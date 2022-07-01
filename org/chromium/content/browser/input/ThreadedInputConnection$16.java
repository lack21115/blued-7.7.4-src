package org.chromium.content.browser.input;

final class ThreadedInputConnection$16 implements Runnable {
  public final void run() {
    ImeAdapterImpl imeAdapterImpl = ThreadedInputConnection.access$100(ThreadedInputConnection.this);
    int i = start;
    int j = end;
    if (imeAdapterImpl.isValid())
      imeAdapterImpl.nativeSetEditableSelectionOffsets(imeAdapterImpl.mNativeImeAdapterAndroid, i, j); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */