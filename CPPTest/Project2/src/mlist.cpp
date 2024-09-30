#include <jni.h>
#include "mlist.h"
#include <stdio.h>

extern "C" {
JNIEXPORT void JNICALL Java_mlist_printlist
  (JNIEnv *, jclass){
    printf("This line is from C++.\n");
    for(int i=1;i<=9;i++){
        for(int j=1;j<=i;j++){
            if(j==i){
                printf("%d * %d = %d\n",j,i,i*j);
            }else{
                printf("%d * %d = %-4d",j,i,i*j);
            }
        }
    }
  }

}

