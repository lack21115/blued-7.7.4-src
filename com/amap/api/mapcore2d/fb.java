package com.amap.api.mapcore2d;

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

public class fb {
  private static void a(em paramem) {
    if (paramem != null)
      try {
        return;
      } finally {
        paramem = null;
      }  
  }
  
  private static void a(em paramem, List<String> paramList) {
    if (paramem != null)
      try {
        Iterator<String> iterator = paramList.iterator();
        while (iterator.hasNext())
          paramem.c(iterator.next()); 
        return;
      } finally {
        paramem = null;
      }  
  }
  
  public static void a(fa paramfa) {
    em em2 = null;
    em em1 = em2;
    try {
    
    } finally {
      paramfa = null;
      em1 = null;
    } 
  }
  
  public static void a(String paramString, byte[] paramArrayOfbyte, fa paramfa) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    OutputStream outputStream1 = null;
    OutputStream outputStream2 = null;
    try {
      if (a(paramfa.a, paramString))
        return; 
      File file = new File(paramfa.a);
      if (!file.exists())
        file.mkdirs(); 
      em em = em.a(file, 1, 1, paramfa.b);
      outputStream1 = outputStream2;
    } finally {
      paramString = null;
    } 
    if (outputStream1 != null)
      try {
        outputStream1.close();
      } finally {
        paramfa = null;
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
      do.c((Throwable)paramString1, "leg", "fet");
    } 
  }
  
  private static byte[] a(em paramem, fa paramfa, List<String> paramList) {
    try {
      File file = paramem.c();
    } finally {
      paramem = null;
    } 
    return new byte[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */