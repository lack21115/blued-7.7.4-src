package com.soft.blued.http;

import java.util.Iterator;
import java.util.Map;

public class HttpUtils {
  public static String a(Map<String, String> paramMap, String paramString) {
    Map.Entry entry;
    String str = paramString;
    if (paramMap != null) {
      str = paramString;
      if (paramMap.size() > 0) {
        Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
        while (true) {
          str = paramString;
          if (iterator.hasNext()) {
            entry = iterator.next();
            if (paramString.contains("?")) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(paramString);
              stringBuilder1.append("&");
              stringBuilder1.append(entry.getKey());
              stringBuilder1.append("=");
              stringBuilder1.append(entry.getValue());
              paramString = stringBuilder1.toString();
              continue;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paramString);
            stringBuilder.append("?");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
            paramString = stringBuilder.toString();
            continue;
          } 
          break;
        } 
      } 
    } 
    return (String)entry;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */