import java.util.Scanner;
public class PrintRhomboidV2 {
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

    //用数组，变短了几行（哭）
    public static void print(int num){
        String[] line = new String[(num+1)/2];
        String temp = "";
        boolean reverse = false;
        int pre = (num-1)/2;
        int mid = 0;

        for (int i = 0;i < line.length;i++) {
            if (i == 0){
                for (int j = 0; j < pre; j++) {
                    temp = temp + " ";
                }
                temp = temp + "*";
                pre--;
                mid++;
            }else{
                for (int j = 0; j < pre+mid+1;j++) {
                    if (j == pre+mid){
                        temp = temp + " *";
                    } else if (j == pre){
                        temp = temp + "*";
                    } else{
                        temp = temp +" ";
                    }
                }
                pre--;
                mid = mid + 2;
            }
            line[i] = temp;
            temp = "";
        }

        //来回遍历一次
        for (int i = 0;i < line.length && i >= 0;) {
            System.out.println(line[i]);
            if (i == line.length-1){
                reverse = true;
            }
            if (reverse){
                i--;
            }else{
                i++;
            }
        }
    }
}