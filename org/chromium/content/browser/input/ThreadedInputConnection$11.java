package org.chromium.content.browser.input;

final class ThreadedInputConnection$11 implements Runnable {
  public final void run() {
    ImeAdapterImpl imeAdapterImpl = ThreadedInputConnection.access$100(ThreadedInputConnection.this);
    int i = actionCode;
    if (imeAdapterImpl.isValid()) {
      if (i != 5) {
        if (i != 7) {
          imeAdapterImpl.sendSyntheticKeyPress(66, 22);
          return;
        } 
        imeAdapterImpl.advanceFocusInForm(2);
        return;
      } 
      imeAdapterImpl.advanceFocusInForm(1);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */