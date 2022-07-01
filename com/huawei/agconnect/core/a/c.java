package com.huawei.agconnect.core.a;

import com.huawei.agconnect.core.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
  private Map<Class<?>, Service> a = new HashMap<Class<?>, Service>();
  
  private Map<Class<?>, Object> b = new HashMap<Class<?>, Object>();
  
  c(List<Service> paramList) {
    if (paramList == null)
      return; 
    for (Service service : paramList)
      this.a.put(service.a(), service); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\core\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */