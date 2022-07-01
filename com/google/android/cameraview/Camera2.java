package com.google.android.cameraview;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;

class Camera2 extends CameraViewImpl {
  private static final SparseIntArray g = new SparseIntArray();
  
  PictureCaptureCallback a;
  
  CameraDevice b;
  
  CameraCaptureSession c;
  
  CaptureRequest.Builder d;
  
  private final CameraManager h;
  
  private final CameraDevice.StateCallback i;
  
  private final CameraCaptureSession.StateCallback j;
  
  private final ImageReader.OnImageAvailableListener k;
  
  private String l;
  
  private CameraCharacteristics m;
  
  private ImageReader n;
  
  private final SizeMap o;
  
  private final SizeMap p;
  
  private int q;
  
  private AspectRatio r;
  
  private boolean s;
  
  private int t;
  
  private int u;
  
  static {
    g.put(0, 1);
    g.put(1, 0);
  }
  
  private boolean p() {
    try {
      int j = g.get(this.q);
      String[] arrayOfString = this.h.getCameraIdList();
      if (arrayOfString.length == 0) {
        this.b = null;
        return false;
      } 
      int k = arrayOfString.length;
      for (int i = 0;; i++) {
        if (i < k) {
          String str = arrayOfString[i];
          CameraCharacteristics cameraCharacteristics = this.h.getCameraCharacteristics(str);
          Integer integer = (Integer)cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
          if (integer != null && integer.intValue() != 2) {
            integer = (Integer)cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (integer != null) {
              if (integer.intValue() == j) {
                this.l = str;
                this.m = cameraCharacteristics;
                return true;
              } 
            } else {
              throw new NullPointerException("Unexpected state: LENS_FACING null");
            } 
          } 
        } else {
          this.l = arrayOfString[0];
          this.m = this.h.getCameraCharacteristics(this.l);
          Integer integer = (Integer)this.m.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
          if (integer != null) {
            if (integer.intValue() == 2)
              return false; 
            integer = (Integer)this.m.get(CameraCharacteristics.LENS_FACING);
            if (integer != null) {
              j = g.size();
              for (i = 0;; i++) {
                if (i < j) {
                  if (g.valueAt(i) == integer.intValue()) {
                    this.q = g.keyAt(i);
                    return true;
                  } 
                } else {
                  this.q = 0;
                  return true;
                } 
              } 
              break;
            } 
            throw new NullPointerException("Unexpected state: LENS_FACING null");
          } 
          return false;
        } 
      } 
    } catch (CameraAccessException cameraAccessException) {
      throw new RuntimeException("Failed to get a list of camera devices", cameraAccessException);
    } 
  }
  
