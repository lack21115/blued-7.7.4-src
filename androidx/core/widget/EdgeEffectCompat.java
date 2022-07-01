package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {
  private EdgeEffect a;
  
  @Deprecated
  public EdgeEffectCompat(Context paramContext) {
    this.a = new EdgeEffect(paramContext);
  }
  
  public static void onPull(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      return;
    } 
    paramEdgeEffect.onPull(paramFloat1);
  }
  
  @Deprecated
  public boolean draw(Canvas paramCanvas) {
    return this.a.draw(paramCanvas);
  }
  
  @Deprecated
  public void finish() {
    this.a.finish();
  }
  
  @Deprecated
  public boolean isFinished() {
    return this.a.isFinished();
  }
  
  @Deprecated
  public boolean onAbsorb(int paramInt) {
    this.a.onAbsorb(paramInt);
    return true;
  }
  
  @Deprecated
  public boolean onPull(float paramFloat) {
    this.a.onPull(paramFloat);
    return true;
  }
  
  @Deprecated
  public boolean onPull(float paramFloat1, float paramFloat2) {
    onPull(this.a, paramFloat1, paramFloat2);
    return true;
  }
  
  @Deprecated
  public boolean onRelease() {
    this.a.onRelease();
    return this.a.isFinished();
  }
  
  @Deprecated
  public void setSize(int paramInt1, int paramInt2) {
    this.a.setSize(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\EdgeEffectCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */