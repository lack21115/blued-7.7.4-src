package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.Map;

public class n<T> {
  public final T a = null;
  
  public final com.bytedance.sdk.adnet.face.a.a b = null;
  
  public final VAdError c;
  
  public boolean d = false;
  
  public long e = 0L;
  
  public long f = 0L;
  
  public Map<String, Object> g;
  
  public long h = 0L;
  
  private n(VAdError paramVAdError) {
    this.c = paramVAdError;
    if (this.h == 0L && paramVAdError != null && paramVAdError.a != null)
      this.h = paramVAdError.a.a; 
  }
  
  private n(T paramT, com.bytedance.sdk.adnet.face.a.a parama) {
    this.c = null;
  }
  
  public static <T> n<T> a(VAdError paramVAdError) {
    return new n<T>(paramVAdError);
  }
  
  public static <T> n<T> a(T paramT, com.bytedance.sdk.adnet.face.a.a parama) {
    return new n<T>(paramT, parama);
  }
  
  public n a(long paramLong) {
    this.e = paramLong;
    return this;
  }
  
  public Object a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      Map<String, Object> map = this.g;
      if (map != null)
        return map.get(paramString); 
    } 
    return null;
  }
  
  public String a(String paramString1, String paramString2) {
    com.bytedance.sdk.adnet.face.a.a a1 = this.b;
    if (a1 != null) {
      if (a1.h == null)
        return paramString2; 
      paramString1 = (String)this.b.h.get(paramString1);
      return (paramString1 != null) ? paramString1 : paramString2;
    } 
    return paramString2;
  }
  
  public boolean a() {
    return (this.c == null);
  }
  
  public n b(long paramLong) {
    this.f = paramLong;
    return this;
  }
  
  public static interface a<T> {
    void a(n<T> param1n);
    
    void b(n<T> param1n);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */