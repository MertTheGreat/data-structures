package main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * This question asked me at LeisurePassGroup interview.
 * I was declined because had trouble implementing the Equal method.
 */
public class SumPair {
    public static void main(String[] args) {
        int[] array = {1,3,5,9,-1,6,7,0,8};
        System.out.println(hasPairSum(array, 8));
    }

    static Collection<Pair> hasPairSum(int[] array, int target){
        ArrayList<Pair> pairs = new ArrayList<>();
        ArrayList<Integer> comps = new ArrayList<>();
        for (int i : array) {
            if (comps.contains(target-i)){
                pairs.add(new Pair(i, target-i));
            } else {
                comps.add(i);
            }
        }

        return pairs;
    }
}

class Pair{
    private int num1;
    private int num2;

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "num1=" + num1 +
                ", nem2=" + num2 +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return num1 == pair.num1 && num2 == pair.num2;
    }

    @Override
    public int hashCode(){
        return Objects.hash(num1, num2);
    }
}
