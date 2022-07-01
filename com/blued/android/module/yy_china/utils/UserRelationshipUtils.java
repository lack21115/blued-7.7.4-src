package com.blued.android.module.yy_china.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;

public class UserRelationshipUtils {
  public static String a(Context paramContext, TextView paramTextView, String paramString) {
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      if ("0".equals(paramString)) {
        str = paramContext.getString(R.string.yy_role_0);
      } else if ("1".equals(paramString)) {
        str = str.getString(R.string.yy_role_1);
      } else if ("0.5".equals(paramString)) {
        str = str.getString(R.string.yy_role_05);
      } else if ("-1".equals(paramString)) {
        str = str.getString(R.string.yy_role_other);
      } else if ("0.75".equals(paramString)) {
        str = str.getString(R.string.yy_role_075);
      } else if ("0.25".equals(paramString)) {
        str = str.getString(R.string.yy_role_025);
      } else {
        str = str.getString(R.string.yy_role_other);
      } 
    } else {
      str = str.getString(R.string.yy_role_other);
    } 
    if (paramTextView != null)
      paramTextView.setText(str); 
    return str;
  }
  
  public static String a(Context paramContext, String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "0"; 
    byte b = -1;
    switch (str.hashCode()) {
      case 51:
        if (str.equals("3"))
          b = 1; 
        break;
      case 50:
        if (str.equals("2"))
          b = 2; 
        break;
      case 49:
        if (str.equals("1"))
          b = 0; 
        break;
    } 
    return (b != 0) ? ((b != 1) ? paramContext.getResources().getString(R.string.yy_follow) : paramContext.getResources().getString(R.string.yy_follow_eachother)) : paramContext.getResources().getString(R.string.yy_followed);
  }
  
  public static String b(Context paramContext, String paramString) {
    return TextUtils.equals(paramString, "2") ? paramContext.getResources().getString(R.string.yy_role_manager) : (TextUtils.equals(paramString, "1") ? paramContext.getResources().getString(R.string.yy_role_host) : "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\UserRelationshipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */