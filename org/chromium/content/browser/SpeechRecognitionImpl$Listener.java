package org.chromium.content.browser;

import android.os.Bundle;
import android.speech.RecognitionListener;
import java.util.ArrayList;

final class SpeechRecognitionImpl$Listener implements RecognitionListener {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private void handleResults(Bundle paramBundle, boolean paramBoolean) {
    if (SpeechRecognitionImpl.access$300(SpeechRecognitionImpl.this) && paramBoolean)
      paramBoolean = false; 
    ArrayList arrayList = paramBundle.getStringArrayList("results_recognition");
    String[] arrayOfString = (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
    float[] arrayOfFloat = paramBundle.getFloatArray("confidence_scores");
    SpeechRecognitionImpl.access$800(SpeechRecognitionImpl.this, SpeechRecognitionImpl.access$100(SpeechRecognitionImpl.this), arrayOfString, arrayOfFloat, paramBoolean);
  }
  
  public final void onBeginningOfSpeech() {
    SpeechRecognitionImpl.access$002(SpeechRecognitionImpl.this, 2);
    SpeechRecognitionImpl.access$200(SpeechRecognitionImpl.this, SpeechRecognitionImpl.access$100(SpeechRecognitionImpl.this));
  }
  
  public final void onBufferReceived(byte[] paramArrayOfbyte) {}
  
  public final void onEndOfSpeech() {
    if (!SpeechRecognitionImpl.access$300(SpeechRecognitionImpl.this)) {
      SpeechRecognitionImpl.access$400(SpeechRecognitionImpl.this, SpeechRecognitionImpl.access$100(SpeechRecognitionImpl.this));
      SpeechRecognitionImpl.access$500(SpeechRecognitionImpl.this, SpeechRecognitionImpl.access$100(SpeechRecognitionImpl.this));
      SpeechRecognitionImpl.access$002(SpeechRecognitionImpl.this, 0);
    } 
  }
  
  public final void onError(int paramInt) {
    switch (paramInt) {
      default:
        assert false;
        throw new AssertionError();
      case 8:
      case 9:
        paramInt = 5;
        break;
      case 7:
        paramInt = 9;
        break;
      case 6:
        paramInt = 1;
        break;
      case 5:
        paramInt = 2;
        break;
      case 3:
        paramInt = 3;
        break;
      case 1:
      case 2:
      case 4:
        paramInt = 4;
        break;
    } 
    SpeechRecognitionImpl.access$600(SpeechRecognitionImpl.this, paramInt);
  }
  
  public final void onEvent(int paramInt, Bundle paramBundle) {}
  
  public final void onPartialResults(Bundle paramBundle) {
    handleResults(paramBundle, true);
  }
  
  public final void onReadyForSpeech(Bundle paramBundle) {
    SpeechRecognitionImpl.access$002(SpeechRecognitionImpl.this, 1);
    SpeechRecognitionImpl.access$700(SpeechRecognitionImpl.this, SpeechRecognitionImpl.access$100(SpeechRecognitionImpl.this));
  }
  
  public final void onResults(Bundle paramBundle) {
    handleResults(paramBundle, false);
    SpeechRecognitionImpl.access$600(SpeechRecognitionImpl.this, 0);
  }
  
  public final void onRmsChanged(float paramFloat) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\SpeechRecognitionImpl$Listener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */