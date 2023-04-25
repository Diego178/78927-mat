package com.equipo3.proyecto1.reservaciones;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_proyecto1_equipo3_com.reservaciones.BuscarRequest;
import https.t4is_proyecto1_equipo3_com.reservaciones.BuscarResponse;
import https.t4is_proyecto1_equipo3_com.reservaciones.CambiarEstadoRequest;
import https.t4is_proyecto1_equipo3_com.reservaciones.CambiarEstadoResponse;
import https.t4is_proyecto1_equipo3_com.reservaciones.EditarRequest;
import https.t4is_proyecto1_equipo3_com.reservaciones.EditarResponse;
import https.t4is_proyecto1_equipo3_com.reservaciones.EliminarRequest;
import https.t4is_proyecto1_equipo3_com.reservaciones.EliminarResponse;
import https.t4is_proyecto1_equipo3_com.reservaciones.ListarResponse;
import https.t4is_proyecto1_equipo3_com.reservaciones.ReservacionRequest;
import https.t4is_proyecto1_equipo3_com.reservaciones.ReservacionResponse;

@Endpoint
public class EndPoint {
    @Autowired
    private IReservacion iReservacion;

    @PayloadRoot(localPart = "ReservacionRequest", namespace = "https://t4is.proyecto1.equipo3.com/reservaciones")
    @ResponsePayload
    public ReservacionResponse Saludar(@RequestPayload ReservacionRequest peticion) {
        ReservacionResponse i = new ReservacionResponse();
        // persistencia a la base de datos
        Reservacion reservacion = new Reservacion();
        reservacion.setTipo(peticion.getTipo());
        reservacion.setHorario(peticion.getHorario());
        reservacion.setFecha(peticion.getFecha());
        reservacion.setNomUsuario(peticion.getNomUsuario());
        reservacion.setEstado(true);
        reservacion.setIdSalon(peticion.getIdSalon());
        iReservacion.save(reservacion);
        i.setRespuesta("Se agrego correctamente, su id es: " + iReservacion.count());
        return i;
    }

    @PayloadRoot(localPart = "BuscarRequest", namespace = "https://t4is.proyecto1.equipo3.com/reservaciones")
    @ResponsePayload
    public BuscarResponse Buscar(@RequestPayload BuscarRequest peticion) {
        BuscarResponse i = new BuscarResponse();

        Optional<Reservacion> str = iReservacion.findById(peticion.getId());
        if (str.isPresent()) {
            Reservacion reservacion = iReservacion.findById(peticion.getId()).get();
            i.setRespuesta("ID de reservacion: " + reservacion.getId());
            i.setRespuesta(reservacion.toString());
            return i;
        } else {
            i.setRespuesta("ID no encontrado");
            return i;
        }

    }

    @PayloadRoot(localPart = "EditarRequest", namespace = "https://t4is.proyecto1.equipo3.com/reservaciones")
    @ResponsePayload
    public EditarResponse Editar(@RequestPayload EditarRequest peticion) {
        EditarResponse i = new EditarResponse();
        Optional<Reservacion> str = iReservacion.findById(peticion.getId());

        if (str.isPresent()) {
            Reservacion reservacion = iReservacion.findById(peticion.getId()).get();

            if (!peticion.getHorario().equals("[string]"))
                reservacion.setHorario(peticion.getHorario());

            if (!peticion.getFecha().equals("[string]"))
                reservacion.setFecha(peticion.getFecha());

            if (!peticion.getNomUsuario().equals("[string]"))
                reservacion.setNomUsuario(peticion.getNomUsuario());

            if (!peticion.getTipo().equals("[string]"))
                reservacion.setTipo(peticion.getTipo());

            if (!peticion.getIdSalon().equals("[string]"))
                reservacion.setIdSalon(peticion.getIdSalon());

            iReservacion.save(reservacion);
            i.setRespuesta(reservacion.toString());
            return i;
        } else {
            i.setRespuesta("ID no encontrado");
            return i;
        }
    }

    @PayloadRoot(localPart = "EliminarRequest", namespace = "https://t4is.proyecto1.equipo3.com/reservaciones")
    @ResponsePayload
    public EliminarResponse Eliminar(@RequestPayload EliminarRequest peticion) {
        EliminarResponse i = new EliminarResponse();
        Optional<Reservacion> str = iReservacion.findById(peticion.getId());

        if (str.isPresent()) {
            iReservacion.deleteById(peticion.getId());
            i.setRespuesta("Se elimino correctamente");
            return i;
        } else {
            i.setRespuesta("ID no encontrado");
            return i;
        }
    }

    @PayloadRoot(localPart = "ListarRequest", namespace = "https://t4is.proyecto1.equipo3.com/reservaciones")
    @ResponsePayload
    public ListarResponse Listar() {
        ListarResponse i = new ListarResponse();
        Iterable<Reservacion> lista = iReservacion.findAll();
        String msj = "";
        for (Reservacion s : lista) {
            msj += s.toString() + "\n";
        }
        i.setRespuesta(msj);
        return i;
    }

    @PayloadRoot(localPart = "CambiarEstadoRequest", namespace = "https://t4is.proyecto1.equipo3.com/reservaciones")
    @ResponsePayload
    public CambiarEstadoResponse CambiarEstado(@RequestPayload CambiarEstadoRequest peticion) {
        CambiarEstadoResponse i = new CambiarEstadoResponse();
        Optional<Reservacion> str = iReservacion.findById(peticion.getId());

        if (str.isPresent()) {
            Reservacion reservacion = iReservacion.findById(peticion.getId()).get();
            reservacion.setEstado(!reservacion.getEstado());
            i.setRespuesta("El estado cambio a: " + reservacion.getEstado());
            iReservacion.save(reservacion);
            return i;
        } else {
            i.setRespuesta("ID no encontrado");
            return i;
        }
    }

}
