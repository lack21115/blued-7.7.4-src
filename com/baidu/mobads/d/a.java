package com.baidu.mobads.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class a {
  private static Map<String, String> a = new HashMap<String, String>();
  
  static {
    a.put("0100000", "请求错误");
    a.put("0101000", "广告配置缺失");
    a.put("0101001", "广告配置缺失");
    a.put("0101002", "广告配置缺失");
    a.put("0101003", "广告配置错误");
    a.put("0101004", "广告配置错误");
    a.put("0101005", "广告配置错误");
    a.put("0103000", "无广告返回");
    a.put("0103010", "APPSID缺失");
    a.put("0103011", "APPSID失效或错误");
    a.put("0103012", "APPSID失效或错误");
    a.put("0103020", "APPSID失效或错误");
    a.put("0103030", "无广告返回");
    a.put("0103040", "无广告返回");
    a.put("0103050", "无广告返回");
    a.put("0103060", "应用包名信息错误，请保证注册包名和实际请求包名一致");
    a.put("0104000", "无广告返回");
    a.put("0104010", "无广告返回");
    a.put("0104011", "无广告返回");
    a.put("0104020", "无广告返回");
    a.put("0104021", "无广告返回");
    a.put("0104030", "无广告返回");
    a.put("0104040", "无广告返回");
    a.put("0104050", "无广告返回");
    a.put("0104060", "无广告返回");
    a.put("0104070", "无广告返回");
    a.put("0104071", "无广告返回");
    a.put("0104080", "无广告返回");
    a.put("0104081", "无广告返回");
    a.put("0104090", "无广告返回");
    a.put("0104100", "无广告返回");
    a.put("0104110", "无广告返回");
    a.put("0105000", "无广告返回");
    a.put("0105010", "无广告返回");
    a.put("0105011", "无广告返回");
    a.put("0105020", "无广告返回");
    a.put("0105021", "无广告返回");
    a.put("0105030", "无广告返回");
    a.put("0105031", "无广告返回");
    a.put("0105040", "无广告返回");
    a.put("0105041", "无广告返回");
    a.put("0105050", "无广告返回");
    a.put("0105060", "无广告返回");
    a.put("0105070", "无广告返回");
    a.put("0106000", "无广告返回");
    a.put("0106001", "无广告返回");
    a.put("0106010", "无广告返回");
    a.put("0106020", "无广告返回");
    a.put("0106030", "无广告返回");
    a.put("0107000", "广告位ID缺失");
    a.put("0107001", "广告位ID错误或失效");
    a.put("0107002", "广告位ID错误或失效");
    a.put("0107003", "广告位ID与APPSID不匹配");
    a.put("0107010", "广告位信息缺失");
    a.put("0107020", "广告位信息缺失");
    a.put("0107030", "广告位信息缺失");
    a.put("0107040", "广告位信息缺失");
    a.put("0107050", "视频无法播放");
    a.put("0107051", "视频信息错误");
    a.put("0107052", "广告位尺寸和MSSP注册尺寸不符");
    a.put("0200000", "无广告返回");
    a.put("0201000", "无广告返回");
    a.put("0201010", "广告信息错误");
    a.put("0201020", "广告信息错误");
    a.put("0201021", "广告信息错误");
    a.put("0201030", "广告信息错误");
    a.put("0201031", "广告信息错误");
    a.put("0201040", "广告信息错误");
    a.put("0201050", "广告信息错误");
    a.put("0201060", "广告信息错误");
    a.put("0201070", "广告信息错误");
    a.put("0201080", "广告信息错误");
    a.put("0201090", "广告信息错误");
    a.put("0201100", "广告信息错误");
    a.put("0201110", "广告信息错误");
  }
  
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    String str = paramString;
    if (paramString.length() == 6) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0");
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    str = a.get(str);
    paramString = str;
    if (str == null)
      paramString = ""; 
    return paramString;
  }
  
  public static String b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    String str = paramString;
    if (paramString.length() == 6) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0");
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */