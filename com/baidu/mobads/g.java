package com.baidu.mobads;

import java.util.HashMap;

public class g {
  private static g a;
  
  private static HashMap<String, String> b = new HashMap<String, String>();
  
  public static g a() {
    // Byte code:
    //   0: ldc com/baidu/mobads/g
    //   2: monitorenter
    //   3: getstatic com/baidu/mobads/g.a : Lcom/baidu/mobads/g;
    //   6: ifnonnull -> 19
    //   9: new com/baidu/mobads/g
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/baidu/mobads/g.a : Lcom/baidu/mobads/g;
    //   19: getstatic com/baidu/mobads/g.a : Lcom/baidu/mobads/g;
    //   22: astore_0
    //   23: ldc com/baidu/mobads/g
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/baidu/mobads/g
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public int a(int paramInt) {
    int k = 1;
    int i = 1;
    if (paramInt < 1)
      return 1; 
    int j = k;
    try {
      HashMap<String, String> hashMap = b;
      j = k;
      StringBuilder stringBuilder = new StringBuilder();
      j = k;
      stringBuilder.append(paramInt);
      j = k;
      stringBuilder.append("");
      j = k;
      if (hashMap.containsKey(stringBuilder.toString())) {
        j = k;
        hashMap = b;
        j = k;
        stringBuilder = new StringBuilder();
        j = k;
        stringBuilder.append(paramInt);
        j = k;
        stringBuilder.append("");
        j = k;
        k = Integer.parseInt(hashMap.get(stringBuilder.toString())) + 1;
        if (k >= 1)
          i = k; 
        j = i;
        hashMap = b;
        j = i;
        stringBuilder = new StringBuilder();
        j = i;
        stringBuilder.append(paramInt);
        j = i;
        stringBuilder.append("");
        j = i;
        String str = stringBuilder.toString();
        j = i;
        StringBuilder stringBuilder1 = new StringBuilder();
        j = i;
        stringBuilder1.append(i);
        j = i;
        stringBuilder1.append("");
        j = i;
        hashMap.put(str, stringBuilder1.toString());
        return i;
      } 
      j = k;
      hashMap = b;
      j = k;
      stringBuilder = new StringBuilder();
      j = k;
      stringBuilder.append(paramInt);
      j = k;
      stringBuilder.append("");
      j = k;
      hashMap.put(stringBuilder.toString(), "1");
      return 1;
    } catch (Exception exception) {
      return j;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */