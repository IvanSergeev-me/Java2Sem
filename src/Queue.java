interface Queue {
    boolean empty();
    void clear();
    void push(int val) throws Exception;
    int pop() throws Exception;
    int front() throws Exception;
}