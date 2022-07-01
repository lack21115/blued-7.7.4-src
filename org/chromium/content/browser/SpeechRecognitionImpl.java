package org.chromium.content.browser;

import android.content.ComponentName;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

public class SpeechRecognitionImpl {
  private static ComponentName sRecognitionProvider;
  
  private boolean mContinuous = false;
  
  private final Intent mIntent;
  
  private final RecognitionListener mListener;
  
  private long mNativeSpeechRecognizerImplAndroid;
  
  private SpeechRecognizer mRecognizer;
  
  private int mState;
  
  private SpeechRecognitionImpl(long paramLong) {
    this.mNativeSpeechRecognizerImplAndroid = paramLong;
    this.mListener = new SpeechRecognitionImpl$Listener(this);
    this.mIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    if (sRecognitionProvider != null) {
      this.mRecognizer = SpeechRecognizer.createSpeechRecognizer(ContextUtils.sApplicationContext, sRecognitionProvider);
    } else {
      this.mRecognizer = SpeechRecognizer.createSpeechRecognizer(ContextUtils.sApplicationContext);
    } 
    this.mRecognizer.setRecognitionListener(this.mListener);
  }
  
  @CalledByNative
  private void abortRecognition() {
    if (this.mRecognizer == null)
      return; 
    this.mRecognizer.cancel();
    terminate(2);
  }
  
  @CalledByNative
  private static SpeechRecognitionImpl createSpeechRecognition(long paramLong) {
    return new SpeechRecognitionImpl(paramLong);
  }
  
  private native void nativeOnAudioEnd(long paramLong);
  
  private native void nativeOnAudioStart(long paramLong);
  
  private native void nativeOnRecognitionEnd(long paramLong);
  
  private native void nativeOnRecognitionError(long paramLong, int paramInt);
  
  private native void nativeOnRecognitionResults(long paramLong, String[] paramArrayOfString, float[] paramArrayOffloat, boolean paramBoolean);
  
  private native void nativeOnSoundEnd(long paramLong);
  
  private native void nativeOnSoundStart(long paramLong);
  
  @CalledByNative
  private void startRecognition(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mRecognizer == null)
      return; 
    this.mContinuous = paramBoolean1;
    this.mIntent.putExtra("android.speech.extra.DICTATION_MODE", paramBoolean1);
    this.mIntent.putExtra("android.speech.extra.LANGUAGE", paramString);
    this.mIntent.putExtra("android.speech.extra.PARTIAL_RESULTS", paramBoolean2);
    this.mRecognizer.startListening(this.mIntent);
  }
  
  @CalledByNative
  private void stopRecognition() {
    if (this.mRecognizer == null)
      return; 
    this.mContinuous = false;
    this.mRecognizer.stopListening();
  }
  
  private void terminate(int paramInt) {
    if (this.mNativeSpeechRecognizerImplAndroid == 0L)
      return; 
    if (this.mState != 0) {
      if (this.mState == 2)
        nativeOnSoundEnd(this.mNativeSpeechRecognizerImplAndroid); 
      nativeOnAudioEnd(this.mNativeSpeechRecognizerImplAndroid);
      this.mState = 0;
    } 
    if (paramInt != 0)
      nativeOnRecognitionError(this.mNativeSpeechRecognizerImplAndroid, paramInt); 
    try {
      this.mRecognizer.destroy();
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder("Destroy threw exception ");
      stringBuilder.append(this.mRecognizer);
      Log.w("SpeechRecog", stringBuilder.toString(), new Object[] { illegalArgumentException });
    } 
    this.mRecognizer = null;
    nativeOnRecognitionEnd(this.mNativeSpeechRecognizerImplAndroid);
    this.mNativeSpeechRecognizerImplAndroid = 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\SpeechRecognitionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */