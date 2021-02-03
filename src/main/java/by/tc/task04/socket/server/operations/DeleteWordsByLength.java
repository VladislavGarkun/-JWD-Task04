package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class DeleteWordsByLength {
    private static final int LENGTH=5;
    private static final String FIRST_LETTER = "^(?ui:[^аеёиоуыэюя]).*";

    public static Text deleteWordsByLength(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<Sentence> newSentences = new ArrayList<Sentence>();

        for(Sentence sentence: sentences){
            ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentence);
            for(int i = 0; i < wordsFromSentence.size(); i++){
                if(wordsFromSentence.get(i).length() == LENGTH && wordsFromSentence.get(i).matches(FIRST_LETTER)){
                    wordsFromSentence.remove(i);
                }
            }
            newSentences.add(textParser.getSentenceFromWords(wordsFromSentence));
        }

        return new Text(newSentences);
    }
}
