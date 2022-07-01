package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;

public class ActivityChooserView$InnerLayout extends LinearLayoutCompat {
  private static final int[] TINT_ATTRS = new int[] { 16842964 };
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ActivityChooserView$InnerLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS);
    setBackgroundDrawable(tintTypedArray.getDrawable(0));
    tintTypedArray.mWrapped.recycle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserView$InnerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */