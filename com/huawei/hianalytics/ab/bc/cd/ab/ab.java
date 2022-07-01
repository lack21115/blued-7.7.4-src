package com.huawei.hianalytics.ab.bc.cd.ab;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ab {
  static Map<String, ef> bc = new HashMap<String, ef>();
  
  private static ab cd;
  
  private de ab = new de();
  
  public static ab cd() {
    if (cd == null)
      de(); 
    return cd;
  }
  
  private static void de() {
    // Byte code:
    //   0: ldc com/huawei/hianalytics/ab/bc/cd/ab/ab
    //   2: monitorenter
    //   3: getstatic com/huawei/hianalytics/ab/bc/cd/ab/ab.cd : Lcom/huawei/hianalytics/ab/bc/cd/ab/ab;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/hianalytics/ab/bc/cd/ab/ab
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/hianalytics/ab/bc/cd/ab/ab.cd : Lcom/huawei/hianalytics/ab/bc/cd/ab/ab;
    //   19: ldc com/huawei/hianalytics/ab/bc/cd/ab/ab
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/huawei/hianalytics/ab/bc/cd/ab/ab
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
  }
  
  public ef ab(String paramString) {
    return bc.get(paramString);
  }
  
  public Set<String> ab() {
    return bc.keySet();
  }
  
  public void ab(String paramString, ef paramef) {
    bc.put(paramString, paramef);
  }
  
  public de bc() {
    return this.ab;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\cd\ab\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */