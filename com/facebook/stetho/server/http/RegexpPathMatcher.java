package com.facebook.stetho.server.http;

import java.util.regex.Pattern;

public class RegexpPathMatcher implements PathMatcher {
  private final Pattern mPattern;
  
  public RegexpPathMatcher(Pattern paramPattern) {
    this.mPattern = paramPattern;
  }
  
  public boolean match(String paramString) {
    return this.mPattern.matcher(paramString).matches();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\RegexpPathMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */