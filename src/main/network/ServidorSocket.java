package main.server;

import model.Cliente;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    public static void main(String[] args){
        
        int port = 12345;
        System.out.println("Iniciando o servidor na porta " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());

                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                Cliente cliente = (Cliente) entrada.readObject();

                salvarCliente(cliente);

                System.out.println(
                    "Dados do cliente recebidos: " +
                    "Nome: " + cliente.getNome() +
                    ", Email: " + cliente.getEmail()
                );
                entrada.close();
                socket.close();
            }

        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }

    private static void salvarCliente(Cliente cliente) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt", true));
        writer.write(cliente.getNome() + "," + cliente.getEmail());
        writer.newLine();
        writer.close();
    }
}
