package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class ChangeWordsToSubString {
    private static final int NUMBER_OF_SENTENCE = 2;
    private static final int LENGTH_OF_WORDS_TO_DELETE = 5;
    private static final String SUBSTING = "JWD is top";

    public static Text changeWordsToSubString(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentences.get(NUMBER_OF_SENTENCE - 1));
        for(int i = 0; i < wordsFromSentence.size(); ++i){
            if(wordsFromSentence.get(i).length() == LENGTH_OF_WORDS_TO_DELETE){
                wordsFromSentence.set(i, SUBSTING);
            }
        }
        sentences.set(NUMBER_OF_SENTENCE - 1, textParser.getSentenceFromWords(wordsFromSentence));

        return new Text(sentences);
    }
}
