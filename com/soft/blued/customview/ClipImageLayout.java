package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.soft.blued.utils.BitmapUtils;

public class ClipImageLayout extends RelativeLayout {
  private ClipZoomImageView a;
  
  private ClipImageBorderView b;
  
  private int c = 20;
  
  private int d = 0;
  
  public ClipImageLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = new ClipZoomImageView(paramContext);
    this.b = new ClipImageBorderView(paramContext);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView((View)this.a, (ViewGroup.LayoutParams)layoutParams);
    addView(this.b, (ViewGroup.LayoutParams)layoutParams);
    this.c = (int)TypedValue.applyDimension(1, this.c, getResources().getDisplayMetrics());
  }
  
  public Bitmap a() {
    return this.a.a();
  }
  
  public void setHorizontalPadding(int paramInt) {
    this.c = paramInt;
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    this.a.setImageBitmap(BitmapUtils.a(paramBitmap));
  }
  
  public void setVerticalPadding(int paramInt) {
    this.d = paramInt;
    this.a.setVerticalPadding(paramInt);
    this.b.setVerticalPadding(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ClipImageLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */