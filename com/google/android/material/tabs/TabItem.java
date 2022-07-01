package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

public class TabItem extends View {
  public final CharSequence a;
  
  public final Drawable b;
  
  public final int c;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.TabItem);
    this.a = tintTypedArray.getText(R.styleable.TabItem_android_text);
    this.b = tintTypedArray.getDrawable(R.styleable.TabItem_android_icon);
    this.c = tintTypedArray.getResourceId(R.styleable.TabItem_android_layout, 0);
    tintTypedArray.recycle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\tabs\TabItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */