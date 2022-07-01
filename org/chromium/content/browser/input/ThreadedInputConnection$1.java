package org.chromium.content.browser.input;

final class ThreadedInputConnection$1 extends TextInputState {
  ThreadedInputConnection$1(CharSequence paramCharSequence, Range paramRange1, Range paramRange2, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramCharSequence, paramRange1, paramRange2, paramBoolean1, paramBoolean2);
  }
  
  public final boolean shouldUnblock() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */