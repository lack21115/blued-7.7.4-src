package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class CompositionLayer extends BaseLayer {
  private BaseKeyframeAnimation<Float, Float> e;
  
  private final List<BaseLayer> f;
  
  private final RectF g;
  
  private final RectF h;
  
  public CompositionLayer(LottieDrawable paramLottieDrawable, Layer paramLayer, List<Layer> paramList, LottieComposition paramLottieComposition) {
    super(paramLottieDrawable, paramLayer);
    int j;
    this.f = new ArrayList<BaseLayer>();
    this.g = new RectF();
    this.h = new RectF();
    AnimatableFloatValue animatableFloatValue = paramLayer.u();
    if (animatableFloatValue != null) {
      this.e = animatableFloatValue.a();
      a(this.e);
      this.e.a(this);
    } else {
      this.e = null;
    } 
    LongSparseArray longSparseArray = new LongSparseArray(paramLottieComposition.i().size());
    int i = paramList.size() - 1;
    animatableFloatValue = null;
    while (true) {
      j = 0;
      if (i >= 0) {
        Layer layer = paramList.get(i);
        BaseLayer baseLayer = BaseLayer.a(layer, paramLottieDrawable, paramLottieComposition);
        if (baseLayer != null) {
          longSparseArray.put(baseLayer.c().e(), baseLayer);
          if (animatableFloatValue != null) {
            animatableFloatValue.a(baseLayer);
            animatableFloatValue = null;
          } else {
            this.f.add(0, baseLayer);
            j = null.a[layer.l().ordinal()];
            if (j == 1 || j == 2)
              BaseLayer baseLayer1 = baseLayer; 
          } 
        } 
        i--;
        continue;
      } 
      break;
    } 
    while (j < longSparseArray.size()) {
      BaseLayer baseLayer = (BaseLayer)longSparseArray.get(longSparseArray.keyAt(j));
      if (baseLayer != null) {
        BaseLayer baseLayer1 = (BaseLayer)longSparseArray.get(baseLayer.c().m());
        if (baseLayer1 != null)
          baseLayer.b(baseLayer1); 
      } 
      j++;
    } 
  }
  
  public void a(float paramFloat) {
    super.a(paramFloat);
    if (this.e != null) {
      paramFloat = this.b.r().e();
      paramFloat = (float)(long)(((Float)this.e.g()).floatValue() * 1000.0F) / paramFloat;
    } 
    float f = paramFloat;
    if (this.c.b() != 0.0F)
      f = paramFloat / this.c.b(); 
    paramFloat = this.c.c();
    for (int i = this.f.size() - 1; i >= 0; i--)
      ((BaseLayer)this.f.get(i)).a(f - paramFloat); 
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    super.a(paramRectF, paramMatrix, paramBoolean);
    int i;
    for (i = this.f.size() - 1; i >= 0; i--) {
      this.g.set(0.0F, 0.0F, 0.0F, 0.0F);
      ((BaseLayer)this.f.get(i)).a(this.g, this.a, true);
      paramRectF.union(this.g);
    } 
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    super.a(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.A) {
      if (paramLottieValueCallback == null) {
        this.e = null;
        return;
      } 
      this.e = (BaseKeyframeAnimation<Float, Float>)new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      a(this.e);
    } 
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    L.a("CompositionLayer#draw");
    paramCanvas.save();
    this.h.set(0.0F, 0.0F, this.c.h(), this.c.i());
    paramMatrix.mapRect(this.h);
    int i;
    for (i = this.f.size() - 1; i >= 0; i--) {
      boolean bool;
      if (!this.h.isEmpty()) {
        bool = paramCanvas.clipRect(this.h);
      } else {
        bool = true;
      } 
      if (bool)
        ((BaseLayer)this.f.get(i)).a(paramCanvas, paramMatrix, paramInt); 
    } 
    paramCanvas.restore();
    L.b("CompositionLayer#draw");
  }
  
  protected void b(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    int i;
    for (i = 0; i < this.f.size(); i++)
      ((BaseLayer)this.f.get(i)).a(paramKeyPath1, paramInt, paramList, paramKeyPath2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\CompositionLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */