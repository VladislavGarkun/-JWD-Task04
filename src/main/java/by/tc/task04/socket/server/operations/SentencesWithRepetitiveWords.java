package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class SentencesWithRepetitiveWords {
    public static Text getSentencesWithRepetitiveWords(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<Sentence> sentencesWithRepetitiveWords = new ArrayList<Sentence>();
        for(Sentence sentence: sentences) {
            ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentence);
            for(int i = 0; i < wordsFromSentence.size(); ++i) {
                for(int j = i + 1; j < wordsFromSentence.size(); ++j) {
                    if(wordsFromSentence.get(i).equals(wordsFromSentence.get(j))) {
                        if(!sentencesWithRepetitiveWords.contains(sentence))
                            sentencesWithRepetitiveWords.add(sentence);
                    }
                }
            }
        }

        return new Text(sentencesWithRepetitiveWords);
    }
}
