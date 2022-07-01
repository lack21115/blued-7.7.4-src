package com.google.common.net;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.errorprone.annotations.Immutable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class InternetDomainName {
  private static final CharMatcher a = CharMatcher.a(".。．｡");
  
  private static final Splitter b = Splitter.a('.');
  
  private static final Joiner c = Joiner.a('.');
  
  private static final CharMatcher e = CharMatcher.a("-_");
  
  private static final CharMatcher f = CharMatcher.a('0', '9');
  
  private static final CharMatcher g = CharMatcher.a('a', 'z').b(CharMatcher.a('A', 'Z'));
  
  private static final CharMatcher h = f.b(g).b(e);
  
  private final String d;
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof InternetDomainName) {
      paramObject = paramObject;
      return this.d.equals(((InternetDomainName)paramObject).d);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.d.hashCode();
  }
  
  public String toString() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\net\InternetDomainName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */