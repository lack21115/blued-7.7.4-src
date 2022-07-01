package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LazyHeaders implements Headers {
  private final Map<String, List<LazyHeaderFactory>> c;
  
  private volatile Map<String, String> d;
  
  LazyHeaders(Map<String, List<LazyHeaderFactory>> paramMap) {
    this.c = Collections.unmodifiableMap(paramMap);
  }
  
  private String a(List<LazyHeaderFactory> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      String str = ((LazyHeaderFactory)paramList.get(i)).a();
      if (!TextUtils.isEmpty(str)) {
        stringBuilder.append(str);
        if (i != paramList.size() - 1)
          stringBuilder.append(','); 
      } 
    } 
    return stringBuilder.toString();
  }
  
  private Map<String, String> b() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.c.entrySet()) {
      String str = a((List<LazyHeaderFactory>)entry.getValue());
      if (!TextUtils.isEmpty(str))
        hashMap.put(entry.getKey(), str); 
    } 
    return (Map)hashMap;
  }
  
  public Map<String, String> a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Ljava/util/Map;
    //   4: ifnonnull -> 37
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield d : Ljava/util/Map;
    //   13: ifnonnull -> 27
    //   16: aload_0
    //   17: aload_0
    //   18: invokespecial b : ()Ljava/util/Map;
    //   21: invokestatic unmodifiableMap : (Ljava/util/Map;)Ljava/util/Map;
    //   24: putfield d : Ljava/util/Map;
    //   27: aload_0
    //   28: monitorexit
    //   29: goto -> 37
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    //   37: aload_0
    //   38: getfield d : Ljava/util/Map;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	32	finally
    //   27	29	32	finally
    //   33	35	32	finally
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof LazyHeaders) {
      paramObject = paramObject;
      return this.c.equals(((LazyHeaders)paramObject).c);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.c.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LazyHeaders{headers=");
    stringBuilder.append(this.c);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static final class Builder {
    private static final String a = b();
    
    private static final Map<String, List<LazyHeaderFactory>> b;
    
    private boolean c = true;
    
    private Map<String, List<LazyHeaderFactory>> d = b;
    
    private boolean e = true;
    
    static {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(2);
      if (!TextUtils.isEmpty(a))
        hashMap.put("User-Agent", Collections.singletonList(new LazyHeaders.StringHeaderFactory(a))); 
      b = Collections.unmodifiableMap(hashMap);
    }
    
    static String b() {
      String str = System.getProperty("http.agent");
      if (TextUtils.isEmpty(str))
        return str; 
      int j = str.length();
      StringBuilder stringBuilder = new StringBuilder(str.length());
      for (int i = 0; i < j; i++) {
        char c = str.charAt(i);
        if ((c > '\037' || c == '\t') && c < '') {
          stringBuilder.append(c);
        } else {
          stringBuilder.append('?');
        } 
      } 
      return stringBuilder.toString();
    }
    
    public LazyHeaders a() {
      this.c = true;
      return new LazyHeaders(this.d);
    }
  }
  
  static final class StringHeaderFactory implements LazyHeaderFactory {
    private final String a;
    
    StringHeaderFactory(String param1String) {
      this.a = param1String;
    }
    
    public String a() {
      return this.a;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof StringHeaderFactory) {
        param1Object = param1Object;
        return this.a.equals(((StringHeaderFactory)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("StringHeaderFactory{value='");
      stringBuilder.append(this.a);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\LazyHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */