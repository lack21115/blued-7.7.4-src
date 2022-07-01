package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class PLTextView extends EditText {
  public PLTextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setCursorVisible(false);
    setBackgroundColor(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */