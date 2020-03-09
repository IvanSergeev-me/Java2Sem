import java.util.Scanner;
public class StackObject{
    private static final int DEFSIZE = 16;
    private Object[] array;
    private int head;
    public StackObject(int size) {
        array = new Object[size];
        head = 0;
    }
    public StackObject() {
        this(DEFSIZE);
    }
    public boolean empty() {
        return head == 0;
    }
    public void clear() {
        head = 0;
    }
    public void push(Object val) throws Exception {
        array[head++] = val;
    }
    public Object pop() throws Exception {
        return array[--head];
    }
    public Object top() throws Exception {
        return array[head-1];
    }
    public int length(){
        return array.length;
    }
    public void output(){
        for (int i=0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        StackObject s = new StackObject(10);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите комманду");
            int comm = in.nextInt();
            switch (comm) {

                case 0 : {
                    for (int i = 0; i < 10; i++) {
                        s.push((int) (Math.random() * 10));
                    }
                }
                case 1 : {
                    s.clear();
                    break;
                }
                case 2 : {

                    s.push(new Bird());
                    System.out.println("Vvedite chislo");
                    s.push(in.nextInt());
                    break;
                }

                case 3 : {
                    System.out.println("outputting");
                    s.output();
                    break;
                }
                /*case 4 : {
                    System.out.println("Sorting");
                    for (int i = 0; i < (s.array.length-1) ; i++) {
                        int inTime = s.array[i];
                        if (s.array[i + 1] < inTime) {
                            s.array[i] = s.array[i + 1];
                            s.array[i] = inTime;

                        }
                    }
                    break;
                }*/
                default: {
                    System.out.println("Ты чо дурак блят?");
                    System.exit(0);
                }
            }
        }
    }


}
