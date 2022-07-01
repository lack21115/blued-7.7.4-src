package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
  private Context a;
  
  private ActionBarContextView b;
  
  private ActionMode.Callback c;
  
  private WeakReference<View> d;
  
  private boolean e;
  
  private boolean f;
  
  private MenuBuilder g;
  
  public StandaloneActionMode(Context paramContext, ActionBarContextView paramActionBarContextView, ActionMode.Callback paramCallback, boolean paramBoolean) {
    this.a = paramContext;
    this.b = paramActionBarContextView;
    this.c = paramCallback;
    this.g = (new MenuBuilder(paramActionBarContextView.getContext())).setDefaultShowAsAction(1);
    this.g.setCallback(this);
    this.f = paramBoolean;
  }
  
  public void finish() {
    if (this.e)
      return; 
    this.e = true;
    this.b.sendAccessibilityEvent(32);
    this.c.onDestroyActionMode(this);
  }
  
  public View getCustomView() {
    WeakReference<View> weakReference = this.d;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public Menu getMenu() {
    return (Menu)this.g;
  }
  
  public MenuInflater getMenuInflater() {
    return new SupportMenuInflater(this.b.getContext());
  }
  
  public CharSequence getSubtitle() {
    return this.b.getSubtitle();
  }
  
  public CharSequence getTitle() {
    return this.b.getTitle();
  }
  
  public void invalidate() {
    this.c.onPrepareActionMode(this, (Menu)this.g);
  }
  
  public boolean isTitleOptional() {
    return this.b.isTitleOptional();
  }
  
  public boolean isUiFocusable() {
    return this.f;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    return this.c.onActionItemClicked(this, paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder) {
    invalidate();
    this.b.showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    if (!paramSubMenuBuilder.hasVisibleItems())
      return true; 
    (new MenuPopupHelper(this.b.getContext(), (MenuBuilder)paramSubMenuBuilder)).show();
    return true;
  }
  
  public void setCustomView(View paramView) {
    this.b.setCustomView(paramView);
    if (paramView != null) {
      WeakReference<View> weakReference = new WeakReference<View>(paramView);
    } else {
      paramView = null;
    } 
    this.d = (WeakReference<View>)paramView;
  }
  
  public void setSubtitle(int paramInt) {
    setSubtitle(this.a.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.b.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt) {
    setTitle(this.a.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.b.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean) {
    super.setTitleOptionalHint(paramBoolean);
    this.b.setTitleOptional(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\StandaloneActionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */