package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.kl.gh;
import com.huawei.hianalytics.ab.fg.cd;
import com.huawei.hianalytics.hms.ab;
import java.util.LinkedHashMap;

public abstract class a {
  private static cd a;
  
  public static void a() {
    if (c() != null && gh.bc().ab())
      a.ab(-1); 
  }
  
  public static void a(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap) {
    if (c() != null && gh.bc().ab()) {
      if (paramInt == 1 || paramInt == 0) {
        a.ab(paramInt, paramString, paramLinkedHashMap);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Data type no longer collects range.type: ");
      stringBuilder.append(paramInt);
      ab.de("hmsSdk", stringBuilder.toString());
      return;
    } 
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2) {
    if (c() != null)
      a.ab(paramContext, paramString1, paramString2); 
  }
  
  public static boolean b() {
    return ab.cd().ab();
  }
  
  private static cd c() {
    // Byte code:
    //   0: ldc com/huawei/hms/stats/a
    //   2: monitorenter
    //   3: getstatic com/huawei/hms/stats/a.a : Lcom/huawei/hianalytics/ab/fg/cd;
    //   6: ifnonnull -> 18
    //   9: invokestatic cd : ()Lcom/huawei/hianalytics/hms/ab;
    //   12: invokevirtual bc : ()Lcom/huawei/hianalytics/ab/fg/cd;
    //   15: putstatic com/huawei/hms/stats/a.a : Lcom/huawei/hianalytics/ab/fg/cd;
    //   18: getstatic com/huawei/hms/stats/a.a : Lcom/huawei/hianalytics/ab/fg/cd;
    //   21: astore_0
    //   22: ldc com/huawei/hms/stats/a
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: ldc com/huawei/hms/stats/a
    //   30: monitorexit
    //   31: aload_0
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	27	finally
    //   18	22	27	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\stats\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */