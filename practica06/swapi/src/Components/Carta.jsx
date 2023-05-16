import React, { useState} from 'react'
import { Card, Button } from 'react-bootstrap'
import { Modal } from 'react-bootstrap'

function Carta(props) {
  const [open, setOpen] = useState(false);
  

  const handleModal = () => {
    setOpen(!open);
  }
  return (
    <>
    <Card style={{ width: '18rem' }}>
      <Card.Body>
        <Card.Title>
            {props.person.name}
        </Card.Title>
        <Card.Text>
          Genero: {props.person.gender} <br/>
          Anio de nacimiento: {props.person.birth_year} <br/>
          Color de cabello: {props.person.hair_color} <br/>
          Altura: {props.person.height} <br/>
          Masa: {props.person.mass} <br/> 
          Color de piel: {props.person.skin_color}
          {/* Films: {props.person.films} */}
          

          {/* {props.person.films.map(film => (
            {film}
            // <Pelicula key={film} pelicula={film}></Pelicula>
          ))} */}
        </Card.Text>
        <Button onClick={handleModal} variant="primary">Peliculas</Button>
      </Card.Body>
    </Card>

    <Modal show={open}>
        <Modal.Title>
            Informacion de {props.person.name}
        </Modal.Title>
        <Modal.Body>
          Peliculas: 
          {props.person.films.map(film => (
            <><br/>{film}</>
          ))}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleModal}>
            Close
          </Button>
        </Modal.Footer>
    </Modal>
    
      
      {/* // {props.person.height}
      // {props.person.birth_year}

      // <button onClick={event => { */}
      {/* //         handleFilms(event);
      //       }}>peliculas</button> */}

      </>


      // {props.person.films}
      // {props.person.name}
      // {props.person.name}
      // {props.person.name}
    
  )
}

export default Carta