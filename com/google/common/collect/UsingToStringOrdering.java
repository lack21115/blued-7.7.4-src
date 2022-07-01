package com.google.common.collect;

import java.io.Serializable;

final class UsingToStringOrdering extends Ordering<Object> implements Serializable {
  static final UsingToStringOrdering a = new UsingToStringOrdering();
  
  public int compare(Object paramObject1, Object paramObject2) {
    return paramObject1.toString().compareTo(paramObject2.toString());
  }
  
  public String toString() {
    return "Ordering.usingToString()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\UsingToStringOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */