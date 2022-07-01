package com.android.webview.chromium;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executor;

final class TracingControllerAdapter$4 extends OutputStream {
  public final void close() {
    executor.execute(new TracingControllerAdapter$4$$Lambda$1(localOutputStream));
  }
  
  public final void flush() {}
  
  public final void write(int paramInt) {}
  
  public final void write(byte[] paramArrayOfbyte) {
    executor.execute(new TracingControllerAdapter$4$$Lambda$0(localOutputStream, paramArrayOfbyte));
  }
  
  public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\TracingControllerAdapter$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */