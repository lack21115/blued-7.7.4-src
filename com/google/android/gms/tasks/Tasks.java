package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
  public static <TResult> TResult await(Task<TResult> paramTask) throws ExecutionException, InterruptedException {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    if (paramTask.isComplete())
      return zza(paramTask); 
    zzb zzb = new zzb(null);
    zza(paramTask, zzb);
    zzb.zza();
    return zza(paramTask);
  }
  
  public static <TResult> TResult await(Task<TResult> paramTask, long paramLong, TimeUnit paramTimeUnit) throws ExecutionException, InterruptedException, TimeoutException {
    Preconditions.checkNotMainThread();
    Preconditions.checkNotNull(paramTask, "Task must not be null");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete())
      return zza(paramTask); 
    zzb zzb = new zzb(null);
    zza(paramTask, zzb);
    if (zzb.zza(paramLong, paramTimeUnit))
      return zza(paramTask); 
    throw new TimeoutException("Timed out waiting for Task");
  }
  
  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable) {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }
  
  public static <TResult> Task<TResult> call(Executor paramExecutor, Callable<TResult> paramCallable) {
    Preconditions.checkNotNull(paramExecutor, "Executor must not be null");
    Preconditions.checkNotNull(paramCallable, "Callback must not be null");
    zzu<TResult> zzu = new zzu();
    paramExecutor.execute(new zzy(zzu, paramCallable));
    return zzu;
  }
  
  public static <TResult> Task<TResult> forCanceled() {
    zzu<TResult> zzu = new zzu();
    zzu.zza();
    return zzu;
  }
  
  public static <TResult> Task<TResult> forException(Exception paramException) {
    zzu<TResult> zzu = new zzu();
    zzu.zza(paramException);
    return zzu;
  }
  
  public static <TResult> Task<TResult> forResult(TResult paramTResult) {
    zzu<TResult> zzu = new zzu();
    zzu.zza(paramTResult);
    return zzu;
  }
  
  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection) {
    if (paramCollection == null || paramCollection.isEmpty())
      return forResult(null); 
    Iterator<? extends Task<?>> iterator2 = paramCollection.iterator();
    while (iterator2.hasNext()) {
      if ((Task)iterator2.next() != null)
        continue; 
      throw new NullPointerException("null tasks are not accepted");
    } 
    zzu<Void> zzu = new zzu();
    zzc zzc = new zzc(paramCollection.size(), zzu);
    Iterator<? extends Task<?>> iterator1 = paramCollection.iterator();
    while (iterator1.hasNext())
      zza(iterator1.next(), zzc); 
    return zzu;
  }
  
  public static Task<Void> whenAll(Task<?>... paramVarArgs) {
    return (paramVarArgs == null || paramVarArgs.length == 0) ? forResult(null) : whenAll(Arrays.asList(paramVarArgs));
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> paramCollection) {
    return (paramCollection == null || paramCollection.isEmpty()) ? forResult(Collections.emptyList()) : whenAll(paramCollection).continueWithTask(new zzz(paramCollection));
  }
  
  public static Task<List<Task<?>>> whenAllComplete(Task<?>... paramVarArgs) {
    return (paramVarArgs == null || paramVarArgs.length == 0) ? forResult(Collections.emptyList()) : whenAllComplete(Arrays.asList(paramVarArgs));
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> paramCollection) {
    return (paramCollection == null || paramCollection.isEmpty()) ? forResult(Collections.emptyList()) : whenAll(paramCollection).continueWith(new zzaa(paramCollection));
  }
  
  public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... paramVarArgs) {
    return (paramVarArgs == null || paramVarArgs.length == 0) ? forResult(Collections.emptyList()) : whenAllSuccess(Arrays.asList(paramVarArgs));
  }
  
  private static <TResult> TResult zza(Task<TResult> paramTask) throws ExecutionException {
    if (paramTask.isSuccessful())
      return paramTask.getResult(); 
    if (paramTask.isCanceled())
      throw new CancellationException("Task is already canceled"); 
    throw new ExecutionException(paramTask.getException());
  }
  
  private static void zza(Task<?> paramTask, zza paramzza) {
    paramTask.addOnSuccessListener(TaskExecutors.zza, paramzza);
    paramTask.addOnFailureListener(TaskExecutors.zza, paramzza);
    paramTask.addOnCanceledListener(TaskExecutors.zza, paramzza);
  }
  
  static interface zza extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {}
  
  static final class zzb implements zza {
    private final CountDownLatch zza = new CountDownLatch(1);
    
    private zzb() {}
    
    public final void onCanceled() {
      this.zza.countDown();
    }
    
    public final void onFailure(Exception param1Exception) {
      this.zza.countDown();
    }
    
    public final void onSuccess(Object param1Object) {
      this.zza.countDown();
    }
    
    public final void zza() throws InterruptedException {
      this.zza.await();
    }
    
    public final boolean zza(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      return this.zza.await(param1Long, param1TimeUnit);
    }
  }
  
  static final class zzc implements zza {
    private final Object zza = new Object();
    
    private final int zzb;
    
    private final zzu<Void> zzc;
    
    private int zzd;
    
    private int zze;
    
    private int zzf;
    
    private Exception zzg;
    
    private boolean zzh;
    
    public zzc(int param1Int, zzu<Void> param1zzu) {
      this.zzb = param1Int;
      this.zzc = param1zzu;
    }
    
    private final void zza() {
      int i = this.zzd;
      int j = this.zze;
      int k = this.zzf;
      int m = this.zzb;
      if (i + j + k == m) {
        if (this.zzg != null) {
          zzu<Void> zzu1 = this.zzc;
          StringBuilder stringBuilder = new StringBuilder(54);
          stringBuilder.append(j);
          stringBuilder.append(" out of ");
          stringBuilder.append(m);
          stringBuilder.append(" underlying tasks failed");
          zzu1.zza(new ExecutionException(stringBuilder.toString(), this.zzg));
          return;
        } 
        if (this.zzh) {
          this.zzc.zza();
          return;
        } 
        this.zzc.zza((Void)null);
      } 
    }
    
    public final void onCanceled() {
      synchronized (this.zza) {
        this.zzf++;
        this.zzh = true;
        zza();
        return;
      } 
    }
    
    public final void onFailure(Exception param1Exception) {
      synchronized (this.zza) {
        this.zze++;
        this.zzg = param1Exception;
        zza();
        return;
      } 
    }
    
    public final void onSuccess(Object param1Object) {
      synchronized (this.zza) {
        this.zzd++;
        zza();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\Tasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */