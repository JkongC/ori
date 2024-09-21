import java.util.Scanner;
public class PrintRhomboidV3 {
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

    //V1和V2的杂交，又短了一点（
    public static void print(int num){
        boolean reverse = false;
        int pre = (num-1)/2;
        int mid = 0;

        //条件控制留空了
        for (int i = 0;i < (num+1)/2 && i >= 0;) {
            if (i == 0){
                for (int j = 0; j < pre; j++) {
                    System.out.printf(" ");
                }
                System.out.println("*");
            } else {
                for (int j = 0; j < pre+mid+1; j++) {
                    if (j == pre+mid){
                        System.out.println(" *");
                    } else if (j == pre){
                        System.out.printf("*");
                    } else{
                        System.out.printf(" ");
                    }
                }
            }

            if (i == (num-1)/2){
                reverse = true;
            }
            if (reverse){
                pre++;
                mid = mid - 2;
                i--;
            } else{
                pre--;
                //mid从0到1到3......
                mid = mid + (i == 0 ? 1 : 2);
                i++;
            }
        }
    }
}