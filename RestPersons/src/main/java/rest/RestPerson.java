package rest;

import entity.Persons;
import etc.JSONConverter;
import facade.FacadePerson;
import facade.IPersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("person")
public class RestPerson {

    @Context
    private UriInfo context;

    IPersonFacade ipf = new FacadePerson();

    public RestPerson() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson() {
        return "hello";
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id) {

        Persons p = ipf.getPerson(id);
        String js = JSONConverter.getJSONFromPerson(p);
        return js;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
