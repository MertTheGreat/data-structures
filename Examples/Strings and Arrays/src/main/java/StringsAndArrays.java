package main.java;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This Class is answers for McDowell book Cracking The Coding Interview Chapter 1 Questions.
 */
public class StringsAndArrays {
    public static void main(String[] args) {
//        System.out.println(hasPairSumUnsorted(new int[]{1, 2, 4, 3,7},8));
//        System.out.println(palindromePermutation("cat walks", "tac kalwsee"));
//        System.out.println(isPalindrome(12871));
        System.out.println(oneWay("pale", "bae"));
    }

    public static Boolean isUnique(String str){
        if (str.length()>128){
            return false;
        }

        boolean[] chr_set = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i);
            if(chr_set[ascii]){
                return false;
            }
            chr_set[ascii] = true;
        }
        return true;
    }

    public static boolean checkPermutation(String str1, String str2){
        return sort(str1).equals(sort(str2));
    }

    public static String sort(String str){
        char[] chrs = str.toCharArray();
        java.util.Arrays.sort(chrs);
        return new String(chrs);
    }

    public static boolean checkPermutation2(String str1, String str2){
        int[] letters = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            letters[str2.charAt(i)]--;
            if (letters[str2.charAt(i)] < 0){
                return false;
            }
        }

        return true;
    }

    public static String replaceSpaces(String str){
        char[] chr = str.toCharArray();
        int numSp = numberOfSpaces(chr);
        int newIndex = str.length()-1 + numSp*2;
        char[] newChr = new char[newIndex+1];

        for (int oldIndex = str.length()-1; oldIndex >= 0 ; oldIndex--) {
            if (chr[oldIndex] == ' '){
                newChr[newIndex] = '0';
                newChr[newIndex-1] = '2';
                newChr[newIndex-2] = '%';
                newIndex-=3;
            } else{
            newChr[newIndex] = chr[oldIndex];
            newIndex--;
            }
        }
        return new String(newChr);
    }

    public static int numberOfSpaces(char[] str){
        int numSp = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' '){
                numSp++;
            }
        }
        return numSp;
    }

    static String reverseString(String str){
        if (str == null || str.isEmpty()){
            return null;
        }
        int length = str.length();

        char[] chars = str.toCharArray();
        char[] newCh = new char[str.length()];
        int j = 0;
        for (int i = length-1; i >= 0; i--) {
            newCh[j] = chars[i];
            j++;
        }
        return new String(newCh);
    }

    static String reverseString2(String str){
        if (str == null || str.isEmpty()){
            return null;
        }
        int length = str.length();

        char[] chars = str.toCharArray();

        int i = 0;
        int j = length -1;
        char temp;
        while (i<j){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] =temp;
            i++; j--;
        }
        return new String(chars);
    }

    static boolean hasPairSum(int[] array, int target){
        if (array.length < 2) return false;
        int low = 0;
        int high = array.length-1;

        while (low<high){
            if (array[low] + array[high]==target){
                return true;
            }
            low++;
            high--;
        }
        return false;
    }

    static boolean hasPairSumUnsorted(int[] array, int target){
        ArrayList<Integer> comp = new ArrayList<>();
        for (int i : array) {

        }
        for (int i = 0; i < array.length; i++) {
            if (comp.contains(array[i])){
                return true;
            }
            comp.add(target - array[i]);
        }
        return false;
    }

    static boolean palindromePermutation(String str1, String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        HashMap<Character, Integer> collec = new HashMap<>();
        for (char aChar : chars1) {
            collec.merge(aChar, 1, Integer::sum);
        }
        for (char aChar : chars2) {
            collec.merge(aChar, 1, (oldV,newV)->oldV-newV);
            if (collec.get(aChar)<'0') return false;
        }
        return true;
    }

    static boolean isPalindrome(int number){
        char[] sNmbr = Integer.toString(number).toCharArray();
        int low = 0;
        int high = sNmbr.length -1;
        while (low<high){
            if (sNmbr[low]!=sNmbr[high]){
                return false;
            }
            low++;high--;
        }
        return true;
    }

    static boolean oneWay(String original, String replace){
        int oLength = original.length();
        int rLength = replace.length();
        if (oLength == rLength-1){
            return insertion(original, replace);
        } else if (oLength == rLength){
            return replacement(original, replace);
        } else if (oLength == rLength + 1){
            return removal(original, replace);
        } else {
            return false;
        }
    }

    private static boolean removal(String original, String replace) {
        int count = counter(original, replace);
        return count == 1;
    }

    private static boolean replacement(String original, String replace) {
        int count = counter(original, replace);
        return count == 2;
    }

    private static boolean insertion(String original, String replace) {
        int count = counter(original, replace);
        return count == -1;
    }

    private static int counter(String original, String replace){
        char[] oStr = original.toCharArray();
        char[] rStr = replace.toCharArray();
        int count = 0;
        HashMap<Character, Integer> oCol = new HashMap<Character, Integer>();
        for (char c : oStr) {
            oCol.merge(c, 1, Integer::sum);
        }
        for (char c : rStr) {
            oCol.merge(c, 1, (x,y)->x-y);
        }
        for (Integer value : oCol.values()) count += value;
        return count;
    }

}
