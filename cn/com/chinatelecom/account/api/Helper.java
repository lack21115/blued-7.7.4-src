package cn.com.chinatelecom.account.api;

import android.content.Context;

public final class Helper {
  static {
    System.loadLibrary("CtaApiLib");
  }
  
  public static native String cemppmul();
  
  public static native String cepahsul();
  
  public static native String dnepah(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4);
  
  public static native String dnepmo(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4);
  
  public static native byte[] dnepmret(byte[] paramArrayOfbyte, String paramString);
  
  public static native byte[] dneulret(byte[] paramArrayOfbyte);
  
  public static native String eneulret(String paramString);
  
  public static native String gscret(Context paramContext, String paramString);
  
  public static native String guulam(Context paramContext, String paramString);
  
  public static native String sgwret(String paramString);
  
  public static native String testEncrypt(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */