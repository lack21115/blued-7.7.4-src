package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
  private final Object a;
  
  private final int b;
  
  private final i<Void> c;
  
  private int d;
  
  private Exception e;
  
  private boolean f;
  
  private void b() {
    if (this.d >= this.b) {
      Exception exception = this.e;
      if (exception != null) {
        this.c.a(new ExecutionException("a task failed", exception));
        return;
      } 
      if (this.f) {
        this.c.f();
        return;
      } 
      this.c.a((Void)null);
    } 
  }
  
  public final void a() {
    synchronized (this.a) {
      this.d++;
      this.f = true;
      b();
      return;
    } 
  }
  
  public final void a(Exception paramException) {
    synchronized (this.a) {
      this.d++;
      this.e = paramException;
      b();
      return;
    } 
  }
  
  public final void a(TResult paramTResult) {
    synchronized (this.a) {
      this.d++;
      b();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */