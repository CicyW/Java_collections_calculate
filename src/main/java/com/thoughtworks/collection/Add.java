package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Add {

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int min = Math.min(leftBorder,rightBorder);
        int max = Math.max(leftBorder,rightBorder);
        return IntStream.rangeClosed(min, max).filter(i -> i % 2 == 0).sum();

    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int min = Math.min(leftBorder,rightBorder);
        int max = Math.max(leftBorder,rightBorder);
        return IntStream.rangeClosed(min, max).filter(i -> i % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {

        return arrayList.stream().map(integer -> integer*3+2).mapToInt(integer -> integer).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {

        return  arrayList.stream().map(integer -> (integer%2!=0)?integer*3+2:integer).collect(Collectors.toList());

    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return  arrayList.stream().filter(integer -> integer%2!=0).map(integer -> integer*3+5).mapToInt(integer -> integer).sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenArrayList = getEvenArrayList(arrayList);
        Integer length = evenArrayList.size();
       return new Double(length%2==0?(evenArrayList.get(length/2-1)+ evenArrayList.get(length/2))/2:evenArrayList.get(length/2));
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return getEvenArrayList(arrayList).stream().collect(Collectors.averagingInt(integer -> integer));
    }

    public List<Integer> getEvenArrayList(List<Integer> arrayList){
        return arrayList.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
    }

    public List<Integer> getOddArrayList(List<Integer> arrayList){
        return arrayList.stream().filter(integer -> integer%2!=0).collect(Collectors.toList());
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(integer -> integer%2==0).anyMatch(integer -> integer.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenArrayList = getEvenArrayList(arrayList);
        return evenArrayList.stream().distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenArrayList = getEvenArrayList(arrayList);
        List<Integer> oddArrayList = getOddArrayList(arrayList);
        Collections.sort(evenArrayList);
        Collections.reverse(oddArrayList);
        evenArrayList.addAll(oddArrayList);
        return evenArrayList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {

        List<Integer> newArrayList = new ArrayList<Integer>();
        for (int i = 0; i < arrayList.size()-1; i++) {
            newArrayList.add((arrayList.get(i)+arrayList.get(i+1))*3);
        }
        return newArrayList;

    }
}
