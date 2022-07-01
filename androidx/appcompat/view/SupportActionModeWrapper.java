package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

public class SupportActionModeWrapper extends ActionMode {
  final Context a;
  
  final ActionMode b;
  
  public SupportActionModeWrapper(Context paramContext, ActionMode paramActionMode) {
    this.a = paramContext;
    this.b = paramActionMode;
  }
  
  public void finish() {
    this.b.finish();
  }
  
  public View getCustomView() {
    return this.b.getCustomView();
  }
  
  public Menu getMenu() {
    return (Menu)new MenuWrapperICS(this.a, (SupportMenu)this.b.getMenu());
  }
  
  public MenuInflater getMenuInflater() {
    return this.b.getMenuInflater();
  }
  
  public CharSequence getSubtitle() {
    return this.b.getSubtitle();
  }
  
  public Object getTag() {
    return this.b.getTag();
  }
  
  public CharSequence getTitle() {
    return this.b.getTitle();
  }
  
  public boolean getTitleOptionalHint() {
    return this.b.getTitleOptionalHint();
  }
  
  public void invalidate() {
    this.b.invalidate();
  }
  
  public boolean isTitleOptional() {
    return this.b.isTitleOptional();
  }
  
  public void setCustomView(View paramView) {
    this.b.setCustomView(paramView);
  }
  
  public void setSubtitle(int paramInt) {
    this.b.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.b.setSubtitle(paramCharSequence);
  }
  
  public void setTag(Object paramObject) {
    this.b.setTag(paramObject);
  }
  
  public void setTitle(int paramInt) {
    this.b.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.b.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean) {
    this.b.setTitleOptionalHint(paramBoolean);
  }
  
  public static class CallbackWrapper implements ActionMode.Callback {
    final ActionMode.Callback a;
    
    final Context b;
    
    final ArrayList<SupportActionModeWrapper> c;
    
    final SimpleArrayMap<Menu, Menu> d;
    
    public CallbackWrapper(Context param1Context, ActionMode.Callback param1Callback) {
      this.b = param1Context;
      this.a = param1Callback;
      this.c = new ArrayList<SupportActionModeWrapper>();
      this.d = new SimpleArrayMap();
    }
    
    private Menu a(Menu param1Menu) {
      MenuWrapperICS menuWrapperICS;
      Menu menu2 = (Menu)this.d.get(param1Menu);
      Menu menu1 = menu2;
      if (menu2 == null) {
        menuWrapperICS = new MenuWrapperICS(this.b, (SupportMenu)param1Menu);
        this.d.put(param1Menu, menuWrapperICS);
      } 
      return (Menu)menuWrapperICS;
    }
    
    public ActionMode getActionModeWrapper(ActionMode param1ActionMode) {
      int j = this.c.size();
      for (int i = 0; i < j; i++) {
        SupportActionModeWrapper supportActionModeWrapper1 = this.c.get(i);
        if (supportActionModeWrapper1 != null && supportActionModeWrapper1.b == param1ActionMode)
          return supportActionModeWrapper1; 
      } 
      SupportActionModeWrapper supportActionModeWrapper = new SupportActionModeWrapper(this.b, param1ActionMode);
      this.c.add(supportActionModeWrapper);
      return supportActionModeWrapper;
    }
    
    public boolean onActionItemClicked(ActionMode param1ActionMode, MenuItem param1MenuItem) {
      return this.a.onActionItemClicked(getActionModeWrapper(param1ActionMode), (MenuItem)new MenuItemWrapperICS(this.b, (SupportMenuItem)param1MenuItem));
    }
    
    public boolean onCreateActionMode(ActionMode param1ActionMode, Menu param1Menu) {
      return this.a.onCreateActionMode(getActionModeWrapper(param1ActionMode), a(param1Menu));
    }
    
    public void onDestroyActionMode(ActionMode param1ActionMode) {
      this.a.onDestroyActionMode(getActionModeWrapper(param1ActionMode));
    }
    
    public boolean onPrepareActionMode(ActionMode param1ActionMode, Menu param1Menu) {
      return this.a.onPrepareActionMode(getActionModeWrapper(param1ActionMode), a(param1Menu));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\SupportActionModeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */