#include <jni.h>
#include <math.h>
#include <time.h>
#include "Euler.h"


double factorial(int num);

JNIEXPORT jdouble JNICALL Java_Euler_sinFromC(JNIEnv *env, jobject obj, jdouble x) {
    clock_t start, end;
    double cpu_time_used;

    start = clock();

    jdouble result = 0.0;
    jdouble term;
    int sign = 1;

    for (int n = 1; n <= 9; n += 2) {
        term = pow(x, n) / factorial(n);
        result += sign * term;
        sign *= -1;
    }

    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    return result;
}

double factorial(int num) {
    double fact = 1;
    for (int i = 1; i <= num; i++) {
        fact *= i;
    }
    return fact;
}
