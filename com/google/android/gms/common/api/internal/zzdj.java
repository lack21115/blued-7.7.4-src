package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;

final class zzdj extends Handler {
  public final void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: tableswitch default -> 28, 0 -> 119, 1 -> 67
    //   28: aload_1
    //   29: getfield what : I
    //   32: istore_2
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: bipush #70
    //   39: invokespecial <init> : (I)V
    //   42: astore_1
    //   43: aload_1
    //   44: ldc 'TransformationResultHandler received unknown message type: '
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_1
    //   51: iload_2
    //   52: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 'TransformedResultImpl'
    //   58: aload_1
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: return
    //   67: aload_1
    //   68: getfield obj : Ljava/lang/Object;
    //   71: checkcast java/lang/RuntimeException
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual getMessage : ()Ljava/lang/String;
    //   79: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual length : ()I
    //   87: ifeq -> 100
    //   90: ldc 'Runtime exception on the transformation worker thread: '
    //   92: aload_1
    //   93: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_1
    //   97: goto -> 110
    //   100: new java/lang/String
    //   103: dup
    //   104: ldc 'Runtime exception on the transformation worker thread: '
    //   106: invokespecial <init> : (Ljava/lang/String;)V
    //   109: astore_1
    //   110: ldc 'TransformedResultImpl'
    //   112: aload_1
    //   113: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: aload_3
    //   118: athrow
    //   119: aload_1
    //   120: getfield obj : Ljava/lang/Object;
    //   123: checkcast com/google/android/gms/common/api/PendingResult
    //   126: astore #5
    //   128: aload_0
    //   129: getfield zzgbp : Lcom/google/android/gms/common/api/internal/zzdh;
    //   132: getfield zzfvc : Ljava/lang/Object;
    //   135: astore_1
    //   136: aload_1
    //   137: monitorenter
    //   138: aload #5
    //   140: ifnonnull -> 167
    //   143: aload_0
    //   144: getfield zzgbp : Lcom/google/android/gms/common/api/internal/zzdh;
    //   147: getfield zzgbi : Lcom/google/android/gms/common/api/internal/zzdh;
    //   150: new com/google/android/gms/common/api/Status
    //   153: dup
    //   154: bipush #13
    //   156: ldc 'Transform returned null'
    //   158: invokespecial <init> : (ILjava/lang/String;)V
    //   161: invokevirtual zzd : (Lcom/google/android/gms/common/api/Status;)V
    //   164: goto -> 324
    //   167: aload #5
    //   169: instanceof com/google/android/gms/common/api/internal/zzct
    //   172: ifeq -> 196
    //   175: aload_0
    //   176: getfield zzgbp : Lcom/google/android/gms/common/api/internal/zzdh;
    //   179: getfield zzgbi : Lcom/google/android/gms/common/api/internal/zzdh;
    //   182: aload #5
    //   184: checkcast com/google/android/gms/common/api/internal/zzct
    //   187: getfield mStatus : Lcom/google/android/gms/common/api/Status;
    //   190: invokevirtual zzd : (Lcom/google/android/gms/common/api/Status;)V
    //   193: goto -> 324
    //   196: aload_0
    //   197: getfield zzgbp : Lcom/google/android/gms/common/api/internal/zzdh;
    //   200: getfield zzgbi : Lcom/google/android/gms/common/api/internal/zzdh;
    //   203: astore #4
    //   205: aload #4
    //   207: getfield zzfvc : Ljava/lang/Object;
    //   210: astore_3
    //   211: aload_3
    //   212: monitorenter
    //   213: aload #4
    //   215: aload #5
    //   217: putfield zzgbk : Lcom/google/android/gms/common/api/PendingResult;
    //   220: aload #4
    //   222: getfield zzgbh : Lcom/google/android/gms/common/api/ResultTransform;
    //   225: ifnonnull -> 236
    //   228: aload #4
    //   230: getfield zzgbj : Lcom/google/android/gms/common/api/ResultCallbacks;
    //   233: ifnull -> 322
    //   236: aload #4
    //   238: getfield zzfve : Ljava/lang/ref/WeakReference;
    //   241: invokevirtual get : ()Ljava/lang/Object;
    //   244: checkcast com/google/android/gms/common/api/GoogleApiClient
    //   247: astore #5
    //   249: aload #4
    //   251: getfield zzgbn : Z
    //   254: ifne -> 283
    //   257: aload #4
    //   259: getfield zzgbh : Lcom/google/android/gms/common/api/ResultTransform;
    //   262: ifnull -> 283
    //   265: aload #5
    //   267: ifnull -> 283
    //   270: aload #5
    //   272: aload #4
    //   274: invokevirtual zza : (Lcom/google/android/gms/common/api/internal/zzdh;)V
    //   277: aload #4
    //   279: iconst_1
    //   280: putfield zzgbn : Z
    //   283: aload #4
    //   285: getfield zzgbl : Lcom/google/android/gms/common/api/Status;
    //   288: ifnull -> 304
    //   291: aload #4
    //   293: aload #4
    //   295: getfield zzgbl : Lcom/google/android/gms/common/api/Status;
    //   298: invokevirtual zzx : (Lcom/google/android/gms/common/api/Status;)V
    //   301: goto -> 322
    //   304: aload #4
    //   306: getfield zzgbk : Lcom/google/android/gms/common/api/PendingResult;
    //   309: ifnull -> 322
    //   312: aload #4
    //   314: getfield zzgbk : Lcom/google/android/gms/common/api/PendingResult;
    //   317: aload #4
    //   319: invokevirtual setResultCallback : (Lcom/google/android/gms/common/api/ResultCallback;)V
    //   322: aload_3
    //   323: monitorexit
    //   324: aload_1
    //   325: monitorexit
    //   326: return
    //   327: astore #4
    //   329: aload_3
    //   330: monitorexit
    //   331: aload #4
    //   333: athrow
    //   334: aload_1
    //   335: monitorexit
    //   336: aload_3
    //   337: athrow
    //   338: astore_3
    //   339: goto -> 334
    // Exception table:
    //   from	to	target	type
    //   143	164	338	finally
    //   167	193	338	finally
    //   196	213	338	finally
    //   213	236	327	finally
    //   236	265	327	finally
    //   270	283	327	finally
    //   283	301	327	finally
    //   304	322	327	finally
    //   322	324	327	finally
    //   324	326	338	finally
    //   329	331	327	finally
    //   331	334	338	finally
    //   334	336	338	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */