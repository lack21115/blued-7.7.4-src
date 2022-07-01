package com.tencent.ijk.media.player;

import android.graphics.Rect;

public final class IjkTimedText {
  private Rect mTextBounds = null;
  
  private String mTextChars = null;
  
  public IjkTimedText(Rect paramRect, String paramString) {
    this.mTextBounds = paramRect;
    this.mTextChars = paramString;
  }
  
  public Rect getBounds() {
    return this.mTextBounds;
  }
  
  public String getText() {
    return this.mTextChars;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\IjkTimedText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */