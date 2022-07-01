package com.ss.android.socialbase.appdownloader.e.a;

import java.io.PrintStream;

public class h extends Exception {
  protected Throwable a;
  
  protected int b;
  
  protected int c;
  
  public h(String paramString, g paramg, Throwable paramThrowable) {
    super(stringBuilder.toString());
    String str1;
    this.b = -1;
    this.c = -1;
    if (paramg != null) {
      this.b = paramg.c();
      this.c = paramg.f();
    } 
    this.a = paramThrowable;
  }
  
  public void printStackTrace() {
    if (this.a == null) {
      super.printStackTrace();
      return;
    } 
    synchronized (System.err) {
      PrintStream printStream = System.err;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getMessage());
      stringBuilder.append("; nested exception is:");
      printStream.println(stringBuilder.toString());
      this.a.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\e\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */