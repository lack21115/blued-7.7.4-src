package a.a.a.a.a.b;

import a.a.a.a.a.e.e;
import android.hardware.Camera;
import android.os.Build;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class f {
  public static final List<a.a.a.a.a.e.f> a;
  
  static {
    ArrayList<a.a.a.a.a.e.f> arrayList = new ArrayList();
    a = arrayList;
    arrayList.add(new a.a.a.a.a.e.f(1184, 666));
    a.add(new a.a.a.a.a.e.f(854, 480));
  }
  
  public static double a(CameraStreamingSetting.PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO) {
    int i = b.b[paramPREVIEW_SIZE_RATIO.ordinal()];
    if (i != 1) {
      if (i == 2)
        return 1.7777777777777777D; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cannot support ratio:");
      stringBuilder.append(paramPREVIEW_SIZE_RATIO);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return 1.3333333333333333D;
  }
  
  public static int a(Camera.Parameters paramParameters, int paramInt) {
    e e2 = e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("desired preview fps: ");
    stringBuilder.append(paramInt);
    e2.c("CameraUtils", stringBuilder.toString());
    try {
      List list = paramParameters.getSupportedPreviewFpsRange();
      ArrayList<int[]> arrayList = new ArrayList();
      Iterator<int[]> iterator = list.iterator();
      int i = Integer.MAX_VALUE;
      while (iterator.hasNext()) {
        int[] arrayOfInt1 = iterator.next();
        e e = e.g;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("checking entry: ");
        stringBuilder1.append(arrayOfInt1[0]);
        stringBuilder1.append(" - ");
        stringBuilder1.append(arrayOfInt1[1]);
        e.c("CameraUtils", stringBuilder1.toString());
        if (arrayOfInt1[0] != arrayOfInt1[1]) {
          if (arrayOfInt1[0] <= paramInt && paramInt <= arrayOfInt1[1]) {
            arrayList.add(arrayOfInt1);
            e = e.g;
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("added range entry: ");
            stringBuilder1.append(arrayOfInt1[0]);
            stringBuilder1.append(" - ");
            stringBuilder1.append(arrayOfInt1[1]);
            e.c("CameraUtils", stringBuilder1.toString());
            continue;
          } 
          e.g.c("CameraUtils", "range not cover desired fps, pass.");
          continue;
        } 
        if (arrayOfInt1[0] >= paramInt && arrayOfInt1[0] - paramInt < i - paramInt) {
          i = arrayOfInt1[0];
          e e3 = e.g;
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("rewrited fixed value:");
          stringBuilder2.append(i);
          e3.c("CameraUtils", stringBuilder2.toString());
        } 
      } 
      if (!arrayList.isEmpty()) {
        int[] arrayOfInt1 = arrayList.get(0);
        paramInt = 0;
        while (true) {
          e e4;
          if (paramInt < arrayList.size()) {
            int[] arrayOfInt3 = arrayList.get(paramInt);
            int[] arrayOfInt2 = arrayOfInt1;
            if (arrayOfInt3[1] - arrayOfInt3[0] < arrayOfInt1[1] - arrayOfInt1[0])
              arrayOfInt2 = arrayOfInt3; 
          } else {
            paramParameters.setPreviewFpsRange(arrayOfInt1[0], arrayOfInt1[1]);
            e4 = e.g;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("chose range fps: ");
            stringBuilder1.append(arrayOfInt1[0]);
            stringBuilder1.append(" - ");
            stringBuilder1.append(arrayOfInt1[1]);
            e4.c("CameraUtils", stringBuilder1.toString());
            return arrayOfInt1[1];
          } 
          paramInt++;
          e e3 = e4;
        } 
      } 
      e.g.c("CameraUtils", "cannot find appropriate range fps, try fixed.");
      if (i != Integer.MAX_VALUE) {
        paramParameters.setPreviewFpsRange(i, i);
        e e = e.g;
        stringBuilder = new StringBuilder();
        stringBuilder.append("chose fixed fps: ");
        stringBuilder.append(i);
        e.c("CameraUtils", stringBuilder.toString());
        return i;
      } 
      e.g.c("CameraUtils", "no appropriate fixed fps.");
    } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
      stringIndexOutOfBoundsException.printStackTrace();
      e.g.e("CameraUtils", "getSupportedPreviewFpsRange() gave StringIndexOutOfBoundsException");
    } 
    int[] arrayOfInt = new int[2];
    paramParameters.getPreviewFpsRange(arrayOfInt);
    e e1 = e.g;
    stringBuilder = new StringBuilder();
    stringBuilder.append("use default preview fps range ");
    stringBuilder.append(arrayOfInt[0]);
    stringBuilder.append(" - ");
    stringBuilder.append(arrayOfInt[1]);
    e1.d("CameraUtils", stringBuilder.toString());
    return arrayOfInt[1];
  }
  
  public static Camera.Size a(Camera.Parameters paramParameters, CameraStreamingSetting.PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO, CameraStreamingSetting.PREVIEW_SIZE_LEVEL paramPREVIEW_SIZE_LEVEL) {
    StringBuilder stringBuilder1;
    Camera.Size<Camera.Size> size;
    List<Camera.Size> list = a(a(paramParameters.getSupportedPreviewSizes(), paramPREVIEW_SIZE_RATIO));
    for (Camera.Size size1 : list) {
      e e1 = e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("after filter size.w:");
      stringBuilder.append(size1.width);
      stringBuilder.append(", size.h:");
      stringBuilder.append(size1.height);
      e1.c("CameraUtils", stringBuilder.toString());
    } 
    if (list.isEmpty())
      return null; 
    int j = b.a[paramPREVIEW_SIZE_LEVEL.ordinal()];
    int i = 0;
    if (j != 1) {
      if (j != 2) {
        if (j == 3) {
          size = list.get(list.size() - 1);
        } else {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("cannot support level:");
          stringBuilder1.append(paramPREVIEW_SIZE_LEVEL);
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
      } else {
        if (size.size() - 1 >= 0)
          i = (size.size() - 1) / 2; 
        size = size.get(i);
      } 
    } else {
      size = size.get(0);
    } 
    e e = e.g;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("preview size width:");
    stringBuilder2.append(size.width);
    stringBuilder2.append(",height:");
    stringBuilder2.append(size.height);
    e.c("CameraUtils", stringBuilder2.toString());
    stringBuilder1.setPreviewSize(size.width, size.height);
    return size;
  }
  
  public static Camera.Size a(List<Camera.Size> paramList, CameraStreamingSetting.PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO, int paramInt) {
    Camera.Size size;
    List list = null;
    if (paramList == null)
      return null; 
    double d2 = a(paramPREVIEW_SIZE_RATIO);
    double d1 = Double.MAX_VALUE;
    Iterator<Camera.Size> iterator = paramList.iterator();
    paramList = list;
    while (iterator.hasNext()) {
      Camera.Size size1 = iterator.next();
      if (size1.height != paramInt || !a(size1)) {
        iterator.remove();
        continue;
      } 
      double d = Math.abs(d2 - size1.width * 1.0D / size1.height);
      if (d < d1) {
        size = size1;
        d1 = d;
      } 
    } 
    return size;
  }
  
  public static CameraStreamingSetting.PREVIEW_SIZE_RATIO a(int paramInt1, int paramInt2) {
    e e = e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getRatioBySize width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",height:");
    stringBuilder.append(paramInt2);
    e.c("CameraUtils", stringBuilder.toString());
    double d2 = paramInt1 / paramInt2;
    double d1 = Math.abs(d2 - 1.3333333333333333D);
    d2 = Math.abs(d2 - 1.7777777777777777D);
    if (d1 <= 0.05D)
      return CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_4_3; 
    if (d2 <= 0.05D)
      return CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9; 
    e.g.d("CameraUtils", "ratio of this size beyond tolerance of 4:3 and 16:9, pick the closet one");
    return (d1 < d2) ? CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_4_3 : CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9;
  }
  
  public static List<Camera.Size> a(List<Camera.Size> paramList) {
    Collections.sort(paramList, new a());
    return paramList;
  }
  
  public static List<Camera.Size> a(List<Camera.Size> paramList, int paramInt) {
    if (paramList == null)
      return null; 
    Iterator<Camera.Size> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      Camera.Size size = iterator.next();
      if (size.height <= paramInt || !a(size))
        iterator.remove(); 
    } 
    return paramList;
  }
  
  public static List<Camera.Size> a(List<Camera.Size> paramList, CameraStreamingSetting.PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO) {
    if (paramList == null)
      return null; 
    double d = a(paramPREVIEW_SIZE_RATIO);
    Iterator<Camera.Size> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      Camera.Size size = iterator.next();
      e e = e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("size.width:");
      stringBuilder.append(size.width);
      stringBuilder.append(",size.height:");
      stringBuilder.append(size.height);
      e.c("CameraUtils", stringBuilder.toString());
      if (Math.abs(size.width / size.height - d) > 0.05D || b(size))
        iterator.remove(); 
    } 
    return paramList;
  }
  
  public static boolean a(Camera.Size paramSize) {
    boolean bool2 = false;
    if (paramSize == null)
      return false; 
    boolean bool1 = bool2;
    if (paramSize.width % 16 == 0) {
      bool1 = bool2;
      if (paramSize.height % 16 == 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static Camera.Size b(List<Camera.Size> paramList, CameraStreamingSetting.PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO, int paramInt) {
    Camera.Size size;
    List list = null;
    if (paramList == null)
      return null; 
    double d = a(paramPREVIEW_SIZE_RATIO);
    Iterator<Camera.Size> iterator = paramList.iterator();
    paramList = list;
    while (iterator.hasNext()) {
      Camera.Size size1 = iterator.next();
      if (size1.height != paramInt || !a(size1)) {
        iterator.remove();
        continue;
      } 
      if (Math.abs(size1.width / size1.height - d) > 0.05D || b(size1)) {
        iterator.remove();
        continue;
      } 
      size = size1;
    } 
    return size;
  }
  
  public static List<Camera.Size> b(List<Camera.Size> paramList, int paramInt) {
    if (paramList == null)
      return null; 
    Iterator<Camera.Size> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      Camera.Size size = iterator.next();
      if (size.height >= paramInt || !a(size))
        iterator.remove(); 
    } 
    return paramList;
  }
  
  public static boolean b(Camera.Size paramSize) {
    for (a.a.a.a.a.e.f f1 : a) {
      if (paramSize.width == f1.a() && paramSize.height == f1.b()) {
        e.g.c("CameraUtils", "Incompatible size just remove it.");
        return true;
      } 
      if ((Build.MODEL.equals("MI 5s") || Build.MODEL.equals("MI 5")) && paramSize.width == 864 && paramSize.height == 480)
        return true; 
    } 
    return false;
  }
  
  public static final class a implements Comparator<Camera.Size> {
    public int a(Camera.Size param1Size1, Camera.Size param1Size2) {
      return param1Size1.width * param1Size1.height - param1Size2.width * param1Size2.height;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */