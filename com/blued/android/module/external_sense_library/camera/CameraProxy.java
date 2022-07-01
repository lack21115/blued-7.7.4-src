package com.blued.android.module.external_sense_library.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CameraProxy {
  private boolean a = true;
  
  private Context b;
  
  private int c;
  
  private Camera d;
  
  private boolean e = false;
  
  private boolean f = false;
  
  private int g;
  
  private int h;
  
  private Camera.CameraInfo i = new Camera.CameraInfo();
  
  public CameraProxy(Context paramContext) {
    this.b = paramContext;
  }
  
  private void j() {
    Camera.Parameters parameters = this.d.getParameters();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("parameters: ");
    stringBuilder.append(parameters.flatten());
    Log.e("CameraProxy", stringBuilder.toString());
    if (parameters.getSupportedFocusModes().contains("continuous-picture"))
      parameters.setFocusMode("continuous-picture"); 
    List list = parameters.getSupportedFlashModes();
    if (list != null && list.contains("off"))
      parameters.setFlashMode("off"); 
    k();
    parameters.setPreviewSize(640, 480);
    Point point = l();
    parameters.setPictureSize(point.x, point.y);
    this.d.setParameters(parameters);
    this.g = parameters.getMaxExposureCompensation();
    this.h = parameters.getMinExposureCompensation();
  }
  
  private Point k() {
    Point point = new Point(1920, 1080);
    Camera camera = this.d;
    if (camera != null) {
      for (Camera.Size size : camera.getParameters().getSupportedPreviewSizes()) {
        if (size.width == point.x && size.height == point.y)
          return point; 
      } 
      return new Point(640, 480);
    } 
    return null;
  }
  
  private Point l() {
    Point point = new Point(4608, 3456);
    if (this.d != null) {
      Point point1 = new Point(0, 0);
      for (Camera.Size size : this.d.getParameters().getSupportedPictureSizes()) {
        if (size.width == point.x && size.height == point.y)
          return point; 
        if (point1.x < size.width) {
          point1.x = size.width;
          point1.y = size.height;
        } 
      } 
      return point1;
    } 
    return null;
  }
  
  public Camera a() {
    return this.d;
  }
  
  public ArrayList<String> a(String[] paramArrayOfString) {
    ArrayList<String> arrayList = new ArrayList();
    Camera camera = this.d;
    if (camera != null) {
      List list = camera.getParameters().getSupportedPreviewSizes();
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++) {
        String str = paramArrayOfString[i];
        int k = str.indexOf('x');
        if (k != -1) {
          int m = Integer.parseInt(str.substring(0, k));
          k = Integer.parseInt(str.substring(k + 1));
          for (Camera.Size size : list) {
            if (size.width == m && size.height == k)
              arrayList.add(str); 
          } 
        } 
      } 
    } 
    return arrayList;
  }
  
  public void a(int paramInt1, int paramInt2) {
    Camera camera1 = this.d;
    if (camera1 == null)
      return; 
    Camera.Parameters parameters = camera1.getParameters();
    parameters.setPreviewSize(paramInt1, paramInt2);
    Camera camera2 = this.d;
    if (camera2 == null)
      return; 
    camera2.setParameters(parameters);
  }
  
  public void a(Rect paramRect) {
    ArrayList<Camera.Area> arrayList = new ArrayList();
    arrayList.add(new Camera.Area(paramRect, 1));
    Camera camera = this.d;
    if (camera != null)
      try {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setMeteringAreas(arrayList);
        this.d.setParameters(parameters);
        return;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onFaceDetection exception: ");
        stringBuilder.append(exception.getMessage());
        Log.e("CameraProxy", stringBuilder.toString());
      }  
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, Camera.PreviewCallback paramPreviewCallback) {
    try {
      if (this.d == null)
        return; 
      if (paramSurfaceTexture != null)
        Camera camera = this.d; 
      this.d.setPreviewTexture(paramSurfaceTexture);
      if (paramPreviewCallback != null && this.d != null)
        this.d.setPreviewCallback(paramPreviewCallback); 
      this.d.startPreview();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public void a(boolean paramBoolean) {
    Camera.Parameters parameters = this.d.getParameters();
    if (parameters.isZoomSupported()) {
      int i = parameters.getMaxZoom();
      int j = parameters.getZoom();
      if (paramBoolean && j < i) {
        i = j + 1;
      } else {
        i = j;
        if (j > 0)
          i = j - 1; 
      } 
      parameters.setZoom(i);
      this.d.setParameters(parameters);
      return;
    } 
    Log.i("CameraProxy", "zoom not supported");
  }
  
  public boolean a(int paramInt) {
    try {
      b();
      this.d = Camera.open(paramInt);
      this.d.getParameters();
      this.c = paramInt;
      Camera camera = this.d;
      Camera.getCameraInfo(paramInt, this.i);
      j();
      this.e = true;
      this.f = false;
      return true;
    } catch (Exception exception) {
      this.f = true;
      this.d = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("openCamera fail msg=");
      stringBuilder.append(exception.getMessage());
      Log.i("CameraProxy", stringBuilder.toString());
      return false;
    } 
  }
  
  public void b() {
    Camera camera = this.d;
    if (camera != null) {
      camera.setPreviewCallback(null);
      this.d.stopPreview();
      this.d.release();
      this.d = null;
    } 
  }
  
  public void b(int paramInt) {
    Camera.Parameters parameters = this.d.getParameters();
    if (paramInt >= 50) {
      paramInt = (paramInt - 50) * this.g / 50;
    } else {
      paramInt = this.h * (50 - paramInt) / 50;
    } 
    parameters.setExposureCompensation(paramInt);
    this.d.setParameters(parameters);
  }
  
  public void c() {
    Camera camera = this.d;
    if (camera != null)
      camera.stopPreview(); 
  }
  
  public int d() {
    Camera.CameraInfo cameraInfo = this.i;
    return (cameraInfo == null) ? 0 : cameraInfo.orientation;
  }
  
  public boolean e() {
    Camera.CameraInfo cameraInfo = this.i;
    boolean bool = false;
    if (cameraInfo == null)
      return false; 
    if (cameraInfo.facing == 1)
      bool = true; 
    return bool;
  }
  
  public boolean f() {
    Camera.CameraInfo cameraInfo = this.i;
    boolean bool = false;
    if (cameraInfo == null)
      return false; 
    if (cameraInfo.orientation == 90 || this.i.orientation == 270)
      bool = true; 
    return bool;
  }
  
  public int g() {
    return Camera.getNumberOfCameras();
  }
  
  public boolean h() {
    return this.f;
  }
  
  public boolean i() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\camera\CameraProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */