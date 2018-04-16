package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {

    public List<Integer> getListByInterval(int left, int right) {
        if (left <= right)
            return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
        else {
            List<Integer> list = IntStream.rangeClosed(right, left).boxed().collect(Collectors.toList());
            Collections.reverse(list);
            return list;
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left <= right)
            return IntStream.rangeClosed(left, right).filter(integer -> integer%2==0).boxed().collect(Collectors.toList());
        else {
            List<Integer> list = IntStream.rangeClosed(right, left).filter(integer -> integer%2==0).boxed().collect(Collectors.toList());
            Collections.reverse(list);
            return list;
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> list = ArrayToList(array);
        return list.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {

        List<Integer> firstArrayList = ArrayToList(firstArray);
        List<Integer> secondArrayList = ArrayToList(secondArray);
        firstArrayList.retainAll(secondArrayList);
        return firstArrayList;
    }

    public List<Integer> ArrayToList(int[] array){
        List<Integer> list = new ArrayList<Integer>();
        for(int i:array){
            list.add(i);
        }
        return list;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstArrayList = new ArrayList<Integer>(Arrays.asList(firstArray));
        List<Integer> secondArrayList = new ArrayList<Integer>(Arrays.asList(secondArray));
        List<Integer> temp = firstArrayList;
        secondArrayList.removeAll(firstArrayList);
        firstArrayList.addAll(secondArrayList);
        return firstArrayList;
    }
}
