package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public final class o extends t {
  private String b;
  
  private byte[] c;
  
  private String d;
  
  private ArrayList<Header> e;
  
  private Map<String, String> f;
  
  private boolean g;
  
  public o(String paramString) {
    this.b = paramString;
    this.e = new ArrayList<Header>();
    this.f = new HashMap<String, String>();
    this.d = "application/x-www-form-urlencoded";
  }
  
  public final String a() {
    return this.b;
  }
  
  public final void a(String paramString) {
    this.d = paramString;
  }
  
  public final void a(String paramString1, String paramString2) {
    if (this.f == null)
      this.f = new HashMap<String, String>(); 
    this.f.put(paramString1, paramString2);
  }
  
  public final void a(Header paramHeader) {
    this.e.add(paramHeader);
  }
  
  public final void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    this.c = paramArrayOfbyte;
  }
  
  public final String b(String paramString) {
    Map<String, String> map = this.f;
    return (map == null) ? null : map.get(paramString);
  }
  
  public final byte[] b() {
    return this.c;
  }
  
  public final String c() {
    return this.d;
  }
  
  public final ArrayList<Header> d() {
    return this.e;
  }
  
  public final boolean e() {
    return this.g;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    byte[] arrayOfByte = this.c;
    if (arrayOfByte == null) {
      if (((o)paramObject).c != null)
        return false; 
    } else if (!arrayOfByte.equals(((o)paramObject).c)) {
      return false;
    } 
    String str = this.b;
    paramObject = ((o)paramObject).b;
    if (str == null) {
      if (paramObject != null)
        return false; 
    } else if (!str.equals(paramObject)) {
      return false;
    } 
    return true;
  }
  
  public final int hashCode() {
    byte b;
    int i;
    Map<String, String> map = this.f;
    if (map != null && map.containsKey("id")) {
      b = ((String)this.f.get("id")).hashCode() + 31;
    } else {
      b = 1;
    } 
    String str = this.b;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    return b * 31 + i;
  }
  
  public final String toString() {
    return String.format("Url : %s,HttpHeader: %s", new Object[] { this.b, this.e });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */