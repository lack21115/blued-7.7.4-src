package org.chromium.content.browser.input;

import android.os.SystemClock;

final class ThreadedInputConnection$14 implements Runnable {
  public final void run() {
    if (ThreadedInputConnection.access$400(ThreadedInputConnection.this) != 0)
      ThreadedInputConnection.access$200(ThreadedInputConnection.this); 
    ImeAdapterImpl imeAdapterImpl = ThreadedInputConnection.access$100(ThreadedInputConnection.this);
    int i = beforeLength;
    int j = afterLength;
    imeAdapterImpl.onImeEvent();
    if (imeAdapterImpl.isValid()) {
      imeAdapterImpl.nativeSendKeyEvent(imeAdapterImpl.mNativeImeAdapterAndroid, null, 7, 0, SystemClock.uptimeMillis(), 229, 0, false, 0);
      imeAdapterImpl.nativeDeleteSurroundingTextInCodePoints(imeAdapterImpl.mNativeImeAdapterAndroid, i, j);
      imeAdapterImpl.nativeSendKeyEvent(imeAdapterImpl.mNativeImeAdapterAndroid, null, 9, 0, SystemClock.uptimeMillis(), 229, 0, false, 0);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */