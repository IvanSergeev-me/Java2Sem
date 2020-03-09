import java.awt.*;
public class Bird {
    static int count;
    protected int x;
    protected int y;
    protected int size=50;
    protected Color color = Color.black;
    public Bird(){
        count++;
        System.out.println("Я - птица номер " +count);
        fly();
    }
    public void  fly(){
        System.out.println("Ya lechu!");
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,size,size);
    }
}
