package com.blued.android.framework.view.shape;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;

public class ShapeHelper {
  private static GradientDrawable a(int paramInt, ShapeModel paramShapeModel) {
    int i;
    int j;
    int k;
    int m;
    GradientDrawable gradientDrawable = new GradientDrawable();
    if (paramInt != 1) {
      if (paramInt != 2) {
        m = paramShapeModel.k;
        paramInt = paramShapeModel.n;
        i = paramShapeModel.t;
        j = paramShapeModel.u;
        k = paramShapeModel.v;
      } else {
        m = paramShapeModel.m;
        paramInt = paramShapeModel.p;
        i = paramShapeModel.z;
        j = paramShapeModel.A;
        k = paramShapeModel.B;
      } 
    } else {
      m = paramShapeModel.l;
      paramInt = paramShapeModel.o;
      i = paramShapeModel.w;
      j = paramShapeModel.x;
      k = paramShapeModel.y;
    } 
    int n = paramShapeModel.M;
    if (n != 0) {
      if (n != 1) {
        if (n != 2) {
          if (n == 3) {
            gradientDrawable.setStroke(0, 0, 0.0F, 0.0F);
            a(gradientDrawable, paramShapeModel, i, j, k);
          } 
        } else {
          gradientDrawable.setStroke(0, 0, 0.0F, 0.0F);
          gradientDrawable.setColor(m);
        } 
      } else {
        gradientDrawable.setStroke((int)paramShapeModel.q, paramInt, paramShapeModel.r, paramShapeModel.s);
        gradientDrawable.setColor(0);
      } 
    } else {
      gradientDrawable.setStroke((int)paramShapeModel.q, paramInt, paramShapeModel.r, paramShapeModel.s);
      gradientDrawable.setColor(m);
      a(gradientDrawable, paramShapeModel, i, j, k);
    } 
    if (paramShapeModel.N != 0)
      gradientDrawable.setShape(paramShapeModel.N); 
    if (paramShapeModel.N != 1) {
      if (paramShapeModel.H != 0.0F) {
        gradientDrawable.setCornerRadius(paramShapeModel.H);
        return gradientDrawable;
      } 
      gradientDrawable.setCornerRadii(new float[] { paramShapeModel.I, paramShapeModel.I, paramShapeModel.J, paramShapeModel.J, paramShapeModel.L, paramShapeModel.L, paramShapeModel.K, paramShapeModel.K });
    } 
    return gradientDrawable;
  }
  
  public static StateListDrawable a(ShapeModel paramShapeModel) {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Landroid/graphics/drawable/Drawable;
    //   4: astore_1
    //   5: aload_0
    //   6: getfield i : Landroid/graphics/drawable/Drawable;
    //   9: astore_3
    //   10: aload_0
    //   11: getfield j : Landroid/graphics/drawable/Drawable;
    //   14: astore #4
    //   16: aload_1
    //   17: astore_2
    //   18: aload_1
    //   19: ifnonnull -> 28
    //   22: iconst_0
    //   23: aload_0
    //   24: invokestatic a : (ILcom/blued/android/framework/view/shape/ShapeModel;)Landroid/graphics/drawable/GradientDrawable;
    //   27: astore_2
    //   28: aload_3
    //   29: astore_1
    //   30: aload_3
    //   31: ifnonnull -> 168
    //   34: aload_0
    //   35: getfield M : I
    //   38: ifne -> 62
    //   41: aload_0
    //   42: getfield l : I
    //   45: ifne -> 107
    //   48: aload_0
    //   49: getfield l : I
    //   52: ifne -> 107
    //   55: aload_0
    //   56: getfield w : I
    //   59: ifne -> 107
    //   62: aload_0
    //   63: getfield M : I
    //   66: iconst_2
    //   67: if_icmpne -> 77
    //   70: aload_0
    //   71: getfield l : I
    //   74: ifne -> 107
    //   77: aload_0
    //   78: getfield M : I
    //   81: iconst_1
    //   82: if_icmpne -> 92
    //   85: aload_0
    //   86: getfield o : I
    //   89: ifne -> 107
    //   92: aload_0
    //   93: getfield M : I
    //   96: iconst_3
    //   97: if_icmpne -> 116
    //   100: aload_0
    //   101: getfield w : I
    //   104: ifeq -> 116
    //   107: iconst_1
    //   108: aload_0
    //   109: invokestatic a : (ILcom/blued/android/framework/view/shape/ShapeModel;)Landroid/graphics/drawable/GradientDrawable;
    //   112: astore_1
    //   113: goto -> 168
    //   116: aload_3
    //   117: astore_1
    //   118: aload_0
    //   119: getfield a : Z
    //   122: ifeq -> 168
    //   125: aload_3
    //   126: astore_1
    //   127: aload_2
    //   128: ifnull -> 168
    //   131: aload_2
    //   132: invokevirtual getConstantState : ()Landroid/graphics/drawable/Drawable$ConstantState;
    //   135: astore #5
    //   137: aload_3
    //   138: astore_1
    //   139: aload #5
    //   141: ifnull -> 168
    //   144: aload #5
    //   146: invokevirtual newDrawable : ()Landroid/graphics/drawable/Drawable;
    //   149: invokestatic wrap : (Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   152: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   155: astore_1
    //   156: aload_1
    //   157: ldc '#d1d1d1'
    //   159: invokestatic parseColor : (Ljava/lang/String;)I
    //   162: getstatic android/graphics/PorterDuff$Mode.MULTIPLY : Landroid/graphics/PorterDuff$Mode;
    //   165: invokevirtual setColorFilter : (ILandroid/graphics/PorterDuff$Mode;)V
    //   168: aload #4
    //   170: astore_3
    //   171: aload #4
    //   173: ifnonnull -> 206
    //   176: aload_0
    //   177: getfield m : I
    //   180: ifne -> 200
    //   183: aload_0
    //   184: getfield p : I
    //   187: ifne -> 200
    //   190: aload #4
    //   192: astore_3
    //   193: aload_0
    //   194: getfield z : I
    //   197: ifeq -> 206
    //   200: iconst_2
    //   201: aload_0
    //   202: invokestatic a : (ILcom/blued/android/framework/view/shape/ShapeModel;)Landroid/graphics/drawable/GradientDrawable;
    //   205: astore_3
    //   206: new android/graphics/drawable/StateListDrawable
    //   209: dup
    //   210: invokespecial <init> : ()V
    //   213: astore_0
    //   214: aload_1
    //   215: ifnull -> 254
    //   218: aload_0
    //   219: iconst_2
    //   220: newarray int
    //   222: dup
    //   223: iconst_0
    //   224: ldc 16842908
    //   226: iastore
    //   227: dup
    //   228: iconst_1
    //   229: ldc 16842919
    //   231: iastore
    //   232: aload_1
    //   233: invokevirtual addState : ([ILandroid/graphics/drawable/Drawable;)V
    //   236: aload_0
    //   237: iconst_2
    //   238: newarray int
    //   240: dup
    //   241: iconst_0
    //   242: ldc -16842908
    //   244: iastore
    //   245: dup
    //   246: iconst_1
    //   247: ldc 16842919
    //   249: iastore
    //   250: aload_1
    //   251: invokevirtual addState : ([ILandroid/graphics/drawable/Drawable;)V
    //   254: aload_3
    //   255: ifnull -> 271
    //   258: aload_0
    //   259: iconst_1
    //   260: newarray int
    //   262: dup
    //   263: iconst_0
    //   264: ldc -16842910
    //   266: iastore
    //   267: aload_3
    //   268: invokevirtual addState : ([ILandroid/graphics/drawable/Drawable;)V
    //   271: aload_0
    //   272: iconst_0
    //   273: newarray int
    //   275: aload_2
    //   276: invokevirtual addState : ([ILandroid/graphics/drawable/Drawable;)V
    //   279: aload_0
    //   280: areturn
  }
  
  private static void a(GradientDrawable paramGradientDrawable, ShapeModel paramShapeModel, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 != 0) {
      if (Build.VERSION.SDK_INT > 15) {
        GradientDrawable.Orientation orientation;
        if (paramInt2 != 0) {
          paramGradientDrawable.setColors(new int[] { paramInt1, paramInt2, paramInt3 });
        } else {
          paramGradientDrawable.setColors(new int[] { paramInt1, paramInt3 });
        } 
        paramInt1 = paramShapeModel.C;
        if (paramInt1 != 45) {
          if (paramInt1 != 90) {
            if (paramInt1 != 135) {
              if (paramInt1 != 180) {
                if (paramInt1 != 225) {
                  if (paramInt1 != 270) {
                    if (paramInt1 != 315) {
                      orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                    } else {
                      orientation = GradientDrawable.Orientation.TL_BR;
                    } 
                  } else {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                  } 
                } else {
                  orientation = GradientDrawable.Orientation.TR_BL;
                } 
              } else {
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
              } 
            } else {
              orientation = GradientDrawable.Orientation.BR_TL;
            } 
          } else {
            orientation = GradientDrawable.Orientation.BOTTOM_TOP;
          } 
        } else {
          orientation = GradientDrawable.Orientation.BL_TR;
        } 
        paramGradientDrawable.setOrientation(orientation);
        paramGradientDrawable.setGradientType(paramShapeModel.D);
        if (paramShapeModel.D == 1)
          paramGradientDrawable.setGradientRadius(paramShapeModel.E); 
        paramGradientDrawable.setGradientCenter(paramShapeModel.F, paramShapeModel.G);
        return;
      } 
      paramGradientDrawable.setColor(paramInt1);
    } 
  }
  
  public static void a(ShapeView paramShapeView) {
    ShapeModel shapeModel = paramShapeView.getShapeModel();
    ((View)paramShapeView).setBackgroundDrawable((Drawable)a(shapeModel));
    if (paramShapeView instanceof androidx.appcompat.widget.AppCompatTextView || paramShapeView instanceof TextView) {
      if (shapeModel.e != 0) {
        ((TextView)paramShapeView).setTextColor(shapeModel.e);
        return;
      } 
      ((TextView)paramShapeView).setTextColor(b(shapeModel));
    } 
  }
  
  public static void a(ShapeView paramShapeView, float paramFloat) {
    ShapeModel shapeModel = b(paramShapeView);
    shapeModel.H = paramFloat;
    shapeModel.I = 0.0F;
    shapeModel.J = 0.0F;
    shapeModel.K = 0.0F;
    shapeModel.L = 0.0F;
    a(paramShapeView, shapeModel);
  }
  
  public static void a(ShapeView paramShapeView, float paramFloat1, float paramFloat2, float paramFloat3) {
    ShapeModel shapeModel = b(paramShapeView);
    shapeModel.q = paramFloat1;
    shapeModel.r = paramFloat2;
    shapeModel.s = paramFloat3;
    a(paramShapeView, shapeModel);
  }
  
  public static void a(ShapeView paramShapeView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    ShapeModel shapeModel = b(paramShapeView);
    shapeModel.H = 0.0F;
    shapeModel.I = paramFloat1;
    shapeModel.J = paramFloat2;
    shapeModel.K = paramFloat3;
    shapeModel.L = paramFloat4;
    a(paramShapeView, shapeModel);
  }
  
  public static void a(ShapeView paramShapeView, int paramInt) {
    a(paramShapeView, paramInt, paramInt, paramInt);
  }
  
  public static void a(ShapeView paramShapeView, int paramInt1, int paramInt2) {
    d(paramShapeView, paramInt1, 17170445, paramInt2);
  }
  
  public static void a(ShapeView paramShapeView, int paramInt1, int paramInt2, int paramInt3) {
    ShapeModel shapeModel = b(paramShapeView);
    shapeModel.P = paramInt1;
    shapeModel.Q = paramInt2;
    shapeModel.R = paramInt3;
    shapeModel.b = BluedSkinUtils.a(AppInfo.d(), paramInt1);
    shapeModel.c = BluedSkinUtils.a(AppInfo.d(), paramInt2);
    shapeModel.d = BluedSkinUtils.a(AppInfo.d(), paramInt3);
    shapeModel.e = 0;
    shapeModel.f = 0;
    a(paramShapeView, shapeModel);
  }
  
  public static void a(ShapeView paramShapeView, ShapeModel paramShapeModel) {
    paramShapeView.setShapeModel(paramShapeModel);
  }
  
  public static ColorStateList b(ShapeModel paramShapeModel) {
    int i = paramShapeModel.c;
    int j = paramShapeModel.c;
    int k = paramShapeModel.d;
    int m = paramShapeModel.b;
    int[] arrayOfInt1 = { 16842908, 16842919 };
    int[] arrayOfInt2 = { -16842910 };
    int[] arrayOfInt3 = new int[0];
    return new ColorStateList(new int[][] { arrayOfInt1, { -16842908, 16842919 }, , arrayOfInt2, arrayOfInt3 }, new int[] { i, j, k, m });
  }
  
  public static ShapeModel b(ShapeView paramShapeView) {
    return paramShapeView.getShapeModel();
  }
  
  public static void b(ShapeView paramShapeView, int paramInt) {
    b(paramShapeView, paramInt, paramInt, paramInt);
  }
  
  public static void b(ShapeView paramShapeView, int paramInt1, int paramInt2, int paramInt3) {
    ShapeModel shapeModel = b(paramShapeView);
    shapeModel.U = paramInt1;
    shapeModel.V = paramInt2;
    shapeModel.W = paramInt3;
    shapeModel.k = BluedSkinUtils.a(AppInfo.d(), paramInt1);
    shapeModel.l = BluedSkinUtils.a(AppInfo.d(), paramInt2);
    shapeModel.m = BluedSkinUtils.a(AppInfo.d(), paramInt3);
    a(paramShapeView, shapeModel);
  }
  
  public static void c(ShapeView paramShapeView, int paramInt) {
    ShapeModel shapeModel = b(paramShapeView);
    b(paramShapeView, shapeModel.U, paramInt, shapeModel.W);
  }
  
  public static void c(ShapeView paramShapeView, int paramInt1, int paramInt2, int paramInt3) {
    ShapeModel shapeModel = b(paramShapeView);
    shapeModel.X = paramInt1;
    shapeModel.Y = paramInt2;
    shapeModel.Z = paramInt3;
    shapeModel.n = BluedSkinUtils.a(AppInfo.d(), paramInt1);
    shapeModel.o = BluedSkinUtils.a(AppInfo.d(), paramInt2);
    shapeModel.p = BluedSkinUtils.a(AppInfo.d(), paramInt3);
    a(paramShapeView, shapeModel);
  }
  
  public static void d(ShapeView paramShapeView, int paramInt) {
    c(paramShapeView, paramInt, paramInt, paramInt);
  }
  
  public static void d(ShapeView paramShapeView, int paramInt1, int paramInt2, int paramInt3) {
    ShapeModel shapeModel = b(paramShapeView);
    shapeModel.aa = paramInt1;
    shapeModel.ad = paramInt1;
    shapeModel.ag = paramInt1;
    shapeModel.ab = paramInt2;
    shapeModel.ae = paramInt2;
    shapeModel.ah = paramInt2;
    shapeModel.ac = paramInt3;
    shapeModel.af = paramInt3;
    shapeModel.ai = paramInt3;
    shapeModel.t = BluedSkinUtils.a(AppInfo.d(), paramInt1);
    shapeModel.w = BluedSkinUtils.a(AppInfo.d(), paramInt1);
    shapeModel.z = BluedSkinUtils.a(AppInfo.d(), paramInt1);
    shapeModel.u = BluedSkinUtils.a(AppInfo.d(), paramInt2);
    shapeModel.x = BluedSkinUtils.a(AppInfo.d(), paramInt2);
    shapeModel.A = BluedSkinUtils.a(AppInfo.d(), paramInt2);
    shapeModel.v = BluedSkinUtils.a(AppInfo.d(), paramInt3);
    shapeModel.y = BluedSkinUtils.a(AppInfo.d(), paramInt3);
    shapeModel.B = BluedSkinUtils.a(AppInfo.d(), paramInt3);
    a(paramShapeView, shapeModel);
  }
  
  public static interface BG_MODEL {}
  
  public static interface BG_STATE {}
  
  public static interface ShapeView {
    ShapeModel getShapeModel();
    
    void setShapeModel(ShapeModel param1ShapeModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\shape\ShapeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */