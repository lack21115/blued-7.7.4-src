package org.chromium.content.browser.input;

final class ThreadedInputConnectionFactory$CheckInvalidator {
  boolean mInvalid;
  
  private ThreadedInputConnectionFactory$CheckInvalidator() {}
  
  public final void invalidate() {
    ImeUtils.checkOnUiThread();
    this.mInvalid = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnectionFactory$CheckInvalidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */