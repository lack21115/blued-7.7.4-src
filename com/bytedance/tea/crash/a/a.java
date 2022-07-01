package com.bytedance.tea.crash.a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;

public class a extends FileObserver {
  private final c a;
  
  private final int b = 5000;
  
  private volatile boolean c = true;
  
  public a(c paramc, String paramString, int paramInt) {
    super(paramString, paramInt);
    if (paramc != null && !TextUtils.isEmpty(paramString)) {
      this.a = paramc;
      return;
    } 
    throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
  }
  
  public void onEvent(int paramInt, String paramString) {
    if (this.c && paramInt == 8 && !TextUtils.isEmpty(paramString) && paramString.contains("trace")) {
      c c1 = this.a;
      if (c1 != null) {
        this.c = false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/anr/");
        stringBuilder.append(paramString);
        c1.a(200, stringBuilder.toString(), 80);
        getClass();
        (new a(this, 5000)).start();
      } 
    } 
  }
  
  final class a extends Thread {
    private int b;
    
    a(a this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void run() {
      SystemClock.sleep(this.b);
      a.a(this.a, true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */