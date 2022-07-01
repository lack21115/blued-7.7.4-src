package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;

public class c extends Drawable {
  private int a;
  
  private int b;
  
  private int[] c;
  
  private float[] d;
  
  private LinearGradient e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private RectF j;
  
  private Paint k;
  
  public c(int paramInt1, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt2, LinearGradient paramLinearGradient, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    this.a = paramInt1;
    this.c = paramArrayOfint;
    this.d = paramArrayOffloat;
    this.b = paramInt2;
    this.e = paramLinearGradient;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
    this.i = paramInt6;
  }
  
  private void a() {
    this.k = new Paint();
    Paint paint = this.k;
    boolean bool = true;
    paint.setAntiAlias(true);
    this.k.setShadowLayer(this.g, this.h, this.i, this.b);
    if (this.j != null) {
      int[] arrayOfInt = this.c;
      if (arrayOfInt != null && arrayOfInt.length > 1) {
        float[] arrayOfFloat = this.d;
        if (arrayOfFloat == null || arrayOfFloat.length <= 0 || arrayOfFloat.length != arrayOfInt.length)
          bool = false; 
        Paint paint1 = this.k;
        LinearGradient linearGradient2 = this.e;
        LinearGradient linearGradient1 = linearGradient2;
        if (linearGradient2 == null) {
          float f1 = this.j.left;
          float f2 = this.j.right;
          int[] arrayOfInt1 = this.c;
          if (bool) {
            float[] arrayOfFloat1 = this.d;
          } else {
            linearGradient1 = null;
          } 
          linearGradient1 = new LinearGradient(f1, 0.0F, f2, 0.0F, arrayOfInt1, (float[])linearGradient1, Shader.TileMode.CLAMP);
        } 
        paint1.setShader((Shader)linearGradient1);
        return;
      } 
    } 
    this.k.setColor(this.a);
  }
  
  public static void a(View paramView, a parama) {
    if (paramView != null) {
      if (parama == null)
        return; 
      paramView.setLayerType(1, null);
      ViewCompat.setBackground(paramView, parama.a());
    } 
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.j == null) {
      Rect rect = getBounds();
      this.j = new RectF((rect.left + this.g - this.h), (rect.top + this.g - this.i), (rect.right - this.g - this.h), (rect.bottom - this.g - this.i));
    } 
    if (this.k == null)
      a(); 
    RectF rectF = this.j;
    int i = this.f;
    paramCanvas.drawRoundRect(rectF, i, i, this.k);
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public void setAlpha(int paramInt) {
    Paint paint = this.k;
    if (paint != null)
      paint.setAlpha(paramInt); 
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    Paint paint = this.k;
    if (paint != null)
      paint.setColorFilter(paramColorFilter); 
  }
  
  public static class a {
    private int a = ab.j(o.a(), "tt_ssxinmian8");
    
    private int b = ab.j(o.a(), "tt_ssxinxian3");
    
    private int[] c;
    
    private float[] d;
    
    private LinearGradient e;
    
    private int f = 10;
    
    private int g = 16;
    
    private int h = 0;
    
    private int i = 0;
    
    public a() {
      this.h = 0;
      this.i = 0;
    }
    
    public a a(int param1Int) {
      this.a = param1Int;
      return this;
    }
    
    public a a(int[] param1ArrayOfint) {
      this.c = param1ArrayOfint;
      return this;
    }
    
    public c a() {
      return new c(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i);
    }
    
    public a b(int param1Int) {
      this.b = param1Int;
      return this;
    }
    
    public a c(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    public a d(int param1Int) {
      this.h = param1Int;
      return this;
    }
    
    public a e(int param1Int) {
      this.i = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */