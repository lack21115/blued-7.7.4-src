package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult extends PendingResult {
  static final ThreadLocal zzfvb = new zzs();
  
  @KeepName
  private BasePendingResult$zzb mResultGuardian;
  
  private boolean zzam;
  
  private final CountDownLatch zzapc;
  
  private Result zzftm;
  
  private final Object zzfvc;
  
  private BasePendingResult$zza zzfvd;
  
  private WeakReference zzfve;
  
  private final ArrayList zzfvf;
  
  private ResultCallback zzfvg;
  
  private final AtomicReference zzfvh;
  
  private volatile boolean zzfvi;
  
  private boolean zzfvj;
  
  private volatile zzdh zzfvl;
  
  private boolean zzfvm;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @Deprecated
  BasePendingResult() {
    this.zzfvc = new Object();
    this.zzapc = new CountDownLatch(1);
    this.zzfvf = new ArrayList();
    this.zzfvh = new AtomicReference();
    this.zzfvm = false;
    this.zzfvd = new BasePendingResult$zza(Looper.getMainLooper());
    this.zzfve = new WeakReference(null);
  }
  
  protected BasePendingResult(GoogleApiClient paramGoogleApiClient) {
    Looper looper;
    this.zzfvc = new Object();
    this.zzapc = new CountDownLatch(1);
    this.zzfvf = new ArrayList();
    this.zzfvh = new AtomicReference();
    this.zzfvm = false;
    if (paramGoogleApiClient != null) {
      looper = paramGoogleApiClient.getLooper();
    } else {
      looper = Looper.getMainLooper();
    } 
    this.zzfvd = new BasePendingResult$zza(looper);
    this.zzfve = new WeakReference<GoogleApiClient>(paramGoogleApiClient);
  }
  
  private final Result get() {
    synchronized (this.zzfvc) {
      zzbq.zza(this.zzfvi ^ true, "Result has already been consumed.");
      zzbq.zza(isReady(), "Result is not ready.");
      Result result = this.zzftm;
      this.zzftm = null;
      this.zzfvg = null;
      this.zzfvi = true;
      null = this.zzfvh.getAndSet(null);
      if (null != null)
        null.zzc(this); 
      return result;
    } 
  }
  
  private final void zzc(Result paramResult) {
    this.zzftm = paramResult;
    this.zzapc.countDown();
    this.zzftm.getStatus();
    boolean bool = this.zzam;
    int i = 0;
    if (bool) {
      this.zzfvg = null;
    } else if (this.zzfvg == null) {
      if (this.zzftm instanceof com.google.android.gms.common.api.Releasable)
        this.mResultGuardian = new BasePendingResult$zzb(this, (byte)0); 
    } else {
      this.zzfvd.removeMessages(2);
      this.zzfvd.zza(this.zzfvg, get());
    } 
    ArrayList<Object> arrayList = this.zzfvf;
    int j = arrayList.size();
    while (i < j) {
      PendingResult.zza zza = (PendingResult.zza)arrayList.get(i);
      i++;
      ((PendingResult.zza)zza).zzr$e184e5d();
    } 
    this.zzfvf.clear();
  }
  
  public static void zzd(Result paramResult) {
    if (paramResult instanceof com.google.android.gms.common.api.Releasable);
  }
  
  public final void cancel() {
    synchronized (this.zzfvc) {
      if (this.zzam || this.zzfvi)
        return; 
      this.zzam = true;
      zzc(zzb(Status.zzftu));
      return;
    } 
  }
  
  public final boolean isCanceled() {
    synchronized (this.zzfvc) {
      return this.zzam;
    } 
  }
  
  public final boolean isReady() {
    return (this.zzapc.getCount() == 0L);
  }
  
  public final void setResult(Result paramResult) {
    synchronized (this.zzfvc) {
      if (!this.zzfvj && !this.zzam) {
        isReady();
        zzbq.zza(isReady() ^ true, "Results have already been set");
        zzbq.zza(this.zzfvi ^ true, "Result has already been consumed");
        zzc(paramResult);
        return;
      } 
      return;
    } 
  }
  
  public final void setResultCallback(ResultCallback paramResultCallback) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzfvc : Ljava/lang/Object;
    //   4: astore #4
    //   6: aload #4
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull -> 22
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield zzfvg : Lcom/google/android/gms/common/api/ResultCallback;
    //   18: aload #4
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield zzfvi : Z
    //   26: istore_3
    //   27: iconst_1
    //   28: istore_2
    //   29: iload_3
    //   30: iconst_1
    //   31: ixor
    //   32: ldc 'Result has already been consumed.'
    //   34: invokestatic zza : (ZLjava/lang/Object;)V
    //   37: aload_0
    //   38: getfield zzfvl : Lcom/google/android/gms/common/api/internal/zzdh;
    //   41: ifnonnull -> 104
    //   44: goto -> 47
    //   47: iload_2
    //   48: ldc 'Cannot set callbacks if then() has been called.'
    //   50: invokestatic zza : (ZLjava/lang/Object;)V
    //   53: aload_0
    //   54: invokevirtual isCanceled : ()Z
    //   57: ifeq -> 64
    //   60: aload #4
    //   62: monitorexit
    //   63: return
    //   64: aload_0
    //   65: invokevirtual isReady : ()Z
    //   68: ifeq -> 86
    //   71: aload_0
    //   72: getfield zzfvd : Lcom/google/android/gms/common/api/internal/BasePendingResult$zza;
    //   75: aload_1
    //   76: aload_0
    //   77: invokespecial get : ()Lcom/google/android/gms/common/api/Result;
    //   80: invokevirtual zza : (Lcom/google/android/gms/common/api/ResultCallback;Lcom/google/android/gms/common/api/Result;)V
    //   83: goto -> 91
    //   86: aload_0
    //   87: aload_1
    //   88: putfield zzfvg : Lcom/google/android/gms/common/api/ResultCallback;
    //   91: aload #4
    //   93: monitorexit
    //   94: return
    //   95: aload #4
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: goto -> 95
    //   104: iconst_0
    //   105: istore_2
    //   106: goto -> 47
    // Exception table:
    //   from	to	target	type
    //   13	21	100	finally
    //   22	27	100	finally
    //   29	44	100	finally
    //   47	63	100	finally
    //   64	83	100	finally
    //   86	91	100	finally
    //   91	94	100	finally
    //   95	98	100	finally
  }
  
  public final void zza(PendingResult.zza paramzza) {
    boolean bool;
    if (paramzza != null) {
      bool = true;
    } else {
      bool = false;
    } 
    zzbq.checkArgument(bool, "Callback cannot be null.");
    synchronized (this.zzfvc) {
      if (isReady()) {
        paramzza.zzr$e184e5d();
      } else {
        this.zzfvf.add(paramzza);
      } 
      return;
    } 
  }
  
  public final void zza(zzdn paramzzdn) {
    this.zzfvh.set(paramzzdn);
  }
  
  public final Integer zzaid() {
    return null;
  }
  
  public final boolean zzaip() {
    synchronized (this.zzfvc) {
      if ((GoogleApiClient)this.zzfve.get() == null || !this.zzfvm)
        super.cancel(); 
      return super.isCanceled();
    } 
  }
  
  public final void zzaiq() {
    boolean bool;
    if (this.zzfvm || ((Boolean)zzfvb.get()).booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.zzfvm = bool;
  }
  
  public abstract Result zzb(Status paramStatus);
  
  public final void zzv(Status paramStatus) {
    synchronized (this.zzfvc) {
      if (!isReady()) {
        setResult(zzb(paramStatus));
        this.zzfvj = true;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\BasePendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */