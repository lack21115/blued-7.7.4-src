package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

public class ShapeAppearancePathProvider {
  private final ShapePath[] a = new ShapePath[4];
  
  private final Matrix[] b = new Matrix[4];
  
  private final Matrix[] c = new Matrix[4];
  
  private final PointF d = new PointF();
  
  private final Path e = new Path();
  
  private final Path f = new Path();
  
  private final ShapePath g = new ShapePath();
  
  private final float[] h = new float[2];
  
  private final float[] i = new float[2];
  
  private boolean j = true;
  
  public ShapeAppearancePathProvider() {
    for (int i = 0; i < 4; i++) {
      this.a[i] = new ShapePath();
      this.b[i] = new Matrix();
      this.c[i] = new Matrix();
    } 
  }
  
  private float a(RectF paramRectF, int paramInt) {
    this.h[0] = (this.a[paramInt]).c;
    this.h[1] = (this.a[paramInt]).d;
    this.b[paramInt].mapPoints(this.h);
    return (paramInt != 1 && paramInt != 3) ? Math.abs(paramRectF.centerY() - this.h[1]) : Math.abs(paramRectF.centerX() - this.h[0]);
  }
  
  private CornerTreatment a(int paramInt, ShapeAppearanceModel paramShapeAppearanceModel) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? paramShapeAppearanceModel.c() : paramShapeAppearanceModel.b()) : paramShapeAppearanceModel.e()) : paramShapeAppearanceModel.d();
  }
  
  private void a(int paramInt) {
    this.h[0] = this.a[paramInt].d();
    this.h[1] = this.a[paramInt].e();
    this.b[paramInt].mapPoints(this.h);
    float f = b(paramInt);
    this.c[paramInt].reset();
    Matrix matrix = this.c[paramInt];
    float[] arrayOfFloat = this.h;
    matrix.setTranslate(arrayOfFloat[0], arrayOfFloat[1]);
    this.c[paramInt].preRotate(f);
  }
  
  private void a(int paramInt, RectF paramRectF, PointF paramPointF) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          paramPointF.set(paramRectF.right, paramRectF.top);
          return;
        } 
        paramPointF.set(paramRectF.left, paramRectF.top);
        return;
      } 
      paramPointF.set(paramRectF.left, paramRectF.bottom);
      return;
    } 
    paramPointF.set(paramRectF.right, paramRectF.bottom);
  }
  
  private void a(ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt) {
    CornerSize cornerSize = b(paramInt, paramShapeAppearancePathSpec.a);
    a(paramInt, paramShapeAppearancePathSpec.a).a(this.a[paramInt], 90.0F, paramShapeAppearancePathSpec.e, paramShapeAppearancePathSpec.c, cornerSize);
    float f = b(paramInt);
    this.b[paramInt].reset();
    a(paramInt, paramShapeAppearancePathSpec.c, this.d);
    this.b[paramInt].setTranslate(this.d.x, this.d.y);
    this.b[paramInt].preRotate(f);
  }
  
  private boolean a(Path paramPath, int paramInt) {
    Path path = new Path();
    this.a[paramInt].a(this.b[paramInt], path);
    RectF rectF = new RectF();
    boolean bool = true;
    paramPath.computeBounds(rectF, true);
    path.computeBounds(rectF, true);
    paramPath.op(path, Path.Op.INTERSECT);
    paramPath.computeBounds(rectF, true);
    if (rectF.isEmpty()) {
      if (rectF.width() > 1.0F && rectF.height() > 1.0F)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  private float b(int paramInt) {
    return ((paramInt + 1) * 90);
  }
  
  private CornerSize b(int paramInt, ShapeAppearanceModel paramShapeAppearanceModel) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? paramShapeAppearanceModel.g() : paramShapeAppearanceModel.f()) : paramShapeAppearanceModel.i()) : paramShapeAppearanceModel.h();
  }
  
  private void b(ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt) {
    this.h[0] = this.a[paramInt].b();
    this.h[1] = this.a[paramInt].c();
    this.b[paramInt].mapPoints(this.h);
    if (paramInt == 0) {
      Path path = paramShapeAppearancePathSpec.b;
      float[] arrayOfFloat = this.h;
      path.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    } else {
      Path path = paramShapeAppearancePathSpec.b;
      float[] arrayOfFloat = this.h;
      path.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
    } 
    this.a[paramInt].a(this.b[paramInt], paramShapeAppearancePathSpec.b);
    if (paramShapeAppearancePathSpec.d != null)
      paramShapeAppearancePathSpec.d.a(this.a[paramInt], this.b[paramInt], paramInt); 
  }
  
  private EdgeTreatment c(int paramInt, ShapeAppearanceModel paramShapeAppearanceModel) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? paramShapeAppearanceModel.l() : paramShapeAppearanceModel.k()) : paramShapeAppearanceModel.j()) : paramShapeAppearanceModel.m();
  }
  
  private void c(ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt) {
    int i = (paramInt + 1) % 4;
    this.h[0] = this.a[paramInt].d();
    this.h[1] = this.a[paramInt].e();
    this.b[paramInt].mapPoints(this.h);
    this.i[0] = this.a[i].b();
    this.i[1] = this.a[i].c();
    this.b[i].mapPoints(this.i);
    float[] arrayOfFloat1 = this.h;
    float f1 = arrayOfFloat1[0];
    float[] arrayOfFloat2 = this.i;
    f1 = Math.max((float)Math.hypot((f1 - arrayOfFloat2[0]), (arrayOfFloat1[1] - arrayOfFloat2[1])) - 0.001F, 0.0F);
    float f2 = a(paramShapeAppearancePathSpec.c, paramInt);
    this.g.a(0.0F, 0.0F);
    EdgeTreatment edgeTreatment = c(paramInt, paramShapeAppearancePathSpec.a);
    edgeTreatment.a(f1, f2, paramShapeAppearancePathSpec.e, this.g);
    Path path = new Path();
    this.g.a(this.c[paramInt], path);
    if (this.j && Build.VERSION.SDK_INT >= 19 && (edgeTreatment.f() || a(path, paramInt) || a(path, i))) {
      path.op(path, this.f, Path.Op.DIFFERENCE);
      this.h[0] = this.g.b();
      this.h[1] = this.g.c();
      this.c[paramInt].mapPoints(this.h);
      Path path1 = this.e;
      float[] arrayOfFloat = this.h;
      path1.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
      this.g.a(this.c[paramInt], this.e);
    } else {
      this.g.a(this.c[paramInt], paramShapeAppearancePathSpec.b);
    } 
    if (paramShapeAppearancePathSpec.d != null)
      paramShapeAppearancePathSpec.d.b(this.g, this.c[paramInt], paramInt); 
  }
  
  public void a(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, Path paramPath) {
    a(paramShapeAppearanceModel, paramFloat, paramRectF, null, paramPath);
  }
  
  public void a(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, PathListener paramPathListener, Path paramPath) {
    int j;
    paramPath.rewind();
    this.e.rewind();
    this.f.rewind();
    this.f.addRect(paramRectF, Path.Direction.CW);
    ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(paramShapeAppearanceModel, paramFloat, paramRectF, paramPathListener, paramPath);
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < 4) {
        a(shapeAppearancePathSpec, i);
        a(i);
        i++;
        continue;
      } 
      break;
    } 
    while (j < 4) {
      b(shapeAppearancePathSpec, j);
      c(shapeAppearancePathSpec, j);
      j++;
    } 
    paramPath.close();
    this.e.close();
    if (Build.VERSION.SDK_INT >= 19 && !this.e.isEmpty())
      paramPath.op(this.e, Path.Op.UNION); 
  }
  
  public static interface PathListener {
    void a(ShapePath param1ShapePath, Matrix param1Matrix, int param1Int);
    
    void b(ShapePath param1ShapePath, Matrix param1Matrix, int param1Int);
  }
  
  static final class ShapeAppearancePathSpec {
    public final ShapeAppearanceModel a;
    
    public final Path b;
    
    public final RectF c;
    
    public final ShapeAppearancePathProvider.PathListener d;
    
    public final float e;
    
    ShapeAppearancePathSpec(ShapeAppearanceModel param1ShapeAppearanceModel, float param1Float, RectF param1RectF, ShapeAppearancePathProvider.PathListener param1PathListener, Path param1Path) {
      this.d = param1PathListener;
      this.a = param1ShapeAppearanceModel;
      this.e = param1Float;
      this.c = param1RectF;
      this.b = param1Path;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\ShapeAppearancePathProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */