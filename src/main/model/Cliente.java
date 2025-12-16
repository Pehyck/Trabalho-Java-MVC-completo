package main.model;

import java.io.Serializable;

public class Cliente implements Serializable {

    /*  Evita problemas durante o processo de serialização e desserialização,
        garantindo que a versão da classe seja compatível.*/
    private static final long serialVersionUID = 1L; // Para controle de versão da classe serializável 

    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}