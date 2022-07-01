package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zaci<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
  private ResultTransform<? super R, ? extends Result> zaa;
  
  private zaci<? extends Result> zab;
  
  private volatile ResultCallbacks<? super R> zac;
  
  private PendingResult<R> zad;
  
  private final Object zae;
  
  private Status zaf;
  
  private final WeakReference<GoogleApiClient> zag;
  
  private final zack zah;
  
  private boolean zai;
  
  public zaci(WeakReference<GoogleApiClient> paramWeakReference) {
    Looper looper;
    this.zaa = null;
    this.zab = null;
    this.zac = null;
    this.zad = null;
    this.zae = new Object();
    this.zaf = null;
    this.zai = false;
    Preconditions.checkNotNull(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zag = paramWeakReference;
    GoogleApiClient googleApiClient = this.zag.get();
    if (googleApiClient != null) {
      looper = googleApiClient.getLooper();
    } else {
      looper = Looper.getMainLooper();
    } 
    this.zah = new zack(this, looper);
  }
  
  private static void zaa(Result paramResult) {
    if (paramResult instanceof Releasable)
      try {
        ((Releasable)paramResult).release();
        return;
      } catch (RuntimeException runtimeException) {
        String str = String.valueOf(paramResult);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 18);
        stringBuilder.append("Unable to release ");
        stringBuilder.append(str);
        Log.w("TransformedResultImpl", stringBuilder.toString(), runtimeException);
      }  
  }
  
  private final void zaa(Status paramStatus) {
    synchronized (this.zae) {
      this.zaf = paramStatus;
      zab(this.zaf);
      return;
    } 
  }
  
  private final void zab() {
    if (this.zaa == null && this.zac == null)
      return; 
    GoogleApiClient googleApiClient = this.zag.get();
    if (!this.zai && this.zaa != null && googleApiClient != null) {
      googleApiClient.zaa(this);
      this.zai = true;
    } 
    Status status = this.zaf;
    if (status != null) {
      zab(status);
      return;
    } 
    PendingResult<R> pendingResult = this.zad;
    if (pendingResult != null)
      pendingResult.setResultCallback(this); 
  }
  
  private final void zab(Status paramStatus) {
    synchronized (this.zae) {
      if (this.zaa != null) {
        paramStatus = (Status)Preconditions.checkNotNull(this.zaa.onFailure(paramStatus), "onFailure must not return null");
        ((zaci)Preconditions.checkNotNull(this.zab)).zaa(paramStatus);
      } else if (zac()) {
        ((ResultCallbacks)Preconditions.checkNotNull(this.zac)).onFailure(paramStatus);
      } 
      return;
    } 
  }
  
  private final boolean zac() {
    GoogleApiClient googleApiClient = this.zag.get();
    return (this.zac != null && googleApiClient != null);
  }
  
  public final void andFinally(ResultCallbacks<? super R> paramResultCallbacks) {
    synchronized (this.zae) {
      boolean bool1;
      ResultCallbacks<? super R> resultCallbacks = this.zac;
      boolean bool2 = true;
      if (resultCallbacks == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.checkState(bool1, "Cannot call andFinally() twice.");
      if (this.zaa == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
      this.zac = paramResultCallbacks;
      zab();
      return;
    } 
  }
  
  public final void onResult(R paramR) {
    synchronized (this.zae) {
      if (paramR.getStatus().isSuccess()) {
        if (this.zaa != null) {
          zabz.zaa().submit(new zacl(this, (Result)paramR));
        } else if (zac()) {
          ((ResultCallbacks)Preconditions.checkNotNull(this.zac)).onSuccess((Result)paramR);
        } 
      } else {
        zaa(paramR.getStatus());
        zaa((Result)paramR);
      } 
      return;
    } 
  }
  
  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform) {
    synchronized (this.zae) {
      boolean bool1;
      ResultTransform<? super R, ? extends Result> resultTransform = this.zaa;
      boolean bool2 = true;
      if (resultTransform == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.checkState(bool1, "Cannot call then() twice.");
      if (this.zac == null) {
        bool1 = bool2;
        Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
        this.zaa = paramResultTransform;
        zaci<? extends Result> zaci2 = new zaci(this.zag);
        this.zab = zaci2;
        zab();
        return (TransformedResult)zaci2;
      } 
    } 
    boolean bool = false;
    Preconditions.checkState(bool, "Cannot call then() and andFinally() on the same TransformedResult.");
    this.zaa = paramResultTransform;
    zaci<? extends Result> zaci1 = new zaci(this.zag);
    this.zab = zaci1;
    zab();
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
    return (TransformedResult)zaci1;
  }
  
  final void zaa() {
    this.zac = null;
  }
  
  public final void zaa(PendingResult<?> paramPendingResult) {
    synchronized (this.zae) {
      this.zad = (PendingResult)paramPendingResult;
      zab();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */