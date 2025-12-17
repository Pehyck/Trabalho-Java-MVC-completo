package main.network;

import main.model.Cliente;
import main.view.ClienteView;

import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteSocket {

    private static final String HOST = "localhost";
    private static final int PORTA = 12345;

    
    public static void iniciar(){
        try{
            Cliente cliente;
            cliente = ClienteView.cadastroCliente();

            boolean dadosValidos = false;
            dadosValidos = validarCliente(cliente);

            if(dadosValidos) {
                Socket socket = new Socket(HOST, PORTA);

                ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());

                saida.writeObject(cliente);
                saida.flush();
                saida.close();
                socket.close();

                ClienteView.mostrarMensagem("Dados enviados com sucesso ao servidor.");

            }

        }catch(Exception e){
            ClienteView.mostrarMensagem("Erro ao enviar dados: " + e.getMessage());
        }

    }

    public static void main(String[] args){
        new ClienteSocket().iniciar();
    }

    public static boolean validarCliente(Cliente cliente){
        if(!cliente.getNome().isEmpty() && !cliente.getEmail().isEmpty()){
            if(cliente.getNome() != null && cliente.getEmail() != null){
                if(cliente.getEmail().contains("@email.com" ) || cliente.getEmail().contains("@gmail.com") || cliente.getEmail().contains("@outlook.com") || cliente.getEmail().contains("@yahoo.com")){
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Dados inválidos. Por favor, tente novamente.",
                            "Erro de Validação",
                            JOptionPane.ERROR_MESSAGE
                    );
                    iniciar();
                }
            }
        }
        return false;
    }
}
