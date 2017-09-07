/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etc;

import com.google.gson.Gson;
import entity.Persons;
import java.util.List;

/**
 *
 * @author vfgya_000
 */
public class JSONConverter {

    public static Persons getPersonFromJson(String js) {
        Persons p = new Gson().fromJson(js, Persons.class);
        return p;
    }

    public static String getJSONFromPerson(Persons p) {
        String json = new Gson().toJson(p);
        return json;
    }

    public static String getJSONFromPerson(List<Persons> persons) {
        String json = new Gson().toJson(persons);
        return json;
    }
}
