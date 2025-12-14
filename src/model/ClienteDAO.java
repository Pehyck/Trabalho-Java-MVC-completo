package model;

public class ClienteDAO {

    public void DadosCliente(Cliente cliente) {
        System.out.println("Dados do cliente:" + 
        "Nome: " + cliente.getNome() + 
        "Email: " + cliente.getEmail());
    }

}


