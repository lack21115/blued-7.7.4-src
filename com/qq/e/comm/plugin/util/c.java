package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import yaq.gdtadv;

public class c {
  static {
    if (m.a(c)) {
      str = "1";
    } else {
      str = c;
    } 
    a = str;
  }
  
  private static String a() {
    return (String)gdtadv.getobjresult(329, 1, new Object[0]);
  }
  
  public static String a(String paramString) {
    return (String)gdtadv.getobjresult(330, 1, new Object[] { paramString });
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    return (byte[])gdtadv.getobjresult(331, 1, new Object[] { paramArrayOfbyte });
  }
  
  public static String b(String paramString) {
    return (String)gdtadv.getobjresult(332, 1, new Object[] { paramString });
  }
  
  private static byte[] b(byte[] paramArrayOfbyte) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    return (byte[])gdtadv.getobjresult(333, 1, new Object[] { paramArrayOfbyte });
  }
  
  static {
    String str;
  }
  
  public static final String a;
  
  private static final String b = String.format("AES/%s/PKCS7Padding", new Object[] { "ECB" });
  
  private static final String c = GDTADManager.getInstance().getSM().getString("cgiAesKeyVer");
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */