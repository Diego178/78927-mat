import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Carta from './Carta';

function People() {
    const [people, setPeople] = useState([]);
    

    useEffect(() => {
      axios.get("https://swapi.dev/api/people/")
      .then(function (response){
          setPeople(response.data.results);
          console.log(response.data);
          // console.log(people)
      }).catch(function (error) {
          alert(error);
      });
    }, []);

    


  return (
    <>
      {people.map(person => (
          <Carta key={person.name} person={person}></Carta>
      ))}

      
    </>
  )
}

export default People