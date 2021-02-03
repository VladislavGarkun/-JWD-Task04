package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class Swap {
    private static final String SPACES = "\\s+";

    public static Text swapWords(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<Sentence> result = new ArrayList<Sentence>();

        for(Sentence sentence : sentences)
        {
            ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentence);

            if(wordsFromSentence.size() > 1)
            {
                String firstWord = wordsFromSentence.get(0);
                String lastWord = wordsFromSentence.get(wordsFromSentence.size() - 1);

                wordsFromSentence.remove(0);
                wordsFromSentence.remove(wordsFromSentence.size() - 1);
                wordsFromSentence.add(0, lastWord);
                wordsFromSentence.add(wordsFromSentence.size(), firstWord);
            }
            result.add(textParser.getSentenceFromWords(wordsFromSentence));
        }

        return new Text(result);
    }
}
