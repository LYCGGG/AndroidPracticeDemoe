#include <jni.h>
#include <string>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_lyc_jnitestdemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_lyc_jnitestdemo_Test_getStringFromJNI(JNIEnv *env, jobject thiz) {
    std::string s = "test";
    return  env->NewStringUTF(s.c_str());
}