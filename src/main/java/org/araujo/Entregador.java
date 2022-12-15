package org.araujo;

import java.util.Observable;
import java.util.Observer;

public class Entregador implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Entregador(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void vincular(Empresa empresa) {
        empresa.addObserver(this);
    }

    public void update(Observable empresa, Object arg1) {
        this.ultimaNotificacao = this.nome + ", nova solicitação " + empresa.toString();
    }
}
