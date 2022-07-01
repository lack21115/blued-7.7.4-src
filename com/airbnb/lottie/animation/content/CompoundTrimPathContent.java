package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent {
  private List<TrimPathContent> a = new ArrayList<TrimPathContent>();
  
  public void a(Path paramPath) {
    for (int i = this.a.size() - 1; i >= 0; i--)
      Utils.a(paramPath, this.a.get(i)); 
  }
  
  void a(TrimPathContent paramTrimPathContent) {
    this.a.add(paramTrimPathContent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\CompoundTrimPathContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */