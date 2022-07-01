package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup implements ContentModel {
  private final String a;
  
  private final List<ContentModel> b;
  
  private final boolean c;
  
  public ShapeGroup(String paramString, List<ContentModel> paramList, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new ContentGroup(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public List<ContentModel> b() {
    return this.b;
  }
  
  public boolean c() {
    return this.c;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ShapeGroup{name='");
    stringBuilder.append(this.a);
    stringBuilder.append("' Shapes: ");
    stringBuilder.append(Arrays.toString(this.b.toArray()));
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\ShapeGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */