package org.acme.rest.json.resources;

import org.acme.rest.json.entities.Fruit;
import org.acme.rest.json.service.ServiceFruit;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.Set;

public class ResourceFruit {

    @Inject
    ServiceFruit service;

    public ResourceFruit() {
        // CDI
    }

    /**
     * Los metodos hello() y list()
     * negocian con el content-type del header
     * de la peticion http
     * hello -> content-type text
     * list() -> content application/json
     */

    @Path("/helloworld")
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    // curl -w "\n" http://localhost:8080/fruits/helloworld
    // -H "Content-Type: application/x-www-form-urlencoded"
    // El "Content-Type: application/x-www-form-urlencoded" indica que es TEXT_PLAIN
    public String hello() {
        return "Hello World";


    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // no es necesario Produces ya que por defecto
    // resteasy jackson desactiva la negociación
    // y sirve MediaType.APPLICATION_JSON
    // curl -w "\n" http://localhost:8080/fruits/ -H "Content-Type: application/json"
    public Set<Fruit> list() {
        return service.list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    // curl -d '{"name":"Banana", "description":"Brings a Gorilla too"}'
    // -H "Content-Type: application/json" -X POST http://localhost:8080/fruits
    public Set<Fruit> add(@Valid Fruit fruit) {
        service.add(fruit);
        return this.list();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    // curl -d '{"name":"Banana", "description":"Brings a Gorilla too"}'
    // -H "Content-Type: application/json" -X DELETE http://localhost:8080/fruits
    public Set<Fruit> delete(@Valid Fruit fruit) {
        service.remove(fruit.getName());
        return list();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    // curl -w "\n" http://localhost:8080/fruits/Apple -v
    // curl -w "\n" http://localhost:8080/fruits/jkl -v
    public Response get(@PathParam("name") String name) {
        Optional<Fruit> fruit = service.getFruit(name);
        return fruit.isPresent()?
                Response.status(Response.Status.OK).entity(fruit.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }


}
