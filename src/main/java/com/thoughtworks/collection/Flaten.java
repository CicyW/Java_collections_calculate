package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> oneDimesionalArray = new ArrayList<Integer>();
        int[] oneDimesional = Arrays.stream(array).flatMap(x -> Arrays.stream(x)).mapToInt(item->item).toArray();
        for(int i:oneDimesional){
            oneDimesionalArray.add(i);
        }
        return oneDimesionalArray;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> oneDimesionalArray = new ArrayList<Integer>();
        int[] oneDimesional = Arrays.stream(array).flatMap(x -> Arrays.stream(x)).distinct().mapToInt(item->item).toArray();
        for(int i:oneDimesional){
            oneDimesionalArray.add(i);
        }
        return oneDimesionalArray;
    }
}
