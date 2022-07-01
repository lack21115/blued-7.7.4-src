package com.blued.android.framework.utils;

import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtils {
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    StringBuilder stringBuilder = null;
    Matcher matcher = Pattern.compile("@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)").matcher(paramString);
    int i = 0;
    while (matcher.find()) {
      StringBuilder stringBuilder1 = stringBuilder;
      if (stringBuilder == null)
        stringBuilder1 = new StringBuilder(); 
      String str = matcher.group(1);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("@");
      stringBuilder2.append(str);
      str = stringBuilder2.toString();
      stringBuilder1.append(paramString.subSequence(i, matcher.start()));
      stringBuilder1.append(str);
      i = matcher.end();
      stringBuilder = stringBuilder1;
    } 
    if (stringBuilder != null && i < paramString.length() - 1)
      stringBuilder.append(paramString.subSequence(i, paramString.length())); 
    if (stringBuilder != null)
      paramString = stringBuilder.toString(); 
    return paramString;
  }
  
  public static interface AtUserClickSpanListener {}
  
  public static interface TopicClickSpanListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\RegExpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */