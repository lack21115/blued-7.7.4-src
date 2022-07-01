package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class ResourceLoaderUtil {
  private static Context a;
  
  private static String b;
  
  public static int getAnimId(String paramString) {
    return a.getResources().getIdentifier(paramString, "anim", b);
  }
  
  public static int getColorId(String paramString) {
    return a.getResources().getIdentifier(paramString, "color", b);
  }
  
  public static Drawable getDrawable(String paramString) {
    return a.getResources().getDrawable(getDrawableId(paramString));
  }
  
  public static int getDrawableId(String paramString) {
    return a.getResources().getIdentifier(paramString, "drawable", b);
  }
  
  public static int getIdId(String paramString) {
    return a.getResources().getIdentifier(paramString, "id", b);
  }
  
  public static int getLayoutId(String paramString) {
    return a.getResources().getIdentifier(paramString, "layout", b);
  }
  
  public static String getString(String paramString) {
    return a.getResources().getString(getStringId(paramString));
  }
  
  public static String getString(String paramString, Object... paramVarArgs) {
    return a.getResources().getString(getStringId(paramString), paramVarArgs);
  }
  
  public static int getStringId(String paramString) {
    return a.getResources().getIdentifier(paramString, "string", b);
  }
  
  public static int getStyleId(String paramString) {
    return a.getResources().getIdentifier(paramString, "style", b);
  }
  
  public static Context getmContext() {
    return a;
  }
  
  public static void setmContext(Context paramContext) {
    a = paramContext;
    b = paramContext.getPackageName();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\ResourceLoaderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */