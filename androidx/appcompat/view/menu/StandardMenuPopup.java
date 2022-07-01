package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
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
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class StandardMenuPopup extends MenuPopup implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, MenuPresenter {
  private static final int e = R.layout.abc_popup_menu_item_layout;
  
  final MenuPopupWindow a;
  
  final ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener(this) {
      public void onGlobalLayout() {
        if (this.a.isShowing() && !this.a.a.isModal()) {
          View view = this.a.c;
          if (view == null || !view.isShown()) {
            this.a.dismiss();
            return;
          } 
          this.a.a.show();
          return;
        } 
      }
    };
  
  View c;
  
  ViewTreeObserver d;
  
  private final Context f;
  
  private final MenuBuilder g;
  
  private final MenuAdapter h;
  
  private final boolean i;
  
  private final int j;
  
  private final int k;
  
  private final int l;
  
  private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener(this) {
      public void onViewAttachedToWindow(View param1View) {}
      
      public void onViewDetachedFromWindow(View param1View) {
        if (this.a.d != null) {
          if (!this.a.d.isAlive())
            this.a.d = param1View.getViewTreeObserver(); 
          this.a.d.removeGlobalOnLayoutListener(this.a.b);
        } 
        param1View.removeOnAttachStateChangeListener(this);
      }
    };
  
  private PopupWindow.OnDismissListener n;
  
  private View o;
  
  private MenuPresenter.Callback p;
  
  private boolean q;
  
  private boolean r;
  
  private int s;
  
  private int t = 0;
  
  private boolean u;
  
  public StandardMenuPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    this.f = paramContext;
    this.g = paramMenuBuilder;
    this.i = paramBoolean;
    this.h = new MenuAdapter(paramMenuBuilder, LayoutInflater.from(paramContext), this.i, e);
    this.k = paramInt1;
    this.l = paramInt2;
    Resources resources = paramContext.getResources();
    this.j = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.o = paramView;
    this.a = new MenuPopupWindow(this.f, null, this.k, this.l);
    paramMenuBuilder.addMenuPresenter(this, paramContext);
  }
  
  private boolean b() {
    if (isShowing())
      return true; 
    if (!this.q) {
      boolean bool;
      View view = this.o;
      if (view == null)
        return false; 
      this.c = view;
      this.a.setOnDismissListener(this);
      this.a.setOnItemClickListener(this);
      this.a.setModal(true);
      view = this.c;
      if (this.d == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.d = view.getViewTreeObserver();
      if (bool)
        this.d.addOnGlobalLayoutListener(this.b); 
      view.addOnAttachStateChangeListener(this.m);
      this.a.setAnchorView(view);
      this.a.setDropDownGravity(this.t);
      if (!this.r) {
        this.s = a((ListAdapter)this.h, null, this.f, this.j);
        this.r = true;
      } 
      this.a.setContentWidth(this.s);
      this.a.setInputMethodMode(2);
      this.a.setEpicenterBounds(getEpicenterBounds());
      this.a.show();
      ListView listView = this.a.getListView();
      listView.setOnKeyListener(this);
      if (this.u && this.g.getHeaderTitle() != null) {
        FrameLayout frameLayout = (FrameLayout)LayoutInflater.from(this.f).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)listView, false);
        TextView textView = (TextView)frameLayout.findViewById(16908310);
        if (textView != null)
          textView.setText(this.g.getHeaderTitle()); 
        frameLayout.setEnabled(false);
        listView.addHeaderView((View)frameLayout, null, false);
      } 
      this.a.setAdapter((ListAdapter)this.h);
      this.a.show();
      return true;
    } 
    return false;
  }
  
  public void addMenu(MenuBuilder paramMenuBuilder) {}
  
  public void dismiss() {
    if (isShowing())
      this.a.dismiss(); 
  }
  
  public boolean flagActionItems() {
    return false;
  }
  
  public ListView getListView() {
    return this.a.getListView();
  }
  
  public boolean isShowing() {
    return (!this.q && this.a.isShowing());
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    if (paramMenuBuilder != this.g)
      return; 
    dismiss();
    MenuPresenter.Callback callback = this.p;
    if (callback != null)
      callback.onCloseMenu(paramMenuBuilder, paramBoolean); 
  }
  
  public void onDismiss() {
    this.q = true;
    this.g.close();
    ViewTreeObserver viewTreeObserver = this.d;
    if (viewTreeObserver != null) {
      if (!viewTreeObserver.isAlive())
        this.d = this.c.getViewTreeObserver(); 
      this.d.removeGlobalOnLayoutListener(this.b);
      this.d = null;
    } 
    this.c.removeOnAttachStateChangeListener(this.m);
    PopupWindow.OnDismissListener onDismissListener = this.n;
    if (onDismissListener != null)
      onDismissListener.onDismiss(); 
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
    if (paramSubMenuBuilder.hasVisibleItems()) {
      MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f, paramSubMenuBuilder, this.c, this.i, this.k, this.l);
      menuPopupHelper.setPresenterCallback(this.p);
      menuPopupHelper.setForceShowIcon(MenuPopup.a(paramSubMenuBuilder));
      menuPopupHelper.setOnDismissListener(this.n);
      this.n = null;
      this.g.close(false);
      int j = this.a.getHorizontalOffset();
      int k = this.a.getVerticalOffset();
      int i = j;
      if ((Gravity.getAbsoluteGravity(this.t, ViewCompat.getLayoutDirection(this.o)) & 0x7) == 5)
        i = j + this.o.getWidth(); 
      if (menuPopupHelper.tryShow(i, k)) {
        MenuPresenter.Callback callback = this.p;
        if (callback != null)
          callback.onOpenSubMenu(paramSubMenuBuilder); 
        return true;
      } 
    } 
    return false;
  }
  
  public void setAnchorView(View paramView) {
    this.o = paramView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {
    this.p = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean) {
    this.h.setForceShowIcon(paramBoolean);
  }
  
  public void setGravity(int paramInt) {
    this.t = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt) {
    this.a.setHorizontalOffset(paramInt);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.n = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt) {
    this.a.setVerticalOffset(paramInt);
  }
  
  public void show() {
    if (b())
      return; 
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public void updateMenuView(boolean paramBoolean) {
    this.r = false;
    MenuAdapter menuAdapter = this.h;
    if (menuAdapter != null)
      menuAdapter.notifyDataSetChanged(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\StandardMenuPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */