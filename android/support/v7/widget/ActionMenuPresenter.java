package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ActionProvider;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

final class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
  private final SparseBooleanArray mActionButtonGroups;
  
  ActionMenuPresenter$ActionButtonSubmenu mActionButtonPopup;
  
  private int mActionItemWidthLimit;
  
  private boolean mExpandedActionViewsExclusive;
  
  int mMaxItems;
  
  boolean mMaxItemsSet;
  
  private int mMinCellSize;
  
  ActionMenuPresenter$OverflowMenuButton mOverflowButton;
  
  ActionMenuPresenter$OverflowPopup mOverflowPopup;
  
  private Drawable mPendingOverflowIcon;
  
  private boolean mPendingOverflowIconSet;
  
  private ActionMenuPresenter$ActionMenuPopupCallback mPopupCallback;
  
  final ActionMenuPresenter$PopupPresenterCallback mPopupPresenterCallback;
  
  ActionMenuPresenter$OpenOverflowRunnable mPostedOpenRunnable;
  
  private boolean mReserveOverflow;
  
  private boolean mReserveOverflowSet;
  
  private View mScrapActionButtonView;
  
  private boolean mStrictWidthLimit;
  
  private int mWidthLimit;
  
  private boolean mWidthLimitSet;
  
  public final void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView) {
    paramItemView.initialize$667f453d(paramMenuItemImpl);
    ActionMenuView actionMenuView = (ActionMenuView)this.mMenuView;
    ActionMenuItemView actionMenuItemView = (ActionMenuItemView)paramItemView;
    actionMenuItemView.mItemInvoker = actionMenuView;
    if (this.mPopupCallback == null)
      this.mPopupCallback = new ActionMenuPresenter$ActionMenuPopupCallback(this); 
    actionMenuItemView.mPopupCallback = this.mPopupCallback;
  }
  
  public final boolean dismissPopupMenus() {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public final boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt) {
    return (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) ? false : super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public final boolean flagActionItems() {
    // Byte code:
    //   0: aload_0
    //   1: astore #15
    //   3: aload #15
    //   5: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   8: ifnull -> 31
    //   11: aload #15
    //   13: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   16: invokevirtual getVisibleItems : ()Ljava/util/ArrayList;
    //   19: astore #14
    //   21: aload #14
    //   23: invokevirtual size : ()I
    //   26: istore #4
    //   28: goto -> 37
    //   31: aconst_null
    //   32: astore #14
    //   34: iconst_0
    //   35: istore #4
    //   37: aload #15
    //   39: getfield mMaxItems : I
    //   42: istore_1
    //   43: aload #15
    //   45: getfield mActionItemWidthLimit : I
    //   48: istore #8
    //   50: iconst_0
    //   51: iconst_0
    //   52: invokestatic makeMeasureSpec : (II)I
    //   55: istore #10
    //   57: aload #15
    //   59: getfield mMenuView : Landroid/support/v7/view/menu/MenuView;
    //   62: checkcast android/view/ViewGroup
    //   65: astore #16
    //   67: iconst_0
    //   68: istore_3
    //   69: iconst_0
    //   70: istore #5
    //   72: iconst_0
    //   73: istore #6
    //   75: iconst_0
    //   76: istore_2
    //   77: iload_3
    //   78: iload #4
    //   80: if_icmpge -> 164
    //   83: aload #14
    //   85: iload_3
    //   86: invokevirtual get : (I)Ljava/lang/Object;
    //   89: checkcast android/support/v7/view/menu/MenuItemImpl
    //   92: astore #17
    //   94: aload #17
    //   96: invokevirtual requiresActionButton : ()Z
    //   99: ifeq -> 111
    //   102: iload #5
    //   104: iconst_1
    //   105: iadd
    //   106: istore #5
    //   108: goto -> 129
    //   111: aload #17
    //   113: invokevirtual requestsActionButton : ()Z
    //   116: ifeq -> 126
    //   119: iload_2
    //   120: iconst_1
    //   121: iadd
    //   122: istore_2
    //   123: goto -> 129
    //   126: iconst_1
    //   127: istore #6
    //   129: iload_1
    //   130: istore #7
    //   132: aload #15
    //   134: getfield mExpandedActionViewsExclusive : Z
    //   137: ifeq -> 154
    //   140: iload_1
    //   141: istore #7
    //   143: aload #17
    //   145: invokevirtual isActionViewExpanded : ()Z
    //   148: ifeq -> 154
    //   151: iconst_0
    //   152: istore #7
    //   154: iload_3
    //   155: iconst_1
    //   156: iadd
    //   157: istore_3
    //   158: iload #7
    //   160: istore_1
    //   161: goto -> 77
    //   164: iload_1
    //   165: istore_3
    //   166: aload #15
    //   168: getfield mReserveOverflow : Z
    //   171: ifeq -> 193
    //   174: iload #6
    //   176: ifne -> 189
    //   179: iload_1
    //   180: istore_3
    //   181: iload_2
    //   182: iload #5
    //   184: iadd
    //   185: iload_1
    //   186: if_icmple -> 193
    //   189: iload_1
    //   190: iconst_1
    //   191: isub
    //   192: istore_3
    //   193: iload_3
    //   194: iload #5
    //   196: isub
    //   197: istore_1
    //   198: aload #15
    //   200: getfield mActionButtonGroups : Landroid/util/SparseBooleanArray;
    //   203: astore #17
    //   205: aload #17
    //   207: invokevirtual clear : ()V
    //   210: aload #15
    //   212: getfield mStrictWidthLimit : Z
    //   215: ifeq -> 254
    //   218: iload #8
    //   220: aload #15
    //   222: getfield mMinCellSize : I
    //   225: idiv
    //   226: istore_3
    //   227: aload #15
    //   229: getfield mMinCellSize : I
    //   232: istore_2
    //   233: aload #15
    //   235: getfield mMinCellSize : I
    //   238: istore #5
    //   240: iload #8
    //   242: iload_2
    //   243: irem
    //   244: iload_3
    //   245: idiv
    //   246: iload #5
    //   248: iadd
    //   249: istore #6
    //   251: goto -> 259
    //   254: iconst_0
    //   255: istore_3
    //   256: iconst_0
    //   257: istore #6
    //   259: iload #8
    //   261: istore #5
    //   263: iconst_0
    //   264: istore #8
    //   266: iconst_0
    //   267: istore_2
    //   268: iload #4
    //   270: istore #7
    //   272: aload_0
    //   273: astore #15
    //   275: iload #8
    //   277: iload #7
    //   279: if_icmpge -> 798
    //   282: aload #14
    //   284: iload #8
    //   286: invokevirtual get : (I)Ljava/lang/Object;
    //   289: checkcast android/support/v7/view/menu/MenuItemImpl
    //   292: astore #18
    //   294: aload #18
    //   296: invokevirtual requiresActionButton : ()Z
    //   299: ifeq -> 423
    //   302: aload #15
    //   304: aload #18
    //   306: aload #15
    //   308: getfield mScrapActionButtonView : Landroid/view/View;
    //   311: aload #16
    //   313: invokevirtual getItemView : (Landroid/support/v7/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   316: astore #19
    //   318: aload #15
    //   320: getfield mScrapActionButtonView : Landroid/view/View;
    //   323: ifnonnull -> 333
    //   326: aload #15
    //   328: aload #19
    //   330: putfield mScrapActionButtonView : Landroid/view/View;
    //   333: aload #15
    //   335: getfield mStrictWidthLimit : Z
    //   338: ifeq -> 358
    //   341: iload_3
    //   342: aload #19
    //   344: iload #6
    //   346: iload_3
    //   347: iload #10
    //   349: iconst_0
    //   350: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   353: isub
    //   354: istore_3
    //   355: goto -> 367
    //   358: aload #19
    //   360: iload #10
    //   362: iload #10
    //   364: invokevirtual measure : (II)V
    //   367: aload #19
    //   369: invokevirtual getMeasuredWidth : ()I
    //   372: istore #4
    //   374: iload #5
    //   376: iload #4
    //   378: isub
    //   379: istore #5
    //   381: iload_2
    //   382: ifne -> 391
    //   385: iload #4
    //   387: istore_2
    //   388: goto -> 391
    //   391: aload #18
    //   393: invokevirtual getGroupId : ()I
    //   396: istore #4
    //   398: iload #4
    //   400: ifeq -> 414
    //   403: aload #17
    //   405: iload #4
    //   407: iconst_1
    //   408: invokevirtual put : (IZ)V
    //   411: goto -> 414
    //   414: aload #18
    //   416: iconst_1
    //   417: invokevirtual setIsActionButton : (Z)V
    //   420: goto -> 789
    //   423: aload #18
    //   425: invokevirtual requestsActionButton : ()Z
    //   428: ifeq -> 783
    //   431: aload #18
    //   433: invokevirtual getGroupId : ()I
    //   436: istore #11
    //   438: aload #17
    //   440: iload #11
    //   442: invokevirtual get : (I)Z
    //   445: istore #13
    //   447: iload_1
    //   448: ifgt -> 456
    //   451: iload #13
    //   453: ifeq -> 479
    //   456: iload #5
    //   458: ifle -> 479
    //   461: aload #15
    //   463: getfield mStrictWidthLimit : Z
    //   466: ifeq -> 473
    //   469: iload_3
    //   470: ifle -> 479
    //   473: iconst_1
    //   474: istore #12
    //   476: goto -> 482
    //   479: iconst_0
    //   480: istore #12
    //   482: iload #12
    //   484: ifeq -> 648
    //   487: aload #15
    //   489: aload #18
    //   491: aload #15
    //   493: getfield mScrapActionButtonView : Landroid/view/View;
    //   496: aload #16
    //   498: invokevirtual getItemView : (Landroid/support/v7/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   501: astore #19
    //   503: aload #15
    //   505: getfield mScrapActionButtonView : Landroid/view/View;
    //   508: ifnonnull -> 518
    //   511: aload #15
    //   513: aload #19
    //   515: putfield mScrapActionButtonView : Landroid/view/View;
    //   518: aload #15
    //   520: getfield mStrictWidthLimit : Z
    //   523: ifeq -> 555
    //   526: aload #19
    //   528: iload #6
    //   530: iload_3
    //   531: iload #10
    //   533: iconst_0
    //   534: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   537: istore #4
    //   539: iload_3
    //   540: iload #4
    //   542: isub
    //   543: istore_3
    //   544: iload #4
    //   546: ifne -> 552
    //   549: iconst_0
    //   550: istore #12
    //   552: goto -> 564
    //   555: aload #19
    //   557: iload #10
    //   559: iload #10
    //   561: invokevirtual measure : (II)V
    //   564: aload #19
    //   566: invokevirtual getMeasuredWidth : ()I
    //   569: istore #9
    //   571: iload #5
    //   573: iload #9
    //   575: isub
    //   576: istore #5
    //   578: iload_2
    //   579: istore #4
    //   581: iload_2
    //   582: ifne -> 589
    //   585: iload #9
    //   587: istore #4
    //   589: aload #15
    //   591: getfield mStrictWidthLimit : Z
    //   594: ifeq -> 621
    //   597: iload #5
    //   599: iflt -> 607
    //   602: iconst_1
    //   603: istore_2
    //   604: goto -> 609
    //   607: iconst_0
    //   608: istore_2
    //   609: iload #12
    //   611: iload_2
    //   612: iand
    //   613: istore #12
    //   615: iload #4
    //   617: istore_2
    //   618: goto -> 648
    //   621: iload #5
    //   623: iload #4
    //   625: iadd
    //   626: ifle -> 634
    //   629: iconst_1
    //   630: istore_2
    //   631: goto -> 636
    //   634: iconst_0
    //   635: istore_2
    //   636: iload #12
    //   638: iload_2
    //   639: iand
    //   640: istore #12
    //   642: iload #4
    //   644: istore_2
    //   645: goto -> 648
    //   648: iload #12
    //   650: ifeq -> 672
    //   653: iload #11
    //   655: ifeq -> 672
    //   658: aload #17
    //   660: iload #11
    //   662: iconst_1
    //   663: invokevirtual put : (IZ)V
    //   666: iload_1
    //   667: istore #4
    //   669: goto -> 760
    //   672: iload_1
    //   673: istore #4
    //   675: iload #13
    //   677: ifeq -> 760
    //   680: aload #17
    //   682: iload #11
    //   684: iconst_0
    //   685: invokevirtual put : (IZ)V
    //   688: iconst_0
    //   689: istore #9
    //   691: iload_1
    //   692: istore #4
    //   694: iload #9
    //   696: iload #8
    //   698: if_icmpge -> 760
    //   701: aload #14
    //   703: iload #9
    //   705: invokevirtual get : (I)Ljava/lang/Object;
    //   708: checkcast android/support/v7/view/menu/MenuItemImpl
    //   711: astore #15
    //   713: iload_1
    //   714: istore #4
    //   716: aload #15
    //   718: invokevirtual getGroupId : ()I
    //   721: iload #11
    //   723: if_icmpne -> 748
    //   726: iload_1
    //   727: istore #4
    //   729: aload #15
    //   731: invokevirtual isActionButton : ()Z
    //   734: ifeq -> 742
    //   737: iload_1
    //   738: iconst_1
    //   739: iadd
    //   740: istore #4
    //   742: aload #15
    //   744: iconst_0
    //   745: invokevirtual setIsActionButton : (Z)V
    //   748: iload #9
    //   750: iconst_1
    //   751: iadd
    //   752: istore #9
    //   754: iload #4
    //   756: istore_1
    //   757: goto -> 691
    //   760: iload #4
    //   762: istore_1
    //   763: iload #12
    //   765: ifeq -> 773
    //   768: iload #4
    //   770: iconst_1
    //   771: isub
    //   772: istore_1
    //   773: aload #18
    //   775: iload #12
    //   777: invokevirtual setIsActionButton : (Z)V
    //   780: goto -> 420
    //   783: aload #18
    //   785: iconst_0
    //   786: invokevirtual setIsActionButton : (Z)V
    //   789: iload #8
    //   791: iconst_1
    //   792: iadd
    //   793: istore #8
    //   795: goto -> 272
    //   798: iconst_1
    //   799: ireturn
  }
  
  public final View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup) {
    boolean bool;
    View view = paramMenuItemImpl.getActionView();
    if (view == null || paramMenuItemImpl.hasCollapsibleActionView())
      view = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup); 
    if (paramMenuItemImpl.isActionViewExpanded()) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setVisibility(bool);
    ActionMenuView actionMenuView = (ActionMenuView)paramViewGroup;
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (!actionMenuView.checkLayoutParams(layoutParams))
      view.setLayoutParams((ViewGroup.LayoutParams)ActionMenuView.generateLayoutParams(layoutParams)); 
    return view;
  }
  
  public final boolean hideOverflowMenu() {
    if (this.mPostedOpenRunnable != null && this.mMenuView != null) {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      return true;
    } 
    ActionMenuPresenter$OverflowPopup actionMenuPresenter$OverflowPopup = this.mOverflowPopup;
    if (actionMenuPresenter$OverflowPopup != null) {
      actionMenuPresenter$OverflowPopup.dismiss();
      return true;
    } 
    return false;
  }
  
  public final boolean hideSubMenus() {
    if (this.mActionButtonPopup != null) {
      this.mActionButtonPopup.dismiss();
      return true;
    } 
    return false;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    super.initForMenu(paramContext, paramMenuBuilder);
    Resources resources = paramContext.getResources();
    ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet) {
      int j = Build.VERSION.SDK_INT;
      boolean bool = true;
      if (j < 19 && ViewConfiguration.get(actionBarPolicy.mContext).hasPermanentMenuKey())
        bool = false; 
      this.mReserveOverflow = bool;
    } 
    if (!this.mWidthLimitSet)
      this.mWidthLimit = (actionBarPolicy.mContext.getResources().getDisplayMetrics()).widthPixels / 2; 
    if (!this.mMaxItemsSet)
      this.mMaxItems = actionBarPolicy.getMaxActionButtons(); 
    int i = this.mWidthLimit;
    if (this.mReserveOverflow) {
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new ActionMenuPresenter$OverflowMenuButton(this, this.mSystemContext);
        if (this.mPendingOverflowIconSet) {
          this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
          this.mPendingOverflowIcon = null;
          this.mPendingOverflowIconSet = false;
        } 
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      } 
      i -= this.mOverflowButton.getMeasuredWidth();
    } else {
      this.mOverflowButton = null;
    } 
    this.mActionItemWidthLimit = i;
    this.mMinCellSize = (int)((resources.getDisplayMetrics()).density * 56.0F);
    this.mScrapActionButtonView = null;
  }
  
  public final boolean isOverflowMenuShowing() {
    return (this.mOverflowPopup != null && this.mOverflowPopup.isShowing());
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual hasVisibleItems : ()Z
    //   4: istore #4
    //   6: iconst_0
    //   7: istore #5
    //   9: iload #4
    //   11: ifne -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: astore #6
    //   19: aload #6
    //   21: getfield mParentMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   24: aload_0
    //   25: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   28: if_acmpeq -> 44
    //   31: aload #6
    //   33: getfield mParentMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   36: checkcast android/support/v7/view/menu/SubMenuBuilder
    //   39: astore #6
    //   41: goto -> 19
    //   44: aload #6
    //   46: invokevirtual getItem : ()Landroid/view/MenuItem;
    //   49: astore #7
    //   51: aload_0
    //   52: getfield mMenuView : Landroid/support/v7/view/menu/MenuView;
    //   55: checkcast android/view/ViewGroup
    //   58: astore #8
    //   60: aload #8
    //   62: ifnull -> 119
    //   65: aload #8
    //   67: invokevirtual getChildCount : ()I
    //   70: istore_3
    //   71: iconst_0
    //   72: istore_2
    //   73: iload_2
    //   74: iload_3
    //   75: if_icmpge -> 119
    //   78: aload #8
    //   80: iload_2
    //   81: invokevirtual getChildAt : (I)Landroid/view/View;
    //   84: astore #6
    //   86: aload #6
    //   88: instanceof android/support/v7/view/menu/MenuView$ItemView
    //   91: ifeq -> 112
    //   94: aload #6
    //   96: checkcast android/support/v7/view/menu/MenuView$ItemView
    //   99: invokeinterface getItemData : ()Landroid/support/v7/view/menu/MenuItemImpl;
    //   104: aload #7
    //   106: if_acmpne -> 112
    //   109: goto -> 122
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore_2
    //   116: goto -> 73
    //   119: aconst_null
    //   120: astore #6
    //   122: aload #6
    //   124: ifnonnull -> 129
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_1
    //   130: invokevirtual getItem : ()Landroid/view/MenuItem;
    //   133: invokeinterface getItemId : ()I
    //   138: pop
    //   139: aload_1
    //   140: invokevirtual size : ()I
    //   143: istore_3
    //   144: iconst_0
    //   145: istore_2
    //   146: iload #5
    //   148: istore #4
    //   150: iload_2
    //   151: iload_3
    //   152: if_icmpge -> 195
    //   155: aload_1
    //   156: iload_2
    //   157: invokevirtual getItem : (I)Landroid/view/MenuItem;
    //   160: astore #7
    //   162: aload #7
    //   164: invokeinterface isVisible : ()Z
    //   169: ifeq -> 188
    //   172: aload #7
    //   174: invokeinterface getIcon : ()Landroid/graphics/drawable/Drawable;
    //   179: ifnull -> 188
    //   182: iconst_1
    //   183: istore #4
    //   185: goto -> 195
    //   188: iload_2
    //   189: iconst_1
    //   190: iadd
    //   191: istore_2
    //   192: goto -> 146
    //   195: aload_0
    //   196: new android/support/v7/widget/ActionMenuPresenter$ActionButtonSubmenu
    //   199: dup
    //   200: aload_0
    //   201: aload_0
    //   202: getfield mContext : Landroid/content/Context;
    //   205: aload_1
    //   206: aload #6
    //   208: invokespecial <init> : (Landroid/support/v7/widget/ActionMenuPresenter;Landroid/content/Context;Landroid/support/v7/view/menu/SubMenuBuilder;Landroid/view/View;)V
    //   211: putfield mActionButtonPopup : Landroid/support/v7/widget/ActionMenuPresenter$ActionButtonSubmenu;
    //   214: aload_0
    //   215: getfield mActionButtonPopup : Landroid/support/v7/widget/ActionMenuPresenter$ActionButtonSubmenu;
    //   218: iload #4
    //   220: invokevirtual setForceShowIcon : (Z)V
    //   223: aload_0
    //   224: getfield mActionButtonPopup : Landroid/support/v7/widget/ActionMenuPresenter$ActionButtonSubmenu;
    //   227: invokevirtual tryShow : ()Z
    //   230: ifeq -> 241
    //   233: aload_0
    //   234: aload_1
    //   235: invokespecial onSubMenuSelected : (Landroid/support/v7/view/menu/SubMenuBuilder;)Z
    //   238: pop
    //   239: iconst_1
    //   240: ireturn
    //   241: new java/lang/IllegalStateException
    //   244: dup
    //   245: ldc_w 'MenuPopupHelper cannot be used without an anchor'
    //   248: invokespecial <init> : (Ljava/lang/String;)V
    //   251: athrow
  }
  
  public final void onSubUiVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean) {
      super.onSubMenuSelected(null);
      return;
    } 
    if (this.mMenu != null)
      this.mMenu.close(false); 
  }
  
  public final boolean shouldIncludeItem$6edfc5cf(MenuItemImpl paramMenuItemImpl) {
    return paramMenuItemImpl.isActionButton();
  }
  
  public final boolean showOverflowMenu() {
    if (this.mReserveOverflow && !isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
      this.mPostedOpenRunnable = new ActionMenuPresenter$OpenOverflowRunnable(this, new ActionMenuPresenter$OverflowPopup(this, this.mContext, this.mMenu, (View)this.mOverflowButton, true));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    } 
    return false;
  }
  
  public final void updateMenuView(boolean paramBoolean) {
    super.updateMenuView(paramBoolean);
    ((View)this.mMenuView).requestLayout();
    MenuBuilder<MenuItemImpl> menuBuilder = this.mMenu;
    byte b = 0;
    if (menuBuilder != null) {
      menuBuilder = this.mMenu;
      menuBuilder.flagActionItems();
      ArrayList arrayList = menuBuilder.mActionItems;
      int k = arrayList.size();
      for (int j = 0; j < k; j++) {
        ActionProvider actionProvider = ((MenuItemImpl)arrayList.get(j)).mActionProvider;
        if (actionProvider != null)
          actionProvider.mSubUiVisibilityListener = this; 
      } 
    } 
    if (this.mMenu != null) {
      ArrayList arrayList = this.mMenu.getNonActionItems();
    } else {
      menuBuilder = null;
    } 
    int i = b;
    if (this.mReserveOverflow) {
      i = b;
      if (menuBuilder != null) {
        i = menuBuilder.size();
        if (i == 1) {
          i = ((MenuItemImpl)menuBuilder.get(0)).isActionViewExpanded() ^ true;
        } else if (i > 0) {
          i = 1;
        } else {
          i = b;
        } 
      } 
    } 
    if (i != 0) {
      if (this.mOverflowButton == null)
        this.mOverflowButton = new ActionMenuPresenter$OverflowMenuButton(this, this.mSystemContext); 
      ViewGroup viewGroup = (ViewGroup)this.mOverflowButton.getParent();
      if (viewGroup != this.mMenuView) {
        if (viewGroup != null)
          viewGroup.removeView((View)this.mOverflowButton); 
        ((ActionMenuView)this.mMenuView).addView((View)this.mOverflowButton, (ViewGroup.LayoutParams)ActionMenuView.generateOverflowButtonLayoutParams());
      } 
      return;
    } 
    if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView)
      ((ViewGroup)this.mMenuView).removeView((View)this.mOverflowButton); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */