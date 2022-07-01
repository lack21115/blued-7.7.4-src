package com.loc;

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

public final class ay {
  public static int a(ax paramax) {
    ao ao = null;
    try {
    
    } finally {
      paramax = null;
      ao = null;
    } 
    return -1;
  }
  
  private static void a(ao paramao, List<String> paramList) {
    if (paramao != null)
      try {
        Iterator<String> iterator = paramList.iterator();
        while (iterator.hasNext())
          paramao.c(iterator.next()); 
        return;
      } finally {
        paramao = null;
      }  
  }
  
  public static void a(String paramString, byte[] paramArrayOfbyte, ax paramax) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    OutputStream outputStream1 = null;
    OutputStream outputStream2 = null;
    try {
      if (a(paramax.a, paramString))
        return; 
      File file = new File(paramax.a);
      if (!file.exists())
        file.mkdirs(); 
      ao ao = ao.a(file, paramax.b);
      outputStream1 = outputStream2;
    } finally {
      paramString = null;
    } 
    if (outputStream1 != null)
      try {
        outputStream1.close();
      } finally {
        paramax = null;
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
      ab.b((Throwable)paramString1, "leg", "fet");
    } 
  }
  
  private static byte[] a(ao paramao, ax paramax, List<String> paramList) {
    int i;
    try {
    
    } finally {
      paramao = null;
      ab.b((Throwable)paramao, "leg", "gCo");
    } 
    return (i <= 0) ? null : paramax.g.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */