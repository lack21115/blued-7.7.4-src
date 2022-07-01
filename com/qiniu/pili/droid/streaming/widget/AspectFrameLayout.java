package com.qiniu.pili.droid.streaming.widget;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class AspectFrameLayout extends FrameLayout {
  public double a = -1.0D;
  
  public SHOW_MODE b = SHOW_MODE.REAL;
  
  public Point c;
  
  public int d = 0;
  
  public int e = 0;
  
  public Rect f = new Rect();
  
  public int g;
  
  public int h;
  
  public AspectFrameLayout(Context paramContext) {
    super(paramContext);
    this.c = h.d(paramContext);
  }
  
  public AspectFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = h.d(paramContext);
  }
  
  public void a(Point paramPoint) {
    this.c = paramPoint;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   3: astore #15
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #16
    //   14: aload #16
    //   16: ldc 'onMeasure target='
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload #16
    //   24: aload_0
    //   25: getfield a : D
    //   28: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload #16
    //   34: ldc ' width=['
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload #16
    //   42: iload_1
    //   43: invokestatic toString : (I)Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #16
    //   52: ldc '] height=['
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #16
    //   60: iload_2
    //   61: invokestatic toString : (I)Ljava/lang/String;
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #16
    //   70: ldc ']'
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #16
    //   78: ldc ',x:'
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload #16
    //   86: aload_0
    //   87: getfield c : Landroid/graphics/Point;
    //   90: getfield x : I
    //   93: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #16
    //   99: ldc ',y:'
    //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload #16
    //   107: aload_0
    //   108: getfield c : Landroid/graphics/Point;
    //   111: getfield y : I
    //   114: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #15
    //   120: ldc 'AspectFrameLayout'
    //   122: aload #16
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: aload_0
    //   132: getfield f : Landroid/graphics/Rect;
    //   135: invokevirtual getWindowVisibleDisplayFrame : (Landroid/graphics/Rect;)V
    //   138: aload_0
    //   139: getfield e : I
    //   142: ifne -> 174
    //   145: aload_0
    //   146: getfield d : I
    //   149: ifne -> 174
    //   152: aload_0
    //   153: aload_0
    //   154: invokevirtual getRootView : ()Landroid/view/View;
    //   157: invokevirtual getWidth : ()I
    //   160: putfield e : I
    //   163: aload_0
    //   164: aload_0
    //   165: invokevirtual getRootView : ()Landroid/view/View;
    //   168: invokevirtual getHeight : ()I
    //   171: putfield d : I
    //   174: aload_0
    //   175: getfield c : Landroid/graphics/Point;
    //   178: astore #15
    //   180: aload #15
    //   182: getfield x : I
    //   185: aload #15
    //   187: getfield y : I
    //   190: if_icmple -> 223
    //   193: aload_0
    //   194: getfield e : I
    //   197: istore #10
    //   199: aload_0
    //   200: getfield d : I
    //   203: istore #11
    //   205: iload #10
    //   207: istore #9
    //   209: iload #10
    //   211: iload #11
    //   213: if_icmple -> 253
    //   216: iload #11
    //   218: istore #9
    //   220: goto -> 253
    //   223: aload_0
    //   224: getfield e : I
    //   227: istore #10
    //   229: aload_0
    //   230: getfield d : I
    //   233: istore #11
    //   235: iload #10
    //   237: istore #9
    //   239: iload #10
    //   241: iload #11
    //   243: if_icmpge -> 253
    //   246: iload #11
    //   248: istore #9
    //   250: goto -> 253
    //   253: aload_0
    //   254: getfield f : Landroid/graphics/Rect;
    //   257: astore #15
    //   259: iload #9
    //   261: aload #15
    //   263: getfield bottom : I
    //   266: aload #15
    //   268: getfield top : I
    //   271: isub
    //   272: isub
    //   273: iload #9
    //   275: iconst_4
    //   276: idiv
    //   277: if_icmple -> 303
    //   280: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   283: ldc 'AspectFrameLayout'
    //   285: ldc 'soft keyboard show'
    //   287: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_0
    //   291: aload_0
    //   292: getfield g : I
    //   295: aload_0
    //   296: getfield h : I
    //   299: invokespecial onMeasure : (II)V
    //   302: return
    //   303: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   306: ldc 'AspectFrameLayout'
    //   308: ldc 'soft keyboard hide'
    //   310: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_0
    //   314: getfield a : D
    //   317: dconst_0
    //   318: dcmpl
    //   319: ifle -> 791
    //   322: iload_1
    //   323: invokestatic getSize : (I)I
    //   326: istore #9
    //   328: iload_2
    //   329: invokestatic getSize : (I)I
    //   332: istore #10
    //   334: aload_0
    //   335: invokevirtual getPaddingLeft : ()I
    //   338: aload_0
    //   339: invokevirtual getPaddingRight : ()I
    //   342: iadd
    //   343: istore #13
    //   345: aload_0
    //   346: invokevirtual getPaddingTop : ()I
    //   349: aload_0
    //   350: invokevirtual getPaddingBottom : ()I
    //   353: iadd
    //   354: istore #14
    //   356: iload #9
    //   358: iload #13
    //   360: isub
    //   361: istore #9
    //   363: iload #10
    //   365: iload #14
    //   367: isub
    //   368: istore #10
    //   370: iload #9
    //   372: i2d
    //   373: dstore_3
    //   374: iload #10
    //   376: i2d
    //   377: dstore #5
    //   379: dload_3
    //   380: dload #5
    //   382: ddiv
    //   383: dstore #7
    //   385: aload_0
    //   386: getfield a : D
    //   389: dload #7
    //   391: ddiv
    //   392: dconst_1
    //   393: dsub
    //   394: dstore #7
    //   396: dload #7
    //   398: invokestatic abs : (D)D
    //   401: ldc2_w 0.01
    //   404: dcmpg
    //   405: ifge -> 495
    //   408: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   411: astore #15
    //   413: new java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial <init> : ()V
    //   420: astore #16
    //   422: aload #16
    //   424: ldc 'aspect ratio is good (target='
    //   426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload #16
    //   432: aload_0
    //   433: getfield a : D
    //   436: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload #16
    //   442: ldc ', view='
    //   444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload #16
    //   450: iload #9
    //   452: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload #16
    //   458: ldc 'x'
    //   460: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload #16
    //   466: iload #10
    //   468: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload #16
    //   474: ldc ')'
    //   476: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload #15
    //   482: ldc 'AspectFrameLayout'
    //   484: aload #16
    //   486: invokevirtual toString : ()Ljava/lang/String;
    //   489: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   492: goto -> 791
    //   495: aload_0
    //   496: getfield b : Lcom/qiniu/pili/droid/streaming/widget/AspectFrameLayout$SHOW_MODE;
    //   499: getstatic com/qiniu/pili/droid/streaming/widget/AspectFrameLayout$SHOW_MODE.REAL : Lcom/qiniu/pili/droid/streaming/widget/AspectFrameLayout$SHOW_MODE;
    //   502: if_acmpne -> 549
    //   505: dload #7
    //   507: dconst_0
    //   508: dcmpl
    //   509: ifle -> 524
    //   512: dload_3
    //   513: aload_0
    //   514: getfield a : D
    //   517: ddiv
    //   518: d2i
    //   519: istore #10
    //   521: goto -> 534
    //   524: dload #5
    //   526: aload_0
    //   527: getfield a : D
    //   530: dmul
    //   531: d2i
    //   532: istore #9
    //   534: iload #9
    //   536: iload #13
    //   538: iadd
    //   539: istore_1
    //   540: iload #10
    //   542: iload #14
    //   544: iadd
    //   545: istore_2
    //   546: goto -> 686
    //   549: aload_0
    //   550: getfield c : Landroid/graphics/Point;
    //   553: astore #15
    //   555: aload #15
    //   557: getfield x : I
    //   560: istore #11
    //   562: aload #15
    //   564: getfield y : I
    //   567: istore #12
    //   569: iload #11
    //   571: iload #12
    //   573: if_icmple -> 631
    //   576: iload #9
    //   578: iload #11
    //   580: if_icmpne -> 605
    //   583: iload #12
    //   585: i2d
    //   586: dstore_3
    //   587: aload_0
    //   588: getfield a : D
    //   591: dstore #5
    //   593: dload_3
    //   594: dload #5
    //   596: dmul
    //   597: d2i
    //   598: istore_1
    //   599: iload #12
    //   601: istore_2
    //   602: goto -> 686
    //   605: iload #9
    //   607: istore_1
    //   608: iload #10
    //   610: istore_2
    //   611: iload #9
    //   613: iload #11
    //   615: if_icmpge -> 686
    //   618: iload #11
    //   620: i2d
    //   621: dstore_3
    //   622: aload_0
    //   623: getfield a : D
    //   626: dstore #5
    //   628: goto -> 648
    //   631: iload #9
    //   633: iload #11
    //   635: if_icmpne -> 660
    //   638: iload #11
    //   640: i2d
    //   641: dstore_3
    //   642: aload_0
    //   643: getfield a : D
    //   646: dstore #5
    //   648: dload_3
    //   649: dload #5
    //   651: ddiv
    //   652: d2i
    //   653: istore_2
    //   654: iload #11
    //   656: istore_1
    //   657: goto -> 686
    //   660: iload #9
    //   662: istore_1
    //   663: iload #10
    //   665: istore_2
    //   666: iload #9
    //   668: iload #11
    //   670: if_icmpge -> 686
    //   673: iload #12
    //   675: i2d
    //   676: dstore_3
    //   677: aload_0
    //   678: getfield a : D
    //   681: dstore #5
    //   683: goto -> 593
    //   686: getstatic a/a/a/a/a/e/e.c : La/a/a/a/a/e/e;
    //   689: astore #15
    //   691: new java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial <init> : ()V
    //   698: astore #16
    //   700: aload #16
    //   702: ldc 'new size='
    //   704: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload #16
    //   710: iload_1
    //   711: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload #16
    //   717: ldc 'x'
    //   719: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload #16
    //   725: iload_2
    //   726: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload #16
    //   732: ldc ' + padding '
    //   734: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload #16
    //   740: iload #13
    //   742: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload #16
    //   748: ldc 'x'
    //   750: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload #16
    //   756: iload #14
    //   758: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload #15
    //   764: ldc 'AspectFrameLayout'
    //   766: aload #16
    //   768: invokevirtual toString : ()Ljava/lang/String;
    //   771: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   774: iload_1
    //   775: ldc 1073741824
    //   777: invokestatic makeMeasureSpec : (II)I
    //   780: istore_1
    //   781: iload_2
    //   782: ldc 1073741824
    //   784: invokestatic makeMeasureSpec : (II)I
    //   787: istore_2
    //   788: goto -> 791
    //   791: aload_0
    //   792: iload_1
    //   793: putfield g : I
    //   796: aload_0
    //   797: iload_2
    //   798: putfield h : I
    //   801: aload_0
    //   802: iload_1
    //   803: iload_2
    //   804: invokespecial onMeasure : (II)V
    //   807: return
  }
  
  public void setAspectRatio(double paramDouble) {
    if (paramDouble >= 0.0D) {
      e e = e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Setting aspect ratio to ");
      stringBuilder.append(paramDouble);
      stringBuilder.append(" (was ");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      e.c("AspectFrameLayout", stringBuilder.toString());
      if (this.a != paramDouble) {
        this.a = paramDouble;
        if (getHandler() != null)
          getHandler().post(new a(this)); 
      } 
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  public void setShowMode(SHOW_MODE paramSHOW_MODE) {
    this.b = paramSHOW_MODE;
  }
  
  public enum SHOW_MODE {
    FULL, REAL;
    
    static {
      SHOW_MODE sHOW_MODE = new SHOW_MODE("REAL", 1);
      REAL = sHOW_MODE;
      $VALUES = new SHOW_MODE[] { FULL, sHOW_MODE };
    }
  }
  
  public class a implements Runnable {
    public a(AspectFrameLayout this$0) {}
    
    public void run() {
      this.a.requestLayout();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\widget\AspectFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */