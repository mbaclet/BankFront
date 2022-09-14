package fr.m2i.bankfrontspring.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Long id;

    private String title;

    private Long montant;

    private Boolean reccuring;

    private Compte compte;

}