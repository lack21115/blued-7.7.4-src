package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
  private boolean mFormatItems;
  
  private int mFormatItemsWidth;
  
  private int mGeneratedItemPadding;
  
  MenuBuilder mMenu;
  
  private int mMinCellSize;
  
  ActionMenuPresenter mPresenter;
  
  public ActionMenuView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.mBaselineAligned = false;
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    this.mMinCellSize = (int)(56.0F * f);
    this.mGeneratedItemPadding = (int)(f * 4.0F);
  }
  
  private static ActionMenuView$LayoutParams generateDefaultLayoutParams() {
    ActionMenuView$LayoutParams actionMenuView$LayoutParams = new ActionMenuView$LayoutParams(-2, -2);
    actionMenuView$LayoutParams.gravity = 16;
    return actionMenuView$LayoutParams;
  }
  
  private ActionMenuView$LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new ActionMenuView$LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected static ActionMenuView$LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams != null) {
      ActionMenuView$LayoutParams actionMenuView$LayoutParams;
      if (paramLayoutParams instanceof ActionMenuView$LayoutParams) {
        actionMenuView$LayoutParams = new ActionMenuView$LayoutParams((ActionMenuView$LayoutParams)paramLayoutParams);
      } else {
        actionMenuView$LayoutParams = new ActionMenuView$LayoutParams((ViewGroup.LayoutParams)actionMenuView$LayoutParams);
      } 
      if (actionMenuView$LayoutParams.gravity <= 0)
        actionMenuView$LayoutParams.gravity = 16; 
      return actionMenuView$LayoutParams;
    } 
    return generateDefaultLayoutParams();
  }
  
  public static ActionMenuView$LayoutParams generateOverflowButtonLayoutParams() {
    ActionMenuView$LayoutParams actionMenuView$LayoutParams = generateDefaultLayoutParams();
    actionMenuView$LayoutParams.isOverflowButton = true;
    return actionMenuView$LayoutParams;
  }
  
  private boolean hasSupportDividerBeforeChildAt(int paramInt) {
    boolean bool;
    int j = 0;
    if (paramInt == 0)
      return false; 
    View view1 = getChildAt(paramInt - 1);
    View view2 = getChildAt(paramInt);
    int i = j;
    if (paramInt < getChildCount()) {
      i = j;
      if (view1 instanceof ActionMenuView$ActionMenuChildView)
        i = false | ((ActionMenuView$ActionMenuChildView)view1).needsDividerAfter(); 
    } 
    j = i;
    if (paramInt > 0) {
      j = i;
      if (view2 instanceof ActionMenuView$ActionMenuChildView)
        bool = i | ((ActionMenuView$ActionMenuChildView)view2).needsDividerBefore(); 
    } 
    return bool;
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    ActionMenuItemView actionMenuItemView;
    ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    if (paramView instanceof ActionMenuItemView) {
      actionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      actionMenuItemView = null;
    } 
    boolean bool = true;
    if (actionMenuItemView != null && actionMenuItemView.hasText()) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    } 
    paramInt4 = 2;
    if (paramInt2 > 0 && (paramInt3 == 0 || paramInt2 >= 2)) {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, -2147483648), i);
      int k = paramView.getMeasuredWidth();
      int j = k / paramInt1;
      paramInt2 = j;
      if (k % paramInt1 != 0)
        paramInt2 = j + 1; 
      if (paramInt3 != 0 && paramInt2 < 2)
        paramInt2 = paramInt4; 
    } else {
      paramInt2 = 0;
    } 
    if (actionMenuView$LayoutParams.isOverflowButton || paramInt3 == 0)
      bool = false; 
    actionMenuView$LayoutParams.expandable = bool;
    actionMenuView$LayoutParams.cellsUsed = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), i);
    return paramInt2;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams != null && paramLayoutParams instanceof ActionMenuView$LayoutParams);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    return false;
  }
  
  public final boolean invokeItem(MenuItemImpl paramMenuItemImpl) {
    return this.mMenu.performItemAction((MenuItem)paramMenuItemImpl, null, 0);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPresenter != null) {
      this.mPresenter.updateMenuView(false);
      if (this.mPresenter.isOverflowMenuShowing()) {
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
      } 
    } 
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.mPresenter != null)
      this.mPresenter.dismissPopupMenus(); 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.mFormatItems) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    int k = getChildCount();
    int j = (paramInt4 - paramInt2) / 2;
    int m = this.mDividerWidth;
    int n = paramInt3 - paramInt1;
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingLeft();
    paramBoolean = ViewUtils.isLayoutRtl((View)this);
    paramInt4 = n - paramInt1 - paramInt2;
    paramInt3 = 0;
    int i = 0;
    paramInt2 = 0;
    while (paramInt3 < k) {
      View view = getChildAt(paramInt3);
      int i1 = i;
      int i2 = paramInt2;
      paramInt1 = paramInt4;
      if (view.getVisibility() != 8) {
        ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
        if (actionMenuView$LayoutParams.isOverflowButton) {
          i = view.getMeasuredWidth();
          paramInt1 = i;
          if (hasSupportDividerBeforeChildAt(paramInt3))
            paramInt1 = i + m; 
          i2 = view.getMeasuredHeight();
          if (paramBoolean) {
            i1 = getPaddingLeft() + actionMenuView$LayoutParams.leftMargin;
            i = i1 + paramInt1;
          } else {
            i = getWidth() - getPaddingRight() - actionMenuView$LayoutParams.rightMargin;
            i1 = i - paramInt1;
          } 
          int i3 = j - i2 / 2;
          view.layout(i1, i3, i, i2 + i3);
          paramInt1 = paramInt4 - paramInt1;
          i1 = 1;
          i2 = paramInt2;
        } else {
          paramInt1 = paramInt4 - view.getMeasuredWidth() + actionMenuView$LayoutParams.leftMargin + actionMenuView$LayoutParams.rightMargin;
          hasSupportDividerBeforeChildAt(paramInt3);
          i2 = paramInt2 + 1;
          i1 = i;
        } 
      } 
      paramInt3++;
      i = i1;
      paramInt2 = i2;
      paramInt4 = paramInt1;
    } 
    if (k == 1 && i == 0) {
      View view = getChildAt(0);
      paramInt1 = view.getMeasuredWidth();
      paramInt2 = view.getMeasuredHeight();
      paramInt3 = n / 2 - paramInt1 / 2;
      paramInt4 = j - paramInt2 / 2;
      view.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    } 
    paramInt1 = paramInt2 - (i ^ 0x1);
    if (paramInt1 > 0) {
      paramInt1 = paramInt4 / paramInt1;
    } else {
      paramInt1 = 0;
    } 
    paramInt4 = 0;
    paramInt3 = 0;
    i = Math.max(0, paramInt1);
    if (paramBoolean) {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = paramInt3;
      while (paramInt1 < k) {
        View view = getChildAt(paramInt1);
        ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
        paramInt3 = paramInt2;
        if (view.getVisibility() != 8) {
          paramInt3 = paramInt2;
          if (!actionMenuView$LayoutParams.isOverflowButton) {
            paramInt2 -= actionMenuView$LayoutParams.rightMargin;
            paramInt3 = view.getMeasuredWidth();
            paramInt4 = view.getMeasuredHeight();
            int i1 = j - paramInt4 / 2;
            view.layout(paramInt2 - paramInt3, i1, paramInt2, paramInt4 + i1);
            paramInt3 = paramInt2 - paramInt3 + actionMenuView$LayoutParams.leftMargin + i;
          } 
        } 
        paramInt1++;
        paramInt2 = paramInt3;
      } 
      return;
    } 
    paramInt2 = getPaddingLeft();
    paramInt1 = paramInt4;
    while (paramInt1 < k) {
      View view = getChildAt(paramInt1);
      ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
      paramInt3 = paramInt2;
      if (view.getVisibility() != 8) {
        paramInt3 = paramInt2;
        if (!actionMenuView$LayoutParams.isOverflowButton) {
          paramInt2 += actionMenuView$LayoutParams.leftMargin;
          paramInt3 = view.getMeasuredWidth();
          paramInt4 = view.getMeasuredHeight();
          int i1 = j - paramInt4 / 2;
          view.layout(paramInt2, i1, paramInt2 + paramInt3, paramInt4 + i1);
          paramInt3 = paramInt2 + paramInt3 + actionMenuView$LayoutParams.rightMargin + i;
        } 
      } 
      paramInt1++;
      paramInt2 = paramInt3;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mFormatItems : Z
    //   4: istore #24
    //   6: iload_1
    //   7: invokestatic getMode : (I)I
    //   10: ldc 1073741824
    //   12: if_icmpne -> 21
    //   15: iconst_1
    //   16: istore #23
    //   18: goto -> 24
    //   21: iconst_0
    //   22: istore #23
    //   24: aload_0
    //   25: iload #23
    //   27: putfield mFormatItems : Z
    //   30: iload #24
    //   32: aload_0
    //   33: getfield mFormatItems : Z
    //   36: if_icmpeq -> 44
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield mFormatItemsWidth : I
    //   44: iload_1
    //   45: invokestatic getSize : (I)I
    //   48: istore #6
    //   50: aload_0
    //   51: getfield mFormatItems : Z
    //   54: ifeq -> 87
    //   57: aload_0
    //   58: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   61: ifnull -> 87
    //   64: iload #6
    //   66: aload_0
    //   67: getfield mFormatItemsWidth : I
    //   70: if_icmpeq -> 87
    //   73: aload_0
    //   74: iload #6
    //   76: putfield mFormatItemsWidth : I
    //   79: aload_0
    //   80: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   83: iconst_1
    //   84: invokevirtual onItemsChanged : (Z)V
    //   87: aload_0
    //   88: invokevirtual getChildCount : ()I
    //   91: istore #7
    //   93: aload_0
    //   94: getfield mFormatItems : Z
    //   97: ifeq -> 1376
    //   100: iload #7
    //   102: ifle -> 1376
    //   105: iload_2
    //   106: invokestatic getMode : (I)I
    //   109: istore #12
    //   111: iload_1
    //   112: invokestatic getSize : (I)I
    //   115: istore_1
    //   116: iload_2
    //   117: invokestatic getSize : (I)I
    //   120: istore #8
    //   122: aload_0
    //   123: invokevirtual getPaddingLeft : ()I
    //   126: istore #6
    //   128: aload_0
    //   129: invokevirtual getPaddingRight : ()I
    //   132: istore #7
    //   134: aload_0
    //   135: invokevirtual getPaddingTop : ()I
    //   138: aload_0
    //   139: invokevirtual getPaddingBottom : ()I
    //   142: iadd
    //   143: istore #15
    //   145: iload_2
    //   146: iload #15
    //   148: bipush #-2
    //   150: invokestatic getChildMeasureSpec : (III)I
    //   153: istore #20
    //   155: iload_1
    //   156: iload #6
    //   158: iload #7
    //   160: iadd
    //   161: isub
    //   162: istore #17
    //   164: iload #17
    //   166: aload_0
    //   167: getfield mMinCellSize : I
    //   170: idiv
    //   171: istore_1
    //   172: aload_0
    //   173: getfield mMinCellSize : I
    //   176: istore_2
    //   177: iload_1
    //   178: ifne -> 189
    //   181: aload_0
    //   182: iload #17
    //   184: iconst_0
    //   185: invokevirtual setMeasuredDimension : (II)V
    //   188: return
    //   189: aload_0
    //   190: getfield mMinCellSize : I
    //   193: iload #17
    //   195: iload_2
    //   196: irem
    //   197: iload_1
    //   198: idiv
    //   199: iadd
    //   200: istore #21
    //   202: aload_0
    //   203: invokevirtual getChildCount : ()I
    //   206: istore #22
    //   208: iconst_0
    //   209: istore #13
    //   211: iconst_0
    //   212: istore #11
    //   214: iconst_0
    //   215: istore #7
    //   217: iconst_0
    //   218: istore #9
    //   220: iconst_0
    //   221: istore #14
    //   223: iconst_0
    //   224: istore #10
    //   226: lconst_0
    //   227: lstore #25
    //   229: iload #11
    //   231: iload #22
    //   233: if_icmpge -> 514
    //   236: aload_0
    //   237: iload #11
    //   239: invokevirtual getChildAt : (I)Landroid/view/View;
    //   242: astore #33
    //   244: aload #33
    //   246: invokevirtual getVisibility : ()I
    //   249: bipush #8
    //   251: if_icmpeq -> 487
    //   254: aload #33
    //   256: instanceof android/support/v7/view/menu/ActionMenuItemView
    //   259: istore #23
    //   261: iload #14
    //   263: iconst_1
    //   264: iadd
    //   265: istore #6
    //   267: iload #23
    //   269: ifeq -> 290
    //   272: aload #33
    //   274: aload_0
    //   275: getfield mGeneratedItemPadding : I
    //   278: iconst_0
    //   279: aload_0
    //   280: getfield mGeneratedItemPadding : I
    //   283: iconst_0
    //   284: invokevirtual setPadding : (IIII)V
    //   287: goto -> 290
    //   290: aload #33
    //   292: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   295: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   298: astore #34
    //   300: aload #34
    //   302: iconst_0
    //   303: putfield expanded : Z
    //   306: aload #34
    //   308: iconst_0
    //   309: putfield extraPixels : I
    //   312: aload #34
    //   314: iconst_0
    //   315: putfield cellsUsed : I
    //   318: aload #34
    //   320: iconst_0
    //   321: putfield expandable : Z
    //   324: aload #34
    //   326: iconst_0
    //   327: putfield leftMargin : I
    //   330: aload #34
    //   332: iconst_0
    //   333: putfield rightMargin : I
    //   336: iload #23
    //   338: ifeq -> 358
    //   341: aload #33
    //   343: checkcast android/support/v7/view/menu/ActionMenuItemView
    //   346: invokevirtual hasText : ()Z
    //   349: ifeq -> 358
    //   352: iconst_1
    //   353: istore #23
    //   355: goto -> 361
    //   358: iconst_0
    //   359: istore #23
    //   361: aload #34
    //   363: iload #23
    //   365: putfield preventEdgeOffset : Z
    //   368: aload #34
    //   370: getfield isOverflowButton : Z
    //   373: ifeq -> 381
    //   376: iconst_1
    //   377: istore_2
    //   378: goto -> 383
    //   381: iload_1
    //   382: istore_2
    //   383: aload #33
    //   385: iload #21
    //   387: iload_2
    //   388: iload #20
    //   390: iload #15
    //   392: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   395: istore #14
    //   397: iload #13
    //   399: iload #14
    //   401: invokestatic max : (II)I
    //   404: istore #13
    //   406: iload #10
    //   408: istore_2
    //   409: aload #34
    //   411: getfield expandable : Z
    //   414: ifeq -> 422
    //   417: iload #10
    //   419: iconst_1
    //   420: iadd
    //   421: istore_2
    //   422: aload #34
    //   424: getfield isOverflowButton : Z
    //   427: ifeq -> 433
    //   430: iconst_1
    //   431: istore #9
    //   433: iload_1
    //   434: iload #14
    //   436: isub
    //   437: istore #10
    //   439: iload #7
    //   441: aload #33
    //   443: invokevirtual getMeasuredHeight : ()I
    //   446: invokestatic max : (II)I
    //   449: istore #7
    //   451: iload #14
    //   453: iconst_1
    //   454: if_icmpne -> 477
    //   457: lload #25
    //   459: iconst_1
    //   460: iload #11
    //   462: ishl
    //   463: i2l
    //   464: lor
    //   465: lstore #25
    //   467: iload #6
    //   469: istore_1
    //   470: iload #10
    //   472: istore #6
    //   474: goto -> 496
    //   477: iload #6
    //   479: istore_1
    //   480: iload #10
    //   482: istore #6
    //   484: goto -> 496
    //   487: iload #10
    //   489: istore_2
    //   490: iload_1
    //   491: istore #6
    //   493: iload #14
    //   495: istore_1
    //   496: iload #11
    //   498: iconst_1
    //   499: iadd
    //   500: istore #11
    //   502: iload_1
    //   503: istore #14
    //   505: iload #6
    //   507: istore_1
    //   508: iload_2
    //   509: istore #10
    //   511: goto -> 229
    //   514: iload #9
    //   516: ifeq -> 531
    //   519: iload #14
    //   521: iconst_2
    //   522: if_icmpne -> 531
    //   525: iconst_1
    //   526: istore #15
    //   528: goto -> 534
    //   531: iconst_0
    //   532: istore #15
    //   534: iconst_0
    //   535: istore #6
    //   537: iload_1
    //   538: istore #16
    //   540: iload #17
    //   542: istore_2
    //   543: iload #12
    //   545: istore_1
    //   546: iload #10
    //   548: ifle -> 884
    //   551: iload #16
    //   553: ifle -> 884
    //   556: ldc_w 2147483647
    //   559: istore #18
    //   561: iconst_0
    //   562: istore #11
    //   564: iconst_0
    //   565: istore #19
    //   567: lconst_0
    //   568: lstore #27
    //   570: iload #6
    //   572: istore #12
    //   574: iload #11
    //   576: iload #22
    //   578: if_icmpge -> 683
    //   581: aload_0
    //   582: iload #11
    //   584: invokevirtual getChildAt : (I)Landroid/view/View;
    //   587: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   590: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   593: astore #33
    //   595: aload #33
    //   597: getfield expandable : Z
    //   600: ifeq -> 666
    //   603: aload #33
    //   605: getfield cellsUsed : I
    //   608: iload #18
    //   610: if_icmpge -> 633
    //   613: aload #33
    //   615: getfield cellsUsed : I
    //   618: istore #18
    //   620: iconst_1
    //   621: iload #11
    //   623: ishl
    //   624: i2l
    //   625: lstore #27
    //   627: iconst_1
    //   628: istore #6
    //   630: goto -> 670
    //   633: aload #33
    //   635: getfield cellsUsed : I
    //   638: iload #18
    //   640: if_icmpne -> 666
    //   643: iconst_1
    //   644: iload #11
    //   646: ishl
    //   647: i2l
    //   648: lstore #29
    //   650: iload #19
    //   652: iconst_1
    //   653: iadd
    //   654: istore #6
    //   656: lload #27
    //   658: lload #29
    //   660: lor
    //   661: lstore #27
    //   663: goto -> 670
    //   666: iload #19
    //   668: istore #6
    //   670: iload #11
    //   672: iconst_1
    //   673: iadd
    //   674: istore #11
    //   676: iload #6
    //   678: istore #19
    //   680: goto -> 574
    //   683: iload_1
    //   684: istore #6
    //   686: iload_2
    //   687: istore #11
    //   689: iload #12
    //   691: istore_1
    //   692: lload #25
    //   694: lload #27
    //   696: lor
    //   697: lstore #25
    //   699: lload #25
    //   701: lstore #29
    //   703: iload #7
    //   705: istore_2
    //   706: iload #6
    //   708: istore #17
    //   710: iload #11
    //   712: istore #12
    //   714: iload #19
    //   716: iload #16
    //   718: if_icmpgt -> 900
    //   721: iconst_0
    //   722: istore_1
    //   723: iload_1
    //   724: iload #22
    //   726: if_icmpge -> 872
    //   729: aload_0
    //   730: iload_1
    //   731: invokevirtual getChildAt : (I)Landroid/view/View;
    //   734: astore #33
    //   736: aload #33
    //   738: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   741: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   744: astore #34
    //   746: iconst_1
    //   747: iload_1
    //   748: ishl
    //   749: i2l
    //   750: lstore #31
    //   752: lload #27
    //   754: lload #31
    //   756: land
    //   757: lconst_0
    //   758: lcmp
    //   759: ifne -> 794
    //   762: iload #16
    //   764: istore_2
    //   765: lload #25
    //   767: lstore #29
    //   769: aload #34
    //   771: getfield cellsUsed : I
    //   774: iload #18
    //   776: iconst_1
    //   777: iadd
    //   778: if_icmpne -> 858
    //   781: lload #25
    //   783: lload #31
    //   785: lor
    //   786: lstore #29
    //   788: iload #16
    //   790: istore_2
    //   791: goto -> 858
    //   794: iload #15
    //   796: ifeq -> 831
    //   799: aload #34
    //   801: getfield preventEdgeOffset : Z
    //   804: ifeq -> 831
    //   807: iload #16
    //   809: iconst_1
    //   810: if_icmpne -> 831
    //   813: aload #33
    //   815: aload_0
    //   816: getfield mGeneratedItemPadding : I
    //   819: iload #21
    //   821: iadd
    //   822: iconst_0
    //   823: aload_0
    //   824: getfield mGeneratedItemPadding : I
    //   827: iconst_0
    //   828: invokevirtual setPadding : (IIII)V
    //   831: aload #34
    //   833: aload #34
    //   835: getfield cellsUsed : I
    //   838: iconst_1
    //   839: iadd
    //   840: putfield cellsUsed : I
    //   843: aload #34
    //   845: iconst_1
    //   846: putfield expanded : Z
    //   849: iload #16
    //   851: iconst_1
    //   852: isub
    //   853: istore_2
    //   854: lload #25
    //   856: lstore #29
    //   858: iload_1
    //   859: iconst_1
    //   860: iadd
    //   861: istore_1
    //   862: iload_2
    //   863: istore #16
    //   865: lload #29
    //   867: lstore #25
    //   869: goto -> 723
    //   872: iload #6
    //   874: istore_1
    //   875: iload #11
    //   877: istore_2
    //   878: iconst_1
    //   879: istore #6
    //   881: goto -> 546
    //   884: iload_2
    //   885: istore #12
    //   887: iload_1
    //   888: istore #17
    //   890: iload #7
    //   892: istore_2
    //   893: iload #6
    //   895: istore_1
    //   896: lload #25
    //   898: lstore #29
    //   900: iload #9
    //   902: ifne -> 917
    //   905: iload #14
    //   907: iconst_1
    //   908: if_icmpne -> 917
    //   911: iconst_1
    //   912: istore #6
    //   914: goto -> 920
    //   917: iconst_0
    //   918: istore #6
    //   920: iload_1
    //   921: istore #7
    //   923: iload #16
    //   925: ifle -> 1281
    //   928: iload_1
    //   929: istore #7
    //   931: lload #29
    //   933: lconst_0
    //   934: lcmp
    //   935: ifeq -> 1281
    //   938: iload #16
    //   940: iload #14
    //   942: iconst_1
    //   943: isub
    //   944: if_icmplt -> 961
    //   947: iload #6
    //   949: ifne -> 961
    //   952: iload_1
    //   953: istore #7
    //   955: iload #13
    //   957: iconst_1
    //   958: if_icmple -> 1281
    //   961: lload #29
    //   963: invokestatic bitCount : (J)I
    //   966: i2f
    //   967: fstore #5
    //   969: fload #5
    //   971: fstore #4
    //   973: iload #6
    //   975: ifne -> 1067
    //   978: fload #5
    //   980: fstore_3
    //   981: lload #29
    //   983: lconst_1
    //   984: land
    //   985: lconst_0
    //   986: lcmp
    //   987: ifeq -> 1017
    //   990: fload #5
    //   992: fstore_3
    //   993: aload_0
    //   994: iconst_0
    //   995: invokevirtual getChildAt : (I)Landroid/view/View;
    //   998: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1001: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   1004: getfield preventEdgeOffset : Z
    //   1007: ifne -> 1017
    //   1010: fload #5
    //   1012: ldc_w 0.5
    //   1015: fsub
    //   1016: fstore_3
    //   1017: iload #22
    //   1019: iconst_1
    //   1020: isub
    //   1021: istore #6
    //   1023: fload_3
    //   1024: fstore #4
    //   1026: lload #29
    //   1028: iconst_1
    //   1029: iload #6
    //   1031: ishl
    //   1032: i2l
    //   1033: land
    //   1034: lconst_0
    //   1035: lcmp
    //   1036: ifeq -> 1067
    //   1039: fload_3
    //   1040: fstore #4
    //   1042: aload_0
    //   1043: iload #6
    //   1045: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1048: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1051: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   1054: getfield preventEdgeOffset : Z
    //   1057: ifne -> 1067
    //   1060: fload_3
    //   1061: ldc_w 0.5
    //   1064: fsub
    //   1065: fstore #4
    //   1067: fload #4
    //   1069: fconst_0
    //   1070: fcmpl
    //   1071: ifle -> 1089
    //   1074: iload #16
    //   1076: iload #21
    //   1078: imul
    //   1079: i2f
    //   1080: fload #4
    //   1082: fdiv
    //   1083: f2i
    //   1084: istore #7
    //   1086: goto -> 1092
    //   1089: iconst_0
    //   1090: istore #7
    //   1092: iconst_0
    //   1093: istore #9
    //   1095: iload #9
    //   1097: iload #22
    //   1099: if_icmpge -> 1278
    //   1102: lload #29
    //   1104: iconst_1
    //   1105: iload #9
    //   1107: ishl
    //   1108: i2l
    //   1109: land
    //   1110: lconst_0
    //   1111: lcmp
    //   1112: ifeq -> 1263
    //   1115: aload_0
    //   1116: iload #9
    //   1118: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1121: astore #33
    //   1123: aload #33
    //   1125: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1128: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   1131: astore #34
    //   1133: aload #33
    //   1135: instanceof android/support/v7/view/menu/ActionMenuItemView
    //   1138: ifeq -> 1185
    //   1141: aload #34
    //   1143: iload #7
    //   1145: putfield extraPixels : I
    //   1148: aload #34
    //   1150: iconst_1
    //   1151: putfield expanded : Z
    //   1154: iload #9
    //   1156: ifne -> 1177
    //   1159: aload #34
    //   1161: getfield preventEdgeOffset : Z
    //   1164: ifne -> 1177
    //   1167: aload #34
    //   1169: iload #7
    //   1171: ineg
    //   1172: iconst_2
    //   1173: idiv
    //   1174: putfield leftMargin : I
    //   1177: iconst_1
    //   1178: istore_1
    //   1179: iload_1
    //   1180: istore #6
    //   1182: goto -> 1266
    //   1185: aload #34
    //   1187: getfield isOverflowButton : Z
    //   1190: ifeq -> 1222
    //   1193: aload #34
    //   1195: iload #7
    //   1197: putfield extraPixels : I
    //   1200: aload #34
    //   1202: iconst_1
    //   1203: putfield expanded : Z
    //   1206: aload #34
    //   1208: iload #7
    //   1210: ineg
    //   1211: iconst_2
    //   1212: idiv
    //   1213: putfield rightMargin : I
    //   1216: iconst_1
    //   1217: istore #6
    //   1219: goto -> 1266
    //   1222: iload #9
    //   1224: ifeq -> 1236
    //   1227: aload #34
    //   1229: iload #7
    //   1231: iconst_2
    //   1232: idiv
    //   1233: putfield leftMargin : I
    //   1236: iload_1
    //   1237: istore #6
    //   1239: iload #9
    //   1241: iload #22
    //   1243: iconst_1
    //   1244: isub
    //   1245: if_icmpeq -> 1266
    //   1248: aload #34
    //   1250: iload #7
    //   1252: iconst_2
    //   1253: idiv
    //   1254: putfield rightMargin : I
    //   1257: iload_1
    //   1258: istore #6
    //   1260: goto -> 1266
    //   1263: goto -> 1179
    //   1266: iload #9
    //   1268: iconst_1
    //   1269: iadd
    //   1270: istore #9
    //   1272: iload #6
    //   1274: istore_1
    //   1275: goto -> 1095
    //   1278: iload_1
    //   1279: istore #7
    //   1281: iload #7
    //   1283: ifeq -> 1355
    //   1286: iconst_0
    //   1287: istore_1
    //   1288: iload_1
    //   1289: iload #22
    //   1291: if_icmpge -> 1355
    //   1294: aload_0
    //   1295: iload_1
    //   1296: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1299: astore #33
    //   1301: aload #33
    //   1303: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1306: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   1309: astore #34
    //   1311: aload #34
    //   1313: getfield expanded : Z
    //   1316: ifeq -> 1348
    //   1319: aload #33
    //   1321: aload #34
    //   1323: getfield cellsUsed : I
    //   1326: iload #21
    //   1328: imul
    //   1329: aload #34
    //   1331: getfield extraPixels : I
    //   1334: iadd
    //   1335: ldc 1073741824
    //   1337: invokestatic makeMeasureSpec : (II)I
    //   1340: iload #20
    //   1342: invokevirtual measure : (II)V
    //   1345: goto -> 1348
    //   1348: iload_1
    //   1349: iconst_1
    //   1350: iadd
    //   1351: istore_1
    //   1352: goto -> 1288
    //   1355: iload #17
    //   1357: ldc 1073741824
    //   1359: if_icmpeq -> 1365
    //   1362: goto -> 1368
    //   1365: iload #8
    //   1367: istore_2
    //   1368: aload_0
    //   1369: iload #12
    //   1371: iload_2
    //   1372: invokevirtual setMeasuredDimension : (II)V
    //   1375: return
    //   1376: iconst_0
    //   1377: istore #6
    //   1379: iload #6
    //   1381: iload #7
    //   1383: if_icmpge -> 1421
    //   1386: aload_0
    //   1387: iload #6
    //   1389: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1392: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1395: checkcast android/support/v7/widget/ActionMenuView$LayoutParams
    //   1398: astore #33
    //   1400: aload #33
    //   1402: iconst_0
    //   1403: putfield rightMargin : I
    //   1406: aload #33
    //   1408: iconst_0
    //   1409: putfield leftMargin : I
    //   1412: iload #6
    //   1414: iconst_1
    //   1415: iadd
    //   1416: istore #6
    //   1418: goto -> 1379
    //   1421: aload_0
    //   1422: iload_1
    //   1423: iload_2
    //   1424: invokespecial onMeasure : (II)V
    //   1427: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */