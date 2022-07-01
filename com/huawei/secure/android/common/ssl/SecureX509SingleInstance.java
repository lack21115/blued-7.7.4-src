package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class SecureX509SingleInstance {
  private static final String a = SecureX509SingleInstance.class.getSimpleName();
  
  private static volatile SecureX509TrustManager b;
  
  public static SecureX509TrustManager a(Context paramContext) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 112
    //   4: aload_0
    //   5: invokestatic a : (Landroid/content/Context;)V
    //   8: getstatic com/huawei/secure/android/common/ssl/SecureX509SingleInstance.b : Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   11: ifnonnull -> 108
    //   14: ldc com/huawei/secure/android/common/ssl/SecureX509SingleInstance
    //   16: monitorenter
    //   17: getstatic com/huawei/secure/android/common/ssl/SecureX509SingleInstance.b : Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   20: ifnonnull -> 96
    //   23: aload_0
    //   24: invokestatic b : (Landroid/content/Context;)Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnonnull -> 53
    //   32: getstatic com/huawei/secure/android/common/ssl/SecureX509SingleInstance.a : Ljava/lang/String;
    //   35: ldc 'get assets bks'
    //   37: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   44: ldc 'hmsrootcas.bks'
    //   46: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   49: astore_1
    //   50: goto -> 61
    //   53: getstatic com/huawei/secure/android/common/ssl/SecureX509SingleInstance.a : Ljava/lang/String;
    //   56: ldc 'get files bks'
    //   58: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   61: new com/huawei/secure/android/common/ssl/SecureX509TrustManager
    //   64: dup
    //   65: aload_1
    //   66: ldc ''
    //   68: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   71: putstatic com/huawei/secure/android/common/ssl/SecureX509SingleInstance.b : Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   74: new com/huawei/secure/android/common/ssl/util/d
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: getstatic android/os/AsyncTask.THREAD_POOL_EXECUTOR : Ljava/util/concurrent/Executor;
    //   84: iconst_1
    //   85: anewarray android/content/Context
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: aastore
    //   92: invokevirtual executeOnExecutor : (Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   95: pop
    //   96: ldc com/huawei/secure/android/common/ssl/SecureX509SingleInstance
    //   98: monitorexit
    //   99: goto -> 108
    //   102: astore_0
    //   103: ldc com/huawei/secure/android/common/ssl/SecureX509SingleInstance
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    //   108: getstatic com/huawei/secure/android/common/ssl/SecureX509SingleInstance.b : Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   111: areturn
    //   112: new java/lang/NullPointerException
    //   115: dup
    //   116: ldc 'context is null'
    //   118: invokespecial <init> : (Ljava/lang/String;)V
    //   121: athrow
    // Exception table:
    //   from	to	target	type
    //   17	28	102	finally
    //   32	50	102	finally
    //   53	61	102	finally
    //   61	96	102	finally
    //   96	99	102	finally
    //   103	106	102	finally
  }
  
  public static void a(InputStream paramInputStream) {
    g.b(a, "update bks");
    if (paramInputStream != null && b != null) {
      b = new SecureX509TrustManager(paramInputStream, "");
      SecureSSLSocketFactory.a(b);
      SecureApacheSSLSocketFactory.a(b);
      if (b != null && b.getAcceptedIssuers() != null) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("after updata bks , ca size is : ");
        stringBuilder.append((b.getAcceptedIssuers()).length);
        g.a(str, stringBuilder.toString());
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\SecureX509SingleInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */