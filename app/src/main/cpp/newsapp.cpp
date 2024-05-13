#include <jni.h>
#include <string>
#include <iostream>
#include <locale.h>

// Include Android-specific text-to-speech headers
#include <android/log.h>
#include <android/native_activity.h>
#include <jni.h>

// Global variable to hold the TextToSpeech object
jobject textToSpeechObj = nullptr;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_newsapp_TalkBackData_MainViewModel_nativeTextToSpeech(JNIEnv *env, jobject obj,
                                                                       jstring text) {
    const char *nativeString = env->GetStringUTFChars(text, nullptr);

    // Call Android's TextToSpeech API to speak the text
    JNIEnv *envNew = nullptr;
    JavaVM *vm;
    env->GetJavaVM(&vm);
    vm->AttachCurrentThread(&envNew, nullptr);

    jclass clazz = envNew->FindClass("android/speech/tts/TextToSpeech");
    jmethodID initMethod = envNew->GetMethodID(clazz, "<init>", "(Landroid/content/Context;Landroid/speech/tts/TextToSpeech$OnInitListener;)V");
    jmethodID speakMethod = envNew->GetMethodID(clazz, "speak", "(Ljava/lang/CharSequence;ILandroid/os/Bundle;Ljava/lang/String;)I");

    // Release previous TextToSpeech object if exists
    if (textToSpeechObj != nullptr) {
        envNew->DeleteGlobalRef(textToSpeechObj);
        textToSpeechObj = nullptr;
    }

//    textToSpeechObj = envNew->NewGlobalRef(env->NewObject(clazz, initMethod, obj, nullptr));
    jstring textString = envNew->NewStringUTF(nativeString);
//    jint result = envNew->CallIntMethod(textToSpeechObj, speakMethod, textString, 0, nullptr, nullptr);

    envNew->DeleteLocalRef(textString);

    vm->DetachCurrentThread();

    env->ReleaseStringUTFChars(text, nativeString);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_newsapp_TalkBackData_MainViewModel_nativeStopReading(JNIEnv *env, jobject thiz) {
    if (textToSpeechObj != nullptr) {
        JNIEnv *envNew = nullptr;
        JavaVM *vm;
        env->GetJavaVM(&vm);
        vm->AttachCurrentThread(&envNew, nullptr);

        jclass clazz = envNew->FindClass("android/speech/tts/TextToSpeech");
        jmethodID stopMethod = envNew->GetMethodID(clazz, "stop", "()I");
        envNew->CallIntMethod(textToSpeechObj, stopMethod);

        vm->DetachCurrentThread();
    }
}
