package dataStructs;

class LinkedList{

    Node head = null;

    //optimization for addition
    //of new nodes
    Node last = null;


    class Node{
        int data;
        Node next ;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    LinkedList(int data)
    {
        Node n = new Node(data);
        head = last = n;
    }
    LinkedList()
    {
        //No arg constructor
    }
    void addNode(int data)
    {

        Node n = new Node(data);
        if (head == null)
        {
            System.out.println("Head Updated");
            head = last = n;
            return;
        }

        Node tmp = this.head;
        while(tmp!= null){
            if(tmp.next == null)
            {
                tmp.next = n;
                break;
            }
            tmp = tmp.next;
        }
        last = n;
    }

    void optimizedAddNode(int data)
    {
        Node n = new Node(data);
        last.next = n;
        last = n;
    }

    void deleteNodeByData(int n)
    {
        Node tmp = head;
        Node prev = head;
        while(tmp.data == n)
        {
            if(head == last)
            {
                last = tmp.next;
            }
            head = tmp = prev = tmp.next;
        }

        if(tmp != null)
            tmp = tmp.next;

        while(tmp != null){
            if(tmp.data == n)
            {
                prev.next = tmp.next;
                if(tmp == last)
                {
                    last = prev;
                    return;
                }
                tmp = tmp.next;
            }
            else
            {
                tmp = tmp.next;
                prev = prev.next;
            }
        }
    }

    void deleteNodeByPosition(int index)
    {
        int cursor = 1;
        if(cursor == 1)
        {
            head = head.next;
            if( head == last)
                last = null;
            return;
        }
        Node tmp = head;
        Node prev = head;
        if(tmp!=null)
            tmp = tmp.next;
        while(tmp!= null)
        {
            cursor++;
            if(cursor == index)
            {

                prev.next = tmp.next;
                if(last == tmp)
                {
                    last = prev;
                }
                return;
            }
        }
        System.err.println("Index value lesser than the number of elements");
        System.out.println("Contents of the list");
        printList();
    }

    int printList()
    {
        int size =0;
        Node tmp = head;
        System.out.println("List Contents");
        while(tmp != null && tmp.next != null){
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
            size++;
        }
        System.out.print(tmp.data);
        size++;
        return size;
    }

}