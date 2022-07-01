package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class i<TResult> extends Task<TResult> {
  private final Object a = new Object();
  
  private boolean b;
  
  private volatile boolean c;
  
  private TResult d;
  
  private Exception e;
  
  private List<ExecuteResult<TResult>> f = new ArrayList<ExecuteResult<TResult>>();
  
  private Task<TResult> a(ExecuteResult<TResult> paramExecuteResult) {
    synchronized (this.a) {
      boolean bool = a();
      if (!bool)
        this.f.add(paramExecuteResult); 
      if (bool)
        paramExecuteResult.a(this); 
      return this;
    } 
  }
  
  private void g() {
    synchronized (this.a) {
      Iterator<ExecuteResult<TResult>> iterator = this.f.iterator();
      while (iterator.hasNext()) {
        ExecuteResult executeResult = iterator.next();
        try {
          executeResult.a(this);
        } catch (RuntimeException runtimeException) {
          throw runtimeException;
        } catch (Exception exception) {
          throw new RuntimeException(exception);
        } 
      } 
      this.f = null;
      return;
    } 
  }
  
  public final Task<TResult> a(OnCompleteListener<TResult> paramOnCompleteListener) {
    return a(TaskExecutors.a(), paramOnCompleteListener);
  }
  
  public final Task<TResult> a(OnFailureListener paramOnFailureListener) {
    return a(TaskExecutors.a(), paramOnFailureListener);
  }
  
  public final Task<TResult> a(OnSuccessListener<TResult> paramOnSuccessListener) {
    return a(TaskExecutors.a(), paramOnSuccessListener);
  }
  
  public final Task<TResult> a(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener) {
    return a(new d<TResult>(paramExecutor, paramOnCompleteListener));
  }
  
  public final Task<TResult> a(Executor paramExecutor, OnFailureListener paramOnFailureListener) {
    return a(new f<TResult>(paramExecutor, paramOnFailureListener));
  }
  
  public final Task<TResult> a(Executor paramExecutor, OnSuccessListener<TResult> paramOnSuccessListener) {
    return a(new h<TResult>(paramExecutor, paramOnSuccessListener));
  }
  
  public final void a(Exception paramException) {
    synchronized (this.a) {
      if (this.b)
        return; 
      this.b = true;
      this.e = paramException;
      this.a.notifyAll();
      g();
      return;
    } 
  }
  
  public final void a(TResult paramTResult) {
    synchronized (this.a) {
      if (this.b)
        return; 
      this.b = true;
      this.d = paramTResult;
      this.a.notifyAll();
      g();
      return;
    } 
  }
  
  public final boolean a() {
    synchronized (this.a) {
      return this.b;
    } 
  }
  
  public final boolean b() {
    synchronized (this.a) {
      if (this.b && !c() && this.e == null)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public final boolean c() {
    return this.c;
  }
  
  public final TResult d() {
    synchronized (this.a) {
      if (this.e == null)
        return this.d; 
      throw new RuntimeException(this.e);
    } 
  }
  
  public final Exception e() {
    synchronized (this.a) {
      return this.e;
    } 
  }
  
  public final boolean f() {
    synchronized (this.a) {
      if (this.b)
        return false; 
      this.b = true;
      this.c = true;
      this.a.notifyAll();
      g();
      return true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hmf\tasks\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */