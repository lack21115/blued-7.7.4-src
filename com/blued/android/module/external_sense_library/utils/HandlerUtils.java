package com.blued.android.module.external_sense_library.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.nio.ByteBuffer;

public class HandlerUtils {
  private Handler a = new Handler(this, Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        if (param1Message.what != 150)
          return; 
        ByteBuffer byteBuffer = (ByteBuffer)param1Message.obj;
        Bundle bundle = param1Message.getData();
        int i = bundle.getInt("imageWidth");
        int j = bundle.getInt("imageHeight");
        HandlerUtils.a(this.a, byteBuffer, FileUtils.a(param1Message.arg1), i, j);
      }
    };
  
  public static void a(File paramFile, Bitmap paramBitmap) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new java/io/BufferedOutputStream
    //   5: dup
    //   6: new java/io/FileOutputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Ljava/io/File;)V
    //   14: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_2
    //   20: aload_1
    //   21: getstatic android/graphics/Bitmap$CompressFormat.JPEG : Landroid/graphics/Bitmap$CompressFormat;
    //   24: bipush #90
    //   26: aload_3
    //   27: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   30: pop
    //   31: aload_3
    //   32: invokevirtual close : ()V
    //   35: goto -> 75
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: aload_2
    //   42: astore_3
    //   43: goto -> 53
    //   46: astore_0
    //   47: goto -> 132
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: astore_2
    //   55: aload_3
    //   56: invokevirtual printStackTrace : ()V
    //   59: aload_1
    //   60: ifnull -> 75
    //   63: aload_1
    //   64: invokevirtual close : ()V
    //   67: goto -> 75
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual printStackTrace : ()V
    //   75: aload_0
    //   76: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   79: astore_1
    //   80: new android/content/Intent
    //   83: dup
    //   84: ldc 'android.intent.action.MEDIA_SCANNER_SCAN_FILE'
    //   86: invokespecial <init> : (Ljava/lang/String;)V
    //   89: astore_2
    //   90: aload_2
    //   91: aload_0
    //   92: invokestatic fromFile : (Ljava/io/File;)Landroid/net/Uri;
    //   95: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   98: pop
    //   99: invokestatic d : ()Landroid/content/Context;
    //   102: aload_2
    //   103: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   106: getstatic android/os/Build$VERSION.SDK_INT : I
    //   109: bipush #19
    //   111: if_icmplt -> 130
    //   114: invokestatic d : ()Landroid/content/Context;
    //   117: iconst_1
    //   118: anewarray java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: aload_1
    //   124: aastore
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokestatic scanFile : (Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    //   130: return
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull -> 148
    //   136: aload_2
    //   137: invokevirtual close : ()V
    //   140: goto -> 148
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual printStackTrace : ()V
    //   148: aload_0
    //   149: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	50	java/io/FileNotFoundException
    //   2	18	46	finally
    //   20	31	38	java/io/FileNotFoundException
    //   20	31	131	finally
    //   31	35	70	java/io/IOException
    //   55	59	131	finally
    //   63	67	70	java/io/IOException
    //   136	140	143	java/io/IOException
  }
  
  private void a(ByteBuffer paramByteBuffer, File paramFile, int paramInt1, int paramInt2) {
    if (paramInt1 > 0) {
      if (paramInt2 <= 0)
        return; 
      Bitmap bitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramByteBuffer.position(0);
      bitmap.copyPixelsFromBuffer(paramByteBuffer);
      a(paramFile, bitmap);
      bitmap.recycle();
    } 
  }
  
  public Handler a() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\HandlerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */