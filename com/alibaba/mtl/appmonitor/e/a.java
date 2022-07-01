package com.alibaba.mtl.appmonitor.e;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.s;
import com.alibaba.mtl.log.model.LogField;
import java.util.Map;

public class a {
  private static final String TAG;
  
  private static a a;
  
  public static a a() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/e/a
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/appmonitor/e/a.a : Lcom/alibaba/mtl/appmonitor/e/a;
    //   6: ifnonnull -> 19
    //   9: new com/alibaba/mtl/appmonitor/e/a
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/alibaba/mtl/appmonitor/e/a.a : Lcom/alibaba/mtl/appmonitor/e/a;
    //   19: getstatic com/alibaba/mtl/appmonitor/e/a.a : Lcom/alibaba/mtl/appmonitor/e/a;
    //   22: astore_0
    //   23: ldc com/alibaba/mtl/appmonitor/e/a
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/alibaba/mtl/appmonitor/e/a
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public void a(Map<String, String> paramMap) {
    if (paramMap == null)
      return; 
    i.a(TAG, new Object[] { "[sendToUT]:", " args:", paramMap });
    if (com.alibaba.mtl.log.a.r) {
      if (paramMap != null) {
        String str1 = paramMap.get(LogField.ARG1.toString());
        String str2 = paramMap.get(LogField.ARG2.toString());
        String str3 = paramMap.get(LogField.ARG3.toString());
        com.alibaba.mtl.log.a.a(paramMap.get(LogField.PAGE.toString()), paramMap.get(LogField.EVENTID.toString()), str1, str2, str3, paramMap);
        return;
      } 
    } else {
      paramMap.put("_fuamf", "yes");
      s.send(paramMap);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */