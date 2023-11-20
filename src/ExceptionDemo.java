import javax.swing.*;
import java.lang.*;
import java.lang.ArithmeticException;

interface printA{
    public void method(int a ) throws ArithmeticException;
}
class printB implements printA{
    int b;
    printB(){
        b = 0;
    }
    printB( int b ){
        this.b = b;
    }
    public void method ( int a){
        System.out.println("b= "+b);
    }

}


public class ExceptionDemo{
    public static void main(String[] args){

    }
}

