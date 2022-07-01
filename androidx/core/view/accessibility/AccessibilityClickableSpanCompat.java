package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class AccessibilityClickableSpanCompat extends ClickableSpan {
  public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
  
  private final int a;
  
  private final AccessibilityNodeInfoCompat b;
  
  private final int c;
  
  public AccessibilityClickableSpanCompat(int paramInt1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, int paramInt2) {
    this.a = paramInt1;
    this.b = paramAccessibilityNodeInfoCompat;
    this.c = paramInt2;
  }
  
  public void onClick(View paramView) {
    Bundle bundle = new Bundle();
    bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
    this.b.performAction(this.c, bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\accessibility\AccessibilityClickableSpanCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */