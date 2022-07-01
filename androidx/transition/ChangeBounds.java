package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds extends Transition {
  private static final String[] a = new String[] { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  
  private static final Property<Drawable, PointF> i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
      private Rect a = new Rect();
      
      public PointF get(Drawable param1Drawable) {
        param1Drawable.copyBounds(this.a);
        return new PointF(this.a.left, this.a.top);
      }
      
      public void set(Drawable param1Drawable, PointF param1PointF) {
        param1Drawable.copyBounds(this.a);
        this.a.offsetTo(Math.round(param1PointF.x), Math.round(param1PointF.y));
        param1Drawable.setBounds(this.a);
      }
    };
  
  private static final Property<ViewBounds, PointF> j = new Property<ViewBounds, PointF>(PointF.class, "topLeft") {
      public PointF get(ChangeBounds.ViewBounds param1ViewBounds) {
        return null;
      }
      
      public void set(ChangeBounds.ViewBounds param1ViewBounds, PointF param1PointF) {
        param1ViewBounds.a(param1PointF);
      }
    };
  
  private static final Property<ViewBounds, PointF> k = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") {
      public PointF get(ChangeBounds.ViewBounds param1ViewBounds) {
        return null;
      }
      
      public void set(ChangeBounds.ViewBounds param1ViewBounds, PointF param1PointF) {
        param1ViewBounds.b(param1PointF);
      }
    };
  
  private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "bottomRight") {
      public PointF get(View param1View) {
        return null;
      }
      
      public void set(View param1View, PointF param1PointF) {
        ViewUtils.a(param1View, param1View.getLeft(), param1View.getTop(), Math.round(param1PointF.x), Math.round(param1PointF.y));
      }
    };
  
  private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "topLeft") {
      public PointF get(View param1View) {
        return null;
      }
      
      public void set(View param1View, PointF param1PointF) {
        ViewUtils.a(param1View, Math.round(param1PointF.x), Math.round(param1PointF.y), param1View.getRight(), param1View.getBottom());
      }
    };
  
  private static final Property<View, PointF> n = new Property<View, PointF>(PointF.class, "position") {
      public PointF get(View param1View) {
        return null;
      }
      
      public void set(View param1View, PointF param1PointF) {
        int i = Math.round(param1PointF.x);
        int j = Math.round(param1PointF.y);
        ViewUtils.a(param1View, i, j, param1View.getWidth() + i, param1View.getHeight() + j);
      }
    };
  
  private static RectEvaluator r = new RectEvaluator();
  
  private int[] o = new int[2];
  
  private boolean p = false;
  
  private boolean q = false;
  
  public ChangeBounds() {}
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.d);
    boolean bool = TypedArrayUtils.getNamedBoolean(typedArray, (XmlPullParser)paramAttributeSet, "resizeClip", 0, false);
    typedArray.recycle();
    setResizeClip(bool);
  }
  
  private boolean a(View paramView1, View paramView2) {
    if (this.q) {
      TransitionValues transitionValues = a(paramView1, true);
      return (transitionValues == null) ? ((paramView1 == paramView2)) : ((paramView2 == transitionValues.view));
    } 
    return true;
  }
  
  private void b(TransitionValues paramTransitionValues) {
    View view = paramTransitionValues.view;
    if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
      paramTransitionValues.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
      paramTransitionValues.values.put("android:changeBounds:parent", paramTransitionValues.view.getParent());
      if (this.q) {
        paramTransitionValues.view.getLocationInWindow(this.o);
        paramTransitionValues.values.put("android:changeBounds:windowX", Integer.valueOf(this.o[0]));
        paramTransitionValues.values.put("android:changeBounds:windowY", Integer.valueOf(this.o[1]));
      } 
      if (this.p)
        paramTransitionValues.values.put("android:changeBounds:clip", ViewCompat.getClipBounds(view)); 
    } 
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    // Byte code:
    //   0: aload_2
    //   1: ifnull -> 1103
    //   4: aload_3
    //   5: ifnonnull -> 11
    //   8: goto -> 1103
    //   11: aload_2
    //   12: getfield values : Ljava/util/Map;
    //   15: astore #20
    //   17: aload_3
    //   18: getfield values : Ljava/util/Map;
    //   21: astore #19
    //   23: aload #20
    //   25: ldc 'android:changeBounds:parent'
    //   27: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast android/view/ViewGroup
    //   35: astore #20
    //   37: aload #19
    //   39: ldc 'android:changeBounds:parent'
    //   41: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast android/view/ViewGroup
    //   49: astore #21
    //   51: aload #20
    //   53: ifnull -> 1101
    //   56: aload #21
    //   58: ifnonnull -> 64
    //   61: goto -> 1101
    //   64: aload_3
    //   65: getfield view : Landroid/view/View;
    //   68: astore #19
    //   70: aload_0
    //   71: aload #20
    //   73: aload #21
    //   75: invokespecial a : (Landroid/view/View;Landroid/view/View;)Z
    //   78: ifeq -> 849
    //   81: aload_2
    //   82: getfield values : Ljava/util/Map;
    //   85: ldc 'android:changeBounds:bounds'
    //   87: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast android/graphics/Rect
    //   95: astore_1
    //   96: aload_3
    //   97: getfield values : Ljava/util/Map;
    //   100: ldc 'android:changeBounds:bounds'
    //   102: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast android/graphics/Rect
    //   110: astore #20
    //   112: aload_1
    //   113: getfield left : I
    //   116: istore #7
    //   118: aload #20
    //   120: getfield left : I
    //   123: istore #8
    //   125: aload_1
    //   126: getfield top : I
    //   129: istore #9
    //   131: aload #20
    //   133: getfield top : I
    //   136: istore #10
    //   138: aload_1
    //   139: getfield right : I
    //   142: istore #11
    //   144: aload #20
    //   146: getfield right : I
    //   149: istore #12
    //   151: aload_1
    //   152: getfield bottom : I
    //   155: istore #13
    //   157: aload #20
    //   159: getfield bottom : I
    //   162: istore #14
    //   164: iload #11
    //   166: iload #7
    //   168: isub
    //   169: istore #15
    //   171: iload #13
    //   173: iload #9
    //   175: isub
    //   176: istore #16
    //   178: iload #12
    //   180: iload #8
    //   182: isub
    //   183: istore #17
    //   185: iload #14
    //   187: iload #10
    //   189: isub
    //   190: istore #18
    //   192: aload_2
    //   193: getfield values : Ljava/util/Map;
    //   196: ldc 'android:changeBounds:clip'
    //   198: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast android/graphics/Rect
    //   206: astore_2
    //   207: aload_3
    //   208: getfield values : Ljava/util/Map;
    //   211: ldc 'android:changeBounds:clip'
    //   213: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   218: checkcast android/graphics/Rect
    //   221: astore #20
    //   223: iload #15
    //   225: ifeq -> 233
    //   228: iload #16
    //   230: ifne -> 243
    //   233: iload #17
    //   235: ifeq -> 296
    //   238: iload #18
    //   240: ifeq -> 296
    //   243: iload #7
    //   245: iload #8
    //   247: if_icmpne -> 266
    //   250: iload #9
    //   252: iload #10
    //   254: if_icmpeq -> 260
    //   257: goto -> 266
    //   260: iconst_0
    //   261: istore #6
    //   263: goto -> 269
    //   266: iconst_1
    //   267: istore #6
    //   269: iload #11
    //   271: iload #12
    //   273: if_icmpne -> 287
    //   276: iload #6
    //   278: istore #5
    //   280: iload #13
    //   282: iload #14
    //   284: if_icmpeq -> 299
    //   287: iload #6
    //   289: iconst_1
    //   290: iadd
    //   291: istore #5
    //   293: goto -> 299
    //   296: iconst_0
    //   297: istore #5
    //   299: aload_2
    //   300: ifnull -> 312
    //   303: aload_2
    //   304: aload #20
    //   306: invokevirtual equals : (Ljava/lang/Object;)Z
    //   309: ifeq -> 329
    //   312: iload #5
    //   314: istore #6
    //   316: aload_2
    //   317: ifnonnull -> 335
    //   320: iload #5
    //   322: istore #6
    //   324: aload #20
    //   326: ifnull -> 335
    //   329: iload #5
    //   331: iconst_1
    //   332: iadd
    //   333: istore #6
    //   335: iload #6
    //   337: ifle -> 942
    //   340: aload_0
    //   341: getfield p : Z
    //   344: ifne -> 604
    //   347: aload #19
    //   349: astore_1
    //   350: aload_1
    //   351: iload #7
    //   353: iload #9
    //   355: iload #11
    //   357: iload #13
    //   359: invokestatic a : (Landroid/view/View;IIII)V
    //   362: iload #6
    //   364: iconst_2
    //   365: if_icmpne -> 523
    //   368: iload #15
    //   370: iload #17
    //   372: if_icmpne -> 414
    //   375: iload #16
    //   377: iload #18
    //   379: if_icmpne -> 414
    //   382: aload_0
    //   383: invokevirtual getPathMotion : ()Landroidx/transition/PathMotion;
    //   386: iload #7
    //   388: i2f
    //   389: iload #9
    //   391: i2f
    //   392: iload #8
    //   394: i2f
    //   395: iload #10
    //   397: i2f
    //   398: invokevirtual getPath : (FFFF)Landroid/graphics/Path;
    //   401: astore_2
    //   402: aload_1
    //   403: getstatic androidx/transition/ChangeBounds.n : Landroid/util/Property;
    //   406: aload_2
    //   407: invokestatic a : (Ljava/lang/Object;Landroid/util/Property;Landroid/graphics/Path;)Landroid/animation/ObjectAnimator;
    //   410: astore_1
    //   411: goto -> 808
    //   414: new androidx/transition/ChangeBounds$ViewBounds
    //   417: dup
    //   418: aload_1
    //   419: invokespecial <init> : (Landroid/view/View;)V
    //   422: astore_2
    //   423: aload_0
    //   424: invokevirtual getPathMotion : ()Landroidx/transition/PathMotion;
    //   427: iload #7
    //   429: i2f
    //   430: iload #9
    //   432: i2f
    //   433: iload #8
    //   435: i2f
    //   436: iload #10
    //   438: i2f
    //   439: invokevirtual getPath : (FFFF)Landroid/graphics/Path;
    //   442: astore_1
    //   443: aload_2
    //   444: getstatic androidx/transition/ChangeBounds.j : Landroid/util/Property;
    //   447: aload_1
    //   448: invokestatic a : (Ljava/lang/Object;Landroid/util/Property;Landroid/graphics/Path;)Landroid/animation/ObjectAnimator;
    //   451: astore_3
    //   452: aload_0
    //   453: invokevirtual getPathMotion : ()Landroidx/transition/PathMotion;
    //   456: iload #11
    //   458: i2f
    //   459: iload #13
    //   461: i2f
    //   462: iload #12
    //   464: i2f
    //   465: iload #14
    //   467: i2f
    //   468: invokevirtual getPath : (FFFF)Landroid/graphics/Path;
    //   471: astore_1
    //   472: aload_2
    //   473: getstatic androidx/transition/ChangeBounds.k : Landroid/util/Property;
    //   476: aload_1
    //   477: invokestatic a : (Ljava/lang/Object;Landroid/util/Property;Landroid/graphics/Path;)Landroid/animation/ObjectAnimator;
    //   480: astore #20
    //   482: new android/animation/AnimatorSet
    //   485: dup
    //   486: invokespecial <init> : ()V
    //   489: astore_1
    //   490: aload_1
    //   491: iconst_2
    //   492: anewarray android/animation/Animator
    //   495: dup
    //   496: iconst_0
    //   497: aload_3
    //   498: aastore
    //   499: dup
    //   500: iconst_1
    //   501: aload #20
    //   503: aastore
    //   504: invokevirtual playTogether : ([Landroid/animation/Animator;)V
    //   507: aload_1
    //   508: new androidx/transition/ChangeBounds$7
    //   511: dup
    //   512: aload_0
    //   513: aload_2
    //   514: invokespecial <init> : (Landroidx/transition/ChangeBounds;Landroidx/transition/ChangeBounds$ViewBounds;)V
    //   517: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   520: goto -> 808
    //   523: iload #7
    //   525: iload #8
    //   527: if_icmpne -> 572
    //   530: iload #9
    //   532: iload #10
    //   534: if_icmpeq -> 540
    //   537: goto -> 572
    //   540: aload_0
    //   541: invokevirtual getPathMotion : ()Landroidx/transition/PathMotion;
    //   544: iload #11
    //   546: i2f
    //   547: iload #13
    //   549: i2f
    //   550: iload #12
    //   552: i2f
    //   553: iload #14
    //   555: i2f
    //   556: invokevirtual getPath : (FFFF)Landroid/graphics/Path;
    //   559: astore_2
    //   560: aload_1
    //   561: getstatic androidx/transition/ChangeBounds.l : Landroid/util/Property;
    //   564: aload_2
    //   565: invokestatic a : (Ljava/lang/Object;Landroid/util/Property;Landroid/graphics/Path;)Landroid/animation/ObjectAnimator;
    //   568: astore_1
    //   569: goto -> 808
    //   572: aload_0
    //   573: invokevirtual getPathMotion : ()Landroidx/transition/PathMotion;
    //   576: iload #7
    //   578: i2f
    //   579: iload #9
    //   581: i2f
    //   582: iload #8
    //   584: i2f
    //   585: iload #10
    //   587: i2f
    //   588: invokevirtual getPath : (FFFF)Landroid/graphics/Path;
    //   591: astore_2
    //   592: aload_1
    //   593: getstatic androidx/transition/ChangeBounds.m : Landroid/util/Property;
    //   596: aload_2
    //   597: invokestatic a : (Ljava/lang/Object;Landroid/util/Property;Landroid/graphics/Path;)Landroid/animation/ObjectAnimator;
    //   600: astore_1
    //   601: goto -> 808
    //   604: aload #19
    //   606: astore #21
    //   608: aload #21
    //   610: iload #7
    //   612: iload #9
    //   614: iload #15
    //   616: iload #17
    //   618: invokestatic max : (II)I
    //   621: iload #7
    //   623: iadd
    //   624: iload #16
    //   626: iload #18
    //   628: invokestatic max : (II)I
    //   631: iload #9
    //   633: iadd
    //   634: invokestatic a : (Landroid/view/View;IIII)V
    //   637: iload #7
    //   639: iload #8
    //   641: if_icmpne -> 659
    //   644: iload #9
    //   646: iload #10
    //   648: if_icmpeq -> 654
    //   651: goto -> 659
    //   654: aconst_null
    //   655: astore_1
    //   656: goto -> 689
    //   659: aload_0
    //   660: invokevirtual getPathMotion : ()Landroidx/transition/PathMotion;
    //   663: iload #7
    //   665: i2f
    //   666: iload #9
    //   668: i2f
    //   669: iload #8
    //   671: i2f
    //   672: iload #10
    //   674: i2f
    //   675: invokevirtual getPath : (FFFF)Landroid/graphics/Path;
    //   678: astore_1
    //   679: aload #21
    //   681: getstatic androidx/transition/ChangeBounds.n : Landroid/util/Property;
    //   684: aload_1
    //   685: invokestatic a : (Ljava/lang/Object;Landroid/util/Property;Landroid/graphics/Path;)Landroid/animation/ObjectAnimator;
    //   688: astore_1
    //   689: aload_2
    //   690: ifnonnull -> 710
    //   693: new android/graphics/Rect
    //   696: dup
    //   697: iconst_0
    //   698: iconst_0
    //   699: iload #15
    //   701: iload #16
    //   703: invokespecial <init> : (IIII)V
    //   706: astore_2
    //   707: goto -> 710
    //   710: aload #20
    //   712: ifnonnull -> 732
    //   715: new android/graphics/Rect
    //   718: dup
    //   719: iconst_0
    //   720: iconst_0
    //   721: iload #17
    //   723: iload #18
    //   725: invokespecial <init> : (IIII)V
    //   728: astore_3
    //   729: goto -> 735
    //   732: aload #20
    //   734: astore_3
    //   735: aload_2
    //   736: aload_3
    //   737: invokevirtual equals : (Ljava/lang/Object;)Z
    //   740: ifne -> 800
    //   743: aload #21
    //   745: aload_2
    //   746: invokestatic setClipBounds : (Landroid/view/View;Landroid/graphics/Rect;)V
    //   749: aload #21
    //   751: ldc_w 'clipBounds'
    //   754: getstatic androidx/transition/ChangeBounds.r : Landroidx/transition/RectEvaluator;
    //   757: iconst_2
    //   758: anewarray java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: aload_2
    //   764: aastore
    //   765: dup
    //   766: iconst_1
    //   767: aload_3
    //   768: aastore
    //   769: invokestatic ofObject : (Ljava/lang/Object;Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/ObjectAnimator;
    //   772: astore_2
    //   773: aload_2
    //   774: new androidx/transition/ChangeBounds$8
    //   777: dup
    //   778: aload_0
    //   779: aload #21
    //   781: aload #20
    //   783: iload #8
    //   785: iload #10
    //   787: iload #12
    //   789: iload #14
    //   791: invokespecial <init> : (Landroidx/transition/ChangeBounds;Landroid/view/View;Landroid/graphics/Rect;IIII)V
    //   794: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   797: goto -> 802
    //   800: aconst_null
    //   801: astore_2
    //   802: aload_1
    //   803: aload_2
    //   804: invokestatic a : (Landroid/animation/Animator;Landroid/animation/Animator;)Landroid/animation/Animator;
    //   807: astore_1
    //   808: aload #19
    //   810: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   813: instanceof android/view/ViewGroup
    //   816: ifeq -> 847
    //   819: aload #19
    //   821: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   824: checkcast android/view/ViewGroup
    //   827: astore_2
    //   828: aload_2
    //   829: iconst_1
    //   830: invokestatic a : (Landroid/view/ViewGroup;Z)V
    //   833: aload_0
    //   834: new androidx/transition/ChangeBounds$9
    //   837: dup
    //   838: aload_0
    //   839: aload_2
    //   840: invokespecial <init> : (Landroidx/transition/ChangeBounds;Landroid/view/ViewGroup;)V
    //   843: invokevirtual addListener : (Landroidx/transition/Transition$TransitionListener;)Landroidx/transition/Transition;
    //   846: pop
    //   847: aload_1
    //   848: areturn
    //   849: aload_2
    //   850: getfield values : Ljava/util/Map;
    //   853: ldc 'android:changeBounds:windowX'
    //   855: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   860: checkcast java/lang/Integer
    //   863: invokevirtual intValue : ()I
    //   866: istore #5
    //   868: aload_2
    //   869: getfield values : Ljava/util/Map;
    //   872: ldc 'android:changeBounds:windowY'
    //   874: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   879: checkcast java/lang/Integer
    //   882: invokevirtual intValue : ()I
    //   885: istore #6
    //   887: aload_3
    //   888: getfield values : Ljava/util/Map;
    //   891: ldc 'android:changeBounds:windowX'
    //   893: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   898: checkcast java/lang/Integer
    //   901: invokevirtual intValue : ()I
    //   904: istore #7
    //   906: aload_3
    //   907: getfield values : Ljava/util/Map;
    //   910: ldc 'android:changeBounds:windowY'
    //   912: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   917: checkcast java/lang/Integer
    //   920: invokevirtual intValue : ()I
    //   923: istore #8
    //   925: iload #5
    //   927: iload #7
    //   929: if_icmpne -> 944
    //   932: iload #6
    //   934: iload #8
    //   936: if_icmpeq -> 942
    //   939: goto -> 944
    //   942: aconst_null
    //   943: areturn
    //   944: aload_1
    //   945: aload_0
    //   946: getfield o : [I
    //   949: invokevirtual getLocationInWindow : ([I)V
    //   952: aload #19
    //   954: invokevirtual getWidth : ()I
    //   957: aload #19
    //   959: invokevirtual getHeight : ()I
    //   962: getstatic android/graphics/Bitmap$Config.ARGB_8888 : Landroid/graphics/Bitmap$Config;
    //   965: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   968: astore_2
    //   969: aload #19
    //   971: new android/graphics/Canvas
    //   974: dup
    //   975: aload_2
    //   976: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   979: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   982: new android/graphics/drawable/BitmapDrawable
    //   985: dup
    //   986: aload_2
    //   987: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   990: astore_2
    //   991: aload #19
    //   993: invokestatic c : (Landroid/view/View;)F
    //   996: fstore #4
    //   998: aload #19
    //   1000: fconst_0
    //   1001: invokestatic a : (Landroid/view/View;F)V
    //   1004: aload_1
    //   1005: invokestatic a : (Landroid/view/View;)Landroidx/transition/ViewOverlayImpl;
    //   1008: aload_2
    //   1009: invokeinterface add : (Landroid/graphics/drawable/Drawable;)V
    //   1014: aload_0
    //   1015: invokevirtual getPathMotion : ()Landroidx/transition/PathMotion;
    //   1018: astore_3
    //   1019: aload_0
    //   1020: getfield o : [I
    //   1023: astore #20
    //   1025: aload_3
    //   1026: iload #5
    //   1028: aload #20
    //   1030: iconst_0
    //   1031: iaload
    //   1032: isub
    //   1033: i2f
    //   1034: iload #6
    //   1036: aload #20
    //   1038: iconst_1
    //   1039: iaload
    //   1040: isub
    //   1041: i2f
    //   1042: iload #7
    //   1044: aload #20
    //   1046: iconst_0
    //   1047: iaload
    //   1048: isub
    //   1049: i2f
    //   1050: iload #8
    //   1052: aload #20
    //   1054: iconst_1
    //   1055: iaload
    //   1056: isub
    //   1057: i2f
    //   1058: invokevirtual getPath : (FFFF)Landroid/graphics/Path;
    //   1061: astore_3
    //   1062: aload_2
    //   1063: iconst_1
    //   1064: anewarray android/animation/PropertyValuesHolder
    //   1067: dup
    //   1068: iconst_0
    //   1069: getstatic androidx/transition/ChangeBounds.i : Landroid/util/Property;
    //   1072: aload_3
    //   1073: invokestatic a : (Landroid/util/Property;Landroid/graphics/Path;)Landroid/animation/PropertyValuesHolder;
    //   1076: aastore
    //   1077: invokestatic ofPropertyValuesHolder : (Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;
    //   1080: astore_3
    //   1081: aload_3
    //   1082: new androidx/transition/ChangeBounds$10
    //   1085: dup
    //   1086: aload_0
    //   1087: aload_1
    //   1088: aload_2
    //   1089: aload #19
    //   1091: fload #4
    //   1093: invokespecial <init> : (Landroidx/transition/ChangeBounds;Landroid/view/ViewGroup;Landroid/graphics/drawable/BitmapDrawable;Landroid/view/View;F)V
    //   1096: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   1099: aload_3
    //   1100: areturn
    //   1101: aconst_null
    //   1102: areturn
    //   1103: aconst_null
    //   1104: areturn
  }
  
  public boolean getResizeClip() {
    return this.p;
  }
  
  public String[] getTransitionProperties() {
    return a;
  }
  
  public void setResizeClip(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  static class ViewBounds {
    private int a;
    
    private int b;
    
    private int c;
    
    private int d;
    
    private View e;
    
    private int f;
    
    private int g;
    
    ViewBounds(View param1View) {
      this.e = param1View;
    }
    
    private void a() {
      ViewUtils.a(this.e, this.a, this.b, this.c, this.d);
      this.f = 0;
      this.g = 0;
    }
    
    void a(PointF param1PointF) {
      this.a = Math.round(param1PointF.x);
      this.b = Math.round(param1PointF.y);
      this.f++;
      if (this.f == this.g)
        a(); 
    }
    
    void b(PointF param1PointF) {
      this.c = Math.round(param1PointF.x);
      this.d = Math.round(param1PointF.y);
      this.g++;
      if (this.f == this.g)
        a(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ChangeBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */