package com.facebook.stetho.common.android;

import android.content.res.Resources;
import com.facebook.stetho.common.LogUtil;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ResourcesUtil {
  private static String getFallbackIdString(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("#");
    stringBuilder.append(Integer.toHexString(paramInt));
    return stringBuilder.toString();
  }
  
  public static String getIdString(@Nullable Resources paramResources, int paramInt) throws Resources.NotFoundException {
    String str2;
    if (paramResources == null)
      return getFallbackIdString(paramInt); 
    int i = getResourcePackageId(paramInt);
    String str3 = "";
    if (i != 127) {
      str3 = paramResources.getResourcePackageName(paramInt);
      str2 = ":";
    } else {
      str2 = "";
    } 
    String str4 = paramResources.getResourceTypeName(paramInt);
    String str1 = paramResources.getResourceEntryName(paramInt);
    StringBuilder stringBuilder = new StringBuilder(str3.length() + 1 + str2.length() + str4.length() + 1 + str1.length());
    stringBuilder.append("@");
    stringBuilder.append(str3);
    stringBuilder.append(str2);
    stringBuilder.append(str4);
    stringBuilder.append("/");
    stringBuilder.append(str1);
    return stringBuilder.toString();
  }
  
  @Nonnull
  public static String getIdStringQuietly(Object paramObject, @Nullable Resources paramResources, int paramInt) {
    try {
      return getIdString(paramResources, paramInt);
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      String str = getFallbackIdString(paramInt);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown identifier encountered on ");
      stringBuilder.append(paramObject);
      stringBuilder.append(": ");
      stringBuilder.append(str);
      LogUtil.w(stringBuilder.toString());
      return str;
    } 
  }
  
  private static int getResourcePackageId(int paramInt) {
    return paramInt >>> 24 & 0xFF;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\ResourcesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */