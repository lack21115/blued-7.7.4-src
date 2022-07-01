package android.support.v7.widget;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(26)
final class TooltipCompat$Api26ViewCompatImpl implements TooltipCompat$ViewCompatImpl {
  private TooltipCompat$Api26ViewCompatImpl() {}
  
  public final void setTooltipText(View paramView, CharSequence paramCharSequence) {
    paramView.setTooltipText(paramCharSequence);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\TooltipCompat$Api26ViewCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */