package com.amap.api.mapcore2d;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

abstract class ei extends ClassLoader {
  protected final Context a;
  
  protected final Map<String, Class<?>> b = new HashMap<String, Class<?>>();
  
  protected DexFile c = null;
  
  volatile boolean d = true;
  
  protected da e;
  
  protected String f;
  
  protected volatile boolean g = false;
  
  protected volatile boolean h = false;
  
  public ei(Context paramContext, da paramda, boolean paramBoolean) {
    super(paramContext.getClassLoader());
    this.a = paramContext;
    this.e = paramda;
  }
  
  public boolean a() {
    return (this.c != null);
  }
  
  protected void b() {
    try {
    
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */