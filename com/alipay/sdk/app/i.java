package com.alipay.sdk.app;

import android.text.TextUtils;
import com.alipay.sdk.data.a;
import java.util.Collections;
import java.util.List;

public class i {
  public static List<a.a> a;
  
  private static String b = "";
  
  private static final a.a c = new a.a("com.eg.android.AlipayGphone", 73, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649");
  
  private static final a.a d = new a.a("hk.alipay.wallet", 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
  
  static {
    a = Collections.singletonList(c);
  }
  
  public static String a() {
    return b;
  }
  
  public static void a(String paramString) {
    byte b;
    b = paramString;
    if (paramString.hashCode() == 3331 && paramString.equals("hk")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0) {
      a = Collections.singletonList(c);
      return;
    } 
    a = Collections.singletonList(d);
  }
  
  public static boolean b() {
    return (TextUtils.isEmpty(b) || TextUtils.equals("cn", b));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */