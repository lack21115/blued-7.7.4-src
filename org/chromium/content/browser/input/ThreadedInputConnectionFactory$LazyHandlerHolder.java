package org.chromium.content.browser.input;

import android.os.Handler;
import android.os.HandlerThread;

final class ThreadedInputConnectionFactory$LazyHandlerHolder {
  private static final Handler sHandler;
  
  static {
    new HandlerThread("InputConnectionHandlerThread", 5);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnectionFactory$LazyHandlerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */