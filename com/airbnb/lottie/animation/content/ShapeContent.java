package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
  private final Path a = new Path();
  
  private final String b;
  
  private final boolean c;
  
  private final LottieDrawable d;
  
  private final BaseKeyframeAnimation<?, Path> e;
  
  private boolean f;
  
  private CompoundTrimPathContent g = new CompoundTrimPathContent();
  
  public ShapeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapePath paramShapePath) {
    this.b = paramShapePath.a();
    this.c = paramShapePath.c();
    this.d = paramLottieDrawable;
    this.e = paramShapePath.b().a();
    paramBaseLayer.a(this.e);
    this.e.a(this);
  }
  
  private void c() {
    this.f = false;
    this.d.invalidateSelf();
  }
  
  public void a() {
    c();
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    for (int i = 0; i < paramList1.size(); i++) {
      Content content = paramList1.get(i);
      if (content instanceof TrimPathContent) {
        content = content;
        if (content.c() == ShapeTrimPath.Type.a) {
          this.g.a((TrimPathContent)content);
          content.a(this);
        } 
      } 
    } 
  }
  
  public String b() {
    return this.b;
  }
  
  public Path e() {
    if (this.f)
      return this.a; 
    this.a.reset();
    if (this.c) {
      this.f = true;
      return this.a;
    } 
    this.a.set((Path)this.e.g());
    this.a.setFillType(Path.FillType.EVEN_ODD);
    this.g.a(this.a);
    this.f = true;
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\ShapeContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */