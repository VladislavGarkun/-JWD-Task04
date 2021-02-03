package by.tc.task04.socket.server.parse;

import by.tc.task04.entity.Text;

import java.io.*;

public class FileParser {
    private File file;

    private static final String PATH = "src\\main\\resources\\Java.txt";

    public FileParser() {
        file = new File(PATH);
    }

    public Text parseFileToText() {
        StringBuilder textContent = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String lineToRead = null;
            while((lineToRead = reader.readLine()) != null) {
                textContent.append(lineToRead);
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Text text = new Text(textContent.toString());

        return text;
    }
}