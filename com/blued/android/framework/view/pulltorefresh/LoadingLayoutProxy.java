package com.blued.android.framework.view.pulltorefresh;

import android.graphics.drawable.Drawable;
import java.util.HashSet;
import java.util.Iterator;

public class LoadingLayoutProxy implements ILoadingLayout {
  private final HashSet<LoadingLayout> a = new HashSet<LoadingLayout>();
  
  public void a(LoadingLayout paramLoadingLayout) {
    if (paramLoadingLayout != null)
      this.a.add(paramLoadingLayout); 
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence) {
    Iterator<LoadingLayout> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((LoadingLayout)iterator.next()).setLastUpdatedLabel(paramCharSequence); 
  }
  
  public void setLoadingDrawable(Drawable paramDrawable) {
    Iterator<LoadingLayout> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((LoadingLayout)iterator.next()).setLoadingDrawable(paramDrawable); 
  }
  
  public void setPullLabel(CharSequence paramCharSequence) {
    Iterator<LoadingLayout> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((LoadingLayout)iterator.next()).setPullLabel(paramCharSequence); 
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence) {
    Iterator<LoadingLayout> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((LoadingLayout)iterator.next()).setRefreshingLabel(paramCharSequence); 
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence) {
    Iterator<LoadingLayout> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((LoadingLayout)iterator.next()).setReleaseLabel(paramCharSequence); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\LoadingLayoutProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */