package com.qiniu.pili.droid.shortvideo.a.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.WindowManager;
import java.util.List;

public class c {
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > paramInt3) ? paramInt3 : ((paramInt1 < paramInt2) ? paramInt2 : paramInt1);
  }
  
  public static int a(Context paramContext) {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
  }
  
  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    if (paramBoolean) {
      f1 = -1.0F;
    } else {
      f1 = 1.0F;
    } 
    paramMatrix.setScale(f1, 1.0F);
    paramMatrix.postRotate(paramInt1);
    float f1 = paramInt2;
    float f2 = f1 / 2000.0F;
    float f3 = paramInt3;
    paramMatrix.postScale(f2, f3 / 2000.0F);
    paramMatrix.postTranslate(f1 / 2.0F, f3 / 2.0F);
  }
  
  public static void a(RectF paramRectF, Rect paramRect) {
    paramRect.left = Math.round(paramRectF.left);
    paramRect.top = Math.round(paramRectF.top);
    paramRect.right = Math.round(paramRectF.right);
    paramRect.bottom = Math.round(paramRectF.bottom);
  }
  
  public static boolean a(String paramString, List<String> paramList) {
    return (paramList != null && paramList.indexOf(paramString) >= 0);
  }
  
  public static int b(Context paramContext) {
    int i = a(paramContext);
    return (i != 0) ? ((i != 1) ? ((i != 2) ? ((i != 3) ? 0 : 270) : 180) : 90) : 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */