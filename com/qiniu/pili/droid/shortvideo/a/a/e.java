package com.qiniu.pili.droid.shortvideo.a.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import java.util.ArrayList;
import java.util.List;

public class e {
  private int a = 0;
  
  private int b;
  
  private int c;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private long f = 0L;
  
  private String g;
  
  private Matrix h = new Matrix();
  
  private List<Camera.Area> i;
  
  private List<Camera.Area> j;
  
  private PLFocusListener k;
  
  private final Camera.AutoFocusCallback l = new Camera.AutoFocusCallback(this) {
      public void onAutoFocus(boolean param1Boolean, Camera param1Camera) {
        byte b;
        com.qiniu.pili.droid.shortvideo.f.e e2 = com.qiniu.pili.droid.shortvideo.f.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("manual focus cost time: ");
        stringBuilder.append(System.currentTimeMillis() - e.a(this.a));
        stringBuilder.append("Ms, result: ");
        stringBuilder.append(param1Boolean);
        e2.c("FocusManager", stringBuilder.toString());
        e e1 = this.a;
        if (param1Boolean) {
          b = 2;
        } else {
          b = 3;
        } 
        e.a(e1, b);
        if (e.b(this.a) != null)
          e.b(this.a).onManualFocusStop(param1Boolean); 
        e.c(this.a);
      }
    };
  
  private final Camera.AutoFocusMoveCallback m = new Camera.AutoFocusMoveCallback(this) {
      public void onAutoFocusMoving(boolean param1Boolean, Camera param1Camera) {
        com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("auto focus move: ");
        stringBuilder.append(param1Boolean);
        e1.c("FocusManager", stringBuilder.toString());
        if (e.b(this.a) != null) {
          if (param1Boolean) {
            e.b(this.a).onAutoFocusStart();
            return;
          } 
          e.b(this.a).onAutoFocusStop();
        } 
      }
    };
  
  public e(Context paramContext, String paramString, int paramInt1, int paramInt2) {
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("default focus mode: ");
    stringBuilder.append(paramString);
    stringBuilder.append(" preview width: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" preview height: ");
    stringBuilder.append(paramInt2);
    e1.c("FocusManager", stringBuilder.toString());
    this.g = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    b();
    c();
    a(paramContext);
  }
  
  private String a(Camera.Parameters paramParameters) {
    String str1;
    String str2;
    List<String> list = paramParameters.getSupportedFocusModes();
    boolean bool = this.d;
    String str3 = "auto";
    if (bool && this.i != null) {
      str2 = "auto";
    } else {
      str2 = this.g;
    } 
    if (!c.a(str2, list)) {
      if (c.a("auto", paramParameters.getSupportedFocusModes())) {
        str1 = str3;
      } else {
        str1 = str1.getFocusMode();
      } 
    } else {
      str1 = str2;
    } 
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("selected focus mode:");
    stringBuilder.append(str1);
    e1.c("FocusManager", stringBuilder.toString());
    return str1;
  }
  
  private void a() {
    Camera.Parameters parameters = a.a().k();
    if (parameters == null) {
      com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "param is null while getParameters");
      return;
    } 
    if (this.d)
      parameters.setFocusAreas(this.i); 
    if (this.e)
      parameters.setMeteringAreas(this.j); 
    parameters.setFocusMode(a(parameters));
    a.a().a(parameters);
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Rect paramRect) {
    paramInt1 = (int)(paramInt1 * paramFloat);
    paramInt2 = (int)(paramInt2 * paramFloat);
    paramInt3 = c.a(paramInt3 - paramInt1 / 2, 0, paramInt5 - paramInt1);
    paramInt4 = c.a(paramInt4 - paramInt2 / 2, 0, paramInt6 - paramInt2);
    RectF rectF = new RectF(paramInt3, paramInt4, (paramInt3 + paramInt1), (paramInt4 + paramInt2));
    this.h.mapRect(rectF);
    c.a(rectF, paramRect);
  }
  
  private void a(Context paramContext) {
    Matrix matrix = new Matrix();
    c.a(matrix, a.a().j(), b(paramContext), this.b, this.c);
    matrix.invert(this.h);
  }
  
  private int b(Context paramContext) {
    int i = c.b(paramContext);
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("handle setting camera orientation, mCameraInfo.facing:");
    stringBuilder.append((a.a().c()).facing);
    stringBuilder.append(",degrees:");
    stringBuilder.append(i);
    stringBuilder.append(",orientation:");
    stringBuilder.append((a.a().c()).orientation);
    e1.c("FocusManager", stringBuilder.toString());
    return a.a().j() ? ((360 - ((a.a().c()).orientation + i) % 360) % 360) : (((a.a().c()).orientation - i + 360) % 360);
  }
  
  private void b() {
    boolean bool1;
    Camera.Parameters parameters = a.a().k();
    if (parameters == null) {
      com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "param is null while getParameters");
      return;
    } 
    int i = parameters.getMaxNumFocusAreas();
    boolean bool2 = true;
    if (i > 0 && c.a("auto", parameters.getSupportedFocusModes())) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.d = bool1;
    if (parameters.getMaxNumMeteringAreas() > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    this.e = bool1;
  }
  
  private void c() {
    Camera.Parameters parameters = a.a().k();
    if (parameters == null) {
      com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "param is null while getParameters");
      return;
    } 
    String str = parameters.getFocusMode();
    if ("continuous-video".equals(str) || "continuous-picture".equals(str))
      a.a().a(this.m); 
  }
  
  private void d() {
    com.qiniu.pili.droid.shortvideo.f.e.f.c("FocusManager", "start manual focus.");
    this.a = 1;
    this.f = System.currentTimeMillis();
    a.a().a(this.l);
    PLFocusListener pLFocusListener = this.k;
    if (pLFocusListener != null)
      pLFocusListener.onManualFocusStart(true); 
  }
  
  private void e() {
    com.qiniu.pili.droid.shortvideo.f.e.f.c("FocusManager", "cancel manual focus.");
    this.a = 0;
    a.a().e();
    f();
    PLFocusListener pLFocusListener = this.k;
    if (pLFocusListener != null)
      pLFocusListener.onManualFocusCancel(); 
  }
  
  private void f() {
    this.i = null;
    this.j = null;
    a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.d) {
      com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "focus not supported on current camera.");
      PLFocusListener pLFocusListener = this.k;
      if (pLFocusListener != null)
        pLFocusListener.onManualFocusStart(false); 
      return;
    } 
    com.qiniu.pili.droid.shortvideo.f.e e1 = com.qiniu.pili.droid.shortvideo.f.e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("focus on x: ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" y: ");
    stringBuilder.append(paramInt4);
    stringBuilder.append(" width: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" height: ");
    stringBuilder.append(paramInt2);
    e1.c("FocusManager", stringBuilder.toString());
    if (this.i != null) {
      int i = this.a;
      if (i == 1 || i == 2 || i == 3)
        e(); 
    } 
    Rect rect1 = new Rect();
    Rect rect2 = new Rect();
    a(paramInt1, paramInt2, 1.0F, paramInt3, paramInt4, this.b, this.c, rect1);
    a(paramInt1, paramInt2, 1.5F, paramInt3, paramInt4, this.b, this.c, rect2);
    if (this.i == null) {
      this.i = new ArrayList<Camera.Area>();
      this.i.add(new Camera.Area(rect1, 1));
      this.j = new ArrayList<Camera.Area>();
      this.j.add(new Camera.Area(rect2, 1));
    } 
    a();
    d();
  }
  
  public void a(PLFocusListener paramPLFocusListener) {
    this.k = paramPLFocusListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */