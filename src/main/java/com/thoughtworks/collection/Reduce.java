package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Reduce implements SingleLink<Integer>{

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }
    // 获取数组中的最大值 -ok
    public int getMaximum() {
        return arrayList.stream().max(Integer::compare).get();
    }
    //获取数组中的最小值 -ok
    public double getMinimum() {
        return arrayList.stream().min(Integer::compare).get();
    }
    // 获取数组的平均值 -ok
    public double getAverage() {
        IntSummaryStatistics stats = arrayList.stream().mapToInt((x) -> x).summaryStatistics();
        return stats.getAverage();
    }
    // 获取数组中位数 -ok
    public double getOrderedMedian() {
        return (arrayList.get(arrayList.size()/2)+arrayList.get(arrayList.size()/2-1))/2.0;
    }
    //获取数组中第一个偶数 -ok
    public int getFirstEven() {
        return arrayList.stream().filter(n->n%2==0).findFirst().get();
    }
    //获取数组中第一个偶数的下标 -ok
    public int getIndexOfFirstEven() {
        int num = arrayList.stream().filter(n->n%2==0).findFirst().get();
        for (int i: arrayList) {
            if (i == num)
                return arrayList.indexOf(i);
        }
        return 0;
    }
    //判断两个数组是否相等 -ok
    public boolean isEqual(List<Integer> arrayList1) {
        Collections.sort(arrayList1);
        Collections.sort(arrayList);
        return arrayList.equals(arrayList1);
}

    //实现接口SingleLink，然后再此函数内使用
    //获取单链表中的中位数
    public Double getMedianInLinkList(SingleLink singleLink) {
        this.arrayList.stream().forEach(singleLink::addTailPointer);
        return (double)((int)singleLink.getNode(this.arrayList.size() / 2) + (int)singleLink.getNode(this.arrayList.size() / 2 + 1)) / 2;
    }
    //获取数组中最后一个奇数 -ok
    public int getLastOdd() {
        Collections.reverse(arrayList);
        return arrayList.stream().filter(n->n%2==1).findFirst().get();
    }
    //获取数组中最后一个奇数的下标 -ok
    public int getIndexOfLastOdd() {
        Collections.reverse(arrayList);
        int num = arrayList.stream().filter(n->n%2==1).findFirst().get();
        for (int i: arrayList) {
            if (i == num)
                return arrayList.size() - arrayList.indexOf(i) -1;
        }
        return 0;
    }

    @Override
    public Integer getHeaderData() {
        return this.arrayList.get(0);
    }

    @Override
    public Integer getTailData() {
        return this.arrayList.get(this.arrayList.size() - 1);
    }

    @Override
    public int size() {
        return this.arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override
    public Integer getNode(int index) {
        return this.arrayList.get(index - 1);
    }

    @Override
    public boolean deleteFirst() {
        return this.arrayList.remove(this.getHeaderData());
    }

    @Override
    public boolean deleteLast() {
        return this.arrayList.remove(this.getTailData());
    }

    @Override
    public void addHeadPointer(Integer item) {
        this.arrayList.add(0, item);
    }

    @Override
    public void addTailPointer(Integer item) {
        this.arrayList.add(item);
    }
}
