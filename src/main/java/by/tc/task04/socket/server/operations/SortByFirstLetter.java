package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;
import java.util.Collections;

public class SortByFirstLetter {
    private static final String SPACE = " ";

    public static Text sortByFirstLetter(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<String> allWordsFromText = new ArrayList<String>();
        for(Sentence sentence : sentences) {
            allWordsFromText.addAll(textParser.parseSentenceToWords(sentence));
        }

        ArrayList<String> wordsToSort = new ArrayList<String>();
        wordsToSort.addAll(allWordsFromText);

        Collections.sort(wordsToSort);

        StringBuilder content = new StringBuilder();
        for(int i = 0; i < wordsToSort.size(); i++) {
            if( i != 0 && wordsToSort.get(i).charAt(0) != wordsToSort.get(i - 1).charAt(0))
                content.append("\n\t");

            content.append(wordsToSort.get(i) + SPACE);
        }

        return new Text(content.toString());
    }
}
