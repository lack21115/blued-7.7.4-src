package com.google.common.escape;

import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
public abstract class Escaper {
  private final Function<String, String> a = new Function<String, String>(this) {
      public String a(String param1String) {
        return this.a.a(param1String);
      }
    };
  
  public abstract String a(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\Escaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */