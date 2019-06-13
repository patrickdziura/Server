/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.android.ws;

import br.android.facade.UsuarioFacade;
import br.android.model.Usuario;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author patri
 */
@Path("ws")
public class WsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WsResource
     */
    public WsResource() {
    }

    /**
     * Retrieves representation of an instance of br.android.ws.WsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of WsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean login(String usuario){
        if(usuario!=null){
            Gson gson = new Gson();
            Usuario user = gson.fromJson(usuario, Usuario.class);
            //fazer a inserção da entrega com endereço e historico
            return UsuarioFacade.login(user);            
        }else{
            return false;
        }
    }
}
