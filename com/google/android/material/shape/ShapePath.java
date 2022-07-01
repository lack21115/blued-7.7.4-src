package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapePath {
  @Deprecated
  public float a;
  
  @Deprecated
  public float b;
  
  @Deprecated
  public float c;
  
  @Deprecated
  public float d;
  
  @Deprecated
  public float e;
  
  @Deprecated
  public float f;
  
  private final List<PathOperation> g = new ArrayList<PathOperation>();
  
  private final List<ShadowCompatOperation> h = new ArrayList<ShadowCompatOperation>();
  
  private boolean i;
  
  public ShapePath() {
    a(0.0F, 0.0F);
  }
  
  private void a(float paramFloat) {
    if (f() == paramFloat)
      return; 
    float f = (paramFloat - f() + 360.0F) % 360.0F;
    if (f > 180.0F)
      return; 
    PathArcOperation pathArcOperation = new PathArcOperation(d(), e(), d(), e());
    PathArcOperation.a(pathArcOperation, f());
    PathArcOperation.b(pathArcOperation, f);
    this.h.add(new ArcShadowOperation(pathArcOperation));
    f(paramFloat);
  }
  
  private void a(ShadowCompatOperation paramShadowCompatOperation, float paramFloat1, float paramFloat2) {
    a(paramFloat1);
    this.h.add(paramShadowCompatOperation);
    f(paramFloat2);
  }
  
  private void b(float paramFloat) {
    this.a = paramFloat;
  }
  
  private void c(float paramFloat) {
    this.b = paramFloat;
  }
  
  private void d(float paramFloat) {
    this.c = paramFloat;
  }
  
  private void e(float paramFloat) {
    this.d = paramFloat;
  }
  
  private float f() {
    return this.e;
  }
  
  private void f(float paramFloat) {
    this.e = paramFloat;
  }
  
  private float g() {
    return this.f;
  }
  
  private void g(float paramFloat) {
    this.f = paramFloat;
  }
  
  ShadowCompatOperation a(Matrix paramMatrix) {
    a(g());
    return new ShadowCompatOperation(this, new ArrayList<ShadowCompatOperation>(this.h), paramMatrix) {
        public void a(Matrix param1Matrix, ShadowRenderer param1ShadowRenderer, int param1Int, Canvas param1Canvas) {
          Iterator<ShapePath.ShadowCompatOperation> iterator = this.a.iterator();
          while (iterator.hasNext())
            ((ShapePath.ShadowCompatOperation)iterator.next()).a(this.b, param1ShadowRenderer, param1Int, param1Canvas); 
        }
      };
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    a(paramFloat1, paramFloat2, 270.0F, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    b(paramFloat1);
    c(paramFloat2);
    d(paramFloat1);
    e(paramFloat2);
    f(paramFloat3);
    g((paramFloat3 + paramFloat4) % 360.0F);
    this.g.clear();
    this.h.clear();
    this.i = false;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
    boolean bool;
    PathArcOperation pathArcOperation = new PathArcOperation(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    PathArcOperation.a(pathArcOperation, paramFloat5);
    PathArcOperation.b(pathArcOperation, paramFloat6);
    this.g.add(pathArcOperation);
    ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
    float f = paramFloat5 + paramFloat6;
    if (paramFloat6 < 0.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    paramFloat6 = paramFloat5;
    if (bool)
      paramFloat6 = (paramFloat5 + 180.0F) % 360.0F; 
    if (bool) {
      paramFloat5 = (180.0F + f) % 360.0F;
    } else {
      paramFloat5 = f;
    } 
    a(arcShadowOperation, paramFloat6, paramFloat5);
    paramFloat5 = (paramFloat3 - paramFloat1) / 2.0F;
    double d = f;
    d((paramFloat1 + paramFloat3) * 0.5F + paramFloat5 * (float)Math.cos(Math.toRadians(d)));
    e((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(d)));
  }
  
  public void a(Matrix paramMatrix, Path paramPath) {
    int j = this.g.size();
    for (int i = 0; i < j; i++)
      ((PathOperation)this.g.get(i)).a(paramMatrix, paramPath); 
  }
  
  boolean a() {
    return this.i;
  }
  
  float b() {
    return this.a;
  }
  
  public void b(float paramFloat1, float paramFloat2) {
    PathLineOperation pathLineOperation = new PathLineOperation();
    PathLineOperation.a(pathLineOperation, paramFloat1);
    PathLineOperation.b(pathLineOperation, paramFloat2);
    this.g.add(pathLineOperation);
    LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, d(), e());
    a(lineShadowOperation, lineShadowOperation.a() + 270.0F, lineShadowOperation.a() + 270.0F);
    d(paramFloat1);
    e(paramFloat2);
  }
  
  float c() {
    return this.b;
  }
  
  float d() {
    return this.c;
  }
  
  float e() {
    return this.d;
  }
  
  static class ArcShadowOperation extends ShadowCompatOperation {
    private final ShapePath.PathArcOperation a;
    
    public ArcShadowOperation(ShapePath.PathArcOperation param1PathArcOperation) {
      this.a = param1PathArcOperation;
    }
    
    public void a(Matrix param1Matrix, ShadowRenderer param1ShadowRenderer, int param1Int, Canvas param1Canvas) {
      float f1 = ShapePath.PathArcOperation.a(this.a);
      float f2 = ShapePath.PathArcOperation.b(this.a);
      param1ShadowRenderer.a(param1Canvas, param1Matrix, new RectF(ShapePath.PathArcOperation.c(this.a), ShapePath.PathArcOperation.d(this.a), ShapePath.PathArcOperation.e(this.a), ShapePath.PathArcOperation.f(this.a)), param1Int, f1, f2);
    }
  }
  
  static class LineShadowOperation extends ShadowCompatOperation {
    private final ShapePath.PathLineOperation a;
    
    private final float b;
    
    private final float c;
    
    public LineShadowOperation(ShapePath.PathLineOperation param1PathLineOperation, float param1Float1, float param1Float2) {
      this.a = param1PathLineOperation;
      this.b = param1Float1;
      this.c = param1Float2;
    }
    
    float a() {
      return (float)Math.toDegrees(Math.atan(((ShapePath.PathLineOperation.a(this.a) - this.c) / (ShapePath.PathLineOperation.b(this.a) - this.b))));
    }
    
    public void a(Matrix param1Matrix, ShadowRenderer param1ShadowRenderer, int param1Int, Canvas param1Canvas) {
      float f1 = ShapePath.PathLineOperation.a(this.a);
      float f2 = this.c;
      float f3 = ShapePath.PathLineOperation.b(this.a);
      float f4 = this.b;
      RectF rectF = new RectF(0.0F, 0.0F, (float)Math.hypot((f1 - f2), (f3 - f4)), 0.0F);
      param1Matrix = new Matrix(param1Matrix);
      param1Matrix.preTranslate(this.b, this.c);
      param1Matrix.preRotate(a());
      param1ShadowRenderer.a(param1Canvas, param1Matrix, rectF, param1Int);
    }
  }
  
  public static class PathArcOperation extends PathOperation {
    private static final RectF h = new RectF();
    
    @Deprecated
    public float a;
    
    @Deprecated
    public float b;
    
    @Deprecated
    public float c;
    
    @Deprecated
    public float d;
    
    @Deprecated
    public float e;
    
    @Deprecated
    public float f;
    
    public PathArcOperation(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
      a(param1Float1);
      b(param1Float2);
      c(param1Float3);
      d(param1Float4);
    }
    
    private float a() {
      return this.a;
    }
    
    private void a(float param1Float) {
      this.a = param1Float;
    }
    
    private float b() {
      return this.b;
    }
    
    private void b(float param1Float) {
      this.b = param1Float;
    }
    
    private float c() {
      return this.c;
    }
    
    private void c(float param1Float) {
      this.c = param1Float;
    }
    
    private float d() {
      return this.d;
    }
    
    private void d(float param1Float) {
      this.d = param1Float;
    }
    
    private float e() {
      return this.e;
    }
    
    private void e(float param1Float) {
      this.e = param1Float;
    }
    
    private float f() {
      return this.f;
    }
    
    private void f(float param1Float) {
      this.f = param1Float;
    }
    
    public void a(Matrix param1Matrix, Path param1Path) {
      Matrix matrix = this.g;
      param1Matrix.invert(matrix);
      param1Path.transform(matrix);
      h.set(a(), b(), c(), d());
      param1Path.arcTo(h, e(), f(), false);
      param1Path.transform(param1Matrix);
    }
  }
  
  public static class PathCubicOperation extends PathOperation {
    private float a;
    
    private float b;
    
    private float c;
    
    private float d;
    
    private float e;
    
    private float f;
    
    public void a(Matrix param1Matrix, Path param1Path) {
      Matrix matrix = this.g;
      param1Matrix.invert(matrix);
      param1Path.transform(matrix);
      param1Path.cubicTo(this.a, this.b, this.c, this.d, this.e, this.f);
      param1Path.transform(param1Matrix);
    }
  }
  
  public static class PathLineOperation extends PathOperation {
    private float a;
    
    private float b;
    
    public void a(Matrix param1Matrix, Path param1Path) {
      Matrix matrix = this.g;
      param1Matrix.invert(matrix);
      param1Path.transform(matrix);
      param1Path.lineTo(this.a, this.b);
      param1Path.transform(param1Matrix);
    }
  }
  
  public static abstract class PathOperation {
    protected final Matrix g = new Matrix();
    
    public abstract void a(Matrix param1Matrix, Path param1Path);
  }
  
  public static class PathQuadOperation extends PathOperation {
    @Deprecated
    public float a;
    
    @Deprecated
    public float b;
    
    @Deprecated
    public float c;
    
    @Deprecated
    public float d;
    
    private float a() {
      return this.c;
    }
    
    private float b() {
      return this.b;
    }
    
    private float c() {
      return this.d;
    }
    
    private float d() {
      return this.a;
    }
    
    public void a(Matrix param1Matrix, Path param1Path) {
      Matrix matrix = this.g;
      param1Matrix.invert(matrix);
      param1Path.transform(matrix);
      param1Path.quadTo(d(), b(), a(), c());
      param1Path.transform(param1Matrix);
    }
  }
  
  static abstract class ShadowCompatOperation {
    static final Matrix d = new Matrix();
    
    public abstract void a(Matrix param1Matrix, ShadowRenderer param1ShadowRenderer, int param1Int, Canvas param1Canvas);
    
    public final void a(ShadowRenderer param1ShadowRenderer, int param1Int, Canvas param1Canvas) {
      a(d, param1ShadowRenderer, param1Int, param1Canvas);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\ShapePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */