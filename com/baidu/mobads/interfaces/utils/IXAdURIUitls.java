package com.baidu.mobads.interfaces.utils;

import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public interface IXAdURIUitls {
  String addParameter(String paramString1, String paramString2, String paramString3);
  
  String addParameters(String paramString, HashMap<String, String> paramHashMap);
  
  void closeHttpURLConnection(HttpURLConnection paramHttpURLConnection);
  
  String encodeUrl(String paramString);
  
  HashMap<String, String> getAllQueryParameters(String paramString);
  
  String getFileName(String paramString);
  
  String getFixedString(String paramString);
  
  HttpURLConnection getHttpURLConnection(URL paramURL);
  
  Set<String> getQueryParameterNames(Uri paramUri);
  
  String getQueryString(String paramString);
  
  String getRequestAdUrl(String paramString, HashMap<String, String> paramHashMap);
  
  Boolean isHttpProtocol(String paramString);
  
  Boolean isHttpsProtocol(String paramString);
  
  void pintHttpInNewThread(String paramString);
  
  String replaceURLWithSupportProtocol(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdURIUitls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */