package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class WordsFromQuestions {
    private static final String QUESTION_MARK = "?";
    private static final String SPACE = " ";
    private static final int wordLength = 5;

    public static Text getWordsFromQuestions(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<String> resultWords = new ArrayList<String>();
        ArrayList<Sentence> questionSentences = new ArrayList<Sentence>();

        for(Sentence sentence : sentences) {
            if(sentence.toString().contains(QUESTION_MARK))
                questionSentences.add(sentence);
        }

        for(Sentence sentence : questionSentences) {
            ArrayList<String> wordsFromSentence = textParser.parseSentenceToWords(sentence);

            for(String word : wordsFromSentence) {
                if(word.length() == wordLength && !resultWords.contains(word))
                    resultWords.add(word);
            }
        }

        StringBuilder allResultWords = new StringBuilder();

        for(String word : resultWords) {
            allResultWords.append(word);
            allResultWords.append(SPACE);
        }

        return new Text(allResultWords.toString());
    }
}
