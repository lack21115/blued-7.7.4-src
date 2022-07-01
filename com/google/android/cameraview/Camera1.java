package com.google.android.cameraview;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;

class Camera1 extends CameraViewImpl {
  private static final SparseArrayCompat<String> b = new SparseArrayCompat();
  
  Camera a;
  
  private int c;
  
  private final AtomicBoolean d = new AtomicBoolean(false);
  
  private Camera.Parameters g;
  
  private final Camera.CameraInfo h = new Camera.CameraInfo();
  
  private final SizeMap i = new SizeMap();
  
  private final SizeMap j = new SizeMap();
  
  private AspectRatio k;
  
  private boolean l;
  
  private boolean m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  static {
    b.put(0, "off");
    b.put(1, "on");
    b.put(2, "torch");
    b.put(3, "auto");
    b.put(4, "red-eye");
  }
  
  Camera1(CameraViewImpl.Callback paramCallback, PreviewImpl paramPreviewImpl) {
    super(paramCallback, paramPreviewImpl);
    paramPreviewImpl.a(new PreviewImpl.Callback(this) {
          public void a() {
            if (this.a.a != null) {
              this.a.c();
              this.a.l();
            } 
          }
        });
  }
  
  private Size a(SortedSet<Size> paramSortedSet) {
    Size size;
    if (!this.f.d())
      return paramSortedSet.first(); 
    int k = this.f.h();
    int i = this.f.i();
    int m = k;
    int j = i;
    if (f(this.p)) {
      j = k;
      m = i;
    } 
    SortedSet sortedSet = null;
    Iterator<Size> iterator = paramSortedSet.iterator();
    paramSortedSet = sortedSet;
    while (iterator.hasNext()) {
      Size size1 = iterator.next();
      size = size1;
      if (m <= size1.a()) {
        size = size1;
        if (j <= size1.b()) {
          size = size1;
          break;
        } 
      } 
    } 
    return size;
  }
  
  private boolean b(boolean paramBoolean) {
    this.m = paramBoolean;
    if (d()) {
      List<String> list = this.g.getSupportedFocusModes();
      if (paramBoolean && list.contains("continuous-picture")) {
        this.g.setFocusMode("continuous-picture");
      } else if (list.contains("fixed")) {
        this.g.setFocusMode("fixed");
      } else if (list.contains("infinity")) {
        this.g.setFocusMode("infinity");
      } else {
        this.g.setFocusMode(list.get(0));
      } 
      return true;
    } 
    return false;
  }
  
  private int d(int paramInt) {
    return (this.h.facing == 1) ? ((360 - (this.h.orientation + paramInt) % 360) % 360) : ((this.h.orientation - paramInt + 360) % 360);
  }
  
  private int e(int paramInt) {
    byte b;
    if (this.h.facing == 1)
      return (this.h.orientation + paramInt) % 360; 
    if (f(paramInt)) {
      b = 180;
    } else {
      b = 0;
    } 
    return (this.h.orientation + paramInt + b) % 360;
  }
  
  private boolean f(int paramInt) {
    return (paramInt == 90 || paramInt == 270);
  }
  
  private boolean g(int paramInt) {
    if (d()) {
      List list = this.g.getSupportedFlashModes();
      String str = (String)b.get(paramInt);
      if (list != null && list.contains(str)) {
        this.g.setFlashMode(str);
        this.o = paramInt;
        return true;
      } 
      str = (String)b.get(this.o);
      if (list == null || !list.contains(str)) {
        this.g.setFlashMode("off");
        this.o = 0;
        return true;
      } 
      return false;
    } 
    this.o = paramInt;
    return false;
  }
  
  private void m() {
    int j = Camera.getNumberOfCameras();
    for (int i = 0; i < j; i++) {
      Camera.getCameraInfo(i, this.h);
      if (this.h.facing == this.n) {
        this.c = i;
        return;
      } 
    } 
    this.c = -1;
  }
  
  private void n() {
    try {
      if (this.a != null)
        q(); 
      this.a = Camera.open(this.c);
      this.g = this.a.getParameters();
      this.i.b();
      for (Camera.Size size : this.g.getSupportedPreviewSizes())
        this.i.a(new Size(size.width, size.height)); 
      this.j.b();
      for (Camera.Size size : this.g.getSupportedPictureSizes())
        this.j.a(new Size(size.width, size.height)); 
      if (this.k == null)
        this.k = Constants.a; 
      l();
      this.a.setDisplayOrientation(d(this.p));
      this.e.a();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private AspectRatio p() {
    Iterator<AspectRatio> iterator = this.i.a().iterator();
    AspectRatio aspectRatio = null;
    while (iterator.hasNext()) {
      AspectRatio aspectRatio1 = iterator.next();
      aspectRatio = aspectRatio1;
      if (aspectRatio1.equals(Constants.a)) {
        aspectRatio = aspectRatio1;
        break;
      } 
    } 
    return aspectRatio;
  }
  
  private void q() {
    Camera camera = this.a;
    if (camera != null) {
      camera.release();
      this.a = null;
      this.e.b();
    } 
  }
  
  void a(int paramInt) {
    if (this.n == paramInt)
      return; 
    this.n = paramInt;
    if (d()) {
      b();
      a();
    } 
  }
  
  void a(boolean paramBoolean) {
    if (this.m == paramBoolean)
      return; 
    if (b(paramBoolean))
      this.a.setParameters(this.g); 
  }
  
  boolean a() {
    m();
    n();
    if (this.a != null) {
      if (this.f.d())
        c(); 
      this.l = true;
      this.a.startPreview();
    } 
    return true;
  }
  
  boolean a(AspectRatio paramAspectRatio) {
    if (this.k == null || !d()) {
      this.k = paramAspectRatio;
      return true;
    } 
    if (!this.k.equals(paramAspectRatio)) {
      if (this.i.b(paramAspectRatio) != null) {
        this.k = paramAspectRatio;
        l();
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramAspectRatio);
      stringBuilder.append(" is not supported");
      throw new UnsupportedOperationException(stringBuilder.toString());
    } 
    return false;
  }
  
  void b() {
    Camera camera = this.a;
    if (camera != null)
      camera.stopPreview(); 
    this.l = false;
    q();
  }
  
  void b(int paramInt) {
    if (paramInt == this.o)
      return; 
    if (g(paramInt))
      this.a.setParameters(this.g); 
  }
  
  void c() {
    try {
      if (this.f.c() == SurfaceHolder.class) {
        boolean bool;
        if (this.l && Build.VERSION.SDK_INT < 14) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool)
          this.a.stopPreview(); 
        this.a.setPreviewDisplay(this.f.f());
        if (bool) {
          this.a.startPreview();
          return;
        } 
      } else {
        this.a.setPreviewTexture((SurfaceTexture)this.f.g());
      } 
      return;
    } catch (IOException iOException) {
      throw new RuntimeException(iOException);
    } 
  }
  
  void c(int paramInt) {
    if (this.p == paramInt)
      return; 
    this.p = paramInt;
    if (d()) {
      boolean bool;
      this.g.setRotation(e(paramInt));
      this.a.setParameters(this.g);
      if (this.l && Build.VERSION.SDK_INT < 14) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool)
        this.a.stopPreview(); 
      this.a.setDisplayOrientation(d(paramInt));
      if (bool)
        this.a.startPreview(); 
    } 
  }
  
  boolean d() {
    return (this.a != null);
  }
  
  int e() {
    return this.n;
  }
  
  Set<AspectRatio> f() {
    SizeMap sizeMap = this.i;
    for (AspectRatio aspectRatio : sizeMap.a()) {
      if (this.j.b(aspectRatio) == null)
        sizeMap.a(aspectRatio); 
    } 
    return sizeMap.a();
  }
  
  AspectRatio g() {
    return this.k;
  }
  
  boolean h() {
    if (!d())
      return this.m; 
    String str = this.g.getFocusMode();
    return (str != null && str.contains("continuous"));
  }
  
  int i() {
    return this.o;
  }
  
  void j() {
    if (d()) {
      if (h()) {
        this.a.cancelAutoFocus();
        this.a.autoFocus(new Camera.AutoFocusCallback(this) {
              public void onAutoFocus(boolean param1Boolean, Camera param1Camera) {
                this.a.k();
              }
            });
        return;
      } 
      k();
      return;
    } 
    throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
  }
  
  void k() {
    if (!this.d.getAndSet(true))
      this.a.takePicture(null, null, null, new Camera.PictureCallback(this) {
            public void onPictureTaken(byte[] param1ArrayOfbyte, Camera param1Camera) {
              Camera1.a(this.a).set(false);
              this.a.e.a(param1ArrayOfbyte);
              param1Camera.cancelAutoFocus();
              param1Camera.startPreview();
            }
          }); 
  }
  
  void l() {
    SortedSet<Size> sortedSet2 = this.i.b(this.k);
    SortedSet<Size> sortedSet1 = sortedSet2;
    if (sortedSet2 == null) {
      this.k = p();
      sortedSet1 = this.i.b(this.k);
    } 
    Size size1 = a(sortedSet1);
    Size size2 = this.j.b(this.k).last();
    if (this.l)
      this.a.stopPreview(); 
    this.g.setPreviewSize(size1.a(), size1.b());
    this.g.setPictureSize(size2.a(), size2.b());
    this.g.setRotation(e(this.p));
    b(this.m);
    g(this.o);
    this.a.setParameters(this.g);
    if (this.l)
      this.a.startPreview(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\Camera1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */