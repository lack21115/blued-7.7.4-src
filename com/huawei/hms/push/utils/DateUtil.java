package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
  public static String parseMilliSecondToString(Long paramLong) {
    if (paramLong == null)
      return null; 
    try {
      return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")).format(paramLong);
    } catch (Exception exception) {
      HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", exception);
      return null;
    } 
  }
  
  public static long parseUtcToMillisecond(String paramString) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    String str = paramString.substring(0, paramString.indexOf("."));
    paramString = paramString.substring(paramString.indexOf("."));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString.substring(0, 4));
    stringBuilder.append("Z");
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    return simpleDateFormat.parse(stringBuilder.toString()).getTime();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\pus\\utils\DateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */