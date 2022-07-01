package com.blued.android.module.external_sense_library.glutils;

import android.graphics.Rect;
import android.util.Log;
import com.sensetime.stmobile.model.STAnimalFace;
import com.sensetime.stmobile.model.STHumanAction;

public class STUtils {
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > paramInt3) ? paramInt3 : ((paramInt1 < paramInt2) ? paramInt2 : paramInt1);
  }
  
  public static Rect a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Rect rect = new Rect();
    float f2 = paramInt2;
    float f1 = paramInt1;
    float f5 = f2 / f1;
    float f3 = paramInt4;
    float f4 = paramInt3;
    if (f5 >= f3 / f4) {
      f2 /= f3;
      paramInt1 = (int)(f4 - f1 / f2) / 2;
      if (paramRect.left <= 0) {
        rect.left = paramInt1;
        rect.right = (int)(paramRect.width() / f2) + paramInt1;
      } else {
        f3 = paramRect.right;
        f4 = paramInt1;
        if (f3 >= f1 + f4 * f2) {
          paramInt1 = paramInt3 - paramInt1;
          rect.left = (int)(paramInt1 - paramRect.width() / f2);
          rect.right = paramInt1 - 1;
        } else {
          rect.left = (int)(paramRect.left / f2 + f4);
          rect.right = (int)(paramRect.right / f2 + f4);
        } 
      } 
      if (paramRect.top <= 0) {
        rect.top = 0;
        rect.bottom = (int)(paramRect.height() / f2);
        return rect;
      } 
      if (paramRect.bottom >= paramInt2) {
        rect.bottom = paramInt4 - 1;
        rect.top = (int)(rect.bottom - paramRect.height() / f2);
        return rect;
      } 
      rect.top = (int)(paramRect.top / f2);
      rect.bottom = (int)(paramRect.bottom / f2);
      return rect;
    } 
    f4 = f1 / f4;
    paramInt1 = (int)(f3 - f2 / f4) / 2;
    if (paramRect.top <= 0) {
      rect.top = paramInt1;
      rect.bottom = (int)(paramRect.height() / f4) + paramInt1;
    } else {
      f3 = paramRect.bottom;
      f5 = paramInt1;
      if (f3 >= f2 + f5 * f4) {
        rect.bottom = paramInt4 - 1;
        rect.top = (int)(rect.bottom - paramRect.height() / f4);
      } else {
        rect.top = (int)(paramRect.top / f4 + f5);
        rect.bottom = (int)(paramRect.bottom / f4 + f5);
      } 
    } 
    if (paramRect.left <= 0) {
      rect.left = 0;
      rect.right = (int)(paramRect.width() / f4);
      return rect;
    } 
    if (paramRect.right + paramInt1 * f4 >= f1) {
      rect.right = paramInt3 - 1;
      rect.left = (int)(rect.right - paramRect.width() / f4);
      return rect;
    } 
    rect.left = (int)(paramRect.left / f4);
    rect.right = (int)(paramRect.right / f4);
    return rect;
  }
  
  public static Rect a(Rect paramRect, int paramInt1, int paramInt2, boolean paramBoolean) {
    int i = paramRect.left;
    paramRect.left = paramRect.top;
    paramRect.top = paramInt2 - paramRect.right;
    paramRect.right = paramRect.bottom;
    paramRect.bottom = paramInt2 - i;
    if (paramBoolean) {
      Rect rect = new Rect();
      rect.left = paramInt1 - paramRect.right;
      rect.right = paramInt1 - paramRect.left;
      rect.top = paramRect.top;
      rect.bottom = paramRect.bottom;
      return rect;
    } 
    return paramRect;
  }
  
  public static Rect a(float[] paramArrayOffloat, float paramFloat1, float paramFloat2, int paramInt) {
    if (paramArrayOffloat.length < 2)
      return null; 
    int k = (int)(paramArrayOffloat[0] / paramFloat2 * 2000.0F - 1000.0F);
    int i = (int)(paramArrayOffloat[1] / paramFloat1 * 2000.0F - 1000.0F);
    int j = paramInt / 2;
    k = a(k - j, -1000, 1000);
    int m = a(k + paramInt, -1000, 1000);
    i = a(i - j, -1000, 1000);
    return new Rect(k, i, m, a(paramInt + i, -1000, 1000));
  }
  
  public static void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOffloat) {
    if (paramInt3 != 1 && paramInt3 != 0)
      return; 
    if (paramInt4 != 90 && paramInt4 != 270)
      return; 
    if (paramInt3 == 1 && paramInt4 == 90) {
      a(paramFloat1, paramFloat2, paramInt1, paramInt2, true, paramArrayOffloat);
    } else if (paramInt3 == 1 && paramInt4 == 270) {
      b(paramFloat1, paramFloat2, paramInt1, paramInt2, true, paramArrayOffloat);
    } else if (paramInt3 == 0 && paramInt4 == 270) {
      b(paramFloat1, paramFloat2, paramInt1, paramInt2, false, paramArrayOffloat);
    } else if (paramInt3 == 0 && paramInt4 == 90) {
      a(paramFloat1, paramFloat2, paramInt1, paramInt2, false, paramArrayOffloat);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramArrayOffloat[0]);
    stringBuilder.append("   ");
    stringBuilder.append(paramArrayOffloat[1]);
    Log.d("touchPosition", stringBuilder.toString());
  }
  
  public static void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat) {
    if (paramArrayOffloat.length < 2)
      return; 
    paramArrayOffloat[0] = paramFloat2;
    paramArrayOffloat[1] = paramInt1 - paramFloat1;
    if (paramBoolean)
      paramArrayOffloat[0] = paramInt2 - paramFloat2; 
  }
  
  public static float[] a(STAnimalFace paramSTAnimalFace, int paramInt1, int paramInt2) {
    if (paramSTAnimalFace == null)
      return null; 
    int j = paramSTAnimalFace.getKey_points_count();
    float[] arrayOfFloat = new float[j * 2];
    for (int i = 0; i < j; i++) {
      int k = i * 2;
      arrayOfFloat[k] = paramSTAnimalFace.getP_key_points()[i].getX() / paramInt1 * 2.0F - 1.0F;
      arrayOfFloat[k + 1] = paramSTAnimalFace.getP_key_points()[i].getY() / paramInt2 * 2.0F - 1.0F;
    } 
    return arrayOfFloat;
  }
  
  public static float[] a(STHumanAction paramSTHumanAction, int paramInt1, int paramInt2, int paramInt3) {
    int j;
    if (paramSTHumanAction == null || paramSTHumanAction.faceCount < paramInt1 + 1)
      return null; 
    float[] arrayOfFloat = new float[((paramSTHumanAction.faces[paramInt1]).extraFacePointsCount + (paramSTHumanAction.faces[paramInt1]).eyeballCenterPointsCount + (paramSTHumanAction.faces[paramInt1]).eyeballContourPointsCount) * 2];
    byte b = 0;
    int i;
    for (i = 0; i < (paramSTHumanAction.faces[paramInt1]).extraFacePointsCount; i++) {
      j = i * 2;
      arrayOfFloat[j] = paramSTHumanAction.faces[paramInt1].getExtraFacePoints()[i].getX() / paramInt2 * 2.0F - 1.0F;
      arrayOfFloat[j + 1] = paramSTHumanAction.faces[paramInt1].getExtraFacePoints()[i].getY() / paramInt3 * 2.0F - 1.0F;
    } 
    i = 0;
    while (true) {
      j = b;
      if (i < (paramSTHumanAction.faces[paramInt1]).eyeballCenterPointsCount) {
        j = i * 2;
        arrayOfFloat[(paramSTHumanAction.faces[paramInt1]).extraFacePointsCount * 2 + j] = paramSTHumanAction.faces[paramInt1].getEyeballCenter()[i].getX() / paramInt2 * 2.0F - 1.0F;
        arrayOfFloat[j + 1 + (paramSTHumanAction.faces[paramInt1]).extraFacePointsCount * 2] = paramSTHumanAction.faces[paramInt1].getEyeballCenter()[i].getY() / paramInt3 * 2.0F - 1.0F;
        i++;
        continue;
      } 
      break;
    } 
    while (j < (paramSTHumanAction.faces[paramInt1]).eyeballContourPointsCount) {
      i = j * 2;
      arrayOfFloat[((paramSTHumanAction.faces[paramInt1]).extraFacePointsCount + (paramSTHumanAction.faces[paramInt1]).eyeballCenterPointsCount) * 2 + i] = paramSTHumanAction.faces[paramInt1].getEyeballContour()[j].getX() / paramInt2 * 2.0F - 1.0F;
      arrayOfFloat[i + 1 + ((paramSTHumanAction.faces[paramInt1]).extraFacePointsCount + (paramSTHumanAction.faces[paramInt1]).eyeballCenterPointsCount) * 2] = paramSTHumanAction.faces[paramInt1].getEyeballContour()[j].getY() / paramInt3 * 2.0F - 1.0F;
      j++;
    } 
    return arrayOfFloat;
  }
  
  public static Rect b(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f1 = paramInt2;
    float f2 = paramInt1;
    float f5 = f1 / f2;
    float f3 = paramInt4;
    float f4 = paramInt3;
    if (f5 >= f3 / f4) {
      f1 /= f3;
      paramInt1 = (int)((f4 - f2 / f1) * f1 / 2.0F);
      f2 = paramRect.left;
      f3 = paramInt1;
      paramRect.left = (int)(f2 * f1 - f3);
      paramRect.top = (int)(paramRect.top * f1);
      paramRect.right = (int)(paramRect.right * f1 - f3);
      paramRect.bottom = (int)(paramRect.bottom * f1);
      return paramRect;
    } 
    f2 /= f4;
    paramInt1 = (int)((f3 - f1 / f2) * f2 / 2.0F);
    paramRect.left = (int)(paramRect.left * f2);
    f1 = paramRect.top;
    f3 = paramInt1;
    paramRect.top = (int)(f1 * f2 - f3);
    paramRect.right = (int)(paramRect.right * f2);
    paramRect.bottom = (int)(paramRect.bottom * f2 - f3);
    return paramRect;
  }
  
  public static Rect b(Rect paramRect, int paramInt1, int paramInt2, boolean paramBoolean) {
    int i = paramRect.left;
    paramRect.left = paramInt2 - paramRect.bottom;
    paramRect.bottom = paramRect.right;
    paramRect.right = paramInt2 - paramRect.top;
    paramRect.top = i;
    if (paramBoolean) {
      Rect rect = new Rect();
      rect.left = paramRect.left;
      rect.right = paramRect.right;
      rect.top = paramInt1 - paramRect.bottom;
      rect.bottom = paramInt1 - paramRect.top;
      return rect;
    } 
    return paramRect;
  }
  
  public static void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat) {
    if (paramArrayOffloat.length < 2)
      return; 
    paramArrayOffloat[0] = paramInt2 - paramFloat2;
    paramArrayOffloat[1] = paramFloat1;
    if (paramBoolean)
      paramArrayOffloat[1] = paramInt1 - paramFloat1; 
  }
  
  public static float[] b(STHumanAction paramSTHumanAction, int paramInt1, int paramInt2, int paramInt3) {
    if (paramSTHumanAction == null || paramSTHumanAction.faceCount < paramInt1 + 1)
      return null; 
    int j = (paramSTHumanAction.faces[paramInt1]).tonguePointsCount;
    float[] arrayOfFloat = new float[j * 2];
    int i;
    for (i = 0; i < j; i++) {
      int k = i * 2;
      arrayOfFloat[k] = (paramSTHumanAction.faces[paramInt1]).tonguePoints[i].getX() / paramInt2 * 2.0F - 1.0F;
      arrayOfFloat[k + 1] = (paramSTHumanAction.faces[paramInt1]).tonguePoints[i].getY() / paramInt3 * 2.0F - 1.0F;
    } 
    return arrayOfFloat;
  }
  
  public static Rect c(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramRect == null)
      return null; 
    if (paramInt3 != 1 && paramInt3 != 0)
      return paramRect; 
    if (paramInt4 != 90 && paramInt4 != 270)
      return paramRect; 
    if (paramInt3 == 1 && paramInt4 == 90)
      return a(paramRect, paramInt2, paramInt1, true); 
    if (paramInt3 == 1 && paramInt4 == 270)
      return b(paramRect, paramInt1, paramInt2, true); 
    if (paramInt3 == 0 && paramInt4 == 270)
      return b(paramRect, paramInt1, paramInt2, false); 
    Rect rect = paramRect;
    if (paramInt3 == 0) {
      rect = paramRect;
      if (paramInt4 == 90)
        rect = a(paramRect, paramInt2, paramInt1, false); 
    } 
    return rect;
  }
  
  public static float[] c(STHumanAction paramSTHumanAction, int paramInt1, int paramInt2, int paramInt3) {
    if (paramSTHumanAction == null || paramSTHumanAction.bodyCount < paramInt1 + 1)
      return null; 
    int j = (paramSTHumanAction.bodys[paramInt1]).keyPointsCount;
    float[] arrayOfFloat = new float[j * 2];
    int i;
    for (i = 0; i < j; i++) {
      int k = i * 2;
      arrayOfFloat[k] = (paramSTHumanAction.bodys[paramInt1]).keyPoints[i].getX() / paramInt2 * 2.0F - 1.0F;
      arrayOfFloat[k + 1] = (paramSTHumanAction.bodys[paramInt1]).keyPoints[i].getY() / paramInt3 * 2.0F - 1.0F;
    } 
    return arrayOfFloat;
  }
  
  public static Rect d(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramRect == null)
      return null; 
    if (paramInt3 != 1 && paramInt3 != 0)
      return paramRect; 
    if (paramInt4 != 90 && paramInt4 != 270)
      return paramRect; 
    if (paramInt3 == 1 && paramInt4 == 90)
      return b(paramRect, paramInt2, paramInt1, true); 
    if (paramInt3 == 1 && paramInt4 == 270)
      return a(paramRect, paramInt1, paramInt2, true); 
    if (paramInt3 == 0 && paramInt4 == 270)
      return a(paramRect, paramInt1, paramInt2, false); 
    Rect rect = paramRect;
    if (paramInt3 == 0) {
      rect = paramRect;
      if (paramInt4 == 90)
        rect = b(paramRect, paramInt2, paramInt1, false); 
    } 
    return rect;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\glutils\STUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */