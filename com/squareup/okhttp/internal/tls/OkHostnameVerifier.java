package com.squareup.okhttp.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class OkHostnameVerifier implements HostnameVerifier {
  private static final int ALT_DNS_NAME = 2;
  
  private static final int ALT_IPA_NAME = 7;
  
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
  
  private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  public static List<String> allSubjectAltNames(X509Certificate paramX509Certificate) {
    List<String> list2 = getSubjectAltNames(paramX509Certificate, 7);
    List<String> list1 = getSubjectAltNames(paramX509Certificate, 2);
    ArrayList<String> arrayList = new ArrayList(list2.size() + list1.size());
    arrayList.addAll(list2);
    arrayList.addAll(list1);
    return arrayList;
  }
  
  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt) {
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
  
  static boolean verifyAsIpAddress(String paramString) {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
  
  private boolean verifyHostName(String paramString1, String paramString2) {
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
  
  private boolean verifyHostName(String paramString, X509Certificate paramX509Certificate) {
    paramString = paramString.toLowerCase(Locale.US);
    List<String> list = getSubjectAltNames(paramX509Certificate, 2);
    int j = list.size();
    int i = 0;
    boolean bool;
    for (bool = false; i < j; bool = true) {
      if (verifyHostName(paramString, list.get(i)))
        return true; 
      i++;
    } 
    if (!bool) {
      String str = (new DistinguishedNameParser(paramX509Certificate.getSubjectX500Principal())).findMostSpecific("cn");
      if (str != null)
        return verifyHostName(paramString, str); 
    } 
    return false;
  }
  
  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate) {
    List<String> list = getSubjectAltNames(paramX509Certificate, 7);
    int j = list.size();
    for (int i = 0; i < j; i++) {
      if (paramString.equalsIgnoreCase(list.get(i)))
        return true; 
    } 
    return false;
  }
  
  public boolean verify(String paramString, X509Certificate paramX509Certificate) {
    return verifyAsIpAddress(paramString) ? verifyIpAddress(paramString, paramX509Certificate) : verifyHostName(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession) {
    try {
      return verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
    } catch (SSLException sSLException) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\tls\OkHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */