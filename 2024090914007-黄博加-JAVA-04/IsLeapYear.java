import java.util.Scanner;
public class IsLeapYear{
    public static void main(String[] args) {
        int year;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个年份");
        year = sc.nextInt();
        if (isLeapYear(year)){
            System.out.println("它是闰年");
        }else{
            System.out.println("它不是闰年");
        }
    }

    public static boolean isLeapYear(int year){
        if (year%4 == 0 && year%100 != 0){
            return true;
        }else if(year%400 == 0){
            return true;
        }else{
            return false;
        }
    }
}