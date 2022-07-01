package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainerUtils {
  public static final String FIELD_DELIMITER = "&";
  
  public static final String KEY_VALUE_DELIMITER = "=";
  
  public static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2) {
    if (paramMap1 == paramMap2)
      return true; 
    boolean bool = false;
    if (paramMap1 != null && paramMap2 != null && paramMap1.size() == paramMap2.size()) {
      boolean bool1;
      Iterator<Map.Entry> iterator = paramMap1.entrySet().iterator();
      while (true) {
        bool1 = bool;
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          if (paramMap2.get(entry.getKey()) != entry.getValue()) {
            bool1 = true;
            break;
          } 
          continue;
        } 
        break;
      } 
      return bool1 ^ true;
    } 
    return false;
  }
  
  public static <K, V> int hashCode(Map<K, V> paramMap) {
    return toString(paramMap).hashCode();
  }
  
  public static <K> String toString(List<K> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 7
    //   4: ldc ''
    //   6: areturn
    //   7: new java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_2
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_0
    //   18: invokeinterface iterator : ()Ljava/util/Iterator;
    //   23: astore_0
    //   24: aload_0
    //   25: invokeinterface hasNext : ()Z
    //   30: ifeq -> 67
    //   33: aload_0
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: astore_3
    //   40: iload_1
    //   41: ifle -> 51
    //   44: aload_2
    //   45: ldc '&'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: iload_1
    //   61: iconst_1
    //   62: iadd
    //   63: istore_1
    //   64: goto -> 24
    //   67: aload_2
    //   68: invokevirtual toString : ()Ljava/lang/String;
    //   71: areturn
  }
  
  public static <K, V> String toString(Map<K, V> paramMap) {
    if (paramMap == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      if (i)
        stringBuilder.append("&"); 
      stringBuilder.append(entry.getKey().toString());
      stringBuilder.append("=");
      stringBuilder.append(entry.getValue().toString());
      i++;
    } 
    return stringBuilder.toString();
  }
  
  public static <K> String toString(Set<K> paramSet) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 7
    //   4: ldc ''
    //   6: areturn
    //   7: new java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_2
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_0
    //   18: invokeinterface iterator : ()Ljava/util/Iterator;
    //   23: astore_0
    //   24: aload_0
    //   25: invokeinterface hasNext : ()Z
    //   30: ifeq -> 67
    //   33: aload_0
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: astore_3
    //   40: iload_1
    //   41: ifle -> 51
    //   44: aload_2
    //   45: ldc '&'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: iload_1
    //   61: iconst_1
    //   62: iadd
    //   63: istore_1
    //   64: goto -> 24
    //   67: aload_2
    //   68: invokevirtual toString : ()Ljava/lang/String;
    //   71: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\ContainerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */