package com.google.common.graph;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class ElementOrder<T> {
  private final Type a;
  
  @NullableDecl
  private final Comparator<T> b;
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ElementOrder))
      return false; 
    paramObject = paramObject;
    return (this.a == ((ElementOrder)paramObject).a && Objects.a(this.b, ((ElementOrder)paramObject).b));
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { this.a, this.b });
  }
  
  public String toString() {
    MoreObjects.ToStringHelper toStringHelper = MoreObjects.a(this).a("type", this.a);
    Comparator<T> comparator = this.b;
    if (comparator != null)
      toStringHelper.a("comparator", comparator); 
    return toStringHelper.toString();
  }
  
  public enum Type {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\ElementOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */