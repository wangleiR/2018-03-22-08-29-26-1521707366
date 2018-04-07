package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
   //ok
    public int getSumOfEvens(int leftBorder, int rightBorder){
        int count = IntStream.rangeClosed(Math.min(leftBorder,rightBorder),Math.max(leftBorder,rightBorder))
                .filter(n -> n%2 == 0).reduce((x,y) -> x + y).getAsInt();
        return count;
    }
    //ok
    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int count = IntStream.rangeClosed(Math.min(leftBorder,rightBorder),Math.max(leftBorder,rightBorder))
                .filter(n -> n%2 == 1).reduce((x,y) -> x + y).getAsInt();
        return count;
    }
    //ok
    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int count =arrayList.stream().map(n -> 3 * n + 2).reduce((x,y) -> x + y).get();
        return count;
    }
    //求数组中奇数元素的3倍加2，偶数元素不变的数组 -ok
    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        //List<Integer> res = arrayList.stream().filter(n -> n%2 == 1).map(n -> 3 * n + 2).collect(Collectors.toList());
        //arrayList.stream().parallel().map(e -> { if (e%2 == 1)  return  3 * e + 2 ;};
        for (int i = 0;i < arrayList.size();i++)
            if(arrayList.get(i) % 2 == 0){
               // break;
            }else{
                arrayList.set(i,arrayList.get(i)*3+2);
            }
        return arrayList;
    }
    //求数组中奇数元素的3倍加5的和-ok
    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int count =arrayList.stream().filter(n -> n%2 == 1).map(n -> 3 * n + 5).reduce((x,y) -> x + y).get();
        return count;
    }
    //求数组中所有偶数组成的数组的中位数 -ok
    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        int length = even.size();
        if (length%2 == 1){
            return even.get(length/2);
        }else{
            return (even.get(length/2)+even.get(length/2-1))/2.0;
        }
    }
    //求数组中所有偶数的平均数-ok
    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        long count = arrayList.stream().filter(n -> n%2 == 0).count();
        double sum = arrayList.stream().filter(n -> n%2 == 0).reduce((x,y) -> x + y).get();
        return (double)sum/count;
    }
    // 求数组中所有偶数组成的数组是否包含某特定的数specialElment - ok
    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> even = arrayList.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        boolean result = even.stream().anyMatch(e -> e == specialElment);
        return result;
    }
    ////去除数组中所有偶数组成的数组的重复数 -ok
    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        return even;
    }
    //排序数组 结果使数组偶数在递增在前，奇数递减在后 -ok
    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(n -> n%2 == 0).sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(n -> n%2 == 1).sorted(( e1, e2 ) -> e2.compareTo( e1 )).collect(Collectors.toList());
        even.addAll(odd);
        return even;
    }
    // 数组中前一个元素和后一个元素的和的3倍的数组 -ok
    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> arr = new ArrayList<>();
       for (int i = 0;i < arrayList.size()-1;i++){
           arr.add((arrayList.get(i)+arrayList.get(i+1))*3);
       }
        return arr;
    }
}
