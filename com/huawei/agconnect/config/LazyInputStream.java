package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.h;
import java.io.InputStream;

public abstract class LazyInputStream {
  private final Context a;
  
  private InputStream b;
  
  public LazyInputStream(Context paramContext) {
    this.a = paramContext;
  }
  
  public abstract InputStream a(Context paramContext);
  
  public final void a() {
    h.a(this.b);
  }
  
  public InputStream b() {
    if (this.b == null)
      this.b = a(this.a); 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\LazyInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */