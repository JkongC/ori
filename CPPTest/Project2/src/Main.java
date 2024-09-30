public class Main {
    static {
        System.loadLibrary("mlist");
    }

    public static void main(String[] args) {
        System.out.println("下面调用C++来打印乘法表");
        mlist.printlist();
    }
}
