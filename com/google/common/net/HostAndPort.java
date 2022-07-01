package com.google.common.net;

import com.google.common.base.Objects;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class HostAndPort implements Serializable {
  private final String a;
  
  private final int b;
  
  public boolean a() {
    return (this.b >= 0);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof HostAndPort) {
      paramObject = paramObject;
      return (Objects.a(this.a, ((HostAndPort)paramObject).a) && this.b == ((HostAndPort)paramObject).b);
    } 
    return false;
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { this.a, Integer.valueOf(this.b) });
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(this.a.length() + 8);
    if (this.a.indexOf(':') >= 0) {
      stringBuilder.append('[');
      stringBuilder.append(this.a);
      stringBuilder.append(']');
    } else {
      stringBuilder.append(this.a);
    } 
    if (a()) {
      stringBuilder.append(':');
      stringBuilder.append(this.b);
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\net\HostAndPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */