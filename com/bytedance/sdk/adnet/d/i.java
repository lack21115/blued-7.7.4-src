package com.bytedance.sdk.adnet.d;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class i {
  private final Map<String, List<String>> a = new LinkedHashMap<String, List<String>>();
  
  private String b = null;
  
  public i() {}
  
  public i(String paramString) {}
  
  private String b(String paramString1, String paramString2) {
    if (paramString2 == null)
      paramString2 = "ISO-8859-1"; 
    try {
      return URLEncoder.encode(paramString1, paramString2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new IllegalArgumentException(unsupportedEncodingException);
    } 
  }
  
  public String a() {
    if (this.a.isEmpty())
      return this.b; 
    String str3 = a(this.a, "UTF-8");
    String str2 = this.b;
    String str1 = str3;
    if (str2 != null) {
      str1 = str3;
      if (str2.length() != 0) {
        StringBuilder stringBuilder;
        if (this.b.indexOf('?') >= 0) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(this.b);
          str2 = "&";
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append(this.b);
          str2 = "?";
        } 
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        str1 = stringBuilder.toString();
      } 
    } 
    return str1;
  }
  
  public String a(Map<String, List<String>> paramMap, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    while (true) {
      if (!iterator.hasNext())
        return stringBuilder.toString(); 
      Map.Entry entry = iterator.next();
      String str = b((String)entry.getKey(), paramString);
      List list = (List)entry.getValue();
      if (list != null && list.size() > 0)
        for (String str1 : list) {
          if (str1 != null) {
            str1 = b(str1, paramString);
          } else {
            str1 = "";
          } 
          if (stringBuilder.length() > 0)
            stringBuilder.append("&"); 
          stringBuilder.append(str);
          if (!str1.isEmpty()) {
            stringBuilder.append("=");
            stringBuilder.append(str1);
          } 
        }  
    } 
  }
  
  public void a(String paramString, double paramDouble) {
    List<String> list2 = this.a.get(paramString);
    List<String> list1 = list2;
    if (list2 == null)
      list1 = new LinkedList(); 
    list1.add(String.valueOf(paramDouble));
    this.a.put(paramString, list1);
  }
  
  public void a(String paramString, int paramInt) {
    List<String> list2 = this.a.get(paramString);
    List<String> list1 = list2;
    if (list2 == null)
      list1 = new LinkedList(); 
    list1.add(String.valueOf(paramInt));
    this.a.put(paramString, list1);
  }
  
  public void a(String paramString1, String paramString2) {
    List<String> list2 = this.a.get(paramString1);
    List<String> list1 = list2;
    if (list2 == null)
      list1 = new LinkedList(); 
    list1.add(String.valueOf(paramString2));
    this.a.put(paramString1, list1);
  }
  
  public String toString() {
    return a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */