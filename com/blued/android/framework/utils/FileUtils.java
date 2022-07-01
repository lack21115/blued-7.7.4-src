package com.blued.android.framework.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
  private static String a() {
    try {
      return AppInfo.d().getExternalCacheDir().getParentFile().getAbsolutePath();
    } catch (NullPointerException nullPointerException) {
      nullPointerException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  private static boolean a(InputStream paramInputStream, OutputStream paramOutputStream) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 202
    //   4: aload_1
    //   5: ifnonnull -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore #4
    //   13: aconst_null
    //   14: astore_3
    //   15: aconst_null
    //   16: astore #6
    //   18: new java/io/BufferedInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial <init> : (Ljava/io/InputStream;)V
    //   26: astore_0
    //   27: aload #4
    //   29: astore_3
    //   30: aload_0
    //   31: astore #4
    //   33: new java/io/BufferedOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   41: astore_1
    //   42: sipush #1024
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_0
    //   49: aload_3
    //   50: invokevirtual read : ([B)I
    //   53: istore_2
    //   54: iload_2
    //   55: iconst_m1
    //   56: if_icmpeq -> 69
    //   59: aload_1
    //   60: aload_3
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual write : ([BII)V
    //   66: goto -> 48
    //   69: aload_1
    //   70: invokevirtual close : ()V
    //   73: aload_0
    //   74: invokevirtual close : ()V
    //   77: goto -> 87
    //   80: astore_0
    //   81: ldc 'closeFile'
    //   83: aload_0
    //   84: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: iconst_1
    //   88: ireturn
    //   89: astore #4
    //   91: aload_1
    //   92: astore_3
    //   93: aload #4
    //   95: astore_1
    //   96: goto -> 172
    //   99: astore #5
    //   101: goto -> 125
    //   104: astore #5
    //   106: aload #6
    //   108: astore_1
    //   109: goto -> 125
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -> 172
    //   118: astore #5
    //   120: aconst_null
    //   121: astore_0
    //   122: aload #6
    //   124: astore_1
    //   125: aload_1
    //   126: astore_3
    //   127: aload_0
    //   128: astore #4
    //   130: aload #5
    //   132: invokevirtual toString : ()Ljava/lang/String;
    //   135: invokestatic d : (Ljava/lang/String;)I
    //   138: pop
    //   139: aload_1
    //   140: ifnull -> 150
    //   143: aload_1
    //   144: invokevirtual close : ()V
    //   147: goto -> 150
    //   150: aload_0
    //   151: ifnull -> 166
    //   154: aload_0
    //   155: invokevirtual close : ()V
    //   158: iconst_0
    //   159: ireturn
    //   160: ldc 'closeFile'
    //   162: aload_0
    //   163: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_1
    //   169: aload #4
    //   171: astore_0
    //   172: aload_3
    //   173: ifnull -> 183
    //   176: aload_3
    //   177: invokevirtual close : ()V
    //   180: goto -> 183
    //   183: aload_0
    //   184: ifnull -> 200
    //   187: aload_0
    //   188: invokevirtual close : ()V
    //   191: goto -> 200
    //   194: ldc 'closeFile'
    //   196: aload_0
    //   197: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload_1
    //   201: athrow
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: goto -> 160
    //   208: astore_0
    //   209: goto -> 194
    // Exception table:
    //   from	to	target	type
    //   18	27	118	java/lang/Exception
    //   18	27	112	finally
    //   33	42	104	java/lang/Exception
    //   33	42	168	finally
    //   42	48	99	java/lang/Exception
    //   42	48	89	finally
    //   48	54	99	java/lang/Exception
    //   48	54	89	finally
    //   59	66	99	java/lang/Exception
    //   59	66	89	finally
    //   69	77	80	java/lang/Exception
    //   130	139	168	finally
    //   143	147	204	java/lang/Exception
    //   154	158	204	java/lang/Exception
    //   176	180	208	java/lang/Exception
    //   187	191	208	java/lang/Exception
  }
  
  private static boolean a(InputStream paramInputStream, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("targetPath: ");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    if (!StringUtils.a(paramString)) {
      if (paramInputStream == null)
        return false; 
      if (!a(paramString, true))
        return false; 
      File file = new File(paramString);
      InputStream inputStream2 = null;
      paramString = null;
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
          a(paramInputStream, fileOutputStream);
        } catch (Exception exception1) {
          FileOutputStream fileOutputStream1 = fileOutputStream;
        } finally {
          Exception exception1;
          paramInputStream = null;
        } 
      } catch (Exception exception) {
        paramInputStream = inputStream2;
      } finally {}
      InputStream inputStream1 = paramInputStream;
      exception.printStackTrace();
      if (paramInputStream != null)
        try {
          paramInputStream.close();
        } catch (Exception exception1) {
          exception1.printStackTrace();
        }  
      return false;
    } 
    return false;
  }
  
  public static boolean a(String paramString) {
    return a(paramString, true);
  }
  
  public static boolean a(String paramString1, String paramString2) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: aload #7
    //   11: ldc 'oldPath: '
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload #7
    //   19: aload_0
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #7
    //   26: ldc ', newPath: '
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload #7
    //   34: aload_1
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #7
    //   41: invokevirtual toString : ()Ljava/lang/String;
    //   44: invokestatic c : (Ljava/lang/String;)I
    //   47: pop
    //   48: iconst_0
    //   49: istore #5
    //   51: iconst_0
    //   52: istore #6
    //   54: aload_0
    //   55: ifnull -> 554
    //   58: aload_1
    //   59: ifnonnull -> 64
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_1
    //   65: iconst_1
    //   66: invokestatic a : (Ljava/lang/String;Z)Z
    //   69: ifne -> 74
    //   72: iconst_0
    //   73: ireturn
    //   74: getstatic android/os/Build$VERSION.SDK_INT : I
    //   77: istore_2
    //   78: aconst_null
    //   79: astore #9
    //   81: aload #9
    //   83: astore #7
    //   85: iload_2
    //   86: bipush #29
    //   88: if_icmplt -> 432
    //   91: aload #9
    //   93: astore #7
    //   95: invokestatic isExternalStorageLegacy : ()Z
    //   98: ifne -> 432
    //   101: aload #9
    //   103: astore #7
    //   105: aload_0
    //   106: invokestatic b : (Ljava/lang/String;)Z
    //   109: ifne -> 432
    //   112: invokestatic d : ()Landroid/content/Context;
    //   115: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   118: astore #10
    //   120: aload_0
    //   121: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   124: ldc 'content://'
    //   126: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   129: ifeq -> 164
    //   132: aload_0
    //   133: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   136: astore #7
    //   138: aload #10
    //   140: aload #7
    //   142: invokevirtual openInputStream : (Landroid/net/Uri;)Ljava/io/InputStream;
    //   145: astore #7
    //   147: goto -> 432
    //   150: astore #7
    //   152: aload #7
    //   154: invokevirtual printStackTrace : ()V
    //   157: aload #9
    //   159: astore #7
    //   161: goto -> 432
    //   164: aload_0
    //   165: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   168: ldc '.jpg'
    //   170: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   173: ifne -> 301
    //   176: aload_0
    //   177: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   180: ldc '.jpeg'
    //   182: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   185: ifne -> 301
    //   188: aload_0
    //   189: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   192: ldc '.gif'
    //   194: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   197: ifne -> 301
    //   200: aload_0
    //   201: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   204: ldc '.webp'
    //   206: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   209: ifne -> 301
    //   212: aload_0
    //   213: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   216: ldc '.png'
    //   218: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   221: ifeq -> 227
    //   224: goto -> 301
    //   227: aload_0
    //   228: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   231: ldc '.mp4'
    //   233: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   236: ifne -> 264
    //   239: aload_0
    //   240: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   243: ldc '.m4v'
    //   245: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   248: ifeq -> 254
    //   251: goto -> 264
    //   254: aconst_null
    //   255: astore #7
    //   257: aload #7
    //   259: astore #8
    //   261: goto -> 335
    //   264: getstatic android/provider/MediaStore$Video$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   267: astore #8
    //   269: aload #10
    //   271: aload #8
    //   273: iconst_1
    //   274: anewarray java/lang/String
    //   277: dup
    //   278: iconst_0
    //   279: ldc '_id'
    //   281: aastore
    //   282: ldc '_data=? '
    //   284: iconst_1
    //   285: anewarray java/lang/String
    //   288: dup
    //   289: iconst_0
    //   290: aload_0
    //   291: aastore
    //   292: aconst_null
    //   293: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   296: astore #7
    //   298: goto -> 335
    //   301: getstatic android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   304: astore #8
    //   306: aload #10
    //   308: aload #8
    //   310: iconst_1
    //   311: anewarray java/lang/String
    //   314: dup
    //   315: iconst_0
    //   316: ldc '_id'
    //   318: aastore
    //   319: ldc '_data=? '
    //   321: iconst_1
    //   322: anewarray java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: aload_0
    //   328: aastore
    //   329: aconst_null
    //   330: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   333: astore #7
    //   335: aload #7
    //   337: ifnull -> 379
    //   340: aload #7
    //   342: invokeinterface moveToFirst : ()Z
    //   347: ifeq -> 379
    //   350: aload #8
    //   352: aload #7
    //   354: aload #7
    //   356: ldc '_id'
    //   358: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   363: invokeinterface getInt : (I)I
    //   368: invokestatic valueOf : (I)Ljava/lang/String;
    //   371: invokestatic withAppendedPath : (Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   374: astore #8
    //   376: goto -> 382
    //   379: aconst_null
    //   380: astore #8
    //   382: aload #7
    //   384: ifnull -> 394
    //   387: aload #7
    //   389: invokeinterface close : ()V
    //   394: aload #8
    //   396: astore #7
    //   398: aload #8
    //   400: ifnonnull -> 409
    //   403: aload_0
    //   404: invokestatic a : (Ljava/lang/String;)Landroid/net/Uri;
    //   407: astore #7
    //   409: aload #10
    //   411: aload #7
    //   413: invokevirtual openInputStream : (Landroid/net/Uri;)Ljava/io/InputStream;
    //   416: astore #7
    //   418: goto -> 432
    //   421: astore #7
    //   423: aload #7
    //   425: invokevirtual printStackTrace : ()V
    //   428: aload #9
    //   430: astore #7
    //   432: aload #7
    //   434: astore #8
    //   436: aload #7
    //   438: ifnonnull -> 455
    //   441: aload #7
    //   443: astore #9
    //   445: new java/io/FileInputStream
    //   448: dup
    //   449: aload_0
    //   450: invokespecial <init> : (Ljava/lang/String;)V
    //   453: astore #8
    //   455: aload #8
    //   457: astore #9
    //   459: aload #8
    //   461: astore #7
    //   463: aload #8
    //   465: aload_1
    //   466: invokestatic a : (Ljava/io/InputStream;Ljava/lang/String;)Z
    //   469: istore_3
    //   470: iload_3
    //   471: istore #4
    //   473: aload #8
    //   475: ifnull -> 531
    //   478: iload_3
    //   479: istore #4
    //   481: aload #8
    //   483: invokevirtual close : ()V
    //   486: iload_3
    //   487: ireturn
    //   488: astore_0
    //   489: aload_0
    //   490: invokevirtual printStackTrace : ()V
    //   493: iload #4
    //   495: ireturn
    //   496: astore_0
    //   497: goto -> 534
    //   500: astore_0
    //   501: aload #7
    //   503: astore #9
    //   505: aload_0
    //   506: invokevirtual printStackTrace : ()V
    //   509: iload #5
    //   511: istore #4
    //   513: aload #7
    //   515: ifnull -> 531
    //   518: iload #6
    //   520: istore #4
    //   522: aload #7
    //   524: invokevirtual close : ()V
    //   527: iload #5
    //   529: istore #4
    //   531: iload #4
    //   533: ireturn
    //   534: aload #9
    //   536: ifnull -> 552
    //   539: aload #9
    //   541: invokevirtual close : ()V
    //   544: goto -> 552
    //   547: astore_1
    //   548: aload_1
    //   549: invokevirtual printStackTrace : ()V
    //   552: aload_0
    //   553: athrow
    //   554: iconst_0
    //   555: ireturn
    // Exception table:
    //   from	to	target	type
    //   138	147	150	java/lang/Exception
    //   409	418	421	java/lang/Exception
    //   445	455	500	java/lang/Exception
    //   445	455	496	finally
    //   463	470	500	java/lang/Exception
    //   463	470	496	finally
    //   481	486	488	java/lang/Exception
    //   505	509	496	finally
    //   522	527	488	java/lang/Exception
    //   539	544	547	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3) {
    return a(paramString1, paramString2, paramString3, 0);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 641
    //   7: aload_2
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifeq -> 17
    //   14: goto -> 641
    //   17: invokestatic d : ()Landroid/content/Context;
    //   20: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   23: astore #6
    //   25: getstatic android/os/Build$VERSION.SDK_INT : I
    //   28: bipush #29
    //   30: if_icmplt -> 432
    //   33: invokestatic isExternalStorageLegacy : ()Z
    //   36: ifne -> 432
    //   39: new android/content/ContentValues
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: astore #7
    //   48: iload_3
    //   49: iconst_1
    //   50: if_icmpeq -> 202
    //   53: aload_0
    //   54: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   57: ldc '.jpg'
    //   59: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   62: ifne -> 202
    //   65: aload_0
    //   66: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   69: ldc '.jpeg'
    //   71: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   74: ifne -> 202
    //   77: aload_0
    //   78: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   81: ldc '.gif'
    //   83: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   86: ifne -> 202
    //   89: aload_0
    //   90: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   93: ldc '.webp'
    //   95: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   98: ifne -> 202
    //   101: aload_0
    //   102: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   105: ldc '.png'
    //   107: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   110: ifeq -> 116
    //   113: goto -> 202
    //   116: iload_3
    //   117: iconst_2
    //   118: if_icmpeq -> 148
    //   121: aload_0
    //   122: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   125: ldc '.mp4'
    //   127: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   130: ifne -> 148
    //   133: aload_0
    //   134: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   137: ldc '.m4v'
    //   139: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   142: ifeq -> 643
    //   145: goto -> 148
    //   148: getstatic android/provider/MediaStore$Video$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   151: astore_1
    //   152: aload #7
    //   154: ldc 'mime_type'
    //   156: ldc 'video/mp4'
    //   158: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   161: new java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial <init> : ()V
    //   168: astore #5
    //   170: aload #5
    //   172: getstatic android/os/Environment.DIRECTORY_DCIM : Ljava/lang/String;
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload #5
    //   181: ldc '/blued'
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload #7
    //   189: ldc 'relative_path'
    //   191: aload #5
    //   193: invokevirtual toString : ()Ljava/lang/String;
    //   196: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   199: goto -> 367
    //   202: getstatic android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   205: astore #5
    //   207: new java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial <init> : ()V
    //   214: astore_1
    //   215: aload_1
    //   216: getstatic android/os/Environment.DIRECTORY_PICTURES : Ljava/lang/String;
    //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: ldc '/blued'
    //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload #7
    //   232: ldc 'relative_path'
    //   234: aload_1
    //   235: invokevirtual toString : ()Ljava/lang/String;
    //   238: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   245: ldc '.jpg'
    //   247: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   250: ifne -> 354
    //   253: aload_0
    //   254: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   257: ldc '.jpeg'
    //   259: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   262: ifeq -> 268
    //   265: goto -> 354
    //   268: aload_0
    //   269: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   272: ldc '.gif'
    //   274: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   277: ifeq -> 295
    //   280: aload #7
    //   282: ldc 'mime_type'
    //   284: ldc 'image/gif'
    //   286: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload #5
    //   291: astore_1
    //   292: goto -> 367
    //   295: aload_0
    //   296: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   299: ldc '.webp'
    //   301: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   304: ifeq -> 323
    //   307: aload #7
    //   309: ldc 'mime_type'
    //   311: ldc_w 'image/webp'
    //   314: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload #5
    //   319: astore_1
    //   320: goto -> 367
    //   323: aload #5
    //   325: astore_1
    //   326: aload_0
    //   327: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   330: ldc '.png'
    //   332: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   335: ifeq -> 367
    //   338: aload #7
    //   340: ldc 'mime_type'
    //   342: ldc_w 'image/png'
    //   345: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload #5
    //   350: astore_1
    //   351: goto -> 367
    //   354: aload #7
    //   356: ldc 'mime_type'
    //   358: ldc_w 'image/jpeg'
    //   361: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload #5
    //   366: astore_1
    //   367: aload #7
    //   369: ldc_w '_display_name'
    //   372: aload_2
    //   373: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload #7
    //   378: ldc_w 'description'
    //   381: ldc_w 'Blued image'
    //   384: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload #7
    //   389: ldc_w 'title'
    //   392: aload_2
    //   393: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload #6
    //   398: aload_1
    //   399: aload #7
    //   401: invokevirtual insert : (Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   404: astore_1
    //   405: aload_1
    //   406: ifnull -> 419
    //   409: aload #6
    //   411: aload_1
    //   412: invokevirtual openOutputStream : (Landroid/net/Uri;)Ljava/io/OutputStream;
    //   415: astore_1
    //   416: goto -> 446
    //   419: aconst_null
    //   420: astore_1
    //   421: goto -> 446
    //   424: astore_1
    //   425: aload_1
    //   426: invokevirtual printStackTrace : ()V
    //   429: goto -> 419
    //   432: aload_1
    //   433: invokestatic a : (Ljava/lang/String;)Z
    //   436: pop
    //   437: new java/io/FileOutputStream
    //   440: dup
    //   441: aload_1
    //   442: invokespecial <init> : (Ljava/lang/String;)V
    //   445: astore_1
    //   446: getstatic android/os/Build$VERSION.SDK_INT : I
    //   449: bipush #29
    //   451: if_icmplt -> 480
    //   454: invokestatic isExternalStorageLegacy : ()Z
    //   457: ifne -> 480
    //   460: aload_0
    //   461: invokestatic b : (Ljava/lang/String;)Z
    //   464: ifne -> 480
    //   467: aload #6
    //   469: aload_0
    //   470: invokestatic a : (Ljava/lang/String;)Landroid/net/Uri;
    //   473: invokevirtual openInputStream : (Landroid/net/Uri;)Ljava/io/InputStream;
    //   476: astore_0
    //   477: goto -> 489
    //   480: new java/io/FileInputStream
    //   483: dup
    //   484: aload_0
    //   485: invokespecial <init> : (Ljava/lang/String;)V
    //   488: astore_0
    //   489: aload_0
    //   490: aload_1
    //   491: invokestatic a : (Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   494: istore #4
    //   496: aload_1
    //   497: ifnull -> 507
    //   500: aload_1
    //   501: invokevirtual close : ()V
    //   504: goto -> 507
    //   507: aload_0
    //   508: ifnull -> 524
    //   511: aload_0
    //   512: invokevirtual close : ()V
    //   515: goto -> 524
    //   518: ldc 'closeFile'
    //   520: aload_0
    //   521: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   524: iload #4
    //   526: ireturn
    //   527: astore #5
    //   529: aload_1
    //   530: astore_2
    //   531: aload_0
    //   532: astore_1
    //   533: aload #5
    //   535: astore_0
    //   536: goto -> 611
    //   539: astore_2
    //   540: goto -> 568
    //   543: astore_0
    //   544: aload_1
    //   545: astore_2
    //   546: aconst_null
    //   547: astore_1
    //   548: goto -> 611
    //   551: astore_2
    //   552: goto -> 566
    //   555: astore_0
    //   556: aconst_null
    //   557: astore_1
    //   558: aconst_null
    //   559: astore_2
    //   560: goto -> 611
    //   563: astore_2
    //   564: aconst_null
    //   565: astore_1
    //   566: aconst_null
    //   567: astore_0
    //   568: aload_2
    //   569: invokevirtual printStackTrace : ()V
    //   572: aload_1
    //   573: ifnull -> 583
    //   576: aload_1
    //   577: invokevirtual close : ()V
    //   580: goto -> 583
    //   583: aload_0
    //   584: ifnull -> 600
    //   587: aload_0
    //   588: invokevirtual close : ()V
    //   591: goto -> 600
    //   594: ldc 'closeFile'
    //   596: aload_0
    //   597: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   600: iconst_1
    //   601: ireturn
    //   602: astore #5
    //   604: aload_1
    //   605: astore_2
    //   606: aload_0
    //   607: astore_1
    //   608: aload #5
    //   610: astore_0
    //   611: aload_2
    //   612: ifnull -> 622
    //   615: aload_2
    //   616: invokevirtual close : ()V
    //   619: goto -> 622
    //   622: aload_1
    //   623: ifnull -> 639
    //   626: aload_1
    //   627: invokevirtual close : ()V
    //   630: goto -> 639
    //   633: ldc 'closeFile'
    //   635: aload_1
    //   636: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   639: aload_0
    //   640: athrow
    //   641: iconst_0
    //   642: ireturn
    //   643: aconst_null
    //   644: astore_1
    //   645: goto -> 367
    //   648: astore_0
    //   649: goto -> 518
    //   652: astore_0
    //   653: goto -> 594
    //   656: astore_1
    //   657: goto -> 633
    // Exception table:
    //   from	to	target	type
    //   17	48	563	java/lang/Exception
    //   17	48	555	finally
    //   53	113	563	java/lang/Exception
    //   53	113	555	finally
    //   121	145	563	java/lang/Exception
    //   121	145	555	finally
    //   148	199	563	java/lang/Exception
    //   148	199	555	finally
    //   202	265	563	java/lang/Exception
    //   202	265	555	finally
    //   268	289	563	java/lang/Exception
    //   268	289	555	finally
    //   295	317	563	java/lang/Exception
    //   295	317	555	finally
    //   326	348	563	java/lang/Exception
    //   326	348	555	finally
    //   354	364	563	java/lang/Exception
    //   354	364	555	finally
    //   367	396	563	java/lang/Exception
    //   367	396	555	finally
    //   396	405	424	java/lang/Exception
    //   396	405	555	finally
    //   409	416	424	java/lang/Exception
    //   409	416	555	finally
    //   425	429	563	java/lang/Exception
    //   425	429	555	finally
    //   432	446	563	java/lang/Exception
    //   432	446	555	finally
    //   446	477	551	java/lang/Exception
    //   446	477	543	finally
    //   480	489	551	java/lang/Exception
    //   480	489	543	finally
    //   489	496	539	java/lang/Exception
    //   489	496	527	finally
    //   500	504	648	java/lang/Exception
    //   511	515	648	java/lang/Exception
    //   568	572	602	finally
    //   576	580	652	java/lang/Exception
    //   587	591	652	java/lang/Exception
    //   615	619	656	java/lang/Exception
    //   626	630	656	java/lang/Exception
  }
  
  public static boolean a(String paramString, boolean paramBoolean) {
    boolean bool = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool) {
      LogUtils.c("filePath is empty");
      return false;
    } 
    File file1 = new File(paramString);
    if (file1.exists()) {
      if (!paramBoolean)
        return true; 
      file1.delete();
    } 
    File file2 = file1.getParentFile();
    if (file2 != null)
      file2.mkdirs(); 
    try {
      paramBoolean = file1.createNewFile();
    } catch (Exception exception) {
      exception.printStackTrace();
      paramBoolean = false;
    } 
    bool = bool1;
    if (paramBoolean) {
      bool = bool1;
      if (file1.exists())
        bool = true; 
    } 
    return bool;
  }
  
  private static String b() {
    try {
      return AppInfo.d().getCacheDir().getParentFile().getAbsolutePath();
    } catch (NullPointerException nullPointerException) {
      nullPointerException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  private static boolean b(String paramString) {
    return (paramString == null) ? false : ((!TextUtils.isEmpty(b()) && paramString.startsWith(b())) ? true : ((!TextUtils.isEmpty(a()) && paramString.startsWith(a()))));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */