import java.util.Scanner;

class StackFIFO implements Queue {
    private int[] array;
    private int size, head, tail;

    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }

    public StackFIFO(int size) {
        array = new int[size];
        clear();
    }

    public boolean empty() {
        return size == 0;
    }

    public void clear() {
        size = head = 0;
        tail = array.length - 1;
    }

    public void push(int val) throws Exception {
        if (++size >= array.length) throw new Exception();
        array[tail = forward(tail)] = val;
    }

    public int pop() throws Exception {
        int val = front();
        head = forward(head);
        size -= 1;
        return val;
    }

    public int front() throws Exception {
        if (empty()) throw new Exception();
        return array[head];
    }

    public static void main(String[] args) throws Exception {
        StackFIFO q = new StackFIFO(5);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите комманду");
            int comm = in.nextInt();
            switch (comm) {
                case 0:
                    System.out.println("Queue is " + (q.empty() ?
                            "empty" :
                            "not empty"));

                    break;
                case 1:
                    q.clear();
                    break;
                case 2:
                    q.push(in.nextInt());
                    break;
                case 3:
                    System.out.println("Pop int " + q.pop());
                    break;
                case 4:
                    System.out.println("Front = " + q.front());
                    break;
                default:
                    System.out.println("Wrong action, ignore");
            }
        }
    }
}