package com.bytedance.sdk.adnet.face;

import com.bytedance.sdk.adnet.core.Header;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface a {
  a a(String paramString);
  
  void a();
  
  void a(String paramString, a parama);
  
  public static class a {
    public int a;
    
    public byte[] b;
    
    public String c;
    
    public long d;
    
    public long e;
    
    public long f;
    
    public long g;
    
    public Map<String, String> h = Collections.emptyMap();
    
    public List<Header> i;
    
    public boolean a() {
      return (this.f < System.currentTimeMillis());
    }
    
    public boolean b() {
      return (this.g < System.currentTimeMillis());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\face\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */