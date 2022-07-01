package org.chromium.content.browser.input;

final class ThreadedInputConnection$17 implements Runnable {
  public final void run() {
    ImeAdapterImpl imeAdapterImpl = ThreadedInputConnection.access$100(ThreadedInputConnection.this);
    int i = start;
    int j = end;
    if (imeAdapterImpl.isValid()) {
      if (i <= j) {
        imeAdapterImpl.nativeSetComposingRegion(imeAdapterImpl.mNativeImeAdapterAndroid, i, j);
        return;
      } 
      imeAdapterImpl.nativeSetComposingRegion(imeAdapterImpl.mNativeImeAdapterAndroid, j, i);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */