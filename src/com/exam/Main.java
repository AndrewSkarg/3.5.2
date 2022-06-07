package com.exam;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static int askQuestion(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        boolean isInputInt = scanner.hasNextInt();
        int number = isInputInt ? scanner.nextInt() : askQuestion(question);
        return number;
    }
    public static int getIndex(int index,int size){
        while (index>=size){
            index-=size;
        }
        return index;
    }

    public static void main(String[] args) {
        // write your code here
        int people = askQuestion("Enter number of people: ");
        int whoDelete = askQuestion("Who every person to delete :")-1;
        LinkedList<Integer> list=new LinkedList<>();
        list.addAll(IntStream.range(0,people).boxed().collect(Collectors.toList()));
        list.forEach(x-> System.out.print(x+", "));
        System.out.println();
        int currentPerson = list.getFirst();
        while (list.size()!=1){
            int ind=list.indexOf(currentPerson)+whoDelete;
            ind=getIndex(ind,list.size());
            System.out.println(list.get(ind)+" deleted");
            list.remove(ind);
            if (ind==list.size()) {
                currentPerson = list.getFirst();
                ind=0;
            }
            if(list.size()!=1) {
                int a;
                if ((a=ind + whoDelete) >= list.size()) {
                    a=getIndex(a,list.size());
                    System.out.println(list.get(a)+" deleted");
                    list.remove(list.get(a));
                    a=getIndex(a,list.size());
                    currentPerson=list.get(a==list.size()?list.get(a=0):a);
                    if(list.size()==2){
                        list.remove((a+whoDelete+1)%2==0?list.getLast():list.getFirst());
                        break;
                    }

                } else {
                    currentPerson = list.get(ind);
                }
            }
        }
        System.out.println("\n"+list.getLast()+ " remains");
    }
}
