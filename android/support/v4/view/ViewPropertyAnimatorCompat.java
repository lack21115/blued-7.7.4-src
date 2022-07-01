package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
  private WeakReference mView;
  
  public final void cancel() {
    View view = this.mView.get();
    if (view != null)
      view.animate().cancel(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */