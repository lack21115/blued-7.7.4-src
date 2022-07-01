package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentTabHost;

public class MyFragmentTabHost extends FragmentTabHost {
  public MyFragmentTabHost(Context paramContext) {
    super(paramContext);
  }
  
  public MyFragmentTabHost(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void onAttachedToWindow() {
    try {
      super.onAttachedToWindow();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\MyFragmentTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */