package com.google.common.collect;

import com.google.common.base.Preconditions;

final class CollectPreconditions {
  static int a(int paramInt, String paramString) {
    if (paramInt >= 0)
      return paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" cannot be negative but was: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static long a(long paramLong, String paramString) {
    if (paramLong >= 0L)
      return paramLong; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" cannot be negative but was: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static void a(Object paramObject1, Object paramObject2) {
    if (paramObject1 != null) {
      if (paramObject2 != null)
        return; 
      paramObject2 = new StringBuilder();
      paramObject2.append("null value in entry: ");
      paramObject2.append(paramObject1);
      paramObject2.append("=null");
      throw new NullPointerException(paramObject2.toString());
    } 
    paramObject1 = new StringBuilder();
    paramObject1.append("null key in entry: null=");
    paramObject1.append(paramObject2);
    throw new NullPointerException(paramObject1.toString());
  }
  
  static void a(boolean paramBoolean) {
    Preconditions.b(paramBoolean, "no calls to next() since the last call to remove()");
  }
  
  static void b(int paramInt, String paramString) {
    if (paramInt > 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" must be positive but was: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CollectPreconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */