package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    //选出给定区间中所有的数字 -ok
    public List<Integer> getListByInterval(int left, int right) {
        //IntStream st = IntStream.rangeClosed(Math.min(left,right),Math.max(left,right));
        List<Integer> arrayList = new ArrayList<>();
       // arrayList.stream().i(f -> f+1).forEachRemaining(System.out::print);
       int  l = Math.min(left,right);
       int  r = Math.max(left,right);
        arrayList = Stream.iterate(l, item -> item + 1).limit(r-l+1).collect(Collectors.toList());
        if (left > right)
            Collections.reverse(arrayList);
       // List<Integer> list =st.boxed().collect(Collectors.toList());
        return arrayList;
    }
    ////选出给定区间中所有的偶数 -ok
    public List<Integer> getEvenListByIntervals(int left, int right) {
        int  l = Math.min(left,right);
        int  r = Math.max(left,right);
        List<Integer> arrayList = Stream.iterate(l, item -> item + 1).limit(r-l+1).filter(n -> n % 2 == 0).collect(Collectors.toList());
        if (left > right)
            Collections.reverse(arrayList);
        return arrayList;
    }
    //选出给定区间中所有的偶数 -ok
    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());
    }
    //弹出集合最后一个元素 -ok
    public int popLastElment(int[] array) {
        return array[array.length-1];
    }
    //弹出两个集合的交集 -ok
    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List m1 = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List m2 = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        m1.retainAll(m2);
        return  m1;
    }
    // 将集合二中与集合一不同的元素加入集合一 -ok
    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List m1 = Arrays.stream(firstArray).collect(Collectors.toList());
        List m2 = Arrays.stream(secondArray).collect(Collectors.toList());
        m2.removeAll(m1);
        m1.addAll(m2);
        return  m1;
    }
}
