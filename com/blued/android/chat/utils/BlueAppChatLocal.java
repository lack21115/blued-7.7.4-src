package com.blued.android.chat.utils;

import com.blued.android.chat.ChatManager;
import java.util.Locale;

public class BlueAppChatLocal {
  public static String getCountry() {
    return (ChatManager.context.getResources().getConfiguration()).locale.getCountry();
  }
  
  public static Locale getDefault() {
    return (ChatManager.context.getResources().getConfiguration()).locale;
  }
  
  public static String getLanguage() {
    return (ChatManager.context.getResources().getConfiguration()).locale.getLanguage();
  }
  
  public static boolean isZh() {
    return "zh".equals(getLanguage());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\BlueAppChatLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */