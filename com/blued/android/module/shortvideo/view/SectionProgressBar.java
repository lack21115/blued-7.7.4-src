package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import java.util.LinkedList;

public class SectionProgressBar extends View implements EventObserver, ReturnObserver {
  private final LinkedList<Long> a = new LinkedList<Long>();
  
  private Paint b;
  
  private Paint c;
  
  private Paint d;
  
  private Paint e;
  
  private Paint f;
  
  private boolean g = true;
  
  private boolean h = false;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private volatile State l = State.b;
  
  private float m;
  
  private float n;
  
  private long o;
  
  private long p;
  
  private int q;
  
  public SectionProgressBar(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public SectionProgressBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SectionProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.q = (getResources().getDisplayMetrics()).widthPixels;
    this.b = new Paint();
    this.c = new Paint();
    this.d = new Paint();
    this.e = new Paint();
    this.f = new Paint();
    setBackgroundColor(Color.parseColor("#4C000000"));
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(getResources().getColor(R.color.stv_yellow_color));
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(getResources().getColor(R.color.nafio_b));
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(getResources().getColor(R.color.nafio_b));
    this.e.setStyle(Paint.Style.FILL);
    this.e.setColor(getResources().getColor(R.color.nafio_b));
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(Color.parseColor("#ff0000"));
  }
  
  public void a() {
    if (getVisibility() == 8)
      setVisibility(0); 
  }
  
