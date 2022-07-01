package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.a.c;

public class k implements i {
  public String a() {
    return Helper.cepahsul();
  }
  
  public String a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4) {
    return Helper.dnepah(paramContext, paramString1, paramString2, paramString3, paramLong, paramString4);
  }
  
  public String a(String paramString1, String paramString2) {
    try {
      return new String(Helper.dnepmret(c.a(paramString1), paramString2));
    } finally {
      paramString1 = null;
      paramString1.printStackTrace();
    } 
  }
  
  public String b() {
    return Helper.cemppmul();
  }
  
  public String b(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4) {
    return Helper.dnepmo(paramContext, paramString1, paramString2, paramString3, paramLong, paramString4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */