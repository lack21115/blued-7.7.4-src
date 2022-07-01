package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
  private final Matrix a = new Matrix();
  
  private final Path b = new Path();
  
  private final RectF c = new RectF();
  
  private final String d;
  
  private final boolean e;
  
  private final List<Content> f;
  
  private final LottieDrawable g;
  
  private List<PathContent> h;
  
  private TransformKeyframeAnimation i;
  
  public ContentGroup(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeGroup paramShapeGroup) {
    this(paramLottieDrawable, paramBaseLayer, paramShapeGroup.a(), paramShapeGroup.c(), a(paramLottieDrawable, paramBaseLayer, paramShapeGroup.b()), a(paramShapeGroup.b()));
  }
  
  ContentGroup(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, String paramString, boolean paramBoolean, List<Content> paramList, AnimatableTransform paramAnimatableTransform) {
    this.d = paramString;
    this.g = paramLottieDrawable;
    this.e = paramBoolean;
    this.f = paramList;
    if (paramAnimatableTransform != null) {
      this.i = paramAnimatableTransform.j();
      this.i.a(paramBaseLayer);
      this.i.a(this);
    } 
    ArrayList<GreedyContent> arrayList = new ArrayList();
    int i;
    for (i = paramList.size() - 1; i >= 0; i--) {
      Content content = paramList.get(i);
      if (content instanceof GreedyContent)
        arrayList.add((GreedyContent)content); 
    } 
    for (i = arrayList.size() - 1; i >= 0; i--)
      ((GreedyContent)arrayList.get(i)).a(paramList.listIterator(paramList.size())); 
  }
  
  static AnimatableTransform a(List<ContentModel> paramList) {
    for (int i = 0; i < paramList.size(); i++) {
      ContentModel contentModel = paramList.get(i);
      if (contentModel instanceof AnimatableTransform)
        return (AnimatableTransform)contentModel; 
    } 
    return null;
  }
  
  private static List<Content> a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, List<ContentModel> paramList) {
    ArrayList<Content> arrayList = new ArrayList(paramList.size());
    for (int i = 0; i < paramList.size(); i++) {
      Content content = ((ContentModel)paramList.get(i)).a(paramLottieDrawable, paramBaseLayer);
      if (content != null)
        arrayList.add(content); 
    } 
    return arrayList;
  }
  
  public void a() {
    this.g.invalidateSelf();
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    if (this.e)
      return; 
    this.a.set(paramMatrix);
    TransformKeyframeAnimation transformKeyframeAnimation = this.i;
    int i = paramInt;
    if (transformKeyframeAnimation != null) {
      this.a.preConcat(transformKeyframeAnimation.d());
      if (this.i.a() == null) {
        i = 100;
      } else {
        i = ((Integer)this.i.a().g()).intValue();
      } 
      i = (int)(i / 100.0F * paramInt / 255.0F * 255.0F);
    } 
    for (paramInt = this.f.size() - 1; paramInt >= 0; paramInt--) {
      transformKeyframeAnimation = (TransformKeyframeAnimation)this.f.get(paramInt);
      if (transformKeyframeAnimation instanceof DrawingContent)
        ((DrawingContent)transformKeyframeAnimation).a(paramCanvas, this.a, i); 
    } 
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    this.a.set(paramMatrix);
    TransformKeyframeAnimation transformKeyframeAnimation = this.i;
    if (transformKeyframeAnimation != null)
      this.a.preConcat(transformKeyframeAnimation.d()); 
    this.c.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i;
    for (i = this.f.size() - 1; i >= 0; i--) {
      Content content = this.f.get(i);
      if (content instanceof DrawingContent) {
        ((DrawingContent)content).a(this.c, this.a, paramBoolean);
        paramRectF.union(this.c);
      } 
    } 
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    if (!paramKeyPath1.a(b(), paramInt))
      return; 
    KeyPath keyPath = paramKeyPath2;
    if (!"__container".equals(b())) {
      paramKeyPath2 = paramKeyPath2.a(b());
      keyPath = paramKeyPath2;
      if (paramKeyPath1.c(b(), paramInt)) {
        paramList.add(paramKeyPath2.a(this));
        keyPath = paramKeyPath2;
      } 
    } 
    if (paramKeyPath1.d(b(), paramInt)) {
      int j = paramKeyPath1.b(b(), paramInt);
      int i;
      for (i = 0; i < this.f.size(); i++) {
        Content content = this.f.get(i);
        if (content instanceof KeyPathElement)
          ((KeyPathElement)content).a(paramKeyPath1, paramInt + j, paramList, keyPath); 
      } 
    } 
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    TransformKeyframeAnimation transformKeyframeAnimation = this.i;
    if (transformKeyframeAnimation != null)
      transformKeyframeAnimation.a(paramT, paramLottieValueCallback); 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    paramList2 = new ArrayList<Content>(paramList1.size() + this.f.size());
    paramList2.addAll(paramList1);
    for (int i = this.f.size() - 1; i >= 0; i--) {
      Content content = this.f.get(i);
      content.a(paramList2, this.f.subList(0, i));
      paramList2.add(content);
    } 
  }
  
  public String b() {
    return this.d;
  }
  
  List<PathContent> c() {
    if (this.h == null) {
      this.h = new ArrayList<PathContent>();
      for (int i = 0; i < this.f.size(); i++) {
        Content content = this.f.get(i);
        if (content instanceof PathContent)
          this.h.add((PathContent)content); 
      } 
    } 
    return this.h;
  }
  
  Matrix d() {
    TransformKeyframeAnimation transformKeyframeAnimation = this.i;
    if (transformKeyframeAnimation != null)
      return transformKeyframeAnimation.d(); 
    this.a.reset();
    return this.a;
  }
  
  public Path e() {
    this.a.reset();
    TransformKeyframeAnimation transformKeyframeAnimation = this.i;
    if (transformKeyframeAnimation != null)
      this.a.set(transformKeyframeAnimation.d()); 
    this.b.reset();
    if (this.e)
      return this.b; 
    for (int i = this.f.size() - 1; i >= 0; i--) {
      Content content = this.f.get(i);
      if (content instanceof PathContent)
        this.b.addPath(((PathContent)content).e(), this.a); 
    } 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\ContentGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */