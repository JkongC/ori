package com.ISEKAI;
/*------------------------------------*/
import com.ISEKAI.tool.Print;
/*------------------------------------*/
public class HelloWorld {
    public static void main(String[] args){
        //IDEA提示我可以用下面这个增强的for循环，暂时不太懂
        for (String arg : args) {
            System.out.println(arg);
        }
        Test.test();
    }
}
/*------------------------------------*/
class Test{
    public static void test(){
        Print.print("Hello World");
    }
}