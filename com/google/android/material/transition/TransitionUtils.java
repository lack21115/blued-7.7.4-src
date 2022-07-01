package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

class TransitionUtils {
  private static final RectF a = new RectF();
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
    return (paramFloat5 < paramFloat3) ? paramFloat1 : ((paramFloat5 > paramFloat4) ? paramFloat2 : a(paramFloat1, paramFloat2, (paramFloat5 - paramFloat3) / (paramFloat4 - paramFloat3)));
  }
  
  static float a(RectF paramRectF) {
    return paramRectF.width() * paramRectF.height();
  }
  
  static int a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat3 < paramFloat1) ? paramInt1 : ((paramFloat3 > paramFloat2) ? paramInt2 : (int)a(paramInt1, paramInt2, (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1)));
  }
  
  private static int a(Canvas paramCanvas, Rect paramRect, int paramInt) {
    a.set(paramRect);
    return (Build.VERSION.SDK_INT >= 21) ? paramCanvas.saveLayerAlpha(a, paramInt) : paramCanvas.saveLayerAlpha(a.left, a.top, a.right, a.bottom, paramInt, 31);
  }
  
  static RectF a(View paramView) {
    return new RectF(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  static Shader a(int paramInt) {
    return (Shader)new LinearGradient(0.0F, 0.0F, 0.0F, 0.0F, paramInt, paramInt, Shader.TileMode.CLAMP);
  }
  
  static View a(View paramView, int paramInt) {
    View view = paramView.findViewById(paramInt);
    return (view != null) ? view : b(paramView, paramInt);
  }
  
  static ShapeAppearanceModel a(ShapeAppearanceModel paramShapeAppearanceModel, RectF paramRectF) {
    return paramShapeAppearanceModel.a(new ShapeAppearanceModel.CornerSizeUnaryOperator(paramRectF) {
          public CornerSize a(CornerSize param1CornerSize) {
            return (CornerSize)((param1CornerSize instanceof RelativeCornerSize) ? param1CornerSize : new RelativeCornerSize(param1CornerSize.a(this.a) / this.a.height()));
          }
        });
  }
  
  static ShapeAppearanceModel a(ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat3 < paramFloat1) ? paramShapeAppearanceModel1 : ((paramFloat3 > paramFloat2) ? paramShapeAppearanceModel2 : a(paramShapeAppearanceModel1, paramShapeAppearanceModel2, paramRectF1, new CornerSizeBinaryOperator(paramRectF1, paramRectF2, paramFloat1, paramFloat2, paramFloat3) {
          public CornerSize a(CornerSize param1CornerSize1, CornerSize param1CornerSize2) {
            return (CornerSize)new AbsoluteCornerSize(TransitionUtils.a(param1CornerSize1.a(this.a), param1CornerSize2.a(this.b), this.c, this.d, this.e));
          }
        }));
  }
  
  static ShapeAppearanceModel a(ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF, CornerSizeBinaryOperator paramCornerSizeBinaryOperator) {
    ShapeAppearanceModel shapeAppearanceModel;
    if (b(paramShapeAppearanceModel1, paramRectF)) {
      shapeAppearanceModel = paramShapeAppearanceModel1;
    } else {
      shapeAppearanceModel = paramShapeAppearanceModel2;
    } 
    return shapeAppearanceModel.n().a(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.f(), paramShapeAppearanceModel2.f())).b(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.g(), paramShapeAppearanceModel2.g())).d(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.i(), paramShapeAppearanceModel2.i())).c(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.h(), paramShapeAppearanceModel2.h())).a();
  }
  
  static <T> T a(T paramT1, T paramT2) {
    return (paramT1 != null) ? paramT1 : paramT2;
  }
  
  static void a(Canvas paramCanvas, Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, CanvasOperation paramCanvasOperation) {
    if (paramInt <= 0)
      return; 
    int i = paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramCanvas.scale(paramFloat3, paramFloat3);
    if (paramInt < 255)
      a(paramCanvas, paramRect, paramInt); 
    paramCanvasOperation.a(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  static RectF b(View paramView) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    return new RectF(i, j, (k + i), (m + j));
  }
  
  static View b(View paramView, int paramInt) {
    String str = paramView.getResources().getResourceName(paramInt);
    while (paramView != null) {
      if (paramView.getId() == paramInt)
        return paramView; 
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof View)
        View view = (View)viewParent; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(" is not a valid ancestor");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static boolean b(ShapeAppearanceModel paramShapeAppearanceModel, RectF paramRectF) {
    return (paramShapeAppearanceModel.f().a(paramRectF) != 0.0F || paramShapeAppearanceModel.g().a(paramRectF) != 0.0F || paramShapeAppearanceModel.h().a(paramRectF) != 0.0F || paramShapeAppearanceModel.i().a(paramRectF) != 0.0F);
  }
  
  static interface CanvasOperation {
    void a(Canvas param1Canvas);
  }
  
  static interface CornerSizeBinaryOperator {
    CornerSize a(CornerSize param1CornerSize1, CornerSize param1CornerSize2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\TransitionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */