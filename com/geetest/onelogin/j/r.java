package com.geetest.onelogin.j;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.VideoView;

public class r {
  public static void a(VideoView paramVideoView, Context paramContext, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aconst_null
    //   4: astore #5
    //   6: aconst_null
    //   7: astore #6
    //   9: aconst_null
    //   10: astore #7
    //   12: aload #5
    //   14: astore_3
    //   15: aload #6
    //   17: astore #4
    //   19: aload_2
    //   20: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   23: astore #10
    //   25: aload #5
    //   27: astore_3
    //   28: aload #6
    //   30: astore #4
    //   32: aload_0
    //   33: aload #10
    //   35: invokevirtual setVideoURI : (Landroid/net/Uri;)V
    //   38: aload #5
    //   40: astore_3
    //   41: aload #6
    //   43: astore #4
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual setVisibility : (I)V
    //   50: aload #5
    //   52: astore_3
    //   53: aload #6
    //   55: astore #4
    //   57: new android/media/MediaMetadataRetriever
    //   60: dup
    //   61: invokespecial <init> : ()V
    //   64: astore #9
    //   66: aload_2
    //   67: ldc 'http://'
    //   69: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   72: ifne -> 98
    //   75: aload_2
    //   76: ldc 'https://'
    //   78: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   81: ifeq -> 87
    //   84: goto -> 98
    //   87: aload #9
    //   89: aload_1
    //   90: aload #10
    //   92: invokevirtual setDataSource : (Landroid/content/Context;Landroid/net/Uri;)V
    //   95: goto -> 111
    //   98: aload #9
    //   100: aload_2
    //   101: new java/util/HashMap
    //   104: dup
    //   105: invokespecial <init> : ()V
    //   108: invokevirtual setDataSource : (Ljava/lang/String;Ljava/util/Map;)V
    //   111: aload #9
    //   113: invokevirtual getFrameAtTime : ()Landroid/graphics/Bitmap;
    //   116: astore_2
    //   117: aload_2
    //   118: astore_3
    //   119: aload #9
    //   121: invokevirtual release : ()V
    //   124: goto -> 173
    //   127: astore #5
    //   129: aload_2
    //   130: astore_3
    //   131: aload_2
    //   132: astore #4
    //   134: aload #5
    //   136: invokevirtual printStackTrace : ()V
    //   139: goto -> 173
    //   142: astore_0
    //   143: goto -> 296
    //   146: astore_2
    //   147: aload_2
    //   148: invokevirtual printStackTrace : ()V
    //   151: aload #5
    //   153: astore_3
    //   154: aload #9
    //   156: invokevirtual release : ()V
    //   159: aload #8
    //   161: astore_2
    //   162: goto -> 173
    //   165: astore #5
    //   167: aload #7
    //   169: astore_2
    //   170: goto -> 129
    //   173: aload_2
    //   174: astore_3
    //   175: aload_2
    //   176: astore #4
    //   178: new android/graphics/drawable/BitmapDrawable
    //   181: dup
    //   182: aload_1
    //   183: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   186: aload_2
    //   187: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   190: astore_1
    //   191: aload_2
    //   192: astore_3
    //   193: aload_2
    //   194: astore #4
    //   196: getstatic android/os/Build$VERSION.SDK_INT : I
    //   199: bipush #16
    //   201: if_icmplt -> 217
    //   204: aload_2
    //   205: astore_3
    //   206: aload_2
    //   207: astore #4
    //   209: aload_0
    //   210: aload_1
    //   211: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
    //   214: goto -> 227
    //   217: aload_2
    //   218: astore_3
    //   219: aload_2
    //   220: astore #4
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   227: aload_2
    //   228: astore_3
    //   229: aload_2
    //   230: astore #4
    //   232: aload_0
    //   233: invokevirtual start : ()V
    //   236: aload_2
    //   237: astore_3
    //   238: aload_2
    //   239: astore #4
    //   241: aload_0
    //   242: new com/geetest/onelogin/j/r$1
    //   245: dup
    //   246: aload_0
    //   247: invokespecial <init> : (Landroid/widget/VideoView;)V
    //   250: invokevirtual setOnCompletionListener : (Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   253: aload_2
    //   254: astore_3
    //   255: aload_2
    //   256: astore #4
    //   258: aload_0
    //   259: new com/geetest/onelogin/j/r$2
    //   262: dup
    //   263: aload_0
    //   264: invokespecial <init> : (Landroid/widget/VideoView;)V
    //   267: invokevirtual setOnPreparedListener : (Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   270: aload_2
    //   271: astore_3
    //   272: aload_2
    //   273: astore #4
    //   275: aload_0
    //   276: new com/geetest/onelogin/j/r$3
    //   279: dup
    //   280: invokespecial <init> : ()V
    //   283: invokevirtual setOnErrorListener : (Landroid/media/MediaPlayer$OnErrorListener;)V
    //   286: aload_2
    //   287: ifnull -> 357
    //   290: aload_2
    //   291: invokevirtual isRecycled : ()Z
    //   294: pop
    //   295: return
    //   296: aload #5
    //   298: astore_3
    //   299: aload #9
    //   301: invokevirtual release : ()V
    //   304: goto -> 319
    //   307: astore_1
    //   308: aload #5
    //   310: astore_3
    //   311: aload #6
    //   313: astore #4
    //   315: aload_1
    //   316: invokevirtual printStackTrace : ()V
    //   319: aload #5
    //   321: astore_3
    //   322: aload #6
    //   324: astore #4
    //   326: aload_0
    //   327: athrow
    //   328: astore_0
    //   329: goto -> 358
    //   332: astore_0
    //   333: aload #4
    //   335: astore_3
    //   336: aload_0
    //   337: invokevirtual printStackTrace : ()V
    //   340: aload #4
    //   342: ifnull -> 357
    //   345: aload #4
    //   347: invokevirtual isRecycled : ()Z
    //   350: pop
    //   351: return
    //   352: astore_0
    //   353: aload_0
    //   354: invokevirtual printStackTrace : ()V
    //   357: return
    //   358: aload_3
    //   359: ifnull -> 375
    //   362: aload_3
    //   363: invokevirtual isRecycled : ()Z
    //   366: pop
    //   367: goto -> 375
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual printStackTrace : ()V
    //   375: aload_0
    //   376: athrow
    // Exception table:
    //   from	to	target	type
    //   19	25	332	java/lang/Exception
    //   19	25	328	finally
    //   32	38	332	java/lang/Exception
    //   32	38	328	finally
    //   45	50	332	java/lang/Exception
    //   45	50	328	finally
    //   57	66	332	java/lang/Exception
    //   57	66	328	finally
    //   66	84	146	java/lang/Exception
    //   66	84	142	finally
    //   87	95	146	java/lang/Exception
    //   87	95	142	finally
    //   98	111	146	java/lang/Exception
    //   98	111	142	finally
    //   111	117	146	java/lang/Exception
    //   111	117	142	finally
    //   119	124	127	java/lang/Exception
    //   119	124	328	finally
    //   134	139	332	java/lang/Exception
    //   134	139	328	finally
    //   147	151	142	finally
    //   154	159	165	java/lang/Exception
    //   154	159	328	finally
    //   178	191	332	java/lang/Exception
    //   178	191	328	finally
    //   196	204	332	java/lang/Exception
    //   196	204	328	finally
    //   209	214	332	java/lang/Exception
    //   209	214	328	finally
    //   222	227	332	java/lang/Exception
    //   222	227	328	finally
    //   232	236	332	java/lang/Exception
    //   232	236	328	finally
    //   241	253	332	java/lang/Exception
    //   241	253	328	finally
    //   258	270	332	java/lang/Exception
    //   258	270	328	finally
    //   275	286	332	java/lang/Exception
    //   275	286	328	finally
    //   290	295	352	java/lang/Exception
    //   299	304	307	java/lang/Exception
    //   299	304	328	finally
    //   315	319	332	java/lang/Exception
    //   315	319	328	finally
    //   326	328	332	java/lang/Exception
    //   326	328	328	finally
    //   336	340	328	finally
    //   345	351	352	java/lang/Exception
    //   362	367	370	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */