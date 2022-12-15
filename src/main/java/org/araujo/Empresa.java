package org.araujo;

import java.util.Observable;

public class Empresa extends Observable {

    private String nome;
    private Endereco endereco;

    public Empresa(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void chamarEntregadores() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                "endereco=" + endereco +
                '}';
    }
}
