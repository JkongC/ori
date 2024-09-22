代码部分，主类在Behaviour.java，Person类在Person.java，关键字修饰试验用到的类在com文件夹里

以下按照小题号：

1. 在Person类的构造方法中，我将形参命名成了和成员变量一样。如果不用this关键字，就是name = name，等号两边代表的都是形参name，这没有意义，成员变量name还是没有赋值上。加了this关键字之后，它会指向当前的对象，this.name就指向了当前对象的成员变量name，那么this.name = name就实现了把形参name赋值给了成员变量name。
2. 像问题上面的提示所说的，类是一个模板，相应的对象就是以类为模板创建出来的，它们共享相同的成员变量和成员方法（具体值可能不同）。拿人来类比，就是它们有（大致）相同的生理构造。所以对这些对象可以进行的操作，要由它们的“生理构造”也就是类来决定。
3. 了解到访问修饰符有public，protected，private或者不写，要完全弄清楚它们的作用还是挺困难的。我以上面的Person类为实验对象。包内测试在NormalTest包内进行。下面的操作都可以在代码文件内看到。
   1. 我在主类Behaviour中写了一行xiaoming.name = "xm";。当Person类中的name还是private修饰的时候，编译会发生错误，提示name在Person是private访问控制。接下来我在Person类里添加了setName和getName方法，用来操作成员变量name，然后在BehaviourTest里调用它们，编译没有错，而且正常地修改和获取了name的内容。这说明private修饰的成员变量可以被本类访问，但是不可以被本包内的其他类访问。经测试，private修饰的成员方法同理。
   2. 我将Person类中的age改为了protected修饰，发现本包的BehaviourTest可以正常访问它。而PackageTest包中的BehaviourTest对age的调用却发生了报错。由此可知，protected修饰的成员变量可以在本类及本包的其他类访问，但不能在其他包的类访问。
   3. 我将Person类中的sex修饰词去掉，发现结果与protected相似。成员方法同样。暂且认为这样写也是仅能在本包范围内访问。
   4. public修饰的成员方法和成员变量，无论是同类，同包，还是不同包，都可以正常访问和调用。

4. 我在Person类中添加了静态成员变量num表示对象数量，它不跟着任何一个对象走，而是属于Person这个类。对于num的操作，我第一想法是在构造方法里写num++。但只是这样的话，对象销毁的时候，num并不会相应地-1。据我了解，java中的对象销毁是在对象没有任何引用的时候自动进行的。那对象销毁怎么跟num挂上联系呢？
   1. 查资料了解到，Object类中有个finalize方法，会在对象销毁的时候被自动调用，那么应该可以在Person类里重写finalize方法，让它把num-1。但查阅文档发现这个方法已经被标记为过时了，无法在高版本jdk使用。有诸如PhantomReference的类作为替代方案，但在这里的实现上有些问题（一是我对它认识很少，二是我没法给每个Person对象都配个PhantomReference对象）。其他的方法就超出我认知范围了QAQ。
