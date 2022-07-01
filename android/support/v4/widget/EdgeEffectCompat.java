package android.support.v4.widget;

import android.os.Build;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {
  private static final EdgeEffectCompat$EdgeEffectBaseImpl IMPL = new EdgeEffectCompat$EdgeEffectBaseImpl();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void onPull(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2) {
    IMPL.onPull(paramEdgeEffect, paramFloat1, paramFloat2);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new EdgeEffectCompat$EdgeEffectApi21Impl();
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\EdgeEffectCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */