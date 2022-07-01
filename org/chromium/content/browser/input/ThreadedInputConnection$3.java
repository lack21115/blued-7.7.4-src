package org.chromium.content.browser.input;

final class ThreadedInputConnection$3 implements Runnable {
  public final void run() {
    ImeAdapterImpl imeAdapterImpl = ThreadedInputConnection.access$100(ThreadedInputConnection.this);
    boolean bool2 = imeAdapterImpl.isValid();
    boolean bool1 = false;
    if (bool2 && imeAdapterImpl.mInputConnection != null)
      bool1 = imeAdapterImpl.nativeRequestTextInputStateUpdate(imeAdapterImpl.mNativeImeAdapterAndroid); 
    if (!bool1)
      ThreadedInputConnection.this.unblockOnUiThread(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */