package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

public class TextDelegate {
  private final Map<String, String> a = new HashMap<String, String>();
  
  private final LottieAnimationView b = null;
  
  private final LottieDrawable c = null;
  
  private boolean d = true;
  
  private String b(String paramString) {
    return paramString;
  }
  
  public final String a(String paramString) {
    if (this.d && this.a.containsKey(paramString))
      return this.a.get(paramString); 
    String str = b(paramString);
    if (this.d)
      this.a.put(paramString, str); 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\TextDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */