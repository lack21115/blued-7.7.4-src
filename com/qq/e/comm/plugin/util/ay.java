package com.qq.e.comm.plugin.util;

import android.os.SystemClock;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;

public final class ay {
  private final int a;
  
  private final int b;
  
  private int c;
  
  private int d;
  
  private long e = -1L;
  
  private final String f;
  
  public ay(int paramInt1, int paramInt2, String paramString) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = paramString;
    paramInt1 = this.a;
    this.c = paramInt1;
    this.d = paramInt1;
  }
  
  public int a() {
    return this.c;
  }
  
  public boolean b() {
    if (this.e == -1L) {
      this.e = SystemClock.elapsedRealtime();
      return false;
    } 
    int j = GDTADManager.getInstance().getSM().getInteger(this.f, this.a);
    if (j != this.c) {
      int m = this.b;
      int k = j;
      if (j < m)
        k = m; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("throttling new value:");
      stringBuilder1.append(k);
      stringBuilder1.append(" old:");
      stringBuilder1.append(this.c);
      GDTLogger.d(stringBuilder1.toString());
      this.e = SystemClock.elapsedRealtime();
      this.c = k;
      this.d = this.c;
    } 
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.e;
    this.e = l1;
    double d = (l1 - l2) * this.c / 60000.0D;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("throttling old:");
    stringBuilder.append(this.d);
    stringBuilder.append(" increase:");
    stringBuilder.append(d);
    GDTLogger.d(stringBuilder.toString());
    this.d = (int)(d + this.d);
    int i = this.d;
    j = this.c;
    if (i > j)
      this.d = j; 
    i = this.d;
    if (i < 1)
      return true; 
    this.d = i - 1;
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */