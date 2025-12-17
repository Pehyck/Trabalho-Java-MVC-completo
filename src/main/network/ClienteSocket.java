package main.network;

import main.model.Cliente;
import main.view.ClienteView;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSocket {

    private static final String HOST = "localhost";
    private static final int PORTA = 12345;

    
    public void iniciar(){
        try{
            Cliente cliente;
            cliente = ClienteView.cadastroCliente();

            Socket socket = new Socket(HOST, PORTA);

            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            
            saida.writeObject(cliente);
            saida.flush();
            saida.close();
            socket.close();

            ClienteView.mostrarMensagem("Dados enviados com sucesso ao servidor.");

        }catch(Exception e){
            ClienteView.mostrarMensagem("Erro ao enviar dados: " + e.getMessage());
        }

    }
    public static void main(String[] args){
        new ClienteSocket().iniciar();
    }
}
