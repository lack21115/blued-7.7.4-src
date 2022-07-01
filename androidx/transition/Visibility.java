package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility extends Transition {
  public static final int MODE_IN = 1;
  
  public static final int MODE_OUT = 2;
  
  private static final String[] a = new String[] { "android:visibility:visibility", "android:visibility:parent" };
  
  private int i = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.e);
    int i = TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    typedArray.recycle();
    if (i != 0)
      setMode(i); 
  }
  
  private VisibilityInfo a(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    VisibilityInfo visibilityInfo = new VisibilityInfo();
    visibilityInfo.a = false;
    visibilityInfo.b = false;
    if (paramTransitionValues1 != null && paramTransitionValues1.values.containsKey("android:visibility:visibility")) {
      visibilityInfo.c = ((Integer)paramTransitionValues1.values.get("android:visibility:visibility")).intValue();
      visibilityInfo.e = (ViewGroup)paramTransitionValues1.values.get("android:visibility:parent");
    } else {
      visibilityInfo.c = -1;
      visibilityInfo.e = null;
    } 
    if (paramTransitionValues2 != null && paramTransitionValues2.values.containsKey("android:visibility:visibility")) {
      visibilityInfo.d = ((Integer)paramTransitionValues2.values.get("android:visibility:visibility")).intValue();
      visibilityInfo.f = (ViewGroup)paramTransitionValues2.values.get("android:visibility:parent");
    } else {
      visibilityInfo.d = -1;
      visibilityInfo.f = null;
    } 
    if (paramTransitionValues1 != null && paramTransitionValues2 != null) {
      if (visibilityInfo.c == visibilityInfo.d && visibilityInfo.e == visibilityInfo.f)
        return visibilityInfo; 
      if (visibilityInfo.c != visibilityInfo.d) {
        if (visibilityInfo.c == 0) {
          visibilityInfo.b = false;
          visibilityInfo.a = true;
          return visibilityInfo;
        } 
        if (visibilityInfo.d == 0) {
          visibilityInfo.b = true;
          visibilityInfo.a = true;
          return visibilityInfo;
        } 
      } else {
        if (visibilityInfo.f == null) {
          visibilityInfo.b = false;
          visibilityInfo.a = true;
          return visibilityInfo;
        } 
        if (visibilityInfo.e == null) {
          visibilityInfo.b = true;
          visibilityInfo.a = true;
          return visibilityInfo;
        } 
      } 
    } else {
      if (paramTransitionValues1 == null && visibilityInfo.d == 0) {
        visibilityInfo.b = true;
        visibilityInfo.a = true;
        return visibilityInfo;
      } 
      if (paramTransitionValues2 == null && visibilityInfo.c == 0) {
        visibilityInfo.b = false;
        visibilityInfo.a = true;
      } 
    } 
    return visibilityInfo;
  }
  
  private void b(TransitionValues paramTransitionValues) {
    int i = paramTransitionValues.view.getVisibility();
    paramTransitionValues.values.put("android:visibility:visibility", Integer.valueOf(i));
    paramTransitionValues.values.put("android:visibility:parent", paramTransitionValues.view.getParent());
    int[] arrayOfInt = new int[2];
    paramTransitionValues.view.getLocationOnScreen(arrayOfInt);
    paramTransitionValues.values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    VisibilityInfo visibilityInfo = a(paramTransitionValues1, paramTransitionValues2);
    return (visibilityInfo.a && (visibilityInfo.e != null || visibilityInfo.f != null)) ? (visibilityInfo.b ? onAppear(paramViewGroup, paramTransitionValues1, visibilityInfo.c, paramTransitionValues2, visibilityInfo.d) : onDisappear(paramViewGroup, paramTransitionValues1, visibilityInfo.c, paramTransitionValues2, visibilityInfo.d)) : null;
  }
  
  public int getMode() {
    return this.i;
  }
  
  public String[] getTransitionProperties() {
    return a;
  }
  
  public boolean isTransitionRequired(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    boolean bool = false;
    if (paramTransitionValues1 == null && paramTransitionValues2 == null)
      return false; 
    if (paramTransitionValues1 != null && paramTransitionValues2 != null && paramTransitionValues2.values.containsKey("android:visibility:visibility") != paramTransitionValues1.values.containsKey("android:visibility:visibility"))
      return false; 
    VisibilityInfo visibilityInfo = a(paramTransitionValues1, paramTransitionValues2);
    null = bool;
    if (visibilityInfo.a) {
      if (visibilityInfo.c != 0) {
        null = bool;
        return (visibilityInfo.d == 0) ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public boolean isVisible(TransitionValues paramTransitionValues) {
    boolean bool2 = false;
    if (paramTransitionValues == null)
      return false; 
    int i = ((Integer)paramTransitionValues.values.get("android:visibility:visibility")).intValue();
    View view = (View)paramTransitionValues.values.get("android:visibility:parent");
    boolean bool1 = bool2;
    if (i == 0) {
      bool1 = bool2;
      if (view != null)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    return null;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2) {
    if ((this.i & 0x1) == 1) {
      if (paramTransitionValues2 == null)
        return null; 
      if (paramTransitionValues1 == null) {
        View view = (View)paramTransitionValues2.view.getParent();
        if ((a(a(view, false), getTransitionValues(view, false))).a)
          return null; 
      } 
      return onAppear(paramViewGroup, paramTransitionValues2.view, paramTransitionValues1, paramTransitionValues2);
    } 
    return null;
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    return null;
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : I
    //   4: iconst_2
    //   5: iand
    //   6: iconst_2
    //   7: if_icmpeq -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_2
    //   13: ifnonnull -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_2
    //   19: getfield view : Landroid/view/View;
    //   22: astore #10
    //   24: aload #4
    //   26: ifnull -> 39
    //   29: aload #4
    //   31: getfield view : Landroid/view/View;
    //   34: astore #7
    //   36: goto -> 42
    //   39: aconst_null
    //   40: astore #7
    //   42: aload #10
    //   44: getstatic androidx/transition/R$id.save_overlay_view : I
    //   47: invokevirtual getTag : (I)Ljava/lang/Object;
    //   50: checkcast android/view/View
    //   53: astore #8
    //   55: aload #8
    //   57: ifnull -> 76
    //   60: aconst_null
    //   61: astore #9
    //   63: iconst_1
    //   64: istore_3
    //   65: aload #8
    //   67: astore #7
    //   69: aload #9
    //   71: astore #8
    //   73: goto -> 281
    //   76: aload #7
    //   78: ifnull -> 118
    //   81: aload #7
    //   83: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   86: ifnonnull -> 92
    //   89: goto -> 118
    //   92: iload #5
    //   94: iconst_4
    //   95: if_icmpne -> 101
    //   98: goto -> 108
    //   101: aload #10
    //   103: aload #7
    //   105: if_acmpne -> 135
    //   108: aconst_null
    //   109: astore #9
    //   111: aload #7
    //   113: astore #8
    //   115: goto -> 130
    //   118: aload #7
    //   120: ifnull -> 135
    //   123: aconst_null
    //   124: astore #8
    //   126: aload #7
    //   128: astore #9
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -> 144
    //   135: aconst_null
    //   136: astore #9
    //   138: aload #9
    //   140: astore #8
    //   142: iconst_1
    //   143: istore_3
    //   144: aload #9
    //   146: astore #7
    //   148: iload_3
    //   149: ifeq -> 279
    //   152: aload #10
    //   154: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   157: ifnonnull -> 163
    //   160: goto -> 275
    //   163: aload #9
    //   165: astore #7
    //   167: aload #10
    //   169: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   172: instanceof android/view/View
    //   175: ifeq -> 279
    //   178: aload #10
    //   180: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   183: checkcast android/view/View
    //   186: astore #11
    //   188: aload_0
    //   189: aload_0
    //   190: aload #11
    //   192: iconst_1
    //   193: invokevirtual getTransitionValues : (Landroid/view/View;Z)Landroidx/transition/TransitionValues;
    //   196: aload_0
    //   197: aload #11
    //   199: iconst_1
    //   200: invokevirtual a : (Landroid/view/View;Z)Landroidx/transition/TransitionValues;
    //   203: invokespecial a : (Landroidx/transition/TransitionValues;Landroidx/transition/TransitionValues;)Landroidx/transition/Visibility$VisibilityInfo;
    //   206: getfield a : Z
    //   209: ifne -> 225
    //   212: aload_1
    //   213: aload #10
    //   215: aload #11
    //   217: invokestatic a : (Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/View;)Landroid/view/View;
    //   220: astore #7
    //   222: goto -> 279
    //   225: aload #11
    //   227: invokevirtual getId : ()I
    //   230: istore_3
    //   231: aload #9
    //   233: astore #7
    //   235: aload #11
    //   237: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   240: ifnonnull -> 279
    //   243: aload #9
    //   245: astore #7
    //   247: iload_3
    //   248: iconst_m1
    //   249: if_icmpeq -> 279
    //   252: aload #9
    //   254: astore #7
    //   256: aload_1
    //   257: iload_3
    //   258: invokevirtual findViewById : (I)Landroid/view/View;
    //   261: ifnull -> 279
    //   264: aload #9
    //   266: astore #7
    //   268: aload_0
    //   269: getfield f : Z
    //   272: ifeq -> 279
    //   275: aload #10
    //   277: astore #7
    //   279: iconst_0
    //   280: istore_3
    //   281: aload #7
    //   283: ifnull -> 441
    //   286: iload_3
    //   287: ifne -> 379
    //   290: aload_2
    //   291: getfield values : Ljava/util/Map;
    //   294: ldc 'android:visibility:screenLocation'
    //   296: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   301: checkcast [I
    //   304: checkcast [I
    //   307: astore #8
    //   309: aload #8
    //   311: iconst_0
    //   312: iaload
    //   313: istore #5
    //   315: aload #8
    //   317: iconst_1
    //   318: iaload
    //   319: istore #6
    //   321: iconst_2
    //   322: newarray int
    //   324: astore #8
    //   326: aload_1
    //   327: aload #8
    //   329: invokevirtual getLocationOnScreen : ([I)V
    //   332: aload #7
    //   334: iload #5
    //   336: aload #8
    //   338: iconst_0
    //   339: iaload
    //   340: isub
    //   341: aload #7
    //   343: invokevirtual getLeft : ()I
    //   346: isub
    //   347: invokevirtual offsetLeftAndRight : (I)V
    //   350: aload #7
    //   352: iload #6
    //   354: aload #8
    //   356: iconst_1
    //   357: iaload
    //   358: isub
    //   359: aload #7
    //   361: invokevirtual getTop : ()I
    //   364: isub
    //   365: invokevirtual offsetTopAndBottom : (I)V
    //   368: aload_1
    //   369: invokestatic a : (Landroid/view/ViewGroup;)Landroidx/transition/ViewGroupOverlayImpl;
    //   372: aload #7
    //   374: invokeinterface add : (Landroid/view/View;)V
    //   379: aload_0
    //   380: aload_1
    //   381: aload #7
    //   383: aload_2
    //   384: aload #4
    //   386: invokevirtual onDisappear : (Landroid/view/ViewGroup;Landroid/view/View;Landroidx/transition/TransitionValues;Landroidx/transition/TransitionValues;)Landroid/animation/Animator;
    //   389: astore_2
    //   390: iload_3
    //   391: ifne -> 439
    //   394: aload_2
    //   395: ifnonnull -> 411
    //   398: aload_1
    //   399: invokestatic a : (Landroid/view/ViewGroup;)Landroidx/transition/ViewGroupOverlayImpl;
    //   402: aload #7
    //   404: invokeinterface remove : (Landroid/view/View;)V
    //   409: aload_2
    //   410: areturn
    //   411: aload #10
    //   413: getstatic androidx/transition/R$id.save_overlay_view : I
    //   416: aload #7
    //   418: invokevirtual setTag : (ILjava/lang/Object;)V
    //   421: aload_0
    //   422: new androidx/transition/Visibility$1
    //   425: dup
    //   426: aload_0
    //   427: aload_1
    //   428: aload #7
    //   430: aload #10
    //   432: invokespecial <init> : (Landroidx/transition/Visibility;Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/View;)V
    //   435: invokevirtual addListener : (Landroidx/transition/Transition$TransitionListener;)Landroidx/transition/Transition;
    //   438: pop
    //   439: aload_2
    //   440: areturn
    //   441: aload #8
    //   443: ifnull -> 512
    //   446: aload #8
    //   448: invokevirtual getVisibility : ()I
    //   451: istore_3
    //   452: aload #8
    //   454: iconst_0
    //   455: invokestatic a : (Landroid/view/View;I)V
    //   458: aload_0
    //   459: aload_1
    //   460: aload #8
    //   462: aload_2
    //   463: aload #4
    //   465: invokevirtual onDisappear : (Landroid/view/ViewGroup;Landroid/view/View;Landroidx/transition/TransitionValues;Landroidx/transition/TransitionValues;)Landroid/animation/Animator;
    //   468: astore_1
    //   469: aload_1
    //   470: ifnull -> 504
    //   473: new androidx/transition/Visibility$DisappearListener
    //   476: dup
    //   477: aload #8
    //   479: iload #5
    //   481: iconst_1
    //   482: invokespecial <init> : (Landroid/view/View;IZ)V
    //   485: astore_2
    //   486: aload_1
    //   487: aload_2
    //   488: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   491: aload_1
    //   492: aload_2
    //   493: invokestatic a : (Landroid/animation/Animator;Landroid/animation/AnimatorListenerAdapter;)V
    //   496: aload_0
    //   497: aload_2
    //   498: invokevirtual addListener : (Landroidx/transition/Transition$TransitionListener;)Landroidx/transition/Transition;
    //   501: pop
    //   502: aload_1
    //   503: areturn
    //   504: aload #8
    //   506: iload_3
    //   507: invokestatic a : (Landroid/view/View;I)V
    //   510: aload_1
    //   511: areturn
    //   512: aconst_null
    //   513: areturn
  }
  
  public void setMode(int paramInt) {
    if ((paramInt & 0xFFFFFFFC) == 0) {
      this.i = paramInt;
      return;
    } 
    throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
  }
  
  static class DisappearListener extends AnimatorListenerAdapter implements AnimatorUtils.AnimatorPauseListenerCompat, Transition.TransitionListener {
    boolean a = false;
    
    private final View b;
    
    private final int c;
    
    private final ViewGroup d;
    
    private final boolean e;
    
    private boolean f;
    
    DisappearListener(View param1View, int param1Int, boolean param1Boolean) {
      this.b = param1View;
      this.c = param1Int;
      this.d = (ViewGroup)param1View.getParent();
      this.e = param1Boolean;
      a(true);
    }
    
    private void a() {
      if (!this.a) {
        ViewUtils.a(this.b, this.c);
        ViewGroup viewGroup = this.d;
        if (viewGroup != null)
          viewGroup.invalidate(); 
      } 
      a(false);
    }
    
    private void a(boolean param1Boolean) {
      if (this.e && this.f != param1Boolean) {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
          this.f = param1Boolean;
          ViewGroupUtils.a(viewGroup, param1Boolean);
        } 
      } 
    }
    
    public void onAnimationCancel(Animator param1Animator) {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator param1Animator) {
      a();
    }
    
    public void onAnimationPause(Animator param1Animator) {
      if (!this.a)
        ViewUtils.a(this.b, this.c); 
    }
    
    public void onAnimationRepeat(Animator param1Animator) {}
    
    public void onAnimationResume(Animator param1Animator) {
      if (!this.a)
        ViewUtils.a(this.b, 0); 
    }
    
    public void onAnimationStart(Animator param1Animator) {}
    
    public void onTransitionCancel(Transition param1Transition) {}
    
    public void onTransitionEnd(Transition param1Transition) {
      a();
      param1Transition.removeListener(this);
    }
    
    public void onTransitionPause(Transition param1Transition) {
      a(false);
    }
    
    public void onTransitionResume(Transition param1Transition) {
      a(true);
    }
    
    public void onTransitionStart(Transition param1Transition) {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Mode {}
  
  static class VisibilityInfo {
    boolean a;
    
    boolean b;
    
    int c;
    
    int d;
    
    ViewGroup e;
    
    ViewGroup f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\Visibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */