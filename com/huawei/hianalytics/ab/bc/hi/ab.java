package com.huawei.hianalytics.ab.bc.hi;

import java.util.HashMap;
import java.util.Map;

public final class ab {
  private static ab bc;
  
  private volatile Map<String, bc> ab = new HashMap<String, bc>();
  
  public static ab ab() {
    if (bc == null)
      bc(); 
    return bc;
  }
  
  private bc bc(String paramString) {
    if (!this.ab.containsKey(paramString)) {
      bc bc = new bc();
      this.ab.put(paramString, bc);
    } 
    return this.ab.get(paramString);
  }
  
  private static void bc() {
    // Byte code:
    //   0: ldc com/huawei/hianalytics/ab/bc/hi/ab
    //   2: monitorenter
    //   3: getstatic com/huawei/hianalytics/ab/bc/hi/ab.bc : Lcom/huawei/hianalytics/ab/bc/hi/ab;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/hianalytics/ab/bc/hi/ab
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/hianalytics/ab/bc/hi/ab.bc : Lcom/huawei/hianalytics/ab/bc/hi/ab;
    //   19: ldc com/huawei/hianalytics/ab/bc/hi/ab
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/huawei/hianalytics/ab/bc/hi/ab
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
  }
  
  public bc ab(String paramString, long paramLong) {
    bc bc = bc(paramString);
    bc.ab(paramLong);
    return bc;
  }
  
  public void ab(String paramString) {
    bc(paramString).ab();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\hi\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */