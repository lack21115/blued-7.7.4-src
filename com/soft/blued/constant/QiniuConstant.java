package com.soft.blued.constant;

import com.soft.blued.http.BluedHttpUrl;

public class QiniuConstant {
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu/chat?ops=%s&isBurn=%s");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\constant\QiniuConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */