package org.chromium.content_public.browser;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextSelection;

public final class SelectionClient$Result {
  public int endAdjust;
  
  public Drawable icon;
  
  public Intent intent;
  
  public CharSequence label;
  
  public View.OnClickListener onClickListener;
  
  public int startAdjust;
  
  public TextClassification textClassification;
  
  public TextSelection textSelection;
  
  public final boolean hasNamedAction() {
    return ((this.label != null || this.icon != null) && (this.intent != null || this.onClickListener != null));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\SelectionClient$Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */