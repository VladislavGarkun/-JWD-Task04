package by.tc.task04.socket;

import by.tc.task04.entity.Text;

public interface ISocket {
    void establishConnection();

    void sendText(Text text);
    void sendInt(int number);

    void acceptText();
    int acceptInt();

    void closeConnection();
}
