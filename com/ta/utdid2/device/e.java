package com.ta.utdid2.device;

import com.ta.utdid2.a.a.a;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.g;

public class e {
  public String d(String paramString) {
    return a.b(paramString);
  }
  
  public String e(String paramString) {
    paramString = a.b(paramString);
    if (!g.a(paramString))
      try {
        return new String(b.decode(paramString, 0));
      } catch (IllegalArgumentException illegalArgumentException) {
        return null;
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\device\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */