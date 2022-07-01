package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class c extends a {
  protected HashMap<String, byte[]> d = null;
  
  private HashMap<String, Object> e = new HashMap<String, Object>();
  
  private i f = new i();
  
  public <T> void a(String paramString, T paramT) {
    byte[] arrayOfByte;
    if (this.d != null) {
      if (paramString != null) {
        if (paramT != null) {
          if (!(paramT instanceof java.util.Set)) {
            j j = new j();
            j.a(this.b);
            j.a(paramT, 0);
            arrayOfByte = l.a(j.a());
            this.d.put(paramString, arrayOfByte);
            return;
          } 
          throw new IllegalArgumentException("can not support Set");
        } 
        throw new IllegalArgumentException("put value can not is null");
      } 
      throw new IllegalArgumentException("put key can not is null");
    } 
    super.a(paramString, arrayOfByte);
  }
  
  public void a(byte[] paramArrayOfbyte) {
    try {
      super.a(paramArrayOfbyte);
      return;
    } catch (Exception exception) {
      this.f.a(paramArrayOfbyte);
      this.f.a(this.b);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
      hashMap.put("", new byte[0]);
      this.d = this.f.a(hashMap, 0, false);
      return;
    } 
  }
  
  public byte[] a() {
    if (this.d != null) {
      j j = new j(0);
      j.a(this.b);
      j.a(this.d, 0);
      return l.a(j.a());
    } 
    return super.a();
  }
  
  public final <T> T b(String paramString, T paramT) throws b {
    HashMap<String, byte[]> hashMap = this.d;
    if (hashMap != null) {
      if (!hashMap.containsKey(paramString))
        return null; 
      if (this.e.containsKey(paramString))
        return (T)this.e.get(paramString); 
      byte[] arrayOfByte1 = this.d.get(paramString);
      try {
        this.f.a(arrayOfByte1);
        this.f.a(this.b);
        paramT = this.f.a(paramT, 0, true);
        if (paramT != null)
          this.e.put(paramString, paramT); 
        return paramT;
      } catch (Exception exception) {
        throw new b(exception);
      } 
    } 
    if (!this.a.containsKey(exception))
      return null; 
    if (this.e.containsKey(exception))
      return (T)this.e.get(exception); 
    HashMap hashMap1 = this.a.get(exception);
    byte[] arrayOfByte = new byte[0];
    Iterator<Map.Entry> iterator = hashMap1.entrySet().iterator();
    if (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      entry.getKey();
      arrayOfByte = (byte[])entry.getValue();
    } 
    try {
      this.f.a(arrayOfByte);
      this.f.a(this.b);
      paramT = this.f.a(paramT, 0, true);
      this.e.put(exception, paramT);
      return paramT;
    } catch (Exception exception1) {
      throw new b(exception1);
    } 
  }
  
  public void c() {
    this.d = (HashMap)new HashMap<String, byte>();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */