package fr.m2i.demoapi.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Annuaire {
    
    private ArrayList<Personne> personnes = new ArrayList<>();
    private long nextId = 1;
    

    public Personne addPersonne(Personne newPersonne){
        newPersonne.setId(nextId);
        nextId++;
        personnes.add(newPersonne);
        return newPersonne;
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
        Iterator<Personne> it = personnes.iterator();
        int index = 0;
        while (it.hasNext() && index == 0) {
            Personne p = it .next();
            if (p.getId().equals(personne.getId())){
                index = personnes.indexOf(p);
            }
        }
        personnes.set(index, personne);

//    solution qui fait une erreur 500 car clause de concurrence avec boucle annuaire update        
//        for (Personne p : personnes) {
//            if (p.getId().equals(personne.getId())){
//                personnes.remove(p);
//                personnes.add(personne);


//       solution 2  moins energivore du remove
//                int index = personnes.indexOf(personne);
//                personnes.set(index, personne);
     }

   public void deletePersonne(long id) {
        Iterator<Personne> it = personnes.iterator();
        int index = 0;
        while (it.hasNext() && index == 0) {
            Personne p = it.next();
            if (p.getId().equals(id)) {
                index = personnes.indexOf(p);
            }
        }
        personnes.remove(index);
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
