package com.example.newsapp.TalkBackData;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u000e\u001a\u00020\u000fH\u0086 J\u0011\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0086 J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/newsapp/TalkBackData/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fileContent", "Landroidx/compose/runtime/MutableState;", "", "getFileContent", "()Landroidx/compose/runtime/MutableState;", "setFileContent", "(Landroidx/compose/runtime/MutableState;)V", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "nativeStopReading", "", "nativeTextToSpeech", "text", "readConten", "readContent", "readFileContent", "line", "stopReadin", "stopReading", "Companion", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.MutableState<java.lang.String> fileContent;
    @org.jetbrains.annotations.Nullable
    private android.speech.tts.TextToSpeech textToSpeech;
    @org.jetbrains.annotations.NotNull
    public static final com.example.newsapp.TalkBackData.MainViewModel.Companion Companion = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getFileContent() {
        return null;
    }
    
    public final void setFileContent(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    public final native void nativeTextToSpeech(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final native void nativeStopReading() {
    }
    
    public final void readFileContent(@org.jetbrains.annotations.NotNull
    java.lang.String line) {
    }
    
    public final void readContent() {
    }
    
    public final void stopReading() {
    }
    
    public final void readConten() {
    }
    
    public final void stopReadin() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/newsapp/TalkBackData/MainViewModel$Companion;", "", "()V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}