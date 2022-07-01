package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation {
  private final List<BaseKeyframeAnimation<ShapeData, Path>> a;
  
  private final List<BaseKeyframeAnimation<Integer, Integer>> b;
  
  private final List<Mask> c;
  
  public MaskKeyframeAnimation(List<Mask> paramList) {
    this.c = paramList;
    this.a = new ArrayList<BaseKeyframeAnimation<ShapeData, Path>>(paramList.size());
    this.b = new ArrayList<BaseKeyframeAnimation<Integer, Integer>>(paramList.size());
    for (int i = 0; i < paramList.size(); i++) {
      this.a.add(((Mask)paramList.get(i)).b().a());
      AnimatableIntegerValue animatableIntegerValue = ((Mask)paramList.get(i)).c();
      this.b.add(animatableIntegerValue.a());
    } 
  }
  
  public List<Mask> a() {
    return this.c;
  }
  
  public List<BaseKeyframeAnimation<ShapeData, Path>> b() {
    return this.a;
  }
  
  public List<BaseKeyframeAnimation<Integer, Integer>> c() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\MaskKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */