import java.util.Stack;

/**
 * Created by dfreer on 2/8/2017.
 */
public class Ex0606 {
    public static void main(String[] args) {
        hanoi(3, 'A','B','C');
    }

    private static void hanoi(int n, char x, char y, char z){
        Stack stack = new Stack();
        stack.push(new Quad(n, x, y, z));
        while(!stack.empty()){
            Quad quad = (Quad)stack.pop();
            n = quad.n;
            x = quad.a;
            y = quad.b;
            z = quad.c;
            if(n == 1)
                System.out.println("Move top disk from peg " +quad.a +
                 " to peg " + quad.c);
            else {
                stack.push(new Quad(n - 1, y, x, z));
                stack.push(new Quad(1, x, y, z));
                stack.push(new Quad(n - 1, x, z, y));
            }
        }
    }


}

class Quad{
    public int n;
    public char a, b, c;
    public Quad(int n, char a, char b, char c){
        this.n = n;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
