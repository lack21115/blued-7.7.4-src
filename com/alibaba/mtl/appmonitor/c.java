package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class c implements Runnable {
  private static Map<Integer, c> c;
  
  private static boolean j = false;
  
  private int d = 180000;
  
  private int e;
  
  private long startTime;
  
  private c(int paramInt1, int paramInt2) {
    this.e = paramInt1;
    this.d = paramInt2;
    this.startTime = System.currentTimeMillis();
  }
  
  private static int a(int paramInt) {
    if (paramInt != 65133) {
      switch (paramInt) {
        default:
          return 0;
        case 65503:
          return 10;
        case 65502:
          return 9;
        case 65501:
          break;
      } 
      return 6;
    } 
    return 11;
  }
  
  static void a(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[setStatisticsInterval] eventId");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" statisticsInterval:");
    stringBuilder.append(paramInt2);
    i.a("CommitTask", new Object[] { stringBuilder.toString() });
    synchronized (c) {
      c c1 = c.get(Integer.valueOf(paramInt1));
      if (c1 == null) {
        if (paramInt2 > 0) {
          c1 = new c(paramInt1, paramInt2 * 1000);
          c.put(Integer.valueOf(paramInt1), c1);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("post next eventId");
          stringBuilder1.append(paramInt1);
          stringBuilder1.append(": uploadTask.interval ");
          stringBuilder1.append(c1.d);
          i.a("CommitTask", new Object[] { stringBuilder1.toString() });
          r.a().a(a(paramInt1), c1, c1.d);
        } 
      } else if (paramInt2 > 0) {
        int i = c1.d;
        paramInt2 *= 1000;
        if (i != paramInt2) {
          r.a().f(a(paramInt1));
          c1.d = paramInt2;
          long l3 = System.currentTimeMillis();
          long l2 = c1.d - l3 - c1.startTime;
          long l1 = l2;
          if (l2 < 0L)
            l1 = 0L; 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(c1);
          stringBuilder1.append("post next eventId");
          stringBuilder1.append(paramInt1);
          stringBuilder1.append(" next:");
          stringBuilder1.append(l1);
          stringBuilder1.append("  uploadTask.interval: ");
          stringBuilder1.append(c1.d);
          i.a("CommitTask", new Object[] { stringBuilder1.toString() });
          r.a().a(a(paramInt1), c1, l1);
          c1.startTime = l3;
        } 
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("uploadTasks.size:");
        stringBuilder1.append(c.size());
        i.a("CommitTask", new Object[] { stringBuilder1.toString() });
        c.remove(Integer.valueOf(paramInt1));
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("uploadTasks.size:");
        stringBuilder1.append(c.size());
        i.a("CommitTask", new Object[] { stringBuilder1.toString() });
      } 
      return;
    } 
  }
  
  static void destroy() {
    for (f f : f.a())
      r.a().f(a(f.a())); 
    j = false;
    c = null;
  }
  
  static void e() {
    for (f f : f.a())
      e.a().a(f.a()); 
  }
  
  static void init() {
    if (!j) {
      int i = 0;
      i.a("CommitTask", new Object[] { "init StatisticsAlarmEvent" });
      c = new ConcurrentHashMap<Integer, c>();
      f[] arrayOfF = f.a();
      int j = arrayOfF.length;
      while (i < j) {
        f f = arrayOfF[i];
        if (f.isOpen()) {
          int k = f.a();
          c c1 = new c(k, f.c() * 1000);
          c.put(Integer.valueOf(k), c1);
          r.a().a(a(k), c1, c1.d);
        } 
        i++;
      } 
      j = true;
    } 
  }
  
  public void run() {
    i.a("CommitTask", new Object[] { "check&commit event:", Integer.valueOf(this.e) });
    e.a().a(this.e);
    if (c.containsValue(this)) {
      this.startTime = System.currentTimeMillis();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("next:");
      stringBuilder.append(this.e);
      i.a("CommitTask", new Object[] { stringBuilder.toString() });
      r.a().a(a(this.e), this, this.d);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */