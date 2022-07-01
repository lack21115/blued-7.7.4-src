package com.baidu.mobads.utils;

import android.net.Uri;
import android.os.Build;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.e.c;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class aa implements IXAdURIUitls {
  private Boolean a(String paramString1, String paramString2) {
    boolean bool = false;
    if (paramString1 != null && paramString1.trim().toLowerCase(Locale.getDefault()).indexOf(paramString2) == 0)
      bool = true; 
    return Boolean.valueOf(bool);
  }
  
  public Boolean a(String paramString) {
    if (a(paramString, "sms:").booleanValue() || a(paramString, "smsto:").booleanValue() || a(paramString, "mms:").booleanValue()) {
      boolean bool1 = true;
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  @Deprecated
  public String addParameter(String paramString1, String paramString2, String paramString3) {
    String str1;
    String str2 = getFixedString(paramString1);
    paramString1 = getQueryString(paramString1);
    if (!XAdSDKFoundationFacade.getInstance().getCommonUtils().isStringAvailable(paramString1)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString2);
      stringBuilder1.append("=");
      stringBuilder1.append(paramString3);
      str1 = stringBuilder1.toString();
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("&");
      stringBuilder1.append(paramString2);
      stringBuilder1.append("=");
      stringBuilder1.append(paramString3);
      str1 = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append("?");
    stringBuilder.append(str1);
    return stringBuilder.toString();
  }
  
  public String addParameters(String paramString, HashMap<String, String> paramHashMap) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    if (paramHashMap == null || paramHashMap.isEmpty())
      return stringBuilder.toString(); 
    stringBuilder.append("?");
    for (Map.Entry<String, String> entry : paramHashMap.entrySet()) {
      try {
        stringBuilder.append((String)entry.getKey());
        stringBuilder.append("=");
        stringBuilder.append((String)entry.getValue());
        stringBuilder.append("&");
      } catch (Exception exception) {
        q.a().e(exception);
      } 
    } 
    String str = stringBuilder.toString();
    return str.substring(0, str.length() - 1);
  }
  
  public void closeHttpURLConnection(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection != null) {
      try {
        paramHttpURLConnection.getInputStream().close();
      } finally {
        Exception exception;
      } 
      try {
        paramHttpURLConnection.getOutputStream().close();
      } finally {
        Exception exception = null;
      } 
    } 
  }
  
  public String encodeUrl(String paramString) {
    try {
      return URLEncoder.encode(paramString, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new IllegalArgumentException(unsupportedEncodingException);
    } 
  }
  
  public HashMap<String, String> getAllQueryParameters(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Uri uri = Uri.parse(paramString);
    for (String str : getQueryParameterNames(uri)) {
      if (str != null && str.length() > 0)
        hashMap.put(str, uri.getQueryParameter(str)); 
    } 
    return (HashMap)hashMap;
  }
  
  public String getFileName(String paramString) {
    try {
      paramString = (new URI(paramString)).getPath();
      return paramString.substring(paramString.lastIndexOf('/') + 1, paramString.length());
    } catch (URISyntaxException uRISyntaxException) {
      return "";
    } 
  }
  
  public String getFixedString(String paramString) {
    if (paramString == null)
      return null; 
    if (!isHttpProtocol(paramString).booleanValue()) {
      String str = paramString;
      return isHttpsProtocol(paramString).booleanValue() ? paramString.split("\\?")[0] : str;
    } 
    return paramString.split("\\?")[0];
  }
  
  public HttpURLConnection getHttpURLConnection(URL paramURL) {
    if (paramURL.getProtocol().toLowerCase().equals("https")) {
      c.a();
      return (HttpsURLConnection)paramURL.openConnection();
    } 
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public Set<String> getQueryParameterNames(Uri paramUri) {
    HashSet<String> hashSet = new HashSet();
    try {
      Set set;
      if (Build.VERSION.SDK_INT >= 11) {
        set = paramUri.getQueryParameterNames();
      } else {
        Set<?> set1;
        String str = set.getEncodedQuery();
        if (str == null) {
          set1 = Collections.emptySet();
        } else {
          LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
          int i = 0;
          while (true) {
            int j;
            while (true) {
              int k = set1.indexOf('&', i);
              j = k;
              linkedHashSet.add(Uri.decode(set1.substring(i, SYNTHETIC_LOCAL_VARIABLE_4)));
              j = SYNTHETIC_LOCAL_VARIABLE_2 + 1;
              i = j;
              break;
            } 
            if (j >= set1.length())
              return (Set)Collections.unmodifiableSet(linkedHashSet); 
          } 
        } 
      } 
    } catch (Exception exception) {
      return hashSet;
    } 
    return (Set<String>)exception;
  }
  
  public String getQueryString(String paramString) {
    String str2 = null;
    if (paramString == null)
      return null; 
    if (isHttpProtocol(paramString).booleanValue() || isHttpsProtocol(paramString).booleanValue()) {
      String[] arrayOfString = paramString.split("\\?");
    } else {
      paramString = null;
    } 
    String str1 = str2;
    if (paramString != null) {
      str1 = str2;
      if (paramString.length >= 2)
        str1 = paramString[1]; 
    } 
    return str1;
  }
  
  public String getRequestAdUrl(String paramString, HashMap<String, String> paramHashMap) {
    XAdSDKFoundationFacade xAdSDKFoundationFacade = XAdSDKFoundationFacade.getInstance();
    StringBuilder stringBuilder3 = new StringBuilder();
    if (paramHashMap != null) {
      Iterator<String> iterator = paramHashMap.keySet().iterator();
      int i = 0;
      while (iterator.hasNext()) {
        i++;
        String str1 = iterator.next();
        String str2 = paramHashMap.get(str1);
        if (i == 1) {
          stringBuilder3.append(str1);
          stringBuilder3.append("=");
          stringBuilder3.append(str2);
          continue;
        } 
        stringBuilder3.append("&");
        stringBuilder3.append(str1);
        stringBuilder3.append("=");
        stringBuilder3.append(str2);
      } 
    } 
    if (XAdSDKProxyVersion.DEBUG.booleanValue()) {
      if (paramHashMap != null) {
        Iterator<String> iterator = paramHashMap.keySet().iterator();
        while (true) {
          if (iterator.hasNext()) {
            String str1 = iterator.next();
            try {
              String str2 = paramHashMap.get(str1);
              if (str2 != null)
                paramHashMap.put(str1, URLEncoder.encode(str2, "UTF-8")); 
            } catch (UnsupportedEncodingException unsupportedEncodingException) {}
            continue;
          } 
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(xAdSDKFoundationFacade.getURIUitls().addParameters(paramString, paramHashMap));
          stringBuilder3.append("&b");
          stringBuilder3.append(System.currentTimeMillis());
          stringBuilder3.append("=1");
          paramString = stringBuilder3.toString();
          stringBuilder1 = new StringBuilder();
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("&b");
          stringBuilder2.append(System.currentTimeMillis());
          stringBuilder1.append(stringBuilder2.toString());
          stringBuilder1.append("=");
          stringBuilder1.append("1");
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(paramString);
          stringBuilder2.append(stringBuilder1.toString());
          return stringBuilder2.toString();
        } 
      } 
    } else {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("?code2=");
      IBase64 iBase64 = stringBuilder2.getBase64();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(stringBuilder3.toString());
      stringBuilder2.append("&b");
      stringBuilder2.append(System.currentTimeMillis());
      stringBuilder2.append("=1");
      stringBuilder1.append(iBase64.encode(stringBuilder2.toString()));
      str = stringBuilder1.toString();
      stringBuilder1 = new StringBuilder();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&b");
      stringBuilder2.append(System.currentTimeMillis());
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append("=");
      stringBuilder1.append("1");
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str);
      stringBuilder2.append(stringBuilder1.toString());
      return stringBuilder2.toString();
    } 
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(stringBuilder2.getURIUitls().addParameters(str, (HashMap)stringBuilder1));
    stringBuilder3.append("&b");
    stringBuilder3.append(System.currentTimeMillis());
    stringBuilder3.append("=1");
    String str = stringBuilder3.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("&b");
    stringBuilder2.append(System.currentTimeMillis());
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append("=");
    stringBuilder1.append("1");
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append(stringBuilder1.toString());
    return stringBuilder2.toString();
  }
  
  public Boolean isHttpProtocol(String paramString) {
    return a(paramString, "http:");
  }
  
  public Boolean isHttpsProtocol(String paramString) {
    return a(paramString, "https:");
  }
  
  public void pintHttpInNewThread(String paramString) {
    a a = new a();
    b b = new b(paramString, "");
    b.e = 1;
    a.a(b, Boolean.valueOf(true));
  }
  
  public String replaceURLWithSupportProtocol(String paramString) {
    String str = paramString;
    if (AdSettings.getSupportHttps().equals(AdSettings.b.c.a())) {
      str = paramString;
      if (isHttpProtocol(paramString).booleanValue())
        str = paramString.replaceFirst("(?i)http", "https"); 
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */