package main.network;

import main.model.Cliente;
import main.model.ClienteDAO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    private static final int PORTA = 12345;
    private static final String ARQUIVO = "clientes.txt";

    public void iniciar(){
        System.out.println("Iniciando o servidor na porta " + PORTA);

        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());

                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                Cliente cliente = (Cliente) entrada.readObject();

                salvarCliente(cliente);

                ClienteDAO dao = new ClienteDAO();
                dao.DadosCliente(cliente);

                entrada.close();
                socket.close();
            }

        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        private static void salvarCliente(Cliente cliente) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true));

        writer.write(cliente.getNome() + "," + cliente.getEmail());
        writer.newLine();
        writer.close();
    }
    public static void main(String[] args){
        new ServidorSocket().iniciar();
    }


}
