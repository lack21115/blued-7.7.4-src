package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzbw;
import com.google.android.gms.common.api.internal.zzc;
import com.google.android.gms.common.api.internal.zzcp;
import com.google.android.gms.common.api.internal.zzcv;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzs;

public class GoogleApi {
  private final Context mContext;
  
  public final int mId;
  
  public final Looper zzalj;
  
  public final Api zzfop;
  
  private final Api$ApiOptions zzfsm;
  
  public final zzh zzfsn;
  
  public final zzbm zzfsq;
  
  public GoogleApi(Context paramContext, Api paramApi, Looper paramLooper) {
    zzbq.checkNotNull(paramContext, "Null context is not permitted.");
    zzbq.checkNotNull(paramApi, "Api must not be null.");
    zzbq.checkNotNull(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.zzfop = paramApi;
    this.zzfsm = null;
    this.zzalj = paramLooper;
    this.zzfsn = new zzh(paramApi);
    new zzbw(this);
    this.zzfsq = zzbm.zzck(this.mContext);
    this.mId = this.zzfsq.zzfzl.getAndIncrement();
    new zzg();
  }
  
  private final zzs zzahx() {
    // Byte code:
    //   0: new com/google/android/gms/common/internal/zzs
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield zzfsm : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   12: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   15: ifeq -> 59
    //   18: aload_0
    //   19: getfield zzfsm : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   22: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   25: invokeinterface getGoogleSignInAccount : ()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull -> 59
    //   35: aload_1
    //   36: getfield zzemh : Ljava/lang/String;
    //   39: ifnull -> 85
    //   42: new android/accounts/Account
    //   45: dup
    //   46: aload_1
    //   47: getfield zzemh : Ljava/lang/String;
    //   50: ldc 'com.google'
    //   52: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   55: astore_1
    //   56: goto -> 87
    //   59: aload_0
    //   60: getfield zzfsm : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   63: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasAccountOptions
    //   66: ifeq -> 85
    //   69: aload_0
    //   70: getfield zzfsm : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   73: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasAccountOptions
    //   76: invokeinterface getAccount : ()Landroid/accounts/Account;
    //   81: astore_1
    //   82: goto -> 87
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_2
    //   88: aload_1
    //   89: putfield zzeho : Landroid/accounts/Account;
    //   92: aload_0
    //   93: getfield zzfsm : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   96: instanceof com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   99: ifeq -> 127
    //   102: aload_0
    //   103: getfield zzfsm : Lcom/google/android/gms/common/api/Api$ApiOptions;
    //   106: checkcast com/google/android/gms/common/api/Api$ApiOptions$HasGoogleSignInAccountOptions
    //   109: invokeinterface getGoogleSignInAccount : ()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull -> 127
    //   119: aload_1
    //   120: invokevirtual zzacf : ()Ljava/util/Set;
    //   123: astore_1
    //   124: goto -> 131
    //   127: invokestatic emptySet : ()Ljava/util/Set;
    //   130: astore_1
    //   131: aload_2
    //   132: getfield zzgfu : Landroid/support/v4/util/ArraySet;
    //   135: ifnonnull -> 149
    //   138: aload_2
    //   139: new android/support/v4/util/ArraySet
    //   142: dup
    //   143: invokespecial <init> : ()V
    //   146: putfield zzgfu : Landroid/support/v4/util/ArraySet;
    //   149: aload_2
    //   150: getfield zzgfu : Landroid/support/v4/util/ArraySet;
    //   153: aload_1
    //   154: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   157: pop
    //   158: aload_2
    //   159: areturn
  }
  
  public Api$zze zza(Looper paramLooper, zzbo paramzzbo) {
    zzs zzs = zzahx();
    zzs.zzehh = this.mContext.getPackageName();
    zzs.zzfta = this.mContext.getClass().getName();
    zzr zzr = zzs.zzamn();
    return this.zzfop.zzahl().zza(this.mContext, paramLooper, zzr, this.zzfsm, (GoogleApiClient$ConnectionCallbacks)paramzzbo, (GoogleApiClient$OnConnectionFailedListener)paramzzbo);
  }
  
  public zzcv zza(Context paramContext, Handler paramHandler) {
    return new zzcv(paramContext, paramHandler, zzahx().zzamn());
  }
  
  public final zzm zzb(zzm paramzzm) {
    paramzzm.zzaiq();
    zzbm zzbm1 = this.zzfsq;
    zzc zzc = new zzc(paramzzm);
    zzbm1.mHandler.sendMessage(zzbm1.mHandler.obtainMessage(4, new zzcp((zza)zzc, zzbm1.zzfzm.get(), this)));
    return paramzzm;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\GoogleApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */