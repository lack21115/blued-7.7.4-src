package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Hashing {
  static int a(int paramInt) {
    return (int)(Integer.rotateLeft((int)(paramInt * -862048943L), 15) * 461845907L);
  }
  
  static int a(int paramInt, double paramDouble) {
    paramInt = Math.max(paramInt, 2);
    int i = Integer.highestOneBit(paramInt);
    if (paramInt > (int)(paramDouble * i)) {
      paramInt = i << 1;
      return (paramInt > 0) ? paramInt : 1073741824;
    } 
    return i;
  }
  
  static int a(@NullableDecl Object paramObject) {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    } 
    return a(i);
  }
  
  static boolean a(int paramInt1, int paramInt2, double paramDouble) {
    return (paramInt1 > paramDouble * paramInt2 && paramInt2 < 1073741824);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Hashing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */