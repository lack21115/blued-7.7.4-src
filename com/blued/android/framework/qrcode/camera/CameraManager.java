package com.blued.android.framework.qrcode.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.IOException;

public final class CameraManager {
  static {
    try {
      c = Integer.parseInt(Build.VERSION.SDK);
    } catch (NumberFormatException numberFormatException) {
      c = '✐';
    } 
    a = c;
  }
  
  private CameraManager(Context paramContext) {
    boolean bool;
    this.d = paramContext;
    this.e = new CameraConfigurationManager(paramContext);
    if (Integer.parseInt(Build.VERSION.SDK) > 3) {
      bool = true;
    } else {
      bool = false;
    } 
    this.i = bool;
    this.j = new PreviewCallback(this.e, this.i);
    this.k = new AutoFocusCallback();
  }
  
  public static CameraManager a() {
    return c;
  }
  
  public static void a(Context paramContext) {
    if (c == null)
      c = new CameraManager(paramContext); 
  }
  
  public PlanarYUVLuminanceSource a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Rect paramRect) {
    return (paramRect == null) ? null : new PlanarYUVLuminanceSource(paramArrayOfbyte, paramInt1, paramInt2, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), false);
  }
  
  public void a(Handler paramHandler, int paramInt) {
    if (this.f != null && this.h) {
      this.j.a(paramHandler, paramInt);
      if (this.i) {
        this.f.setOneShotPreviewCallback(this.j);
        return;
      } 
      this.f.setPreviewCallback(this.j);
    } 
  }
  
  public void a(SurfaceHolder paramSurfaceHolder) throws IOException {
    if (this.f == null) {
      this.f = Camera.open();
      Camera camera = this.f;
      if (camera != null) {
        camera.setPreviewDisplay(paramSurfaceHolder);
        if (!this.g) {
          this.g = true;
          this.e.a(this.f);
        } 
        this.e.b(this.f);
        FlashlightManager.a();
        return;
      } 
      throw new IOException();
    } 
  }
  
  public void b() {
    if (this.f != null) {
      FlashlightManager.b();
      this.f.release();
      this.f = null;
    } 
  }
  
  public void b(Handler paramHandler, int paramInt) {
    if (this.f != null && this.h) {
      this.k.a(paramHandler, paramInt);
      try {
        this.f.autoFocus(this.k);
        return;
      } catch (Exception exception) {
        Log.i(b, "Requested auto-focus callback fail.");
      } 
    } 
  }
  
  public Point c() {
    return this.e.a();
  }
  
  public void d() {
    Camera camera = this.f;
    if (camera != null && !this.h) {
      camera.startPreview();
      this.h = true;
    } 
  }
  
  public void e() {
    Camera camera = this.f;
    if (camera != null && this.h) {
      if (!this.i)
        camera.setPreviewCallback(null); 
      this.f.stopPreview();
      this.j.a(null, 0);
      this.k.a(null, 0);
      this.h = false;
    } 
  }
  
  public void f() {
    Camera camera = this.f;
    if (camera != null) {
      this.l = camera.getParameters();
      this.l.setFlashMode("torch");
      this.f.setParameters(this.l);
    } 
  }
  
  public void g() {
    Camera camera = this.f;
    if (camera != null) {
      this.l = camera.getParameters();
      this.l.setFlashMode("off");
      this.f.setParameters(this.l);
    } 
  }
  
  static {
    char c;
  }
  
  static final int a;
  
  private static final String b = CameraManager.class.getSimpleName();
  
  private static CameraManager c;
  
  private final Context d;
  
  private final CameraConfigurationManager e;
  
  private Camera f;
  
  private boolean g;
  
  private boolean h;
  
  private final boolean i;
  
  private final PreviewCallback j;
  
  private final AutoFocusCallback k;
  
  private Camera.Parameters l;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\camera\CameraManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */