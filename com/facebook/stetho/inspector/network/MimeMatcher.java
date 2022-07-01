package com.facebook.stetho.inspector.network;

import java.util.ArrayList;
import javax.annotation.Nullable;

public class MimeMatcher<T> {
  private final ArrayList<MimeMatcherRule> mRuleMap = new ArrayList<MimeMatcherRule>();
  
  public void addRule(String paramString, T paramT) {
    this.mRuleMap.add(new MimeMatcherRule(paramString, paramT));
  }
  
  public void clear() {
    this.mRuleMap.clear();
  }
  
  @Nullable
  public T match(String paramString) {
    int j = this.mRuleMap.size();
    for (int i = 0; i < j; i++) {
      MimeMatcherRule mimeMatcherRule = this.mRuleMap.get(i);
      if (mimeMatcherRule.match(paramString))
        return mimeMatcherRule.getResultIfMatched(); 
    } 
    return null;
  }
  
  class MimeMatcherRule {
    private final boolean mHasWildcard;
    
    private final String mMatchPrefix;
    
    private final T mResultIfMatched;
    
    public MimeMatcherRule(String param1String, T param1T) {
      if (param1String.endsWith("*")) {
        this.mHasWildcard = true;
        this.mMatchPrefix = param1String.substring(0, param1String.length() - 1);
      } else {
        this.mHasWildcard = false;
        this.mMatchPrefix = param1String;
      } 
      if (!this.mMatchPrefix.contains("*")) {
        this.mResultIfMatched = param1T;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Multiple wildcards present in rule expression ");
      stringBuilder.append(param1String);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public T getResultIfMatched() {
      return this.mResultIfMatched;
    }
    
    public boolean match(String param1String) {
      boolean bool1 = param1String.startsWith(this.mMatchPrefix);
      boolean bool = false;
      if (!bool1)
        return false; 
      if (this.mHasWildcard || param1String.length() == this.mMatchPrefix.length())
        bool = true; 
      return bool;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\MimeMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */