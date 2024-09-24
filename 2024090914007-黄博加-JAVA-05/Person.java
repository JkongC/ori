public class Person {
    private String name;
    private int age;
    private int sex;
    private static int num;

    public Person(String name,int age,int sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
        Person.num++;
    }

    private void eat() {
        System.out.println(name+"正在吃东西");
    }

    private void sleep() {

    }

    private void dadoudou() {

    }

    //静态的count方法
    public static int count(){
        return Person.num;
    }

    //finalize方法
    /*@Override
    protected void finalize() throws Throwable{
        super.finalize();
        Person.num--;
    */
}