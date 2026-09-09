package com.example.tp;

public class Poisson extends Animal {
    private String typeEau;

    public Poisson(String nom, int age, String typeEau) {
        super(nom, age);
        this.typeEau = typeEau;
    }

    public void nager() {
        System.out.println(nom + " nage dans l'eau.");
    }

    @Override
    public String toString() {
        return super.toString() +
               " {Poisson, typeEau=" + typeEau + "}";
    }
}
