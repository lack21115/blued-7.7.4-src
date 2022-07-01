package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AppCompatToggleButton extends ToggleButton {
  private final AppCompatTextHelper a = new AppCompatTextHelper((TextView)this);
  
  public AppCompatToggleButton(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatToggleButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842827);
  }
  
  public AppCompatToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatToggleButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */