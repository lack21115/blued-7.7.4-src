package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.MotionEvent;

class DropDownListView extends ListViewCompat {
  private ViewPropertyAnimatorCompat mClickAnimation;
  
  private boolean mDrawsInPressedState;
  
  private boolean mHijackFocus;
  
  boolean mListSelectionHidden;
  
  private ListViewAutoScrollHelper mScrollHelper;
  
  public DropDownListView(Context paramContext, boolean paramBoolean) {
    super(paramContext, (AttributeSet)null, R.attr.dropDownListViewStyle);
    this.mHijackFocus = paramBoolean;
    setCacheColorHint(0);
  }
  
  public boolean hasFocus() {
    return (this.mHijackFocus || super.hasFocus());
  }
  
  public boolean hasWindowFocus() {
    return (this.mHijackFocus || super.hasWindowFocus());
  }
  
  public boolean isFocused() {
    return (this.mHijackFocus || super.isFocused());
  }
  
  public boolean isInTouchMode() {
    return ((this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode());
  }
  
  public boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #7
    //   6: iconst_0
    //   7: istore #11
    //   9: iload #7
    //   11: tableswitch default -> 36, 1 -> 59, 2 -> 53, 3 -> 44
    //   36: iconst_0
    //   37: istore_2
    //   38: iconst_1
    //   39: istore #10
    //   41: goto -> 576
    //   44: iconst_0
    //   45: istore_2
    //   46: iload #11
    //   48: istore #10
    //   50: goto -> 576
    //   53: iconst_1
    //   54: istore #10
    //   56: goto -> 62
    //   59: iconst_0
    //   60: istore #10
    //   62: aload_1
    //   63: iload_2
    //   64: invokevirtual findPointerIndex : (I)I
    //   67: istore #8
    //   69: iload #8
    //   71: ifge -> 77
    //   74: goto -> 44
    //   77: aload_1
    //   78: iload #8
    //   80: invokevirtual getX : (I)F
    //   83: f2i
    //   84: istore_2
    //   85: aload_1
    //   86: iload #8
    //   88: invokevirtual getY : (I)F
    //   91: f2i
    //   92: istore #9
    //   94: aload_0
    //   95: iload_2
    //   96: iload #9
    //   98: invokevirtual pointToPosition : (II)I
    //   101: istore #8
    //   103: iload #8
    //   105: iconst_m1
    //   106: if_icmpne -> 114
    //   109: iconst_1
    //   110: istore_2
    //   111: goto -> 576
    //   114: aload_0
    //   115: iload #8
    //   117: aload_0
    //   118: invokevirtual getFirstVisiblePosition : ()I
    //   121: isub
    //   122: invokevirtual getChildAt : (I)Landroid/view/View;
    //   125: astore #12
    //   127: iload_2
    //   128: i2f
    //   129: fstore_3
    //   130: iload #9
    //   132: i2f
    //   133: fstore #4
    //   135: aload_0
    //   136: iconst_1
    //   137: putfield mDrawsInPressedState : Z
    //   140: getstatic android/os/Build$VERSION.SDK_INT : I
    //   143: bipush #21
    //   145: if_icmplt -> 155
    //   148: aload_0
    //   149: fload_3
    //   150: fload #4
    //   152: invokevirtual drawableHotspotChanged : (FF)V
    //   155: aload_0
    //   156: invokevirtual isPressed : ()Z
    //   159: ifne -> 167
    //   162: aload_0
    //   163: iconst_1
    //   164: invokevirtual setPressed : (Z)V
    //   167: aload_0
    //   168: invokevirtual layoutChildren : ()V
    //   171: aload_0
    //   172: getfield mMotionPosition : I
    //   175: iconst_m1
    //   176: if_icmpeq -> 220
    //   179: aload_0
    //   180: aload_0
    //   181: getfield mMotionPosition : I
    //   184: aload_0
    //   185: invokevirtual getFirstVisiblePosition : ()I
    //   188: isub
    //   189: invokevirtual getChildAt : (I)Landroid/view/View;
    //   192: astore #13
    //   194: aload #13
    //   196: ifnull -> 220
    //   199: aload #13
    //   201: aload #12
    //   203: if_acmpeq -> 220
    //   206: aload #13
    //   208: invokevirtual isPressed : ()Z
    //   211: ifeq -> 220
    //   214: aload #13
    //   216: iconst_0
    //   217: invokevirtual setPressed : (Z)V
    //   220: aload_0
    //   221: iload #8
    //   223: putfield mMotionPosition : I
    //   226: aload #12
    //   228: invokevirtual getLeft : ()I
    //   231: i2f
    //   232: fstore #5
    //   234: aload #12
    //   236: invokevirtual getTop : ()I
    //   239: i2f
    //   240: fstore #6
    //   242: getstatic android/os/Build$VERSION.SDK_INT : I
    //   245: bipush #21
    //   247: if_icmplt -> 264
    //   250: aload #12
    //   252: fload_3
    //   253: fload #5
    //   255: fsub
    //   256: fload #4
    //   258: fload #6
    //   260: fsub
    //   261: invokevirtual drawableHotspotChanged : (FF)V
    //   264: aload #12
    //   266: invokevirtual isPressed : ()Z
    //   269: ifne -> 278
    //   272: aload #12
    //   274: iconst_1
    //   275: invokevirtual setPressed : (Z)V
    //   278: aload_0
    //   279: invokevirtual getSelector : ()Landroid/graphics/drawable/Drawable;
    //   282: astore #13
    //   284: aload #13
    //   286: ifnull -> 300
    //   289: iload #8
    //   291: iconst_m1
    //   292: if_icmpeq -> 300
    //   295: iconst_1
    //   296: istore_2
    //   297: goto -> 302
    //   300: iconst_0
    //   301: istore_2
    //   302: iload_2
    //   303: ifeq -> 314
    //   306: aload #13
    //   308: iconst_0
    //   309: iconst_0
    //   310: invokevirtual setVisible : (ZZ)Z
    //   313: pop
    //   314: aload_0
    //   315: getfield mSelectorRect : Landroid/graphics/Rect;
    //   318: astore #14
    //   320: aload #14
    //   322: aload #12
    //   324: invokevirtual getLeft : ()I
    //   327: aload #12
    //   329: invokevirtual getTop : ()I
    //   332: aload #12
    //   334: invokevirtual getRight : ()I
    //   337: aload #12
    //   339: invokevirtual getBottom : ()I
    //   342: invokevirtual set : (IIII)V
    //   345: aload #14
    //   347: aload #14
    //   349: getfield left : I
    //   352: aload_0
    //   353: getfield mSelectionLeftPadding : I
    //   356: isub
    //   357: putfield left : I
    //   360: aload #14
    //   362: aload #14
    //   364: getfield top : I
    //   367: aload_0
    //   368: getfield mSelectionTopPadding : I
    //   371: isub
    //   372: putfield top : I
    //   375: aload #14
    //   377: aload #14
    //   379: getfield right : I
    //   382: aload_0
    //   383: getfield mSelectionRightPadding : I
    //   386: iadd
    //   387: putfield right : I
    //   390: aload #14
    //   392: aload #14
    //   394: getfield bottom : I
    //   397: aload_0
    //   398: getfield mSelectionBottomPadding : I
    //   401: iadd
    //   402: putfield bottom : I
    //   405: aload_0
    //   406: getfield mIsChildViewEnabled : Ljava/lang/reflect/Field;
    //   409: aload_0
    //   410: invokevirtual getBoolean : (Ljava/lang/Object;)Z
    //   413: istore #10
    //   415: aload #12
    //   417: invokevirtual isEnabled : ()Z
    //   420: iload #10
    //   422: if_icmpeq -> 450
    //   425: aload_0
    //   426: getfield mIsChildViewEnabled : Ljava/lang/reflect/Field;
    //   429: aload_0
    //   430: iload #10
    //   432: iconst_1
    //   433: ixor
    //   434: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   437: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   440: iload #8
    //   442: iconst_m1
    //   443: if_icmpeq -> 450
    //   446: aload_0
    //   447: invokevirtual refreshDrawableState : ()V
    //   450: goto -> 460
    //   453: astore #14
    //   455: aload #14
    //   457: invokestatic printStackTrace : (Ljava/lang/Throwable;)V
    //   460: iload_2
    //   461: ifeq -> 518
    //   464: aload_0
    //   465: getfield mSelectorRect : Landroid/graphics/Rect;
    //   468: astore #14
    //   470: aload #14
    //   472: invokevirtual exactCenterX : ()F
    //   475: fstore #5
    //   477: aload #14
    //   479: invokevirtual exactCenterY : ()F
    //   482: fstore #6
    //   484: aload_0
    //   485: invokevirtual getVisibility : ()I
    //   488: ifne -> 497
    //   491: iconst_1
    //   492: istore #10
    //   494: goto -> 500
    //   497: iconst_0
    //   498: istore #10
    //   500: aload #13
    //   502: iload #10
    //   504: iconst_0
    //   505: invokevirtual setVisible : (ZZ)Z
    //   508: pop
    //   509: aload #13
    //   511: fload #5
    //   513: fload #6
    //   515: invokestatic setHotspot : (Landroid/graphics/drawable/Drawable;FF)V
    //   518: aload_0
    //   519: invokevirtual getSelector : ()Landroid/graphics/drawable/Drawable;
    //   522: astore #13
    //   524: aload #13
    //   526: ifnull -> 543
    //   529: iload #8
    //   531: iconst_m1
    //   532: if_icmpeq -> 543
    //   535: aload #13
    //   537: fload_3
    //   538: fload #4
    //   540: invokestatic setHotspot : (Landroid/graphics/drawable/Drawable;FF)V
    //   543: aload_0
    //   544: iconst_0
    //   545: invokevirtual setSelectorEnabled : (Z)V
    //   548: aload_0
    //   549: invokevirtual refreshDrawableState : ()V
    //   552: iload #7
    //   554: iconst_1
    //   555: if_icmpne -> 36
    //   558: aload_0
    //   559: aload #12
    //   561: iload #8
    //   563: aload_0
    //   564: iload #8
    //   566: invokevirtual getItemIdAtPosition : (I)J
    //   569: invokevirtual performItemClick : (Landroid/view/View;IJ)Z
    //   572: pop
    //   573: goto -> 36
    //   576: iload #10
    //   578: ifeq -> 585
    //   581: iload_2
    //   582: ifeq -> 644
    //   585: aload_0
    //   586: iconst_0
    //   587: putfield mDrawsInPressedState : Z
    //   590: aload_0
    //   591: iconst_0
    //   592: invokevirtual setPressed : (Z)V
    //   595: aload_0
    //   596: invokevirtual drawableStateChanged : ()V
    //   599: aload_0
    //   600: aload_0
    //   601: getfield mMotionPosition : I
    //   604: aload_0
    //   605: invokevirtual getFirstVisiblePosition : ()I
    //   608: isub
    //   609: invokevirtual getChildAt : (I)Landroid/view/View;
    //   612: astore #12
    //   614: aload #12
    //   616: ifnull -> 625
    //   619: aload #12
    //   621: iconst_0
    //   622: invokevirtual setPressed : (Z)V
    //   625: aload_0
    //   626: getfield mClickAnimation : Landroid/support/v4/view/ViewPropertyAnimatorCompat;
    //   629: ifnull -> 644
    //   632: aload_0
    //   633: getfield mClickAnimation : Landroid/support/v4/view/ViewPropertyAnimatorCompat;
    //   636: invokevirtual cancel : ()V
    //   639: aload_0
    //   640: aconst_null
    //   641: putfield mClickAnimation : Landroid/support/v4/view/ViewPropertyAnimatorCompat;
    //   644: iload #10
    //   646: ifeq -> 690
    //   649: aload_0
    //   650: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   653: ifnonnull -> 668
    //   656: aload_0
    //   657: new android/support/v4/widget/ListViewAutoScrollHelper
    //   660: dup
    //   661: aload_0
    //   662: invokespecial <init> : (Landroid/widget/ListView;)V
    //   665: putfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   668: aload_0
    //   669: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   672: iconst_1
    //   673: invokevirtual setEnabled : (Z)Landroid/support/v4/widget/AutoScrollHelper;
    //   676: pop
    //   677: aload_0
    //   678: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   681: aload_0
    //   682: aload_1
    //   683: invokevirtual onTouch : (Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   686: pop
    //   687: iload #10
    //   689: ireturn
    //   690: aload_0
    //   691: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   694: ifnull -> 706
    //   697: aload_0
    //   698: getfield mScrollHelper : Landroid/support/v4/widget/ListViewAutoScrollHelper;
    //   701: iconst_0
    //   702: invokevirtual setEnabled : (Z)Landroid/support/v4/widget/AutoScrollHelper;
    //   705: pop
    //   706: iload #10
    //   708: ireturn
    // Exception table:
    //   from	to	target	type
    //   405	440	453	java/lang/IllegalAccessException
    //   446	450	453	java/lang/IllegalAccessException
  }
  
  protected final boolean touchModeDrawsInPressedStateCompat() {
    return (this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\DropDownListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */