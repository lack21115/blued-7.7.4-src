package com.baidu.mobads;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdSettings {
  private static HashSet<String> a = new HashSet<String>();
  
  private static JSONArray b = new JSONArray();
  
  private static String c;
  
  private static String d;
  
  private static String e;
  
  private static String f;
  
  private static String g;
  
  private static String h;
  
  private static String i;
  
  private static String j;
  
  private static HashSet<String> k = new HashSet<String>();
  
  private static JSONArray l = new JSONArray();
  
  private static JSONObject m = new JSONObject();
  
  public static JSONObject getAttr() {
    JSONObject jSONObject = new JSONObject();
    Iterator<String> iterator = a.iterator();
    b = new JSONArray();
    while (iterator.hasNext())
      b.put(iterator.next()); 
    try {
      jSONObject.putOpt("KEY", b);
      jSONObject.putOpt("RPT", j);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public static String getSupportHttps() {
    return j;
  }
  
  @Deprecated
  public static void setBirthday(Calendar paramCalendar) {
    if (paramCalendar == null)
      return; 
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2) + 1;
    int k = paramCalendar.get(5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("");
    d = stringBuilder.toString();
    if (j > 0 && j < 10) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append("0");
      stringBuilder.append(j);
      d = stringBuilder.toString();
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append(j);
      d = stringBuilder.toString();
    } 
    if (k > 0 && k < 10) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append("0");
      stringBuilder.append(k);
      d = stringBuilder.toString();
      return;
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append(d);
    stringBuilder.append(k);
    d = stringBuilder.toString();
  }
  
  @Deprecated
  public static void setCity(String paramString) {
    e = paramString;
  }
  
  @Deprecated
  public static void setEducation(a parama) {
    if (parama == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parama.a());
    stringBuilder.append("");
    h = stringBuilder.toString();
  }
  
  @Deprecated
  public static void setHob(List<String> paramList) {
    k.addAll(paramList);
  }
  
  @Deprecated
  public static void setHob(String[] paramArrayOfString) {
    for (int i = 0; i < paramArrayOfString.length; i++)
      k.add(paramArrayOfString[i]); 
  }
  
  @Deprecated
  public static void setJob(String paramString) {
    g = paramString;
  }
  
  @Deprecated
  public static void setKey(List<String> paramList) {
    a.addAll(paramList);
  }
  
  @Deprecated
  public static void setKey(String[] paramArrayOfString) {
    for (int i = 0; i < paramArrayOfString.length; i++)
      a.add(paramArrayOfString[i]); 
  }
  
  @Deprecated
  public static void setSalary(c paramc) {
    if (paramc == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramc.a());
    stringBuilder.append("");
    i = stringBuilder.toString();
  }
  
  @Deprecated
  public static void setSex(d paramd) {
    if (paramd == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramd.a());
    stringBuilder.append("");
    c = stringBuilder.toString();
  }
  
  public static void setSupportHttps(boolean paramBoolean) {
    if (paramBoolean) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(b.c.a());
      stringBuilder1.append("");
      j = stringBuilder1.toString();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.b.a());
    stringBuilder.append("");
    j = stringBuilder.toString();
  }
  
  @Deprecated
  public static void setUserAttr(String paramString1, String paramString2) {
    try {
      m.put(paramString1, paramString2);
      return;
    } catch (JSONException jSONException) {
      return;
    } 
  }
  
  @Deprecated
  public static void setZip(String paramString) {
    f = paramString;
  }
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.c.a());
    stringBuilder.append("");
    j = stringBuilder.toString();
  }
  
  @Deprecated
  public enum a {
    a(0),
    b(1),
    c(2),
    d(3),
    e(4),
    f(5),
    g(6);
    
    private int h;
    
    a(int param1Int1) {
      this.h = param1Int1;
    }
    
    public int a() {
      return this.h;
    }
  }
  
  @Deprecated
  public enum b {
    a(0),
    b(1),
    c(2);
    
    private int d;
    
    b(int param1Int1) {
      this.d = param1Int1;
    }
    
    public String a() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.d);
      stringBuilder.append("");
      return stringBuilder.toString();
    }
  }
  
  @Deprecated
  public enum c {
    a(0),
    b(1),
    c(2),
    d(3),
    e(4),
    f(5),
    g(6),
    h(7),
    i(8),
    j(9),
    k(10),
    l(11),
    m(12);
    
    private int n;
    
    c(int param1Int1) {
      this.n = param1Int1;
    }
    
    public int a() {
      return this.n;
    }
  }
  
  @Deprecated
  public enum d {
    a(0),
    b(1);
    
    private int c;
    
    d(int param1Int1) {
      this.c = param1Int1;
    }
    
    public int a() {
      return this.c;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\AdSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */