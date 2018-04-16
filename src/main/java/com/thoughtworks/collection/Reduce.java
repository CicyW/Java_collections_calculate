package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce{

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(item->item).max().getAsInt();
    }

    public int getMinimum() {
        return arrayList.stream().mapToInt(item->item).min().getAsInt();
    }

    public double getAverage() {
        return arrayList.stream().collect(Collectors.averagingInt(item ->item));
    }

    public double getOrderedMedian() {
        Integer length = arrayList.size();
        return (length%2==0)?(arrayList.get(length/2-1)+arrayList.get(length/2))*1.0/2: arrayList.get(length/2);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(item ->item%2==0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        return IntStream.rangeClosed(0,arrayList.size()-1).filter(i->arrayList.get(i)%2==0).findFirst().getAsInt();
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList.containsAll(this.arrayList)&&this.arrayList.containsAll(arrayList);
    }

    public int getLastOdd() {
        Collections.reverse(arrayList);
        return arrayList.stream().filter(item ->item%2!=0).findFirst().get();
    }

    public int getIndexOfLastOdd() {
        Collections.reverse(arrayList);
        return arrayList.size() - 1 - IntStream.rangeClosed(0,arrayList.size()-1).filter(item->arrayList.get(item)%2!=0).findFirst().getAsInt();

    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }


}
