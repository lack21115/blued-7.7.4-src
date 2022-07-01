package com.huawei.hms.framework.network.grs.c.b;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.c.e;
import java.util.concurrent.Future;

public class b {
  private Future<e> a;
  
  private long b;
  
  public b(Future<e> paramFuture) {
    this.a = paramFuture;
    this.b = SystemClock.elapsedRealtime();
  }
  
  public Future<e> a() {
    return this.a;
  }
  
  public boolean b() {
    return (SystemClock.elapsedRealtime() - this.b <= 300000L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */