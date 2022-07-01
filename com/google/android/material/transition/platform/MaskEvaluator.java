package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class MaskEvaluator {
  private final Path a = new Path();
  
  private final Path b = new Path();
  
  private final Path c = new Path();
  
  private final ShapeAppearancePathProvider d = new ShapeAppearancePathProvider();
  
  private ShapeAppearanceModel e;
  
  Path a() {
    return this.a;
  }
  
  void a(float paramFloat, ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, MaterialContainerTransform.ProgressThresholds paramProgressThresholds) {
    this.e = TransitionUtils.a(paramShapeAppearanceModel1, paramShapeAppearanceModel2, paramRectF1, paramRectF3, paramProgressThresholds.a(), paramProgressThresholds.b(), paramFloat);
    this.d.a(this.e, 1.0F, paramRectF2, this.b);
    this.d.a(this.e, 1.0F, paramRectF3, this.c);
    if (Build.VERSION.SDK_INT >= 23)
      this.a.op(this.b, this.c, Path.Op.UNION); 
  }
  
  void a(Canvas paramCanvas) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramCanvas.clipPath(this.a);
      return;
    } 
    paramCanvas.clipPath(this.b);
    paramCanvas.clipPath(this.c, Region.Op.UNION);
  }
  
  ShapeAppearanceModel b() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\MaskEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */