package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }
    //根据给定数字无限分割至等于0(提示：9-2=7,7-2=5 ...) -ok
    public List<Integer> divideToSmaller(int number) {
        List<Integer> res = new ArrayList<>();
        while (number -2> 0){
            number -= 2;
            res.add(number);
        }
        return res;
    }
}
