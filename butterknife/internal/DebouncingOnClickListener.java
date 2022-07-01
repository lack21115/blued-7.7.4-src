package butterknife.internal;

import android.view.View;

public abstract class DebouncingOnClickListener implements View.OnClickListener {
  static boolean a = true;
  
  private static final Runnable b = -$$Lambda$DebouncingOnClickListener$fKu_GIo_pW_YXcz3KkfF3UXipRU.INSTANCE;
  
  public abstract void a(View paramView);
  
  public final void onClick(View paramView) {
    if (a) {
      a = false;
      paramView.post(b);
      a(paramView);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\butterknife\internal\DebouncingOnClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */