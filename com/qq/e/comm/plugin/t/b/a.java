package com.qq.e.comm.plugin.t.b;

import android.net.Uri;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class a implements e {
  private boolean a = true;
  
  private boolean b = true;
  
  private int c;
  
  private int d;
  
  private String e;
  
  private Map<String, String> f = new HashMap<String, String>();
  
  private Map<String, String> g = new HashMap<String, String>();
  
  private Map<String, String> h = Collections.unmodifiableMap(this.f);
  
  private Map<String, String> i = Collections.unmodifiableMap(this.g);
  
  private e.a j;
  
  private byte[] k;
  
  public a(String paramString, e.a parama, byte[] paramArrayOfbyte) {
    this.e = paramString;
    this.j = parama;
    if (paramArrayOfbyte == null) {
      this.k = null;
      return;
    } 
    this.k = (byte[])paramArrayOfbyte.clone();
  }
  
  public a(String paramString, Map<String, String> paramMap, e.a parama) {
    this.e = paramString;
    this.j = parama;
    if (e.a.b == parama) {
      StringBuilder stringBuilder = new StringBuilder();
      try {
        Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
        while (true) {
          boolean bool = iterator.hasNext();
          if (bool) {
            Map.Entry entry = iterator.next();
            String str1 = URLEncoder.encode((String)entry.getKey(), "utf-8");
            String str2 = URLEncoder.encode((String)entry.getValue(), "utf-8");
            if (stringBuilder.length() > 0)
              stringBuilder.append("&"); 
            stringBuilder.append(str1);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            continue;
          } 
          if (stringBuilder.length() > 0) {
            this.k = stringBuilder.toString().getBytes("utf-8");
            a("Content-Type", "application/x-www-form-urlencoded");
            return;
          } 
          break;
        } 
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw new IllegalArgumentException(unsupportedEncodingException);
      } 
    } 
  }
  
  public void a(String paramString1, String paramString2) {
    if (!StringUtil.isEmpty(paramString1)) {
      if (StringUtil.isEmpty(paramString2))
        return; 
      this.f.put(paramString1, paramString2);
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public byte[] a() throws Exception {
    return this.k;
  }
  
  public e.a b() {
    return this.j;
  }
  
  public void b(String paramString1, String paramString2) {
    this.g.put(paramString1, paramString2);
  }
  
  public void b(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public String c() {
    return this.e;
  }
  
  public Map<String, String> d() {
    return this.h;
  }
  
  public Map<String, String> e() {
    return this.i;
  }
  
  public String f() {
    if (e().isEmpty())
      return c(); 
    Uri.Builder builder = Uri.parse(c()).buildUpon();
    for (Map.Entry<String, String> entry : e().entrySet())
      builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()); 
    return builder.build().toString();
  }
  
  public int g() {
    return this.c;
  }
  
  public int h() {
    return this.d;
  }
  
  public boolean i() {
    return this.b;
  }
  
  public boolean j() {
    return this.a;
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    if (b() == e.a.a) {
      str = "get ";
    } else {
      str = "post ";
    } 
    stringBuilder2.append(str);
    stringBuilder2.append("url, ");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append(f());
    if (b() == e.a.b)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" , ");
        stringBuilder.append(URLDecoder.decode(new String(this.k, Charset.forName("utf-8"))));
        stringBuilder1.append(stringBuilder.toString());
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return stringBuilder1.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */