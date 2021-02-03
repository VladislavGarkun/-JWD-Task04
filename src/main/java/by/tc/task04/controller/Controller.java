package by.tc.task04.controller;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.operations.Swap;
import by.tc.task04.socket.server.parse.FileParser;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

import static by.tc.task04.socket.server.operations.ChangeWordsToSubString.changeWordsToSubString;
import static by.tc.task04.socket.server.operations.DeleteLettersFromWords.deleteLetterFromWords;
import static by.tc.task04.socket.server.operations.DeleteSubStrings.deleteSubStrings;
import static by.tc.task04.socket.server.operations.DeleteWordsByLength.deleteWordsByLength;
import static by.tc.task04.socket.server.operations.FindPalindrome.getLongestPalindrome;
import static by.tc.task04.socket.server.operations.SentencesByWordsCount.getSentencesBywordsCount;
import static by.tc.task04.socket.server.operations.SentencesWithRepetitiveWords.getSentencesWithRepetitiveWords;
import static by.tc.task04.socket.server.operations.SortByFirstLetter.sortByFirstLetter;
import static by.tc.task04.socket.server.operations.SortByVowelRatio.sortByVowelRatio;
import static by.tc.task04.socket.server.operations.Swap.swapWords;
import static by.tc.task04.socket.server.operations.UniqueWord.getUniqueWords;
import static by.tc.task04.socket.server.operations.WordsFromQuestions.getWordsFromQuestions;

public class Controller {
    public Text chooseOperation(int value){
        FileParser fileParser = new FileParser();
        Text text = fileParser.parseFileToText();

        TextParser textParser = new TextParser();
        ArrayList<Sentence> allSentencesFromText = textParser.parseTextToSentences(text);

        Text resultText = null;

        switch(value){
            case 1:
                resultText = getSentencesWithRepetitiveWords(allSentencesFromText);

                break;
            case 2:
                resultText = getSentencesBywordsCount(allSentencesFromText);

                break;
            case 3:
                resultText = getUniqueWords(allSentencesFromText);

                break;
            case 4:
                resultText = getWordsFromQuestions(allSentencesFromText);

                break;
            case 5:
                resultText = swapWords(allSentencesFromText);

                break;
            case 6:
                resultText = sortByFirstLetter(allSentencesFromText);

                break;
            case 7:
                resultText = sortByVowelRatio(allSentencesFromText);

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:
                resultText = deleteSubStrings(allSentencesFromText);

                break;
            case 12:
                resultText = deleteWordsByLength(allSentencesFromText);

                break;
            case 13:

                break;
            case 14:
                resultText = getLongestPalindrome(allSentencesFromText);

                break;
            case 15:
                resultText = deleteLetterFromWords(allSentencesFromText);

                break;
            case 16:
                resultText = changeWordsToSubString(allSentencesFromText);

                break;

        }

        return resultText;
    }
}
