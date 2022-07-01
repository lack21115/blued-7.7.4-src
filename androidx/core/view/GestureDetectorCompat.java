package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
  private final GestureDetectorCompatImpl a;
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener) {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler) {
    if (Build.VERSION.SDK_INT > 17) {
      this.a = new GestureDetectorCompatImplJellybeanMr2(paramContext, paramOnGestureListener, paramHandler);
      return;
    } 
    this.a = new GestureDetectorCompatImplBase(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean isLongpressEnabled() {
    return this.a.isLongpressEnabled();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.a.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean) {
    this.a.setIsLongpressEnabled(paramBoolean);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener) {
    this.a.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  static interface GestureDetectorCompatImpl {
    boolean isLongpressEnabled();
    
    boolean onTouchEvent(MotionEvent param1MotionEvent);
    
    void setIsLongpressEnabled(boolean param1Boolean);
    
    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener);
  }
  
  static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
    private static final int j = ViewConfiguration.getLongPressTimeout();
    
    private static final int k = ViewConfiguration.getTapTimeout();
    
    private static final int l = ViewConfiguration.getDoubleTapTimeout();
    
    final GestureDetector.OnGestureListener a;
    
    GestureDetector.OnDoubleTapListener b;
    
    boolean c;
    
    boolean d;
    
    MotionEvent e;
    
    private int f;
    
    private int g;
    
    private int h;
    
    private int i;
    
    private final Handler m;
    
    private boolean n;
    
    private boolean o;
    
    private boolean p;
    
    private MotionEvent q;
    
    private boolean r;
    
    private float s;
    
    private float t;
    
    private float u;
    
    private float v;
    
    private boolean w;
    
    private VelocityTracker x;
    
    GestureDetectorCompatImplBase(Context param1Context, GestureDetector.OnGestureListener param1OnGestureListener, Handler param1Handler) {
      if (param1Handler != null) {
        this.m = new GestureHandler(this, param1Handler);
      } else {
        this.m = new GestureHandler(this);
      } 
      this.a = param1OnGestureListener;
      if (param1OnGestureListener instanceof GestureDetector.OnDoubleTapListener)
        setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)param1OnGestureListener); 
      a(param1Context);
    }
    
    private void a(Context param1Context) {
      if (param1Context != null) {
        if (this.a != null) {
          this.w = true;
          ViewConfiguration viewConfiguration = ViewConfiguration.get(param1Context);
          int i = viewConfiguration.getScaledTouchSlop();
          int j = viewConfiguration.getScaledDoubleTapSlop();
          this.h = viewConfiguration.getScaledMinimumFlingVelocity();
          this.i = viewConfiguration.getScaledMaximumFlingVelocity();
          this.f = i * i;
          this.g = j * j;
          return;
        } 
        throw new IllegalArgumentException("OnGestureListener must not be null");
      } 
      throw new IllegalArgumentException("Context must not be null");
    }
    
    private boolean a(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, MotionEvent param1MotionEvent3) {
      boolean bool1 = this.p;
      boolean bool = false;
      if (!bool1)
        return false; 
      if (param1MotionEvent3.getEventTime() - param1MotionEvent2.getEventTime() > l)
        return false; 
      int i = (int)param1MotionEvent1.getX() - (int)param1MotionEvent3.getX();
      int j = (int)param1MotionEvent1.getY() - (int)param1MotionEvent3.getY();
      if (i * i + j * j < this.g)
        bool = true; 
      return bool;
    }
    
    private void b() {
      this.m.removeMessages(1);
      this.m.removeMessages(2);
      this.m.removeMessages(3);
      this.x.recycle();
      this.x = null;
      this.r = false;
      this.c = false;
      this.o = false;
      this.p = false;
      this.d = false;
      if (this.n)
        this.n = false; 
    }
    
    private void c() {
      this.m.removeMessages(1);
      this.m.removeMessages(2);
      this.m.removeMessages(3);
      this.r = false;
      this.o = false;
      this.p = false;
      this.d = false;
      if (this.n)
        this.n = false; 
    }
    
    void a() {
      this.m.removeMessages(3);
      this.d = false;
      this.n = true;
      this.a.onLongPress(this.e);
    }
    
    public boolean isLongpressEnabled() {
      return this.w;
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getAction : ()I
      //   4: istore #6
      //   6: aload_0
      //   7: getfield x : Landroid/view/VelocityTracker;
      //   10: ifnonnull -> 20
      //   13: aload_0
      //   14: invokestatic obtain : ()Landroid/view/VelocityTracker;
      //   17: putfield x : Landroid/view/VelocityTracker;
      //   20: aload_0
      //   21: getfield x : Landroid/view/VelocityTracker;
      //   24: aload_1
      //   25: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
      //   28: iload #6
      //   30: sipush #255
      //   33: iand
      //   34: istore #10
      //   36: iconst_0
      //   37: istore #12
      //   39: iload #10
      //   41: bipush #6
      //   43: if_icmpne -> 52
      //   46: iconst_1
      //   47: istore #6
      //   49: goto -> 55
      //   52: iconst_0
      //   53: istore #6
      //   55: iload #6
      //   57: ifeq -> 69
      //   60: aload_1
      //   61: invokevirtual getActionIndex : ()I
      //   64: istore #7
      //   66: goto -> 72
      //   69: iconst_m1
      //   70: istore #7
      //   72: aload_1
      //   73: invokevirtual getPointerCount : ()I
      //   76: istore #9
      //   78: iconst_0
      //   79: istore #8
      //   81: fconst_0
      //   82: fstore_3
      //   83: fconst_0
      //   84: fstore_2
      //   85: iload #8
      //   87: iload #9
      //   89: if_icmpge -> 129
      //   92: iload #7
      //   94: iload #8
      //   96: if_icmpne -> 102
      //   99: goto -> 120
      //   102: fload_3
      //   103: aload_1
      //   104: iload #8
      //   106: invokevirtual getX : (I)F
      //   109: fadd
      //   110: fstore_3
      //   111: fload_2
      //   112: aload_1
      //   113: iload #8
      //   115: invokevirtual getY : (I)F
      //   118: fadd
      //   119: fstore_2
      //   120: iload #8
      //   122: iconst_1
      //   123: iadd
      //   124: istore #8
      //   126: goto -> 85
      //   129: iload #6
      //   131: ifeq -> 143
      //   134: iload #9
      //   136: iconst_1
      //   137: isub
      //   138: istore #6
      //   140: goto -> 147
      //   143: iload #9
      //   145: istore #6
      //   147: iload #6
      //   149: i2f
      //   150: fstore #4
      //   152: fload_3
      //   153: fload #4
      //   155: fdiv
      //   156: fstore_3
      //   157: fload_2
      //   158: fload #4
      //   160: fdiv
      //   161: fstore_2
      //   162: iload #10
      //   164: ifeq -> 890
      //   167: iload #10
      //   169: iconst_1
      //   170: if_icmpeq -> 618
      //   173: iload #10
      //   175: iconst_2
      //   176: if_icmpeq -> 379
      //   179: iload #10
      //   181: iconst_3
      //   182: if_icmpeq -> 373
      //   185: iload #10
      //   187: iconst_5
      //   188: if_icmpeq -> 347
      //   191: iload #10
      //   193: bipush #6
      //   195: if_icmpeq -> 200
      //   198: iconst_0
      //   199: ireturn
      //   200: aload_0
      //   201: fload_3
      //   202: putfield s : F
      //   205: aload_0
      //   206: fload_3
      //   207: putfield u : F
      //   210: aload_0
      //   211: fload_2
      //   212: putfield t : F
      //   215: aload_0
      //   216: fload_2
      //   217: putfield v : F
      //   220: aload_0
      //   221: getfield x : Landroid/view/VelocityTracker;
      //   224: sipush #1000
      //   227: aload_0
      //   228: getfield i : I
      //   231: i2f
      //   232: invokevirtual computeCurrentVelocity : (IF)V
      //   235: aload_1
      //   236: invokevirtual getActionIndex : ()I
      //   239: istore #7
      //   241: aload_1
      //   242: iload #7
      //   244: invokevirtual getPointerId : (I)I
      //   247: istore #6
      //   249: aload_0
      //   250: getfield x : Landroid/view/VelocityTracker;
      //   253: iload #6
      //   255: invokevirtual getXVelocity : (I)F
      //   258: fstore_2
      //   259: aload_0
      //   260: getfield x : Landroid/view/VelocityTracker;
      //   263: iload #6
      //   265: invokevirtual getYVelocity : (I)F
      //   268: fstore_3
      //   269: iconst_0
      //   270: istore #6
      //   272: iload #12
      //   274: istore #11
      //   276: iload #6
      //   278: iload #9
      //   280: if_icmpge -> 1157
      //   283: iload #6
      //   285: iload #7
      //   287: if_icmpne -> 293
      //   290: goto -> 338
      //   293: aload_1
      //   294: iload #6
      //   296: invokevirtual getPointerId : (I)I
      //   299: istore #8
      //   301: aload_0
      //   302: getfield x : Landroid/view/VelocityTracker;
      //   305: iload #8
      //   307: invokevirtual getXVelocity : (I)F
      //   310: fload_2
      //   311: fmul
      //   312: aload_0
      //   313: getfield x : Landroid/view/VelocityTracker;
      //   316: iload #8
      //   318: invokevirtual getYVelocity : (I)F
      //   321: fload_3
      //   322: fmul
      //   323: fadd
      //   324: fconst_0
      //   325: fcmpg
      //   326: ifge -> 338
      //   329: aload_0
      //   330: getfield x : Landroid/view/VelocityTracker;
      //   333: invokevirtual clear : ()V
      //   336: iconst_0
      //   337: ireturn
      //   338: iload #6
      //   340: iconst_1
      //   341: iadd
      //   342: istore #6
      //   344: goto -> 272
      //   347: aload_0
      //   348: fload_3
      //   349: putfield s : F
      //   352: aload_0
      //   353: fload_3
      //   354: putfield u : F
      //   357: aload_0
      //   358: fload_2
      //   359: putfield t : F
      //   362: aload_0
      //   363: fload_2
      //   364: putfield v : F
      //   367: aload_0
      //   368: invokespecial c : ()V
      //   371: iconst_0
      //   372: ireturn
      //   373: aload_0
      //   374: invokespecial b : ()V
      //   377: iconst_0
      //   378: ireturn
      //   379: aload_0
      //   380: getfield n : Z
      //   383: ifeq -> 388
      //   386: iconst_0
      //   387: ireturn
      //   388: aload_0
      //   389: getfield s : F
      //   392: fload_3
      //   393: fsub
      //   394: fstore #4
      //   396: aload_0
      //   397: getfield t : F
      //   400: fload_2
      //   401: fsub
      //   402: fstore #5
      //   404: aload_0
      //   405: getfield r : Z
      //   408: ifeq -> 424
      //   411: iconst_0
      //   412: aload_0
      //   413: getfield b : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   416: aload_1
      //   417: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   422: ior
      //   423: ireturn
      //   424: aload_0
      //   425: getfield o : Z
      //   428: ifeq -> 561
      //   431: fload_3
      //   432: aload_0
      //   433: getfield u : F
      //   436: fsub
      //   437: f2i
      //   438: istore #6
      //   440: fload_2
      //   441: aload_0
      //   442: getfield v : F
      //   445: fsub
      //   446: f2i
      //   447: istore #7
      //   449: iload #6
      //   451: iload #6
      //   453: imul
      //   454: iload #7
      //   456: iload #7
      //   458: imul
      //   459: iadd
      //   460: istore #6
      //   462: iload #6
      //   464: aload_0
      //   465: getfield f : I
      //   468: if_icmple -> 533
      //   471: aload_0
      //   472: getfield a : Landroid/view/GestureDetector$OnGestureListener;
      //   475: aload_0
      //   476: getfield e : Landroid/view/MotionEvent;
      //   479: aload_1
      //   480: fload #4
      //   482: fload #5
      //   484: invokeinterface onScroll : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   489: istore #11
      //   491: aload_0
      //   492: fload_3
      //   493: putfield s : F
      //   496: aload_0
      //   497: fload_2
      //   498: putfield t : F
      //   501: aload_0
      //   502: iconst_0
      //   503: putfield o : Z
      //   506: aload_0
      //   507: getfield m : Landroid/os/Handler;
      //   510: iconst_3
      //   511: invokevirtual removeMessages : (I)V
      //   514: aload_0
      //   515: getfield m : Landroid/os/Handler;
      //   518: iconst_1
      //   519: invokevirtual removeMessages : (I)V
      //   522: aload_0
      //   523: getfield m : Landroid/os/Handler;
      //   526: iconst_2
      //   527: invokevirtual removeMessages : (I)V
      //   530: goto -> 536
      //   533: iconst_0
      //   534: istore #11
      //   536: iload #11
      //   538: istore #12
      //   540: iload #6
      //   542: aload_0
      //   543: getfield f : I
      //   546: if_icmple -> 887
      //   549: aload_0
      //   550: iconst_0
      //   551: putfield p : Z
      //   554: iload #11
      //   556: istore #12
      //   558: goto -> 887
      //   561: fload #4
      //   563: invokestatic abs : (F)F
      //   566: fconst_1
      //   567: fcmpl
      //   568: ifge -> 585
      //   571: iload #12
      //   573: istore #11
      //   575: fload #5
      //   577: invokestatic abs : (F)F
      //   580: fconst_1
      //   581: fcmpl
      //   582: iflt -> 1157
      //   585: aload_0
      //   586: getfield a : Landroid/view/GestureDetector$OnGestureListener;
      //   589: aload_0
      //   590: getfield e : Landroid/view/MotionEvent;
      //   593: aload_1
      //   594: fload #4
      //   596: fload #5
      //   598: invokeinterface onScroll : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   603: istore #11
      //   605: aload_0
      //   606: fload_3
      //   607: putfield s : F
      //   610: aload_0
      //   611: fload_2
      //   612: putfield t : F
      //   615: iload #11
      //   617: ireturn
      //   618: aload_0
      //   619: iconst_0
      //   620: putfield c : Z
      //   623: aload_1
      //   624: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
      //   627: astore #13
      //   629: aload_0
      //   630: getfield r : Z
      //   633: ifeq -> 653
      //   636: aload_0
      //   637: getfield b : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   640: aload_1
      //   641: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   646: iconst_0
      //   647: ior
      //   648: istore #11
      //   650: goto -> 820
      //   653: aload_0
      //   654: getfield n : Z
      //   657: ifeq -> 676
      //   660: aload_0
      //   661: getfield m : Landroid/os/Handler;
      //   664: iconst_3
      //   665: invokevirtual removeMessages : (I)V
      //   668: aload_0
      //   669: iconst_0
      //   670: putfield n : Z
      //   673: goto -> 796
      //   676: aload_0
      //   677: getfield o : Z
      //   680: ifeq -> 725
      //   683: aload_0
      //   684: getfield a : Landroid/view/GestureDetector$OnGestureListener;
      //   687: aload_1
      //   688: invokeinterface onSingleTapUp : (Landroid/view/MotionEvent;)Z
      //   693: istore #11
      //   695: aload_0
      //   696: getfield d : Z
      //   699: ifeq -> 722
      //   702: aload_0
      //   703: getfield b : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   706: astore #14
      //   708: aload #14
      //   710: ifnull -> 722
      //   713: aload #14
      //   715: aload_1
      //   716: invokeinterface onSingleTapConfirmed : (Landroid/view/MotionEvent;)Z
      //   721: pop
      //   722: goto -> 820
      //   725: aload_0
      //   726: getfield x : Landroid/view/VelocityTracker;
      //   729: astore #14
      //   731: aload_1
      //   732: iconst_0
      //   733: invokevirtual getPointerId : (I)I
      //   736: istore #6
      //   738: aload #14
      //   740: sipush #1000
      //   743: aload_0
      //   744: getfield i : I
      //   747: i2f
      //   748: invokevirtual computeCurrentVelocity : (IF)V
      //   751: aload #14
      //   753: iload #6
      //   755: invokevirtual getYVelocity : (I)F
      //   758: fstore_2
      //   759: aload #14
      //   761: iload #6
      //   763: invokevirtual getXVelocity : (I)F
      //   766: fstore_3
      //   767: fload_2
      //   768: invokestatic abs : (F)F
      //   771: aload_0
      //   772: getfield h : I
      //   775: i2f
      //   776: fcmpl
      //   777: ifgt -> 802
      //   780: fload_3
      //   781: invokestatic abs : (F)F
      //   784: aload_0
      //   785: getfield h : I
      //   788: i2f
      //   789: fcmpl
      //   790: ifle -> 796
      //   793: goto -> 802
      //   796: iconst_0
      //   797: istore #11
      //   799: goto -> 820
      //   802: aload_0
      //   803: getfield a : Landroid/view/GestureDetector$OnGestureListener;
      //   806: aload_0
      //   807: getfield e : Landroid/view/MotionEvent;
      //   810: aload_1
      //   811: fload_3
      //   812: fload_2
      //   813: invokeinterface onFling : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   818: istore #11
      //   820: aload_0
      //   821: getfield q : Landroid/view/MotionEvent;
      //   824: astore_1
      //   825: aload_1
      //   826: ifnull -> 833
      //   829: aload_1
      //   830: invokevirtual recycle : ()V
      //   833: aload_0
      //   834: aload #13
      //   836: putfield q : Landroid/view/MotionEvent;
      //   839: aload_0
      //   840: getfield x : Landroid/view/VelocityTracker;
      //   843: astore_1
      //   844: aload_1
      //   845: ifnull -> 857
      //   848: aload_1
      //   849: invokevirtual recycle : ()V
      //   852: aload_0
      //   853: aconst_null
      //   854: putfield x : Landroid/view/VelocityTracker;
      //   857: aload_0
      //   858: iconst_0
      //   859: putfield r : Z
      //   862: aload_0
      //   863: iconst_0
      //   864: putfield d : Z
      //   867: aload_0
      //   868: getfield m : Landroid/os/Handler;
      //   871: iconst_1
      //   872: invokevirtual removeMessages : (I)V
      //   875: aload_0
      //   876: getfield m : Landroid/os/Handler;
      //   879: iconst_2
      //   880: invokevirtual removeMessages : (I)V
      //   883: iload #11
      //   885: istore #12
      //   887: iload #12
      //   889: ireturn
      //   890: aload_0
      //   891: getfield b : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   894: ifnull -> 1008
      //   897: aload_0
      //   898: getfield m : Landroid/os/Handler;
      //   901: iconst_3
      //   902: invokevirtual hasMessages : (I)Z
      //   905: istore #11
      //   907: iload #11
      //   909: ifeq -> 920
      //   912: aload_0
      //   913: getfield m : Landroid/os/Handler;
      //   916: iconst_3
      //   917: invokevirtual removeMessages : (I)V
      //   920: aload_0
      //   921: getfield e : Landroid/view/MotionEvent;
      //   924: astore #13
      //   926: aload #13
      //   928: ifnull -> 995
      //   931: aload_0
      //   932: getfield q : Landroid/view/MotionEvent;
      //   935: astore #14
      //   937: aload #14
      //   939: ifnull -> 995
      //   942: iload #11
      //   944: ifeq -> 995
      //   947: aload_0
      //   948: aload #13
      //   950: aload #14
      //   952: aload_1
      //   953: invokespecial a : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z
      //   956: ifeq -> 995
      //   959: aload_0
      //   960: iconst_1
      //   961: putfield r : Z
      //   964: aload_0
      //   965: getfield b : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   968: aload_0
      //   969: getfield e : Landroid/view/MotionEvent;
      //   972: invokeinterface onDoubleTap : (Landroid/view/MotionEvent;)Z
      //   977: iconst_0
      //   978: ior
      //   979: aload_0
      //   980: getfield b : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   983: aload_1
      //   984: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   989: ior
      //   990: istore #6
      //   992: goto -> 1011
      //   995: aload_0
      //   996: getfield m : Landroid/os/Handler;
      //   999: iconst_3
      //   1000: getstatic androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase.l : I
      //   1003: i2l
      //   1004: invokevirtual sendEmptyMessageDelayed : (IJ)Z
      //   1007: pop
      //   1008: iconst_0
      //   1009: istore #6
      //   1011: aload_0
      //   1012: fload_3
      //   1013: putfield s : F
      //   1016: aload_0
      //   1017: fload_3
      //   1018: putfield u : F
      //   1021: aload_0
      //   1022: fload_2
      //   1023: putfield t : F
      //   1026: aload_0
      //   1027: fload_2
      //   1028: putfield v : F
      //   1031: aload_0
      //   1032: getfield e : Landroid/view/MotionEvent;
      //   1035: astore #13
      //   1037: aload #13
      //   1039: ifnull -> 1047
      //   1042: aload #13
      //   1044: invokevirtual recycle : ()V
      //   1047: aload_0
      //   1048: aload_1
      //   1049: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
      //   1052: putfield e : Landroid/view/MotionEvent;
      //   1055: aload_0
      //   1056: iconst_1
      //   1057: putfield o : Z
      //   1060: aload_0
      //   1061: iconst_1
      //   1062: putfield p : Z
      //   1065: aload_0
      //   1066: iconst_1
      //   1067: putfield c : Z
      //   1070: aload_0
      //   1071: iconst_0
      //   1072: putfield n : Z
      //   1075: aload_0
      //   1076: iconst_0
      //   1077: putfield d : Z
      //   1080: aload_0
      //   1081: getfield w : Z
      //   1084: ifeq -> 1121
      //   1087: aload_0
      //   1088: getfield m : Landroid/os/Handler;
      //   1091: iconst_2
      //   1092: invokevirtual removeMessages : (I)V
      //   1095: aload_0
      //   1096: getfield m : Landroid/os/Handler;
      //   1099: iconst_2
      //   1100: aload_0
      //   1101: getfield e : Landroid/view/MotionEvent;
      //   1104: invokevirtual getDownTime : ()J
      //   1107: getstatic androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase.k : I
      //   1110: i2l
      //   1111: ladd
      //   1112: getstatic androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase.j : I
      //   1115: i2l
      //   1116: ladd
      //   1117: invokevirtual sendEmptyMessageAtTime : (IJ)Z
      //   1120: pop
      //   1121: aload_0
      //   1122: getfield m : Landroid/os/Handler;
      //   1125: iconst_1
      //   1126: aload_0
      //   1127: getfield e : Landroid/view/MotionEvent;
      //   1130: invokevirtual getDownTime : ()J
      //   1133: getstatic androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase.k : I
      //   1136: i2l
      //   1137: ladd
      //   1138: invokevirtual sendEmptyMessageAtTime : (IJ)Z
      //   1141: pop
      //   1142: iload #6
      //   1144: aload_0
      //   1145: getfield a : Landroid/view/GestureDetector$OnGestureListener;
      //   1148: aload_1
      //   1149: invokeinterface onDown : (Landroid/view/MotionEvent;)Z
      //   1154: ior
      //   1155: istore #11
      //   1157: iload #11
      //   1159: ireturn
    }
    
    public void setIsLongpressEnabled(boolean param1Boolean) {
      this.w = param1Boolean;
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener) {
      this.b = param1OnDoubleTapListener;
    }
    
    class GestureHandler extends Handler {
      GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase this$0) {}
      
      GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase this$0, Handler param2Handler) {
        super(param2Handler.getLooper());
      }
      
      public void handleMessage(Message param2Message) {
        int i = param2Message.what;
        if (i != 1) {
          if (i != 2) {
            if (i == 3) {
              if (this.a.b != null) {
                if (!this.a.c) {
                  this.a.b.onSingleTapConfirmed(this.a.e);
                  return;
                } 
                this.a.d = true;
                return;
              } 
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unknown message ");
              stringBuilder.append(param2Message);
              throw new RuntimeException(stringBuilder.toString());
            } 
          } else {
            this.a.a();
            return;
          } 
        } else {
          this.a.a.onShowPress(this.a.e);
        } 
      }
    }
  }
  
  class GestureHandler extends Handler {
    GestureHandler(GestureDetectorCompat this$0) {}
    
    GestureHandler(GestureDetectorCompat this$0, Handler param1Handler) {
      super(param1Handler.getLooper());
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 1) {
        if (i != 2) {
          if (i == 3) {
            if (this.a.b != null) {
              if (!this.a.c) {
                this.a.b.onSingleTapConfirmed(this.a.e);
                return;
              } 
              this.a.d = true;
              return;
            } 
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown message ");
            stringBuilder.append(param1Message);
            throw new RuntimeException(stringBuilder.toString());
          } 
        } else {
          this.a.a();
          return;
        } 
      } else {
        this.a.a.onShowPress(this.a.e);
      } 
    }
  }
  
  static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
    private final GestureDetector a;
    
    GestureDetectorCompatImplJellybeanMr2(Context param1Context, GestureDetector.OnGestureListener param1OnGestureListener, Handler param1Handler) {
      this.a = new GestureDetector(param1Context, param1OnGestureListener, param1Handler);
    }
    
    public boolean isLongpressEnabled() {
      return this.a.isLongpressEnabled();
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      return this.a.onTouchEvent(param1MotionEvent);
    }
    
    public void setIsLongpressEnabled(boolean param1Boolean) {
      this.a.setIsLongpressEnabled(param1Boolean);
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener) {
      this.a.setOnDoubleTapListener(param1OnDoubleTapListener);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\GestureDetectorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */