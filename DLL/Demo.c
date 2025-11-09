#include <jni.h>
#include <stdio.h>
#include "Demo.h"
JNIEXPORT int JNICALL Java_B1_add(JNIEnv *env, jobject obj, jint a, jint b)
{
printf("\n%d + %d = %d\n",a,b,(a+b));
return a+b;
}
JNIEXPORT int JNICALL Java_B1_sub(JNIEnv *env, jobject obj, jint a, jint b)
{
printf("\n%d - %d = %d\n", a, b, (a-b));
return a-b;
}
JNIEXPORT int JNICALL Java_B1_mul(JNIEnv *env, jobject obj, jint a, jint b)
{
printf("\n%d * %d = %d\n", a, b, (a*b));
return a*b;
}
JNIEXPORT int JNICALL Java_B1_div(JNIEnv *env, jobject obj, jint a, jint b)
{
    if (b==0)
    {
        printf("\nDivision by zero error!\n");
        return 0; 
    }
    
printf("\n%d / %d = %d\n", a, b, (a/b));
return a/b;
}

/*Exeution Steps:
$ javac Demo.java
$ ls
$ gcc -shared -fPIC -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux Demo.c -o libB1.so
$ ls
$ java -classpath . -Djava.library.path=. Demo
*/