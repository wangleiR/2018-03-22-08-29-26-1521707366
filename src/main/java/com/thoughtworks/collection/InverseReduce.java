package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }
    //根据给定数字无限分割至等于0(提示：9-2=7,7-2=5 ...) -ok
    public List<Integer> divideToSmaller(int number) {
        int n = random.nextInt(3);
        return IntStream.range(0,number).boxed().sorted((n1,n2)->n2-n1).filter(num -> (number - num) % n == 0).collect(Collectors.toList());
    }
}
