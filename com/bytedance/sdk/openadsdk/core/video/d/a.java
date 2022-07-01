package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.Build;
import android.view.View;

public class a {
  private static final int a = Build.VERSION.SDK_INT;
  
  public static int a(long paramLong1, long paramLong2) {
    boolean bool;
    if (paramLong2 > 0L) {
      bool = (int)(paramLong1 * 1.0D / paramLong2 * 100.0D);
    } else {
      bool = false;
    } 
    return Math.min(Math.max(0, bool), 100);
  }
  
  public static String a(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    long l = paramLong / 60000L;
    paramLong = paramLong % 3600000L % 60000L / 1000L;
    if (l >= 10L) {
      stringBuilder.append(l);
    } else if (l > 0L) {
      stringBuilder.append(0);
      stringBuilder.append(l);
    } else {
      stringBuilder.append(0);
      stringBuilder.append(0);
    } 
    stringBuilder.append(":");
    if (paramLong >= 10L) {
      stringBuilder.append(paramLong);
    } else if (paramLong > 0L) {
      stringBuilder.append(0);
      stringBuilder.append(paramLong);
    } else {
      stringBuilder.append(0);
      stringBuilder.append(0);
    } 
    return stringBuilder.toString();
  }
  
  public static void a(View paramView, boolean paramBoolean) {
    if (paramView == null)
      return; 
    if (paramBoolean) {
      paramView.setSystemUiVisibility(0);
      return;
    } 
    int i = a;
    if (i >= 19) {
      paramView.setSystemUiVisibility(3846);
      return;
    } 
    if (i >= 16) {
      paramView.setSystemUiVisibility(5);
      return;
    } 
    paramView.setSystemUiVisibility(1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */