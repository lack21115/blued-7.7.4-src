package com.datavisor.vangogh.storage.local;

import android.content.Context;
import com.datavisor.vangogh.f.d;

public class a {
  public static String a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic a : (Ljava/lang/String;)Z
    //   4: ifeq -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #4
    //   18: aload #4
    //   20: aload_1
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #4
    //   27: ldc '.mp3'
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload #4
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: astore_1
    //   39: new java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: astore #4
    //   48: aload #4
    //   50: ldc '_display_name = ''
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #4
    //   58: aload_1
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #4
    //   65: ldc '''
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #4
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   81: getstatic android/provider/MediaStore$Audio$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   84: iconst_1
    //   85: anewarray java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: ldc '_id'
    //   92: aastore
    //   93: aload_1
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore #4
    //   101: aload #4
    //   103: ifnull -> 311
    //   106: aload #4
    //   108: invokeinterface moveToFirst : ()Z
    //   113: ifeq -> 311
    //   116: aload #4
    //   118: aload #4
    //   120: ldc '_id'
    //   122: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   127: invokeinterface getInt : (I)I
    //   132: istore_2
    //   133: getstatic android/provider/MediaStore$Audio$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   136: astore_1
    //   137: new java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial <init> : ()V
    //   144: astore #5
    //   146: aload #5
    //   148: ldc ''
    //   150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload #5
    //   156: iload_2
    //   157: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: aload #5
    //   164: invokevirtual toString : ()Ljava/lang/String;
    //   167: invokestatic withAppendedPath : (Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull -> 289
    //   175: aload_0
    //   176: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   179: aload_1
    //   180: invokevirtual openInputStream : (Landroid/net/Uri;)Ljava/io/InputStream;
    //   183: astore_0
    //   184: new java/io/ByteArrayOutputStream
    //   187: dup
    //   188: invokespecial <init> : ()V
    //   191: astore_1
    //   192: sipush #512
    //   195: newarray byte
    //   197: astore #5
    //   199: aload_0
    //   200: aload #5
    //   202: iconst_0
    //   203: sipush #512
    //   206: invokevirtual read : ([BII)I
    //   209: istore_2
    //   210: iload_2
    //   211: iconst_m1
    //   212: if_icmpeq -> 226
    //   215: aload_1
    //   216: aload #5
    //   218: iconst_0
    //   219: iload_2
    //   220: invokevirtual write : ([BII)V
    //   223: goto -> 199
    //   226: aload_1
    //   227: invokevirtual toByteArray : ()[B
    //   230: invokestatic a2d : ([B)[B
    //   233: astore_0
    //   234: aload_0
    //   235: ifnull -> 268
    //   238: new java/lang/String
    //   241: dup
    //   242: aload_0
    //   243: invokespecial <init> : ([B)V
    //   246: astore_0
    //   247: aload #4
    //   249: ifnull -> 266
    //   252: aload #4
    //   254: invokeinterface close : ()V
    //   259: aload_0
    //   260: areturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokestatic a : (Ljava/lang/Throwable;)V
    //   266: aload_0
    //   267: areturn
    //   268: aload #4
    //   270: ifnull -> 287
    //   273: aload #4
    //   275: invokeinterface close : ()V
    //   280: aconst_null
    //   281: areturn
    //   282: astore_0
    //   283: aload_0
    //   284: invokestatic a : (Ljava/lang/Throwable;)V
    //   287: aconst_null
    //   288: areturn
    //   289: aload #4
    //   291: invokeinterface moveToNext : ()Z
    //   296: istore_3
    //   297: iload_3
    //   298: ifne -> 116
    //   301: goto -> 311
    //   304: astore_1
    //   305: aload #4
    //   307: astore_0
    //   308: goto -> 335
    //   311: aload #4
    //   313: ifnull -> 330
    //   316: aload #4
    //   318: invokeinterface close : ()V
    //   323: aconst_null
    //   324: areturn
    //   325: astore_0
    //   326: aload_0
    //   327: invokestatic a : (Ljava/lang/Throwable;)V
    //   330: aconst_null
    //   331: areturn
    //   332: astore_1
    //   333: aconst_null
    //   334: astore_0
    //   335: aload_1
    //   336: invokestatic a : (Ljava/lang/Throwable;)V
    //   339: aload_0
    //   340: ifnull -> 356
    //   343: aload_0
    //   344: invokeinterface close : ()V
    //   349: aconst_null
    //   350: areturn
    //   351: astore_0
    //   352: aload_0
    //   353: invokestatic a : (Ljava/lang/Throwable;)V
    //   356: aconst_null
    //   357: areturn
    //   358: astore_1
    //   359: aload_0
    //   360: ifnull -> 377
    //   363: aload_0
    //   364: invokeinterface close : ()V
    //   369: goto -> 377
    //   372: astore_0
    //   373: aload_0
    //   374: invokestatic a : (Ljava/lang/Throwable;)V
    //   377: aload_1
    //   378: athrow
    // Exception table:
    //   from	to	target	type
    //   0	7	332	finally
    //   9	101	332	finally
    //   106	116	304	finally
    //   116	171	304	finally
    //   175	199	304	finally
    //   199	210	304	finally
    //   215	223	304	finally
    //   226	234	304	finally
    //   238	247	304	finally
    //   252	259	261	finally
    //   273	280	282	finally
    //   289	297	304	finally
    //   316	323	325	finally
    //   335	339	358	finally
    //   343	349	351	finally
    //   363	369	372	finally
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    try {
      return false;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\storage\local\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */