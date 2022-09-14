package fr.m2i.bankfrontspring.repositories;

import fr.m2i.bankfrontspring.models.Compte;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CompteProxy {

    @Value("${apiUrl}")
    private String url;


    public Iterable<Compte> getComptes() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<Compte>> response = restTemplate.exchange(
                url + "/comptes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Compte>>() {
                }
        );

        return response.getBody();

    }


    public Compte getCompteById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Compte> response = restTemplate.exchange(
                url + "/comptes/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference <Compte>() {
                }
        );
        return response.getBody();
    }



    public Compte saveCompte(Compte compte) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Compte> todoHttpEntity = new HttpEntity<Compte>(compte);

        ResponseEntity<Compte> response = restTemplate.exchange(
                url + "/comptes/save",
                HttpMethod.POST,
                todoHttpEntity,
                Compte.class
        );

        return response.getBody();
    }


    public void deleteComtpe(Compte compte) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Compte> todoHttpEntity = new HttpEntity<Compte>(compte);

        ResponseEntity<Compte> response = restTemplate.exchange(
                url + "/comptes/delete",
                HttpMethod.DELETE,
                todoHttpEntity,
                Compte.class
        );

        response.getBody();
    }
}
