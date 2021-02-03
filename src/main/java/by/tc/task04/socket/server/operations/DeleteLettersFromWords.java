package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class DeleteLettersFromWords {
    public static Text deleteLetterFromWords(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        for(int i = 0; i < sentences.size(); i++){
            ArrayList<String> wordsFromSentence=textParser.parseSentenceToWords(sentences.get(i));
            for(int j = 0; j < wordsFromSentence.size(); j++){
                for(int k = 1; k < wordsFromSentence.get(j).length(); k++){
                    if(wordsFromSentence.get(j).charAt(0)==wordsFromSentence.get(j).charAt(k)){
                        StringBuilder stringBuilder = new StringBuilder(wordsFromSentence.get(j));
                        stringBuilder.deleteCharAt(k);
                        wordsFromSentence.set(j,stringBuilder.toString());
                    }
                }
            }
            sentences.set(i,textParser.getSentenceFromWords(wordsFromSentence));
        }

        return new Text(sentences);
    }
}
