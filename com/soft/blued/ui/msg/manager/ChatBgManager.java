package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import com.soft.blued.utils.BluedPreferences;
import java.io.File;

public class ChatBgManager {
  public static void a(String paramString) {
    if (!TextUtils.isEmpty(BluedPreferences.ab())) {
      BluedPreferences.a(paramString, BluedPreferences.ab());
      BluedPreferences.v("");
    } 
  }
  
  public static boolean b(String paramString) {
    return (!TextUtils.isEmpty(paramString) && paramString.equals("default"));
  }
  
  public static String c(String paramString) {
    String str = AppMethods.b("ChatBgImg");
    if (!TextUtils.isEmpty(str)) {
      File file = new File(str);
      if (file.exists() || file.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bg_");
        stringBuilder.append(Md5.a(paramString.toLowerCase().trim()));
        return (new File(file, stringBuilder.toString())).getAbsolutePath();
      } 
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\ChatBgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */