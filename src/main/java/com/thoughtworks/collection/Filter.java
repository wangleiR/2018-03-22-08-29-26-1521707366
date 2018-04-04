package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    //求数组中的偶数 -ok
    public List<Integer> filterEven() {
        return array.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
    }
    //求数组中3的倍数 -ok
    public List<Integer> filterMultipleOfThree() {
        return array.stream().filter(n -> n%3 == 0).collect(Collectors.toList());
    }
    //求两数组的公共元素
    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List m1 = new ArrayList(firstList);
        List m2 = new ArrayList(secondList);
        m1.retainAll(m2);
        return  m1;
    }
    //去除数组中的重复元素 -ok
    public List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }
}