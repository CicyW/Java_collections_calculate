package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(item->3*item).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.array.stream().map(item->letters[item-1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return this.array.stream().map(item->getLettersOfTwentySix(item,"")).collect(Collectors.toList());
    }
    public String getLettersOfTwentySix(Integer digit,String letter){
        if(digit/26<26){
            if (digit/26==0)
                return letters[digit%26-1]+letter;
            else{
                if(digit%26==0)
                    return letters[digit/26-2]+letters[26-1]+letter;
                else
                    return letters[digit/26-1]+letters[digit%26-1]+letter;
            }

        } else{
            return getLettersOfTwentySix(digit = digit/26,letter+letters[digit%26-1]);
        }
    }
    public List<Integer> sortFromBig() {
        Collections.sort(this.array);
        Collections.reverse(this.array);
        return this.array;
    }

    public List<Integer> sortFromSmall() {

        Collections.sort(this.array);
        return this.array;
    }
}
