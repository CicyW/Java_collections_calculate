package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {

        this.array = array;
    }

    public List<Integer> filterEven() {
        return this.array.stream().filter(item ->item%2==0).collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return this.array.stream().filter(item ->item%3==0).collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> firstArrayList = new ArrayList<Integer>(firstList);
        List<Integer> secondArrayList = new ArrayList<Integer>(secondList);
        firstArrayList.retainAll(secondArrayList);
        return firstArrayList;
    }

    public List<Integer> getDifferentElements() {
        return this.array.stream().distinct().collect(Collectors.toList());
    }
}