package com.blued.android.chat.utils;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtRegExpUtils {
  public static final String AT_USERNAME_PATTERN2 = "@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)";
  
  public static final String NOT_NAME_PUNCTUATION = "`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？";
  
  public static boolean isAtSelf(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ((paramString.contains(ChatManager.userInfo.encryUid) || paramString.contains("000000")));
  }
  
  public static String parseMessageAt(String paramString) {
    StringBuffer stringBuffer;
    if (TextUtils.isEmpty(paramString))
      return null; 
    Matcher matcher = Pattern.compile("@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)").matcher(paramString);
    paramString = null;
    while (matcher.find()) {
      StringBuffer stringBuffer1;
      String str = paramString;
      if (paramString == null)
        stringBuffer1 = new StringBuffer(); 
      stringBuffer1.append(matcher.group(2));
      stringBuffer1.append(";");
      stringBuffer = stringBuffer1;
    } 
    return (stringBuffer != null && stringBuffer.length() > 1) ? stringBuffer.substring(0, stringBuffer.length() - 1) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\AtRegExpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */