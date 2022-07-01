package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzu<TResult> extends Task<TResult> {
  private final Object zza = new Object();
  
  private final zzq<TResult> zzb = new zzq<TResult>();
  
  private boolean zzc;
  
  private volatile boolean zzd;
  
  private TResult zze;
  
  private Exception zzf;
  
  private final void zzb() {
    Preconditions.checkState(this.zzc, "Task is not yet complete");
  }
  
  private final void zzc() {
    if (!this.zzc)
      return; 
    throw DuplicateTaskCompletionException.of(this);
  }
  
  private final void zzd() {
    if (!this.zzd)
      return; 
    throw new CancellationException("Task is already canceled.");
  }
  
  private final void zze() {
    synchronized (this.zza) {
      if (!this.zzc)
        return; 
      this.zzb.zza(this);
      return;
    } 
  }
  
  public final Task<TResult> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener) {
    zzh<TResult> zzh = new zzh(zzv.zza(TaskExecutors.MAIN_THREAD), paramOnCanceledListener);
    this.zzb.zza(zzh);
    zza.zza(paramActivity).zza(zzh);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnCanceledListener(OnCanceledListener paramOnCanceledListener) {
    return super.addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
  }
  
  public final Task<TResult> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener) {
    this.zzb.zza(new zzh<TResult>(zzv.zza(paramExecutor), paramOnCanceledListener));
    zze();
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener) {
    zzi<TResult> zzi = new zzi<TResult>(zzv.zza(TaskExecutors.MAIN_THREAD), paramOnCompleteListener);
    this.zzb.zza(zzi);
    zza.zza(paramActivity).zza(zzi);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener) {
    return super.addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  public final Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener) {
    this.zzb.zza(new zzi<TResult>(zzv.zza(paramExecutor), paramOnCompleteListener));
    zze();
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener) {
    zzl<TResult> zzl = new zzl(zzv.zza(TaskExecutors.MAIN_THREAD), paramOnFailureListener);
    this.zzb.zza(zzl);
    zza.zza(paramActivity).zza(zzl);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener) {
    return super.addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  public final Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener) {
    this.zzb.zza(new zzl<TResult>(zzv.zza(paramExecutor), paramOnFailureListener));
    zze();
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<? super TResult> paramOnSuccessListener) {
    zzm<TResult> zzm = new zzm<TResult>(zzv.zza(TaskExecutors.MAIN_THREAD), paramOnSuccessListener);
    this.zzb.zza(zzm);
    zza.zza(paramActivity).zza(zzm);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> paramOnSuccessListener) {
    return super.addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  public final Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener) {
    this.zzb.zza(new zzm<TResult>(zzv.zza(paramExecutor), paramOnSuccessListener));
    zze();
    return this;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation) {
    return super.continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation) {
    zzu<TContinuationResult> zzu1 = new zzu();
    this.zzb.zza(new zzc<TResult, TContinuationResult>(zzv.zza(paramExecutor), paramContinuation, zzu1));
    zze();
    return zzu1;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    return super.continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation) {
    zzu<TContinuationResult> zzu1 = new zzu();
    this.zzb.zza(new zzd<TResult, TContinuationResult>(zzv.zza(paramExecutor), paramContinuation, zzu1));
    zze();
    return zzu1;
  }
  
  public final Exception getException() {
    synchronized (this.zza) {
      return this.zzf;
    } 
  }
  
  public final TResult getResult() {
    synchronized (this.zza) {
      zzb();
      zzd();
      if (this.zzf == null)
        return this.zze; 
      throw new RuntimeExecutionException(this.zzf);
    } 
  }
  
  public final <X extends Throwable> TResult getResult(Class<X> paramClass) throws X {
    synchronized (this.zza) {
      TResult tResult;
      zzb();
      zzd();
      if (!paramClass.isInstance(this.zzf)) {
        if (this.zzf == null) {
          tResult = this.zze;
          return tResult;
        } 
        throw (X)new RuntimeExecutionException(this.zzf);
      } 
      throw (X)tResult.cast(this.zzf);
    } 
  }
  
  public final boolean isCanceled() {
    return this.zzd;
  }
  
  public final boolean isComplete() {
    synchronized (this.zza) {
      return this.zzc;
    } 
  }
  
  public final boolean isSuccessful() {
    synchronized (this.zza) {
      if (this.zzc && !this.zzd && this.zzf == null)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    return super.onSuccessTask(TaskExecutors.MAIN_THREAD, paramSuccessContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation) {
    zzu<TContinuationResult> zzu1 = new zzu();
    this.zzb.zza(new zzp<TResult, TContinuationResult>(zzv.zza(paramExecutor), paramSuccessContinuation, zzu1));
    zze();
    return zzu1;
  }
  
  public final void zza(Exception paramException) {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.zza) {
      zzc();
      this.zzc = true;
      this.zzf = paramException;
      this.zzb.zza(this);
      return;
    } 
  }
  
  public final void zza(TResult paramTResult) {
    synchronized (this.zza) {
      zzc();
      this.zzc = true;
      this.zze = paramTResult;
      this.zzb.zza(this);
      return;
    } 
  }
  
  public final boolean zza() {
    synchronized (this.zza) {
      if (this.zzc)
        return false; 
      this.zzc = true;
      this.zzd = true;
      this.zzb.zza(this);
      return true;
    } 
  }
  
  public final boolean zzb(Exception paramException) {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.zza) {
      if (this.zzc)
        return false; 
      this.zzc = true;
      this.zzf = paramException;
      this.zzb.zza(this);
      return true;
    } 
  }
  
  public final boolean zzb(TResult paramTResult) {
    synchronized (this.zza) {
      if (this.zzc)
        return false; 
      this.zzc = true;
      this.zze = paramTResult;
      this.zzb.zza(this);
      return true;
    } 
  }
  
  static class zza extends LifecycleCallback {
    private final List<WeakReference<zzr<?>>> zza = new ArrayList<WeakReference<zzr<?>>>();
    
    private zza(LifecycleFragment param1LifecycleFragment) {
      super(param1LifecycleFragment);
      this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }
    
    public static zza zza(Activity param1Activity) {
      LifecycleFragment lifecycleFragment = getFragment(param1Activity);
      zza zza2 = (zza)lifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
      zza zza1 = zza2;
      if (zza2 == null)
        zza1 = new zza(lifecycleFragment); 
      return zza1;
    }
    
    public void onStop() {
      synchronized (this.zza) {
        Iterator<WeakReference<zzr<?>>> iterator = this.zza.iterator();
        while (iterator.hasNext()) {
          zzr zzr = ((WeakReference<zzr>)iterator.next()).get();
          if (zzr != null)
            zzr.zza(); 
        } 
        this.zza.clear();
        return;
      } 
    }
    
    public final <T> void zza(zzr<T> param1zzr) {
      synchronized (this.zza) {
        this.zza.add(new WeakReference<zzr<?>>(param1zzr));
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */