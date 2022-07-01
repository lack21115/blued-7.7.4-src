package com.blued.android.core.imagecache;

public class LoadDrawableException extends Throwable {
  FailReason.FailType a = FailReason.FailType.a;
  
  Throwable b = null;
  
  public LoadDrawableException(FailReason.FailType paramFailType, Throwable paramThrowable) {
    this.a = paramFailType;
    this.b = paramThrowable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\LoadDrawableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */