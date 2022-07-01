package com.huawei.updatesdk.a.b.d;

import com.huawei.updatesdk.a.b.d.c.d;
import com.huawei.updatesdk.service.appmgr.bean.b;
import java.util.HashMap;
import java.util.Map;

public class a {
  private static Map<String, Class> a = (Map)new HashMap<String, Class<?>>();
  
  static {
    a.put("client.updateCheck", b.class);
  }
  
  public static d a(String paramString) throws InstantiationException, IllegalAccessException {
    Class<d> clazz = a.get(paramString);
    if (clazz != null)
      return clazz.newInstance(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ResponseBean class not found, method:");
    stringBuilder.append(paramString);
    throw new InstantiationException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */