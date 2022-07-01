package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

public final class c extends CancellationToken {
  public final List<Runnable> a = new ArrayList<Runnable>();
  
  public final Object b = new Object();
  
  public boolean c = false;
  
  public final CancellationToken a(Runnable paramRunnable) {
    synchronized (this.b) {
      if (this.c) {
        paramRunnable.run();
      } else {
        this.a.add(paramRunnable);
      } 
      return this;
    } 
  }
  
  public final boolean a() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */