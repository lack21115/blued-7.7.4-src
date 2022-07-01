package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Count implements Serializable {
  private int a;
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject instanceof Count && ((Count)paramObject).a == this.a);
  }
  
  public int hashCode() {
    return this.a;
  }
  
  public String toString() {
    return Integer.toString(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */