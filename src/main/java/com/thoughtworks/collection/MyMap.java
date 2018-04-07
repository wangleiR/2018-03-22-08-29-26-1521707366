package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }
    //将集合A中得元素映射成集合B中的元素 -ok
    public List<Integer> getTriple() {
        return  array.stream().map(n-> 3* n).collect(Collectors.toList());
    }
    //数字映射为字母 -ok
    public List<String> mapLetter() {
        //return  array.stream().map(MyMap::R(array,letterList)).collect(Collectors.toList());
        List<String> res = new ArrayList<>();
        for (int i = 0;i < array.size();i++) {
            res.add(letterList.get(array.get(i)-1));
        }
        return res;
    }

    //数字映射为字母
    private static List<String> R(List<Integer> array,List<String> letterList){
        List<String> res = new ArrayList<>();
        for (int i = 0;i < array.size();i++) {
            res.add(letterList.get(array.get(i)-1));
        }
        return res;
    }
    //字母表映射 -ok
    public List<String> mapLetters() {
        List<String> res = new ArrayList<>();
        for (int i = 0;i < array.size();i++) {
            int firstCh =  array.get(i)/26;
            int secondCh = array.get(i)%26;
            if (firstCh > 0){
                if (secondCh == 0){
                    firstCh -= 1;
                    secondCh= 26;
                }
                res.add(letterList.get(firstCh-1)+letterList.get(secondCh-1));
            }
            else
                res.add(letterList.get(secondCh-1));
        }
        return res;
    }
    //从大到小排序 -ok
    public List<Integer> sortFromBig() {
        return array.stream().sorted(( e1, e2 ) -> e2.compareTo( e1 )).collect(Collectors.toList());
    }
    //从小到大排序 -ok
    public List<Integer> sortFromSmall() {
       return array.stream().sorted().collect(Collectors.toList());
    }
}
