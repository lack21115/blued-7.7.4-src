package com.bytedance.tea.a.a.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a {
  private static a a;
  
  private static boolean b = false;
  
  private static Uri a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramString2 != null) {
      if (paramString1 != null) {
        stringBuilder.append(paramString1);
        stringBuilder.append("://");
      } 
      stringBuilder.append(paramString2);
      if (paramInt > 0) {
        stringBuilder.append(':');
        stringBuilder.append(paramInt);
      } 
    } 
    if (paramString3 == null || !paramString3.startsWith("/"))
      stringBuilder.append('/'); 
    if (paramString3 != null)
      stringBuilder.append(paramString3); 
    if (paramString4 != null) {
      stringBuilder.append('?');
      stringBuilder.append(paramString4);
    } 
    if (paramString5 != null) {
      stringBuilder.append('#');
      stringBuilder.append(paramString5);
    } 
    return Uri.parse(stringBuilder.toString());
  }
  
  private static String a(String paramString1, String paramString2) {
    if (paramString2 == null)
      paramString2 = "ISO-8859-1"; 
    try {
      return URLEncoder.encode(paramString1, paramString2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new IllegalArgumentException(unsupportedEncodingException);
    } 
  }
  
  public static String a(String paramString, List<Pair<String, String>> paramList) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    if (a == null)
      return paramString; 
    if (b)
      return paramString; 
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    try {
      Uri uri = Uri.parse(paramString);
      a(uri, (Map)linkedHashMap);
      LinkedList<Pair<String, List<String>>> linkedList1 = new LinkedList();
      a((Map)linkedHashMap, linkedList1, "device_id");
      a((Map)linkedHashMap, linkedList1, "device_type");
      a((Map)linkedHashMap, linkedList1, "device_brand");
      a((Map)linkedHashMap, linkedList1, "uuid");
      a((Map)linkedHashMap, linkedList1, "openudid");
      String str1 = a(linkedList1, false, "UTF-8");
      if (TextUtils.isEmpty(str1))
        return paramString; 
      byte[] arrayOfByte = str1.getBytes();
      arrayOfByte = TTEncryptUtils.a(arrayOfByte, arrayOfByte.length);
      if (arrayOfByte == null)
        return paramString; 
      String str2 = Base64.encodeToString(arrayOfByte, 2);
      LinkedList<Pair> linkedList = new LinkedList();
      if (a.a()) {
        LinkedList<String> linkedList2 = new LinkedList();
        linkedList2.add(str2);
        linkedList.add(new Pair("ss_queries", linkedList2));
      } 
      if (a.b() && paramList != null)
        paramList.add(new Pair("X-SS-QUERIES", a(str2, "UTF-8"))); 
      return a(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), null, uri.getFragment()).toString();
    } finally {
      paramList = null;
      paramList.printStackTrace();
    } 
  }
  
  private static String a(List<Pair<String, List<String>>> paramList, boolean paramBoolean, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Pair<String, List<String>> pair : paramList) {
      String str = (String)pair.first;
      if (paramBoolean)
        str = a((String)pair.first, paramString); 
      List list = (List)pair.second;
      if (list != null && list.size() > 0)
        for (String str2 : list) {
          String str1 = str2;
          if (paramBoolean)
            if (str2 != null) {
              str1 = a(str2, paramString);
            } else {
              str1 = "";
            }  
          if (stringBuilder.length() > 0)
            stringBuilder.append("&"); 
          stringBuilder.append(str);
          stringBuilder.append("=");
          stringBuilder.append(str1);
        }  
    } 
    return stringBuilder.toString();
  }
  
  public static void a(Uri paramUri, Map<String, List<String>> paramMap) throws IOException {
    if (paramUri != null) {
      if (paramMap != null)
        try {
        
        } finally {
          paramUri = null;
          paramUri.printStackTrace();
        }  
      return;
    } 
    throw new IOException("parseUrl url is null !!!");
  }
  
  private static boolean a(Map<String, List<String>> paramMap, List<Pair<String, List<String>>> paramList, String paramString) throws UnsupportedEncodingException {
    if (TextUtils.isEmpty(paramString))
      return false; 
    if (paramList == null)
      return false; 
    if (paramMap.containsKey(paramString)) {
      paramList.add(new Pair(paramString, paramMap.get(paramString)));
      if (!a.c())
        paramMap.remove(paramString); 
      return true;
    } 
    return false;
  }
  
  public static interface a {
    boolean a();
    
    boolean b();
    
    boolean c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */