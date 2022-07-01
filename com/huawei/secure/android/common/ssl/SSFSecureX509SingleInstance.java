package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.g;
import java.io.InputStream;

public class SSFSecureX509SingleInstance {
  private static final String a = SSFSecureX509SingleInstance.class.getSimpleName();
  
  private static volatile SecureX509TrustManager b;
  
  public static void a(InputStream paramInputStream) {
    g.b(a, "update bks");
    if (paramInputStream != null && b != null) {
      b = new SecureX509TrustManager(paramInputStream, "", true);
      SSFCompatiableSystemCA.a(b);
      SASFCompatiableSystemCA.a(b);
      if (b != null && b.getAcceptedIssuers() != null) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("after updata bks , ca size is : ");
        stringBuilder.append((b.getAcceptedIssuers()).length);
        g.a(str, stringBuilder.toString());
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\SSFSecureX509SingleInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */