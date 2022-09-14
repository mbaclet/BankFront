package fr.m2i.bankfrontspring.services;

import fr.m2i.bankfrontspring.models.Compte;
import fr.m2i.bankfrontspring.repositories.CompteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {

    @Autowired
    CompteProxy cp;

    public Iterable<Compte> getComptes() {
        return cp.getComptes();
    }

    public Compte getCompteById(Long id) {
        return cp.getCompteById(id);
    }

    public Compte saveCompte(Compte compte) {
        return cp.saveCompte(compte);
    }

    public void deleteCompte(Compte compte) {
        cp.deleteComtpe(compte);
    }
}
