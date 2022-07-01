package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import java.util.Set;

public class b {
  private a a;
  
  private Set<String> c;
  
  public boolean b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    boolean bool = this.c.contains(paramString);
    return (this.a == a.b) ? bool : (bool ^ true);
  }
  
  enum a {
    b, c;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */