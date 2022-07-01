package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

public class Layer {
  private final List<ContentModel> a;
  
  private final LottieComposition b;
  
  private final String c;
  
  private final long d;
  
  private final LayerType e;
  
  private final long f;
  
  private final String g;
  
  private final List<Mask> h;
  
  private final AnimatableTransform i;
  
  private final int j;
  
  private final int k;
  
  private final int l;
  
  private final float m;
  
  private final float n;
  
  private final int o;
  
  private final int p;
  
  private final AnimatableTextFrame q;
  
  private final AnimatableTextProperties r;
  
  private final AnimatableFloatValue s;
  
  private final List<Keyframe<Float>> t;
  
  private final MatteType u;
  
  private final boolean v;
  
  public Layer(List<ContentModel> paramList, LottieComposition paramLottieComposition, String paramString1, long paramLong1, LayerType paramLayerType, long paramLong2, String paramString2, List<Mask> paramList1, AnimatableTransform paramAnimatableTransform, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, AnimatableTextFrame paramAnimatableTextFrame, AnimatableTextProperties paramAnimatableTextProperties, List<Keyframe<Float>> paramList2, MatteType paramMatteType, AnimatableFloatValue paramAnimatableFloatValue, boolean paramBoolean) {
    this.a = paramList;
    this.b = paramLottieComposition;
    this.c = paramString1;
    this.d = paramLong1;
    this.e = paramLayerType;
    this.f = paramLong2;
    this.g = paramString2;
    this.h = paramList1;
    this.i = paramAnimatableTransform;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramFloat1;
    this.n = paramFloat2;
    this.o = paramInt4;
    this.p = paramInt5;
    this.q = paramAnimatableTextFrame;
    this.r = paramAnimatableTextProperties;
    this.t = paramList2;
    this.u = paramMatteType;
    this.s = paramAnimatableFloatValue;
    this.v = paramBoolean;
  }
  
  LottieComposition a() {
    return this.b;
  }
  
  public String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(f());
    stringBuilder.append("\n");
    Layer layer = this.b.a(m());
    if (layer != null) {
      stringBuilder.append("\t\tParents: ");
      stringBuilder.append(layer.f());
      for (layer = this.b.a(layer.m()); layer != null; layer = this.b.a(layer.m())) {
        stringBuilder.append("->");
        stringBuilder.append(layer.f());
      } 
      stringBuilder.append(paramString);
      stringBuilder.append("\n");
    } 
    if (!j().isEmpty()) {
      stringBuilder.append(paramString);
      stringBuilder.append("\tMasks: ");
      stringBuilder.append(j().size());
      stringBuilder.append("\n");
    } 
    if (r() != 0 && q() != 0) {
      stringBuilder.append(paramString);
      stringBuilder.append("\tBackground: ");
      stringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p()) }));
    } 
    if (!this.a.isEmpty()) {
      stringBuilder.append(paramString);
      stringBuilder.append("\tShapes:\n");
      for (ContentModel contentModel : this.a) {
        stringBuilder.append(paramString);
        stringBuilder.append("\t\t");
        stringBuilder.append(contentModel);
        stringBuilder.append("\n");
      } 
    } 
    return stringBuilder.toString();
  }
  
  float b() {
    return this.m;
  }
  
  float c() {
    return this.n / this.b.m();
  }
  
  List<Keyframe<Float>> d() {
    return this.t;
  }
  
  public long e() {
    return this.d;
  }
  
  String f() {
    return this.c;
  }
  
  String g() {
    return this.g;
  }
  
  int h() {
    return this.o;
  }
  
  int i() {
    return this.p;
  }
  
  List<Mask> j() {
    return this.h;
  }
  
  public LayerType k() {
    return this.e;
  }
  
  MatteType l() {
    return this.u;
  }
  
  long m() {
    return this.f;
  }
  
  List<ContentModel> n() {
    return this.a;
  }
  
  AnimatableTransform o() {
    return this.i;
  }
  
  int p() {
    return this.l;
  }
  
  int q() {
    return this.k;
  }
  
  int r() {
    return this.j;
  }
  
  AnimatableTextFrame s() {
    return this.q;
  }
  
  AnimatableTextProperties t() {
    return this.r;
  }
  
  public String toString() {
    return a("");
  }
  
  AnimatableFloatValue u() {
    return this.s;
  }
  
  public boolean v() {
    return this.v;
  }
  
  public enum LayerType {
    a, b, c, d, e, f, g;
  }
  
  public enum MatteType {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\Layer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */