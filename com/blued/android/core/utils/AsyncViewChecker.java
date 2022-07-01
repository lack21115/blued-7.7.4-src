package com.blued.android.core.utils;

import android.view.View;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AsyncViewChecker<T> {
  private final Map<Integer, T> a = Collections.synchronizedMap(new HashMap<Integer, T>());
  
  public void a(View paramView) {
    if (paramView != null)
      this.a.remove(Integer.valueOf(paramView.hashCode())); 
  }
  
  public void a(View paramView, T paramT) {
    if (paramView != null)
      this.a.put(Integer.valueOf(paramView.hashCode()), paramT); 
  }
  
  public boolean b(View paramView, T paramT) {
    if (paramView != null) {
      paramView = (View)this.a.get(Integer.valueOf(paramView.hashCode()));
      if (paramView != null)
        return paramView.equals(paramT); 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\AsyncViewChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */