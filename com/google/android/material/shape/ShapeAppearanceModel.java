package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

public class ShapeAppearanceModel {
  public static final CornerSize a = new RelativeCornerSize(0.5F);
  
  CornerTreatment b = MaterialShapeUtils.a();
  
  CornerTreatment c = MaterialShapeUtils.a();
  
  CornerTreatment d = MaterialShapeUtils.a();
  
  CornerTreatment e = MaterialShapeUtils.a();
  
  CornerSize f = new AbsoluteCornerSize(0.0F);
  
  CornerSize g = new AbsoluteCornerSize(0.0F);
  
  CornerSize h = new AbsoluteCornerSize(0.0F);
  
  CornerSize i = new AbsoluteCornerSize(0.0F);
  
  EdgeTreatment j = MaterialShapeUtils.b();
  
  EdgeTreatment k = MaterialShapeUtils.b();
  
  EdgeTreatment l = MaterialShapeUtils.b();
  
  EdgeTreatment m = MaterialShapeUtils.b();
  
  public ShapeAppearanceModel() {}
  
  private ShapeAppearanceModel(Builder paramBuilder) {}
  
  private static CornerSize a(TypedArray paramTypedArray, int paramInt, CornerSize paramCornerSize) {
    TypedValue typedValue = paramTypedArray.peekValue(paramInt);
    return (typedValue == null) ? paramCornerSize : ((typedValue.type == 5) ? new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(typedValue.data, paramTypedArray.getResources().getDisplayMetrics())) : ((typedValue.type == 6) ? new RelativeCornerSize(typedValue.getFraction(1.0F, 1.0F)) : paramCornerSize));
  }
  
  public static Builder a() {
    return new Builder();
  }
  
  public static Builder a(Context paramContext, int paramInt1, int paramInt2) {
    return a(paramContext, paramInt1, paramInt2, 0);
  }
  
  private static Builder a(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
    return a(paramContext, paramInt1, paramInt2, new AbsoluteCornerSize(paramInt3));
  }
  
  private static Builder a(Context paramContext, int paramInt1, int paramInt2, CornerSize paramCornerSize) {
    ContextThemeWrapper contextThemeWrapper;
    Context context = paramContext;
    int i = paramInt1;
    if (paramInt2 != 0) {
      contextThemeWrapper = new ContextThemeWrapper(paramContext, paramInt1);
      i = paramInt2;
    } 
    TypedArray typedArray = contextThemeWrapper.obtainStyledAttributes(i, R.styleable.ShapeAppearance);
    try {
      int j = typedArray.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
      paramInt1 = typedArray.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, j);
      paramInt2 = typedArray.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, j);
      i = typedArray.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, j);
      j = typedArray.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, j);
      CornerSize cornerSize3 = a(typedArray, R.styleable.ShapeAppearance_cornerSize, paramCornerSize);
      paramCornerSize = a(typedArray, R.styleable.ShapeAppearance_cornerSizeTopLeft, cornerSize3);
      CornerSize cornerSize1 = a(typedArray, R.styleable.ShapeAppearance_cornerSizeTopRight, cornerSize3);
      CornerSize cornerSize2 = a(typedArray, R.styleable.ShapeAppearance_cornerSizeBottomRight, cornerSize3);
      cornerSize3 = a(typedArray, R.styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSize3);
      return (new Builder()).a(paramInt1, paramCornerSize).b(paramInt2, cornerSize1).c(i, cornerSize2).d(j, cornerSize3);
    } finally {
      typedArray.recycle();
    } 
  }
  
  public static Builder a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    return a(paramContext, paramAttributeSet, paramInt1, paramInt2, 0);
  }
  
  public static Builder a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3) {
    return a(paramContext, paramAttributeSet, paramInt1, paramInt2, new AbsoluteCornerSize(paramInt3));
  }
  
  public static Builder a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, CornerSize paramCornerSize) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialShape, paramInt1, paramInt2);
    paramInt1 = typedArray.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
    paramInt2 = typedArray.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
    typedArray.recycle();
    return a(paramContext, paramInt1, paramInt2, paramCornerSize);
  }
  
  public ShapeAppearanceModel a(float paramFloat) {
    return n().a(paramFloat).a();
  }
  
  public ShapeAppearanceModel a(CornerSizeUnaryOperator paramCornerSizeUnaryOperator) {
    return n().a(paramCornerSizeUnaryOperator.a(f())).b(paramCornerSizeUnaryOperator.a(g())).d(paramCornerSizeUnaryOperator.a(i())).c(paramCornerSizeUnaryOperator.a(h())).a();
  }
  
  public boolean a(RectF paramRectF) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (this.m.getClass().equals(EdgeTreatment.class) && this.k.getClass().equals(EdgeTreatment.class) && this.j.getClass().equals(EdgeTreatment.class) && this.l.getClass().equals(EdgeTreatment.class)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    float f = this.f.a(paramRectF);
    if (this.g.a(paramRectF) == f && this.i.a(paramRectF) == f && this.h.a(paramRectF) == f) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (this.c instanceof RoundedCornerTreatment && this.b instanceof RoundedCornerTreatment && this.d instanceof RoundedCornerTreatment && this.e instanceof RoundedCornerTreatment) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    return (bool1 && bool2 && bool3);
  }
  
  public CornerTreatment b() {
    return this.b;
  }
  
  public CornerTreatment c() {
    return this.c;
  }
  
  public CornerTreatment d() {
    return this.d;
  }
  
  public CornerTreatment e() {
    return this.e;
  }
  
  public CornerSize f() {
    return this.f;
  }
  
  public CornerSize g() {
    return this.g;
  }
  
  public CornerSize h() {
    return this.h;
  }
  
  public CornerSize i() {
    return this.i;
  }
  
  public EdgeTreatment j() {
    return this.m;
  }
  
  public EdgeTreatment k() {
    return this.j;
  }
  
  public EdgeTreatment l() {
    return this.k;
  }
  
  public EdgeTreatment m() {
    return this.l;
  }
  
  public Builder n() {
    return new Builder(this);
  }
  
  public static final class Builder {
    private CornerTreatment a = MaterialShapeUtils.a();
    
    private CornerTreatment b = MaterialShapeUtils.a();
    
    private CornerTreatment c = MaterialShapeUtils.a();
    
    private CornerTreatment d = MaterialShapeUtils.a();
    
    private CornerSize e = new AbsoluteCornerSize(0.0F);
    
    private CornerSize f = new AbsoluteCornerSize(0.0F);
    
    private CornerSize g = new AbsoluteCornerSize(0.0F);
    
    private CornerSize h = new AbsoluteCornerSize(0.0F);
    
    private EdgeTreatment i = MaterialShapeUtils.b();
    
    private EdgeTreatment j = MaterialShapeUtils.b();
    
    private EdgeTreatment k = MaterialShapeUtils.b();
    
    private EdgeTreatment l = MaterialShapeUtils.b();
    
    public Builder() {}
    
    public Builder(ShapeAppearanceModel param1ShapeAppearanceModel) {
      this.a = param1ShapeAppearanceModel.b;
      this.b = param1ShapeAppearanceModel.c;
      this.c = param1ShapeAppearanceModel.d;
      this.d = param1ShapeAppearanceModel.e;
      this.e = param1ShapeAppearanceModel.f;
      this.f = param1ShapeAppearanceModel.g;
      this.g = param1ShapeAppearanceModel.h;
      this.h = param1ShapeAppearanceModel.i;
      this.i = param1ShapeAppearanceModel.j;
      this.j = param1ShapeAppearanceModel.k;
      this.k = param1ShapeAppearanceModel.l;
      this.l = param1ShapeAppearanceModel.m;
    }
    
    private static float f(CornerTreatment param1CornerTreatment) {
      return (param1CornerTreatment instanceof RoundedCornerTreatment) ? ((RoundedCornerTreatment)param1CornerTreatment).a : ((param1CornerTreatment instanceof CutCornerTreatment) ? ((CutCornerTreatment)param1CornerTreatment).a : -1.0F);
    }
    
    public Builder a(float param1Float) {
      return b(param1Float).c(param1Float).d(param1Float).e(param1Float);
    }
    
    public Builder a(int param1Int, float param1Float) {
      return a(MaterialShapeUtils.a(param1Int)).a(param1Float);
    }
    
    public Builder a(int param1Int, CornerSize param1CornerSize) {
      return b(MaterialShapeUtils.a(param1Int)).a(param1CornerSize);
    }
    
    public Builder a(CornerSize param1CornerSize) {
      this.e = param1CornerSize;
      return this;
    }
    
    public Builder a(CornerTreatment param1CornerTreatment) {
      return b(param1CornerTreatment).c(param1CornerTreatment).d(param1CornerTreatment).e(param1CornerTreatment);
    }
    
    public Builder a(EdgeTreatment param1EdgeTreatment) {
      this.i = param1EdgeTreatment;
      return this;
    }
    
    public ShapeAppearanceModel a() {
      return new ShapeAppearanceModel(this);
    }
    
    public Builder b(float param1Float) {
      this.e = new AbsoluteCornerSize(param1Float);
      return this;
    }
    
    public Builder b(int param1Int, CornerSize param1CornerSize) {
      return c(MaterialShapeUtils.a(param1Int)).b(param1CornerSize);
    }
    
    public Builder b(CornerSize param1CornerSize) {
      this.f = param1CornerSize;
      return this;
    }
    
    public Builder b(CornerTreatment param1CornerTreatment) {
      this.a = param1CornerTreatment;
      float f = f(param1CornerTreatment);
      if (f != -1.0F)
        b(f); 
      return this;
    }
    
    public Builder b(EdgeTreatment param1EdgeTreatment) {
      this.k = param1EdgeTreatment;
      return this;
    }
    
    public Builder c(float param1Float) {
      this.f = new AbsoluteCornerSize(param1Float);
      return this;
    }
    
    public Builder c(int param1Int, CornerSize param1CornerSize) {
      return d(MaterialShapeUtils.a(param1Int)).c(param1CornerSize);
    }
    
    public Builder c(CornerSize param1CornerSize) {
      this.g = param1CornerSize;
      return this;
    }
    
    public Builder c(CornerTreatment param1CornerTreatment) {
      this.b = param1CornerTreatment;
      float f = f(param1CornerTreatment);
      if (f != -1.0F)
        c(f); 
      return this;
    }
    
    public Builder d(float param1Float) {
      this.g = new AbsoluteCornerSize(param1Float);
      return this;
    }
    
    public Builder d(int param1Int, CornerSize param1CornerSize) {
      return e(MaterialShapeUtils.a(param1Int)).d(param1CornerSize);
    }
    
    public Builder d(CornerSize param1CornerSize) {
      this.h = param1CornerSize;
      return this;
    }
    
    public Builder d(CornerTreatment param1CornerTreatment) {
      this.c = param1CornerTreatment;
      float f = f(param1CornerTreatment);
      if (f != -1.0F)
        d(f); 
      return this;
    }
    
    public Builder e(float param1Float) {
      this.h = new AbsoluteCornerSize(param1Float);
      return this;
    }
    
    public Builder e(CornerTreatment param1CornerTreatment) {
      this.d = param1CornerTreatment;
      float f = f(param1CornerTreatment);
      if (f != -1.0F)
        e(f); 
      return this;
    }
  }
  
  public static interface CornerSizeUnaryOperator {
    CornerSize a(CornerSize param1CornerSize);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\ShapeAppearanceModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */