package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, b {
  private a a;
  
  private b.a b;
  
  public SSRenderTextureView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SSRenderTextureView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt1, int paramInt2) {
    ViewGroup.LayoutParams layoutParams = getLayoutParams();
    layoutParams.height = paramInt2;
    layoutParams.width = paramInt1;
    setLayoutParams(layoutParams);
  }
  
  public void a(a parama) {
    this.a = parama;
    setSurfaceTextureListener(this);
  }
  
  public SurfaceHolder getHolder() {
    return null;
  }
  
  public View getView() {
    return (View)this;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow() {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramSurfaceTexture, paramInt1, paramInt2); 
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture) {
    a a1 = this.a;
    return (a1 != null && a1.a(paramSurfaceTexture));
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    a a1 = this.a;
    if (a1 != null)
      a1.b(paramSurfaceTexture, paramInt1, paramInt2); 
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {
    a a1 = this.a;
    if (a1 != null)
      a1.b(paramSurfaceTexture); 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    b.a a1 = this.b;
    if (a1 != null)
      a1.a(paramInt); 
  }
  
  public void setWindowVisibilityChangedListener(b.a parama) {
    this.b = parama;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\renderview\SSRenderTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */