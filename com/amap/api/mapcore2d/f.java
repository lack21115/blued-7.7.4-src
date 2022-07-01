package com.amap.api.mapcore2d;

import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;
import java.util.ArrayList;
import java.util.Vector;

abstract class f<T, V> extends aw {
  protected bo<T> a;
  
  private volatile boolean c = true;
  
  private Vector<Thread> d = null;
  
  private Runnable e = new Runnable(this) {
      public void run() {
        ArrayList arrayList;
        Thread thread = Thread.currentThread();
        if (thread != null)
          thread.setName("TaskRunDownLoad"); 
        try {
          if (f.a(this.a) != null)
            f.a(this.a).add(thread); 
        } finally {
          thread = null;
          cm.a((Throwable)thread, "AsyncServer", "run");
        } 
        while (true) {
          if (f.b(this.a) && !Thread.interrupted()) {
            ArrayList arrayList3;
            if (this.a.b == null) {
              f.a(this.a, false);
              continue;
            } 
            boolean bool = MapsInitializer.getNetworkEnable();
            if (!bool) {
              try {
                if (!Thread.interrupted())
                  Thread.sleep(200L); 
              } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
              } catch (Exception exception) {
                cm.a(exception, "AsyncServer", "run");
                Thread.currentThread().interrupt();
              } 
              continue;
            } 
            ArrayList arrayList2 = arrayList;
            if (this.a.a != null)
              arrayList2 = this.a.a.a(this.a.g(), false); 
            if (arrayList2 != null && arrayList2.size() == 0) {
              arrayList = arrayList2;
              continue;
            } 
            if (!f.b(this.a))
              return; 
            Thread thread1 = thread;
            if (arrayList2 != null) {
              ArrayList arrayList4;
              if (!f.b(this.a))
                return; 
              az az = this.a.b;
              if (az == null) {
                ArrayList arrayList5 = arrayList2;
                continue;
              } 
              try {
                ArrayList arrayList5 = this.a.a(arrayList2);
                arrayList4 = arrayList5;
              } catch (AMapException aMapException) {
                cm.a((Throwable)aMapException, "AsyncServer", "run");
              } 
              arrayList3 = arrayList4;
              if (arrayList4 != null) {
                arrayList3 = arrayList4;
                if (this.a.a != null) {
                  this.a.a.a(arrayList4, false);
                  arrayList3 = arrayList4;
                } 
              } 
            } 
            arrayList = arrayList2;
            ArrayList arrayList1 = arrayList3;
            if (f.b(this.a) == true) {
              bool = Thread.interrupted();
              arrayList = arrayList2;
              arrayList1 = arrayList3;
              if (!bool)
                try {
                  Thread.sleep(50L);
                  arrayList = arrayList2;
                  arrayList1 = arrayList3;
                } catch (InterruptedException interruptedException) {
                  Thread.currentThread().interrupt();
                  arrayList = arrayList2;
                  ArrayList arrayList4 = arrayList3;
                } catch (Exception exception) {
                  cm.a(exception, "AsyncServer", "run");
                  arrayList = arrayList2;
                  ArrayList arrayList4 = arrayList3;
                }  
            } 
            continue;
          } 
          return;
        } 
      }
    };
  
  private Runnable f = new Runnable(this) {
      public void run() {
        Exception exception;
        Thread thread2;
        Thread thread1 = Thread.currentThread();
        if (thread1 != null)
          thread1.setName("TaskRunCach"); 
        try {
          if (f.a(this.a) != null && thread1 != null)
            f.a(this.a).add(thread1); 
        } finally {
          thread1 = null;
          cm.a((Throwable)thread1, "AsyncServer", "run");
        } 
        while (true) {
          if (f.b(this.a) && !Thread.interrupted()) {
            ArrayList arrayList1;
            Exception exception1;
            ArrayList arrayList2;
            if (this.a.b == null) {
              f.a(this.a, false);
              continue;
            } 
            thread1 = thread2;
            if (this.a.a != null)
              arrayList1 = this.a.a.a(this.a.g(), true); 
            if (arrayList1 != null && arrayList1.size() == 0) {
              ArrayList arrayList = arrayList1;
              continue;
            } 
            boolean bool = f.b(this.a);
            if (!bool)
              return; 
            try {
              ArrayList arrayList = this.a.b(arrayList1);
            } finally {
              exception1 = null;
              cm.a(exception1, "AsyncServer", "run");
            } 
            exception = exception1;
            if (f.b(this.a) == true) {
              bool = Thread.interrupted();
              arrayList2 = arrayList1;
              exception = exception1;
              if (!bool)
                try {
                
                } catch (InterruptedException interruptedException) {
                
                } finally {
                  exception = null;
                  cm.a(exception, "AsyncServer", "run");
                  arrayList2 = arrayList1;
                }  
            } 
            continue;
          } 
          return;
        } 
      }
    };
  
  private bq g;
  
  public f(az paramaz) {
    super(paramaz);
  }
  
  protected abstract ArrayList<T> a(ArrayList<T> paramArrayList) throws AMapException;
  
  protected void a() {
    if (this.d == null)
      this.d = new Vector<Thread>(); 
    this.g = new bq(f(), this.f, this.e);
    this.g.a();
  }
  
  protected abstract ArrayList<T> b(ArrayList<T> paramArrayList) throws AMapException;
  
  public void b() {
    bo<T> bo1 = this.a;
    if (bo1 != null)
      bo1.a(); 
    e();
    bo1 = this.a;
    if (bo1 != null)
      bo1.b(); 
    this.a = null;
    this.f = null;
    this.e = null;
    this.b = null;
  }
  
  public void c() {
    super.c();
    e();
  }
  
  public void d() {
    try {
      if (this.c == true)
        return; 
      this.c = true;
      if (this.d == null)
        this.d = new Vector<Thread>(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void e() {
    try {
      this.c = false;
      if (this.d != null) {
        int j = this.d.size();
        for (int i = 0;; i++) {
          if (i < j) {
            Thread thread = this.d.get(0);
            if (thread != null) {
              thread.interrupt();
              this.d.remove(0);
            } 
          } else {
            this.d = null;
            if (this.g != null) {
              this.g.b();
              return;
            } 
          } 
        } 
      } 
    } finally {
      Exception exception = null;
    } 
  }
  
  protected abstract int f();
  
  protected abstract int g();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */