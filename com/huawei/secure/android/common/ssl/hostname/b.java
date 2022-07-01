package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

public class b {
  private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  
  private static final String[] b = new String[] { 
      "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", 
      "ne", "net", "or", "org" };
  
  static {
    Arrays.sort((Object[])b);
  }
  
  public static final void a(String paramString, X509Certificate paramX509Certificate, boolean paramBoolean) throws SSLException {
    String[] arrayOfString2 = a(paramX509Certificate);
    String[] arrayOfString1 = b(paramX509Certificate);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cn is : ");
    stringBuilder.append(Arrays.toString((Object[])arrayOfString2));
    g.a("", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("san is : ");
    stringBuilder.append(Arrays.toString((Object[])arrayOfString1));
    g.a("", stringBuilder.toString());
    a(paramString, arrayOfString2, arrayOfString1, paramBoolean);
  }
  
  public static final void a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean) throws SSLException {
    LinkedList<String> linkedList = new LinkedList();
    if (paramArrayOfString1 != null && paramArrayOfString1.length > 0 && paramArrayOfString1[0] != null)
      linkedList.add(paramArrayOfString1[0]); 
    if (paramArrayOfString2 != null) {
      int j = paramArrayOfString2.length;
      int i;
      for (i = 0; i < j; i++) {
        String str = paramArrayOfString2[i];
        if (str != null)
          linkedList.add(str); 
      } 
    } 
    if (!linkedList.isEmpty()) {
      boolean bool1;
      StringBuffer stringBuffer = new StringBuffer();
      String str = paramString.trim().toLowerCase(Locale.ENGLISH);
      Iterator<String> iterator = linkedList.iterator();
      boolean bool2 = false;
      while (true) {
        bool1 = bool2;
        if (iterator.hasNext()) {
          boolean bool;
          String str1 = ((String)iterator.next()).toLowerCase(Locale.ENGLISH);
          stringBuffer.append(" <");
          stringBuffer.append(str1);
          stringBuffer.append('>');
          if (iterator.hasNext())
            stringBuffer.append(" OR"); 
          bool2 = str1.startsWith("*.");
          bool1 = true;
          if (bool2 && str1.indexOf('.', 2) != -1 && a(str1) && !c(paramString)) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool) {
            bool2 = str.endsWith(str1.substring(1));
            if (bool2 && paramBoolean) {
              if (b(str) != b(str1))
                bool1 = false; 
            } else {
              bool1 = bool2;
            } 
          } else {
            bool1 = str.equals(str1);
          } 
          bool2 = bool1;
          if (bool1)
            break; 
          continue;
        } 
        break;
      } 
      if (bool1)
        return; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("hostname in certificate didn't match: <");
      stringBuilder1.append(paramString);
      stringBuilder1.append("> !=");
      stringBuilder1.append(stringBuffer);
      throw new SSLException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Certificate for <");
    stringBuilder.append(paramString);
    stringBuilder.append("> doesn't contain CN or DNS subjectAlt");
    throw new SSLException(stringBuilder.toString());
  }
  
  public static boolean a(String paramString) {
    int i = paramString.length();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 7) {
      bool1 = bool2;
      if (i <= 9) {
        i -= 3;
        bool1 = bool2;
        if (paramString.charAt(i) == '.') {
          paramString = paramString.substring(2, i);
          if (Arrays.binarySearch((Object[])b, paramString) < 0)
            return true; 
          bool1 = false;
        } 
      } 
    } 
    return bool1;
  }
  
  public static String[] a(X509Certificate paramX509Certificate) {
    List<String> list = (new a(paramX509Certificate.getSubjectX500Principal())).a("cn");
    if (!list.isEmpty()) {
      String[] arrayOfString = new String[list.size()];
      list.toArray(arrayOfString);
      return arrayOfString;
    } 
    return null;
  }
  
  public static int b(String paramString) {
    int i = 0;
    int j;
    for (j = 0; i < paramString.length(); j = k) {
      int k = j;
      if (paramString.charAt(i) == '.')
        k = j + 1; 
      i++;
    } 
    return j;
  }
  
  public static String[] b(X509Certificate paramX509Certificate) {
    LinkedList<String> linkedList = new LinkedList();
    try {
      Collection<List<?>> collection = paramX509Certificate.getSubjectAlternativeNames();
    } catch (CertificateParsingException certificateParsingException) {
      g.a("", "Error parsing certificate.", certificateParsingException);
      certificateParsingException = null;
    } 
    if (certificateParsingException != null)
      for (List<Integer> list : (Iterable<List<Integer>>)certificateParsingException) {
        if (((Integer)list.get(0)).intValue() == 2)
          linkedList.add((String)list.get(1)); 
      }  
    if (!linkedList.isEmpty()) {
      String[] arrayOfString = new String[linkedList.size()];
      linkedList.toArray(arrayOfString);
      return arrayOfString;
    } 
    return null;
  }
  
  private static boolean c(String paramString) {
    return a.matcher(paramString).matches();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ssl\hostname\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */