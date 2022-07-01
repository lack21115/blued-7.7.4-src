package com.google.zxing;

import java.util.List;

public enum DecodeHintType {
  a(Object.class),
  b(Void.class),
  c(List.class),
  d(Void.class),
  e(String.class),
  f(int[].class),
  g(Void.class),
  h(Void.class),
  i(Void.class),
  j(ResultPointCallback.class),
  k(int[].class);
  
  private final Class<?> l;
  
  DecodeHintType(Class<?> paramClass) {
    this.l = paramClass;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\DecodeHintType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */