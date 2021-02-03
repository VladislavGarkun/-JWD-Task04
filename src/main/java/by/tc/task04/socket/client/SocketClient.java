package by.tc.task04.socket.client;

import by.tc.task04.entity.Text;
import by.tc.task04.socket.ISocket;
import by.tc.task04.socket.client.print.TextPrinter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class SocketClient implements ISocket {
    private Socket socket;

    @Override
    public void establishConnection() {
        try {
            socket = new Socket("127.0.0.1", 8030);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendText(Text text) {

    }

    @Override
    public void sendInt(int number){
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(number);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void acceptText() {
        ObjectInputStream objectInputStream = null;
        Text text = null;

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            text = (Text)objectInputStream.readObject();

            TextPrinter textPrinter = new TextPrinter(text);
            textPrinter.print();

            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int acceptInt() {
        return 0;
    }

    @Override
    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputMenu(){
        System.out.println("Выберете операции");
        System.out.println("1)Найти наибольшее количество предложений текста, в которых есть одинаковые слова.");
        System.out.println("2)Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.");
        System.out.println("3.Найти такое слово в первом предложении, которого нет ни в предложений. одном из остальных.");
        System.out.println("4.Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины.");
        System.out.println("5.Вкаждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.");
        System.out.println("6.Напечатать слова текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.");
        System.out.println("7.Рассортировать слова текста по возрастанию доли гласных гласных к общему количеству букв в слове).");
        System.out.println("8.Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.");
        System.out.println("9.Все слова текста рассортировать по возрастанию количества заданной буквы в слове. Слова с одинаковым количеством букв расположить в алфавитном порядке.");
        System.out.println("10.Существует текст и список слов. Для каждого слова из заданного списка найти, сколько раз оно встречается в каждом предложении, и рассортировать слова по убыванию общего количества вхождений.");
        System.out.println("11.В каждом предложении текста исключить подстроку максимальной длины, начинающуюся и заканчивающуюся заданными символами.");
        System.out.println("12.Из текста удалить все слова заданной длины, начинающиеся на согласную букву.");
        System.out.println("13.Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.");
        System.out.println("14.В заданном тексте найти подстроку максимальной длины, являющуюся палиндромом, т.е. читающуюся слева направо и справа налево одинаково.");
        System.out.println("15.Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие) вхождения первой (последней) буквы этого слова.");
        System.out.println("16.В некотором предложении текста слова заданной длины заменить подстрокой, длина которой может не совпадать с длиной слова. указанной.");
        System.out.println("0.Выйти из программы.");
    }

    public int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        do {
            number = scanner.nextInt();
        }while (number < 0 || number > 16);

        scanner.close();

        return number;
    }
}