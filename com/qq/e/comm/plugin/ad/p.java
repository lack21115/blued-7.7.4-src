package com.qq.e.comm.plugin.ad;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public abstract class p {
  private Map<String, Object> a = new HashMap<String, Object>();
  
  private void a(String paramString, Object paramObject) {
    if (paramString != null) {
      if (paramObject == null)
        return; 
      this.a.put(paramString, paramObject);
    } 
  }
  
  public String a(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool)
      return null; 
    Object object = this.a.get(paramString);
    paramString = str;
    if (object != null)
      try {
        return (String)object;
      } catch (ClassCastException classCastException) {
        return null;
      }  
    return (String)classCastException;
  }
  
  public void a(String paramString, int paramInt) {
    a(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2) {
    a(paramString1, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    a(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public int b(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool)
      return 0; 
    paramString = (String)this.a.get(paramString);
    if (paramString != null)
      try {
        return ((Integer)paramString).intValue();
      } catch (ClassCastException classCastException) {
        return 0;
      }  
    return i;
  }
  
  public boolean c(String paramString) {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2)
      return false; 
    paramString = (String)this.a.get(paramString);
    if (paramString != null)
      try {
        return ((Boolean)paramString).booleanValue();
      } catch (ClassCastException classCastException) {
        return false;
      }  
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */