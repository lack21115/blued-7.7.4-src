package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;

public class TTRatingBar extends LinearLayout {
  private int a = 5;
  
  private int b = 0;
  
  private int c = 0;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private Drawable g;
  
  private Drawable h;
  
  private Drawable i;
  
  public TTRatingBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    this.g = ab.c(paramContext, "tt_star_empty_bg");
    this.h = ab.c(paramContext, "tt_star_full_bg");
    this.i = ab.c(paramContext, "tt_star_empty_bg");
    this.d = ai.c(paramContext, 15.0F);
    this.e = ai.c(paramContext, 15.0F);
    this.f = ai.c(paramContext, 5.0F);
  }
  
  private ImageView getStarImageView() {
    ImageView imageView = new ImageView(getContext());
    imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.d), Math.round(this.e)));
    imageView.setPadding(0, 0, Math.round(this.f), 0);
    return imageView;
  }
  
  public void a() {
    int j;
    removeAllViews();
    byte b = 0;
    int i;
    for (i = 0; i < getStarFillNum(); i++) {
      ImageView imageView = getStarImageView();
      imageView.setImageDrawable(getStarFillDrawable());
      addView((View)imageView);
    } 
    i = 0;
    while (true) {
      j = b;
      if (i < getStarHalfNum()) {
        ImageView imageView = getStarImageView();
        imageView.setImageDrawable(getStarHalfDrawable());
        addView((View)imageView);
        i++;
        continue;
      } 
      break;
    } 
    while (j < getStarEmptyNum()) {
      ImageView imageView = getStarImageView();
      imageView.setImageDrawable(getStarEmptyDrawable());
      addView((View)imageView);
      j++;
    } 
  }
  
  public Drawable getStarEmptyDrawable() {
    return this.g;
  }
  
  public int getStarEmptyNum() {
    return this.c;
  }
  
  public Drawable getStarFillDrawable() {
    return this.h;
  }
  
  public int getStarFillNum() {
    return this.a;
  }
  
  public Drawable getStarHalfDrawable() {
    return this.i;
  }
  
  public int getStarHalfNum() {
    return this.b;
  }
  
  public float getStarImageHeight() {
    return this.e;
  }
  
  public float getStarImagePadding() {
    return this.f;
  }
  
  public float getStarImageWidth() {
    return this.d;
  }
  
  public void setStarEmptyDrawable(Drawable paramDrawable) {
    this.g = paramDrawable;
  }
  
  public void setStarEmptyNum(int paramInt) {
    this.c = paramInt;
  }
  
  public void setStarFillDrawable(Drawable paramDrawable) {
    this.h = paramDrawable;
  }
  
  public void setStarFillNum(int paramInt) {
    this.a = paramInt;
  }
  
  public void setStarHalfDrawable(Drawable paramDrawable) {
    this.i = paramDrawable;
  }
  
  public void setStarHalfNum(int paramInt) {
    this.b = paramInt;
  }
  
  public void setStarImageHeight(float paramFloat) {
    this.e = paramFloat;
  }
  
  public void setStarImagePadding(float paramFloat) {
    this.f = paramFloat;
  }
  
  public void setStarImageWidth(float paramFloat) {
    this.d = paramFloat;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\TTRatingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */