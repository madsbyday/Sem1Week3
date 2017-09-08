package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Persons;
import etc.JSONConverter;
import facade.FacadePerson;
import facade.IPersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id) {

        Persons p = ipf.getPerson(id);
        if (p != null) {
            String js = JSONConverter.getJSONFromPerson(p);
            return js;
        } else {
            return "{\"code\":404, \"message\": \"No person with provided id found\", \"stackTrace\": \"....\"}";
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson() {
        Persons p = ipf.getPerson(1);
        String js = JSONConverter.getJSONFromPerson(p);
        return js;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPerson(String content) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String PersonFirstName = "";
        String PersonLastName = "";
        String PersonPhoneNumber = "";

        if (body.has("firstname")) {
            PersonFirstName = body.get("firstname").getAsString();
        }
        if (body.has("lastname")) {
            PersonLastName = body.get("lastname").getAsString();
        }
        if (body.has("phonenr")) {
            PersonPhoneNumber = body.get("phonenr").getAsString();
        }
        Persons p = new Persons(PersonFirstName, PersonLastName, PersonPhoneNumber);
        ipf.addPerson(p);

        String js = JSONConverter.getJSONFromPerson(p);
        return js;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String editPerson(String content) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        Persons p = ipf.getPerson(body.get("idpersons").getAsInt());

        if (body.has("firstname")) {
            p.setFirstname(body.get("firstname").getAsString());
        }
        if (body.has("lastname")) {
            p.setLastname(body.get("lastname").getAsString());
        }
        if (body.has("phonenr")) {
            p.setPhonenr(body.get("phonenr").getAsString());
        }

        ipf.editPerson(p);

        String js = JSONConverter.getJSONFromPerson(p);
        return js;
    }

    @Path("{id}")
    @DELETE
    public void deletePerson(@PathParam("id") int id) {
        ipf.deletePerson(id);
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Persons> allp = ipf.getPersons();
        String jsonAll = JSONConverter.getJSONFromPerson(allp);
        return jsonAll;
    }

}
