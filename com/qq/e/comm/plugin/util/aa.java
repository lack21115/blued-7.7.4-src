package com.qq.e.comm.plugin.util;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.e.a;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class aa {
  private static volatile String a;
  
  private static volatile String b;
  
  public static String a() {
    String str = "";
    try {
      Context context = GDTADManager.getInstance().getAppContext();
      String str2 = GDTADManager.getInstance().getSM().getString("markets");
      if (StringUtil.isEmpty(str2))
        return ""; 
      if (b != null && b.equals(str2))
        return a; 
      String str1 = str;
      return str1;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String a(Context paramContext, Map<Integer, String> paramMap) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<Integer, String> entry : paramMap.entrySet()) {
      if (a.a(paramContext, (String)entry.getValue())) {
        stringBuilder.append(",");
        stringBuilder.append(entry.getKey());
      } 
    } 
    return (stringBuilder.length() > 1) ? stringBuilder.substring(1) : "";
  }
  
  private static Map<Integer, String> a(String[] paramArrayOfString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = paramArrayOfString.length;
    int i = 0;
    while (true) {
      if (i < j) {
        String str = paramArrayOfString[i];
        if (!StringUtil.isEmpty(str)) {
          String[] arrayOfString = str.split(":");
          if (arrayOfString.length == 2)
            try {
              hashMap.put(Integer.valueOf(Integer.parseInt(arrayOfString[0])), arrayOfString[1]);
            } finally {} 
        } 
        i++;
        continue;
      } 
      return (Map)hashMap;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */