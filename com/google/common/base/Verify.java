package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Verify {
  public static void a(boolean paramBoolean, @NullableDecl String paramString, @NullableDecl Object paramObject) {
    if (paramBoolean)
      return; 
    throw new VerifyException(Strings.a(paramString, new Object[] { paramObject }));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Verify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */