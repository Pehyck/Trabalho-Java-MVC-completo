package main.view;

import model.Cliente;
import javax.swing.*;

public class ClienteView {

    public static Cliente cadastroCliente() {

        String nome = JOptionPane.showInputDialog(null, 
            "Nome: ",
            "Cadastro",
            JOptionPane.QUESTION_MESSAGE
        );
        String email = JOptionPane.showInputDialog(null, 
            "Email: ",
            "Cadastro",
            JOptionPane.QUESTION_MESSAGE
        );

        return new Cliente(nome, email);
    }

    public static void mostrarMensagem(String msg) {
        JOptionPane.showMessageDialog(null, 
            msg,
            "Mensagem do Servidor",
            JOptionPane.INFORMATION_MESSAGE);
    }
}

