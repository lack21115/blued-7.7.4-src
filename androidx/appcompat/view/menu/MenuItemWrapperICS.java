package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
  private final SupportMenuItem b;
  
  private Method c;
  
  public MenuItemWrapperICS(Context paramContext, SupportMenuItem paramSupportMenuItem) {
    super(paramContext);
    if (paramSupportMenuItem != null) {
      this.b = paramSupportMenuItem;
      return;
    } 
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public boolean collapseActionView() {
    return this.b.collapseActionView();
  }
  
  public boolean expandActionView() {
    return this.b.expandActionView();
  }
  
  public ActionProvider getActionProvider() {
    ActionProvider actionProvider = this.b.getSupportActionProvider();
    return (actionProvider instanceof ActionProviderWrapper) ? ((ActionProviderWrapper)actionProvider).a : null;
  }
  
  public View getActionView() {
    View view2 = this.b.getActionView();
    View view1 = view2;
    if (view2 instanceof CollapsibleActionViewWrapper)
      view1 = ((CollapsibleActionViewWrapper)view2).a(); 
    return view1;
  }
  
  public int getAlphabeticModifiers() {
    return this.b.getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut() {
    return this.b.getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription() {
    return this.b.getContentDescription();
  }
  
  public int getGroupId() {
    return this.b.getGroupId();
  }
  
  public Drawable getIcon() {
    return this.b.getIcon();
  }
  
  public ColorStateList getIconTintList() {
    return this.b.getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode() {
    return this.b.getIconTintMode();
  }
  
  public Intent getIntent() {
    return this.b.getIntent();
  }
  
  public int getItemId() {
    return this.b.getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo() {
    return this.b.getMenuInfo();
  }
  
  public int getNumericModifiers() {
    return this.b.getNumericModifiers();
  }
  
  public char getNumericShortcut() {
    return this.b.getNumericShortcut();
  }
  
  public int getOrder() {
    return this.b.getOrder();
  }
  
  public SubMenu getSubMenu() {
    return a(this.b.getSubMenu());
  }
  
  public CharSequence getTitle() {
    return this.b.getTitle();
  }
  
  public CharSequence getTitleCondensed() {
    return this.b.getTitleCondensed();
  }
  
  public CharSequence getTooltipText() {
    return this.b.getTooltipText();
  }
  
  public boolean hasSubMenu() {
    return this.b.hasSubMenu();
  }
  
  public boolean isActionViewExpanded() {
    return this.b.isActionViewExpanded();
  }
  
  public boolean isCheckable() {
    return this.b.isCheckable();
  }
  
  public boolean isChecked() {
    return this.b.isChecked();
  }
  
  public boolean isEnabled() {
    return this.b.isEnabled();
  }
  
  public boolean isVisible() {
    return this.b.isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider) {
    ActionProvider actionProvider;
    if (Build.VERSION.SDK_INT >= 16) {
      actionProvider = new ActionProviderWrapperJB(this, this.a, paramActionProvider);
    } else {
      actionProvider = new ActionProviderWrapper(this, this.a, paramActionProvider);
    } 
    SupportMenuItem supportMenuItem = this.b;
    if (paramActionProvider == null)
      actionProvider = null; 
    supportMenuItem.setSupportActionProvider(actionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt) {
    this.b.setActionView(paramInt);
    View view = this.b.getActionView();
    if (view instanceof CollapsibleActionView)
      this.b.setActionView((View)new CollapsibleActionViewWrapper(view)); 
    return this;
  }
  
  public MenuItem setActionView(View paramView) {
    CollapsibleActionViewWrapper collapsibleActionViewWrapper;
    View view = paramView;
    if (paramView instanceof CollapsibleActionView)
      collapsibleActionViewWrapper = new CollapsibleActionViewWrapper(paramView); 
    this.b.setActionView((View)collapsibleActionViewWrapper);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar) {
    this.b.setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt) {
    this.b.setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean) {
    this.b.setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean) {
    this.b.setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence) {
    this.b.setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean) {
    this.b.setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean) {
    try {
      if (this.c == null)
        this.c = this.b.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { boolean.class }); 
      this.c.invoke(this.b, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    } catch (Exception exception) {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", exception);
      return;
    } 
  }
  
  public MenuItem setIcon(int paramInt) {
    this.b.setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable) {
    this.b.setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList) {
    this.b.setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode) {
    this.b.setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent) {
    this.b.setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar) {
    this.b.setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt) {
    this.b.setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    SupportMenuItem supportMenuItem = this.b;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new OnActionExpandListenerWrapper(this, paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    } 
    supportMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    SupportMenuItem supportMenuItem = this.b;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new OnMenuItemClickListenerWrapper(this, paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    } 
    supportMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.b.setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2) {
    this.b.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt) {
    this.b.setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt) {
    this.b.setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt) {
    this.b.setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence) {
    this.b.setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.b.setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence) {
    this.b.setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean) {
    return this.b.setVisible(paramBoolean);
  }
  
  class ActionProviderWrapper extends ActionProvider {
    final ActionProvider a;
    
    ActionProviderWrapper(MenuItemWrapperICS this$0, Context param1Context, ActionProvider param1ActionProvider) {
      super(param1Context);
      this.a = param1ActionProvider;
    }
    
    public boolean hasSubMenu() {
      return this.a.hasSubMenu();
    }
    
    public View onCreateActionView() {
      return this.a.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction() {
      return this.a.onPerformDefaultAction();
    }
    
    public void onPrepareSubMenu(SubMenu param1SubMenu) {
      this.a.onPrepareSubMenu(this.b.a(param1SubMenu));
    }
  }
  
  class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {
    private ActionProvider.VisibilityListener d;
    
    ActionProviderWrapperJB(MenuItemWrapperICS this$0, Context param1Context, ActionProvider param1ActionProvider) {
      super(this$0, param1Context, param1ActionProvider);
    }
    
    public boolean isVisible() {
      return this.a.isVisible();
    }
    
    public void onActionProviderVisibilityChanged(boolean param1Boolean) {
      ActionProvider.VisibilityListener visibilityListener = this.d;
      if (visibilityListener != null)
        visibilityListener.onActionProviderVisibilityChanged(param1Boolean); 
    }
    
    public View onCreateActionView(MenuItem param1MenuItem) {
      return this.a.onCreateActionView(param1MenuItem);
    }
    
    public boolean overridesItemVisibility() {
      return this.a.overridesItemVisibility();
    }
    
    public void refreshVisibility() {
      this.a.refreshVisibility();
    }
    
    public void setVisibilityListener(ActionProvider.VisibilityListener param1VisibilityListener) {
      this.d = param1VisibilityListener;
      ActionProvider actionProvider = this.a;
      if (param1VisibilityListener != null) {
        ActionProviderWrapperJB actionProviderWrapperJB = this;
      } else {
        param1VisibilityListener = null;
      } 
      actionProvider.setVisibilityListener((ActionProvider.VisibilityListener)param1VisibilityListener);
    }
  }
  
  static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
    final CollapsibleActionView a;
    
    CollapsibleActionViewWrapper(View param1View) {
      super(param1View.getContext());
      this.a = (CollapsibleActionView)param1View;
      addView(param1View);
    }
    
    View a() {
      return (View)this.a;
    }
    
    public void onActionViewCollapsed() {
      this.a.onActionViewCollapsed();
    }
    
    public void onActionViewExpanded() {
      this.a.onActionViewExpanded();
    }
  }
  
  class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
    private final MenuItem.OnActionExpandListener b;
    
    OnActionExpandListenerWrapper(MenuItemWrapperICS this$0, MenuItem.OnActionExpandListener param1OnActionExpandListener) {
      this.b = param1OnActionExpandListener;
    }
    
    public boolean onMenuItemActionCollapse(MenuItem param1MenuItem) {
      return this.b.onMenuItemActionCollapse(this.a.a(param1MenuItem));
    }
    
    public boolean onMenuItemActionExpand(MenuItem param1MenuItem) {
      return this.b.onMenuItemActionExpand(this.a.a(param1MenuItem));
    }
  }
  
  class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
    private final MenuItem.OnMenuItemClickListener b;
    
    OnMenuItemClickListenerWrapper(MenuItemWrapperICS this$0, MenuItem.OnMenuItemClickListener param1OnMenuItemClickListener) {
      this.b = param1OnMenuItemClickListener;
    }
    
    public boolean onMenuItemClick(MenuItem param1MenuItem) {
      return this.b.onMenuItemClick(this.a.a(param1MenuItem));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\MenuItemWrapperICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */