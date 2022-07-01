package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
  ViewGroupOverlayApi14(Context paramContext, ViewGroup paramViewGroup, View paramView) {
    super(paramContext, paramViewGroup, paramView);
  }
  
  static ViewGroupOverlayApi14 a(ViewGroup paramViewGroup) {
    return (ViewGroupOverlayApi14)ViewOverlayApi14.b((View)paramViewGroup);
  }
  
  public void add(View paramView) {
    this.a.add(paramView);
  }
  
  public void remove(View paramView) {
    this.a.remove(paramView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewGroupOverlayApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */