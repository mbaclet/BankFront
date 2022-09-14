package fr.m2i.bankfrontspring.repositories;

import fr.m2i.bankfrontspring.models.Compte;
import fr.m2i.bankfrontspring.models.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionProxy {

    @Value("${apiUrl}")
    private String url;






    public Iterable<Transaction> getTransactions() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<Transaction>> response = restTemplate.exchange(
                url + "/transactions/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Transaction>>() {
                }
        );

        return response.getBody();

    }


    public Transaction getTransactionById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Transaction> response = restTemplate.exchange(
                url + "/transactions/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference <Transaction>() {
                }
        );
        return response.getBody();
    }



    public Transaction saveTransaction(Transaction transaction) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Transaction> todoHttpEntity = new HttpEntity<Transaction>(transaction);

        ResponseEntity<Transaction> response = restTemplate.exchange(
                url + "/transactions/save",
                HttpMethod.POST,
                todoHttpEntity,
                Transaction.class
        );

        return response.getBody();
    }


    public void deleteComtpe(Transaction transaction) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Transaction> todoHttpEntity = new HttpEntity<Transaction>(transaction);

        ResponseEntity<Transaction> response = restTemplate.exchange(
                url + "/transactions/delete",
                HttpMethod.DELETE,
                todoHttpEntity,
                Transaction.class
        );

        response.getBody();
    }




}