  public void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: fconst_0
    //   4: putfield n : F
    //   7: aload_0
    //   8: getfield a : Ljava/util/LinkedList;
    //   11: lload_1
    //   12: invokestatic valueOf : (J)Ljava/lang/Long;
    //   15: invokevirtual add : (Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	22	finally
  }
  
  public void a(Context paramContext, long paramLong) {
    this.k = (float)paramLong;
    this.i = this.q / this.k;
    this.m = this.i;
  }
  
  public void a(EventType.VALUE paramVALUE) {
    switch (null.a[paramVALUE.ordinal()]) {
      default:
        return;
      case 5:
      case 6:
        a(false);
        return;
      case 4:
        a(true);
        return;
      case 3:
        a();
        return;
      case 2:
        b();
        return;
      case 1:
        break;
    } 
    setCurrentState(State.b);
  }
  
  public void a(EventType.VALUE paramVALUE, boolean paramBoolean) {
    if (paramBoolean && paramVALUE == EventType.VALUE.g) {
      a(false);
      a();
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void b() {
    if (getVisibility() == 0)
      setVisibility(8); 
  }
  
  public void c() {
    ObserverMgr.a().a(this);
    ObserverMgr.a().a(this);
  }
  
  public void d() {}
  
  public void e() {
    ObserverMgr.a().b(this);
    ObserverMgr.a().b(this);
  }
  
  public void f() {}
  
  public void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual i : ()Z
    //   6: ifeq -> 17
    //   9: aload_0
    //   10: getfield a : Ljava/util/LinkedList;
    //   13: invokevirtual removeLast : ()Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  public void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual i : ()Z
    //   6: ifeq -> 16
    //   9: aload_0
    //   10: getfield a : Ljava/util/LinkedList;
    //   13: invokevirtual clear : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
  
  public boolean i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/LinkedList;
    //   6: invokevirtual isEmpty : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: iconst_1
    //   14: ixor
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	16	finally
  }
  
  protected void onDraw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onDraw : (Landroid/graphics/Canvas;)V
    //   5: invokestatic currentTimeMillis : ()J
    //   8: lstore #8
    //   10: aload_0
    //   11: getfield p : J
    //   14: lstore #10
    //   16: lload #10
    //   18: lconst_0
    //   19: lcmp
    //   20: ifeq -> 35
    //   23: lload #8
    //   25: lload #10
    //   27: lsub
    //   28: ldc2_w 500
    //   31: lcmp
    //   32: iflt -> 52
    //   35: aload_0
    //   36: aload_0
    //   37: getfield g : Z
    //   40: iconst_1
    //   41: ixor
    //   42: putfield g : Z
    //   45: aload_0
    //   46: invokestatic currentTimeMillis : ()J
    //   49: putfield p : J
    //   52: aload_0
    //   53: monitorenter
    //   54: aload_0
    //   55: getfield a : Ljava/util/LinkedList;
    //   58: invokevirtual isEmpty : ()Z
    //   61: istore #12
    //   63: iconst_0
    //   64: istore #4
    //   66: iload #12
    //   68: ifne -> 267
    //   71: aload_0
    //   72: getfield a : Ljava/util/LinkedList;
    //   75: invokevirtual size : ()I
    //   78: istore #6
    //   80: iconst_0
    //   81: istore #5
    //   83: iconst_0
    //   84: istore #4
    //   86: fconst_0
    //   87: fstore_2
    //   88: iload #5
    //   90: iload #6
    //   92: if_icmpge -> 503
    //   95: aload_0
    //   96: getfield a : Ljava/util/LinkedList;
    //   99: iload #5
    //   101: invokevirtual get : (I)Ljava/lang/Object;
    //   104: checkcast java/lang/Long
    //   107: astore #13
    //   109: iload #4
    //   111: i2f
    //   112: fstore_3
    //   113: aload #13
    //   115: invokevirtual longValue : ()J
    //   118: l2f
    //   119: fload_2
    //   120: fsub
    //   121: aload_0
    //   122: getfield i : F
    //   125: fmul
    //   126: fload_3
    //   127: fadd
    //   128: f2i
    //   129: istore #7
    //   131: iload #5
    //   133: iload #6
    //   135: iconst_1
    //   136: isub
    //   137: if_icmpne -> 497
    //   140: aload_0
    //   141: getfield g : Z
    //   144: ifeq -> 497
    //   147: aload_0
    //   148: getfield h : Z
    //   151: ifeq -> 497
    //   154: iconst_1
    //   155: istore #4
    //   157: goto -> 160
    //   160: iload #4
    //   162: ifeq -> 195
    //   165: aload_0
    //   166: getfield c : Landroid/graphics/Paint;
    //   169: bipush #100
    //   171: invokevirtual setAlpha : (I)V
    //   174: aload_1
    //   175: fload_3
    //   176: fconst_0
    //   177: iload #7
    //   179: i2f
    //   180: aload_0
    //   181: invokevirtual getMeasuredHeight : ()I
    //   184: i2f
    //   185: aload_0
    //   186: getfield c : Landroid/graphics/Paint;
    //   189: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   192: goto -> 223
    //   195: aload_0
    //   196: getfield c : Landroid/graphics/Paint;
    //   199: sipush #255
    //   202: invokevirtual setAlpha : (I)V
    //   205: aload_1
    //   206: fload_3
    //   207: fconst_0
    //   208: iload #7
    //   210: i2f
    //   211: aload_0
    //   212: invokevirtual getMeasuredHeight : ()I
    //   215: i2f
    //   216: aload_0
    //   217: getfield c : Landroid/graphics/Paint;
    //   220: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   223: iload #7
    //   225: i2f
    //   226: fstore_2
    //   227: fload_2
    //   228: fconst_2
    //   229: fadd
    //   230: fstore_3
    //   231: aload_1
    //   232: fload_2
    //   233: fconst_0
    //   234: fload_3
    //   235: aload_0
    //   236: invokevirtual getMeasuredHeight : ()I
    //   239: i2f
    //   240: aload_0
    //   241: getfield e : Landroid/graphics/Paint;
    //   244: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   247: fload_3
    //   248: f2i
    //   249: istore #4
    //   251: aload #13
    //   253: invokevirtual longValue : ()J
    //   256: l2f
    //   257: fstore_2
    //   258: iload #5
    //   260: iconst_1
    //   261: iadd
    //   262: istore #5
    //   264: goto -> 88
    //   267: aload_0
    //   268: getfield a : Ljava/util/LinkedList;
    //   271: invokevirtual isEmpty : ()Z
    //   274: ifeq -> 304
    //   277: aload_1
    //   278: aload_0
    //   279: getfield j : F
    //   282: fconst_0
    //   283: aload_0
    //   284: getfield j : F
    //   287: fconst_2
    //   288: fadd
    //   289: aload_0
    //   290: invokevirtual getMeasuredHeight : ()I
    //   293: i2f
    //   294: aload_0
    //   295: getfield d : Landroid/graphics/Paint;
    //   298: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   301: goto -> 339
    //   304: iload #4
    //   306: i2f
    //   307: aload_0
    //   308: getfield j : F
    //   311: fcmpg
    //   312: ifgt -> 339
    //   315: aload_1
    //   316: aload_0
    //   317: getfield j : F
    //   320: fconst_0
    //   321: aload_0
    //   322: getfield j : F
    //   325: fconst_2
    //   326: fadd
    //   327: aload_0
    //   328: invokevirtual getMeasuredHeight : ()I
    //   331: i2f
    //   332: aload_0
    //   333: getfield d : Landroid/graphics/Paint;
    //   336: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   339: aload_0
    //   340: monitorexit
    //   341: aload_0
    //   342: getfield l : Lcom/blued/android/module/shortvideo/view/SectionProgressBar$State;
    //   345: getstatic com/blued/android/module/shortvideo/view/SectionProgressBar$State.a : Lcom/blued/android/module/shortvideo/view/SectionProgressBar$State;
    //   348: if_acmpne -> 373
    //   351: aload_0
    //   352: aload_0
    //   353: getfield n : F
    //   356: aload_0
    //   357: getfield m : F
    //   360: lload #8
    //   362: aload_0
    //   363: getfield o : J
    //   366: lsub
    //   367: l2f
    //   368: fmul
    //   369: fadd
    //   370: putfield n : F
    //   373: aload_0
    //   374: getfield c : Landroid/graphics/Paint;
    //   377: sipush #255
    //   380: invokevirtual setAlpha : (I)V
    //   383: iload #4
    //   385: i2f
    //   386: fstore_2
    //   387: aload_0
    //   388: getfield n : F
    //   391: fload_2
    //   392: fadd
    //   393: aload_0
    //   394: invokevirtual getMeasuredWidth : ()I
    //   397: i2f
    //   398: fcmpg
    //   399: ifgt -> 426
    //   402: aload_1
    //   403: fload_2
    //   404: fconst_0
    //   405: fload_2
    //   406: aload_0
    //   407: getfield n : F
    //   410: fadd
    //   411: aload_0
    //   412: invokevirtual getMeasuredHeight : ()I
    //   415: i2f
    //   416: aload_0
    //   417: getfield c : Landroid/graphics/Paint;
    //   420: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   423: goto -> 446
    //   426: aload_1
    //   427: fload_2
    //   428: fconst_0
    //   429: aload_0
    //   430: invokevirtual getMeasuredWidth : ()I
    //   433: i2f
    //   434: aload_0
    //   435: invokevirtual getMeasuredHeight : ()I
    //   438: i2f
    //   439: aload_0
    //   440: getfield c : Landroid/graphics/Paint;
    //   443: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   446: aload_0
    //   447: getfield g : Z
    //   450: ifeq -> 480
    //   453: aload_0
    //   454: getfield n : F
    //   457: fstore_3
    //   458: aload_1
    //   459: fload_2
    //   460: fload_3
    //   461: fadd
    //   462: fconst_0
    //   463: fload_2
    //   464: fconst_2
    //   465: fadd
    //   466: fload_3
    //   467: fadd
    //   468: aload_0
    //   469: invokevirtual getMeasuredHeight : ()I
    //   472: i2f
    //   473: aload_0
    //   474: getfield b : Landroid/graphics/Paint;
    //   477: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   480: aload_0
    //   481: invokestatic currentTimeMillis : ()J
    //   484: putfield o : J
    //   487: aload_0
    //   488: invokevirtual invalidate : ()V
    //   491: return
    //   492: astore_1
    //   493: aload_0
    //   494: monitorexit
    //   495: aload_1
    //   496: athrow
    //   497: iconst_0
    //   498: istore #4
    //   500: goto -> 160
    //   503: goto -> 267
    // Exception table:
    //   from	to	target	type
    //   54	63	492	finally
    //   71	80	492	finally
    //   95	109	492	finally
    //   113	131	492	finally
    //   140	154	492	finally
    //   165	192	492	finally
    //   195	223	492	finally
    //   231	247	492	finally
    //   251	258	492	finally
    //   267	301	492	finally
    //   304	339	492	finally
    //   339	341	492	finally
    //   493	495	492	finally
  }
  
  public void setCurrentState(State paramState) {
    this.l = paramState;
    if (this.l == State.b)
      this.n = 0.0F; 
  }
  
  public void setFirstPointPre(float paramFloat) {
    this.j = this.q * paramFloat;
  }
  
  public enum State {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\SectionProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */