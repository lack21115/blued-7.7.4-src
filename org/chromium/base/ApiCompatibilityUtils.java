package org.chromium.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import java.io.File;
import java.io.UnsupportedEncodingException;

@TargetApi(21)
public class ApiCompatibilityUtils {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int checkPermission(Context paramContext, String paramString, int paramInt1, int paramInt2) {
    try {
      return paramContext.checkPermission(paramString, paramInt1, paramInt2);
    } catch (RuntimeException runtimeException) {
      return -1;
    } 
  }
  
  public static byte[] getBytesUtf8(String paramString) {
    try {
      return paramString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new IllegalStateException("UTF-8 encoding not available.", unsupportedEncodingException);
    } 
  }
  
  public static int getColor(Resources paramResources, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? paramResources.getColor(paramInt, null) : paramResources.getColor(paramInt);
  }
  
  public static Drawable getDrawable(Resources paramResources, int paramInt) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      if (Build.VERSION.SDK_INT >= 21) {
        drawable = paramResources.getDrawable(paramInt, null);
        return drawable;
      } 
      Drawable drawable = drawable.getDrawable(paramInt);
      return drawable;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  public static int getLayoutDirection(Configuration paramConfiguration) {
    return (Build.VERSION.SDK_INT >= 17) ? paramConfiguration.getLayoutDirection() : 0;
  }
  
  public static Uri getUriForImageCaptureFile(File paramFile) {
    return (Build.VERSION.SDK_INT >= 18) ? ContentUriUtils.getContentUriFromFile$3dde563() : Uri.fromFile(paramFile);
  }
  
  @TargetApi(17)
  public static boolean isDeviceProvisioned(Context paramContext) {
    return (Build.VERSION.SDK_INT < 17) ? true : ((paramContext == null) ? true : ((paramContext.getContentResolver() == null) ? true : ((Settings.Global.getInt(paramContext.getContentResolver(), "device_provisioned", 0) != 0))));
  }
  
  public static boolean isInMultiWindowMode(Activity paramActivity) {
    return (Build.VERSION.SDK_INT < 24) ? false : paramActivity.isInMultiWindowMode();
  }
  
  public static boolean isLayoutRtl(View paramView) {
    return (Build.VERSION.SDK_INT >= 17) ? ((paramView.getLayoutDirection() == 1)) : false;
  }
  
  public static void setLayoutDirection(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 17)
      paramView.setLayoutDirection(paramInt); 
  }
  
  public static String toHtml(Spanned paramSpanned, int paramInt) {
    return (Build.VERSION.SDK_INT >= 24) ? Html.toHtml(paramSpanned, paramInt) : Html.toHtml(paramSpanned);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ApiCompatibilityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */