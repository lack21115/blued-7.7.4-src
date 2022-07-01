package com.tencent.bugly.yaq.proguard;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;

public interface t {
  void a(boolean paramBoolean);
  
  final class a implements Runnable {
    private final Context a;
    
    private final Runnable b;
    
    private final long c;
    
    public a(t this$0, Context param1Context) {
      this.a = param1Context;
      this.b = null;
      this.c = 0L;
    }
    
    public a(t this$0, Context param1Context, Runnable param1Runnable, long param1Long) {
      this.a = param1Context;
      this.b = param1Runnable;
      this.c = param1Long;
    }
    
    public final void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Landroid/content/Context;
      //   4: ldc 'security_info'
      //   6: ldc2_w 30000
      //   9: invokestatic a : (Landroid/content/Context;Ljava/lang/String;J)Z
      //   12: ifne -> 122
      //   15: ldc '[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)'
      //   17: iconst_3
      //   18: anewarray java/lang/Object
      //   21: dup
      //   22: iconst_0
      //   23: sipush #5000
      //   26: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   29: aastore
      //   30: dup
      //   31: iconst_1
      //   32: invokestatic myPid : ()I
      //   35: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   38: aastore
      //   39: dup
      //   40: iconst_2
      //   41: invokestatic myTid : ()I
      //   44: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   47: aastore
      //   48: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   51: pop
      //   52: ldc2_w 5000
      //   55: invokestatic sleep : (J)V
      //   58: aload_0
      //   59: ldc 'BUGLY_ASYNC_UPLOAD'
      //   61: invokestatic a : (Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
      //   64: ifnonnull -> 91
      //   67: ldc '[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.'
      //   69: iconst_0
      //   70: anewarray java/lang/Object
      //   73: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   76: pop
      //   77: invokestatic a : ()Lcom/tencent/bugly/yaq/proguard/v;
      //   80: astore_1
      //   81: aload_1
      //   82: ifnull -> 109
      //   85: aload_1
      //   86: aload_0
      //   87: invokevirtual a : (Ljava/lang/Runnable;)Z
      //   90: pop
      //   91: new java/lang/VerifyError
      //   94: dup
      //   95: ldc 'bad dex opcode'
      //   97: invokespecial <init> : (Ljava/lang/String;)V
      //   100: athrow
      //   101: astore_1
      //   102: aload_1
      //   103: invokevirtual printStackTrace : ()V
      //   106: goto -> 58
      //   109: ldc '[UploadManager] Asynchronous thread pool is unavailable now, try next time.'
      //   111: iconst_0
      //   112: anewarray java/lang/Object
      //   115: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   118: pop
      //   119: goto -> 91
      //   122: aload_0
      //   123: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   126: invokestatic c : (Lcom/tencent/bugly/yaq/proguard/t;)Z
      //   129: ifne -> 150
      //   132: ldc '[UploadManager] Failed to load security info from database'
      //   134: iconst_0
      //   135: anewarray java/lang/Object
      //   138: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   141: pop
      //   142: aload_0
      //   143: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   146: iconst_0
      //   147: invokevirtual b : (Z)V
      //   150: aload_0
      //   151: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   154: invokestatic d : (Lcom/tencent/bugly/yaq/proguard/t;)Ljava/lang/String;
      //   157: ifnull -> 285
      //   160: aload_0
      //   161: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   164: invokevirtual b : ()Z
      //   167: ifeq -> 267
      //   170: ldc '[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)'
      //   172: iconst_2
      //   173: anewarray java/lang/Object
      //   176: dup
      //   177: iconst_0
      //   178: invokestatic myPid : ()I
      //   181: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   184: aastore
      //   185: dup
      //   186: iconst_1
      //   187: invokestatic myTid : ()I
      //   190: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   193: aastore
      //   194: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   197: pop
      //   198: aload_0
      //   199: getfield b : Ljava/lang/Runnable;
      //   202: ifnull -> 220
      //   205: aload_0
      //   206: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   209: aload_0
      //   210: getfield b : Ljava/lang/Runnable;
      //   213: aload_0
      //   214: getfield c : J
      //   217: invokestatic a : (Lcom/tencent/bugly/yaq/proguard/t;Ljava/lang/Runnable;J)V
      //   220: aload_0
      //   221: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   224: iconst_0
      //   225: invokestatic a : (Lcom/tencent/bugly/yaq/proguard/t;I)V
      //   228: aload_0
      //   229: getfield a : Landroid/content/Context;
      //   232: ldc 'security_info'
      //   234: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
      //   237: pop
      //   238: aload_0
      //   239: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   242: invokestatic e : (Lcom/tencent/bugly/yaq/proguard/t;)Ljava/lang/Object;
      //   245: astore_1
      //   246: aload_1
      //   247: monitorenter
      //   248: aload_0
      //   249: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   252: iconst_0
      //   253: invokestatic a : (Lcom/tencent/bugly/yaq/proguard/t;Z)Z
      //   256: pop
      //   257: aload_1
      //   258: monitorexit
      //   259: goto -> 91
      //   262: astore_2
      //   263: aload_1
      //   264: monitorexit
      //   265: aload_2
      //   266: athrow
      //   267: ldc '[UploadManager] Session ID is expired, drop it.'
      //   269: iconst_0
      //   270: anewarray java/lang/Object
      //   273: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   276: pop
      //   277: aload_0
      //   278: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   281: iconst_1
      //   282: invokevirtual b : (Z)V
      //   285: sipush #128
      //   288: invokestatic a : (I)[B
      //   291: astore_1
      //   292: aload_1
      //   293: ifnull -> 379
      //   296: aload_1
      //   297: arraylength
      //   298: iconst_3
      //   299: ishl
      //   300: sipush #128
      //   303: if_icmpne -> 379
      //   306: aload_0
      //   307: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   310: aload_1
      //   311: invokestatic a : (Lcom/tencent/bugly/yaq/proguard/t;[B)[B
      //   314: pop
      //   315: ldc '[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)'
      //   317: iconst_2
      //   318: anewarray java/lang/Object
      //   321: dup
      //   322: iconst_0
      //   323: invokestatic myPid : ()I
      //   326: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   329: aastore
      //   330: dup
      //   331: iconst_1
      //   332: invokestatic myTid : ()I
      //   335: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   338: aastore
      //   339: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   342: pop
      //   343: aload_0
      //   344: getfield b : Ljava/lang/Runnable;
      //   347: ifnull -> 368
      //   350: aload_0
      //   351: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   354: aload_0
      //   355: getfield b : Ljava/lang/Runnable;
      //   358: aload_0
      //   359: getfield c : J
      //   362: invokestatic a : (Lcom/tencent/bugly/yaq/proguard/t;Ljava/lang/Runnable;J)V
      //   365: goto -> 91
      //   368: aload_0
      //   369: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   372: iconst_1
      //   373: invokestatic a : (Lcom/tencent/bugly/yaq/proguard/t;I)V
      //   376: goto -> 91
      //   379: ldc '[UploadManager] Failed to create AES key (pid=%d | tid=%d)'
      //   381: iconst_2
      //   382: anewarray java/lang/Object
      //   385: dup
      //   386: iconst_0
      //   387: invokestatic myPid : ()I
      //   390: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   393: aastore
      //   394: dup
      //   395: iconst_1
      //   396: invokestatic myTid : ()I
      //   399: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   402: aastore
      //   403: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
      //   406: pop
      //   407: aload_0
      //   408: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   411: iconst_0
      //   412: invokevirtual b : (Z)V
      //   415: aload_0
      //   416: getfield a : Landroid/content/Context;
      //   419: ldc 'security_info'
      //   421: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
      //   424: pop
      //   425: aload_0
      //   426: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   429: invokestatic e : (Lcom/tencent/bugly/yaq/proguard/t;)Ljava/lang/Object;
      //   432: astore_1
      //   433: aload_1
      //   434: monitorenter
      //   435: aload_0
      //   436: getfield d : Lcom/tencent/bugly/yaq/proguard/t;
      //   439: iconst_0
      //   440: invokestatic a : (Lcom/tencent/bugly/yaq/proguard/t;Z)Z
      //   443: pop
      //   444: aload_1
      //   445: monitorexit
      //   446: goto -> 91
      //   449: astore_2
      //   450: aload_1
      //   451: monitorexit
      //   452: aload_2
      //   453: athrow
      // Exception table:
      //   from	to	target	type
      //   52	58	101	java/lang/InterruptedException
      //   248	259	262	finally
      //   435	446	449	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */