package org.chromium.content.browser.input;

final class ThreadedInputConnection$12 implements Runnable {
  public final void run() {
    ImeAdapterImpl imeAdapterImpl = ThreadedInputConnection.access$100(ThreadedInputConnection.this);
    switch (id) {
      default:
        return;
      case 16908322:
        imeAdapterImpl.mWebContents.paste();
        return;
      case 16908321:
        imeAdapterImpl.mWebContents.copy();
        return;
      case 16908320:
        imeAdapterImpl.mWebContents.cut();
        return;
      case 16908319:
        break;
    } 
    imeAdapterImpl.mWebContents.selectAll();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */