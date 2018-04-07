package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }
    //把二维数组变成一维数组 -ok
    public List<Integer> transformToOneDimesional() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<array.length;i++){
            for (int j = 0;j<array[i].length;j++){
                list.add(array[i][j]);
            }
        }
        return list;
    }
    // 把二维数组变成一维数组,消除重复,按照第一次出现的顺序排列最后的输出结果 -ok
    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<array.length;i++){
            for (int j = 0;j<array[i].length;j++){
                list.add(array[i][j]);
            }
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
}
