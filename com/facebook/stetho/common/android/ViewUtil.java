package com.facebook.stetho.common.android;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import javax.annotation.Nullable;

final class ViewUtil {
  @Nullable
  private static Activity tryGetActivity(Context paramContext) {
    while (paramContext != null) {
      if (paramContext instanceof Activity)
        return (Activity)paramContext; 
      if (paramContext instanceof ContextWrapper)
        paramContext = ((ContextWrapper)paramContext).getBaseContext(); 
    } 
    return null;
  }
  
  @Nullable
  static Activity tryGetActivity(View paramView) {
    if (paramView == null)
      return null; 
    Activity activity = tryGetActivity(paramView.getContext());
    if (activity != null)
      return activity; 
    ViewParent viewParent = paramView.getParent();
    return (viewParent instanceof View) ? tryGetActivity((View)viewParent) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\ViewUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */