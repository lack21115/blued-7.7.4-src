package com.google.common.collect;

public enum BoundType {
  a(false),
  b(true);
  
  final boolean c;
  
  BoundType(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  static BoundType a(boolean paramBoolean) {
    return paramBoolean ? b : a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\BoundType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */