package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class SkinAppCompatDelegateImpl extends AppCompatDelegateImpl {
  private static Map<Activity, WeakReference<AppCompatDelegate>> t = new WeakHashMap<Activity, WeakReference<AppCompatDelegate>>();
  
  private SkinAppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback) {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  public static AppCompatDelegate get(Activity paramActivity, AppCompatCallback paramAppCompatCallback) {
    AppCompatDelegate appCompatDelegate1;
    WeakReference<AppCompatDelegate> weakReference = t.get(paramActivity);
    if (weakReference == null) {
      weakReference = null;
    } else {
      appCompatDelegate1 = weakReference.get();
    } 
    AppCompatDelegate appCompatDelegate2 = appCompatDelegate1;
    if (appCompatDelegate1 == null) {
      appCompatDelegate2 = new SkinAppCompatDelegateImpl((Context)paramActivity, paramActivity.getWindow(), paramAppCompatCallback);
      t.put(paramActivity, new WeakReference<AppCompatDelegate>(appCompatDelegate2));
    } 
    return appCompatDelegate2;
  }
  
  public void installViewFactory() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\SkinAppCompatDelegateImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */