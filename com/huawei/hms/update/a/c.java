package com.huawei.hms.update.a;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.utils.Checker;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class c implements a {
  private static final Executor a = Executors.newSingleThreadExecutor();
  
  private final a b;
  
  public c(a parama) {
    Checker.checkNonNull(parama, "update must not be null.");
    this.b = parama;
  }
  
  private static b b(b paramb) {
    return new b(paramb) {
        public void a(int param1Int1, int param1Int2, int param1Int3, File param1File) {
          (new Handler(Looper.getMainLooper())).post(new Runnable(this, param1Int1, param1Int2, param1Int3, param1File) {
                public void run() {
                  this.e.a.a(this.a, this.b, this.c, this.d);
                }
              });
        }
        
        public void a(int param1Int, c param1c) {
          (new Handler(Looper.getMainLooper())).post(new Runnable(this, param1Int, param1c) {
                public void run() {
                  this.c.a.a(this.a, this.b);
                }
              });
        }
      };
  }
  
  public void a() {
    this.b.a();
  }
  
  public void a(b paramb, c paramc) {
    a.execute(new Runnable(this, paramb, paramc) {
          public void run() {
            c.a(this.c).a(c.a(this.a), this.b);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */