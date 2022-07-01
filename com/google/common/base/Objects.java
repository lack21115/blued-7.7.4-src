package com.google.common.base;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Objects extends ExtraObjectsMethodsForWeb {
  public static int a(@NullableDecl Object... paramVarArgs) {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */