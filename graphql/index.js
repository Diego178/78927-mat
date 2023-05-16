import {gql, ApolloServer} from 'apollo-server' 
import axios from 'axios';

let libros = '';

axios.get('http://127.0.0.1:8000/biblioteca/libros/todos/')
.then((response) => {
   libros = response.data
}).catch((e) => {
  console.log(e);
})


const definicionTipos = gql`
    type Libro {
        titulo: String!
        descripcion: String!
        precio: Float!
        cantidad: Int!
        categoria: String!
        autor: String!
        editorial: String!
    }

    type Query {
        numLibros: Int!
        todosLibros: [Libro]!
    }
`

const resolvers = {
    Query: {
        numLibros: () => libros.length,
        todosLibros: () => libros
    }
}

const server = new ApolloServer({
    typeDefs: definicionTipos,
    resolvers
})

server.listen().then(({url}) => {
    console.log(`Servidor listo en: ${url}`);
})