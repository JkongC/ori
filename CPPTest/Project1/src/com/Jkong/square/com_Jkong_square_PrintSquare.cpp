#include <stdio.h>
#include <jni.h>
#include "com_Jkong_square_PrintSquare.h"

extern "C" {

JNIEXPORT void JNICALL Java_com_Jkong_square_PrintSquare_printsqr
  (JNIEnv *, jclass){
    for(int i=0;i<8;i++){
        for(int j=0;j<5;j++){
            if(j == 4){
                printf("*\n");
            }else{
                printf("*");
            }
        }
    }
  }


}

