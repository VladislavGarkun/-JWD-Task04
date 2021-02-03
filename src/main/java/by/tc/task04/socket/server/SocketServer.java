package by.tc.task04.socket.server;

import by.tc.task04.entity.Text;
import by.tc.task04.socket.ISocket;
import by.tc.task04.socket.server.parse.FileParser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements ISocket {
    private Socket socket;

    @Override
    public void establishConnection(){
        ServerSocket server = null;
        try {
            server = new ServerSocket(8030);
            socket = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendText(Text text){
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(text);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendInt(int number) {

    }

    @Override
    public void acceptText() {

    }

    @Override
    public int acceptInt() {
        ObjectInputStream objectInputStream = null;
        int number = 0;

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            number = (int)objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return number;
    }

    @Override
    public void closeConnection(){
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Text parseText(){
        FileParser fileParser = new FileParser();
        Text text = fileParser.parseFileToText();

        return text;
    }
}
