package com.blued.android.core.imagecache.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;

public class RecyclingImageView extends ImageView {
  public RecyclingImageView(Context paramContext) {
    super(paramContext);
  }
  
  public RecyclingImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static void a(Drawable paramDrawable, boolean paramBoolean) {
    if (paramDrawable instanceof IRecyclingDrawable) {
      ((IRecyclingDrawable)paramDrawable).a(paramBoolean);
      return;
    } 
    if (paramDrawable instanceof LayerDrawable) {
      LayerDrawable layerDrawable = (LayerDrawable)paramDrawable;
      int i = 0;
      int j = layerDrawable.getNumberOfLayers();
      while (i < j) {
        a(layerDrawable.getDrawable(i), paramBoolean);
        i++;
      } 
    } 
  }
  
  protected void onDetachedFromWindow() {
    if (getDrawable() instanceof IRecyclingDrawable)
      setImageDrawable((Drawable)null); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    try {
      super.onDraw(paramCanvas);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    Drawable drawable = getDrawable();
    super.setImageDrawable(paramDrawable);
    a(paramDrawable, true);
    a(drawable, false);
  }
  
  public void setImageResource(int paramInt) {
    if (isInEditMode() || !LoadOptions.a) {
      setImageResourceInner(paramInt);
      return;
    } 
    setImageResourceOverload(paramInt);
  }
  
  public void setImageResourceInner(int paramInt) {
    super.setImageResource(paramInt);
  }
  
  public void setImageResourceOverload(int paramInt) {
    RecyclingImageLoader.a(this, paramInt, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\view\RecyclingImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */