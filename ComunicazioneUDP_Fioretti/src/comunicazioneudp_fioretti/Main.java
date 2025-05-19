/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
public class Main {

    public static void main(String[] args) {
        // Avvia il server su un nuovo thread
        Thread serverThread = new Thread(() -> {
            UDPServer.main(null);
        });

        // Avvia il client su un nuovo thread (dopo un piccolo ritardo)
        Thread clientThread = new Thread(() -> {
            try {
                // Aspetta un po' che il server sia avviato
                Thread.sleep(1000);
                UDPClient.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        serverThread.start();
        clientThread.start();
    }
}
