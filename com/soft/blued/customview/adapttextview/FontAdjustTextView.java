package com.soft.blued.customview.adapttextview;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.config.FlexDebugSevConfig;
import com.soft.blued.customview.emoji.view.EmojiTextView;

public class FontAdjustTextView extends EmojiTextView {
  public FontAdjustTextView(Context paramContext) {
    this(paramContext, null);
  }
  
  public FontAdjustTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontAdjustTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if ((FlexDebugSevConfig.a().b()).android_font_adjust == 1)
      setTextSize(FontAdjustTextHelper.a()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\adapttextview\FontAdjustTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */