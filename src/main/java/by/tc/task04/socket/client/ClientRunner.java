package by.tc.task04.socket.client;

import by.tc.task04.socket.ISocket;

public class ClientRunner {
    public static void main(String[] args) {
        ISocket client = new SocketClient();
        client.establishConnection();

        SocketClient socketClient = new SocketClient();
        int opNumber = 0;

        while(true){
            client.acceptText();

            socketClient.outputMenu();
            opNumber = socketClient.inputNumber();

            client.sendInt(opNumber);

            if(opNumber == 0)
                break;
        }

        client.closeConnection();
    }
}
