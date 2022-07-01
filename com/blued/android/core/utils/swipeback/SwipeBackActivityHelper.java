package com.blued.android.core.utils.swipeback;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import com.blued.blued_core.R;

public class SwipeBackActivityHelper {
  private SwipeBackLayout a;
  
  private boolean b = true;
  
  private boolean a() {
    return (SwipeBackConfig.a() && this.b && this.a != null);
  }
  
  public <T extends android.view.View> T a(int paramInt) {
    SwipeBackLayout swipeBackLayout = this.a;
    return (T)((swipeBackLayout != null) ? swipeBackLayout.findViewById(paramInt) : null);
  }
  
  public void a(Activity paramActivity) {
    if (SwipeBackConfig.a())
      this.a = (SwipeBackLayout)LayoutInflater.from((Context)paramActivity).inflate(R.layout.blued_swipeback_layout, null); 
  }
  
  public void a(boolean paramBoolean) {
    if (a()) {
      this.b = paramBoolean;
      this.a.setEnableGesture(paramBoolean);
    } 
  }
  
  public void b(Activity paramActivity) {
    if (this.a != null) {
      paramActivity.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramActivity.getWindow().getDecorView().setBackgroundColor(0);
      this.a.a(paramActivity);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\swipeback\SwipeBackActivityHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */