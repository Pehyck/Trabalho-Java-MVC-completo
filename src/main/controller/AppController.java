package main.controller;

import main.network.ClienteSocket;
import javax.swing.JOptionPane;
import main.network.ServidorSocket;

public class AppController {
    
    //Método para iniciar a aplicação chamado pelo MainApp 
    public void start() {
        String[] opcoes = {
                "Iniciar Servidor",
                "Iniciar Cliente",
                "Sair"
            };

            int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha o modo do sistema:",
                "Aplicação Cliente-Servidor",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    iniciarServidor();
                    break;
                case 1:
                    iniciarCliente();
                    break;
                default:
                    encerrarAplicacao();
                    break;
            }
        }


        //Métodos para controle (privados):
        private void iniciarServidor(){
            ServidorSocket servidor = new ServidorSocket();
            servidor.iniciar();
        }
        
        private void iniciarCliente(){
            ClienteSocket cliente = new ClienteSocket();
            cliente.iniciar();
        }
        
        private void encerrarAplicacao(){
            JOptionPane.showMessageDialog(
                null,
                "Encerrando a aplicação.",
                "Saída",
                JOptionPane.INFORMATION_MESSAGE
            );
            System.exit(0);
        }
}
