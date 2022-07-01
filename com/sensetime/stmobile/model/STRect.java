package com.sensetime.stmobile.model;

import android.graphics.Rect;

public class STRect {
  private int bottom;
  
  private int left;
  
  private int right;
  
  private int top;
  
  public STRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  public Rect getRect() {
    Rect rect = new Rect();
    rect.left = this.left;
    rect.top = this.top;
    rect.right = this.right;
    rect.bottom = this.bottom;
    return rect;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */