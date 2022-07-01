package com.soft.blued.customview.emoji.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.appcompat.content.res.AppCompatResources;

final class EmojiSpan extends DynamicDrawableSpan {
  private final Context a;
  
  private final int b;
  
  private final int c;
  
  private Drawable d;
  
  public Drawable getDrawable() {
    if (this.d == null) {
      this.d = AppCompatResources.getDrawable(this.a, this.b);
      Drawable drawable = this.d;
      int i = this.c;
      drawable.setBounds(0, 0, i, i);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\EmojiSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */