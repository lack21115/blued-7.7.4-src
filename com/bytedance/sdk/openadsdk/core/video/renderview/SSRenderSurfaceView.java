package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {
  private static final ArrayList<c> c = new ArrayList<c>();
  
  private WeakReference<a> a;
  
  private c b;
  
  private b.a d;
  
  public SSRenderSurfaceView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  private void a() {
    this.b = new c(this);
    c.add(this.b);
  }
  
  public void a(int paramInt1, int paramInt2) {
    ViewGroup.LayoutParams layoutParams = getLayoutParams();
    layoutParams.height = paramInt2;
    layoutParams.width = paramInt1;
    setLayoutParams(layoutParams);
  }
  
  public void a(a parama) {
    this.a = new WeakReference<a>(parama);
    SurfaceHolder surfaceHolder = getHolder();
    surfaceHolder.setFormat(-3);
    Iterator<c> iterator = c.iterator();
    while (iterator.hasNext()) {
      c c1 = iterator.next();
      if (c1.a() == null) {
        surfaceHolder.removeCallback(c1);
        iterator.remove();
      } 
    } 
    surfaceHolder.addCallback(this.b);
  }
  
  public View getView() {
    return (View)this;
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    b.a a1 = this.d;
    if (a1 != null)
      a1.a(paramInt); 
  }
  
  public void setWindowVisibilityChangedListener(b.a parama) {
    this.d = parama;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {
    WeakReference<a> weakReference = this.a;
    if (weakReference != null && weakReference.get() != null)
      ((a)this.a.get()).a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3); 
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    WeakReference<a> weakReference = this.a;
    if (weakReference != null && weakReference.get() != null)
      ((a)this.a.get()).a(paramSurfaceHolder); 
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    WeakReference<a> weakReference = this.a;
    if (weakReference != null && weakReference.get() != null)
      ((a)this.a.get()).b(paramSurfaceHolder); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\renderview\SSRenderSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */