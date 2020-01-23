package main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This question asked me during the screening interview at Beacon 21.01.2020
 *
 * _Question_ There two lists of words, write a function returns repeated words at same times:
 *
 * ```Given:
 * ['word','this','another','word','this','this']
 *
 * ['word','word','another','this']
 *
 * Return
 * ['word','another']
 * ```
 *
 * 'this' did not returned because it appears 3 times on the first list and only 1 time on the second.
 */
public class RepeatedWords {
    public static void main(String[] args) {
        String[] str1 = {"word", "this", "another", "word", "this", "this"};
        String[] str2 = {"word", "this", "another", "word"};
        System.out.println(repeatedWords(str1, str2));
    }

    static Collection<String> repeatedWords(String[] str1, String[] str2){
        HashMap<String, Integer> words = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (String s : str1) {
            words.merge(s, 1, Integer::sum);
        }
        for (String s : str2) {
            words.merge(s,1,(a,b)->a-b);
        }
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == 0){
                result.add(entry.getKey());
            }
        }
        return result;
    }

}
