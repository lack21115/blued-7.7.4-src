package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzce;
import com.google.android.gms.internal.zzcyg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class GoogleApiClient$Builder {
  private final Context mContext;
  
  private Looper zzalj;
  
  private String zzehh;
  
  private Account zzeho;
  
  public final Set zzfsw = new HashSet();
  
  public final Set zzfsx = new HashSet();
  
  private String zzfta;
  
  private final Map zzftb = (Map)new ArrayMap();
  
  public final Map zzftc = (Map)new ArrayMap();
  
  private zzce zzftd;
  
  private int zzfte = -1;
  
  private GoogleApiClient$OnConnectionFailedListener zzftf;
  
  private GoogleApiAvailability zzftg = GoogleApiAvailability.getInstance();
  
  private Api$zza zzfth = zzcyg.zzegv;
  
  public final ArrayList zzfti = new ArrayList();
  
  public final ArrayList zzftj = new ArrayList();
  
  public GoogleApiClient$Builder(Context paramContext) {
    this.mContext = paramContext;
    this.zzalj = paramContext.getMainLooper();
    this.zzehh = paramContext.getPackageName();
    this.zzfta = paramContext.getClass().getName();
  }
  
  public final GoogleApiClient build() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzftc : Ljava/util/Map;
    //   4: invokeinterface isEmpty : ()Z
    //   9: iconst_1
    //   10: ixor
    //   11: ldc 'must call addApi() to add at least one API'
    //   13: invokestatic checkArgument : (ZLjava/lang/Object;)V
    //   16: getstatic com/google/android/gms/internal/zzcyk.zzklp : Lcom/google/android/gms/internal/zzcyk;
    //   19: astore #4
    //   21: aload_0
    //   22: getfield zzftc : Ljava/util/Map;
    //   25: getstatic com/google/android/gms/internal/zzcyg.API : Lcom/google/android/gms/common/api/Api;
    //   28: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   33: ifeq -> 53
    //   36: aload_0
    //   37: getfield zzftc : Ljava/util/Map;
    //   40: getstatic com/google/android/gms/internal/zzcyg.API : Lcom/google/android/gms/common/api/Api;
    //   43: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast com/google/android/gms/internal/zzcyk
    //   51: astore #4
    //   53: new com/google/android/gms/common/internal/zzr
    //   56: dup
    //   57: aload_0
    //   58: getfield zzeho : Landroid/accounts/Account;
    //   61: aload_0
    //   62: getfield zzfsw : Ljava/util/Set;
    //   65: aload_0
    //   66: getfield zzftb : Ljava/util/Map;
    //   69: aload_0
    //   70: getfield zzehh : Ljava/lang/String;
    //   73: aload_0
    //   74: getfield zzfta : Ljava/lang/String;
    //   77: aload #4
    //   79: invokespecial <init> : (Landroid/accounts/Account;Ljava/util/Set;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzcyk;)V
    //   82: astore #6
    //   84: aconst_null
    //   85: astore #4
    //   87: aload #6
    //   89: getfield zzgfr : Ljava/util/Map;
    //   92: astore #7
    //   94: new android/support/v4/util/ArrayMap
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: astore #8
    //   103: new android/support/v4/util/ArrayMap
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore #9
    //   112: new java/util/ArrayList
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: astore #10
    //   121: aload_0
    //   122: getfield zzftc : Ljava/util/Map;
    //   125: invokeinterface keySet : ()Ljava/util/Set;
    //   130: invokeinterface iterator : ()Ljava/util/Iterator;
    //   135: astore #11
    //   137: aload #11
    //   139: invokeinterface hasNext : ()Z
    //   144: istore_3
    //   145: iconst_0
    //   146: istore_2
    //   147: iload_3
    //   148: ifeq -> 367
    //   151: aload #11
    //   153: invokeinterface next : ()Ljava/lang/Object;
    //   158: checkcast com/google/android/gms/common/api/Api
    //   161: astore #5
    //   163: aload_0
    //   164: getfield zzftc : Ljava/util/Map;
    //   167: aload #5
    //   169: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   174: astore #12
    //   176: aload #7
    //   178: aload #5
    //   180: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   185: ifnull -> 190
    //   188: iconst_1
    //   189: istore_2
    //   190: aload #8
    //   192: aload #5
    //   194: iload_2
    //   195: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   198: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: new com/google/android/gms/common/api/internal/zzt
    //   207: dup
    //   208: aload #5
    //   210: iload_2
    //   211: invokespecial <init> : (Lcom/google/android/gms/common/api/Api;Z)V
    //   214: astore #13
    //   216: aload #10
    //   218: aload #13
    //   220: invokevirtual add : (Ljava/lang/Object;)Z
    //   223: pop
    //   224: aload #5
    //   226: invokevirtual zzahl : ()Lcom/google/android/gms/common/api/Api$zza;
    //   229: aload_0
    //   230: getfield mContext : Landroid/content/Context;
    //   233: aload_0
    //   234: getfield zzalj : Landroid/os/Looper;
    //   237: aload #6
    //   239: aload #12
    //   241: aload #13
    //   243: aload #13
    //   245: invokevirtual zza : (Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/zzr;Ljava/lang/Object;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/Api$zze;
    //   248: astore #12
    //   250: aload #9
    //   252: aload #5
    //   254: invokevirtual zzahm : ()Lcom/google/android/gms/common/api/Api$zzc;
    //   257: aload #12
    //   259: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: aload #12
    //   267: invokeinterface zzacn : ()Z
    //   272: ifeq -> 137
    //   275: aload #4
    //   277: ifnonnull -> 287
    //   280: aload #5
    //   282: astore #4
    //   284: goto -> 137
    //   287: aload #5
    //   289: getfield mName : Ljava/lang/String;
    //   292: astore #5
    //   294: aload #4
    //   296: getfield mName : Ljava/lang/String;
    //   299: astore #4
    //   301: new java/lang/StringBuilder
    //   304: dup
    //   305: aload #5
    //   307: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   310: invokevirtual length : ()I
    //   313: bipush #21
    //   315: iadd
    //   316: aload #4
    //   318: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   321: invokevirtual length : ()I
    //   324: iadd
    //   325: invokespecial <init> : (I)V
    //   328: astore #6
    //   330: aload #6
    //   332: aload #5
    //   334: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload #6
    //   340: ldc ' cannot be used with '
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload #6
    //   348: aload #4
    //   350: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: new java/lang/IllegalStateException
    //   357: dup
    //   358: aload #6
    //   360: invokevirtual toString : ()Ljava/lang/String;
    //   363: invokespecial <init> : (Ljava/lang/String;)V
    //   366: athrow
    //   367: aload #4
    //   369: ifnull -> 434
    //   372: aload_0
    //   373: getfield zzeho : Landroid/accounts/Account;
    //   376: ifnonnull -> 384
    //   379: iconst_1
    //   380: istore_2
    //   381: goto -> 386
    //   384: iconst_0
    //   385: istore_2
    //   386: iload_2
    //   387: ldc 'Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead'
    //   389: iconst_1
    //   390: anewarray java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: aload #4
    //   397: getfield mName : Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic zza : (ZLjava/lang/String;[Ljava/lang/Object;)V
    //   404: aload_0
    //   405: getfield zzfsw : Ljava/util/Set;
    //   408: aload_0
    //   409: getfield zzfsx : Ljava/util/Set;
    //   412: invokeinterface equals : (Ljava/lang/Object;)Z
    //   417: ldc 'Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.'
    //   419: iconst_1
    //   420: anewarray java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: aload #4
    //   427: getfield mName : Ljava/lang/String;
    //   430: aastore
    //   431: invokestatic zza : (ZLjava/lang/String;[Ljava/lang/Object;)V
    //   434: aload #9
    //   436: invokeinterface values : ()Ljava/util/Collection;
    //   441: iconst_1
    //   442: invokestatic zza : (Ljava/lang/Iterable;Z)I
    //   445: istore_1
    //   446: new com/google/android/gms/common/api/internal/zzba
    //   449: dup
    //   450: aload_0
    //   451: getfield mContext : Landroid/content/Context;
    //   454: new java/util/concurrent/locks/ReentrantLock
    //   457: dup
    //   458: invokespecial <init> : ()V
    //   461: aload_0
    //   462: getfield zzalj : Landroid/os/Looper;
    //   465: aload #6
    //   467: aload_0
    //   468: getfield zzftg : Lcom/google/android/gms/common/GoogleApiAvailability;
    //   471: aload_0
    //   472: getfield zzfth : Lcom/google/android/gms/common/api/Api$zza;
    //   475: aload #8
    //   477: aload_0
    //   478: getfield zzfti : Ljava/util/ArrayList;
    //   481: aload_0
    //   482: getfield zzftj : Ljava/util/ArrayList;
    //   485: aload #9
    //   487: aload_0
    //   488: getfield zzfte : I
    //   491: iload_1
    //   492: aload #10
    //   494: invokespecial <init> : (Landroid/content/Context;Ljava/util/concurrent/locks/Lock;Landroid/os/Looper;Lcom/google/android/gms/common/internal/zzr;Lcom/google/android/gms/common/GoogleApiAvailability;Lcom/google/android/gms/common/api/Api$zza;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;IILjava/util/ArrayList;)V
    //   497: astore #5
    //   499: invokestatic zzaib : ()Ljava/util/Set;
    //   502: astore #4
    //   504: aload #4
    //   506: monitorenter
    //   507: invokestatic zzaib : ()Ljava/util/Set;
    //   510: aload #5
    //   512: invokeinterface add : (Ljava/lang/Object;)Z
    //   517: pop
    //   518: aload #4
    //   520: monitorexit
    //   521: aload_0
    //   522: getfield zzfte : I
    //   525: iflt -> 548
    //   528: aload_0
    //   529: getfield zzftd : Lcom/google/android/gms/common/api/internal/zzce;
    //   532: invokestatic zza : (Lcom/google/android/gms/common/api/internal/zzce;)Lcom/google/android/gms/common/api/internal/zzi;
    //   535: aload_0
    //   536: getfield zzfte : I
    //   539: aload #5
    //   541: aload_0
    //   542: getfield zzftf : Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;
    //   545: invokevirtual zza : (ILcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)V
    //   548: aload #5
    //   550: areturn
    //   551: astore #5
    //   553: aload #4
    //   555: monitorexit
    //   556: aload #5
    //   558: athrow
    // Exception table:
    //   from	to	target	type
    //   507	521	551	finally
    //   553	556	551	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiClient$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */