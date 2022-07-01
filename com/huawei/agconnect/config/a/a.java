package com.huawei.agconnect.config.a;

import android.content.Context;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;

public class a extends AGConnectServicesConfig {
  private final Context a;
  
  private final String b;
  
  private LazyInputStream c;
  
  private volatile b d;
  
  private final Object e = new Object();
  
  public a(Context paramContext, String paramString) {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private static LazyInputStream a(Context paramContext, InputStream paramInputStream) {
    return new LazyInputStream(paramContext, paramInputStream) {
        public InputStream a(Context param1Context) {
          return this.a;
        }
      };
  }
  
  private static String b(String paramString) {
    int k = paramString.length();
    int j = 0;
    int i = 0;
    if (k > 0)
      while (true) {
        j = i;
        if (paramString.charAt(i) == '/') {
          i++;
          continue;
        } 
        break;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('/');
    stringBuilder.append(paramString.substring(j));
    return stringBuilder.toString();
  }
  
  public String a(String paramString) {
    return a(paramString, (String)null);
  }
  
  public String a(String paramString1, String paramString2) {
    if (paramString1 != null) {
      if (this.d == null)
        synchronized (this.e) {
          if (this.d == null)
            if (this.c != null) {
              this.d = new d(this.c.b());
              this.c.a();
              this.c = null;
            } else {
              this.d = new g(this.a, this.b);
            }  
        }  
      paramString1 = b(paramString1);
      return this.d.a(paramString1, paramString2);
    } 
    throw new NullPointerException("path must not be null.");
  }
  
  public void a(LazyInputStream paramLazyInputStream) {
    this.c = paramLazyInputStream;
  }
  
  public void a(InputStream paramInputStream) {
    a(a(this.a, paramInputStream));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */