package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class j {
  public final int a;
  
  public final byte[] b;
  
  public final Map<String, String> c;
  
  public final List<Header> d;
  
  public final boolean e;
  
  public final long f;
  
  private j(int paramInt, byte[] paramArrayOfbyte, Map<String, String> paramMap, List<Header> paramList, boolean paramBoolean, long paramLong) {
    this.a = paramInt;
    this.b = paramArrayOfbyte;
    this.c = paramMap;
    if (paramList == null) {
      this.d = null;
    } else {
      this.d = Collections.unmodifiableList(paramList);
    } 
    this.e = paramBoolean;
    this.f = paramLong;
  }
  
  @Deprecated
  public j(int paramInt, byte[] paramArrayOfbyte, Map<String, String> paramMap, boolean paramBoolean, long paramLong) {
    this(paramInt, paramArrayOfbyte, paramMap, a(paramMap), paramBoolean, paramLong);
  }
  
  public j(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean, long paramLong, List<Header> paramList) {
    this(paramInt, paramArrayOfbyte, a(paramList), paramList, paramBoolean, paramLong);
  }
  
  @Deprecated
  public j(byte[] paramArrayOfbyte, Map<String, String> paramMap) {
    this(200, paramArrayOfbyte, paramMap, false, 0L);
  }
  
  private static List<Header> a(Map<String, String> paramMap) {
    if (paramMap == null)
      return null; 
    if (paramMap.isEmpty())
      return Collections.emptyList(); 
    ArrayList<Header> arrayList = new ArrayList(paramMap.size());
    for (Map.Entry<String, String> entry : paramMap.entrySet())
      arrayList.add(new Header((String)entry.getKey(), (String)entry.getValue())); 
    return arrayList;
  }
  
  private static Map<String, String> a(List<Header> paramList) {
    if (paramList == null)
      return null; 
    if (paramList.isEmpty())
      return Collections.emptyMap(); 
    TreeMap<String, Object> treeMap = new TreeMap<String, Object>(String.CASE_INSENSITIVE_ORDER);
    for (Header header : paramList)
      treeMap.put(header.a(), header.b()); 
    return (Map)treeMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */