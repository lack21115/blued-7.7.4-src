package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TransactionIdCreater {
  private static final int API_SIZE = 6;
  
  private static final int APPID_SIZE = 9;
  
  private static final char FILL_BYTE = '0';
  
  public static String getId(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(StringUtil.addByteForNum(paramString1, 9, '0'));
    stringBuilder.append(StringUtil.addByteForNum(paramString2, 6, '0'));
    stringBuilder.append((new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH)).format(new Date()));
    stringBuilder.append(String.format(Locale.ENGLISH, "%06d", new Object[] { Integer.valueOf((new SecureRandom()).nextInt(1000000)) }));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\TransactionIdCreater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */