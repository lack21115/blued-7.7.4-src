package com.blued.android.core.utils.swipeback;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class SwipeBackListenerActivityAdapter implements SwipeBackLayout.SwipeListenerEx {
  private final WeakReference<Activity> a;
  
  public SwipeBackListenerActivityAdapter(Activity paramActivity) {
    this.a = new WeakReference<Activity>(paramActivity);
  }
  
  public void a() {}
  
  public void a(int paramInt) {
    WeakReference<Activity> weakReference = this.a;
    if (weakReference != null) {
      Activity activity = weakReference.get();
      if (activity != null)
        SwipeBackUtils.a(activity); 
    } 
  }
  
  public void a(int paramInt, float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void b() {
    WeakReference<Activity> weakReference = this.a;
    if (weakReference != null) {
      Activity activity = weakReference.get();
      if (activity != null && !activity.isFinishing()) {
        activity.finish();
        activity.overridePendingTransition(0, 0);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\swipeback\SwipeBackListenerActivityAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */