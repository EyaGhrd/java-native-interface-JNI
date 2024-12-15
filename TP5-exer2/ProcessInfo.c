#include <jni.h>
#include <unistd.h>
#include "ProcessInfo.h"

JNIEXPORT jint JNICALL Java_ProcessInfo_getProcessID(JNIEnv *env, jobject obj) {
    return getpid();
}
