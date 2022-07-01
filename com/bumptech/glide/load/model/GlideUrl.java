package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class GlideUrl implements Key {
  private final Headers b;
  
  private final URL c = null;
  
  private final String d;
  
  private String e;
  
  private URL f;
  
  private volatile byte[] g;
  
  private int h;
  
  public GlideUrl(String paramString) {
    this(paramString, Headers.b);
  }
  
  public GlideUrl(String paramString, Headers paramHeaders) {
    this.d = Preconditions.a(paramString);
    this.b = (Headers)Preconditions.a(paramHeaders);
  }
  
  public GlideUrl(URL paramURL) {
    this(paramURL, Headers.b);
  }
  
  public GlideUrl(URL paramURL, Headers paramHeaders) {
    this.d = null;
    this.b = (Headers)Preconditions.a(paramHeaders);
  }
  
  private URL e() throws MalformedURLException {
    if (this.f == null)
      this.f = new URL(f()); 
    return this.f;
  }
  
  private String f() {
    if (TextUtils.isEmpty(this.e)) {
      String str2 = this.d;
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = ((URL)Preconditions.a(this.c)).toString(); 
      this.e = Uri.encode(str1, "@#&=*+-_.,:!?()/~'%;$");
    } 
    return this.e;
  }
  
  private byte[] g() {
    if (this.g == null)
      this.g = d().getBytes(a); 
    return this.g;
  }
  
  public URL a() throws MalformedURLException {
    return e();
  }
  
  public void a(MessageDigest paramMessageDigest) {
    paramMessageDigest.update(g());
  }
  
  public String b() {
    return f();
  }
  
  public Map<String, String> c() {
    return this.b.a();
  }
  
  public String d() {
    String str = this.d;
    return (str != null) ? str : ((URL)Preconditions.a(this.c)).toString();
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof GlideUrl;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (d().equals(paramObject.d())) {
        bool1 = bool2;
        if (this.b.equals(((GlideUrl)paramObject).b))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    if (this.h == 0) {
      this.h = d().hashCode();
      this.h = this.h * 31 + this.b.hashCode();
    } 
    return this.h;
  }
  
  public String toString() {
    return d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\GlideUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */