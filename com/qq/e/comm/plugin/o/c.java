package com.qq.e.comm.plugin.o;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.ads.hybrid.HybridADSetting;

class c extends RelativeLayout {
  private final ImageView a;
  
  private final View b;
  
  private final View c;
  
  private final ImageView d;
  
  private final TextView e;
  
  public c(Context paramContext, HybridADSetting paramHybridADSetting) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial <init> : (Landroid/content/Context;)V
    //   5: aload_0
    //   6: aload_2
    //   7: invokevirtual getTitleBarColor : ()I
    //   10: invokevirtual setBackgroundColor : (I)V
    //   13: aload_0
    //   14: new android/widget/ImageView
    //   17: dup
    //   18: aload_1
    //   19: invokespecial <init> : (Landroid/content/Context;)V
    //   22: putfield a : Landroid/widget/ImageView;
    //   25: aload_0
    //   26: getfield a : Landroid/widget/ImageView;
    //   29: getstatic android/widget/ImageView$ScaleType.FIT_CENTER : Landroid/widget/ImageView$ScaleType;
    //   32: invokevirtual setScaleType : (Landroid/widget/ImageView$ScaleType;)V
    //   35: aload_0
    //   36: getfield a : Landroid/widget/ImageView;
    //   39: ldc 2131755009
    //   41: invokevirtual setId : (I)V
    //   44: aload_1
    //   45: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   48: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   51: getfield density : F
    //   54: fconst_2
    //   55: fdiv
    //   56: fstore_3
    //   57: aload_2
    //   58: invokevirtual getBackButtonImage : ()Ljava/lang/String;
    //   61: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   64: ifne -> 111
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual getBackButtonImage : ()Ljava/lang/String;
    //   72: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   75: astore #6
    //   77: aload #6
    //   79: instanceof android/graphics/drawable/BitmapDrawable
    //   82: ifeq -> 111
    //   85: aload #6
    //   87: invokevirtual getIntrinsicWidth : ()I
    //   90: istore #4
    //   92: aload #6
    //   94: invokevirtual getIntrinsicHeight : ()I
    //   97: istore #5
    //   99: aload_0
    //   100: getfield a : Landroid/widget/ImageView;
    //   103: aload #6
    //   105: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   108: goto -> 149
    //   111: ldc 'iVBORw0KGgoAAAANSUhEUgAAAFgAAABYBAMAAACDuy0HAAAAMFBMVEUAAAArLTQqLTMyMjMuLjQrLjMrLTMsLzYrLzMuLkYsLzMrLTQrLzUsLzQrMDQqLTMf2TcfAAAAD3RSTlMA2OYYJ/rzUTwLRst+YjvhhJY4AAAAXklEQVRIx2MYBaNgFIyCkQw4V5Kg2PA38WqZ5T+RYPD/cBIM/lowavAQNZiTFIO5/v8hISHrf2sgXrXT/wziFbOMGj1ojc4jxeiPDCQYTYpi5ssMo2AUjIJRMAoIAQAD4S52zh4qlgAAAABJRU5ErkJggg=='
    //   113: invokestatic a : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   116: astore #6
    //   118: aload #6
    //   120: invokevirtual getWidth : ()I
    //   123: i2f
    //   124: fload_3
    //   125: fmul
    //   126: f2i
    //   127: istore #4
    //   129: aload #6
    //   131: invokevirtual getHeight : ()I
    //   134: i2f
    //   135: fload_3
    //   136: fmul
    //   137: f2i
    //   138: istore #5
    //   140: aload_0
    //   141: getfield a : Landroid/widget/ImageView;
    //   144: aload #6
    //   146: invokevirtual setImageBitmap : (Landroid/graphics/Bitmap;)V
    //   149: new android/widget/RelativeLayout$LayoutParams
    //   152: dup
    //   153: iload #4
    //   155: iload #5
    //   157: invokespecial <init> : (II)V
    //   160: astore #6
    //   162: aload #6
    //   164: bipush #15
    //   166: iconst_m1
    //   167: invokevirtual addRule : (II)V
    //   170: aload #6
    //   172: bipush #9
    //   174: iconst_m1
    //   175: invokevirtual addRule : (II)V
    //   178: aload_0
    //   179: aload_0
    //   180: getfield a : Landroid/widget/ImageView;
    //   183: aload #6
    //   185: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   188: aload_0
    //   189: new android/view/View
    //   192: dup
    //   193: aload_1
    //   194: invokespecial <init> : (Landroid/content/Context;)V
    //   197: putfield b : Landroid/view/View;
    //   200: aload_0
    //   201: getfield b : Landroid/view/View;
    //   204: ldc 2131755010
    //   206: invokevirtual setId : (I)V
    //   209: aload_0
    //   210: getfield b : Landroid/view/View;
    //   213: aload_2
    //   214: invokevirtual getSeparatorColor : ()I
    //   217: invokevirtual setBackgroundColor : (I)V
    //   220: new android/widget/RelativeLayout$LayoutParams
    //   223: dup
    //   224: aload_1
    //   225: iconst_1
    //   226: invokestatic a : (Landroid/content/Context;I)I
    //   229: aload_1
    //   230: aload_2
    //   231: invokevirtual getBackSeparatorLength : ()I
    //   234: invokestatic a : (Landroid/content/Context;I)I
    //   237: invokespecial <init> : (II)V
    //   240: astore #6
    //   242: aload #6
    //   244: bipush #15
    //   246: iconst_m1
    //   247: invokevirtual addRule : (II)V
    //   250: aload #6
    //   252: iconst_1
    //   253: ldc 2131755009
    //   255: invokevirtual addRule : (II)V
    //   258: aload_0
    //   259: aload_0
    //   260: getfield b : Landroid/view/View;
    //   263: aload #6
    //   265: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   268: aload_0
    //   269: new android/widget/ImageView
    //   272: dup
    //   273: aload_1
    //   274: invokespecial <init> : (Landroid/content/Context;)V
    //   277: putfield d : Landroid/widget/ImageView;
    //   280: aload_0
    //   281: getfield d : Landroid/widget/ImageView;
    //   284: ldc 2131755011
    //   286: invokevirtual setId : (I)V
    //   289: aload_0
    //   290: getfield d : Landroid/widget/ImageView;
    //   293: getstatic android/widget/ImageView$ScaleType.FIT_CENTER : Landroid/widget/ImageView$ScaleType;
    //   296: invokevirtual setScaleType : (Landroid/widget/ImageView$ScaleType;)V
    //   299: aload_2
    //   300: invokevirtual getCloseButtonImage : ()Ljava/lang/String;
    //   303: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   306: ifne -> 353
    //   309: aload_1
    //   310: aload_2
    //   311: invokevirtual getCloseButtonImage : ()Ljava/lang/String;
    //   314: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   317: astore #6
    //   319: aload #6
    //   321: instanceof android/graphics/drawable/BitmapDrawable
    //   324: ifeq -> 353
    //   327: aload #6
    //   329: invokevirtual getIntrinsicWidth : ()I
    //   332: istore #5
    //   334: aload #6
    //   336: invokevirtual getIntrinsicHeight : ()I
    //   339: istore #4
    //   341: aload_0
    //   342: getfield d : Landroid/widget/ImageView;
    //   345: aload #6
    //   347: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   350: goto -> 391
    //   353: ldc 'iVBORw0KGgoAAAANSUhEUgAAAFgAAABYBAMAAACDuy0HAAAAKlBMVEUAAAAqLTQsMjMrLzMrLjMrLjQqLjMrLTQuLjMxMT2AgIAsLjMqLjQqLTM0qw1cAAAADXRSTlMAnSNB9eOqcTcVAoaFBOzX1gAAALFJREFUSMft0rENwlAMRVFDGqD6CyD9kgGyRppMwAJIVCzCAqzABqyQIqV3Aaqbys8D+HZujlw8q6qqquIu2+P5sqi9N45h+ljUwReO0ZuFnb0Br93CdtCjz0YxDaxpYE0DaxpY08ApGljTwAkaOEE7sKaBZYP71bKN7ksantabtzQ8Mz4Nd8anYcaXgQ1aw9AZGFrD0BqG1nCSPgL/6Xv8BfCPFnM6vbvRo1tVVVUV9QW8Pkx3bVKuuwAAAABJRU5ErkJggg=='
    //   355: invokestatic a : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   358: astore #6
    //   360: aload #6
    //   362: invokevirtual getWidth : ()I
    //   365: i2f
    //   366: fload_3
    //   367: fmul
    //   368: f2i
    //   369: istore #5
    //   371: aload #6
    //   373: invokevirtual getHeight : ()I
    //   376: i2f
    //   377: fload_3
    //   378: fmul
    //   379: f2i
    //   380: istore #4
    //   382: aload_0
    //   383: getfield d : Landroid/widget/ImageView;
    //   386: aload #6
    //   388: invokevirtual setImageBitmap : (Landroid/graphics/Bitmap;)V
    //   391: new android/widget/RelativeLayout$LayoutParams
    //   394: dup
    //   395: iload #5
    //   397: iload #4
    //   399: invokespecial <init> : (II)V
    //   402: astore #6
    //   404: aload #6
    //   406: bipush #15
    //   408: iconst_m1
    //   409: invokevirtual addRule : (II)V
    //   412: aload #6
    //   414: iconst_1
    //   415: ldc 2131755010
    //   417: invokevirtual addRule : (II)V
    //   420: aload_0
    //   421: aload_0
    //   422: getfield d : Landroid/widget/ImageView;
    //   425: aload #6
    //   427: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   430: aload_0
    //   431: new android/widget/TextView
    //   434: dup
    //   435: aload_1
    //   436: invokespecial <init> : (Landroid/content/Context;)V
    //   439: putfield e : Landroid/widget/TextView;
    //   442: aload_0
    //   443: getfield e : Landroid/widget/TextView;
    //   446: aload_2
    //   447: invokevirtual getTitleSize : ()I
    //   450: i2f
    //   451: invokevirtual setTextSize : (F)V
    //   454: aload_0
    //   455: getfield e : Landroid/widget/TextView;
    //   458: aload_2
    //   459: invokevirtual getTitleColor : ()I
    //   462: invokevirtual setTextColor : (I)V
    //   465: aload_0
    //   466: getfield e : Landroid/widget/TextView;
    //   469: aload_2
    //   470: invokevirtual getTitle : ()Ljava/lang/String;
    //   473: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   476: aload_0
    //   477: getfield e : Landroid/widget/TextView;
    //   480: bipush #17
    //   482: invokevirtual setGravity : (I)V
    //   485: aload_0
    //   486: getfield e : Landroid/widget/TextView;
    //   489: aload_1
    //   490: sipush #160
    //   493: invokestatic a : (Landroid/content/Context;I)I
    //   496: invokevirtual setMaxWidth : (I)V
    //   499: aload_0
    //   500: getfield e : Landroid/widget/TextView;
    //   503: iconst_1
    //   504: invokevirtual setSingleLine : (Z)V
    //   507: aload_0
    //   508: getfield e : Landroid/widget/TextView;
    //   511: getstatic android/text/TextUtils$TruncateAt.END : Landroid/text/TextUtils$TruncateAt;
    //   514: invokevirtual setEllipsize : (Landroid/text/TextUtils$TruncateAt;)V
    //   517: new android/widget/RelativeLayout$LayoutParams
    //   520: dup
    //   521: bipush #-2
    //   523: bipush #-2
    //   525: invokespecial <init> : (II)V
    //   528: astore #6
    //   530: aload #6
    //   532: bipush #13
    //   534: iconst_m1
    //   535: invokevirtual addRule : (II)V
    //   538: aload_0
    //   539: aload_0
    //   540: getfield e : Landroid/widget/TextView;
    //   543: aload #6
    //   545: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   548: aload_0
    //   549: new android/view/View
    //   552: dup
    //   553: aload_1
    //   554: invokespecial <init> : (Landroid/content/Context;)V
    //   557: putfield c : Landroid/view/View;
    //   560: aload_0
    //   561: getfield c : Landroid/view/View;
    //   564: aload_2
    //   565: invokevirtual getSeparatorColor : ()I
    //   568: invokevirtual setBackgroundColor : (I)V
    //   571: new android/widget/RelativeLayout$LayoutParams
    //   574: dup
    //   575: iconst_m1
    //   576: aload_1
    //   577: iconst_1
    //   578: invokestatic a : (Landroid/content/Context;I)I
    //   581: invokespecial <init> : (II)V
    //   584: astore_1
    //   585: aload_1
    //   586: bipush #12
    //   588: iconst_m1
    //   589: invokevirtual addRule : (II)V
    //   592: aload_0
    //   593: aload_0
    //   594: getfield c : Landroid/view/View;
    //   597: aload_1
    //   598: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   601: aload_0
    //   602: getfield b : Landroid/view/View;
    //   605: iconst_4
    //   606: invokevirtual setVisibility : (I)V
    //   609: aload_0
    //   610: getfield d : Landroid/widget/ImageView;
    //   613: iconst_4
    //   614: invokevirtual setVisibility : (I)V
    //   617: return
  }
  
  public ImageView a() {
    return this.a;
  }
  
  public ImageView b() {
    return this.d;
  }
  
  public TextView c() {
    return this.e;
  }
  
  public View d() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\o\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */