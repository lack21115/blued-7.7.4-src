package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public interface Animatable2Compat extends Animatable {
  void clearAnimationCallbacks();
  
  void registerAnimationCallback(AnimationCallback paramAnimationCallback);
  
  boolean unregisterAnimationCallback(AnimationCallback paramAnimationCallback);
  
  public static abstract class AnimationCallback {
    Animatable2.AnimationCallback a;
    
    Animatable2.AnimationCallback a() {
      if (this.a == null)
        this.a = new Animatable2.AnimationCallback(this) {
            public void onAnimationEnd(Drawable param2Drawable) {
              this.a.onAnimationEnd(param2Drawable);
            }
            
            public void onAnimationStart(Drawable param2Drawable) {
              this.a.onAnimationStart(param2Drawable);
            }
          }; 
      return this.a;
    }
    
    public void onAnimationEnd(Drawable param1Drawable) {}
    
    public void onAnimationStart(Drawable param1Drawable) {}
  }
  
  class null extends Animatable2.AnimationCallback {
    null(Animatable2Compat this$0) {}
    
    public void onAnimationEnd(Drawable param1Drawable) {
      this.a.onAnimationEnd(param1Drawable);
    }
    
    public void onAnimationStart(Drawable param1Drawable) {
      this.a.onAnimationStart(param1Drawable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\vectordrawable\graphics\drawable\Animatable2Compat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */