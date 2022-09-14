package fr.m2i.bankfrontspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    private Long id;

    private String name;

    private Long solde;

    private Set<Transaction> transactions;

}