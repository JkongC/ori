import java.util.Scanner;
public class PrintRhomboidV1 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入菱形的行数，它必须是大于一的奇数");
        //检查输入是否为大于一的奇数，但是没有防非int输入
        while(true){
            num = sc.nextInt();
            if (num%2 != 0 && num > 1){
                break;
            }else{
                System.out.println("请输入一个大于一的奇数！");
            }
        }

        print(num);
    }

    //猪脑魅力时刻：冗长代码，再写一版（
    public static void print(int num){
        //前面的空格数
        int pre = (num-1) / 2;
        //中间的空格数
        int mid = 0;

        //打印第一行
        for (int i = 0; i < pre; i++) {
            System.out.printf(" ");
        }
        pre--;
        mid++;
        System.out.println("*");

        //打印直到中间行
        for (int i = 0; i < (num-1)/2; i++) {
            for (int j = 0; j < pre; j++) {
                System.out.printf(" ");
            }
            System.out.printf("*");
            for (int j = 0; j < mid; j++) {
                System.out.printf(" ");
            }
            System.out.println("*");
            if (i == (num-1)/2-1){
                pre++;
                mid = mid - 2;
                break;
            }
            pre--;
            mid = mid + 2;
        }

        //打印接下来的行，除了最后一行
        for (int i = 0; i < (num-1)/2-1; i++) {
            for (int j = 0; j < pre; j++) {
                System.out.printf(" ");
            }
            System.out.printf("*");
            for (int j = 0; j < mid; j++) {
                System.out.printf(" ");
            }
            System.out.println("*");
            pre++;
            mid = mid - 2;
        }

        //打印最后一行
        for (int i = 0; i < pre; i++) {
            System.out.printf(" ");
        }
        System.out.println("*");
    }
}