package com.alibaba.mtl.log.model;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.c;
import com.alibaba.mtl.log.e.h;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.n;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a {
  public String T;
  
  public String U = "3";
  
  private String V;
  
  public String W = null;
  
  public String X = "";
  
  public int id;
  
  private Map<String, String> k;
  
  private String u;
  
  private String v;
  
  private String w;
  
  private String x;
  
  public a() {}
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap) {
    this.T = paramString2;
    this.u = paramString1;
    this.v = paramString3;
    this.w = paramString4;
    this.x = paramString5;
    this.k = paramMap;
    this.W = String.valueOf(System.currentTimeMillis());
    s();
  }
  
  public String h() {
    String str = null;
    try {
      byte[] arrayOfByte = c.decode(this.V.getBytes("UTF-8"), 2);
      if (arrayOfByte != null)
        str = new String(n.a(arrayOfByte, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")); 
      return str;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String i() {
    return this.V;
  }
  
  public void j(String paramString) {
    if (paramString != null)
      try {
        this.V = new String(c.encode(n.a(paramString.getBytes(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"), 2), "UTF-8");
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      }  
  }
  
  public void k(String paramString) {
    this.V = paramString;
  }
  
  public void s() {
    if (TextUtils.isEmpty(this.W))
      this.W = String.valueOf(System.currentTimeMillis()); 
    String str = h.a(this.u, this.T, this.v, this.w, this.x, this.k, this.X, this.W);
    i.a("UTLog", new Object[] { this, str });
    j(str);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Log [id=");
    stringBuilder.append(this.id);
    stringBuilder.append(", eventId=");
    stringBuilder.append(this.T);
    stringBuilder.append(", index=");
    stringBuilder.append(this.X);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */