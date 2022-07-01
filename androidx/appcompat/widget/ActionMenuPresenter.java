package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
  OverflowMenuButton g;
  
  OverflowPopup h;
  
  ActionButtonSubmenu i;
  
  OpenOverflowRunnable j;
  
  final PopupPresenterCallback k = new PopupPresenterCallback(this);
  
  int l;
  
  private Drawable m;
  
  private boolean n;
  
  private boolean o;
  
  private boolean p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private boolean w;
  
  private int x;
  
  private final SparseBooleanArray y = new SparseBooleanArray();
  
  private ActionMenuPopupCallback z;
  
  public ActionMenuPresenter(Context paramContext) {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View a(MenuItem paramMenuItem) {
    ViewGroup viewGroup = (ViewGroup)this.f;
    if (viewGroup == null)
      return null; 
    int j = viewGroup.getChildCount();
    for (int i = 0; i < j; i++) {
      View view = viewGroup.getChildAt(i);
      if (view instanceof MenuView.ItemView && ((MenuView.ItemView)view).getItemData() == paramMenuItem)
        return view; 
    } 
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView) {
    paramItemView.initialize(paramMenuItemImpl, 0);
    ActionMenuView actionMenuView = (ActionMenuView)this.f;
    ActionMenuItemView actionMenuItemView = (ActionMenuItemView)paramItemView;
    actionMenuItemView.setItemInvoker(actionMenuView);
    if (this.z == null)
      this.z = new ActionMenuPopupCallback(this); 
    actionMenuItemView.setPopupCallback(this.z);
  }
  
  public boolean dismissPopupMenus() {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt) {
    return (paramViewGroup.getChildAt(paramInt) == this.g) ? false : super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems() {
    // Byte code:
    //   0: aload_0
    //   1: astore #18
    //   3: aload #18
    //   5: getfield c : Landroidx/appcompat/view/menu/MenuBuilder;
    //   8: ifnull -> 31
    //   11: aload #18
    //   13: getfield c : Landroidx/appcompat/view/menu/MenuBuilder;
    //   16: invokevirtual getVisibleItems : ()Ljava/util/ArrayList;
    //   19: astore #17
    //   21: aload #17
    //   23: invokevirtual size : ()I
    //   26: istore #4
    //   28: goto -> 37
    //   31: aconst_null
    //   32: astore #17
    //   34: iconst_0
    //   35: istore #4
    //   37: aload #18
    //   39: getfield s : I
    //   42: istore_1
    //   43: aload #18
    //   45: getfield r : I
    //   48: istore #9
    //   50: iconst_0
    //   51: iconst_0
    //   52: invokestatic makeMeasureSpec : (II)I
    //   55: istore #11
    //   57: aload #18
    //   59: getfield f : Landroidx/appcompat/view/menu/MenuView;
    //   62: checkcast android/view/ViewGroup
    //   65: astore #19
    //   67: iconst_0
    //   68: istore #5
    //   70: iconst_0
    //   71: istore #6
    //   73: iconst_0
    //   74: istore_2
    //   75: iconst_0
    //   76: istore_3
    //   77: iload #5
    //   79: iload #4
    //   81: if_icmpge -> 166
    //   84: aload #17
    //   86: iload #5
    //   88: invokevirtual get : (I)Ljava/lang/Object;
    //   91: checkcast androidx/appcompat/view/menu/MenuItemImpl
    //   94: astore #20
    //   96: aload #20
    //   98: invokevirtual requiresActionButton : ()Z
    //   101: ifeq -> 111
    //   104: iload_2
    //   105: iconst_1
    //   106: iadd
    //   107: istore_2
    //   108: goto -> 129
    //   111: aload #20
    //   113: invokevirtual requestsActionButton : ()Z
    //   116: ifeq -> 126
    //   119: iload_3
    //   120: iconst_1
    //   121: iadd
    //   122: istore_3
    //   123: goto -> 129
    //   126: iconst_1
    //   127: istore #6
    //   129: iload_1
    //   130: istore #7
    //   132: aload #18
    //   134: getfield w : Z
    //   137: ifeq -> 154
    //   140: iload_1
    //   141: istore #7
    //   143: aload #20
    //   145: invokevirtual isActionViewExpanded : ()Z
    //   148: ifeq -> 154
    //   151: iconst_0
    //   152: istore #7
    //   154: iload #5
    //   156: iconst_1
    //   157: iadd
    //   158: istore #5
    //   160: iload #7
    //   162: istore_1
    //   163: goto -> 77
    //   166: iload_1
    //   167: istore #5
    //   169: aload #18
    //   171: getfield o : Z
    //   174: ifeq -> 197
    //   177: iload #6
    //   179: ifne -> 192
    //   182: iload_1
    //   183: istore #5
    //   185: iload_3
    //   186: iload_2
    //   187: iadd
    //   188: iload_1
    //   189: if_icmple -> 197
    //   192: iload_1
    //   193: iconst_1
    //   194: isub
    //   195: istore #5
    //   197: iload #5
    //   199: iload_2
    //   200: isub
    //   201: istore_1
    //   202: aload #18
    //   204: getfield y : Landroid/util/SparseBooleanArray;
    //   207: astore #20
    //   209: aload #20
    //   211: invokevirtual clear : ()V
    //   214: aload #18
    //   216: getfield u : Z
    //   219: ifeq -> 246
    //   222: aload #18
    //   224: getfield x : I
    //   227: istore_2
    //   228: iload #9
    //   230: iload_2
    //   231: idiv
    //   232: istore_3
    //   233: iload_2
    //   234: iload #9
    //   236: iload_2
    //   237: irem
    //   238: iload_3
    //   239: idiv
    //   240: iadd
    //   241: istore #8
    //   243: goto -> 251
    //   246: iconst_0
    //   247: istore #8
    //   249: iconst_0
    //   250: istore_3
    //   251: iload #9
    //   253: istore #5
    //   255: iconst_0
    //   256: istore #10
    //   258: iconst_0
    //   259: istore_2
    //   260: iload #4
    //   262: istore #9
    //   264: aload_0
    //   265: astore #18
    //   267: iload #10
    //   269: iload #9
    //   271: if_icmpge -> 758
    //   274: aload #17
    //   276: iload #10
    //   278: invokevirtual get : (I)Ljava/lang/Object;
    //   281: checkcast androidx/appcompat/view/menu/MenuItemImpl
    //   284: astore #21
    //   286: aload #21
    //   288: invokevirtual requiresActionButton : ()Z
    //   291: ifeq -> 403
    //   294: aload #18
    //   296: aload #21
    //   298: aconst_null
    //   299: aload #19
    //   301: invokevirtual getItemView : (Landroidx/appcompat/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   304: astore #22
    //   306: aload #18
    //   308: getfield u : Z
    //   311: ifeq -> 331
    //   314: iload_3
    //   315: aload #22
    //   317: iload #8
    //   319: iload_3
    //   320: iload #11
    //   322: iconst_0
    //   323: invokestatic a : (Landroid/view/View;IIII)I
    //   326: isub
    //   327: istore_3
    //   328: goto -> 340
    //   331: aload #22
    //   333: iload #11
    //   335: iload #11
    //   337: invokevirtual measure : (II)V
    //   340: aload #22
    //   342: invokevirtual getMeasuredWidth : ()I
    //   345: istore #4
    //   347: iload #5
    //   349: iload #4
    //   351: isub
    //   352: istore #6
    //   354: iload_2
    //   355: ifne -> 364
    //   358: iload #4
    //   360: istore_2
    //   361: goto -> 364
    //   364: aload #21
    //   366: invokevirtual getGroupId : ()I
    //   369: istore #4
    //   371: iload #4
    //   373: ifeq -> 384
    //   376: aload #20
    //   378: iload #4
    //   380: iconst_1
    //   381: invokevirtual put : (IZ)V
    //   384: aload #21
    //   386: iconst_1
    //   387: invokevirtual setIsActionButton : (Z)V
    //   390: iload_2
    //   391: istore #4
    //   393: iload #6
    //   395: istore #5
    //   397: iload #4
    //   399: istore_2
    //   400: goto -> 749
    //   403: aload #21
    //   405: invokevirtual requestsActionButton : ()Z
    //   408: ifeq -> 743
    //   411: aload #21
    //   413: invokevirtual getGroupId : ()I
    //   416: istore #12
    //   418: aload #20
    //   420: iload #12
    //   422: invokevirtual get : (I)Z
    //   425: istore #16
    //   427: iload_1
    //   428: ifgt -> 436
    //   431: iload #16
    //   433: ifeq -> 459
    //   436: iload #5
    //   438: ifle -> 459
    //   441: aload #18
    //   443: getfield u : Z
    //   446: ifeq -> 453
    //   449: iload_3
    //   450: ifle -> 459
    //   453: iconst_1
    //   454: istore #13
    //   456: goto -> 462
    //   459: iconst_0
    //   460: istore #13
    //   462: iload #13
    //   464: istore #14
    //   466: iload #13
    //   468: istore #15
    //   470: iload_3
    //   471: istore #7
    //   473: iload #5
    //   475: istore #6
    //   477: iload_2
    //   478: istore #4
    //   480: iload #13
    //   482: ifeq -> 619
    //   485: aload #18
    //   487: aload #21
    //   489: aconst_null
    //   490: aload #19
    //   492: invokevirtual getItemView : (Landroidx/appcompat/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   495: astore #22
    //   497: aload #18
    //   499: getfield u : Z
    //   502: ifeq -> 541
    //   505: aload #22
    //   507: iload #8
    //   509: iload_3
    //   510: iload #11
    //   512: iconst_0
    //   513: invokestatic a : (Landroid/view/View;IIII)I
    //   516: istore #4
    //   518: iload_3
    //   519: iload #4
    //   521: isub
    //   522: istore_3
    //   523: iload #4
    //   525: ifne -> 534
    //   528: iconst_0
    //   529: istore #13
    //   531: goto -> 538
    //   534: iload #14
    //   536: istore #13
    //   538: goto -> 554
    //   541: aload #22
    //   543: iload #11
    //   545: iload #11
    //   547: invokevirtual measure : (II)V
    //   550: iload #14
    //   552: istore #13
    //   554: aload #22
    //   556: invokevirtual getMeasuredWidth : ()I
    //   559: istore #7
    //   561: iload #5
    //   563: iload #7
    //   565: isub
    //   566: istore #6
    //   568: iload_2
    //   569: istore #4
    //   571: iload_2
    //   572: ifne -> 579
    //   575: iload #7
    //   577: istore #4
    //   579: aload #18
    //   581: getfield u : Z
    //   584: ifeq -> 595
    //   587: iload #6
    //   589: iflt -> 608
    //   592: goto -> 603
    //   595: iload #6
    //   597: iload #4
    //   599: iadd
    //   600: ifle -> 608
    //   603: iconst_1
    //   604: istore_2
    //   605: goto -> 610
    //   608: iconst_0
    //   609: istore_2
    //   610: iload #13
    //   612: iload_2
    //   613: iand
    //   614: istore #15
    //   616: iload_3
    //   617: istore #7
    //   619: iload #15
    //   621: ifeq -> 642
    //   624: iload #12
    //   626: ifeq -> 642
    //   629: aload #20
    //   631: iload #12
    //   633: iconst_1
    //   634: invokevirtual put : (IZ)V
    //   637: iload_1
    //   638: istore_2
    //   639: goto -> 719
    //   642: iload_1
    //   643: istore_2
    //   644: iload #16
    //   646: ifeq -> 719
    //   649: aload #20
    //   651: iload #12
    //   653: iconst_0
    //   654: invokevirtual put : (IZ)V
    //   657: iconst_0
    //   658: istore_3
    //   659: iload_1
    //   660: istore_2
    //   661: iload_3
    //   662: iload #10
    //   664: if_icmpge -> 719
    //   667: aload #17
    //   669: iload_3
    //   670: invokevirtual get : (I)Ljava/lang/Object;
    //   673: checkcast androidx/appcompat/view/menu/MenuItemImpl
    //   676: astore #18
    //   678: iload_1
    //   679: istore_2
    //   680: aload #18
    //   682: invokevirtual getGroupId : ()I
    //   685: iload #12
    //   687: if_icmpne -> 710
    //   690: iload_1
    //   691: istore_2
    //   692: aload #18
    //   694: invokevirtual isActionButton : ()Z
    //   697: ifeq -> 704
    //   700: iload_1
    //   701: iconst_1
    //   702: iadd
    //   703: istore_2
    //   704: aload #18
    //   706: iconst_0
    //   707: invokevirtual setIsActionButton : (Z)V
    //   710: iload_3
    //   711: iconst_1
    //   712: iadd
    //   713: istore_3
    //   714: iload_2
    //   715: istore_1
    //   716: goto -> 659
    //   719: iload_2
    //   720: istore_1
    //   721: iload #15
    //   723: ifeq -> 730
    //   726: iload_2
    //   727: iconst_1
    //   728: isub
    //   729: istore_1
    //   730: aload #21
    //   732: iload #15
    //   734: invokevirtual setIsActionButton : (Z)V
    //   737: iload #7
    //   739: istore_3
    //   740: goto -> 393
    //   743: aload #21
    //   745: iconst_0
    //   746: invokevirtual setIsActionButton : (Z)V
    //   749: iload #10
    //   751: iconst_1
    //   752: iadd
    //   753: istore #10
    //   755: goto -> 264
    //   758: iconst_1
    //   759: ireturn
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup) {
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
      view.setLayoutParams((ViewGroup.LayoutParams)actionMenuView.a(layoutParams)); 
    return view;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    MenuView menuView2 = this.f;
    MenuView menuView1 = super.getMenuView(paramViewGroup);
    if (menuView2 != menuView1)
      ((ActionMenuView)menuView1).setPresenter(this); 
    return menuView1;
  }
  
  public Drawable getOverflowIcon() {
    OverflowMenuButton overflowMenuButton = this.g;
    return (overflowMenuButton != null) ? overflowMenuButton.getDrawable() : (this.n ? this.m : null);
  }
  
  public boolean hideOverflowMenu() {
    if (this.j != null && this.f != null) {
      ((View)this.f).removeCallbacks(this.j);
      this.j = null;
      return true;
    } 
    OverflowPopup overflowPopup = this.h;
    if (overflowPopup != null) {
      overflowPopup.dismiss();
      return true;
    } 
    return false;
  }
  
  public boolean hideSubMenus() {
    ActionButtonSubmenu actionButtonSubmenu = this.i;
    if (actionButtonSubmenu != null) {
      actionButtonSubmenu.dismiss();
      return true;
    } 
    return false;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
    super.initForMenu(paramContext, paramMenuBuilder);
    Resources resources = paramContext.getResources();
    ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(paramContext);
    if (!this.p)
      this.o = actionBarPolicy.showsOverflowMenuButton(); 
    if (!this.v)
      this.q = actionBarPolicy.getEmbeddedMenuWidthLimit(); 
    if (!this.t)
      this.s = actionBarPolicy.getMaxActionButtons(); 
    int i = this.q;
    if (this.o) {
      if (this.g == null) {
        this.g = new OverflowMenuButton(this, this.a);
        if (this.n) {
          this.g.setImageDrawable(this.m);
          this.m = null;
          this.n = false;
        } 
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.g.measure(j, j);
      } 
      i -= this.g.getMeasuredWidth();
    } else {
      this.g = null;
    } 
    this.r = i;
    this.x = (int)((resources.getDisplayMetrics()).density * 56.0F);
  }
  
  public boolean isOverflowMenuShowPending() {
    return (this.j != null || isOverflowMenuShowing());
  }
  
  public boolean isOverflowMenuShowing() {
    OverflowPopup overflowPopup = this.h;
    return (overflowPopup != null && overflowPopup.isShowing());
  }
  
  public boolean isOverflowReserved() {
    return this.o;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (!this.t)
      this.s = ActionBarPolicy.get(this.b).getMaxActionButtons(); 
    if (this.c != null)
      this.c.onItemsChanged(true); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState))
      return; 
    paramParcelable = paramParcelable;
    if (((SavedState)paramParcelable).openSubMenuId > 0) {
      MenuItem menuItem = this.c.findItem(((SavedState)paramParcelable).openSubMenuId);
      if (menuItem != null)
        onSubMenuSelected((SubMenuBuilder)menuItem.getSubMenu()); 
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState();
    savedState.openSubMenuId = this.l;
    return savedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    boolean bool = paramSubMenuBuilder.hasVisibleItems();
    boolean bool1 = false;
    if (!bool)
      return false; 
    SubMenuBuilder subMenuBuilder;
    for (subMenuBuilder = paramSubMenuBuilder; subMenuBuilder.getParentMenu() != this.c; subMenuBuilder = (SubMenuBuilder)subMenuBuilder.getParentMenu());
    View view = a(subMenuBuilder.getItem());
    if (view == null)
      return false; 
    this.l = paramSubMenuBuilder.getItem().getItemId();
    int j = paramSubMenuBuilder.size();
    int i = 0;
    while (true) {
      bool = bool1;
      if (i < j) {
        MenuItem menuItem = paramSubMenuBuilder.getItem(i);
        if (menuItem.isVisible() && menuItem.getIcon() != null) {
          bool = true;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    this.i = new ActionButtonSubmenu(this, this.b, paramSubMenuBuilder, view);
    this.i.setForceShowIcon(bool);
    this.i.show();
    super.onSubMenuSelected(paramSubMenuBuilder);
    return true;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean) {
      super.onSubMenuSelected(null);
      return;
    } 
    if (this.c != null)
      this.c.close(false); 
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean) {
    this.w = paramBoolean;
  }
  
  public void setItemLimit(int paramInt) {
    this.s = paramInt;
    this.t = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView) {
    this.f = paramActionMenuView;
    paramActionMenuView.initialize(this.c);
  }
  
  public void setOverflowIcon(Drawable paramDrawable) {
    OverflowMenuButton overflowMenuButton = this.g;
    if (overflowMenuButton != null) {
      overflowMenuButton.setImageDrawable(paramDrawable);
      return;
    } 
    this.n = true;
    this.m = paramDrawable;
  }
  
  public void setReserveOverflow(boolean paramBoolean) {
    this.o = paramBoolean;
    this.p = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean) {
    this.q = paramInt;
    this.u = paramBoolean;
    this.v = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl) {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu() {
    if (this.o && !isOverflowMenuShowing() && this.c != null && this.f != null && this.j == null && !this.c.getNonActionItems().isEmpty()) {
      this.j = new OpenOverflowRunnable(this, new OverflowPopup(this, this.b, this.c, (View)this.g, true));
      ((View)this.f).post(this.j);
      super.onSubMenuSelected(null);
      return true;
    } 
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean) {
    super.updateMenuView(paramBoolean);
    ((View)this.f).requestLayout();
    MenuBuilder<MenuItemImpl> menuBuilder = this.c;
    byte b = 0;
    if (menuBuilder != null) {
      ArrayList<MenuItemImpl> arrayList = this.c.getActionItems();
      int k = arrayList.size();
      for (int j = 0; j < k; j++) {
        ActionProvider actionProvider = ((MenuItemImpl)arrayList.get(j)).getSupportActionProvider();
        if (actionProvider != null)
          actionProvider.setSubUiVisibilityListener(this); 
      } 
    } 
    if (this.c != null) {
      ArrayList arrayList = this.c.getNonActionItems();
    } else {
      menuBuilder = null;
    } 
    int i = b;
    if (this.o) {
      i = b;
      if (menuBuilder != null) {
        int j = menuBuilder.size();
        if (j == 1) {
          i = ((MenuItemImpl)menuBuilder.get(0)).isActionViewExpanded() ^ true;
        } else {
          i = b;
          if (j > 0)
            i = 1; 
        } 
      } 
    } 
    if (i != 0) {
      if (this.g == null)
        this.g = new OverflowMenuButton(this, this.a); 
      ViewGroup viewGroup = (ViewGroup)this.g.getParent();
      if (viewGroup != this.f) {
        if (viewGroup != null)
          viewGroup.removeView((View)this.g); 
        viewGroup = (ActionMenuView)this.f;
        viewGroup.addView((View)this.g, (ViewGroup.LayoutParams)viewGroup.generateOverflowButtonLayoutParams());
      } 
    } else {
      OverflowMenuButton overflowMenuButton = this.g;
      if (overflowMenuButton != null && overflowMenuButton.getParent() == this.f)
        ((ViewGroup)this.f).removeView((View)this.g); 
    } 
    ((ActionMenuView)this.f).setOverflowReserved(this.o);
  }
  
  class ActionButtonSubmenu extends MenuPopupHelper {
    public ActionButtonSubmenu(ActionMenuPresenter this$0, Context param1Context, SubMenuBuilder param1SubMenuBuilder, View param1View) {
      super(param1Context, (MenuBuilder)param1SubMenuBuilder, param1View, false, R.attr.actionOverflowMenuStyle);
      if (!((MenuItemImpl)param1SubMenuBuilder.getItem()).isActionButton()) {
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton;
        if (this$0.g == null) {
          View view = (View)ActionMenuPresenter.c(this$0);
        } else {
          overflowMenuButton = this$0.g;
        } 
        setAnchorView((View)overflowMenuButton);
      } 
      setPresenterCallback(this$0.k);
    }
    
    public void a() {
      ActionMenuPresenter actionMenuPresenter = this.a;
      actionMenuPresenter.i = null;
      actionMenuPresenter.l = 0;
      super.a();
    }
  }
  
  class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
    ActionMenuPopupCallback(ActionMenuPresenter this$0) {}
    
    public ShowableListMenu getPopup() {
      return (ShowableListMenu)((this.a.i != null) ? this.a.i.getPopup() : null);
    }
  }
  
  class OpenOverflowRunnable implements Runnable {
    private ActionMenuPresenter.OverflowPopup b;
    
    public OpenOverflowRunnable(ActionMenuPresenter this$0, ActionMenuPresenter.OverflowPopup param1OverflowPopup) {
      this.b = param1OverflowPopup;
    }
    
    public void run() {
      if (ActionMenuPresenter.d(this.a) != null)
        ActionMenuPresenter.e(this.a).changeMenuMode(); 
      View view = (View)ActionMenuPresenter.f(this.a);
      if (view != null && view.getWindowToken() != null && this.b.tryShow())
        this.a.h = this.b; 
      this.a.j = null;
    }
  }
  
  class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
    private final float[] b = new float[2];
    
    public OverflowMenuButton(ActionMenuPresenter this$0, Context param1Context) {
      super(param1Context, (AttributeSet)null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      TooltipCompat.setTooltipText((View)this, getContentDescription());
      setOnTouchListener(new ForwardingListener(this, (View)this, this$0) {
            public ShowableListMenu getPopup() {
              return (ShowableListMenu)((this.b.a.h == null) ? null : this.b.a.h.getPopup());
            }
            
            public boolean onForwardingStarted() {
              this.b.a.showOverflowMenu();
              return true;
            }
            
            public boolean onForwardingStopped() {
              if (this.b.a.j != null)
                return false; 
              this.b.a.hideOverflowMenu();
              return true;
            }
          });
    }
    
    public boolean needsDividerAfter() {
      return false;
    }
    
    public boolean needsDividerBefore() {
      return false;
    }
    
    public boolean performClick() {
      if (super.performClick())
        return true; 
      playSoundEffect(0);
      this.a.showOverflowMenu();
      return true;
    }
    
    protected boolean setFrame(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      boolean bool = super.setFrame(param1Int1, param1Int2, param1Int3, param1Int4);
      Drawable drawable1 = getDrawable();
      Drawable drawable2 = getBackground();
      if (drawable1 != null && drawable2 != null) {
        int i = getWidth();
        param1Int2 = getHeight();
        param1Int1 = Math.max(i, param1Int2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        param1Int3 = getPaddingTop();
        param1Int4 = getPaddingBottom();
        i = (i + j - k) / 2;
        param1Int2 = (param1Int2 + param1Int3 - param1Int4) / 2;
        DrawableCompat.setHotspotBounds(drawable2, i - param1Int1, param1Int2 - param1Int1, i + param1Int1, param1Int2 + param1Int1);
      } 
      return bool;
    }
  }
  
  class null extends ForwardingListener {
    null(ActionMenuPresenter this$0, View param1View, ActionMenuPresenter param1ActionMenuPresenter) {
      super(param1View);
    }
    
    public ShowableListMenu getPopup() {
      return (ShowableListMenu)((this.b.a.h == null) ? null : this.b.a.h.getPopup());
    }
    
    public boolean onForwardingStarted() {
      this.b.a.showOverflowMenu();
      return true;
    }
    
    public boolean onForwardingStopped() {
      if (this.b.a.j != null)
        return false; 
      this.b.a.hideOverflowMenu();
      return true;
    }
  }
  
  class OverflowPopup extends MenuPopupHelper {
    public OverflowPopup(ActionMenuPresenter this$0, Context param1Context, MenuBuilder param1MenuBuilder, View param1View, boolean param1Boolean) {
      super(param1Context, param1MenuBuilder, param1View, param1Boolean, R.attr.actionOverflowMenuStyle);
      setGravity(8388613);
      setPresenterCallback(this$0.k);
    }
    
    public void a() {
      if (ActionMenuPresenter.a(this.a) != null)
        ActionMenuPresenter.b(this.a).close(); 
      this.a.h = null;
      super.a();
    }
  }
  
  class PopupPresenterCallback implements MenuPresenter.Callback {
    PopupPresenterCallback(ActionMenuPresenter this$0) {}
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      if (param1MenuBuilder instanceof SubMenuBuilder)
        param1MenuBuilder.getRootMenu().close(false); 
      MenuPresenter.Callback callback = this.a.getCallback();
      if (callback != null)
        callback.onCloseMenu(param1MenuBuilder, param1Boolean); 
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      boolean bool = false;
      if (param1MenuBuilder == null)
        return false; 
      this.a.l = ((SubMenuBuilder)param1MenuBuilder).getItem().getItemId();
      MenuPresenter.Callback callback = this.a.getCallback();
      if (callback != null)
        bool = callback.onOpenSubMenu(param1MenuBuilder); 
      return bool;
    }
  }
  
  static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public ActionMenuPresenter.SavedState createFromParcel(Parcel param2Parcel) {
          return new ActionMenuPresenter.SavedState(param2Parcel);
        }
        
        public ActionMenuPresenter.SavedState[] newArray(int param2Int) {
          return new ActionMenuPresenter.SavedState[param2Int];
        }
      };
    
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.openSubMenuId = param1Parcel.readInt();
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.openSubMenuId);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public ActionMenuPresenter.SavedState createFromParcel(Parcel param1Parcel) {
      return new ActionMenuPresenter.SavedState(param1Parcel);
    }
    
    public ActionMenuPresenter.SavedState[] newArray(int param1Int) {
      return new ActionMenuPresenter.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */