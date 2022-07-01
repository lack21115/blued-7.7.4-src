package com.blued.android.framework.qrcode.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

final class CameraConfigurationManager {
  private static final String a = CameraConfigurationManager.class.getSimpleName();
  
  private static final Pattern b = Pattern.compile(",");
  
  private final Context c;
  
  private Point d;
  
  private Point e;
  
  private int f;
  
  private String g;
  
  CameraConfigurationManager(Context paramContext) {
    this.c = paramContext;
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt) {
    String[] arrayOfString = b.split(paramCharSequence);
    int k = arrayOfString.length;
    int i = 0;
    int j = 0;
    while (true) {
      if (i < k) {
        String str = arrayOfString[i].trim();
        try {
          double d = Double.parseDouble(str);
          int n = (int)(10.0D * d);
          int m = j;
          if (Math.abs(paramInt - d) < Math.abs(paramInt - j))
            m = n; 
          i++;
          j = m;
        } catch (NumberFormatException numberFormatException) {
          return paramInt;
        } 
        continue;
      } 
      return j;
    } 
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint) {
    Point point2;
    String str1 = paramParameters.get("preview-size-values");
    String str2 = str1;
    if (str1 == null)
      str2 = paramParameters.get("preview-size-value"); 
    str1 = null;
    if (str2 != null) {
      str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("preview-size-values parameter: ");
      stringBuilder.append(str2);
      Log.d(str1, stringBuilder.toString());
      point2 = b(paramParameters, paramPoint);
    } 
    Point point1 = point2;
    if (point2 == null)
      point1 = new Point(paramPoint.x >> 3 << 3, paramPoint.y >> 3 << 3); 
    return point1;
  }
  
  private void a(Camera.Parameters paramParameters) {
    if (Build.MODEL.contains("Behold II") && CameraManager.a == 3) {
      paramParameters.set("flash-value", 1);
    } else {
      paramParameters.set("flash-value", 2);
    } 
    paramParameters.set("flash-mode", "off");
  }
  
  private static Point b(Camera.Parameters paramParameters, Point paramPoint) {
    List<?> list = paramParameters.getSupportedPreviewSizes();
    if (list == null) {
      Log.w(a, "Device returned no supported preview sizes; using default");
      Camera.Size size = paramParameters.getPreviewSize();
      return new Point(size.width, size.height);
    } 
    list = new ArrayList(list);
    Collections.sort(list, new Comparator<Camera.Size>() {
          public int a(Camera.Size param1Size1, Camera.Size param1Size2) {
            int i = param1Size1.height * param1Size1.width;
            int j = param1Size2.height * param1Size2.width;
            return (j < i) ? -1 : ((j > i) ? 1 : 0);
          }
        });
    double d = paramPoint.x / paramPoint.y;
    Iterator<?> iterator = list.iterator();
    while (true) {
      Point point2;
      boolean bool = iterator.hasNext();
      int i = 0;
      if (bool) {
        int m;
        Camera.Size size1 = (Camera.Size)iterator.next();
        int j = size1.width;
        int k = size1.height;
        if (j * k < 153600) {
          iterator.remove();
          continue;
        } 
        if (j < k)
          i = 1; 
        if (i) {
          m = k;
        } else {
          m = j;
        } 
        if (i) {
          i = j;
        } else {
          i = k;
        } 
        if (Math.abs(m / i - d) > 0.15D) {
          iterator.remove();
          continue;
        } 
        if (m == paramPoint.x && i == paramPoint.y) {
          point2 = new Point(j, k);
          String str1 = a;
          stringBuilder = new StringBuilder();
          stringBuilder.append("Found preview size exactly matching screen size: ");
          stringBuilder.append(point2);
          Log.i(str1, stringBuilder.toString());
          return point2;
        } 
        continue;
      } 
      if (!stringBuilder.isEmpty()) {
        Camera.Size size1 = stringBuilder.get(0);
        point2 = new Point(size1.width, size1.height);
        String str1 = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Using largest suitable preview size: ");
        stringBuilder.append(point2);
        Log.i(str1, stringBuilder.toString());
        return point2;
      } 
      Camera.Size size = point2.getPreviewSize();
      Point point1 = new Point(size.width, size.height);
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No suitable preview sizes, using default: ");
      stringBuilder.append(point1);
      Log.i(str, stringBuilder.toString());
      return point1;
    } 
  }
  
  private void b(Camera.Parameters paramParameters) {
    String str1 = paramParameters.get("zoom-supported");
    if (str1 != null && !Boolean.parseBoolean(str1))
      return; 
    int j = 27;
    str1 = paramParameters.get("max-zoom");
    int i = j;
    if (str1 != null)
      try {
        double d = Double.parseDouble(str1);
        int k = (int)(d * 10.0D);
        i = j;
        if (27 > k)
          i = k; 
      } catch (NumberFormatException numberFormatException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad max-zoom: ");
        stringBuilder.append(str1);
        Log.w(str, stringBuilder.toString());
        i = j;
      }  
    String str2 = paramParameters.get("taking-picture-zoom-max");
    j = i;
    if (str2 != null)
      try {
        int k = Integer.parseInt(str2);
        j = i;
        if (i > k)
          j = k; 
      } catch (NumberFormatException numberFormatException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad taking-picture-zoom-max: ");
        stringBuilder.append(str2);
        Log.w(str, stringBuilder.toString());
        j = i;
      }  
    String str3 = paramParameters.get("mot-zoom-values");
    i = j;
    if (str3 != null)
      i = a(str3, j); 
    String str4 = paramParameters.get("mot-zoom-step");
    j = i;
    if (str4 != null)
      try {
        int k = (int)(Double.parseDouble(str4.trim()) * 10.0D);
        j = i;
        if (k > 1)
          j = i - i % k; 
      } catch (NumberFormatException numberFormatException) {
        j = i;
      }  
    if (str1 != null || str3 != null)
      paramParameters.set("zoom", String.valueOf(j / 10.0D)); 
    if (str2 != null)
      paramParameters.set("taking-picture-zoom", j); 
  }
  
  Point a() {
    return this.e;
  }
  
  void a(Camera paramCamera) {
    Camera.Parameters parameters = paramCamera.getParameters();
    this.f = parameters.getPreviewFormat();
    this.g = parameters.get("preview-format");
    String str3 = a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Default preview format: ");
    stringBuilder2.append(this.f);
    stringBuilder2.append('/');
    stringBuilder2.append(this.g);
    Log.d(str3, stringBuilder2.toString());
    Display display = ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay();
    this.d = new Point(display.getWidth(), display.getHeight());
    String str2 = a;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Screen resolution: ");
    stringBuilder2.append(this.d);
    Log.d(str2, stringBuilder2.toString());
    Point point = new Point();
    point.x = this.d.x;
    point.y = this.d.y;
    if (this.d.x < this.d.y) {
      point.x = this.d.y;
      point.y = this.d.x;
    } 
    this.e = a(parameters, point);
    String str1 = a;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Camera resolution: ");
    stringBuilder1.append(this.d);
    Log.d(str1, stringBuilder1.toString());
  }
  
  void b(Camera paramCamera) {
    Camera.Parameters parameters = paramCamera.getParameters();
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Setting preview size: ");
    stringBuilder.append(this.e);
    Log.d(str, stringBuilder.toString());
    parameters.setPreviewSize(this.e.x, this.e.y);
    a(parameters);
    b(parameters);
    paramCamera.setDisplayOrientation(90);
    paramCamera.setParameters(parameters);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\camera\CameraConfigurationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */