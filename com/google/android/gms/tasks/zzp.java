package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public final class zzp extends Task {
  public final Object mLock = new Object();
  
  public final zzn zzlen = new zzn();
  
  public boolean zzleo;
  
  public Exception zzleq;
  
  public final Task addOnCompleteListener(Executor paramExecutor, OnCompleteListener paramOnCompleteListener) {
    zzn zzn1 = this.zzlen;
    null = new zze(paramExecutor, paramOnCompleteListener);
    synchronized (zzn1.mLock) {
      if (zzn1.zzlej == null)
        zzn1.zzlej = new ArrayDeque(); 
      zzn1.zzlej.add(null);
      synchronized (this.mLock) {
        if (!this.zzleo)
          return this; 
        this.zzlen.zzb(this);
        return this;
      } 
    } 
  }
  
  public final Exception getException() {
    synchronized (this.mLock) {
      return this.zzleq;
    } 
  }
  
  public final boolean isSuccessful() {
    synchronized (this.mLock) {
      if (this.zzleo && this.zzleq == null)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public final boolean trySetException(Exception paramException) {
    zzbq.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock) {
      if (this.zzleo)
        return false; 
      this.zzleo = true;
      this.zzleq = paramException;
      this.zzlen.zzb(this);
      return true;
    } 
  }
  
  public final boolean trySetResult$5d527815() {
    synchronized (this.mLock) {
      if (this.zzleo)
        return false; 
      this.zzleo = true;
      this.zzlen.zzb(this);
      return true;
    } 
  }
  
  public final void zzble() {
    zzbq.zza(this.zzleo ^ true, "Task is already complete");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\tasks\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */