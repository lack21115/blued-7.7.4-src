package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.appcompat.R;
import android.support.v7.widget.DropDownListView;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

final class StandardMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
  private final MenuAdapter mAdapter;
  
  private View mAnchorView;
  
  private final View.OnAttachStateChangeListener mAttachStateChangeListener = new StandardMenuPopup$2(this);
  
  private int mContentWidth;
  
  private final Context mContext;
  
  private int mDropDownGravity = 0;
  
  private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new StandardMenuPopup$1(this);
  
  private boolean mHasContentWidth;
  
  private final MenuBuilder mMenu;
  
  private PopupWindow.OnDismissListener mOnDismissListener;
  
  private final boolean mOverflowOnly;
  
  final MenuPopupWindow mPopup;
  
  private final int mPopupMaxWidth;
  
  private final int mPopupStyleAttr;
  
  private final int mPopupStyleRes;
  
  private MenuPresenter$Callback mPresenterCallback;
  
  private boolean mShowTitle;
  
  View mShownAnchorView;
  
  private ViewTreeObserver mTreeObserver;
  
  private boolean mWasDismissed;
  
  public StandardMenuPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    this.mContext = paramContext;
    this.mMenu = paramMenuBuilder;
    this.mOverflowOnly = paramBoolean;
    this.mAdapter = new MenuAdapter(paramMenuBuilder, LayoutInflater.from(paramContext), this.mOverflowOnly);
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
    Resources resources = paramContext.getResources();
    this.mPopupMaxWidth = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.mAnchorView = paramView;
    this.mPopup = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
    paramMenuBuilder.addMenuPresenter(this, paramContext);
  }
  
  public final void addMenu(MenuBuilder paramMenuBuilder) {}
  
  public final void dismiss() {
    if (isShowing())
      this.mPopup.dismiss(); 
  }
  
  public final boolean flagActionItems() {
    return false;
  }
  
  public final ListView getListView() {
    return (ListView)((ListPopupWindow)this.mPopup).mDropDownList;
  }
  
  public final boolean isShowing() {
    return (!this.mWasDismissed && ((ListPopupWindow)this.mPopup).mPopup.isShowing());
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    if (paramMenuBuilder != this.mMenu)
      return; 
    dismiss();
    if (this.mPresenterCallback != null)
      this.mPresenterCallback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public final void onDismiss() {
    this.mWasDismissed = true;
    this.mMenu.close();
    if (this.mTreeObserver != null) {
      if (!this.mTreeObserver.isAlive())
        this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver(); 
      this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
      this.mTreeObserver = null;
    } 
    this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
    if (this.mOnDismissListener != null)
      this.mOnDismissListener.onDismiss(); 
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1 && paramInt == 82) {
      dismiss();
      return true;
    } 
    return false;
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual hasVisibleItems : ()Z
    //   4: ifeq -> 181
    //   7: new android/support/v7/view/menu/MenuPopupHelper
    //   10: dup
    //   11: aload_0
    //   12: getfield mContext : Landroid/content/Context;
    //   15: aload_1
    //   16: aload_0
    //   17: getfield mShownAnchorView : Landroid/view/View;
    //   20: aload_0
    //   21: getfield mOverflowOnly : Z
    //   24: aload_0
    //   25: getfield mPopupStyleAttr : I
    //   28: aload_0
    //   29: getfield mPopupStyleRes : I
    //   32: invokespecial <init> : (Landroid/content/Context;Landroid/support/v7/view/menu/MenuBuilder;Landroid/view/View;ZII)V
    //   35: astore #4
    //   37: aload #4
    //   39: aload_0
    //   40: getfield mPresenterCallback : Landroid/support/v7/view/menu/MenuPresenter$Callback;
    //   43: invokevirtual setPresenterCallback : (Landroid/support/v7/view/menu/MenuPresenter$Callback;)V
    //   46: aload #4
    //   48: aload_1
    //   49: invokestatic shouldPreserveIconSpacing : (Landroid/support/v7/view/menu/MenuBuilder;)Z
    //   52: invokevirtual setForceShowIcon : (Z)V
    //   55: aload #4
    //   57: aload_0
    //   58: getfield mDropDownGravity : I
    //   61: putfield mDropDownGravity : I
    //   64: aload #4
    //   66: aload_0
    //   67: getfield mOnDismissListener : Landroid/widget/PopupWindow$OnDismissListener;
    //   70: putfield mOnDismissListener : Landroid/widget/PopupWindow$OnDismissListener;
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield mOnDismissListener : Landroid/widget/PopupWindow$OnDismissListener;
    //   78: aload_0
    //   79: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   82: iconst_0
    //   83: invokevirtual close : (Z)V
    //   86: aload_0
    //   87: getfield mPopup : Landroid/support/v7/widget/MenuPopupWindow;
    //   90: getfield mDropDownHorizontalOffset : I
    //   93: istore_3
    //   94: aload_0
    //   95: getfield mPopup : Landroid/support/v7/widget/MenuPopupWindow;
    //   98: astore #5
    //   100: aload #5
    //   102: getfield mDropDownVerticalOffsetSet : Z
    //   105: ifne -> 113
    //   108: iconst_0
    //   109: istore_2
    //   110: goto -> 119
    //   113: aload #5
    //   115: getfield mDropDownVerticalOffset : I
    //   118: istore_2
    //   119: aload #4
    //   121: invokevirtual isShowing : ()Z
    //   124: ifeq -> 132
    //   127: iconst_1
    //   128: istore_2
    //   129: goto -> 157
    //   132: aload #4
    //   134: getfield mAnchorView : Landroid/view/View;
    //   137: ifnonnull -> 145
    //   140: iconst_0
    //   141: istore_2
    //   142: goto -> 157
    //   145: aload #4
    //   147: iload_3
    //   148: iload_2
    //   149: iconst_1
    //   150: iconst_1
    //   151: invokevirtual showPopup : (IIZZ)V
    //   154: goto -> 127
    //   157: iload_2
    //   158: ifeq -> 181
    //   161: aload_0
    //   162: getfield mPresenterCallback : Landroid/support/v7/view/menu/MenuPresenter$Callback;
    //   165: ifnull -> 179
    //   168: aload_0
    //   169: getfield mPresenterCallback : Landroid/support/v7/view/menu/MenuPresenter$Callback;
    //   172: aload_1
    //   173: invokeinterface onOpenSubMenu : (Landroid/support/v7/view/menu/MenuBuilder;)Z
    //   178: pop
    //   179: iconst_1
    //   180: ireturn
    //   181: iconst_0
    //   182: ireturn
  }
  
  public final void setAnchorView(View paramView) {
    this.mAnchorView = paramView;
  }
  
  public final void setCallback(MenuPresenter$Callback paramMenuPresenter$Callback) {
    this.mPresenterCallback = paramMenuPresenter$Callback;
  }
  
  public final void setForceShowIcon(boolean paramBoolean) {
    this.mAdapter.mForceShowIcon = paramBoolean;
  }
  
  public final void setGravity(int paramInt) {
    this.mDropDownGravity = paramInt;
  }
  
  public final void setHorizontalOffset(int paramInt) {
    ((ListPopupWindow)this.mPopup).mDropDownHorizontalOffset = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public final void setShowTitle(boolean paramBoolean) {
    this.mShowTitle = paramBoolean;
  }
  
  public final void setVerticalOffset(int paramInt) {
    this.mPopup.setVerticalOffset(paramInt);
  }
  
  public final void show() {
    boolean bool1;
    boolean bool = isShowing();
    boolean bool2 = true;
    if (bool) {
      bool1 = bool2;
    } else if (this.mWasDismissed || this.mAnchorView == null) {
      bool1 = false;
    } else {
      this.mShownAnchorView = this.mAnchorView;
      this.mPopup.setOnDismissListener(this);
      ((ListPopupWindow)this.mPopup).mItemClickListener = this;
      this.mPopup.setModal(true);
      View view = this.mShownAnchorView;
      if (this.mTreeObserver == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.mTreeObserver = view.getViewTreeObserver();
      if (bool1)
        this.mTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener); 
      view.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
      ((ListPopupWindow)this.mPopup).mDropDownAnchorView = view;
      ((ListPopupWindow)this.mPopup).mDropDownGravity = this.mDropDownGravity;
      if (!this.mHasContentWidth) {
        this.mContentWidth = measureIndividualMenuWidth((ListAdapter)this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
        this.mHasContentWidth = true;
      } 
      this.mPopup.setContentWidth(this.mContentWidth);
      this.mPopup.setInputMethodMode(2);
      ((ListPopupWindow)this.mPopup).mEpicenterBounds = this.mEpicenterBounds;
      this.mPopup.show();
      DropDownListView dropDownListView = ((ListPopupWindow)this.mPopup).mDropDownList;
      dropDownListView.setOnKeyListener(this);
      if (this.mShowTitle && this.mMenu.mHeaderTitle != null) {
        FrameLayout frameLayout = (FrameLayout)LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)dropDownListView, false);
        TextView textView = (TextView)frameLayout.findViewById(16908310);
        if (textView != null)
          textView.setText(this.mMenu.mHeaderTitle); 
        frameLayout.setEnabled(false);
        dropDownListView.addHeaderView((View)frameLayout, null, false);
      } 
      this.mPopup.setAdapter((ListAdapter)this.mAdapter);
      this.mPopup.show();
      bool1 = bool2;
    } 
    if (bool1)
      return; 
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public final void updateMenuView(boolean paramBoolean) {
    this.mHasContentWidth = false;
    if (this.mAdapter != null)
      this.mAdapter.notifyDataSetChanged(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\StandardMenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */