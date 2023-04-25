package mx.uv.practica04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BuscarRequest;
import https.t4is_uv_mx.saludos.BuscarResponse;
import https.t4is_uv_mx.saludos.EditarRequest;
import https.t4is_uv_mx.saludos.EditarResponse;
import https.t4is_uv_mx.saludos.EliminarRequest;
import https.t4is_uv_mx.saludos.EliminarResponse;
import https.t4is_uv_mx.saludos.ListarResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;

@Endpoint
public class EndPoint {
    @Autowired
    private ISaludador iSaludador;

    // private List<String> saludos = new ArrayList<>();

    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse i = new SaludarResponse();
        i.setRespuesta("Bienvenido " + peticion.getNombre());
        // persistencia a la base de datos
        Saludador saludador = new Saludador();
        saludador.setNombre(peticion.getNombre());
        iSaludador.save(saludador);
        return i;
    }

    @PayloadRoot(localPart = "BuscarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarResponse Buscar(@RequestPayload BuscarRequest peticion) {
        BuscarResponse i = new BuscarResponse();
        Saludador saludador = iSaludador.findById(peticion.getId()).get();
        i.setRespuesta(saludador.getNombre());
        return i;
    }

    @PayloadRoot(localPart = "EditarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EditarResponse Editar(@RequestPayload EditarRequest peticion) {
        EditarResponse i = new EditarResponse();
        Saludador saludador = new Saludador();
        saludador.setId(peticion.getId());
        saludador.setNombre(peticion.getNombre());
        iSaludador.save(saludador);
        i.setRespuesta("Se actualizo correctamente");
        return i;
    }

    @PayloadRoot(localPart = "EliminarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EliminarResponse Eliminar(@RequestPayload EliminarRequest peticion) {
        EliminarResponse i = new EliminarResponse();
        iSaludador.deleteById(peticion.getId());
        i.setRespuesta("Se elimino correctamente");
        return i;
    }

    @PayloadRoot(localPart = "ListarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ListarResponse Listar() {
        ListarResponse i = new ListarResponse();
        Iterable<Saludador> lista = iSaludador.findAll();
        String msj = "";
        for(Saludador s : lista){
            msj += "ID: "+s.getId()+ ", Nombre: " + s.getNombre() + ", ";
        }
        i.setRespuesta(msj);
        return i;
    }

}
