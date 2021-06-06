package org.acme.rest.json.resources;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.acme.rest.json.entities.Student;
import org.acme.rest.json.service.ServiceStudent;

@Path("/students")
public class ResourceStudent {
    
    @Inject
    ServiceStudent service;

    public ResourceStudent() {}

    @GET
    @Path("/all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response allStudents() {
        // ok() method already have a STATUS 200
        return Response.ok(service.setStudents(), MediaType.APPLICATION_JSON).header("message", "All students returned").build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addStudent(@Valid Student student) {
        service.add(student);

        return Response.ok(service.setStudents(), MediaType.APPLICATION_JSON_TYPE).header("message", "The Student was add succesfully!!!").build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteStudent(@Valid Student student) {
        service.remove(student.getName());

        return Response.ok(service.setStudents(), MediaType.APPLICATION_JSON).header("message", "The Student was deleted succesfully!!!").build();
    }

    
    @PUT
    @Path("/put")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateStudent(@Valid Student student) {
        Optional<Student> studentUpdated = service.updateStudent(student);

        return studentUpdated.isPresent() ? Response.status(Response.Status.OK).entity(studentUpdated.get()).build() : Response.status(Response.Status.NOT_FOUND).build();

    }

    @GET
    @Path("/{name}")
    // @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateStudent(@PathParam("name") String name) {
        Optional<Student> student = service.getStudentByName(name);

        return student.isPresent() ? Response.status(Response.Status.OK).entity(student.get()).build() : Response.status(Response.Status.NOT_FOUND).build();

    }


}
