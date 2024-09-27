package com.Jkong.File;

public class EmptyFileException extends RuntimeException{
    public EmptyFileException(){
        super();
    }

    public EmptyFileException(String message){
        super(message);
    }
    //偷懒啦，还有两种构造方法不写了
}
