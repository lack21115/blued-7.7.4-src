package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
  private final String a;
  
  private final boolean b;
  
  private final List<BaseKeyframeAnimation.AnimationListener> c = new ArrayList<BaseKeyframeAnimation.AnimationListener>();
  
  private final ShapeTrimPath.Type d;
  
  private final BaseKeyframeAnimation<?, Float> e;
  
  private final BaseKeyframeAnimation<?, Float> f;
  
  private final BaseKeyframeAnimation<?, Float> g;
  
  public TrimPathContent(BaseLayer paramBaseLayer, ShapeTrimPath paramShapeTrimPath) {
    this.a = paramShapeTrimPath.a();
    this.b = paramShapeTrimPath.f();
    this.d = paramShapeTrimPath.b();
    this.e = paramShapeTrimPath.d().a();
    this.f = paramShapeTrimPath.c().a();
    this.g = paramShapeTrimPath.e().a();
    paramBaseLayer.a(this.e);
    paramBaseLayer.a(this.f);
    paramBaseLayer.a(this.g);
    this.e.a(this);
    this.f.a(this);
    this.g.a(this);
  }
  
  public void a() {
    for (int i = 0; i < this.c.size(); i++)
      ((BaseKeyframeAnimation.AnimationListener)this.c.get(i)).a(); 
  }
  
  void a(BaseKeyframeAnimation.AnimationListener paramAnimationListener) {
    this.c.add(paramAnimationListener);
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {}
  
  public String b() {
    return this.a;
  }
  
  ShapeTrimPath.Type c() {
    return this.d;
  }
  
  public BaseKeyframeAnimation<?, Float> d() {
    return this.e;
  }
  
  public BaseKeyframeAnimation<?, Float> e() {
    return this.f;
  }
  
  public BaseKeyframeAnimation<?, Float> f() {
    return this.g;
  }
  
  public boolean g() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\TrimPathContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */