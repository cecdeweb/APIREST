package fr.m2i.demoapii.business;

import java.util.ArrayList;
import java.util.Optional;

public class Annuaire {
    
    private ArrayList<Personne> personnes = new ArrayList<>();
    private long nextId = 1;
    

    public void addPersonne(Personne newPersonne){
        newPersonne.setId(nextId);
        nextId++;
        personnes.add(newPersonne);
    }
    
    public Optional<Personne> getPersonne(long id){
        for (Personne p : personnes){
            if (p.getId().equals(id)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }
    
    public void updatePersonne(Personne personne){
        for (Personne p : personnes) {
            if (p.getId().equals(personne.getId())){
                personnes.remove(p);
                personnes.add(personne);
    
//       solution 2  moins energivore du remove
//                int index = personnes.indexOf(personne);
//                personnes.set(index, personne);
            }
        }
     }

    public void deletePersonne(Personne personne){
        for (Personne p : personnes) {
            if (p.getId().equals(personne.getId())){
                personnes.remove(p);
            }
        }
     }
        
    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }
    
    public void setPersonnes(ArrayList<Personne> personnes) {
        this.personnes = personnes;
    }

    public long getNextId() {
        return nextId;
    }

    public void setNextId(long nextId) {
        this.nextId = nextId;
    }
    
    
    
    
}
