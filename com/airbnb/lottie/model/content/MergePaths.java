package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

public class MergePaths implements ContentModel {
  private final String a;
  
  private final MergePathsMode b;
  
  private final boolean c;
  
  public MergePaths(String paramString, MergePathsMode paramMergePathsMode, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramMergePathsMode;
    this.c = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    if (!paramLottieDrawable.a()) {
      Logger.b("Animation contains merge paths but they are disabled.");
      return null;
    } 
    return (Content)new MergePathsContent(this);
  }
  
  public String a() {
    return this.a;
  }
  
  public MergePathsMode b() {
    return this.b;
  }
  
  public boolean c() {
    return this.c;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MergePaths{mode=");
    stringBuilder.append(this.b);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public enum MergePathsMode {
    a, b, c, d, e;
    
    public static MergePathsMode a(int param1Int) {
      return (param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? a : e) : d) : c) : b) : a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\MergePaths.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */