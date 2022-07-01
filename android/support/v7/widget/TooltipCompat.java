package android.support.v7.widget;

import android.os.Build;
import android.view.View;

public final class TooltipCompat {
  private static final TooltipCompat$ViewCompatImpl IMPL = new TooltipCompat$BaseViewCompatImpl((byte)0);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence) {
    IMPL.setTooltipText(paramView, paramCharSequence);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 26) {
      IMPL = new TooltipCompat$Api26ViewCompatImpl((byte)0);
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\TooltipCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */