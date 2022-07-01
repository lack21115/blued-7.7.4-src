package com.bytedance.tea.crash.d;

import android.os.SystemClock;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.e;
import com.bytedance.tea.crash.f;
import com.bytedance.tea.crash.g.m;
import com.bytedance.tea.crash.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class a implements Thread.UncaughtExceptionHandler {
  private static a a;
  
  private Thread.UncaughtExceptionHandler b;
  
  private HashSet<Thread.UncaughtExceptionHandler> c = new HashSet<Thread.UncaughtExceptionHandler>();
  
  private b d;
  
  private long e = -1L;
  
  private a() {
    c();
    b();
  }
  
  public static a a() {
    if (a == null)
      a = new a(); 
    return a;
  }
  
  private boolean a(Thread paramThread, Throwable paramThrowable) {
    f f = h.b().d();
    boolean bool = true;
    if (f != null)
      try {
        return bool;
      } finally {
        paramThread = null;
      }  
    return bool;
  }
  
  private void b() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void b(Thread paramThread, Throwable paramThrowable) {
    List list = h.b().b();
    c c = c.b;
    for (e e : list) {
      try {
        e.a(c, m.a(paramThrowable), paramThread);
      } finally {
        e = null;
      } 
    } 
  }
  
  private void c() {
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    if (uncaughtExceptionHandler != this) {
      Thread.setDefaultUncaughtExceptionHandler(this);
      if (this.b == null) {
        this.b = uncaughtExceptionHandler;
        return;
      } 
      this.c.add(uncaughtExceptionHandler);
    } 
  }
  
  private void c(Thread paramThread, Throwable paramThrowable) {
    try {
      Iterator<Thread.UncaughtExceptionHandler> iterator = this.c.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Thread.UncaughtExceptionHandler uncaughtExceptionHandler = iterator.next();
          try {
            uncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
          } finally {}
          continue;
        } 
        return;
      } 
    } finally {
      paramThread = null;
    } 
  }
  
  public void a(b paramb) {
    this.d = paramb;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (SystemClock.uptimeMillis() - this.e < 20000L)
      return; 
    long l = System.currentTimeMillis();
    try {
      this.e = SystemClock.uptimeMillis();
      boolean bool = a(paramThread, paramThrowable);
      if (!bool)
        return; 
      c c = c.b;
      b(paramThread, paramThrowable);
    } finally {
      null = null;
    } 
    c(paramThread, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */