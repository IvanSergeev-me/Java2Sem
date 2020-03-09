import java.util.Scanner;

class L1ListTest{
    // массив элементов.
    private int[] array;
    // массив ссылок.
    private int[] next;
    // "нил" списка.
    private int nilList;
    // "нил" свобоного места.
    private int nilFree;
    // индексы элементов до и после указателя.
    private int before, after;
    // связать два элемента, заданные индексами.
    private void link(int first, int second) {
        next[first] = second;
    }
    // захватить место.
    private int mallocIndex() {
        int index = next[nilFree];
        link(nilFree, next[index]);
        return index;
    }
    // освободить место.
    private void freeIndex(int index) {
        link(index, next[nilFree]);
        link(nilFree, index);
    }
    public L1ListTest(int size) {
        array = new int[size];
        next = new int[size + 2];
        nilList = size;
        nilFree = size + 1;
        link(nilList, nilList);
        link(nilFree, 0);
        for (int i=0; i<size-1; i++)
            link(i, i+1);
        link(size-1, nilFree);
        before = after = nilList;
    }
    public boolean empty() {
        return next[nilList] == nilList;
    }


    public void clear() {
        try {
            toFront();
            while (true)
                erase();
        } catch(Exception e) {
            ;
        }
    }
    public void toFront() {
        before = nilList;
        after = next[nilList];
    }
    public boolean end() {
        return after == nilList;
    }
    public void forward() throws Exception {
        if(after == nilList) throw new Exception();
        before = after;
        after = next[after];
    }
    public int after() throws Exception {
        return array[after];
    }
    public void insert(int val) throws Exception {
        int index = mallocIndex();
        link(before, index);
        link(index, after);
        after = index;
        array[index] = val;
    }
    public int erase() throws Exception {
        int val = array[after];
        int index = after;
        after = next[index];
        link(before, after);
        freeIndex(index);
        return val;
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        L1ListTest l = new L1ListTest(5);
        while (true) {
            System.out.println("Введите комманду");
            int comm = s.nextInt();
            switch (comm) {
                case 0:
                    System.out.println("List is " + (l.empty() ?
                            "empty" :
                            "not empty"));

                    break;
                case 1:
                    l.clear(); break;
                case 2:
                    l.toFront(); break;
                case 3:
                    System.out.println("Pointer " + (l.end() ?
                            "is" :
                            "is not")+
                            " in the end of the list");

                    break;
                case 4:
                    l.forward(); break;
                case 5:
                    System.out.println("elem = " + l.after()); break;
                case 6:
                    l.insert(s.nextInt()); break;
                case 7:
                    l.erase(); break;
                default:
                    System.out.println("Ti debil!");
            }
        }
    }
}