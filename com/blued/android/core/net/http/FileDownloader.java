package com.blued.android.core.net.http;

import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import java.io.File;

public class FileDownloader {
  public static void a(String paramString, BinaryHttpResponseHandler paramBinaryHttpResponseHandler) {
    if (HttpManager.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("downloadToMemory(), url:");
      stringBuilder.append(paramString);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    OkHttpUtils.a(paramString, paramBinaryHttpResponseHandler);
  }
  
  public static void a(String paramString1, String paramString2, FileHttpResponseHandler paramFileHttpResponseHandler) {
    b(paramString1, paramString2, paramFileHttpResponseHandler, null);
  }
  
  public static void a(String paramString1, String paramString2, FileHttpResponseHandler paramFileHttpResponseHandler, IRequestHost paramIRequestHost) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 14
    //   7: aload_2
    //   8: astore #4
    //   10: aload_2
    //   11: ifnonnull -> 23
    //   14: new com/blued/android/core/net/http/FileDownloader$1
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #4
    //   23: aload #4
    //   25: invokevirtual sendStartMessage : ()V
    //   28: aload_0
    //   29: aload_1
    //   30: aload #4
    //   32: aload_3
    //   33: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lcom/blued/android/core/net/FileHttpResponseHandler;Lcom/blued/android/core/net/IRequestHost;)V
    //   36: return
  }
  
  public static void b(String paramString1, String paramString2, FileHttpResponseHandler paramFileHttpResponseHandler, IRequestHost paramIRequestHost) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 14
    //   7: aload_2
    //   8: astore #4
    //   10: aload_2
    //   11: ifnonnull -> 23
    //   14: new com/blued/android/core/net/http/FileDownloader$2
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #4
    //   23: aload #4
    //   25: invokevirtual sendStartMessage : ()V
    //   28: aload_0
    //   29: aload_1
    //   30: aload #4
    //   32: aload_3
    //   33: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Lcom/blued/android/core/net/FileHttpResponseHandler;Lcom/blued/android/core/net/IRequestHost;)V
    //   36: return
    //   37: astore_1
    //   38: invokestatic c : ()Z
    //   41: ifeq -> 88
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore_2
    //   52: aload_2
    //   53: ldc '文件下载失败, url:'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: aload_0
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc ', exception:'
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_2
    //   73: aload_1
    //   74: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: ldc 'HttpManager'
    //   80: aload_2
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   87: pop
    //   88: return
    // Exception table:
    //   from	to	target	type
    //   28	36	37	com/blued/android/core/net/exception/OkHttpException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\FileDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */