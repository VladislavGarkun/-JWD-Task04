package by.tc.task04.socket.server;

import by.tc.task04.controller.Controller;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.ISocket;

import static by.tc.task04.socket.server.SocketServer.parseText;

public class ServerRunner{
    public static void main(String[] args)
    {
        ISocket server = new SocketServer();
        Controller controller = new Controller();

        server.establishConnection();
        Text text = parseText();
        server.sendText(text);

        int number = 0;
        while(true){
            number = server.acceptInt();
            if(number == 0)
                break;

            Text text2 = controller.chooseOperation(number);
            server.sendText(text2);
        }

        server.closeConnection();
    }
}
