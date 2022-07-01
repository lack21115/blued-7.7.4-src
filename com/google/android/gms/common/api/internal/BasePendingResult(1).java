package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
  static final ThreadLocal<Boolean> zaa = new zao();
  
  private zaa mResultGuardian;
  
  private final Object zab;
  
  private final CallbackHandler<R> zac;
  
  private final WeakReference<GoogleApiClient> zad;
  
  private final CountDownLatch zae;
  
  private final ArrayList<PendingResult.StatusListener> zaf;
  
  private ResultCallback<? super R> zag;
  
  private final AtomicReference<zaco> zah;
  
  private R zai;
  
  private Status zaj;
  
  private volatile boolean zak;
  
  private boolean zal;
  
  private boolean zam;
  
  private ICancelToken zan;
  
  private volatile zaci<R> zao;
  
  private boolean zap;
  
  @Deprecated
  BasePendingResult() {
    this.zab = new Object();
    this.zae = new CountDownLatch(1);
    this.zaf = new ArrayList<PendingResult.StatusListener>();
    this.zah = new AtomicReference<zaco>();
    this.zap = false;
    this.zac = new CallbackHandler<R>(Looper.getMainLooper());
    this.zad = new WeakReference<GoogleApiClient>(null);
  }
  
  @Deprecated
  public BasePendingResult(Looper paramLooper) {
    this.zab = new Object();
    this.zae = new CountDownLatch(1);
    this.zaf = new ArrayList<PendingResult.StatusListener>();
    this.zah = new AtomicReference<zaco>();
    this.zap = false;
    this.zac = new CallbackHandler<R>(paramLooper);
    this.zad = new WeakReference<GoogleApiClient>(null);
  }
  
  public BasePendingResult(GoogleApiClient paramGoogleApiClient) {
    Looper looper;
    this.zab = new Object();
    this.zae = new CountDownLatch(1);
    this.zaf = new ArrayList<PendingResult.StatusListener>();
    this.zah = new AtomicReference<zaco>();
    this.zap = false;
    if (paramGoogleApiClient != null) {
      looper = paramGoogleApiClient.getLooper();
    } else {
      looper = Looper.getMainLooper();
    } 
    this.zac = new CallbackHandler<R>(looper);
    this.zad = new WeakReference<GoogleApiClient>(paramGoogleApiClient);
  }
  
  protected BasePendingResult(CallbackHandler<R> paramCallbackHandler) {
    this.zab = new Object();
    this.zae = new CountDownLatch(1);
    this.zaf = new ArrayList<PendingResult.StatusListener>();
    this.zah = new AtomicReference<zaco>();
    this.zap = false;
    this.zac = (CallbackHandler<R>)Preconditions.checkNotNull(paramCallbackHandler, "CallbackHandler must not be null");
    this.zad = new WeakReference<GoogleApiClient>(null);
  }
  
  public static void zaa(Result paramResult) {
    if (paramResult instanceof Releasable)
      try {
        ((Releasable)paramResult).release();
        return;
      } catch (RuntimeException runtimeException) {
        String str = String.valueOf(paramResult);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 18);
        stringBuilder.append("Unable to release ");
        stringBuilder.append(str);
        Log.w("BasePendingResult", stringBuilder.toString(), runtimeException);
      }  
  }
  
  private static <R extends Result> ResultCallback<R> zab(ResultCallback<R> paramResultCallback) {
    return paramResultCallback;
  }
  
  private final void zab(R paramR) {
    this.zai = paramR;
    this.zaj = paramR.getStatus();
    this.zan = null;
    this.zae.countDown();
    if (this.zal) {
      this.zag = null;
    } else {
      ResultCallback<? super R> resultCallback = this.zag;
      if (resultCallback == null) {
        if (this.zai instanceof Releasable)
          this.mResultGuardian = new zaa(null); 
      } else {
        this.zac.removeMessages(2);
        this.zac.zaa(resultCallback, zac());
      } 
    } 
    ArrayList<PendingResult.StatusListener> arrayList = this.zaf;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      PendingResult.StatusListener statusListener = (PendingResult.StatusListener)arrayList.get(i);
      i++;
      ((PendingResult.StatusListener)statusListener).onComplete(this.zaj);
    } 
    this.zaf.clear();
  }
  
  private final R zac() {
    synchronized (this.zab) {
      boolean bool;
      if (!this.zak) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Result has already been consumed.");
      Preconditions.checkState(isReady(), "Result is not ready.");
      R r = this.zai;
      this.zai = null;
      this.zag = null;
      this.zak = true;
      null = this.zah.getAndSet(null);
      if (null != null)
        null.zaa(this); 
      return (R)Preconditions.checkNotNull(r);
    } 
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener) {
    boolean bool;
    if (paramStatusListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Callback cannot be null.");
    synchronized (this.zab) {
      if (isReady()) {
        paramStatusListener.onComplete(this.zaj);
      } else {
        this.zaf.add(paramStatusListener);
      } 
      return;
    } 
  }
  
  public final R await() {
    Preconditions.checkNotMainThread("await must not be called on the UI thread");
    boolean bool1 = this.zak;
    boolean bool = true;
    Preconditions.checkState(bool1 ^ true, "Result has already been consumed");
    if (this.zao != null)
      bool = false; 
    Preconditions.checkState(bool, "Cannot await if then() has been called.");
    try {
      this.zae.await();
    } catch (InterruptedException interruptedException) {
      forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
    } 
    Preconditions.checkState(isReady(), "Result is not ready.");
    return zac();
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit) {
    if (paramLong > 0L)
      Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero."); 
    boolean bool1 = this.zak;
    boolean bool = true;
    Preconditions.checkState(bool1 ^ true, "Result has already been consumed.");
    if (this.zao != null)
      bool = false; 
    Preconditions.checkState(bool, "Cannot await if then() has been called.");
    try {
      if (!this.zae.await(paramLong, paramTimeUnit))
        forceFailureUnlessReady(Status.RESULT_TIMEOUT); 
    } catch (InterruptedException interruptedException) {
      forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
    } 
    Preconditions.checkState(isReady(), "Result is not ready.");
    return zac();
  }
  
  public void cancel() {
    synchronized (this.zab) {
      if (this.zal || this.zak)
        return; 
      ICancelToken iCancelToken = this.zan;
      if (iCancelToken != null)
        try {
          this.zan.cancel();
        } catch (RemoteException remoteException) {} 
      zaa((Result)this.zai);
      this.zal = true;
      zab(createFailedResult(Status.RESULT_CANCELED));
      return;
    } 
  }
  
  protected abstract R createFailedResult(Status paramStatus);
  
  @Deprecated
  public final void forceFailureUnlessReady(Status paramStatus) {
    synchronized (this.zab) {
      if (!isReady()) {
        setResult(createFailedResult(paramStatus));
        this.zam = true;
      } 
      return;
    } 
  }
  
  public boolean isCanceled() {
    synchronized (this.zab) {
      return this.zal;
    } 
  }
  
  public final boolean isReady() {
    return (this.zae.getCount() == 0L);
  }
  
  protected final void setCancelToken(ICancelToken paramICancelToken) {
    synchronized (this.zab) {
      this.zan = paramICancelToken;
      return;
    } 
  }
  
  public final void setResult(R paramR) {
    synchronized (this.zab) {
      if (!this.zam && !this.zal) {
        isReady();
        boolean bool = isReady();
        boolean bool1 = true;
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "Results have already been set");
        if (!this.zak) {
          bool = bool1;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "Result has already been consumed");
        zab(paramR);
        return;
      } 
      zaa((Result)paramR);
      return;
    } 
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zab : Ljava/lang/Object;
    //   4: astore #4
    //   6: aload #4
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull -> 22
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield zag : Lcom/google/android/gms/common/api/ResultCallback;
    //   18: aload #4
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield zak : Z
    //   26: istore_2
    //   27: iconst_1
    //   28: istore_3
    //   29: iload_2
    //   30: ifne -> 111
    //   33: iconst_1
    //   34: istore_2
    //   35: goto -> 38
    //   38: iload_2
    //   39: ldc 'Result has already been consumed.'
    //   41: invokestatic checkState : (ZLjava/lang/Object;)V
    //   44: aload_0
    //   45: getfield zao : Lcom/google/android/gms/common/api/internal/zaci;
    //   48: ifnonnull -> 116
    //   51: iload_3
    //   52: istore_2
    //   53: goto -> 56
    //   56: iload_2
    //   57: ldc_w 'Cannot set callbacks if then() has been called.'
    //   60: invokestatic checkState : (ZLjava/lang/Object;)V
    //   63: aload_0
    //   64: invokevirtual isCanceled : ()Z
    //   67: ifeq -> 74
    //   70: aload #4
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: invokevirtual isReady : ()Z
    //   78: ifeq -> 96
    //   81: aload_0
    //   82: getfield zac : Lcom/google/android/gms/common/api/internal/BasePendingResult$CallbackHandler;
    //   85: aload_1
    //   86: aload_0
    //   87: invokespecial zac : ()Lcom/google/android/gms/common/api/Result;
    //   90: invokevirtual zaa : (Lcom/google/android/gms/common/api/ResultCallback;Lcom/google/android/gms/common/api/Result;)V
    //   93: goto -> 101
    //   96: aload_0
    //   97: aload_1
    //   98: putfield zag : Lcom/google/android/gms/common/api/ResultCallback;
    //   101: aload #4
    //   103: monitorexit
    //   104: return
    //   105: astore_1
    //   106: aload #4
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    //   111: iconst_0
    //   112: istore_2
    //   113: goto -> 38
    //   116: iconst_0
    //   117: istore_2
    //   118: goto -> 56
    // Exception table:
    //   from	to	target	type
    //   13	21	105	finally
    //   22	27	105	finally
    //   38	51	105	finally
    //   56	73	105	finally
    //   74	93	105	finally
    //   96	101	105	finally
    //   101	104	105	finally
    //   106	109	105	finally
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zab : Ljava/lang/Object;
    //   4: astore #7
    //   6: aload #7
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull -> 22
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield zag : Lcom/google/android/gms/common/api/ResultCallback;
    //   18: aload #7
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield zak : Z
    //   26: istore #5
    //   28: iconst_1
    //   29: istore #6
    //   31: iload #5
    //   33: ifne -> 143
    //   36: iconst_1
    //   37: istore #5
    //   39: goto -> 42
    //   42: iload #5
    //   44: ldc 'Result has already been consumed.'
    //   46: invokestatic checkState : (ZLjava/lang/Object;)V
    //   49: aload_0
    //   50: getfield zao : Lcom/google/android/gms/common/api/internal/zaci;
    //   53: ifnonnull -> 149
    //   56: iload #6
    //   58: istore #5
    //   60: goto -> 63
    //   63: iload #5
    //   65: ldc_w 'Cannot set callbacks if then() has been called.'
    //   68: invokestatic checkState : (ZLjava/lang/Object;)V
    //   71: aload_0
    //   72: invokevirtual isCanceled : ()Z
    //   75: ifeq -> 82
    //   78: aload #7
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: invokevirtual isReady : ()Z
    //   86: ifeq -> 104
    //   89: aload_0
    //   90: getfield zac : Lcom/google/android/gms/common/api/internal/BasePendingResult$CallbackHandler;
    //   93: aload_1
    //   94: aload_0
    //   95: invokespecial zac : ()Lcom/google/android/gms/common/api/Result;
    //   98: invokevirtual zaa : (Lcom/google/android/gms/common/api/ResultCallback;Lcom/google/android/gms/common/api/Result;)V
    //   101: goto -> 133
    //   104: aload_0
    //   105: aload_1
    //   106: putfield zag : Lcom/google/android/gms/common/api/ResultCallback;
    //   109: aload_0
    //   110: getfield zac : Lcom/google/android/gms/common/api/internal/BasePendingResult$CallbackHandler;
    //   113: astore_1
    //   114: aload #4
    //   116: lload_2
    //   117: invokevirtual toMillis : (J)J
    //   120: lstore_2
    //   121: aload_1
    //   122: aload_1
    //   123: iconst_2
    //   124: aload_0
    //   125: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   128: lload_2
    //   129: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
    //   132: pop
    //   133: aload #7
    //   135: monitorexit
    //   136: return
    //   137: astore_1
    //   138: aload #7
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: iconst_0
    //   144: istore #5
    //   146: goto -> 42
    //   149: iconst_0
    //   150: istore #5
    //   152: goto -> 63
    // Exception table:
    //   from	to	target	type
    //   13	21	137	finally
    //   22	28	137	finally
    //   42	56	137	finally
    //   63	81	137	finally
    //   82	101	137	finally
    //   104	133	137	finally
    //   133	136	137	finally
    //   138	141	137	finally
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform) {
    Preconditions.checkState(this.zak ^ true, "Result has already been consumed.");
    synchronized (this.zab) {
      zaci<R> zaci1 = this.zao;
      boolean bool2 = false;
      if (zaci1 == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.checkState(bool1, "Cannot call then() twice.");
      if (this.zag == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.checkState(bool1, "Cannot call then() if callbacks are set.");
      boolean bool1 = bool2;
      if (!this.zal)
        bool1 = true; 
      Preconditions.checkState(bool1, "Cannot call then() if result was canceled.");
      this.zap = true;
      this.zao = new zaci<R>(this.zad);
      TransformedResult<S> transformedResult = this.zao.then(paramResultTransform);
      if (isReady()) {
        this.zac.zaa(this.zao, zac());
      } else {
        this.zag = this.zao;
      } 
      return transformedResult;
    } 
  }
  
  public final void zaa(zaco paramzaco) {
    this.zah.set(paramzaco);
  }
  
  public final boolean zaa() {
    synchronized (this.zab) {
      if ((GoogleApiClient)this.zad.get() == null || !this.zap)
        super.cancel(); 
      return super.isCanceled();
    } 
  }
  
  public final void zab() {
    boolean bool;
    if (this.zap || ((Boolean)zaa.get()).booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.zap = bool;
  }
  
  public static class CallbackHandler<R extends Result> extends zap {
    public CallbackHandler() {
      this(Looper.getMainLooper());
    }
    
    public CallbackHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      StringBuilder stringBuilder;
      int i = param1Message.what;
      if (i != 1) {
        if (i != 2) {
          i = param1Message.what;
          stringBuilder = new StringBuilder(45);
          stringBuilder.append("Don't know how to handle message: ");
          stringBuilder.append(i);
          Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
          return;
        } 
        ((BasePendingResult)((Message)stringBuilder).obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
        return;
      } 
      Pair pair = (Pair)((Message)stringBuilder).obj;
      ResultCallback resultCallback = (ResultCallback)pair.first;
      Result result = (Result)pair.second;
      try {
        resultCallback.onResult(result);
        return;
      } catch (RuntimeException runtimeException) {
        BasePendingResult.zaa(result);
        throw runtimeException;
      } 
    }
    
    public final void zaa(ResultCallback<? super R> param1ResultCallback, R param1R) {
      sendMessage(obtainMessage(1, new Pair(Preconditions.checkNotNull(BasePendingResult.zaa(param1ResultCallback)), param1R)));
    }
  }
  
  final class zaa {
    private zaa(BasePendingResult this$0) {}
    
    protected final void finalize() throws Throwable {
      BasePendingResult.zaa(BasePendingResult.zaa(this.zaa));
      super.finalize();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\BasePendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */