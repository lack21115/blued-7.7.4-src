package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
  private final ActionBar.OnNavigationListener a;
  
  public NavItemSelectedListener(ActionBar.OnNavigationListener paramOnNavigationListener) {
    this.a = paramOnNavigationListener;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    ActionBar.OnNavigationListener onNavigationListener = this.a;
    if (onNavigationListener != null)
      onNavigationListener.onNavigationItemSelected(paramInt, paramLong); 
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\NavItemSelectedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */