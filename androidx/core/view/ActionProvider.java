package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {
  private final Context a;
  
  private SubUiVisibilityListener b;
  
  private VisibilityListener c;
  
  public ActionProvider(Context paramContext) {
    this.a = paramContext;
  }
  
  public Context getContext() {
    return this.a;
  }
  
  public boolean hasSubMenu() {
    return false;
  }
  
  public boolean isVisible() {
    return true;
  }
  
  public abstract View onCreateActionView();
  
  public View onCreateActionView(MenuItem paramMenuItem) {
    return onCreateActionView();
  }
  
  public boolean onPerformDefaultAction() {
    return false;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu) {}
  
  public boolean overridesItemVisibility() {
    return false;
  }
  
  public void refreshVisibility() {
    if (this.c != null && overridesItemVisibility())
      this.c.onActionProviderVisibilityChanged(isVisible()); 
  }
  
  public void reset() {
    this.c = null;
    this.b = null;
  }
  
  public void setSubUiVisibilityListener(SubUiVisibilityListener paramSubUiVisibilityListener) {
    this.b = paramSubUiVisibilityListener;
  }
  
  public void setVisibilityListener(VisibilityListener paramVisibilityListener) {
    if (this.c != null && paramVisibilityListener != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
      stringBuilder.append(getClass().getSimpleName());
      stringBuilder.append(" instance while it is still in use somewhere else?");
      Log.w("ActionProvider(support)", stringBuilder.toString());
    } 
    this.c = paramVisibilityListener;
  }
  
  public void subUiVisibilityChanged(boolean paramBoolean) {
    SubUiVisibilityListener subUiVisibilityListener = this.b;
    if (subUiVisibilityListener != null)
      subUiVisibilityListener.onSubUiVisibilityChanged(paramBoolean); 
  }
  
  public static interface SubUiVisibilityListener {
    void onSubUiVisibilityChanged(boolean param1Boolean);
  }
  
  public static interface VisibilityListener {
    void onActionProviderVisibilityChanged(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\ActionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */