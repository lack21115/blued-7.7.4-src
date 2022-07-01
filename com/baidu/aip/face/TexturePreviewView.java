package com.baidu.aip.face;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

public class TexturePreviewView extends FrameLayout implements PreviewView {
  private Handler handler = new Handler(Looper.getMainLooper());
  
  private boolean mirrored = true;
  
  private PreviewView.ScaleType scaleType = PreviewView.ScaleType.CROP_INSIDE;
  
  private TextureView textureView;
  
  private int videoHeight = 0;
  
  private int videoWidth = 0;
  
  public TexturePreviewView(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public TexturePreviewView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TexturePreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {
    this.textureView = new TextureView(getContext());
    addView((View)this.textureView);
  }
  
  private PreviewView.ScaleType resolveScaleType() {
    if (getHeight() <= 0 || this.videoHeight <= 0)
      return PreviewView.ScaleType.CROP_INSIDE; 
    float f1 = getWidth() * 1.0F / getHeight();
    float f2 = this.videoWidth * 1.0F / this.videoHeight;
    PreviewView.ScaleType scaleType2 = this.scaleType;
    PreviewView.ScaleType scaleType1 = scaleType2;
    if (scaleType2 == PreviewView.ScaleType.CROP_INSIDE)
      if (f1 > f2) {
        scaleType1 = PreviewView.ScaleType.FIT_WIDTH;
      } else {
        scaleType1 = PreviewView.ScaleType.FIT_HEIGHT;
      }  
    return scaleType1;
  }
  
  public PreviewView.ScaleType getScaleType() {
    return this.scaleType;
  }
  
  public TextureView getTextureView() {
    return this.textureView;
  }
  
  public void mapFromOriginalRect(RectF paramRectF) {
    int i = getWidth();
    int j = getHeight();
    if (this.videoWidth != 0 && this.videoHeight != 0 && i != 0) {
      if (j == 0)
        return; 
      Matrix matrix = new Matrix();
      if (resolveScaleType() == PreviewView.ScaleType.FIT_HEIGHT) {
        int m = this.videoWidth;
        int k = this.videoHeight;
        m = (m * j / k - i) / 2;
        float f = j * 1.0F / k;
        matrix.postScale(f, f);
        matrix.postTranslate(-m, 0.0F);
      } else {
        int m = this.videoHeight;
        int k = this.videoWidth;
        j = (m * i / k - j) / 2;
        float f = i * 1.0F / k;
        matrix.postScale(f, f);
        matrix.postTranslate(0.0F, -j);
      } 
      matrix.mapRect(paramRectF);
      if (this.mirrored) {
        float f1 = i - paramRectF.right;
        float f2 = paramRectF.width();
        paramRectF.left = f1;
        paramRectF.right = f2 + f1;
      } 
    } 
  }
  
  public void mapFromOriginalRectEx(RectF paramRectF) {
    int i = getWidth();
    int j = getHeight();
    if (this.videoWidth != 0 && this.videoHeight != 0 && i != 0) {
      if (j == 0)
        return; 
      Matrix matrix = new Matrix();
      float f1 = i;
      float f2 = 1.0F * f1 / this.videoWidth;
      matrix.postScale(f2, f2);
      matrix.mapRect(paramRectF);
      if (this.mirrored) {
        f1 -= paramRectF.right;
        f2 = paramRectF.width();
        paramRectF.left = f1;
        paramRectF.right = f2 + f1;
      } 
    } 
  }
  
  public void mapToOriginalRect(RectF paramRectF) {
    int i = getWidth();
    int j = getHeight();
    if (this.videoWidth != 0 && this.videoHeight != 0 && i != 0) {
      if (j == 0)
        return; 
      Matrix matrix = new Matrix();
      if (resolveScaleType() == PreviewView.ScaleType.FIT_HEIGHT) {
        int m = this.videoWidth;
        int k = this.videoHeight;
        i = (m * j / k - i) / 2;
        float f = k * 1.0F / j;
        matrix.postTranslate(i, 0.0F);
        matrix.postScale(f, f);
      } else {
        int m = this.videoHeight;
        int k = this.videoWidth;
        j = (m * i / k - j) / 2;
        float f = k * 1.0F / i;
        matrix.postTranslate(0.0F, j);
        matrix.postScale(f, f);
      } 
      matrix.mapRect(paramRectF);
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i = getWidth();
    int j = getHeight();
    if (this.videoWidth != 0 && this.videoHeight != 0 && i != 0) {
      if (j == 0)
        return; 
      if (resolveScaleType() == PreviewView.ScaleType.FIT_HEIGHT) {
        i = (this.videoWidth * j / this.videoHeight - i) / 2;
        this.textureView.layout(paramInt1 - i, paramInt2, paramInt3 + i, paramInt4);
        return;
      } 
      i = (this.videoHeight * i / this.videoWidth - j) / 2;
      this.textureView.layout(paramInt1, paramInt2 - i, paramInt3, paramInt4 + i);
    } 
  }
  
  public void setMirrored(boolean paramBoolean) {
    this.mirrored = paramBoolean;
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2) {
    if (this.videoWidth == paramInt1 && this.videoHeight == paramInt2)
      return; 
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.handler.post(new Runnable() {
          public void run() {
            TexturePreviewView.this.requestLayout();
          }
        });
  }
  
  public void setScaleType(PreviewView.ScaleType paramScaleType) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\TexturePreviewView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */