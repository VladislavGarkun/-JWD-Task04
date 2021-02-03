package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.ArrayList;

public class FindPalindrome {
    public static Text getLongestPalindrome(ArrayList<Sentence> sentences){
        int length=0;
        TextParser textParser = new TextParser();
        ArrayList<Sentence> result = new ArrayList<>();
        result.add(new Sentence(""));

        for(Sentence sentence: sentences){
            String sContent= sentence.getContent();
            int j = 0;
            for(int i = 0; i < sContent.length() - 1; ++i, ++j){
                if(i >= sContent.length() - 1 - j)
                    break;

                String toCheck = sContent.substring(i, sContent.length() - 1 - j);
                StringBuffer stringBuffer = new StringBuffer(toCheck);
                String reverse = stringBuffer.reverse().toString();
                if(toCheck.equals(reverse) && toCheck.length() > length){
                    length = toCheck.length();
                    result.set(0, new Sentence("Longest palindrome: " + toCheck));
                }
            }
        }
        if(length == 0)
            result.set(0, new Sentence("No palindromes"));

        return new Text(result);
    }
}
