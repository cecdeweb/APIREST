package fr.m2i.demoapi.api;

import fr.m2i.demoapi.business.Annuaire;
import fr.m2i.demoapi.business.Personne;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/personnes")
public class AnnuaireApi {

    
    @GET()
    @Produces({ MediaType.APPLICATION_JSON})
    public ArrayList<Personne> getPersonnes(@Context HttpServletRequest request){
        
        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        // request n'existe pas --> récupère dans les paramètre de la method
        if (annuaire == null) {
        annuaire = new Annuaire();
        }
        return annuaire.getPersonnes();
    }
    
    
    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON})
    public Personne getPersonne(@PathParam("id") long personneId, @Context HttpServletRequest request){
        
        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        // request n'existe pas --> récupère dans les paramètre de la method
        if (annuaire == null) {
        annuaire = new Annuaire();
        }
                
        Optional<Personne> p = annuaire.getPersonne(personneId);
        if(p.isPresent()){
            return p.get();
        }
        
        return new Personne();
    }
    
    
    @Path("/{id}")
    @PUT()
    @Consumes ({ MediaType.APPLICATION_JSON})
    public void putPersonne(Personne personne, @Context HttpServletRequest request){

        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
        annuaire = new Annuaire();
        }
        annuaire.updatePersonne(personne);
        request.getSession().setAttribute("annuaire", annuaire);
        
        
    }    
    
    @Path("/{id}")
    @DELETE()
    public void deletePersonne(@PathParam("id") long personneId,  @Context HttpServletRequest request){

        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
        annuaire = new Annuaire();
        }
        annuaire.deletePersonne(personneId);
        request.getSession().setAttribute("annuaire", annuaire);
                
    }    


    
    @POST()
    @Consumes ({ MediaType.APPLICATION_JSON})
    @Produces ({ MediaType.APPLICATION_JSON})
    public Personne postPersonne(Personne newPersonne, @Context HttpServletRequest request){

        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
        annuaire = new Annuaire();
        }
        Personne personne = annuaire.addPersonne(newPersonne);
        request.getSession().setAttribute("annuaire", annuaire);
        return personne;
    }
    
    
}
