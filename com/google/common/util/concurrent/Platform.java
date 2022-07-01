package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Platform {
  static boolean a(@NullableDecl Throwable paramThrowable, Class<? extends Throwable> paramClass) {
    return paramClass.isInstance(paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */