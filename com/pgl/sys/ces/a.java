package com.pgl.sys.ces;

import android.content.Context;

public final class a {
  static {
    try {
      System.loadLibrary("nms");
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      return;
    } 
  }
  
  public static native Object meta(int paramInt, Context paramContext, Object paramObject);
  
  public static Object njss(int paramInt, Object paramObject) {
    try {
      return b.a().a(paramInt, paramObject);
    } finally {
      paramObject = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */