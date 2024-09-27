# 题解

了解一点markdown语法，终于可以分大小点了（欢呼）





## Task 1. Exception & Error



### 几个例子

**Exception**

- `IOException`: 在文件或者数据的输入输出过程，如果无法正常进行，就可能会抛出。比如目标文件不存在。
- `NullPointerException`: 在指定的引用变量赋值为null的时候会出现。比如定义 `String a = null` 后，如果执行 `System.out.println(a);` 就会抛出
- `ArrayIndexOutOfBoundsException`: 当访问数组时，指定索引不在数组的范围内，就会抛出。比如 `int[] a = {1,2,3};` 如果尝试调用 `a[3]` 或 `a[-1]` 等等，就会抛出。



**Error**

- `OutOfMemoryError`: 观看源码里的注释可以知道，当JVM尝试为某对象分配内存时，如果内存不足，GC又没办法再腾出更多内存时，就会抛出此Error。

- `IOError`: 与IOException相比，抛出IOError的情况是更为严重的输入输出问题。注释中只提到"a serious I/O error"，拿出手机问小爱同学得知，硬件错误等较为底层的问题是它抛出的原因。
- `IllegalAccessError`: 看注释可以知道，当一个"application"尝试访问它没有权限访问的字段或者方法时，这个Error就会抛出，但往往编译时会报错，所以一般只会出现在class定义异常地改变时。"application"似乎是java中的一个类，但我在源码中找不到它。（bing查到它是javaweb对象）



### 处理态度

**Exception**

- 程序执行过程中一些意外的情况，往往不会被编辑器发现，编译时也可能不会报错，运行时就可能出现了。
- 以我的了解，一个Exception抛出后首先可以在当前代码块被捕获，如果没有捕获，可能就会直接导致程序终止运行。如果设置了相应的捕获语句，它可以被一层层地捕获并抛出到上级代码中。
- 按我的理解，它除了是意外本身，也是程序员处理意外情况的一种机制。程序员可以通过捕获这些意外，通过相应的代码处理，保证程序的正常运行。还可以自己根据实际情况定义新的Exception类，供自己处理意外情况时使用。



**Error**

- 程序执行过程中的严重意外情况，即错误，往往比Exception更底层，影响更大
- Error往往会对程序的运行产生致命的影响，所以一般不会对它进行处理（程序继续运行可能危害更大？），而是在程序编写过程中就尽量避免出现可能导致Error的问题。



### Checked & Unchecked

~~CSDN启动（？~~

**Checked异常**

- 在编译过程中要提醒程序员的Exception。这包括Exception和它的子类（不包括RuntimeException）。我在同目录test.java中写了一段会报FileNotFoundException的代码，它在编译时就会提示。这些往往是能直接从代码里看出来的显性问题。



**Unchecked异常**

- 编译过程中不会提示，但运行时可能会出现的，包括RuntimeException（继承自Exception）的子类。比如NullPointerException就是RuntimeException的子类。它们往往需要修改程序本身来避免，比如修改异常地把变量赋值为null的代码，或者异常地调用null变量的代码。看了一圈，感觉Unchecked异常才是大多数。





## Task 2. 异常的处理



### 第3小问：程序流程

1. 首先，程序会创建一个BankAccount对象，并将balance设置为0-200的随机double值。

2. 然后，程序会尝试执行try语句块内的语句，先获取余额，然后尝试取款150.0，即令balance减取款数额，再打印取款成功

3. 

   - 如果这期间没有问题，那么程序会接着往下执行，打印“程序结束”。

   - 如果withdraw方法内if语句判断为true，即balance < amount，那么会抛出余额不足的Exception，try-catch语句捕获到该Exception后，不会继续执行try语句块里的内容，会转而执行catch语句块里的内容，打印Exception e的错误信息（即抛出异常时传入构造方法的信息：余额不足......）。

     

- *（话说这里用到了我第一次见的System.err.println。翻找源码发现，在System类里，err和out同为PrintStream类型的引用变量，但调用PrintStream里的println方法时，我没有找到它们的不同。查阅资料得知，面对err和out的输出，JVM和操作系统的处理态度可能不同，err要更“紧急”一些。）*



### 第4小问：文件读取与数据处理

***	首先我写了一个NumInitializer用来写入数据，顺便上手一下io相关的类，这其中遇到的问题在它的注释中写出，这里不再赘述。***

1. 首先使用NumInitializer写入给定数量的一定范围的数字，存入data.txt中（位于FileProcessing目录下）。
2. 然后使用NumReader读入并计算数据个数、数据平均值，机制已在代码中体现。
3. 针对题目中提到的三种Exception，我在catch语句块一一判断捕捉到的Exception类型并分别输出不同的信息。针对其他可能的Exception，输出它们的错误信息。（toString方法，如果有错误信息，返回错误名+错误信息）
4. 我了解到，使用try-with-resources时，如果对象实现了AutocCloseable或者Closeable接口，try语句块执行结束时就能够自动被关闭，而BufferedReader的父类Reader做到了这一点，因此我没有写finally。

***就到这里啦qwq***
