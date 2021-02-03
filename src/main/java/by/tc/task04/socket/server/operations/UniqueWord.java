package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class UniqueWord {
    public static Text getUniqueWords(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<String> uniqueWords = new ArrayList<String>();

        Sentence firstSentence = sentences.get(0);
        ArrayList<String> wordsFromFirstSentence = textParser.parseSentenceToWords(firstSentence);

        ArrayList<Sentence> sentencesExceptFirst = new ArrayList<Sentence>();

        for(int i = 1; i < sentences.size(); i++)
            sentencesExceptFirst.add(sentences.get(i));

        for(String word : wordsFromFirstSentence) {
            if(!sentencesExceptFirst.toString().contains(word))
                uniqueWords.add(word);
        }

        return new Text(uniqueWords);
    }
}
