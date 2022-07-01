package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public abstract class ForwardingListener implements View.OnAttachStateChangeListener, View.OnTouchListener {
  private int mActivePointerId;
  
  private Runnable mDisallowIntercept;
  
  boolean mForwarding;
  
  private final int mLongPressTimeout;
  
  private final float mScaledTouchSlop;
  
  final View mSrc;
  
  private final int mTapTimeout;
  
  private final int[] mTmpLocation = new int[2];
  
  private Runnable mTriggerLongPress;
  
  public ForwardingListener(View paramView) {
    this.mSrc = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTapTimeout = ViewConfiguration.getTapTimeout();
    this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
  }
  
  final void clearCallbacks() {
    if (this.mTriggerLongPress != null)
      this.mSrc.removeCallbacks(this.mTriggerLongPress); 
    if (this.mDisallowIntercept != null)
      this.mSrc.removeCallbacks(this.mDisallowIntercept); 
  }
  
  public abstract ShowableListMenu getPopup();
  
  public boolean onForwardingStarted() {
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null && !showableListMenu.isShowing())
      showableListMenu.show(); 
    return true;
  }
  
  protected boolean onForwardingStopped() {
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null && showableListMenu.isShowing())
      showableListMenu.dismiss(); 
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mForwarding : Z
    //   4: istore #10
    //   6: iload #10
    //   8: ifeq -> 224
    //   11: aload_0
    //   12: getfield mSrc : Landroid/view/View;
    //   15: astore_1
    //   16: aload_0
    //   17: invokevirtual getPopup : ()Landroid/support/v7/view/menu/ShowableListMenu;
    //   20: astore #13
    //   22: aload #13
    //   24: ifnull -> 194
    //   27: aload #13
    //   29: invokeinterface isShowing : ()Z
    //   34: ifne -> 40
    //   37: goto -> 194
    //   40: aload #13
    //   42: invokeinterface getListView : ()Landroid/widget/ListView;
    //   47: checkcast android/support/v7/widget/DropDownListView
    //   50: astore #13
    //   52: aload #13
    //   54: ifnull -> 191
    //   57: aload #13
    //   59: invokevirtual isShown : ()Z
    //   62: ifne -> 68
    //   65: goto -> 191
    //   68: aload_2
    //   69: invokestatic obtainNoHistory : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
    //   72: astore #14
    //   74: aload_0
    //   75: getfield mTmpLocation : [I
    //   78: astore #15
    //   80: aload_1
    //   81: aload #15
    //   83: invokevirtual getLocationOnScreen : ([I)V
    //   86: aload #14
    //   88: aload #15
    //   90: iconst_0
    //   91: iaload
    //   92: i2f
    //   93: aload #15
    //   95: iconst_1
    //   96: iaload
    //   97: i2f
    //   98: invokevirtual offsetLocation : (FF)V
    //   101: aload_0
    //   102: getfield mTmpLocation : [I
    //   105: astore_1
    //   106: aload #13
    //   108: aload_1
    //   109: invokevirtual getLocationOnScreen : ([I)V
    //   112: aload #14
    //   114: aload_1
    //   115: iconst_0
    //   116: iaload
    //   117: ineg
    //   118: i2f
    //   119: aload_1
    //   120: iconst_1
    //   121: iaload
    //   122: ineg
    //   123: i2f
    //   124: invokevirtual offsetLocation : (FF)V
    //   127: aload #13
    //   129: aload #14
    //   131: aload_0
    //   132: getfield mActivePointerId : I
    //   135: invokevirtual onForwardedEvent : (Landroid/view/MotionEvent;I)Z
    //   138: istore #8
    //   140: aload #14
    //   142: invokevirtual recycle : ()V
    //   145: aload_2
    //   146: invokevirtual getActionMasked : ()I
    //   149: istore #7
    //   151: iload #7
    //   153: iconst_1
    //   154: if_icmpeq -> 169
    //   157: iload #7
    //   159: iconst_3
    //   160: if_icmpeq -> 169
    //   163: iconst_1
    //   164: istore #7
    //   166: goto -> 172
    //   169: iconst_0
    //   170: istore #7
    //   172: iload #8
    //   174: ifeq -> 188
    //   177: iload #7
    //   179: ifeq -> 188
    //   182: iconst_1
    //   183: istore #7
    //   185: goto -> 197
    //   188: goto -> 194
    //   191: goto -> 194
    //   194: iconst_0
    //   195: istore #7
    //   197: iload #7
    //   199: ifne -> 218
    //   202: aload_0
    //   203: invokevirtual onForwardingStopped : ()Z
    //   206: ifne -> 212
    //   209: goto -> 218
    //   212: iconst_0
    //   213: istore #9
    //   215: goto -> 554
    //   218: iconst_1
    //   219: istore #9
    //   221: goto -> 554
    //   224: aload_0
    //   225: getfield mSrc : Landroid/view/View;
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual isEnabled : ()Z
    //   233: ifeq -> 487
    //   236: aload_2
    //   237: invokevirtual getActionMasked : ()I
    //   240: tableswitch default -> 272, 0 -> 412, 1 -> 405, 2 -> 275, 3 -> 405
    //   272: goto -> 487
    //   275: aload_2
    //   276: aload_0
    //   277: getfield mActivePointerId : I
    //   280: invokevirtual findPointerIndex : (I)I
    //   283: istore #7
    //   285: iload #7
    //   287: iflt -> 487
    //   290: aload_2
    //   291: iload #7
    //   293: invokevirtual getX : (I)F
    //   296: fstore_3
    //   297: aload_2
    //   298: iload #7
    //   300: invokevirtual getY : (I)F
    //   303: fstore #4
    //   305: aload_0
    //   306: getfield mScaledTouchSlop : F
    //   309: fstore #5
    //   311: fload #5
    //   313: fneg
    //   314: fstore #6
    //   316: fload_3
    //   317: fload #6
    //   319: fcmpl
    //   320: iflt -> 374
    //   323: fload #4
    //   325: fload #6
    //   327: fcmpl
    //   328: iflt -> 374
    //   331: fload_3
    //   332: aload_1
    //   333: invokevirtual getRight : ()I
    //   336: aload_1
    //   337: invokevirtual getLeft : ()I
    //   340: isub
    //   341: i2f
    //   342: fload #5
    //   344: fadd
    //   345: fcmpg
    //   346: ifge -> 374
    //   349: fload #4
    //   351: aload_1
    //   352: invokevirtual getBottom : ()I
    //   355: aload_1
    //   356: invokevirtual getTop : ()I
    //   359: isub
    //   360: i2f
    //   361: fload #5
    //   363: fadd
    //   364: fcmpg
    //   365: ifge -> 374
    //   368: iconst_1
    //   369: istore #7
    //   371: goto -> 377
    //   374: iconst_0
    //   375: istore #7
    //   377: iload #7
    //   379: ifne -> 402
    //   382: aload_0
    //   383: invokevirtual clearCallbacks : ()V
    //   386: aload_1
    //   387: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   390: iconst_1
    //   391: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   396: iconst_1
    //   397: istore #7
    //   399: goto -> 490
    //   402: goto -> 487
    //   405: aload_0
    //   406: invokevirtual clearCallbacks : ()V
    //   409: goto -> 487
    //   412: aload_0
    //   413: aload_2
    //   414: iconst_0
    //   415: invokevirtual getPointerId : (I)I
    //   418: putfield mActivePointerId : I
    //   421: aload_0
    //   422: getfield mDisallowIntercept : Ljava/lang/Runnable;
    //   425: ifnonnull -> 440
    //   428: aload_0
    //   429: new android/support/v7/widget/ForwardingListener$DisallowIntercept
    //   432: dup
    //   433: aload_0
    //   434: invokespecial <init> : (Landroid/support/v7/widget/ForwardingListener;)V
    //   437: putfield mDisallowIntercept : Ljava/lang/Runnable;
    //   440: aload_1
    //   441: aload_0
    //   442: getfield mDisallowIntercept : Ljava/lang/Runnable;
    //   445: aload_0
    //   446: getfield mTapTimeout : I
    //   449: i2l
    //   450: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   453: pop
    //   454: aload_0
    //   455: getfield mTriggerLongPress : Ljava/lang/Runnable;
    //   458: ifnonnull -> 473
    //   461: aload_0
    //   462: new android/support/v7/widget/ForwardingListener$TriggerLongPress
    //   465: dup
    //   466: aload_0
    //   467: invokespecial <init> : (Landroid/support/v7/widget/ForwardingListener;)V
    //   470: putfield mTriggerLongPress : Ljava/lang/Runnable;
    //   473: aload_1
    //   474: aload_0
    //   475: getfield mTriggerLongPress : Ljava/lang/Runnable;
    //   478: aload_0
    //   479: getfield mLongPressTimeout : I
    //   482: i2l
    //   483: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   486: pop
    //   487: iconst_0
    //   488: istore #7
    //   490: iload #7
    //   492: ifeq -> 508
    //   495: aload_0
    //   496: invokevirtual onForwardingStarted : ()Z
    //   499: ifeq -> 508
    //   502: iconst_1
    //   503: istore #8
    //   505: goto -> 511
    //   508: iconst_0
    //   509: istore #8
    //   511: iload #8
    //   513: istore #9
    //   515: iload #8
    //   517: ifeq -> 554
    //   520: invokestatic uptimeMillis : ()J
    //   523: lstore #11
    //   525: lload #11
    //   527: lload #11
    //   529: iconst_3
    //   530: fconst_0
    //   531: fconst_0
    //   532: iconst_0
    //   533: invokestatic obtain : (JJIFFI)Landroid/view/MotionEvent;
    //   536: astore_1
    //   537: aload_0
    //   538: getfield mSrc : Landroid/view/View;
    //   541: aload_1
    //   542: invokevirtual onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   545: pop
    //   546: aload_1
    //   547: invokevirtual recycle : ()V
    //   550: iload #8
    //   552: istore #9
    //   554: aload_0
    //   555: iload #9
    //   557: putfield mForwarding : Z
    //   560: iload #9
    //   562: ifne -> 574
    //   565: iload #10
    //   567: ifeq -> 572
    //   570: iconst_1
    //   571: ireturn
    //   572: iconst_0
    //   573: ireturn
    //   574: iconst_1
    //   575: ireturn
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView) {
    this.mForwarding = false;
    this.mActivePointerId = -1;
    if (this.mDisallowIntercept != null)
      this.mSrc.removeCallbacks(this.mDisallowIntercept); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ForwardingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */