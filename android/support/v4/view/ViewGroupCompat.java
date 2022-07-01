package android.support.v4.view;

import android.os.Build;
import android.view.ViewGroup;

public final class ViewGroupCompat {
  private static ViewGroupCompat$ViewGroupCompatBaseImpl IMPL = new ViewGroupCompat$ViewGroupCompatBaseImpl();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean isTransitionGroup(ViewGroup paramViewGroup) {
    return IMPL.isTransitionGroup(paramViewGroup);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new ViewGroupCompat$ViewGroupCompatApi21Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 18) {
      IMPL = new ViewGroupCompat$ViewGroupCompatApi18Impl();
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewGroupCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */