package androidx.transition;

import android.view.View;
import android.view.WindowId;

class WindowIdApi18 implements WindowIdImpl {
  private final WindowId a;
  
  WindowIdApi18(View paramView) {
    this.a = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof WindowIdApi18 && ((WindowIdApi18)paramObject).a.equals(this.a));
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\WindowIdApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */