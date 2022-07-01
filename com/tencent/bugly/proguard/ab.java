package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

public final class ab extends Thread {
  private boolean a = false;
  
  private List<aa> b = new ArrayList<aa>();
  
  private List<ac> c = new ArrayList<ac>();
  
  private ArrayList<aa> d = new ArrayList<aa>();
  
  private void a(Handler paramHandler, long paramLong) {
    if (paramHandler == null) {
      x.e("addThread handler should not be null", new Object[0]);
      return;
    } 
    String str = paramHandler.getLooper().getThread().getName();
    int i = 0;
    try {
      while (i < this.b.size()) {
        if (((aa)this.b.get(i)).d().equals(paramHandler.getLooper().getThread().getName())) {
          x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
          return;
        } 
        i++;
      } 
    } catch (Exception exception) {
      x.b(exception);
    } 
    this.b.add(new aa(paramHandler, str, 5000L));
  }
  
  private int e() {
    int k;
    int j = 0;
    int i = 0;
    while (true) {
      k = i;
      try {
        if (j < this.b.size()) {
          i = Math.max(k, ((aa)this.b.get(j)).c());
          j++;
          continue;
        } 
      } catch (Exception exception) {
        x.b(exception);
      } 
      break;
    } 
    return k;
  }
  
  public final void a() {
    a(new Handler(Looper.getMainLooper()), 5000L);
  }
  
  public final void a(ac paramac) {
    if (this.c.contains(paramac)) {
      x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
      return;
    } 
    this.c.add(paramac);
  }
  
  public final void b() {
    int i = 0;
    try {
      while (i < this.b.size()) {
        if (((aa)this.b.get(i)).d().equals(Looper.getMainLooper().getThread().getName())) {
          x.c("remove handler::%s", new Object[] { this.b.get(i) });
          this.b.remove(i);
        } 
        i++;
      } 
      return;
    } catch (Exception exception) {
      x.b(exception);
      return;
    } 
  }
  
  public final void b(ac paramac) {
    this.c.remove(paramac);
  }
  
  public final boolean c() {
    this.a = true;
    if (!isAlive())
      return false; 
    try {
      interrupt();
      return true;
    } catch (Exception exception) {
      x.b(exception);
      return true;
    } 
  }
  
  public final boolean d() {
    if (isAlive())
      return false; 
    try {
      start();
      return true;
    } catch (Exception exception) {
      x.b(exception);
      return false;
    } 
  }
  
  public final void run() {
    while (true) {
      if (!this.a) {
        int j = 0;
        try {
          while (j < this.b.size()) {
            ((aa)this.b.get(j)).a();
            j++;
          } 
          long l2 = SystemClock.uptimeMillis();
          long l1;
          for (l1 = 2000L; l1 > 0L && !isInterrupted(); l1 = 2000L - SystemClock.uptimeMillis() - l2)
            sleep(l1); 
          j = e();
          if (j == 0 || j == 1)
            continue; 
          this.d.clear();
          for (j = 0; j < this.b.size(); j++) {
            aa aa = this.b.get(j);
            if (aa.b()) {
              this.d.add(aa);
              aa.a(Long.MAX_VALUE);
            } 
          } 
        } catch (Exception exception) {
          x.b(exception);
          continue;
        } catch (OutOfMemoryError outOfMemoryError) {
          x.b(outOfMemoryError);
          continue;
        } 
      } else {
        return;
      } 
      int i = 0;
      boolean bool = false;
      label48: while (i < this.d.size()) {
        aa aa = this.d.get(i);
        for (int j = 0;; j++) {
          if (j < this.c.size()) {
            if (((ac)this.c.get(j)).a(aa))
              bool = true; 
          } else {
            if (!bool) {
              aa.f();
              x.c("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
            } 
            i++;
            continue label48;
          } 
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */