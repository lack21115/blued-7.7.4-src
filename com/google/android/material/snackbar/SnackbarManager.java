package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class SnackbarManager {
  private static SnackbarManager a;
  
  private final Object b = new Object();
  
  private final Handler c = new Handler(Looper.getMainLooper(), new Handler.Callback(this) {
        public boolean handleMessage(Message param1Message) {
          if (param1Message.what != 0)
            return false; 
          this.a.a((SnackbarManager.SnackbarRecord)param1Message.obj);
          return true;
        }
      });
  
  private SnackbarRecord d;
  
  private SnackbarRecord e;
  
  static SnackbarManager a() {
    if (a == null)
      a = new SnackbarManager(); 
    return a;
  }
  
  private boolean a(SnackbarRecord paramSnackbarRecord, int paramInt) {
    Callback callback = paramSnackbarRecord.a.get();
    if (callback != null) {
      this.c.removeCallbacksAndMessages(paramSnackbarRecord);
      callback.a(paramInt);
      return true;
    } 
    return false;
  }
  
  private void b() {
    SnackbarRecord snackbarRecord = this.e;
    if (snackbarRecord != null) {
      this.d = snackbarRecord;
      this.e = null;
      Callback callback = this.d.a.get();
      if (callback != null) {
        callback.a();
        return;
      } 
      this.d = null;
    } 
  }
  
  private void b(SnackbarRecord paramSnackbarRecord) {
    if (paramSnackbarRecord.b == -2)
      return; 
    int i = 2750;
    if (paramSnackbarRecord.b > 0) {
      i = paramSnackbarRecord.b;
    } else if (paramSnackbarRecord.b == -1) {
      i = 1500;
    } 
    this.c.removeCallbacksAndMessages(paramSnackbarRecord);
    Handler handler = this.c;
    handler.sendMessageDelayed(Message.obtain(handler, 0, paramSnackbarRecord), i);
  }
  
  private boolean f(Callback paramCallback) {
    SnackbarRecord snackbarRecord = this.d;
    return (snackbarRecord != null && snackbarRecord.a(paramCallback));
  }
  
  private boolean g(Callback paramCallback) {
    SnackbarRecord snackbarRecord = this.e;
    return (snackbarRecord != null && snackbarRecord.a(paramCallback));
  }
  
  public void a(Callback paramCallback) {
    synchronized (this.b) {
      if (f(paramCallback)) {
        this.d = null;
        if (this.e != null)
          b(); 
      } 
      return;
    } 
  }
  
  public void a(Callback paramCallback, int paramInt) {
    synchronized (this.b) {
      if (f(paramCallback)) {
        a(this.d, paramInt);
      } else if (g(paramCallback)) {
        a(this.e, paramInt);
      } 
      return;
    } 
  }
  
  void a(SnackbarRecord paramSnackbarRecord) {
    synchronized (this.b) {
      if (this.d == paramSnackbarRecord || this.e == paramSnackbarRecord)
        a(paramSnackbarRecord, 2); 
      return;
    } 
  }
  
  public void b(Callback paramCallback) {
    synchronized (this.b) {
      if (f(paramCallback))
        b(this.d); 
      return;
    } 
  }
  
  public void c(Callback paramCallback) {
    synchronized (this.b) {
      if (f(paramCallback) && !this.d.c) {
        this.d.c = true;
        this.c.removeCallbacksAndMessages(this.d);
      } 
      return;
    } 
  }
  
  public void d(Callback paramCallback) {
    synchronized (this.b) {
      if (f(paramCallback) && this.d.c) {
        this.d.c = false;
        b(this.d);
      } 
      return;
    } 
  }
  
  public boolean e(Callback paramCallback) {
    synchronized (this.b) {
      if (f(paramCallback) || g(paramCallback))
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  static interface Callback {
    void a();
    
    void a(int param1Int);
  }
  
  static class SnackbarRecord {
    final WeakReference<SnackbarManager.Callback> a;
    
    int b;
    
    boolean c;
    
    boolean a(SnackbarManager.Callback param1Callback) {
      return (param1Callback != null && this.a.get() == param1Callback);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\snackbar\SnackbarManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */