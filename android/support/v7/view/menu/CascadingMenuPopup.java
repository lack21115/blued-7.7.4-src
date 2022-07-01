package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.MenuItemHoverListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
  private View mAnchorView;
  
  private final View.OnAttachStateChangeListener mAttachStateChangeListener = new CascadingMenuPopup$2(this);
  
  private final Context mContext;
  
  private int mDropDownGravity = 0;
  
  private boolean mForceShowIcon;
  
  private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new CascadingMenuPopup$1(this);
  
  private boolean mHasXOffset;
  
  private boolean mHasYOffset;
  
  private int mLastPosition;
  
  private final MenuItemHoverListener mMenuItemHoverListener = new CascadingMenuPopup$3(this);
  
  private final int mMenuMaxWidth;
  
  private PopupWindow.OnDismissListener mOnDismissListener;
  
  private final boolean mOverflowOnly;
  
  private final List mPendingMenus = new LinkedList();
  
  private final int mPopupStyleAttr;
  
  private final int mPopupStyleRes;
  
  private MenuPresenter$Callback mPresenterCallback;
  
  private int mRawDropDownGravity = 0;
  
  boolean mShouldCloseImmediately;
  
  private boolean mShowTitle;
  
  final List mShowingMenus = new ArrayList();
  
  View mShownAnchorView;
  
  final Handler mSubMenuHoverHandler;
  
  private ViewTreeObserver mTreeObserver;
  
  private int mXOffset;
  
  private int mYOffset;
  
  public CascadingMenuPopup(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    this.mContext = paramContext;
    this.mAnchorView = paramView;
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
    this.mOverflowOnly = paramBoolean;
    this.mForceShowIcon = false;
    this.mLastPosition = getInitialMenuPosition();
    Resources resources = paramContext.getResources();
    this.mMenuMaxWidth = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.mSubMenuHoverHandler = new Handler();
  }
  
  private int getInitialMenuPosition() {
    return (ViewCompat.getLayoutDirection(this.mAnchorView) == 1) ? 0 : 1;
  }
  
  private void showMenu(MenuBuilder paramMenuBuilder) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mContext : Landroid/content/Context;
    //   4: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   7: astore #10
    //   9: new android/support/v7/view/menu/MenuAdapter
    //   12: dup
    //   13: aload_1
    //   14: aload #10
    //   16: aload_0
    //   17: getfield mOverflowOnly : Z
    //   20: invokespecial <init> : (Landroid/support/v7/view/menu/MenuBuilder;Landroid/view/LayoutInflater;Z)V
    //   23: astore #6
    //   25: aload_0
    //   26: invokevirtual isShowing : ()Z
    //   29: ifne -> 48
    //   32: aload_0
    //   33: getfield mForceShowIcon : Z
    //   36: ifeq -> 48
    //   39: aload #6
    //   41: iconst_1
    //   42: putfield mForceShowIcon : Z
    //   45: goto -> 64
    //   48: aload_0
    //   49: invokevirtual isShowing : ()Z
    //   52: ifeq -> 64
    //   55: aload #6
    //   57: aload_1
    //   58: invokestatic shouldPreserveIconSpacing : (Landroid/support/v7/view/menu/MenuBuilder;)Z
    //   61: putfield mForceShowIcon : Z
    //   64: aload_0
    //   65: getfield mContext : Landroid/content/Context;
    //   68: astore #8
    //   70: aload_0
    //   71: getfield mMenuMaxWidth : I
    //   74: istore_2
    //   75: aconst_null
    //   76: astore #7
    //   78: aload #6
    //   80: aconst_null
    //   81: aload #8
    //   83: iload_2
    //   84: invokestatic measureIndividualMenuWidth : (Landroid/widget/ListAdapter;Landroid/view/ViewGroup;Landroid/content/Context;I)I
    //   87: istore #5
    //   89: new android/support/v7/widget/MenuPopupWindow
    //   92: dup
    //   93: aload_0
    //   94: getfield mContext : Landroid/content/Context;
    //   97: aconst_null
    //   98: aload_0
    //   99: getfield mPopupStyleAttr : I
    //   102: aload_0
    //   103: getfield mPopupStyleRes : I
    //   106: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;II)V
    //   109: astore #9
    //   111: aload #9
    //   113: aload_0
    //   114: getfield mMenuItemHoverListener : Landroid/support/v7/widget/MenuItemHoverListener;
    //   117: putfield mHoverListener : Landroid/support/v7/widget/MenuItemHoverListener;
    //   120: aload #9
    //   122: aload_0
    //   123: putfield mItemClickListener : Landroid/widget/AdapterView$OnItemClickListener;
    //   126: aload #9
    //   128: aload_0
    //   129: invokevirtual setOnDismissListener : (Landroid/widget/PopupWindow$OnDismissListener;)V
    //   132: aload #9
    //   134: aload_0
    //   135: getfield mAnchorView : Landroid/view/View;
    //   138: putfield mDropDownAnchorView : Landroid/view/View;
    //   141: aload #9
    //   143: aload_0
    //   144: getfield mDropDownGravity : I
    //   147: putfield mDropDownGravity : I
    //   150: aload #9
    //   152: iconst_1
    //   153: invokevirtual setModal : (Z)V
    //   156: aload #9
    //   158: iconst_2
    //   159: invokevirtual setInputMethodMode : (I)V
    //   162: aload #9
    //   164: aload #6
    //   166: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   169: aload #9
    //   171: iload #5
    //   173: invokevirtual setContentWidth : (I)V
    //   176: aload #9
    //   178: aload_0
    //   179: getfield mDropDownGravity : I
    //   182: putfield mDropDownGravity : I
    //   185: aload_0
    //   186: getfield mShowingMenus : Ljava/util/List;
    //   189: invokeinterface size : ()I
    //   194: ifle -> 456
    //   197: aload_0
    //   198: getfield mShowingMenus : Ljava/util/List;
    //   201: aload_0
    //   202: getfield mShowingMenus : Ljava/util/List;
    //   205: invokeinterface size : ()I
    //   210: iconst_1
    //   211: isub
    //   212: invokeinterface get : (I)Ljava/lang/Object;
    //   217: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   220: astore #8
    //   222: aload #8
    //   224: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   227: astore #11
    //   229: aload #11
    //   231: invokevirtual size : ()I
    //   234: istore_3
    //   235: iconst_0
    //   236: istore_2
    //   237: iload_2
    //   238: iload_3
    //   239: if_icmpge -> 281
    //   242: aload #11
    //   244: iload_2
    //   245: invokevirtual getItem : (I)Landroid/view/MenuItem;
    //   248: astore #6
    //   250: aload #6
    //   252: invokeinterface hasSubMenu : ()Z
    //   257: ifeq -> 274
    //   260: aload_1
    //   261: aload #6
    //   263: invokeinterface getSubMenu : ()Landroid/view/SubMenu;
    //   268: if_acmpne -> 274
    //   271: goto -> 284
    //   274: iload_2
    //   275: iconst_1
    //   276: iadd
    //   277: istore_2
    //   278: goto -> 237
    //   281: aconst_null
    //   282: astore #6
    //   284: aload #6
    //   286: ifnonnull -> 296
    //   289: aload #7
    //   291: astore #6
    //   293: goto -> 445
    //   296: aload #8
    //   298: getfield window : Landroid/support/v7/widget/MenuPopupWindow;
    //   301: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   304: astore #11
    //   306: aload #11
    //   308: invokevirtual getAdapter : ()Landroid/widget/ListAdapter;
    //   311: astore #7
    //   313: aload #7
    //   315: instanceof android/widget/HeaderViewListAdapter
    //   318: ifeq -> 347
    //   321: aload #7
    //   323: checkcast android/widget/HeaderViewListAdapter
    //   326: astore #7
    //   328: aload #7
    //   330: invokevirtual getHeadersCount : ()I
    //   333: istore_3
    //   334: aload #7
    //   336: invokevirtual getWrappedAdapter : ()Landroid/widget/ListAdapter;
    //   339: checkcast android/support/v7/view/menu/MenuAdapter
    //   342: astore #7
    //   344: goto -> 356
    //   347: aload #7
    //   349: checkcast android/support/v7/view/menu/MenuAdapter
    //   352: astore #7
    //   354: iconst_0
    //   355: istore_3
    //   356: aload #7
    //   358: invokevirtual getCount : ()I
    //   361: istore #4
    //   363: iconst_0
    //   364: istore_2
    //   365: iload_2
    //   366: iload #4
    //   368: if_icmpge -> 392
    //   371: aload #6
    //   373: aload #7
    //   375: iload_2
    //   376: invokevirtual getItem : (I)Landroid/support/v7/view/menu/MenuItemImpl;
    //   379: if_acmpne -> 385
    //   382: goto -> 394
    //   385: iload_2
    //   386: iconst_1
    //   387: iadd
    //   388: istore_2
    //   389: goto -> 365
    //   392: iconst_m1
    //   393: istore_2
    //   394: iload_2
    //   395: iconst_m1
    //   396: if_icmpne -> 405
    //   399: aconst_null
    //   400: astore #6
    //   402: goto -> 445
    //   405: iload_2
    //   406: iload_3
    //   407: iadd
    //   408: aload #11
    //   410: invokevirtual getFirstVisiblePosition : ()I
    //   413: isub
    //   414: istore_2
    //   415: iload_2
    //   416: iflt -> 442
    //   419: iload_2
    //   420: aload #11
    //   422: invokevirtual getChildCount : ()I
    //   425: if_icmplt -> 431
    //   428: goto -> 442
    //   431: aload #11
    //   433: iload_2
    //   434: invokevirtual getChildAt : (I)Landroid/view/View;
    //   437: astore #6
    //   439: goto -> 445
    //   442: goto -> 399
    //   445: aload #6
    //   447: astore #7
    //   449: aload #8
    //   451: astore #6
    //   453: goto -> 462
    //   456: aconst_null
    //   457: astore #7
    //   459: aconst_null
    //   460: astore #6
    //   462: aload #7
    //   464: ifnull -> 809
    //   467: getstatic android/support/v7/widget/MenuPopupWindow.sSetTouchModalMethod : Ljava/lang/reflect/Method;
    //   470: ifnull -> 511
    //   473: getstatic android/support/v7/widget/MenuPopupWindow.sSetTouchModalMethod : Ljava/lang/reflect/Method;
    //   476: aload #9
    //   478: getfield mPopup : Landroid/widget/PopupWindow;
    //   481: iconst_1
    //   482: anewarray java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: iconst_0
    //   488: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   491: aastore
    //   492: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   495: pop
    //   496: goto -> 511
    //   499: astore #8
    //   501: ldc_w 'MenuPopupWindow'
    //   504: ldc_w 'Could not invoke setTouchModal() on PopupWindow. Oh well.'
    //   507: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   510: pop
    //   511: getstatic android/os/Build$VERSION.SDK_INT : I
    //   514: bipush #23
    //   516: if_icmplt -> 528
    //   519: aload #9
    //   521: getfield mPopup : Landroid/widget/PopupWindow;
    //   524: aconst_null
    //   525: invokevirtual setEnterTransition : (Landroid/transition/Transition;)V
    //   528: aload_0
    //   529: getfield mShowingMenus : Ljava/util/List;
    //   532: aload_0
    //   533: getfield mShowingMenus : Ljava/util/List;
    //   536: invokeinterface size : ()I
    //   541: iconst_1
    //   542: isub
    //   543: invokeinterface get : (I)Ljava/lang/Object;
    //   548: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   551: getfield window : Landroid/support/v7/widget/MenuPopupWindow;
    //   554: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   557: astore #8
    //   559: iconst_2
    //   560: newarray int
    //   562: astore #11
    //   564: aload #8
    //   566: aload #11
    //   568: invokevirtual getLocationOnScreen : ([I)V
    //   571: new android/graphics/Rect
    //   574: dup
    //   575: invokespecial <init> : ()V
    //   578: astore #12
    //   580: aload_0
    //   581: getfield mShownAnchorView : Landroid/view/View;
    //   584: aload #12
    //   586: invokevirtual getWindowVisibleDisplayFrame : (Landroid/graphics/Rect;)V
    //   589: aload_0
    //   590: getfield mLastPosition : I
    //   593: iconst_1
    //   594: if_icmpne -> 623
    //   597: aload #11
    //   599: iconst_0
    //   600: iaload
    //   601: aload #8
    //   603: invokevirtual getWidth : ()I
    //   606: iadd
    //   607: iload #5
    //   609: iadd
    //   610: aload #12
    //   612: getfield right : I
    //   615: if_icmpgt -> 636
    //   618: iconst_1
    //   619: istore_3
    //   620: goto -> 638
    //   623: aload #11
    //   625: iconst_0
    //   626: iaload
    //   627: iload #5
    //   629: isub
    //   630: ifge -> 636
    //   633: goto -> 618
    //   636: iconst_0
    //   637: istore_3
    //   638: iload_3
    //   639: iconst_1
    //   640: if_icmpne -> 648
    //   643: iconst_1
    //   644: istore_2
    //   645: goto -> 650
    //   648: iconst_0
    //   649: istore_2
    //   650: aload_0
    //   651: iload_3
    //   652: putfield mLastPosition : I
    //   655: getstatic android/os/Build$VERSION.SDK_INT : I
    //   658: bipush #26
    //   660: if_icmplt -> 678
    //   663: aload #9
    //   665: aload #7
    //   667: putfield mDropDownAnchorView : Landroid/view/View;
    //   670: iconst_0
    //   671: istore_3
    //   672: iconst_0
    //   673: istore #4
    //   675: goto -> 725
    //   678: iconst_2
    //   679: newarray int
    //   681: astore #8
    //   683: aload_0
    //   684: getfield mAnchorView : Landroid/view/View;
    //   687: aload #8
    //   689: invokevirtual getLocationOnScreen : ([I)V
    //   692: iconst_2
    //   693: newarray int
    //   695: astore #11
    //   697: aload #7
    //   699: aload #11
    //   701: invokevirtual getLocationOnScreen : ([I)V
    //   704: aload #11
    //   706: iconst_0
    //   707: iaload
    //   708: aload #8
    //   710: iconst_0
    //   711: iaload
    //   712: isub
    //   713: istore #4
    //   715: aload #11
    //   717: iconst_1
    //   718: iaload
    //   719: aload #8
    //   721: iconst_1
    //   722: iaload
    //   723: isub
    //   724: istore_3
    //   725: aload_0
    //   726: getfield mDropDownGravity : I
    //   729: iconst_5
    //   730: iand
    //   731: iconst_5
    //   732: if_icmpne -> 760
    //   735: iload_2
    //   736: ifeq -> 748
    //   739: iload #4
    //   741: iload #5
    //   743: iadd
    //   744: istore_2
    //   745: goto -> 782
    //   748: iload #4
    //   750: aload #7
    //   752: invokevirtual getWidth : ()I
    //   755: isub
    //   756: istore_2
    //   757: goto -> 782
    //   760: iload_2
    //   761: ifeq -> 776
    //   764: iload #4
    //   766: aload #7
    //   768: invokevirtual getWidth : ()I
    //   771: iadd
    //   772: istore_2
    //   773: goto -> 782
    //   776: iload #4
    //   778: iload #5
    //   780: isub
    //   781: istore_2
    //   782: aload #9
    //   784: iload_2
    //   785: putfield mDropDownHorizontalOffset : I
    //   788: aload #9
    //   790: iconst_1
    //   791: putfield mOverlapAnchorSet : Z
    //   794: aload #9
    //   796: iconst_1
    //   797: putfield mOverlapAnchor : Z
    //   800: aload #9
    //   802: iload_3
    //   803: invokevirtual setVerticalOffset : (I)V
    //   806: goto -> 850
    //   809: aload_0
    //   810: getfield mHasXOffset : Z
    //   813: ifeq -> 825
    //   816: aload #9
    //   818: aload_0
    //   819: getfield mXOffset : I
    //   822: putfield mDropDownHorizontalOffset : I
    //   825: aload_0
    //   826: getfield mHasYOffset : Z
    //   829: ifeq -> 841
    //   832: aload #9
    //   834: aload_0
    //   835: getfield mYOffset : I
    //   838: invokevirtual setVerticalOffset : (I)V
    //   841: aload #9
    //   843: aload_0
    //   844: getfield mEpicenterBounds : Landroid/graphics/Rect;
    //   847: putfield mEpicenterBounds : Landroid/graphics/Rect;
    //   850: new android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   853: dup
    //   854: aload #9
    //   856: aload_1
    //   857: aload_0
    //   858: getfield mLastPosition : I
    //   861: invokespecial <init> : (Landroid/support/v7/widget/MenuPopupWindow;Landroid/support/v7/view/menu/MenuBuilder;I)V
    //   864: astore #7
    //   866: aload_0
    //   867: getfield mShowingMenus : Ljava/util/List;
    //   870: aload #7
    //   872: invokeinterface add : (Ljava/lang/Object;)Z
    //   877: pop
    //   878: aload #9
    //   880: invokevirtual show : ()V
    //   883: aload #9
    //   885: getfield mDropDownList : Landroid/support/v7/widget/DropDownListView;
    //   888: astore #7
    //   890: aload #7
    //   892: aload_0
    //   893: invokevirtual setOnKeyListener : (Landroid/view/View$OnKeyListener;)V
    //   896: aload #6
    //   898: ifnonnull -> 973
    //   901: aload_0
    //   902: getfield mShowTitle : Z
    //   905: ifeq -> 973
    //   908: aload_1
    //   909: getfield mHeaderTitle : Ljava/lang/CharSequence;
    //   912: ifnull -> 973
    //   915: aload #10
    //   917: getstatic android/support/v7/appcompat/R$layout.abc_popup_menu_header_item_layout : I
    //   920: aload #7
    //   922: iconst_0
    //   923: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   926: checkcast android/widget/FrameLayout
    //   929: astore #6
    //   931: aload #6
    //   933: ldc_w 16908310
    //   936: invokevirtual findViewById : (I)Landroid/view/View;
    //   939: checkcast android/widget/TextView
    //   942: astore #8
    //   944: aload #6
    //   946: iconst_0
    //   947: invokevirtual setEnabled : (Z)V
    //   950: aload #8
    //   952: aload_1
    //   953: getfield mHeaderTitle : Ljava/lang/CharSequence;
    //   956: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   959: aload #7
    //   961: aload #6
    //   963: aconst_null
    //   964: iconst_0
    //   965: invokevirtual addHeaderView : (Landroid/view/View;Ljava/lang/Object;Z)V
    //   968: aload #9
    //   970: invokevirtual show : ()V
    //   973: return
    // Exception table:
    //   from	to	target	type
    //   473	496	499	java/lang/Exception
  }
  
  public final void addMenu(MenuBuilder paramMenuBuilder) {
    paramMenuBuilder.addMenuPresenter(this, this.mContext);
    if (isShowing()) {
      showMenu(paramMenuBuilder);
      return;
    } 
    this.mPendingMenus.add(paramMenuBuilder);
  }
  
  protected final boolean closeMenuOnSubMenuOpened() {
    return false;
  }
  
  public final void dismiss() {
    int i = this.mShowingMenus.size();
    if (i > 0) {
      CascadingMenuPopup$CascadingMenuInfo[] arrayOfCascadingMenuPopup$CascadingMenuInfo = (CascadingMenuPopup$CascadingMenuInfo[])this.mShowingMenus.toArray((Object[])new CascadingMenuPopup$CascadingMenuInfo[i]);
      while (--i >= 0) {
        CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo = arrayOfCascadingMenuPopup$CascadingMenuInfo[i];
        if (((ListPopupWindow)cascadingMenuPopup$CascadingMenuInfo.window).mPopup.isShowing())
          cascadingMenuPopup$CascadingMenuInfo.window.dismiss(); 
        i--;
      } 
    } 
  }
  
  public final boolean flagActionItems() {
    return false;
  }
  
  public final ListView getListView() {
    return (ListView)(this.mShowingMenus.isEmpty() ? null : ((ListPopupWindow)((CascadingMenuPopup$CascadingMenuInfo)this.mShowingMenus.get(this.mShowingMenus.size() - 1)).window).mDropDownList);
  }
  
  public final boolean isShowing() {
    return (this.mShowingMenus.size() > 0 && ((ListPopupWindow)((CascadingMenuPopup$CascadingMenuInfo)this.mShowingMenus.get(0)).window).mPopup.isShowing());
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mShowingMenus : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: istore #4
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: iload #4
    //   16: if_icmpge -> 49
    //   19: aload_1
    //   20: aload_0
    //   21: getfield mShowingMenus : Ljava/util/List;
    //   24: iload_3
    //   25: invokeinterface get : (I)Ljava/lang/Object;
    //   30: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   33: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   36: if_acmpne -> 42
    //   39: goto -> 51
    //   42: iload_3
    //   43: iconst_1
    //   44: iadd
    //   45: istore_3
    //   46: goto -> 13
    //   49: iconst_m1
    //   50: istore_3
    //   51: iload_3
    //   52: ifge -> 56
    //   55: return
    //   56: iload_3
    //   57: iconst_1
    //   58: iadd
    //   59: istore #4
    //   61: iload #4
    //   63: aload_0
    //   64: getfield mShowingMenus : Ljava/util/List;
    //   67: invokeinterface size : ()I
    //   72: if_icmpge -> 96
    //   75: aload_0
    //   76: getfield mShowingMenus : Ljava/util/List;
    //   79: iload #4
    //   81: invokeinterface get : (I)Ljava/lang/Object;
    //   86: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   89: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   92: iconst_0
    //   93: invokevirtual close : (Z)V
    //   96: aload_0
    //   97: getfield mShowingMenus : Ljava/util/List;
    //   100: iload_3
    //   101: invokeinterface remove : (I)Ljava/lang/Object;
    //   106: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   109: astore #5
    //   111: aload #5
    //   113: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   116: astore #6
    //   118: aload #6
    //   120: getfield mPresenters : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   123: invokevirtual iterator : ()Ljava/util/Iterator;
    //   126: astore #7
    //   128: aload #7
    //   130: invokeinterface hasNext : ()Z
    //   135: ifeq -> 185
    //   138: aload #7
    //   140: invokeinterface next : ()Ljava/lang/Object;
    //   145: checkcast java/lang/ref/WeakReference
    //   148: astore #8
    //   150: aload #8
    //   152: invokevirtual get : ()Ljava/lang/Object;
    //   155: checkcast android/support/v7/view/menu/MenuPresenter
    //   158: astore #9
    //   160: aload #9
    //   162: ifnull -> 171
    //   165: aload #9
    //   167: aload_0
    //   168: if_acmpne -> 182
    //   171: aload #6
    //   173: getfield mPresenters : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   176: aload #8
    //   178: invokevirtual remove : (Ljava/lang/Object;)Z
    //   181: pop
    //   182: goto -> 128
    //   185: aload_0
    //   186: getfield mShouldCloseImmediately : Z
    //   189: ifeq -> 228
    //   192: aload #5
    //   194: getfield window : Landroid/support/v7/widget/MenuPopupWindow;
    //   197: astore #6
    //   199: getstatic android/os/Build$VERSION.SDK_INT : I
    //   202: bipush #23
    //   204: if_icmplt -> 216
    //   207: aload #6
    //   209: getfield mPopup : Landroid/widget/PopupWindow;
    //   212: aconst_null
    //   213: invokevirtual setExitTransition : (Landroid/transition/Transition;)V
    //   216: aload #5
    //   218: getfield window : Landroid/support/v7/widget/MenuPopupWindow;
    //   221: getfield mPopup : Landroid/widget/PopupWindow;
    //   224: iconst_0
    //   225: invokevirtual setAnimationStyle : (I)V
    //   228: aload #5
    //   230: getfield window : Landroid/support/v7/widget/MenuPopupWindow;
    //   233: invokevirtual dismiss : ()V
    //   236: aload_0
    //   237: getfield mShowingMenus : Ljava/util/List;
    //   240: invokeinterface size : ()I
    //   245: istore_3
    //   246: iload_3
    //   247: ifle -> 275
    //   250: aload_0
    //   251: aload_0
    //   252: getfield mShowingMenus : Ljava/util/List;
    //   255: iload_3
    //   256: iconst_1
    //   257: isub
    //   258: invokeinterface get : (I)Ljava/lang/Object;
    //   263: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   266: getfield position : I
    //   269: putfield mLastPosition : I
    //   272: goto -> 283
    //   275: aload_0
    //   276: aload_0
    //   277: invokespecial getInitialMenuPosition : ()I
    //   280: putfield mLastPosition : I
    //   283: iload_3
    //   284: ifne -> 363
    //   287: aload_0
    //   288: invokevirtual dismiss : ()V
    //   291: aload_0
    //   292: getfield mPresenterCallback : Landroid/support/v7/view/menu/MenuPresenter$Callback;
    //   295: ifnull -> 309
    //   298: aload_0
    //   299: getfield mPresenterCallback : Landroid/support/v7/view/menu/MenuPresenter$Callback;
    //   302: aload_1
    //   303: iconst_1
    //   304: invokeinterface onCloseMenu : (Landroid/support/v7/view/menu/MenuBuilder;Z)V
    //   309: aload_0
    //   310: getfield mTreeObserver : Landroid/view/ViewTreeObserver;
    //   313: ifnull -> 342
    //   316: aload_0
    //   317: getfield mTreeObserver : Landroid/view/ViewTreeObserver;
    //   320: invokevirtual isAlive : ()Z
    //   323: ifeq -> 337
    //   326: aload_0
    //   327: getfield mTreeObserver : Landroid/view/ViewTreeObserver;
    //   330: aload_0
    //   331: getfield mGlobalLayoutListener : Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    //   334: invokevirtual removeGlobalOnLayoutListener : (Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   337: aload_0
    //   338: aconst_null
    //   339: putfield mTreeObserver : Landroid/view/ViewTreeObserver;
    //   342: aload_0
    //   343: getfield mShownAnchorView : Landroid/view/View;
    //   346: aload_0
    //   347: getfield mAttachStateChangeListener : Landroid/view/View$OnAttachStateChangeListener;
    //   350: invokevirtual removeOnAttachStateChangeListener : (Landroid/view/View$OnAttachStateChangeListener;)V
    //   353: aload_0
    //   354: getfield mOnDismissListener : Landroid/widget/PopupWindow$OnDismissListener;
    //   357: invokeinterface onDismiss : ()V
    //   362: return
    //   363: iload_2
    //   364: ifeq -> 387
    //   367: aload_0
    //   368: getfield mShowingMenus : Ljava/util/List;
    //   371: iconst_0
    //   372: invokeinterface get : (I)Ljava/lang/Object;
    //   377: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   380: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   383: iconst_0
    //   384: invokevirtual close : (Z)V
    //   387: return
  }
  
  public final void onDismiss() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mShowingMenus : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpge -> 54
    //   17: aload_0
    //   18: getfield mShowingMenus : Ljava/util/List;
    //   21: iload_1
    //   22: invokeinterface get : (I)Ljava/lang/Object;
    //   27: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   30: astore_3
    //   31: aload_3
    //   32: getfield window : Landroid/support/v7/widget/MenuPopupWindow;
    //   35: getfield mPopup : Landroid/widget/PopupWindow;
    //   38: invokevirtual isShowing : ()Z
    //   41: ifne -> 47
    //   44: goto -> 56
    //   47: iload_1
    //   48: iconst_1
    //   49: iadd
    //   50: istore_1
    //   51: goto -> 12
    //   54: aconst_null
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull -> 68
    //   60: aload_3
    //   61: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   64: iconst_0
    //   65: invokevirtual close : (Z)V
    //   68: return
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1 && paramInt == 82) {
      dismiss();
      return true;
    } 
    return false;
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    for (CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo : this.mShowingMenus) {
      if (paramSubMenuBuilder == cascadingMenuPopup$CascadingMenuInfo.menu) {
        ((ListPopupWindow)cascadingMenuPopup$CascadingMenuInfo.window).mDropDownList.requestFocus();
        return true;
      } 
    } 
    if (paramSubMenuBuilder.hasVisibleItems()) {
      addMenu(paramSubMenuBuilder);
      if (this.mPresenterCallback != null)
        this.mPresenterCallback.onOpenSubMenu(paramSubMenuBuilder); 
      return true;
    } 
    return false;
  }
  
  public final void setAnchorView(View paramView) {
    if (this.mAnchorView != paramView) {
      this.mAnchorView = paramView;
      this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView));
    } 
  }
  
  public final void setCallback(MenuPresenter$Callback paramMenuPresenter$Callback) {
    this.mPresenterCallback = paramMenuPresenter$Callback;
  }
  
  public final void setForceShowIcon(boolean paramBoolean) {
    this.mForceShowIcon = paramBoolean;
  }
  
  public final void setGravity(int paramInt) {
    if (this.mRawDropDownGravity != paramInt) {
      this.mRawDropDownGravity = paramInt;
      this.mDropDownGravity = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this.mAnchorView));
    } 
  }
  
  public final void setHorizontalOffset(int paramInt) {
    this.mHasXOffset = true;
    this.mXOffset = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean) {
    this.mShowTitle = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt) {
    this.mHasYOffset = true;
    this.mYOffset = paramInt;
  }
  
  public final void show() {
    if (isShowing())
      return; 
    Iterator<MenuBuilder> iterator = this.mPendingMenus.iterator();
    while (iterator.hasNext())
      showMenu(iterator.next()); 
    this.mPendingMenus.clear();
    this.mShownAnchorView = this.mAnchorView;
    if (this.mShownAnchorView != null) {
      boolean bool;
      if (this.mTreeObserver == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
      if (bool)
        this.mTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener); 
      this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
    } 
  }
  
  public final void updateMenuView(boolean paramBoolean) {
    Iterator iterator = this.mShowingMenus.iterator();
    while (iterator.hasNext())
      toMenuAdapter(((ListPopupWindow)((CascadingMenuPopup$CascadingMenuInfo)iterator.next()).window).mDropDownList.getAdapter()).notifyDataSetChanged(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\CascadingMenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */