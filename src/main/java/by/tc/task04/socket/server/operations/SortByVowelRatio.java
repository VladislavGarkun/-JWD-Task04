package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.FileParser;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class SortByVowelRatio {
    private static final char[] VOWELS = {'е', 'а', 'о', 'э', 'я', 'и', 'ю', 'у', 'ы', 'ё', 'e', 'u', 'i',
            'o', 'a'};
    private static final String SPACE = " ";

    public static boolean isVowel(char letter)
    {
        for(int i = 0; i < VOWELS.length; i++)
        {
            if(letter == VOWELS[i])
                return true;
        }
        return false;
    }

    private static double vowelRatio(String word)
    {
        double vowelCount = 0.0;
        char[] allLetters = word.toCharArray();

        for(int i = 0; i < allLetters.length; i++)
        {
            if(isVowel(allLetters[i]))
                vowelCount++;
        }

        return vowelCount/word.length();
    }

    public static Text sortByVowelRatio(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<String> allWordsFromText = new ArrayList<String>();
        for(Sentence sentence : sentences)
        {
            allWordsFromText.addAll(textParser.parseSentenceToWords(sentence));
        }

        StringBuilder content = new StringBuilder();
        ArrayList<String> wordsToSort = new ArrayList<String>();
        wordsToSort.addAll(allWordsFromText);

        String[] wordsToSortArr = new String[wordsToSort.size()];

        for(int i = 0; i < wordsToSort.size(); i++)
            wordsToSortArr[i] = wordsToSort.get(i);

        for(int i = 0; i < wordsToSortArr.length; i++)
        {
            for(int j = 1; j < wordsToSortArr.length; j++)
            {
                if(vowelRatio(wordsToSortArr[j - 1]) > vowelRatio(wordsToSortArr[j]))
                {
                    String temp = wordsToSortArr[j- 1];
                    wordsToSortArr[j - 1] = wordsToSortArr[j];
                    wordsToSortArr[j] = temp;
                }
            }
        }

        for(int i = 0; i < wordsToSortArr.length; i++)
        {
            content.append(wordsToSortArr[i] + SPACE);
        }

        return new Text(content.toString());
    }
}
