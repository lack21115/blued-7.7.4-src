package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ViewOverlayApi18 implements ViewOverlayImpl {
  private final ViewOverlay a;
  
  ViewOverlayApi18(View paramView) {
    this.a = paramView.getOverlay();
  }
  
  public void add(Drawable paramDrawable) {
    this.a.add(paramDrawable);
  }
  
  public void remove(Drawable paramDrawable) {
    this.a.remove(paramDrawable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewOverlayApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */