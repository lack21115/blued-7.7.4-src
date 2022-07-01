package com.geetest.onepassv2.b;

import com.geetest.onelogin.e.a.a;
import com.geetest.onelogin.e.a.b;
import com.geetest.onelogin.e.a.h;
import java.security.interfaces.RSAPublicKey;

public class d {
  public static String a(String paramString1, String paramString2) {
    String str = String.valueOf(b.a(a.b(paramString1, paramString2)));
    try {
      paramString1 = h.a(paramString2, (RSAPublicKey)h.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCV+w9ttzAugqJLWL3SBzVYKmKP\n/UztcZS26BAzILeGOw2Fv5BeSSftX2AKlhEw7RxnZX1S7rLrIIVzLeJhEctdEvM0\nffzZboGep+zMQIl3wuxGpOMFGmvZftfsm/YqMsh9BDik3WiSSzMUFtoe8y5ngIF/\nJKRbjRJODOU95ObpgwIDAQAB"));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append((String)exception);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */