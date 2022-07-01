package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
  private final ViewGroupOverlay a;
  
  ViewGroupOverlayApi18(ViewGroup paramViewGroup) {
    this.a = paramViewGroup.getOverlay();
  }
  
  public void add(Drawable paramDrawable) {
    this.a.add(paramDrawable);
  }
  
  public void add(View paramView) {
    this.a.add(paramView);
  }
  
  public void remove(Drawable paramDrawable) {
    this.a.remove(paramDrawable);
  }
  
  public void remove(View paramView) {
    this.a.remove(paramView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewGroupOverlayApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */