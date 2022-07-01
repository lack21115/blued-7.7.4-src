package com.huawei.hianalytics.ab.bc.ab;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

public class ab {
  public static final Charset ab = Charset.forName("UTF-8");
  
  public static Pair<byte[], String> ab(String paramString) {
    if (paramString == null || paramString.length() < 32)
      return new Pair(new byte[0], paramString); 
    String str = paramString.substring(0, 32);
    paramString = paramString.substring(32);
    return new Pair(HexUtil.a(str), paramString);
  }
  
  public static String ab(String paramString1, String paramString2) {
    Pair<byte[], String> pair = ab(paramString1);
    return new String(AesCbc.b(HexUtil.a((String)pair.second), HexUtil.a(paramString2), (byte[])pair.first), ab);
  }
  
  public static String bc(String paramString1, String paramString2) {
    return HexUtil.a(AesCbc.a(paramString1.getBytes(ab), HexUtil.a(paramString2)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ab\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */