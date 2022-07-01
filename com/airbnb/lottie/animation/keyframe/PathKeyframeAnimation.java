package com.airbnb.lottie.animation.keyframe;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
  private final PointF c = new PointF();
  
  private final float[] d = new float[2];
  
  private PathKeyframe e;
  
  private PathMeasure f = new PathMeasure();
  
  public PathKeyframeAnimation(List<? extends Keyframe<PointF>> paramList) {
    super(paramList);
  }
  
  public PointF b(Keyframe<PointF> paramKeyframe, float paramFloat) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/airbnb/lottie/animation/keyframe/PathKeyframe
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual b : ()Landroid/graphics/Path;
    //   9: astore #4
    //   11: aload #4
    //   13: ifnonnull -> 24
    //   16: aload_1
    //   17: getfield a : Ljava/lang/Object;
    //   20: checkcast android/graphics/PointF
    //   23: areturn
    //   24: aload_0
    //   25: getfield b : Lcom/airbnb/lottie/value/LottieValueCallback;
    //   28: ifnull -> 76
    //   31: aload_0
    //   32: getfield b : Lcom/airbnb/lottie/value/LottieValueCallback;
    //   35: aload_3
    //   36: getfield d : F
    //   39: aload_3
    //   40: getfield e : Ljava/lang/Float;
    //   43: invokevirtual floatValue : ()F
    //   46: aload_3
    //   47: getfield a : Ljava/lang/Object;
    //   50: aload_3
    //   51: getfield b : Ljava/lang/Object;
    //   54: aload_0
    //   55: invokevirtual d : ()F
    //   58: fload_2
    //   59: aload_0
    //   60: invokevirtual h : ()F
    //   63: invokevirtual a : (FFLjava/lang/Object;Ljava/lang/Object;FFF)Ljava/lang/Object;
    //   66: checkcast android/graphics/PointF
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull -> 76
    //   74: aload_1
    //   75: areturn
    //   76: aload_0
    //   77: getfield e : Lcom/airbnb/lottie/animation/keyframe/PathKeyframe;
    //   80: aload_3
    //   81: if_acmpeq -> 99
    //   84: aload_0
    //   85: getfield f : Landroid/graphics/PathMeasure;
    //   88: aload #4
    //   90: iconst_0
    //   91: invokevirtual setPath : (Landroid/graphics/Path;Z)V
    //   94: aload_0
    //   95: aload_3
    //   96: putfield e : Lcom/airbnb/lottie/animation/keyframe/PathKeyframe;
    //   99: aload_0
    //   100: getfield f : Landroid/graphics/PathMeasure;
    //   103: astore_1
    //   104: aload_1
    //   105: fload_2
    //   106: aload_1
    //   107: invokevirtual getLength : ()F
    //   110: fmul
    //   111: aload_0
    //   112: getfield d : [F
    //   115: aconst_null
    //   116: invokevirtual getPosTan : (F[F[F)Z
    //   119: pop
    //   120: aload_0
    //   121: getfield c : Landroid/graphics/PointF;
    //   124: astore_1
    //   125: aload_0
    //   126: getfield d : [F
    //   129: astore_3
    //   130: aload_1
    //   131: aload_3
    //   132: iconst_0
    //   133: faload
    //   134: aload_3
    //   135: iconst_1
    //   136: faload
    //   137: invokevirtual set : (FF)V
    //   140: aload_0
    //   141: getfield c : Landroid/graphics/PointF;
    //   144: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\PathKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */