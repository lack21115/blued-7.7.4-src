package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class JdkPattern extends CommonPattern implements Serializable {
  private final Pattern a;
  
  JdkPattern(Pattern paramPattern) {
    this.a = Preconditions.<Pattern>a(paramPattern);
  }
  
  public CommonMatcher a(CharSequence paramCharSequence) {
    return new JdkMatcher(this.a.matcher(paramCharSequence));
  }
  
  public String a() {
    return this.a.pattern();
  }
  
  public int b() {
    return this.a.flags();
  }
  
  public String toString() {
    return this.a.toString();
  }
  
  static final class JdkMatcher extends CommonMatcher {
    final Matcher a;
    
    JdkMatcher(Matcher param1Matcher) {
      this.a = Preconditions.<Matcher>a(param1Matcher);
    }
    
    public boolean a() {
      return this.a.matches();
    }
    
    public boolean a(int param1Int) {
      return this.a.find(param1Int);
    }
    
    public boolean b() {
      return this.a.find();
    }
    
    public int c() {
      return this.a.end();
    }
    
    public int d() {
      return this.a.start();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\JdkPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */