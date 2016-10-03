package dataStructs;

import java.util.Random;

class TestDriver
{
    void printMenu()
    {
        System.out.println("-----Test Menu-----");
        System.out.println("1. Linked List");

    }

    void testLinkedList()
    {
        System.out.println("----Testing Linked List Insertion----");
        LinkedList l = new LinkedList();
        Random rn = new Random();
        //Insert 10 random numbers in to the list
        //The numbers should be between 100-999
        for(int i=0; i< 10; i++)
        {
            l.addNode(rn.nextInt(999-100 + 1)+100);
        }
        l.printList();
    }
    public static void main(String args[])
    {
        TestDriver td = new TestDriver();
        td.printMenu();
        td.testLinkedList();
    }
}