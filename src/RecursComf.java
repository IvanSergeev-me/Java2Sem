import java.util.Scanner;
//Рекурсивный компилятор формул.

public class RecursComf{
    private static final int DEFSIZE = 255;
    private char[] str;
    private int index;

    private void compileF(){
        compileT();
        if(index >= str.length)
            return;
        if(str[index] == '+'){
            index++;
            compileF();
            System.out.print("+");
            return;
        }
        if(str[index] == '-'){
            index++;
            compileF();
            System.out.print("-");
        }
    }
    private void compileT(){
        compileM();
        if(index >= str.length)
            return;
        if(str[index] == '*'){
            index++;
            compileT();
            System.out.print("*");
            return;
        }
        if(str[index] == '/'){
            index++;
            compileT();
            System.out.print("/");
        }
    }
    private void compileM(){
        if(str[index] == '('){
            index++;
            compileF();
            index++;
        }
        else
            compileV();
    }
    private void compileV(){
        System.out.print("" + str[index++] + " ");
    }
    public void RecursCompf(){
        str = new char[DEFSIZE];
    }
    public void compile(char[] str){
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
    public static void main(String[] args) throws Exception{
        RecursComf c = new RecursComf();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Введите формулу -> ");
            c.compile(in.next().toCharArray());
        }
    }
}