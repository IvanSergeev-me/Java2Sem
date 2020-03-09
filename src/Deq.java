import java.util.Scanner;
import java.util.Stack;

public class Deq extends Stack {
    public static Scanner in = new Scanner(System.in);

    private final static int DEFSIZE = 16;
    private int[] array;
    private int size, head, tail;

    public Deq(int size) {
        array = new int[size];
        this.size = head = 0;
        tail = array.length - 1;
    }

    public Deq() {
        this(DEFSIZE);
    }

    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }

    private int backward(int index) {
        return --index >= 0 ? index : array.length - 1;
    }

    public int front() {
        return array[head];
    }

    public int back() {
        return array[tail];
    }

    public int length() {
        return size;
    }

    public void pushFront(int p) {
        array[head = backward(head)] = p;
        size += 1;
    }

    public void pushBack(int p) {
        array[tail = forward(tail)] = p;
        size += 1;
    }

    public int popFront() {
        int p = front();
        head = forward(head);
        size -= 1;
        return p;
    }

    public int popBack() {
        int p = back();
        tail = backward(tail);
        size -= 1;
        return p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deq deq = new Deq(10);
        while (true) {
            System.out.println("enter a command");
            int comm = in.nextInt();
            switch (comm) {
                case 0: {
                    System.out.println("filling array");
                    for (int i = 0; i < 10; i++) {
                        deq.pushFront((int) (Math.random() * 10));
                    }
                    for (int i = deq.head; i < (deq.tail + 1); i++) {
                        System.out.println(deq.front());
                        deq.popFront();
                    }
                    break;
                }
                case 1: {
                    System.out.println("outputting");
                    for (int i = deq.head; i < (deq.tail + 1); i++) {
                        System.out.println(deq.front());
                        deq.popFront();
                    }
                    break;
                }
                case 2:{
                    System.out.println("Sorting");

                    break;
                }
                case 3:{
                    System.out.println("The head is: "+ deq.front());
                    System.out.println("The tail is: "+ deq.back());
                    break;
                }


            }
        }
    }
}