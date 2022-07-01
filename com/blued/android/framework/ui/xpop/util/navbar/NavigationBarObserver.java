package com.blued.android.framework.ui.xpop.util.navbar;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;

public final class NavigationBarObserver extends ContentObserver {
  private ArrayList<OnNavigationBarListener> a;
  
  private Context b;
  
  private Boolean c = Boolean.valueOf(false);
  
  private NavigationBarObserver() {
    super(new Handler(Looper.getMainLooper()));
  }
  
  public void onChange(boolean paramBoolean) {
    super.onChange(paramBoolean);
    if (Build.VERSION.SDK_INT >= 17) {
      Context context = this.b;
      if (context != null && context.getContentResolver() != null) {
        ArrayList<OnNavigationBarListener> arrayList = this.a;
        if (arrayList != null && !arrayList.isEmpty()) {
          boolean bool;
          if (OSUtils.a()) {
            bool = Settings.Global.getInt(this.b.getContentResolver(), "force_fsg_nav_bar", 0);
          } else if (OSUtils.b()) {
            if (OSUtils.f() || Build.VERSION.SDK_INT < 21) {
              bool = Settings.System.getInt(this.b.getContentResolver(), "navigationbar_is_min", 0);
            } else {
              bool = Settings.Global.getInt(this.b.getContentResolver(), "navigationbar_is_min", 0);
            } 
          } else {
            bool = false;
          } 
          for (OnNavigationBarListener onNavigationBarListener : this.a) {
            paramBoolean = true;
            if (bool == true)
              paramBoolean = false; 
            onNavigationBarListener.a(paramBoolean);
          } 
        } 
      } 
    } 
  }
  
  static class NavigationBarObserverInstance {
    private static final NavigationBarObserver a = new NavigationBarObserver();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpo\\util\navbar\NavigationBarObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */