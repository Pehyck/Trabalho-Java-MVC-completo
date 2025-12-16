package main.network;

import main.model.Cliente;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSocket {
    public static void main(String[] args){
        try{
            Cliente cliente;
            cliente = ClienteView.cadastroCliente();

            Socket socket = new Socket("localhost", 12345);

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
}
