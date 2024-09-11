/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.edu.umg.wsumg1;

import com.edu.umg.conversortest.Base64Utils;
import java.util.Base64;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author caste
 */
//holaaaa
@Path("WSUMG")
public class GenericResource {

    @Context
    private UriInfo context;
    
    public GenericResource() {
    }
    
     @GET
    @Path("/pruebaUMG")
    @Produces(MediaType.TEXT_PLAIN)
    public String pruebaUMG() throws Exception {
        // Crear un objeto JSON
        JSONObject json = new JSONObject();
        json.put("Nombre", "Juan");
        json.put("Apellido", "Castellanos");

        // Convertir el JSON a String
        String jsonString = json.toJSONString();
        System.out.println("JSON original: " + jsonString);

        // Codificar el JSON a Base64 usando tu clase Base64Utils
        String base64Encoded = Base64Utils.codificarJSON(json);
        System.out.println("JSON codificado en Base64: " + base64Encoded);

        // Decodificar el Base64 para obtener el JSON original usando Base64Utils
        String jsonDecoded = "";
     
            JSONObject jsonObjectDecodificado = Base64Utils.decodificarBase64(base64Encoded);
            jsonDecoded = jsonObjectDecodificado.toJSONString();
            System.out.println("JSON decodificado: " + jsonDecoded);

        // Retornar todo en la respuesta (JSON original, Base64, JSON decodificado)
        StringBuilder result = new StringBuilder();
        result.append("JSON original: ").append(jsonString).append("\n");
        result.append("JSON codificado en Base64: ").append(base64Encoded).append("\n");
        result.append("JSON decodificado: ").append(jsonDecoded).append("\n");

        return result.toString(); // Retornar el resultado completo
    }
    //localhost:8080/WSUMG1/webresources/WSUMG/pruebaUMG


    
//localhost:8080/WSUMG1/webresources/WSUMG/decodificar?base64=eyJOb21icmUiOiJKdWFuIiwiQXBlbGxpZG8iOiJDYXN0ZWxsYW5vcyJ9
}