  private void q() {
    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)this.m.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (streamConfigurationMap != null) {
      this.o.b();
      for (Size size : streamConfigurationMap.getOutputSizes(this.f.c())) {
        int i = size.getWidth();
        int j = size.getHeight();
        if (i <= 1920 && j <= 1080)
          this.o.a(new Size(i, j)); 
      } 
      this.p.b();
      a(this.p, streamConfigurationMap);
      for (AspectRatio aspectRatio : this.o.a()) {
        if (!this.p.a().contains(aspectRatio))
          this.o.a(aspectRatio); 
      } 
      if (!this.o.a().contains(this.r))
        this.r = this.o.a().iterator().next(); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to get configuration map: ");
    stringBuilder.append(this.l);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void r() {
    ImageReader imageReader = this.n;
    if (imageReader != null)
      imageReader.close(); 
    Size size = this.p.b(this.r).last();
    this.n = ImageReader.newInstance(size.a(), size.b(), 256, 2);
    this.n.setOnImageAvailableListener(this.k, null);
  }
  
  private void s() {
    try {
      this.h.openCamera(this.l, this.i, null);
      return;
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to open camera: ");
      stringBuilder.append(this.l);
      throw new RuntimeException(stringBuilder.toString(), cameraAccessException);
    } 
  }
  
  private Size t() {
    int k = this.f.h();
    int i = this.f.i();
    int m = k;
    int j = i;
    if (k < i) {
      j = k;
      m = i;
    } 
    SortedSet<Size> sortedSet = this.o.b(this.r);
    for (Size size : sortedSet) {
      if (size.a() >= m && size.b() >= j)
        return size; 
    } 
    return sortedSet.last();
  }
  
  private void u() {
    CaptureRequest.Builder builder = this.d;
    if (builder != null) {
      builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      try {
        this.a.a(1);
        if (this.c != null) {
          this.c.capture(this.d.build(), this.a, null);
          return;
        } 
      } catch (CameraAccessException cameraAccessException) {
        Log.e("Camera2", "Failed to lock focus.", (Throwable)cameraAccessException);
      } 
    } 
  }
  
  void a(int paramInt) {
    if (this.q == paramInt)
      return; 
    this.q = paramInt;
    if (d()) {
      b();
      a();
    } 
  }
  
  protected void a(SizeMap paramSizeMap, StreamConfigurationMap paramStreamConfigurationMap) {
    for (Size size : paramStreamConfigurationMap.getOutputSizes(256))
      this.p.a(new Size(size.getWidth(), size.getHeight())); 
  }
  
  void a(boolean paramBoolean) {
    if (this.s == paramBoolean)
      return; 
    this.s = paramBoolean;
    if (this.d != null) {
      k();
      CameraCaptureSession cameraCaptureSession = this.c;
      if (cameraCaptureSession != null)
        try {
          cameraCaptureSession.setRepeatingRequest(this.d.build(), this.a, null);
          return;
        } catch (CameraAccessException cameraAccessException) {
          this.s ^= 0x1;
        }  
    } 
  }
  
  boolean a() {
    if (!p())
      return false; 
    q();
    r();
    s();
    return true;
  }
  
  boolean a(AspectRatio paramAspectRatio) {
    if (paramAspectRatio == null || paramAspectRatio.equals(this.r) || !this.o.a().contains(paramAspectRatio))
      return false; 
    this.r = paramAspectRatio;
    r();
    CameraCaptureSession cameraCaptureSession = this.c;
    if (cameraCaptureSession != null) {
      cameraCaptureSession.close();
      this.c = null;
      c();
    } 
    return true;
  }
  
  void b() {
    CameraCaptureSession cameraCaptureSession = this.c;
    if (cameraCaptureSession != null) {
      cameraCaptureSession.close();
      this.c = null;
    } 
    CameraDevice cameraDevice = this.b;
    if (cameraDevice != null) {
      cameraDevice.close();
      this.b = null;
    } 
    ImageReader imageReader = this.n;
    if (imageReader != null) {
      imageReader.close();
      this.n = null;
    } 
  }
  
  void b(int paramInt) {
    int i = this.t;
    if (i == paramInt)
      return; 
    this.t = paramInt;
    if (this.d != null) {
      l();
      CameraCaptureSession cameraCaptureSession = this.c;
      if (cameraCaptureSession != null)
        try {
          cameraCaptureSession.setRepeatingRequest(this.d.build(), this.a, null);
          return;
        } catch (CameraAccessException cameraAccessException) {
          this.t = i;
        }  
    } 
  }
  
  void c() {
    if (d() && this.f.d()) {
      if (this.n == null)
        return; 
      Size size = t();
      this.f.a(size.a(), size.b());
      Surface surface = this.f.a();
      try {
        this.d = this.b.createCaptureRequest(1);
        this.d.addTarget(surface);
        this.b.createCaptureSession(Arrays.asList(new Surface[] { surface, this.n.getSurface() }, ), this.j, null);
        return;
      } catch (CameraAccessException cameraAccessException) {
        throw new RuntimeException("Failed to start camera session");
      } 
    } 
  }
  
  void c(int paramInt) {
    this.u = paramInt;
    this.f.a(this.u);
  }
  
  boolean d() {
    if (this.b != null)
      try {
        int i = (this.h.getCameraIdList()).length;
        if (i > 0)
          return true; 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  int e() {
    return this.q;
  }
  
  Set<AspectRatio> f() {
    return this.o.a();
  }
  
  AspectRatio g() {
    return this.r;
  }
  
  boolean h() {
    return this.s;
  }
  
  int i() {
    return this.t;
  }
  
  void j() {
    if (this.s) {
      u();
      return;
    } 
    m();
  }
  
  void k() {
    boolean bool = this.s;
    Integer integer = Integer.valueOf(0);
    if (bool) {
      int[] arrayOfInt = (int[])this.m.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
      if (arrayOfInt == null || arrayOfInt.length == 0 || (arrayOfInt.length == 1 && arrayOfInt[0] == 0)) {
        this.s = false;
        this.d.set(CaptureRequest.CONTROL_AF_MODE, integer);
        return;
      } 
      this.d.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      return;
    } 
    this.d.set(CaptureRequest.CONTROL_AF_MODE, integer);
  }
  
  void l() {
    int i = this.t;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4)
              return; 
            this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(4));
            this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
            return;
          } 
          this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
          this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
          return;
        } 
        this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
        return;
      } 
      this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
      this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      return;
    } 
    this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
    this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
  }
  
  void m() {
    try {
      if (d()) {
        CaptureRequest.Builder builder = this.b.createCaptureRequest(2);
        builder.addTarget(this.n.getSurface());
        builder.set(CaptureRequest.CONTROL_AF_MODE, this.d.get(CaptureRequest.CONTROL_AF_MODE));
        int i = this.t;
        byte b = 1;
        if (i != 0) {
          if (i != 1) {
            if (i != 2) {
              if (i != 3) {
                if (i == 4)
                  builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2)); 
              } else {
                builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
              } 
            } else {
              builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
              builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
            } 
          } else {
            builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
          } 
        } else {
          builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
          builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
        } 
        i = ((Integer)this.m.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        CaptureRequest.Key key = CaptureRequest.JPEG_ORIENTATION;
        int j = this.u;
        if (this.q != 1)
          b = -1; 
        builder.set(key, Integer.valueOf((i + j * b + 360) % 360));
        this.c.stopRepeating();
        this.c.capture(builder.build(), new CameraCaptureSession.CaptureCallback(this) {
              public void onCaptureCompleted(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, TotalCaptureResult param1TotalCaptureResult) {
                this.a.n();
              }
            },  null);
        return;
      } 
    } catch (CameraAccessException cameraAccessException) {
      Log.e("Camera2", "Cannot capture a still picture.", (Throwable)cameraAccessException);
    } 
  }
  
  void n() {
    this.d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    try {
      this.c.capture(this.d.build(), this.a, null);
      k();
      l();
      this.d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
      this.c.setRepeatingRequest(this.d.build(), this.a, null);
      this.a.a(0);
      return;
    } catch (CameraAccessException cameraAccessException) {
      Log.e("Camera2", "Failed to restart camera preview.", (Throwable)cameraAccessException);
      return;
    } 
  }
  
  static abstract class PictureCaptureCallback extends CameraCaptureSession.CaptureCallback {
    private int a;
    
    private void a(CaptureResult param1CaptureResult) {
      Integer integer;
      int i = this.a;
      if (i != 1) {
        if (i != 3) {
          if (i != 4)
            return; 
          integer = (Integer)param1CaptureResult.get(CaptureResult.CONTROL_AE_STATE);
          if (integer == null || integer.intValue() != 5) {
            a(5);
            b();
            return;
          } 
        } else {
          integer = (Integer)integer.get(CaptureResult.CONTROL_AE_STATE);
          if (integer == null || integer.intValue() == 5 || integer.intValue() == 4 || integer.intValue() == 2) {
            a(4);
            return;
          } 
        } 
      } else {
        Integer integer1 = (Integer)integer.get(CaptureResult.CONTROL_AF_STATE);
        if (integer1 == null)
          return; 
        if (integer1.intValue() == 4 || integer1.intValue() == 5) {
          integer = (Integer)integer.get(CaptureResult.CONTROL_AE_STATE);
          if (integer == null || integer.intValue() == 2) {
            a(5);
            b();
            return;
          } 
          a(2);
          a();
          return;
        } 
      } 
    }
    
    public abstract void a();
    
    void a(int param1Int) {
      this.a = param1Int;
    }
    
    public abstract void b();
    
    public void onCaptureCompleted(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, TotalCaptureResult param1TotalCaptureResult) {
      a((CaptureResult)param1TotalCaptureResult);
    }
    
    public void onCaptureProgressed(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, CaptureResult param1CaptureResult) {
      a(param1CaptureResult);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\Camera2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */