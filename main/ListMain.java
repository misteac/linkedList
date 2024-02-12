package linkedList.main;

import linkedList.core.MyLList;

public class ListMain {
    public static void main(String[] args) {
        MyLList<Integer> myLList = new MyLList<>();
        myLList.addElement(123);
        myLList.addElement(421);
        myLList.addElement(441);
        myLList.addElement(44241);
        myLList.addElement(5651);
        System.out.println(myLList.size());
        myLList.removeAt(4);
        System.out.println(myLList.size());
        myLList.add(11111, 0);
        System.out.println(myLList.getIndex(0));
        myLList.add(99999, myLList.size());
        System.out.println(myLList.getIndex(myLList.size()-1));
        System.out.println("--------------------");
        System.out.println(myLList.print(myLList));
    }
}