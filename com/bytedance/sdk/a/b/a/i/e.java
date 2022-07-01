package com.bytedance.sdk.a.b.a.i;

import com.bytedance.sdk.a.b.a.c;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class e implements HostnameVerifier {
  public static final e a = new e();
  
  public static List<String> a(X509Certificate paramX509Certificate) {
    List<String> list2 = a(paramX509Certificate, 7);
    List<String> list1 = a(paramX509Certificate, 2);
    ArrayList<String> arrayList = new ArrayList(list2.size() + list1.size());
    arrayList.addAll(list2);
    arrayList.addAll(list1);
    return arrayList;
  }
  
  private static List<String> a(X509Certificate paramX509Certificate, int paramInt) {
    ArrayList<String> arrayList = new ArrayList();
    try {
      Collection<List<?>> collection = paramX509Certificate.getSubjectAlternativeNames();
      if (collection == null)
        return Collections.emptyList(); 
      for (List<Integer> list : collection) {
        if (list == null || list.size() < 2)
          continue; 
        Integer integer = list.get(0);
        if (integer != null && integer.intValue() == paramInt) {
          String str = (String)list.get(1);
          if (str != null)
            arrayList.add(str); 
        } 
      } 
      return arrayList;
    } catch (CertificateParsingException certificateParsingException) {
      return Collections.emptyList();
    } 
  }
  
  private boolean b(String paramString, X509Certificate paramX509Certificate) {
    List<String> list = a(paramX509Certificate, 7);
    int j = list.size();
    for (int i = 0; i < j; i++) {
      if (paramString.equalsIgnoreCase(list.get(i)))
        return true; 
    } 
    return false;
  }
  
  private boolean c(String paramString, X509Certificate paramX509Certificate) {
    paramString = paramString.toLowerCase(Locale.US);
    List<String> list = a(paramX509Certificate, 2);
    int j = list.size();
    int i = 0;
    boolean bool;
    for (bool = false; i < j; bool = true) {
      if (a(paramString, list.get(i)))
        return true; 
      i++;
    } 
    if (!bool) {
      String str = (new d(paramX509Certificate.getSubjectX500Principal())).a("cn");
      if (str != null)
        return a(paramString, str); 
    } 
    return false;
  }
  
  public boolean a(String paramString1, String paramString2) {
    if (paramString1 != null && paramString1.length() != 0 && !paramString1.startsWith(".")) {
      if (paramString1.endsWith(".."))
        return false; 
      if (paramString2 != null && paramString2.length() != 0 && !paramString2.startsWith(".")) {
        if (paramString2.endsWith(".."))
          return false; 
        String str2 = paramString1;
        if (!paramString1.endsWith(".")) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString1);
          stringBuilder.append('.');
          str2 = stringBuilder.toString();
        } 
        paramString1 = paramString2;
        if (!paramString2.endsWith(".")) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString2);
          stringBuilder.append('.');
          str1 = stringBuilder.toString();
        } 
        String str1 = str1.toLowerCase(Locale.US);
        if (!str1.contains("*"))
          return str2.equals(str1); 
        if (str1.startsWith("*.")) {
          if (str1.indexOf('*', 1) != -1)
            return false; 
          if (str2.length() < str1.length())
            return false; 
          if ("*.".equals(str1))
            return false; 
          str1 = str1.substring(1);
          if (!str2.endsWith(str1))
            return false; 
          int i = str2.length() - str1.length();
          return !(i > 0 && str2.lastIndexOf('.', i - 1) != -1);
        } 
      } 
    } 
    return false;
  }
  
  public boolean a(String paramString, X509Certificate paramX509Certificate) {
    return c.c(paramString) ? b(paramString, paramX509Certificate) : c(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession) {
    try {
      return a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
    } catch (SSLException sSLException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */