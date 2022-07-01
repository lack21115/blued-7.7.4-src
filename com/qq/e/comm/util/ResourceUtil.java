package com.qq.e.comm.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

public class ResourceUtil {
  public static int getColorId(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      Resources resources = paramContext.getResources();
      if (resources != null)
        return resources.getIdentifier(paramString, "color", paramContext.getPackageName()); 
    } 
    return -1;
  }
  
  public static int getDrawableId(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      Resources resources = paramContext.getResources();
      if (resources != null)
        return resources.getIdentifier(paramString, "drawable", paramContext.getPackageName()); 
    } 
    return -1;
  }
  
  public static int getId(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      Resources resources = paramContext.getResources();
      if (resources != null)
        return resources.getIdentifier(paramString, "id", paramContext.getPackageName()); 
    } 
    return -1;
  }
  
  public static int getLayoutId(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      Resources resources = paramContext.getResources();
      if (resources != null)
        return resources.getIdentifier(paramString, "layout", paramContext.getPackageName()); 
    } 
    return -1;
  }
  
  public static int getStringId(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      Resources resources = paramContext.getResources();
      if (resources != null)
        return resources.getIdentifier(paramString, "string", paramContext.getPackageName()); 
    } 
    return -1;
  }
  
  public static int getStyleId(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      Resources resources = paramContext.getResources();
      if (resources != null)
        return resources.getIdentifier(paramString, "style", paramContext.getPackageName()); 
    } 
    return -1;
  }
  
  public static int getStyleableFieldId(Context paramContext, String paramString1, String paramString2) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramContext.getPackageName());
    stringBuilder2.append(".R");
    String str2 = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString1);
    stringBuilder1.append("_");
    stringBuilder1.append(paramString2);
    String str1 = stringBuilder1.toString();
    try {
    
    } finally {
      str1 = null;
    } 
    return 0;
  }
  
  public static int[] getStyleableIntArray(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(".R$styleable");
    } finally {
      paramContext = null;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\ResourceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */