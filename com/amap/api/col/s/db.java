package com.amap.api.col.s;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class db {
  public static int a(da paramda) {
    cp cp = null;
    try {
    
    } finally {
      paramda = null;
      cp = null;
    } 
    return -1;
  }
  
  private static void a(cp paramcp, List<String> paramList) {
    if (paramcp != null)
      try {
        Iterator<String> iterator = paramList.iterator();
        while (iterator.hasNext())
          paramcp.c(iterator.next()); 
        return;
      } finally {
        paramcp = null;
      }  
  }
  
  public static void a(String paramString, byte[] paramArrayOfbyte, da paramda) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    OutputStream outputStream1 = null;
    OutputStream outputStream2 = null;
    try {
      if (a(paramda.a, paramString))
        return; 
      File file = new File(paramda.a);
      if (!file.exists())
        file.mkdirs(); 
      cp cp = cp.a(file, paramda.b);
      outputStream1 = outputStream2;
    } finally {
      paramString = null;
    } 
    if (outputStream1 != null)
      try {
        outputStream1.close();
      } finally {
        paramda = null;
      }  
    if (paramArrayOfbyte != null)
      try {
        paramArrayOfbyte.close();
      } finally {
        paramArrayOfbyte = null;
      }  
    throw paramString;
  }
  
  private static boolean a(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return (new File(paramString1, stringBuilder.toString())).exists();
    } finally {
      paramString1 = null;
      cg.c((Throwable)paramString1, "leg", "fet");
    } 
  }
  
  private static byte[] a(cp paramcp, da paramda, List<String> paramList) {
    int i;
    try {
    
    } finally {
      paramcp = null;
      cg.c((Throwable)paramcp, "leg", "gCo");
    } 
    return (i <= 0) ? null : paramda.g.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */