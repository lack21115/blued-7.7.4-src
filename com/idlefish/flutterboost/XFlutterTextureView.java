package com.idlefish.flutterboost;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class XFlutterTextureView extends TextureView implements RenderSurface {
  private boolean a = false;
  
  private boolean b = false;
  
  private FlutterRenderer c;
  
  private Surface d;
  
  private final TextureView.SurfaceTextureListener e = new TextureView.SurfaceTextureListener(this) {
      public void onSurfaceTextureAvailable(SurfaceTexture param1SurfaceTexture, int param1Int1, int param1Int2) {
        Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
        XFlutterTextureView.a(this.a, true);
        if (XFlutterTextureView.a(this.a))
          XFlutterTextureView.b(this.a); 
      }
      
      public boolean onSurfaceTextureDestroyed(SurfaceTexture param1SurfaceTexture) {
        Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
        XFlutterTextureView.a(this.a, false);
        if (XFlutterTextureView.a(this.a))
          XFlutterTextureView.c(this.a); 
        return true;
      }
      
      public void onSurfaceTextureSizeChanged(SurfaceTexture param1SurfaceTexture, int param1Int1, int param1Int2) {
        Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
        if (XFlutterTextureView.a(this.a))
          XFlutterTextureView.a(this.a, param1Int1, param1Int2); 
      }
      
      public void onSurfaceTextureUpdated(SurfaceTexture param1SurfaceTexture) {}
    };
  
  public XFlutterTextureView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public XFlutterTextureView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a() {
    setSurfaceTextureListener(this.e);
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (this.c != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Notifying FlutterRenderer that Android surface size has changed to ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" x ");
      stringBuilder.append(paramInt2);
      Log.v("FlutterTextureView", stringBuilder.toString());
      this.c.surfaceChanged(paramInt1, paramInt2);
      return;
    } 
    throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
  }
  
  private void b() {
    if (this.c != null && getSurfaceTexture() != null) {
      this.d = new Surface(getSurfaceTexture());
      this.c.startRenderingToSurface(this.d);
      return;
    } 
    throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
  }
  
  private void c() {
    FlutterRenderer flutterRenderer = this.c;
    if (flutterRenderer != null) {
      flutterRenderer.stopRenderingToSurface();
      Surface surface = this.d;
      if (surface != null) {
        surface.release();
        this.d = null;
      } 
      return;
    } 
    throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
  }
  
  public void attachToRenderer(FlutterRenderer paramFlutterRenderer) {
    Log.v("FlutterTextureView", "Attaching to FlutterRenderer.");
    if (this.c != null) {
      Log.v("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
      this.c.stopRenderingToSurface();
    } 
    this.c = paramFlutterRenderer;
    this.b = true;
    if (this.a) {
      Log.v("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
      b();
    } 
  }
  
  public void detachFromRenderer() {
    if (this.c != null) {
      if (getWindowToken() != null) {
        Log.v("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
        c();
      } 
      this.c = null;
      this.b = false;
      return;
    } 
    Log.w("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
  }
  
  public FlutterRenderer getAttachedRenderer() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\XFlutterTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */