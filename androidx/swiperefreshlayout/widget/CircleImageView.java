package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

class CircleImageView extends ImageView {
  int a;
  
  private Animation.AnimationListener b;
  
  CircleImageView(Context paramContext, int paramInt) {
    super(paramContext);
    ShapeDrawable shapeDrawable;
    float f = (getContext().getResources().getDisplayMetrics()).density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.a = (int)(3.5F * f);
    if (a()) {
      shapeDrawable = new ShapeDrawable((Shape)new OvalShape());
      ViewCompat.setElevation((View)this, f * 4.0F);
    } else {
      shapeDrawable = new ShapeDrawable((Shape)new OvalShadow(this, this.a));
      setLayerType(1, shapeDrawable.getPaint());
      shapeDrawable.getPaint().setShadowLayer(this.a, j, i, 503316480);
      i = this.a;
      setPadding(i, i, i, i);
    } 
    shapeDrawable.getPaint().setColor(paramInt);
    ViewCompat.setBackground((View)this, (Drawable)shapeDrawable);
  }
  
  private boolean a() {
    return (Build.VERSION.SDK_INT >= 21);
  }
  
  public void onAnimationEnd() {
    super.onAnimationEnd();
    Animation.AnimationListener animationListener = this.b;
    if (animationListener != null)
      animationListener.onAnimationEnd(getAnimation()); 
  }
  
  public void onAnimationStart() {
    super.onAnimationStart();
    Animation.AnimationListener animationListener = this.b;
    if (animationListener != null)
      animationListener.onAnimationStart(getAnimation()); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (!a())
      setMeasuredDimension(getMeasuredWidth() + this.a * 2, getMeasuredHeight() + this.a * 2); 
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener) {
    this.b = paramAnimationListener;
  }
  
  public void setBackgroundColor(int paramInt) {
    if (getBackground() instanceof ShapeDrawable)
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt); 
  }
  
  public void setBackgroundColorRes(int paramInt) {
    setBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  class OvalShadow extends OvalShape {
    private RadialGradient b;
    
    private Paint c = new Paint();
    
    OvalShadow(CircleImageView this$0, int param1Int) {
      this$0.a = param1Int;
      a((int)rect().width());
    }
    
    private void a(int param1Int) {
      float f1 = (param1Int / 2);
      float f2 = this.a.a;
      Shader.TileMode tileMode = Shader.TileMode.CLAMP;
      this.b = new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, tileMode);
      this.c.setShader((Shader)this.b);
    }
    
    public void draw(Canvas param1Canvas, Paint param1Paint) {
      int j = this.a.getWidth();
      int i = this.a.getHeight();
      j /= 2;
      float f1 = j;
      float f2 = (i / 2);
      param1Canvas.drawCircle(f1, f2, f1, this.c);
      param1Canvas.drawCircle(f1, f2, (j - this.a.a), param1Paint);
    }
    
    protected void onResize(float param1Float1, float param1Float2) {
      super.onResize(param1Float1, param1Float2);
      a((int)param1Float1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\swiperefreshlayout\widget\CircleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */