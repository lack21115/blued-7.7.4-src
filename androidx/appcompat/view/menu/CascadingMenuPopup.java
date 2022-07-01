package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener, MenuPresenter {
  private static final int g = R.layout.abc_cascading_menu_item_layout;
  
  private PopupWindow.OnDismissListener A;
  
  final Handler a;
  
  final List<CascadingMenuInfo> b = new ArrayList<CascadingMenuInfo>();
  
  final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener(this) {
      public void onGlobalLayout() {
        if (this.a.isShowing() && this.a.b.size() > 0 && !((CascadingMenuPopup.CascadingMenuInfo)this.a.b.get(0)).window.isModal()) {
          View view = this.a.d;
          if (view == null || !view.isShown()) {
            this.a.dismiss();
            return;
          } 
          Iterator<CascadingMenuPopup.CascadingMenuInfo> iterator = this.a.b.iterator();
          while (iterator.hasNext())
            ((CascadingMenuPopup.CascadingMenuInfo)iterator.next()).window.show(); 
        } 
      }
    };
  
  View d;
  
  ViewTreeObserver e;
  
  boolean f;
  
  private final Context h;
  
  private final int i;
  
  private final int j;
  
  private final int k;
  
  private final boolean l;
  
  private final List<MenuBuilder> m = new ArrayList<MenuBuilder>();
  
  private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener(this) {
      public void onViewAttachedToWindow(View param1View) {}
      
      public void onViewDetachedFromWindow(View param1View) {
        if (this.a.e != null) {
          if (!this.a.e.isAlive())
            this.a.e = param1View.getViewTreeObserver(); 
          this.a.e.removeGlobalOnLayoutListener(this.a.c);
        } 
        param1View.removeOnAttachStateChangeListener(this);
      }
    };
  
  private final MenuItemHoverListener o = new MenuItemHoverListener(this) {
      public void onItemHoverEnter(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
        // Byte code:
        //   0: aload_0
        //   1: getfield a : Landroidx/appcompat/view/menu/CascadingMenuPopup;
        //   4: getfield a : Landroid/os/Handler;
        //   7: astore #8
        //   9: aconst_null
        //   10: astore #7
        //   12: aload #8
        //   14: aconst_null
        //   15: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
        //   18: aload_0
        //   19: getfield a : Landroidx/appcompat/view/menu/CascadingMenuPopup;
        //   22: getfield b : Ljava/util/List;
        //   25: invokeinterface size : ()I
        //   30: istore #4
        //   32: iconst_0
        //   33: istore_3
        //   34: iload_3
        //   35: iload #4
        //   37: if_icmpge -> 73
        //   40: aload_1
        //   41: aload_0
        //   42: getfield a : Landroidx/appcompat/view/menu/CascadingMenuPopup;
        //   45: getfield b : Ljava/util/List;
        //   48: iload_3
        //   49: invokeinterface get : (I)Ljava/lang/Object;
        //   54: checkcast androidx/appcompat/view/menu/CascadingMenuPopup$CascadingMenuInfo
        //   57: getfield menu : Landroidx/appcompat/view/menu/MenuBuilder;
        //   60: if_acmpne -> 66
        //   63: goto -> 75
        //   66: iload_3
        //   67: iconst_1
        //   68: iadd
        //   69: istore_3
        //   70: goto -> 34
        //   73: iconst_m1
        //   74: istore_3
        //   75: iload_3
        //   76: iconst_m1
        //   77: if_icmpne -> 81
        //   80: return
        //   81: iload_3
        //   82: iconst_1
        //   83: iadd
        //   84: istore_3
        //   85: iload_3
        //   86: aload_0
        //   87: getfield a : Landroidx/appcompat/view/menu/CascadingMenuPopup;
        //   90: getfield b : Ljava/util/List;
        //   93: invokeinterface size : ()I
        //   98: if_icmpge -> 119
        //   101: aload_0
        //   102: getfield a : Landroidx/appcompat/view/menu/CascadingMenuPopup;
        //   105: getfield b : Ljava/util/List;
        //   108: iload_3
        //   109: invokeinterface get : (I)Ljava/lang/Object;
        //   114: checkcast androidx/appcompat/view/menu/CascadingMenuPopup$CascadingMenuInfo
        //   117: astore #7
        //   119: new androidx/appcompat/view/menu/CascadingMenuPopup$3$1
        //   122: dup
        //   123: aload_0
        //   124: aload #7
        //   126: aload_2
        //   127: aload_1
        //   128: invokespecial <init> : (Landroidx/appcompat/view/menu/CascadingMenuPopup$3;Landroidx/appcompat/view/menu/CascadingMenuPopup$CascadingMenuInfo;Landroid/view/MenuItem;Landroidx/appcompat/view/menu/MenuBuilder;)V
        //   131: astore_2
        //   132: invokestatic uptimeMillis : ()J
        //   135: lstore #5
        //   137: aload_0
        //   138: getfield a : Landroidx/appcompat/view/menu/CascadingMenuPopup;
        //   141: getfield a : Landroid/os/Handler;
        //   144: aload_2
        //   145: aload_1
        //   146: lload #5
        //   148: ldc2_w 200
        //   151: ladd
        //   152: invokevirtual postAtTime : (Ljava/lang/Runnable;Ljava/lang/Object;J)Z
        //   155: pop
        //   156: return
      }
      
      public void onItemHoverExit(MenuBuilder param1MenuBuilder, MenuItem param1MenuItem) {
        this.a.a.removeCallbacksAndMessages(param1MenuBuilder);
      }
    };
  
  private int p = 0;
  
  private int q = 0;
  
  private View r;
  
  private int s;
  
  private boolean t;
  
  private boolean u;
  
  private int v;
  
  private int w;
  
  private boolean x;
  
  private boolean y;
  
  private MenuPresenter.Callback z;
  
  public CascadingMenuPopup(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    this.h = paramContext;
    this.r = paramView;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramBoolean;
    this.x = false;
    this.s = c();
    Resources resources = paramContext.getResources();
    this.i = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.a = new Handler();
  }
  
  private int a(int paramInt) {
    List<CascadingMenuInfo> list = this.b;
    ListView listView = ((CascadingMenuInfo)list.get(list.size() - 1)).getListView();
    int[] arrayOfInt = new int[2];
    listView.getLocationOnScreen(arrayOfInt);
    Rect rect = new Rect();
    this.d.getWindowVisibleDisplayFrame(rect);
    return (this.s == 1) ? ((arrayOfInt[0] + listView.getWidth() + paramInt > rect.right) ? 0 : 1) : ((arrayOfInt[0] - paramInt < 0) ? 1 : 0);
  }
  
  private MenuItem a(MenuBuilder paramMenuBuilder1, MenuBuilder paramMenuBuilder2) {
    int j = paramMenuBuilder1.size();
    for (int i = 0; i < j; i++) {
      MenuItem menuItem = paramMenuBuilder1.getItem(i);
      if (menuItem.hasSubMenu() && paramMenuBuilder2 == menuItem.getSubMenu())
        return menuItem; 
    } 
    return null;
  }
  
  private View a(CascadingMenuInfo paramCascadingMenuInfo, MenuBuilder paramMenuBuilder) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getfield menu : Landroidx/appcompat/view/menu/MenuBuilder;
    //   5: aload_2
    //   6: invokespecial a : (Landroidx/appcompat/view/menu/MenuBuilder;Landroidx/appcompat/view/menu/MenuBuilder;)Landroid/view/MenuItem;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokevirtual getListView : ()Landroid/widget/ListView;
    //   20: astore #7
    //   22: aload #7
    //   24: invokevirtual getAdapter : ()Landroid/widget/ListAdapter;
    //   27: astore_1
    //   28: aload_1
    //   29: instanceof android/widget/HeaderViewListAdapter
    //   32: istore #6
    //   34: iconst_0
    //   35: istore_3
    //   36: iload #6
    //   38: ifeq -> 63
    //   41: aload_1
    //   42: checkcast android/widget/HeaderViewListAdapter
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual getHeadersCount : ()I
    //   50: istore #4
    //   52: aload_1
    //   53: invokevirtual getWrappedAdapter : ()Landroid/widget/ListAdapter;
    //   56: checkcast androidx/appcompat/view/menu/MenuAdapter
    //   59: astore_1
    //   60: goto -> 71
    //   63: aload_1
    //   64: checkcast androidx/appcompat/view/menu/MenuAdapter
    //   67: astore_1
    //   68: iconst_0
    //   69: istore #4
    //   71: aload_1
    //   72: invokevirtual getCount : ()I
    //   75: istore #5
    //   77: iload_3
    //   78: iload #5
    //   80: if_icmpge -> 102
    //   83: aload_2
    //   84: aload_1
    //   85: iload_3
    //   86: invokevirtual getItem : (I)Landroidx/appcompat/view/menu/MenuItemImpl;
    //   89: if_acmpne -> 95
    //   92: goto -> 104
    //   95: iload_3
    //   96: iconst_1
    //   97: iadd
    //   98: istore_3
    //   99: goto -> 77
    //   102: iconst_m1
    //   103: istore_3
    //   104: iload_3
    //   105: iconst_m1
    //   106: if_icmpne -> 111
    //   109: aconst_null
    //   110: areturn
    //   111: iload_3
    //   112: iload #4
    //   114: iadd
    //   115: aload #7
    //   117: invokevirtual getFirstVisiblePosition : ()I
    //   120: isub
    //   121: istore_3
    //   122: iload_3
    //   123: iflt -> 144
    //   126: iload_3
    //   127: aload #7
    //   129: invokevirtual getChildCount : ()I
    //   132: if_icmplt -> 137
    //   135: aconst_null
    //   136: areturn
    //   137: aload #7
    //   139: iload_3
    //   140: invokevirtual getChildAt : (I)Landroid/view/View;
    //   143: areturn
    //   144: aconst_null
    //   145: areturn
  }
  
  private MenuPopupWindow b() {
    MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.h, null, this.j, this.k);
    menuPopupWindow.setHoverListener(this.o);
    menuPopupWindow.setOnItemClickListener(this);
    menuPopupWindow.setOnDismissListener(this);
    menuPopupWindow.setAnchorView(this.r);
    menuPopupWindow.setDropDownGravity(this.q);
    menuPopupWindow.setModal(true);
    menuPopupWindow.setInputMethodMode(2);
    return menuPopupWindow;
  }
  
  private void b(MenuBuilder paramMenuBuilder) {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Landroid/content/Context;
    //   4: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   7: astore #9
    //   9: new androidx/appcompat/view/menu/MenuAdapter
    //   12: dup
    //   13: aload_1
    //   14: aload #9
    //   16: aload_0
    //   17: getfield l : Z
    //   20: getstatic androidx/appcompat/view/menu/CascadingMenuPopup.g : I
    //   23: invokespecial <init> : (Landroidx/appcompat/view/menu/MenuBuilder;Landroid/view/LayoutInflater;ZI)V
    //   26: astore #6
    //   28: aload_0
    //   29: invokevirtual isShowing : ()Z
    //   32: ifne -> 51
    //   35: aload_0
    //   36: getfield x : Z
    //   39: ifeq -> 51
    //   42: aload #6
    //   44: iconst_1
    //   45: invokevirtual setForceShowIcon : (Z)V
    //   48: goto -> 67
    //   51: aload_0
    //   52: invokevirtual isShowing : ()Z
    //   55: ifeq -> 67
    //   58: aload #6
    //   60: aload_1
    //   61: invokestatic a : (Landroidx/appcompat/view/menu/MenuBuilder;)Z
    //   64: invokevirtual setForceShowIcon : (Z)V
    //   67: aload #6
    //   69: aconst_null
    //   70: aload_0
    //   71: getfield h : Landroid/content/Context;
    //   74: aload_0
    //   75: getfield i : I
    //   78: invokestatic a : (Landroid/widget/ListAdapter;Landroid/view/ViewGroup;Landroid/content/Context;I)I
    //   81: istore_3
    //   82: aload_0
    //   83: invokespecial b : ()Landroidx/appcompat/widget/MenuPopupWindow;
    //   86: astore #8
    //   88: aload #8
    //   90: aload #6
    //   92: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   95: aload #8
    //   97: iload_3
    //   98: invokevirtual setContentWidth : (I)V
    //   101: aload #8
    //   103: aload_0
    //   104: getfield q : I
    //   107: invokevirtual setDropDownGravity : (I)V
    //   110: aload_0
    //   111: getfield b : Ljava/util/List;
    //   114: invokeinterface size : ()I
    //   119: ifle -> 161
    //   122: aload_0
    //   123: getfield b : Ljava/util/List;
    //   126: astore #6
    //   128: aload #6
    //   130: aload #6
    //   132: invokeinterface size : ()I
    //   137: iconst_1
    //   138: isub
    //   139: invokeinterface get : (I)Ljava/lang/Object;
    //   144: checkcast androidx/appcompat/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   147: astore #6
    //   149: aload_0
    //   150: aload #6
    //   152: aload_1
    //   153: invokespecial a : (Landroidx/appcompat/view/menu/CascadingMenuPopup$CascadingMenuInfo;Landroidx/appcompat/view/menu/MenuBuilder;)Landroid/view/View;
    //   156: astore #7
    //   158: goto -> 168
    //   161: aconst_null
    //   162: astore #6
    //   164: aload #6
    //   166: astore #7
    //   168: aload #7
    //   170: ifnull -> 393
    //   173: aload #8
    //   175: iconst_0
    //   176: invokevirtual setTouchModal : (Z)V
    //   179: aload #8
    //   181: aconst_null
    //   182: invokevirtual setEnterTransition : (Ljava/lang/Object;)V
    //   185: aload_0
    //   186: iload_3
    //   187: invokespecial a : (I)I
    //   190: istore_2
    //   191: iload_2
    //   192: iconst_1
    //   193: if_icmpne -> 202
    //   196: iconst_1
    //   197: istore #4
    //   199: goto -> 205
    //   202: iconst_0
    //   203: istore #4
    //   205: aload_0
    //   206: iload_2
    //   207: putfield s : I
    //   210: getstatic android/os/Build$VERSION.SDK_INT : I
    //   213: bipush #26
    //   215: if_icmplt -> 233
    //   218: aload #8
    //   220: aload #7
    //   222: invokevirtual setAnchorView : (Landroid/view/View;)V
    //   225: iconst_0
    //   226: istore_2
    //   227: iconst_0
    //   228: istore #5
    //   230: goto -> 321
    //   233: iconst_2
    //   234: newarray int
    //   236: astore #10
    //   238: aload_0
    //   239: getfield r : Landroid/view/View;
    //   242: aload #10
    //   244: invokevirtual getLocationOnScreen : ([I)V
    //   247: iconst_2
    //   248: newarray int
    //   250: astore #11
    //   252: aload #7
    //   254: aload #11
    //   256: invokevirtual getLocationOnScreen : ([I)V
    //   259: aload_0
    //   260: getfield q : I
    //   263: bipush #7
    //   265: iand
    //   266: iconst_5
    //   267: if_icmpne -> 300
    //   270: aload #10
    //   272: iconst_0
    //   273: aload #10
    //   275: iconst_0
    //   276: iaload
    //   277: aload_0
    //   278: getfield r : Landroid/view/View;
    //   281: invokevirtual getWidth : ()I
    //   284: iadd
    //   285: iastore
    //   286: aload #11
    //   288: iconst_0
    //   289: aload #11
    //   291: iconst_0
    //   292: iaload
    //   293: aload #7
    //   295: invokevirtual getWidth : ()I
    //   298: iadd
    //   299: iastore
    //   300: aload #11
    //   302: iconst_0
    //   303: iaload
    //   304: aload #10
    //   306: iconst_0
    //   307: iaload
    //   308: isub
    //   309: istore #5
    //   311: aload #11
    //   313: iconst_1
    //   314: iaload
    //   315: aload #10
    //   317: iconst_1
    //   318: iaload
    //   319: isub
    //   320: istore_2
    //   321: aload_0
    //   322: getfield q : I
    //   325: iconst_5
    //   326: iand
    //   327: iconst_5
    //   328: if_icmpne -> 348
    //   331: iload #4
    //   333: ifeq -> 339
    //   336: goto -> 359
    //   339: aload #7
    //   341: invokevirtual getWidth : ()I
    //   344: istore_3
    //   345: goto -> 367
    //   348: iload #4
    //   350: ifeq -> 367
    //   353: aload #7
    //   355: invokevirtual getWidth : ()I
    //   358: istore_3
    //   359: iload #5
    //   361: iload_3
    //   362: iadd
    //   363: istore_3
    //   364: goto -> 372
    //   367: iload #5
    //   369: iload_3
    //   370: isub
    //   371: istore_3
    //   372: aload #8
    //   374: iload_3
    //   375: invokevirtual setHorizontalOffset : (I)V
    //   378: aload #8
    //   380: iconst_1
    //   381: invokevirtual setOverlapAnchor : (Z)V
    //   384: aload #8
    //   386: iload_2
    //   387: invokevirtual setVerticalOffset : (I)V
    //   390: goto -> 434
    //   393: aload_0
    //   394: getfield t : Z
    //   397: ifeq -> 409
    //   400: aload #8
    //   402: aload_0
    //   403: getfield v : I
    //   406: invokevirtual setHorizontalOffset : (I)V
    //   409: aload_0
    //   410: getfield u : Z
    //   413: ifeq -> 425
    //   416: aload #8
    //   418: aload_0
    //   419: getfield w : I
    //   422: invokevirtual setVerticalOffset : (I)V
    //   425: aload #8
    //   427: aload_0
    //   428: invokevirtual getEpicenterBounds : ()Landroid/graphics/Rect;
    //   431: invokevirtual setEpicenterBounds : (Landroid/graphics/Rect;)V
    //   434: new androidx/appcompat/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   437: dup
    //   438: aload #8
    //   440: aload_1
    //   441: aload_0
    //   442: getfield s : I
    //   445: invokespecial <init> : (Landroidx/appcompat/widget/MenuPopupWindow;Landroidx/appcompat/view/menu/MenuBuilder;I)V
    //   448: astore #7
    //   450: aload_0
    //   451: getfield b : Ljava/util/List;
    //   454: aload #7
    //   456: invokeinterface add : (Ljava/lang/Object;)Z
    //   461: pop
    //   462: aload #8
    //   464: invokevirtual show : ()V
    //   467: aload #8
    //   469: invokevirtual getListView : ()Landroid/widget/ListView;
    //   472: astore #7
    //   474: aload #7
    //   476: aload_0
    //   477: invokevirtual setOnKeyListener : (Landroid/view/View$OnKeyListener;)V
    //   480: aload #6
    //   482: ifnonnull -> 557
    //   485: aload_0
    //   486: getfield y : Z
    //   489: ifeq -> 557
    //   492: aload_1
    //   493: invokevirtual getHeaderTitle : ()Ljava/lang/CharSequence;
    //   496: ifnull -> 557
    //   499: aload #9
    //   501: getstatic androidx/appcompat/R$layout.abc_popup_menu_header_item_layout : I
    //   504: aload #7
    //   506: iconst_0
    //   507: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   510: checkcast android/widget/FrameLayout
    //   513: astore #6
    //   515: aload #6
    //   517: ldc_w 16908310
    //   520: invokevirtual findViewById : (I)Landroid/view/View;
    //   523: checkcast android/widget/TextView
    //   526: astore #9
    //   528: aload #6
    //   530: iconst_0
    //   531: invokevirtual setEnabled : (Z)V
    //   534: aload #9
    //   536: aload_1
    //   537: invokevirtual getHeaderTitle : ()Ljava/lang/CharSequence;
    //   540: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   543: aload #7
    //   545: aload #6
    //   547: aconst_null
    //   548: iconst_0
    //   549: invokevirtual addHeaderView : (Landroid/view/View;Ljava/lang/Object;Z)V
    //   552: aload #8
    //   554: invokevirtual show : ()V
    //   557: return
  }
  
  private int c() {
    int i = ViewCompat.getLayoutDirection(this.r);
    boolean bool = true;
    if (i == 1)
      bool = false; 
    return bool;
  }
  
  private int c(MenuBuilder paramMenuBuilder) {
    int j = this.b.size();
    for (int i = 0; i < j; i++) {
      if (paramMenuBuilder == ((CascadingMenuInfo)this.b.get(i)).menu)
        return i; 
    } 
    return -1;
  }
  
  protected boolean a() {
    return false;
  }
  
  public void addMenu(MenuBuilder paramMenuBuilder) {
    paramMenuBuilder.addMenuPresenter(this, this.h);
    if (isShowing()) {
      b(paramMenuBuilder);
      return;
    } 
    this.m.add(paramMenuBuilder);
  }
  
  public void dismiss() {
    int i = this.b.size();
    if (i > 0) {
      CascadingMenuInfo[] arrayOfCascadingMenuInfo = this.b.<CascadingMenuInfo>toArray(new CascadingMenuInfo[i]);
      while (--i >= 0) {
        CascadingMenuInfo cascadingMenuInfo = arrayOfCascadingMenuInfo[i];
        if (cascadingMenuInfo.window.isShowing())
          cascadingMenuInfo.window.dismiss(); 
        i--;
      } 
    } 
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public ListView getListView() {
    if (this.b.isEmpty())
      return null; 
    List<CascadingMenuInfo> list = this.b;
    return ((CascadingMenuInfo)list.get(list.size() - 1)).getListView();
  }
  
  public boolean isShowing() {
    int i = this.b.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0) {
      bool1 = bool2;
      if (((CascadingMenuInfo)this.b.get(0)).window.isShowing())
        bool1 = true; 
    } 
    return bool1;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    int i = c(paramMenuBuilder);
    if (i < 0)
      return; 
    int j = i + 1;
    if (j < this.b.size())
      ((CascadingMenuInfo)this.b.get(j)).menu.close(false); 
    CascadingMenuInfo cascadingMenuInfo = this.b.remove(i);
    cascadingMenuInfo.menu.removeMenuPresenter(this);
    if (this.f) {
      cascadingMenuInfo.window.setExitTransition(null);
      cascadingMenuInfo.window.setAnimationStyle(0);
    } 
    cascadingMenuInfo.window.dismiss();
    i = this.b.size();
    if (i > 0) {
      this.s = ((CascadingMenuInfo)this.b.get(i - 1)).position;
    } else {
      this.s = c();
    } 
    if (i == 0) {
      dismiss();
      MenuPresenter.Callback callback = this.z;
      if (callback != null)
        callback.onCloseMenu(paramMenuBuilder, true); 
      ViewTreeObserver viewTreeObserver = this.e;
      if (viewTreeObserver != null) {
        if (viewTreeObserver.isAlive())
          this.e.removeGlobalOnLayoutListener(this.c); 
        this.e = null;
      } 
      this.d.removeOnAttachStateChangeListener(this.n);
      this.A.onDismiss();
      return;
    } 
    if (paramBoolean)
      ((CascadingMenuInfo)this.b.get(0)).menu.close(false); 
  }
  
  public void onDismiss() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpge -> 51
    //   17: aload_0
    //   18: getfield b : Ljava/util/List;
    //   21: iload_1
    //   22: invokeinterface get : (I)Ljava/lang/Object;
    //   27: checkcast androidx/appcompat/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   30: astore_3
    //   31: aload_3
    //   32: getfield window : Landroidx/appcompat/widget/MenuPopupWindow;
    //   35: invokevirtual isShowing : ()Z
    //   38: ifne -> 44
    //   41: goto -> 53
    //   44: iload_1
    //   45: iconst_1
    //   46: iadd
    //   47: istore_1
    //   48: goto -> 12
    //   51: aconst_null
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull -> 65
    //   57: aload_3
    //   58: getfield menu : Landroidx/appcompat/view/menu/MenuBuilder;
    //   61: iconst_0
    //   62: invokevirtual close : (Z)V
    //   65: return
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1 && paramInt == 82) {
      dismiss();
      return true;
    } 
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState() {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    for (CascadingMenuInfo cascadingMenuInfo : this.b) {
      if (paramSubMenuBuilder == cascadingMenuInfo.menu) {
        cascadingMenuInfo.getListView().requestFocus();
        return true;
      } 
    } 
    if (paramSubMenuBuilder.hasVisibleItems()) {
      addMenu(paramSubMenuBuilder);
      MenuPresenter.Callback callback = this.z;
      if (callback != null)
        callback.onOpenSubMenu(paramSubMenuBuilder); 
      return true;
    } 
    return false;
  }
  
  public void setAnchorView(View paramView) {
    if (this.r != paramView) {
      this.r = paramView;
      this.q = GravityCompat.getAbsoluteGravity(this.p, ViewCompat.getLayoutDirection(this.r));
    } 
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {
    this.z = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.x = paramBoolean;
  }
  
  public void setGravity(int paramInt) {
    if (this.p != paramInt) {
      this.p = paramInt;
      this.q = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this.r));
    } 
  }
  
  public void setHorizontalOffset(int paramInt) {
    this.t = true;
    this.v = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.A = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean) {
    this.y = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt) {
    this.u = true;
    this.w = paramInt;
  }
  
  public void show() {
    if (isShowing())
      return; 
    Iterator<MenuBuilder> iterator = this.m.iterator();
    while (iterator.hasNext())
      b(iterator.next()); 
    this.m.clear();
    this.d = this.r;
    if (this.d != null) {
      boolean bool;
      if (this.e == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.e = this.d.getViewTreeObserver();
      if (bool)
        this.e.addOnGlobalLayoutListener(this.c); 
      this.d.addOnAttachStateChangeListener(this.n);
    } 
  }
  
  public void updateMenuView(boolean paramBoolean) {
    Iterator<CascadingMenuInfo> iterator = this.b.iterator();
    while (iterator.hasNext())
      a(((CascadingMenuInfo)iterator.next()).getListView().getAdapter()).notifyDataSetChanged(); 
  }
  
  static class CascadingMenuInfo {
    public final MenuBuilder menu;
    
    public final int position;
    
    public final MenuPopupWindow window;
    
    public CascadingMenuInfo(MenuPopupWindow param1MenuPopupWindow, MenuBuilder param1MenuBuilder, int param1Int) {
      this.window = param1MenuPopupWindow;
      this.menu = param1MenuBuilder;
      this.position = param1Int;
    }
    
    public ListView getListView() {
      return this.window.getListView();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HorizPosition {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\CascadingMenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */