package android.support.v7.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

final class TooltipCompatHandler implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
  private static TooltipCompatHandler sActiveHandler;
  
  private final View mAnchor;
  
  private int mAnchorX;
  
  private int mAnchorY;
  
  private boolean mFromTouch;
  
  private final Runnable mHideRunnable = new TooltipCompatHandler$2(this);
  
  private TooltipPopup mPopup;
  
  private final Runnable mShowRunnable = new TooltipCompatHandler$1(this);
  
  private final CharSequence mTooltipText;
  
  private TooltipCompatHandler(View paramView, CharSequence paramCharSequence) {
    this.mAnchor = paramView;
    this.mTooltipText = paramCharSequence;
    this.mAnchor.setOnLongClickListener(this);
    this.mAnchor.setOnHoverListener(this);
  }
  
  private void hide() {
    if (sActiveHandler == this) {
      sActiveHandler = null;
      if (this.mPopup != null) {
        this.mPopup.hide();
        this.mPopup = null;
        this.mAnchor.removeOnAttachStateChangeListener(this);
      } else {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      } 
    } 
    this.mAnchor.removeCallbacks(this.mShowRunnable);
    this.mAnchor.removeCallbacks(this.mHideRunnable);
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence) {
    if (TextUtils.isEmpty(paramCharSequence)) {
      if (sActiveHandler != null && sActiveHandler.mAnchor == paramView)
        sActiveHandler.hide(); 
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    } 
    new TooltipCompatHandler(paramView, paramCharSequence);
  }
  
  private void show(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAnchor : Landroid/view/View;
    //   4: invokestatic isAttachedToWindow : (Landroid/view/View;)Z
    //   7: ifne -> 11
    //   10: return
    //   11: getstatic android/support/v7/widget/TooltipCompatHandler.sActiveHandler : Landroid/support/v7/widget/TooltipCompatHandler;
    //   14: ifnull -> 23
    //   17: getstatic android/support/v7/widget/TooltipCompatHandler.sActiveHandler : Landroid/support/v7/widget/TooltipCompatHandler;
    //   20: invokespecial hide : ()V
    //   23: aload_0
    //   24: putstatic android/support/v7/widget/TooltipCompatHandler.sActiveHandler : Landroid/support/v7/widget/TooltipCompatHandler;
    //   27: aload_0
    //   28: iload_1
    //   29: putfield mFromTouch : Z
    //   32: aload_0
    //   33: new android/support/v7/widget/TooltipPopup
    //   36: dup
    //   37: aload_0
    //   38: getfield mAnchor : Landroid/view/View;
    //   41: invokevirtual getContext : ()Landroid/content/Context;
    //   44: invokespecial <init> : (Landroid/content/Context;)V
    //   47: putfield mPopup : Landroid/support/v7/widget/TooltipPopup;
    //   50: aload_0
    //   51: getfield mPopup : Landroid/support/v7/widget/TooltipPopup;
    //   54: astore #10
    //   56: aload_0
    //   57: getfield mAnchor : Landroid/view/View;
    //   60: astore #12
    //   62: aload_0
    //   63: getfield mAnchorX : I
    //   66: istore_2
    //   67: aload_0
    //   68: getfield mAnchorY : I
    //   71: istore #4
    //   73: aload_0
    //   74: getfield mFromTouch : Z
    //   77: istore_1
    //   78: aload_0
    //   79: getfield mTooltipText : Ljava/lang/CharSequence;
    //   82: astore #9
    //   84: aload #10
    //   86: invokevirtual isShowing : ()Z
    //   89: ifeq -> 97
    //   92: aload #10
    //   94: invokevirtual hide : ()V
    //   97: aload #10
    //   99: getfield mMessageView : Landroid/widget/TextView;
    //   102: aload #9
    //   104: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   107: aload #10
    //   109: getfield mLayoutParams : Landroid/view/WindowManager$LayoutParams;
    //   112: astore #11
    //   114: aload #10
    //   116: getfield mContext : Landroid/content/Context;
    //   119: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   122: getstatic android/support/v7/appcompat/R$dimen.tooltip_precise_anchor_threshold : I
    //   125: invokevirtual getDimensionPixelOffset : (I)I
    //   128: istore_3
    //   129: aload #12
    //   131: invokevirtual getWidth : ()I
    //   134: iload_3
    //   135: if_icmplt -> 141
    //   138: goto -> 149
    //   141: aload #12
    //   143: invokevirtual getWidth : ()I
    //   146: iconst_2
    //   147: idiv
    //   148: istore_2
    //   149: aload #12
    //   151: invokevirtual getHeight : ()I
    //   154: iload_3
    //   155: if_icmplt -> 190
    //   158: aload #10
    //   160: getfield mContext : Landroid/content/Context;
    //   163: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   166: getstatic android/support/v7/appcompat/R$dimen.tooltip_precise_anchor_extra_offset : I
    //   169: invokevirtual getDimensionPixelOffset : (I)I
    //   172: istore #5
    //   174: iload #4
    //   176: iload #5
    //   178: iadd
    //   179: istore_3
    //   180: iload #4
    //   182: iload #5
    //   184: isub
    //   185: istore #4
    //   187: goto -> 199
    //   190: aload #12
    //   192: invokevirtual getHeight : ()I
    //   195: istore_3
    //   196: iconst_0
    //   197: istore #4
    //   199: aload #11
    //   201: bipush #49
    //   203: putfield gravity : I
    //   206: aload #10
    //   208: getfield mContext : Landroid/content/Context;
    //   211: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   214: astore #9
    //   216: iload_1
    //   217: ifeq -> 228
    //   220: getstatic android/support/v7/appcompat/R$dimen.tooltip_y_offset_touch : I
    //   223: istore #5
    //   225: goto -> 233
    //   228: getstatic android/support/v7/appcompat/R$dimen.tooltip_y_offset_non_touch : I
    //   231: istore #5
    //   233: aload #9
    //   235: iload #5
    //   237: invokevirtual getDimensionPixelOffset : (I)I
    //   240: istore #6
    //   242: aload #12
    //   244: invokevirtual getContext : ()Landroid/content/Context;
    //   247: astore #9
    //   249: aload #9
    //   251: instanceof android/content/ContextWrapper
    //   254: ifeq -> 294
    //   257: aload #9
    //   259: instanceof android/app/Activity
    //   262: ifeq -> 281
    //   265: aload #9
    //   267: checkcast android/app/Activity
    //   270: invokevirtual getWindow : ()Landroid/view/Window;
    //   273: invokevirtual getDecorView : ()Landroid/view/View;
    //   276: astore #9
    //   278: goto -> 301
    //   281: aload #9
    //   283: checkcast android/content/ContextWrapper
    //   286: invokevirtual getBaseContext : ()Landroid/content/Context;
    //   289: astore #9
    //   291: goto -> 249
    //   294: aload #12
    //   296: invokevirtual getRootView : ()Landroid/view/View;
    //   299: astore #9
    //   301: aload #9
    //   303: ifnonnull -> 317
    //   306: ldc 'TooltipPopup'
    //   308: ldc 'Cannot find app view'
    //   310: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   313: pop
    //   314: goto -> 614
    //   317: aload #9
    //   319: aload #10
    //   321: getfield mTmpDisplayFrame : Landroid/graphics/Rect;
    //   324: invokevirtual getWindowVisibleDisplayFrame : (Landroid/graphics/Rect;)V
    //   327: aload #10
    //   329: getfield mTmpDisplayFrame : Landroid/graphics/Rect;
    //   332: getfield left : I
    //   335: ifge -> 420
    //   338: aload #10
    //   340: getfield mTmpDisplayFrame : Landroid/graphics/Rect;
    //   343: getfield top : I
    //   346: ifge -> 420
    //   349: aload #10
    //   351: getfield mContext : Landroid/content/Context;
    //   354: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   357: astore #13
    //   359: aload #13
    //   361: ldc 'status_bar_height'
    //   363: ldc 'dimen'
    //   365: ldc 'android'
    //   367: invokestatic getIdentifier : (Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   370: istore #5
    //   372: iload #5
    //   374: ifeq -> 389
    //   377: aload #13
    //   379: iload #5
    //   381: invokevirtual getDimensionPixelSize : (I)I
    //   384: istore #5
    //   386: goto -> 392
    //   389: iconst_0
    //   390: istore #5
    //   392: aload #13
    //   394: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   397: astore #13
    //   399: aload #10
    //   401: getfield mTmpDisplayFrame : Landroid/graphics/Rect;
    //   404: iconst_0
    //   405: iload #5
    //   407: aload #13
    //   409: getfield widthPixels : I
    //   412: aload #13
    //   414: getfield heightPixels : I
    //   417: invokevirtual set : (IIII)V
    //   420: aload #9
    //   422: aload #10
    //   424: getfield mTmpAppPos : [I
    //   427: invokevirtual getLocationOnScreen : ([I)V
    //   430: aload #12
    //   432: aload #10
    //   434: getfield mTmpAnchorPos : [I
    //   437: invokevirtual getLocationOnScreen : ([I)V
    //   440: aload #10
    //   442: getfield mTmpAnchorPos : [I
    //   445: astore #9
    //   447: aload #9
    //   449: iconst_0
    //   450: aload #9
    //   452: iconst_0
    //   453: iaload
    //   454: aload #10
    //   456: getfield mTmpAppPos : [I
    //   459: iconst_0
    //   460: iaload
    //   461: isub
    //   462: iastore
    //   463: aload #10
    //   465: getfield mTmpAnchorPos : [I
    //   468: astore #9
    //   470: aload #9
    //   472: iconst_1
    //   473: aload #9
    //   475: iconst_1
    //   476: iaload
    //   477: aload #10
    //   479: getfield mTmpAppPos : [I
    //   482: iconst_1
    //   483: iaload
    //   484: isub
    //   485: iastore
    //   486: aload #11
    //   488: aload #10
    //   490: getfield mTmpAnchorPos : [I
    //   493: iconst_0
    //   494: iaload
    //   495: iload_2
    //   496: iadd
    //   497: aload #10
    //   499: getfield mTmpDisplayFrame : Landroid/graphics/Rect;
    //   502: invokevirtual width : ()I
    //   505: iconst_2
    //   506: idiv
    //   507: isub
    //   508: putfield x : I
    //   511: iconst_0
    //   512: iconst_0
    //   513: invokestatic makeMeasureSpec : (II)I
    //   516: istore_2
    //   517: aload #10
    //   519: getfield mContentView : Landroid/view/View;
    //   522: iload_2
    //   523: iload_2
    //   524: invokevirtual measure : (II)V
    //   527: aload #10
    //   529: getfield mContentView : Landroid/view/View;
    //   532: invokevirtual getMeasuredHeight : ()I
    //   535: istore_2
    //   536: aload #10
    //   538: getfield mTmpAnchorPos : [I
    //   541: iconst_1
    //   542: iaload
    //   543: iload #4
    //   545: iadd
    //   546: iload #6
    //   548: isub
    //   549: iload_2
    //   550: isub
    //   551: istore #4
    //   553: aload #10
    //   555: getfield mTmpAnchorPos : [I
    //   558: iconst_1
    //   559: iaload
    //   560: iload_3
    //   561: iadd
    //   562: iload #6
    //   564: iadd
    //   565: istore_3
    //   566: iload_1
    //   567: ifeq -> 584
    //   570: iload #4
    //   572: ifge -> 607
    //   575: aload #11
    //   577: iload_3
    //   578: putfield y : I
    //   581: goto -> 614
    //   584: iload_2
    //   585: iload_3
    //   586: iadd
    //   587: aload #10
    //   589: getfield mTmpDisplayFrame : Landroid/graphics/Rect;
    //   592: invokevirtual height : ()I
    //   595: if_icmpgt -> 607
    //   598: aload #11
    //   600: iload_3
    //   601: putfield y : I
    //   604: goto -> 614
    //   607: aload #11
    //   609: iload #4
    //   611: putfield y : I
    //   614: aload #10
    //   616: getfield mContext : Landroid/content/Context;
    //   619: ldc_w 'window'
    //   622: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   625: checkcast android/view/WindowManager
    //   628: aload #10
    //   630: getfield mContentView : Landroid/view/View;
    //   633: aload #10
    //   635: getfield mLayoutParams : Landroid/view/WindowManager$LayoutParams;
    //   638: invokeinterface addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   643: aload_0
    //   644: getfield mAnchor : Landroid/view/View;
    //   647: aload_0
    //   648: invokevirtual addOnAttachStateChangeListener : (Landroid/view/View$OnAttachStateChangeListener;)V
    //   651: aload_0
    //   652: getfield mFromTouch : Z
    //   655: ifeq -> 666
    //   658: ldc2_w 2500
    //   661: lstore #7
    //   663: goto -> 702
    //   666: aload_0
    //   667: getfield mAnchor : Landroid/view/View;
    //   670: invokestatic getWindowSystemUiVisibility : (Landroid/view/View;)I
    //   673: iconst_1
    //   674: iand
    //   675: iconst_1
    //   676: if_icmpne -> 692
    //   679: ldc2_w 3000
    //   682: invokestatic getLongPressTimeout : ()I
    //   685: i2l
    //   686: lsub
    //   687: lstore #7
    //   689: goto -> 702
    //   692: ldc2_w 15000
    //   695: invokestatic getLongPressTimeout : ()I
    //   698: i2l
    //   699: lsub
    //   700: lstore #7
    //   702: aload_0
    //   703: getfield mAnchor : Landroid/view/View;
    //   706: aload_0
    //   707: getfield mHideRunnable : Ljava/lang/Runnable;
    //   710: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)Z
    //   713: pop
    //   714: aload_0
    //   715: getfield mAnchor : Landroid/view/View;
    //   718: aload_0
    //   719: getfield mHideRunnable : Ljava/lang/Runnable;
    //   722: lload #7
    //   724: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   727: pop
    //   728: return
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent) {
    if (this.mPopup != null && this.mFromTouch)
      return false; 
    AccessibilityManager accessibilityManager = (AccessibilityManager)this.mAnchor.getContext().getSystemService("accessibility");
    if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled())
      return false; 
    int i = paramMotionEvent.getAction();
    if (i != 7) {
      if (i != 10)
        return false; 
      hide();
      return false;
    } 
    if (this.mAnchor.isEnabled() && this.mPopup == null) {
      this.mAnchorX = (int)paramMotionEvent.getX();
      this.mAnchorY = (int)paramMotionEvent.getY();
      this.mAnchor.removeCallbacks(this.mShowRunnable);
      this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
    } 
    return false;
  }
  
  public final boolean onLongClick(View paramView) {
    this.mAnchorX = paramView.getWidth() / 2;
    this.mAnchorY = paramView.getHeight() / 2;
    show(true);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView) {
    hide();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\TooltipCompatHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */