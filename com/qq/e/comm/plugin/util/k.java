package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import java.io.File;

public class k {
  public static int a(BitmapFactory.Options paramOptions, ImageView paramImageView) {
    int i = paramOptions.outWidth;
    int j = paramOptions.outHeight;
    int m = a(paramImageView);
    int n = b(paramImageView);
    return (i > m || j > n) ? Math.max(Math.round(i * 1.0F / m), Math.round(j * 1.0F / n)) : 1;
  }
  
  public static int a(ImageView paramImageView) {
    byte b;
    Context context = GDTADManager.getInstance().getAppContext();
    if (paramImageView != null) {
      int j = paramImageView.getWidth();
      ViewGroup.LayoutParams layoutParams = paramImageView.getLayoutParams();
      b = j;
      if (layoutParams != null) {
        b = j;
        if (j <= 0)
          b = layoutParams.width; 
      } 
    } else {
      b = 0;
    } 
    int i = b;
    if (b)
      i = am.b(context); 
    return i;
  }
  
  public static Bitmap a(File paramFile, ImageView paramImageView) {
    return a(paramFile.getAbsolutePath(), paramImageView);
  }
  
  public static Bitmap a(String paramString, ImageView paramImageView) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    options.inPreferredConfig = Bitmap.Config.RGB_565;
    BitmapFactory.decodeFile(paramString, options);
    options.inSampleSize = a(options, paramImageView);
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, options);
  }
  
  public static boolean a(File paramFile) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore #4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_0
    //   8: ifnonnull -> 20
    //   11: ldc 'image file is null'
    //   13: astore_0
    //   14: iload #4
    //   16: istore_3
    //   17: goto -> 309
    //   20: aload_0
    //   21: invokevirtual exists : ()Z
    //   24: ifne -> 68
    //   27: new java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore #5
    //   36: aload #5
    //   38: aload_0
    //   39: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #5
    //   48: ldc ' not exist'
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #5
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: astore_0
    //   62: iload #4
    //   64: istore_3
    //   65: goto -> 309
    //   68: aload_0
    //   69: invokevirtual length : ()J
    //   72: ldc2_w 6
    //   75: lcmp
    //   76: ifge -> 122
    //   79: new java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore #5
    //   88: aload #5
    //   90: aload_0
    //   91: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload #5
    //   100: ldc ' size too short, len = '
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #5
    //   108: aload_0
    //   109: invokevirtual length : ()J
    //   112: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload #5
    //   118: astore_0
    //   119: goto -> 57
    //   122: aconst_null
    //   123: astore #7
    //   125: aconst_null
    //   126: astore #5
    //   128: new java/io/FileInputStream
    //   131: dup
    //   132: aload_0
    //   133: invokespecial <init> : (Ljava/io/File;)V
    //   136: astore #6
    //   138: bipush #6
    //   140: newarray byte
    //   142: astore #5
    //   144: aload #6
    //   146: aload #5
    //   148: invokevirtual read : ([B)I
    //   151: istore_1
    //   152: iload_1
    //   153: bipush #6
    //   155: if_icmpge -> 217
    //   158: new java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial <init> : ()V
    //   165: astore #5
    //   167: aload #5
    //   169: aload_0
    //   170: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #5
    //   179: ldc ' only read '
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #5
    //   187: iload_1
    //   188: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #5
    //   194: ldc ' bytes!'
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload #5
    //   202: invokevirtual toString : ()Ljava/lang/String;
    //   205: invokestatic e : (Ljava/lang/String;)V
    //   208: iload_2
    //   209: istore_3
    //   210: aload #6
    //   212: invokevirtual close : ()V
    //   215: iconst_0
    //   216: ireturn
    //   217: iload_3
    //   218: istore_2
    //   219: aload #5
    //   221: iconst_0
    //   222: baload
    //   223: bipush #71
    //   225: if_icmpne -> 294
    //   228: iload_3
    //   229: istore_2
    //   230: aload #5
    //   232: iconst_1
    //   233: baload
    //   234: bipush #73
    //   236: if_icmpne -> 294
    //   239: iload_3
    //   240: istore_2
    //   241: aload #5
    //   243: iconst_2
    //   244: baload
    //   245: bipush #70
    //   247: if_icmpne -> 294
    //   250: iload_3
    //   251: istore_2
    //   252: aload #5
    //   254: iconst_3
    //   255: baload
    //   256: bipush #56
    //   258: if_icmpne -> 294
    //   261: aload #5
    //   263: iconst_4
    //   264: baload
    //   265: bipush #55
    //   267: if_icmpeq -> 281
    //   270: iload_3
    //   271: istore_2
    //   272: aload #5
    //   274: iconst_4
    //   275: baload
    //   276: bipush #57
    //   278: if_icmpne -> 294
    //   281: iload_3
    //   282: istore_2
    //   283: aload #5
    //   285: iconst_5
    //   286: baload
    //   287: bipush #97
    //   289: if_icmpne -> 294
    //   292: iconst_1
    //   293: istore_2
    //   294: iload_2
    //   295: istore_3
    //   296: aload #6
    //   298: invokevirtual close : ()V
    //   301: iload_2
    //   302: ireturn
    //   303: astore_0
    //   304: aload_0
    //   305: invokevirtual getMessage : ()Ljava/lang/String;
    //   308: astore_0
    //   309: aload_0
    //   310: invokestatic e : (Ljava/lang/String;)V
    //   313: iload_3
    //   314: ireturn
    //   315: astore_0
    //   316: aload #6
    //   318: astore #5
    //   320: goto -> 367
    //   323: astore #5
    //   325: aload #6
    //   327: astore_0
    //   328: aload #5
    //   330: astore #6
    //   332: goto -> 344
    //   335: astore_0
    //   336: goto -> 367
    //   339: astore #6
    //   341: aload #7
    //   343: astore_0
    //   344: aload_0
    //   345: astore #5
    //   347: aload #6
    //   349: invokevirtual getMessage : ()Ljava/lang/String;
    //   352: invokestatic e : (Ljava/lang/String;)V
    //   355: aload_0
    //   356: ifnull -> 365
    //   359: iload_2
    //   360: istore_3
    //   361: aload_0
    //   362: invokevirtual close : ()V
    //   365: iconst_0
    //   366: ireturn
    //   367: aload #5
    //   369: ifnull -> 390
    //   372: aload #5
    //   374: invokevirtual close : ()V
    //   377: goto -> 390
    //   380: astore #5
    //   382: aload #5
    //   384: invokevirtual getMessage : ()Ljava/lang/String;
    //   387: invokestatic e : (Ljava/lang/String;)V
    //   390: aload_0
    //   391: athrow
    // Exception table:
    //   from	to	target	type
    //   128	138	339	java/lang/Exception
    //   128	138	335	finally
    //   138	152	323	java/lang/Exception
    //   138	152	315	finally
    //   158	208	323	java/lang/Exception
    //   158	208	315	finally
    //   210	215	303	java/lang/Exception
    //   296	301	303	java/lang/Exception
    //   347	355	335	finally
    //   361	365	303	java/lang/Exception
    //   372	377	380	java/lang/Exception
  }
  
  public static int b(ImageView paramImageView) {
    byte b;
    Context context = GDTADManager.getInstance().getAppContext();
    if (paramImageView != null) {
      ViewGroup.LayoutParams layoutParams = paramImageView.getLayoutParams();
      int j = paramImageView.getHeight();
      b = j;
      if (j <= 0) {
        b = j;
        if (layoutParams != null)
          b = layoutParams.height; 
      } 
    } else {
      b = 0;
    } 
    int i = b;
    if (b)
      i = am.c(context); 
    return i;
  }
  
  public static Movie b(File paramFile) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore #4
    //   5: aload_0
    //   6: invokestatic a : (Ljava/io/File;)Z
    //   9: ifeq -> 439
    //   12: new java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial <init> : (Ljava/io/File;)V
    //   20: astore #10
    //   22: new java/io/ByteArrayOutputStream
    //   25: dup
    //   26: sipush #1024
    //   29: invokespecial <init> : (I)V
    //   32: astore #8
    //   34: sipush #1024
    //   37: newarray byte
    //   39: astore #9
    //   41: aload #10
    //   43: aload #9
    //   45: invokevirtual read : ([B)I
    //   48: istore_2
    //   49: iload_2
    //   50: ifle -> 65
    //   53: aload #8
    //   55: aload #9
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual write : ([BII)V
    //   62: goto -> 41
    //   65: aload #8
    //   67: invokevirtual flush : ()V
    //   70: aload #8
    //   72: invokevirtual toByteArray : ()[B
    //   75: astore #9
    //   77: aload #9
    //   79: iconst_0
    //   80: aload #9
    //   82: arraylength
    //   83: invokestatic decodeByteArray : ([BII)Landroid/graphics/Movie;
    //   86: astore #9
    //   88: aload #10
    //   90: invokevirtual close : ()V
    //   93: goto -> 106
    //   96: astore #10
    //   98: aload #10
    //   100: invokevirtual getMessage : ()Ljava/lang/String;
    //   103: invokestatic e : (Ljava/lang/String;)V
    //   106: aload #8
    //   108: invokevirtual close : ()V
    //   111: aload #9
    //   113: astore #8
    //   115: goto -> 242
    //   118: astore #8
    //   120: aload #8
    //   122: invokevirtual getMessage : ()Ljava/lang/String;
    //   125: invokestatic e : (Ljava/lang/String;)V
    //   128: aload #9
    //   130: astore #8
    //   132: goto -> 242
    //   135: astore #9
    //   137: goto -> 157
    //   140: astore #9
    //   142: aconst_null
    //   143: astore #8
    //   145: goto -> 157
    //   148: astore #9
    //   150: aconst_null
    //   151: astore #10
    //   153: aload #10
    //   155: astore #8
    //   157: new java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial <init> : ()V
    //   164: astore #11
    //   166: aload #11
    //   168: ldc 'decode movie failed: '
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload #11
    //   176: aload #9
    //   178: invokevirtual getMessage : ()Ljava/lang/String;
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #11
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: invokestatic e : (Ljava/lang/String;)V
    //   193: aload #10
    //   195: ifnull -> 216
    //   198: aload #10
    //   200: invokevirtual close : ()V
    //   203: goto -> 216
    //   206: astore #9
    //   208: aload #9
    //   210: invokevirtual getMessage : ()Ljava/lang/String;
    //   213: invokestatic e : (Ljava/lang/String;)V
    //   216: aload #8
    //   218: ifnull -> 239
    //   221: aload #8
    //   223: invokevirtual close : ()V
    //   226: goto -> 239
    //   229: astore #8
    //   231: aload #8
    //   233: invokevirtual getMessage : ()Ljava/lang/String;
    //   236: invokestatic e : (Ljava/lang/String;)V
    //   239: aconst_null
    //   240: astore #8
    //   242: aload #8
    //   244: ifnull -> 387
    //   247: invokestatic currentTimeMillis : ()J
    //   250: lstore #6
    //   252: aload_0
    //   253: invokevirtual length : ()J
    //   256: l2f
    //   257: ldc 1024.0
    //   259: fdiv
    //   260: fstore_1
    //   261: aload #8
    //   263: invokevirtual width : ()I
    //   266: istore_2
    //   267: aload #8
    //   269: invokevirtual height : ()I
    //   272: istore_3
    //   273: ldc '![%.2fKB, %d*%d, len=%dms, cost=%dms](%s)'
    //   275: bipush #6
    //   277: anewarray java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: fload_1
    //   283: invokestatic valueOf : (F)Ljava/lang/Float;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: iload_2
    //   290: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: iload_3
    //   297: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   300: aastore
    //   301: dup
    //   302: iconst_3
    //   303: aload #8
    //   305: invokevirtual duration : ()I
    //   308: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_4
    //   314: lload #6
    //   316: lload #4
    //   318: lsub
    //   319: invokestatic valueOf : (J)Ljava/lang/Long;
    //   322: aastore
    //   323: dup
    //   324: iconst_5
    //   325: aload_0
    //   326: invokevirtual getAbsoluteFile : ()Ljava/io/File;
    //   329: aastore
    //   330: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   333: invokestatic d : (Ljava/lang/String;)V
    //   336: iload_2
    //   337: ifeq -> 344
    //   340: iload_3
    //   341: ifne -> 387
    //   344: new java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial <init> : ()V
    //   351: astore_0
    //   352: aload_0
    //   353: ldc 'invalid gif width or height, w = '
    //   355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_0
    //   360: iload_2
    //   361: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload_0
    //   366: ldc ', h = '
    //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_0
    //   373: iload_3
    //   374: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload_0
    //   379: invokevirtual toString : ()Ljava/lang/String;
    //   382: invokestatic e : (Ljava/lang/String;)V
    //   385: aconst_null
    //   386: areturn
    //   387: aload #8
    //   389: areturn
    //   390: astore_0
    //   391: aload #10
    //   393: ifnull -> 414
    //   396: aload #10
    //   398: invokevirtual close : ()V
    //   401: goto -> 414
    //   404: astore #9
    //   406: aload #9
    //   408: invokevirtual getMessage : ()Ljava/lang/String;
    //   411: invokestatic e : (Ljava/lang/String;)V
    //   414: aload #8
    //   416: ifnull -> 437
    //   419: aload #8
    //   421: invokevirtual close : ()V
    //   424: goto -> 437
    //   427: astore #8
    //   429: aload #8
    //   431: invokevirtual getMessage : ()Ljava/lang/String;
    //   434: invokestatic e : (Ljava/lang/String;)V
    //   437: aload_0
    //   438: athrow
    //   439: aconst_null
    //   440: areturn
    // Exception table:
    //   from	to	target	type
    //   12	22	148	finally
    //   22	34	140	finally
    //   34	41	135	finally
    //   41	49	135	finally
    //   53	62	135	finally
    //   65	88	135	finally
    //   88	93	96	java/lang/Exception
    //   106	111	118	java/lang/Exception
    //   157	193	390	finally
    //   198	203	206	java/lang/Exception
    //   221	226	229	java/lang/Exception
    //   396	401	404	java/lang/Exception
    //   419	424	427	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */