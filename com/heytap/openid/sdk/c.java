package com.heytap.openid.sdk;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class c {
  public com.heytap.openid.a a = null;
  
  public String b = null;
  
  public String c = null;
  
  public final Object d = new Object();
  
  public ServiceConnection e = new b(this);
  
  public String a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic myLooper : ()Landroid/os/Looper;
    //   5: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   8: if_acmpeq -> 157
    //   11: aload_0
    //   12: getfield a : Lcom/heytap/openid/a;
    //   15: ifnonnull -> 136
    //   18: new android/content/Intent
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_3
    //   26: aload_3
    //   27: new android/content/ComponentName
    //   30: dup
    //   31: ldc 'com.heytap.openid'
    //   33: ldc 'com.heytap.openid.IdentifyService'
    //   35: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: invokevirtual setComponent : (Landroid/content/ComponentName;)Landroid/content/Intent;
    //   41: pop
    //   42: aload_3
    //   43: ldc 'action.com.heytap.openid.OPEN_ID_SERVICE'
    //   45: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   48: pop
    //   49: aload_1
    //   50: aload_3
    //   51: aload_0
    //   52: getfield e : Landroid/content/ServiceConnection;
    //   55: iconst_1
    //   56: invokevirtual bindService : (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   59: ifeq -> 81
    //   62: aload_0
    //   63: getfield d : Ljava/lang/Object;
    //   66: astore_3
    //   67: aload_3
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield d : Ljava/lang/Object;
    //   73: ldc2_w 3000
    //   76: invokevirtual wait : (J)V
    //   79: aload_3
    //   80: monitorexit
    //   81: aload_0
    //   82: getfield a : Lcom/heytap/openid/a;
    //   85: ifnonnull -> 115
    //   88: ldc ''
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: areturn
    //   95: astore #4
    //   97: aload #4
    //   99: invokevirtual printStackTrace : ()V
    //   102: goto -> 79
    //   105: astore_1
    //   106: aload_3
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: aload_0
    //   116: aload_1
    //   117: aload_2
    //   118: invokevirtual b : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore_1
    //   122: goto -> 91
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual printStackTrace : ()V
    //   130: ldc ''
    //   132: astore_1
    //   133: goto -> 91
    //   136: aload_0
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual b : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_1
    //   143: goto -> 91
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual printStackTrace : ()V
    //   151: ldc ''
    //   153: astore_1
    //   154: goto -> 91
    //   157: new java/lang/IllegalStateException
    //   160: dup
    //   161: ldc 'Cannot run on MainThread'
    //   163: invokespecial <init> : (Ljava/lang/String;)V
    //   166: athrow
    // Exception table:
    //   from	to	target	type
    //   2	69	110	finally
    //   69	79	95	java/lang/InterruptedException
    //   69	79	105	finally
    //   79	81	105	finally
    //   81	88	110	finally
    //   97	102	105	finally
    //   106	108	105	finally
    //   108	110	110	finally
    //   115	122	125	android/os/RemoteException
    //   115	122	110	finally
    //   126	130	110	finally
    //   136	143	146	android/os/RemoteException
    //   136	143	110	finally
    //   147	151	110	finally
    //   157	167	110	finally
  }
  
  public boolean a(Context paramContext) {
    boolean bool = true;
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      PackageInfo packageInfo = packageManager.getPackageInfo("com.heytap.openid", 0);
      if (Build.VERSION.SDK_INT >= 28) {
        if (packageInfo != null && packageInfo.getLongVersionCode() >= 1L)
          return true; 
      } else {
        if (packageInfo != null) {
          int i = packageInfo.versionCode;
          if (i < 1)
            return false; 
        } else {
          return false;
        } 
        return bool;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return false;
    } 
    return false;
  }
  
  public final String b(Context paramContext, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aload_0
    //   4: getfield b : Ljava/lang/String;
    //   7: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   10: ifeq -> 21
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual getPackageName : ()Ljava/lang/String;
    //   18: putfield b : Ljava/lang/String;
    //   21: aload_0
    //   22: getfield c : Ljava/lang/String;
    //   25: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   28: ifeq -> 177
    //   31: aload_0
    //   32: getfield b : Ljava/lang/String;
    //   35: astore #5
    //   37: aload_1
    //   38: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   41: aload #5
    //   43: bipush #64
    //   45: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   48: getfield signatures : [Landroid/content/pm/Signature;
    //   51: astore #5
    //   53: aload #6
    //   55: astore_1
    //   56: aload #5
    //   58: ifnull -> 172
    //   61: aload #6
    //   63: astore_1
    //   64: aload #5
    //   66: arraylength
    //   67: ifle -> 172
    //   70: aload #5
    //   72: iconst_0
    //   73: aaload
    //   74: invokevirtual toByteArray : ()[B
    //   77: astore #5
    //   79: ldc 'SHA1'
    //   81: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   84: astore #7
    //   86: aload #6
    //   88: astore_1
    //   89: aload #7
    //   91: ifnull -> 172
    //   94: aload #7
    //   96: aload #5
    //   98: invokevirtual digest : ([B)[B
    //   101: astore_1
    //   102: new java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial <init> : ()V
    //   109: astore #5
    //   111: aload_1
    //   112: arraylength
    //   113: istore #4
    //   115: iconst_0
    //   116: istore_3
    //   117: iload_3
    //   118: iload #4
    //   120: if_icmpge -> 166
    //   123: aload #5
    //   125: aload_1
    //   126: iload_3
    //   127: baload
    //   128: sipush #255
    //   131: iand
    //   132: sipush #256
    //   135: ior
    //   136: invokestatic toHexString : (I)Ljava/lang/String;
    //   139: iconst_1
    //   140: iconst_3
    //   141: invokevirtual substring : (II)Ljava/lang/String;
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: iload_3
    //   149: iconst_1
    //   150: iadd
    //   151: istore_3
    //   152: goto -> 117
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual printStackTrace : ()V
    //   160: aconst_null
    //   161: astore #5
    //   163: goto -> 53
    //   166: aload #5
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_0
    //   173: aload_1
    //   174: putfield c : Ljava/lang/String;
    //   177: aload_0
    //   178: getfield a : Lcom/heytap/openid/a;
    //   181: astore_1
    //   182: aload_0
    //   183: getfield b : Ljava/lang/String;
    //   186: astore #5
    //   188: aload_0
    //   189: getfield c : Ljava/lang/String;
    //   192: astore #6
    //   194: aload_1
    //   195: checkcast com/heytap/openid/a$a$a
    //   198: aload #5
    //   200: aload #6
    //   202: aload_2
    //   203: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   206: astore_2
    //   207: aload_2
    //   208: astore_1
    //   209: aload_2
    //   210: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   213: ifeq -> 219
    //   216: ldc ''
    //   218: astore_1
    //   219: aload_1
    //   220: areturn
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual printStackTrace : ()V
    //   226: aload #6
    //   228: astore_1
    //   229: goto -> 172
    // Exception table:
    //   from	to	target	type
    //   37	53	155	android/content/pm/PackageManager$NameNotFoundException
    //   79	86	221	java/security/NoSuchAlgorithmException
    //   94	115	221	java/security/NoSuchAlgorithmException
    //   123	148	221	java/security/NoSuchAlgorithmException
    //   166	172	221	java/security/NoSuchAlgorithmException
  }
  
  private static class a {
    public static final c a = new c(null);
    
    static {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\heytap\openid\sdk\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */