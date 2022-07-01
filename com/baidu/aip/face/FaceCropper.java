package com.baidu.aip.face;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.idl.facesdk.FaceInfo;

public class FaceCropper {
  public static void adjustRect(int[] paramArrayOfint, int paramInt, Rect paramRect) {
    paramRect.left = Math.max(paramRect.left, 0);
    paramRect.right = Math.min(paramRect.right, paramInt);
    paramInt = paramArrayOfint.length / paramInt;
    paramRect.bottom = Math.min(paramRect.bottom, paramInt);
    paramRect.sort();
  }
  
  public static int[] crop(int[] paramArrayOfint, int paramInt, Rect paramRect) {
    adjustRect(paramArrayOfint, paramInt, paramRect);
    int[] arrayOfInt = new int[paramRect.width() * paramRect.height()];
    int i = paramRect.top;
    while (i < paramRect.bottom) {
      try {
        System.arraycopy(paramArrayOfint, paramInt * i + paramRect.left, arrayOfInt, paramRect.width() * (i - paramRect.top), paramRect.width());
        i++;
      } catch (Exception exception) {
        exception.printStackTrace();
        return paramArrayOfint;
      } 
    } 
    return arrayOfInt;
  }
  
  public static Bitmap getFace(int[] paramArrayOfint, FaceInfo paramFaceInfo, int paramInt) {
    int[] arrayOfInt = new int[8];
    paramFaceInfo.getRectPoints(arrayOfInt);
    int i = arrayOfInt[2];
    int j = arrayOfInt[3];
    int m = arrayOfInt[6];
    int k = arrayOfInt[7];
    i = (m - i) * 3 / 2;
    m = (k - j) * 2;
    int n = paramFaceInfo.mCenter_x;
    int i1 = i / 2;
    j = paramFaceInfo.mCenter_y;
    k = m / 2;
    m = m * 4 / 5;
    n = Math.max(n - i1, 0);
    j = Math.max(j - k, 0);
    Rect rect = new Rect(n, j, i + n, m + j);
    adjustRect(paramArrayOfint, paramInt, rect);
    return Bitmap.createBitmap(paramArrayOfint, rect.top * paramInt + rect.left, paramInt, rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\FaceCropper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */