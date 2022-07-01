package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Platform {
  private static final Logger a = Logger.getLogger(Platform.class.getName());
  
  private static final PatternCompiler b = b();
  
  static long a() {
    return System.nanoTime();
  }
  
  static String a(double paramDouble) {
    return String.format(Locale.ROOT, "%.4g", new Object[] { Double.valueOf(paramDouble) });
  }
  
  static boolean a(@NullableDecl String paramString) {
    return (paramString == null || paramString.isEmpty());
  }
  
  private static PatternCompiler b() {
    return new JdkPatternCompiler();
  }
  
  static String b(@NullableDecl String paramString) {
    String str = paramString;
    if (a(paramString))
      str = null; 
    return str;
  }
  
  static CommonPattern c(String paramString) {
    Preconditions.a(paramString);
    return b.a(paramString);
  }
  
  static final class JdkPatternCompiler implements PatternCompiler {
    private JdkPatternCompiler() {}
    
    public CommonPattern a(String param1String) {
      return new JdkPattern(Pattern.compile(param1String));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */