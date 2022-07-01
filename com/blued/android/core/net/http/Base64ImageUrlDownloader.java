package com.blued.android.core.net.http;

import android.text.TextUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;

public class Base64ImageUrlDownloader {
  public static void a(String paramString1, String paramString2, FileHttpResponseHandler paramFileHttpResponseHandler, IRequestHost paramIRequestHost) {
    // Byte code:
    //   0: aload_0
    //   1: ldc ';base64,'
    //   3: invokevirtual indexOf : (Ljava/lang/String;)I
    //   6: istore #4
    //   8: iload #4
    //   10: ifle -> 244
    //   13: aload_0
    //   14: iload #4
    //   16: bipush #8
    //   18: iadd
    //   19: invokevirtual substring : (I)Ljava/lang/String;
    //   22: astore_3
    //   23: new java/io/File
    //   26: dup
    //   27: aload_1
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: astore #5
    //   33: aload #5
    //   35: invokevirtual exists : ()Z
    //   38: ifne -> 47
    //   41: aload #5
    //   43: invokevirtual createNewFile : ()Z
    //   46: pop
    //   47: new java/io/FileOutputStream
    //   50: dup
    //   51: aload #5
    //   53: invokespecial <init> : (Ljava/io/File;)V
    //   56: astore_1
    //   57: aload_1
    //   58: aload_3
    //   59: iconst_0
    //   60: invokestatic decode : (Ljava/lang/String;I)[B
    //   63: invokevirtual write : ([B)V
    //   66: aload_1
    //   67: invokevirtual flush : ()V
    //   70: aload_2
    //   71: ifnull -> 84
    //   74: aload_2
    //   75: aload_0
    //   76: sipush #200
    //   79: aload #5
    //   81: invokevirtual sendSuccessMessage : (Ljava/lang/String;ILjava/lang/Object;)V
    //   84: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   87: aconst_null
    //   88: invokevirtual a : ([B)V
    //   91: aload_1
    //   92: invokestatic a : (Ljava/io/OutputStream;)V
    //   95: aload_2
    //   96: ifnull -> 244
    //   99: goto -> 217
    //   102: astore_0
    //   103: goto -> 223
    //   106: astore #5
    //   108: aload_1
    //   109: astore_3
    //   110: goto -> 130
    //   113: astore #5
    //   115: aload_1
    //   116: astore_3
    //   117: goto -> 176
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -> 223
    //   126: astore #5
    //   128: aconst_null
    //   129: astore_3
    //   130: aload_3
    //   131: astore_1
    //   132: aload #5
    //   134: invokevirtual printStackTrace : ()V
    //   137: aload_2
    //   138: ifnull -> 154
    //   141: aload_3
    //   142: astore_1
    //   143: aload_2
    //   144: aload_0
    //   145: aload #5
    //   147: sipush #-2001
    //   150: aconst_null
    //   151: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   154: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   157: aconst_null
    //   158: invokevirtual a : ([B)V
    //   161: aload_3
    //   162: invokestatic a : (Ljava/io/OutputStream;)V
    //   165: aload_2
    //   166: ifnull -> 244
    //   169: goto -> 217
    //   172: astore #5
    //   174: aconst_null
    //   175: astore_3
    //   176: aload_3
    //   177: astore_1
    //   178: aload #5
    //   180: invokevirtual printStackTrace : ()V
    //   183: aload_2
    //   184: ifnull -> 202
    //   187: aload_3
    //   188: astore_1
    //   189: aload_2
    //   190: aload_0
    //   191: aload #5
    //   193: aload #5
    //   195: invokestatic a : (Ljava/io/IOException;)I
    //   198: aconst_null
    //   199: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   202: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   205: aconst_null
    //   206: invokevirtual a : ([B)V
    //   209: aload_3
    //   210: invokestatic a : (Ljava/io/OutputStream;)V
    //   213: aload_2
    //   214: ifnull -> 244
    //   217: aload_2
    //   218: invokevirtual sendFinishMessage : ()V
    //   221: return
    //   222: astore_0
    //   223: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   226: aconst_null
    //   227: invokevirtual a : ([B)V
    //   230: aload_1
    //   231: invokestatic a : (Ljava/io/OutputStream;)V
    //   234: aload_2
    //   235: ifnull -> 242
    //   238: aload_2
    //   239: invokevirtual sendFinishMessage : ()V
    //   242: aload_0
    //   243: athrow
    //   244: return
    // Exception table:
    //   from	to	target	type
    //   23	47	172	java/io/IOException
    //   23	47	126	java/lang/Exception
    //   23	47	120	finally
    //   47	57	172	java/io/IOException
    //   47	57	126	java/lang/Exception
    //   47	57	120	finally
    //   57	70	113	java/io/IOException
    //   57	70	106	java/lang/Exception
    //   57	70	102	finally
    //   74	84	113	java/io/IOException
    //   74	84	106	java/lang/Exception
    //   74	84	102	finally
    //   132	137	222	finally
    //   143	154	222	finally
    //   178	183	222	finally
    //   189	202	222	finally
  }
  
  public static boolean a(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ((paramString.startsWith("data:image/gif;base64,") || paramString.startsWith("data:image/png;base64,") || paramString.startsWith("data:image/jpeg;base64,") || paramString.startsWith("data:image/x-icon;base64,")));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\Base64ImageUrlDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */