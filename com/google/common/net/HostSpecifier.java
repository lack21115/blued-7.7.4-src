package com.google.common.net;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class HostSpecifier {
  private final String a;
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof HostSpecifier) {
      paramObject = paramObject;
      return this.a.equals(((HostSpecifier)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public String toString() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\net\HostSpecifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */