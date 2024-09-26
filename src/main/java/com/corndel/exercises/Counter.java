package com.corndel.exercises;


public class Counter {

   private int count;

    public Counter() {
        count = 0;
    }

    public void increment() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public static void main (String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = counter1;


        System.out.println(counter1);
        System.out.println(counter2 == counter1);
    }

}