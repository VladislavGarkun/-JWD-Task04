package by.tc.task04.socket.server.operations;

import by.tc.task04.entity.Sentence;
import by.tc.task04.entity.Text;
import by.tc.task04.socket.server.parse.TextParser;

import java.util.*;

public class SentencesByWordsCount {
    private static HashMap<Sentence, Integer> sortByValue(HashMap<Sentence, Integer> hm) {
        List<Map.Entry<Sentence, Integer> > list = new LinkedList<Map.Entry<Sentence, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Sentence, Integer> >() {
            public int compare(Map.Entry<Sentence, Integer> o1,
                               Map.Entry<Sentence, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Sentence, Integer> temp = new LinkedHashMap<Sentence, Integer>();

        for (Map.Entry<Sentence, Integer> aa : list){
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static Text getSentencesBywordsCount(ArrayList<Sentence> sentences){
        TextParser textParser = new TextParser();

        ArrayList<Sentence> sentencesSortedBySize= new ArrayList<Sentence>();
        HashMap<Sentence, Integer> sentencesAndSizesMap = new HashMap<Sentence, Integer>();


        for(Sentence sentence : sentences)
            sentencesAndSizesMap.put(sentence, textParser.parseSentenceToWords(sentence).size());

        sentencesAndSizesMap = sortByValue(sentencesAndSizesMap);

        for(Sentence sentence : sentencesAndSizesMap.keySet())
            sentencesSortedBySize.add(sentence);

        return new Text(sentencesSortedBySize);
    }
}
