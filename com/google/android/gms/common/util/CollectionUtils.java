package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CollectionUtils {
  public static boolean isEmpty(Collection<?> paramCollection) {
    return (paramCollection == null) ? true : paramCollection.isEmpty();
  }
  
  @Deprecated
  public static <T> List<T> listOf() {
    return Collections.emptyList();
  }
  
  @Deprecated
  public static <T> List<T> listOf(T paramT) {
    return Collections.singletonList(paramT);
  }
  
  @Deprecated
  public static <T> List<T> listOf(T... paramVarArgs) {
    int i = paramVarArgs.length;
    return (i != 0) ? ((i != 1) ? Collections.unmodifiableList(Arrays.asList(paramVarArgs)) : listOf(paramVarArgs[0])) : listOf();
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    Map<?, ?> map = zzb(3, false);
    map.put(paramK1, paramV1);
    map.put(paramK2, paramV2);
    map.put(paramK3, paramV3);
    return Collections.unmodifiableMap((Map)map);
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6) {
    Map<?, ?> map = zzb(6, false);
    map.put(paramK1, paramV1);
    map.put(paramK2, paramV2);
    map.put(paramK3, paramV3);
    map.put(paramK4, paramV4);
    map.put(paramK5, paramV5);
    map.put(paramK6, paramV6);
    return Collections.unmodifiableMap((Map)map);
  }
  
  public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV) {
    if (paramArrayOfK.length == paramArrayOfV.length) {
      int k = paramArrayOfK.length;
      if (k != 0) {
        int m = 0;
        if (k != 1) {
          Map<?, ?> map = zzb(paramArrayOfK.length, false);
          while (m < paramArrayOfK.length) {
            map.put(paramArrayOfK[m], paramArrayOfV[m]);
            m++;
          } 
          return Collections.unmodifiableMap((Map)map);
        } 
        return Collections.singletonMap(paramArrayOfK[0], paramArrayOfV[0]);
      } 
      return Collections.emptyMap();
    } 
    int i = paramArrayOfK.length;
    int j = paramArrayOfV.length;
    StringBuilder stringBuilder = new StringBuilder(66);
    stringBuilder.append("Key and values array lengths not equal: ");
    stringBuilder.append(i);
    stringBuilder.append(" != ");
    stringBuilder.append(j);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt) {
    return (Set<T>)((paramInt == 0) ? new ArraySet() : zza(paramInt, true));
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3) {
    Set<?> set = zza(3, false);
    set.add(paramT1);
    set.add(paramT2);
    set.add(paramT3);
    return Collections.unmodifiableSet((Set)set);
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T... paramVarArgs) {
    int i = paramVarArgs.length;
    if (i != 0) {
      T t;
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              Set<?> set2 = zza(paramVarArgs.length, false);
              Collections.addAll(set2, (Object[])paramVarArgs);
              return Collections.unmodifiableSet((Set)set2);
            } 
            T t2 = paramVarArgs[0];
            T t3 = paramVarArgs[1];
            T t4 = paramVarArgs[2];
            t = paramVarArgs[3];
            Set<?> set1 = zza(4, false);
            set1.add(t2);
            set1.add(t3);
            set1.add(t4);
            set1.add(t);
            return Collections.unmodifiableSet((Set)set1);
          } 
          return setOf(t[0], t[1], t[2]);
        } 
        T t1 = t[0];
        t = t[1];
        Set<?> set = zza(2, false);
        set.add(t1);
        set.add(t);
        return Collections.unmodifiableSet((Set)set);
      } 
      return Collections.singleton(t[0]);
    } 
    return Collections.emptySet();
  }
  
  private static <T> Set<T> zza(int paramInt, boolean paramBoolean) {
    float f;
    char c;
    if (paramBoolean) {
      f = 0.75F;
    } else {
      f = 1.0F;
    } 
    if (paramBoolean) {
      c = '';
    } else {
      c = 'Ā';
    } 
    return (Set<T>)((paramInt <= c) ? new ArraySet(paramInt) : new HashSet<T>(paramInt, f));
  }
  
  private static <K, V> Map<K, V> zzb(int paramInt, boolean paramBoolean) {
    return (Map<K, V>)((paramInt <= 256) ? new ArrayMap(paramInt) : new HashMap<K, V>(paramInt, 1.0F));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\CollectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */