package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class DeleteSubStrings {
    private static final char START_SYMBOL = 'с';
    private static final char END_SYMBOL = 'а';

    public static Text deleteSubStrings(ArrayList<Sentence> sentences){
        int length = 0;
        TextParser textParser = new TextParser();

        for(int i = 0; i < sentences.size(); ++i){
            int startIndex = sentences.get(i).getContent().indexOf(START_SYMBOL);
            int endIndex = sentences.get(i).getContent().lastIndexOf(END_SYMBOL) + 1;

            if(startIndex >= 0 && endIndex > startIndex) {
                String substring = sentences.get(i).getContent().substring(startIndex, endIndex);

                sentences.set(i, new Sentence(sentences.get(i).getContent().replace(substring, "")));
            }
        }
        return new Text(sentences);
    }
}
