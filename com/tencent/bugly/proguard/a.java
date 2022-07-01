package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {
  private static Proxy e;
  
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap<String, HashMap<String, byte[]>>();
  
  protected String b;
  
  i c;
  
  private HashMap<String, Object> d;
  
  a() {
    new HashMap<Object, Object>();
    this.d = new HashMap<String, Object>();
    this.b = "GBK";
    this.c = new i();
  }
  
  public static aj a(int paramInt) {
    return (aj)((paramInt == 1) ? new ai() : ((paramInt == 3) ? new ah() : null));
  }
  
  public static ap a(Context paramContext, int paramInt, byte[] paramArrayOfbyte) {
    com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.b();
    StrategyBean strategyBean = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    if (a1 == null || strategyBean == null) {
      x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
      return null;
    } 
    try {
    
    } finally {
      paramContext = null;
      if (!x.b((Throwable)paramContext))
        paramContext.printStackTrace(); 
    } 
    return (ap)SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  public static aq a(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramArrayOfbyte != null)
      try {
        d d = new d();
        d.c();
        d.a("utf-8");
        d.a(paramArrayOfbyte);
        paramArrayOfbyte = d.b("detail", new aq());
        if (aq.class.isInstance(paramArrayOfbyte)) {
          aq aq = aq.class.cast(paramArrayOfbyte);
        } else {
          paramArrayOfbyte = null;
        } 
        return (aq)paramArrayOfbyte;
      } finally {
        paramArrayOfbyte = null;
      }  
    return null;
  }
  
  public static at a(UserInfoBean paramUserInfoBean) {
    boolean bool;
    if (paramUserInfoBean == null)
      return null; 
    at at = new at();
    at.a = paramUserInfoBean.e;
    at.e = paramUserInfoBean.j;
    at.d = paramUserInfoBean.c;
    at.c = paramUserInfoBean.d;
    at.g = com.tencent.bugly.crashreport.common.info.a.b().i();
    if (paramUserInfoBean.o == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    at.h = bool;
    int j = paramUserInfoBean.b;
    if (j != 1) {
      if (j != 2) {
        if (j != 3) {
          if (j != 4) {
            if (paramUserInfoBean.b >= 10 && paramUserInfoBean.b < 20) {
              at.b = (byte)paramUserInfoBean.b;
            } else {
              x.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(paramUserInfoBean.b) });
              return null;
            } 
          } else {
            at.b = 3;
          } 
        } else {
          at.b = 2;
        } 
      } else {
        at.b = 4;
      } 
    } else {
      at.b = 1;
    } 
    at.f = new HashMap<String, String>();
    if (paramUserInfoBean.p >= 0) {
      Map<String, String> map1 = at.f;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramUserInfoBean.p);
      map1.put("C01", stringBuilder1.toString());
    } 
    if (paramUserInfoBean.q >= 0) {
      Map<String, String> map1 = at.f;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramUserInfoBean.q);
      map1.put("C02", stringBuilder1.toString());
    } 
    if (paramUserInfoBean.r != null && paramUserInfoBean.r.size() > 0)
      for (Map.Entry entry : paramUserInfoBean.r.entrySet()) {
        Map<String, String> map1 = at.f;
        StringBuilder stringBuilder1 = new StringBuilder("C03_");
        stringBuilder1.append((String)entry.getKey());
        map1.put(stringBuilder1.toString(), (String)entry.getValue());
      }  
    if (paramUserInfoBean.s != null && paramUserInfoBean.s.size() > 0)
      for (Map.Entry entry : paramUserInfoBean.s.entrySet()) {
        Map<String, String> map1 = at.f;
        StringBuilder stringBuilder1 = new StringBuilder("C04_");
        stringBuilder1.append((String)entry.getKey());
        map1.put(stringBuilder1.toString(), (String)entry.getValue());
      }  
    Map<String, String> map = at.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserInfoBean.l ^ true);
    map.put("A36", stringBuilder.toString());
    map = at.f;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserInfoBean.g);
    map.put("F02", stringBuilder.toString());
    map = at.f;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserInfoBean.h);
    map.put("F03", stringBuilder.toString());
    map = at.f;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserInfoBean.j);
    map.put("F04", stringBuilder.toString());
    map = at.f;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserInfoBean.i);
    map.put("F05", stringBuilder.toString());
    map = at.f;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserInfoBean.m);
    map.put("F06", stringBuilder.toString());
    map = at.f;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserInfoBean.k);
    map.put("F10", stringBuilder.toString());
    x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(at.b), Integer.valueOf(at.f.size()) });
    return at;
  }
  
  public static au a(List<UserInfoBean> paramList, int paramInt) {
    if (paramList != null) {
      if (paramList.size() == 0)
        return null; 
      com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.b();
      if (a1 == null)
        return null; 
      a1.t();
      au au = new au();
      au.b = a1.d;
      au.c = a1.h();
      ArrayList<at> arrayList = new ArrayList();
      Iterator<UserInfoBean> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        at at = a(iterator.next());
        if (at != null)
          arrayList.add(at); 
      } 
      au.d = arrayList;
      au.e = new HashMap<String, String>();
      Map<String, String> map = au.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a1.g);
      map.put("A7", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.s());
      map.put("A6", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.r());
      map.put("A5", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.p());
      map.put("A2", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.p());
      map.put("A1", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.i);
      map.put("A24", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.q());
      map.put("A17", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.w());
      map.put("A15", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.x());
      map.put("A13", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.w);
      map.put("F08", stringBuilder.toString());
      map = au.e;
      stringBuilder = new StringBuilder();
      stringBuilder.append(a1.x);
      map.put("F09", stringBuilder.toString());
      map = a1.G();
      if (map != null && map.size() > 0)
        for (Map.Entry<String, String> entry : map.entrySet()) {
          Map<String, String> map1 = au.e;
          StringBuilder stringBuilder1 = new StringBuilder("C04_");
          stringBuilder1.append((String)entry.getKey());
          map1.put(stringBuilder1.toString(), (String)entry.getValue());
        }  
      if (paramInt != 1) {
        if (paramInt != 2) {
          x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
          return null;
        } 
        au.a = 2;
        return au;
      } 
      au.a = 1;
      return au;
    } 
    return null;
  }
  
  public static <T extends k> T a(byte[] paramArrayOfbyte, Class<T> paramClass) {
    if (paramArrayOfbyte != null) {
      if (paramArrayOfbyte.length <= 0)
        return null; 
      try {
        k k = (k)paramClass.newInstance();
        i i1 = new i(paramArrayOfbyte);
        i1.a("utf-8");
        return (T)k;
      } finally {
        paramArrayOfbyte = null;
      } 
    } 
    return null;
  }
  
  public static String a(ArrayList<String> paramArrayList) {
    StringBuffer stringBuffer = new StringBuffer();
    int j = 0;
    while (true) {
      int k = paramArrayList.size();
      String str = "map";
      if (j < k) {
        String str1 = paramArrayList.get(j);
        if (str1.equals("java.lang.Integer") || str1.equals("int")) {
          str = "int32";
        } else if (str1.equals("java.lang.Boolean") || str1.equals("boolean")) {
          str = "bool";
        } else if (str1.equals("java.lang.Byte") || str1.equals("byte")) {
          str = "char";
        } else if (str1.equals("java.lang.Double") || str1.equals("double")) {
          str = "double";
        } else if (str1.equals("java.lang.Float") || str1.equals("float")) {
          str = "float";
        } else if (str1.equals("java.lang.Long") || str1.equals("long")) {
          str = "int64";
        } else if (str1.equals("java.lang.Short") || str1.equals("short")) {
          str = "short";
        } else if (!str1.equals("java.lang.Character")) {
          if (str1.equals("java.lang.String")) {
            str = "string";
          } else if (str1.equals("java.util.List")) {
            str = "list";
          } else if (!str1.equals("java.util.Map")) {
            str = str1;
          } 
        } else {
          throw new IllegalArgumentException("can not support java.lang.Character");
        } 
        paramArrayList.set(j, str);
        j++;
        continue;
      } 
      Collections.reverse(paramArrayList);
      for (j = 0; j < paramArrayList.size(); j++) {
        StringBuilder stringBuilder;
        str = paramArrayList.get(j);
        if (str.equals("list")) {
          k = j - 1;
          stringBuilder = new StringBuilder("<");
          stringBuilder.append(paramArrayList.get(k));
          paramArrayList.set(k, stringBuilder.toString());
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramArrayList.get(0));
          stringBuilder.append(">");
          paramArrayList.set(0, stringBuilder.toString());
        } else if (stringBuilder.equals("map")) {
          k = j - 1;
          stringBuilder = new StringBuilder("<");
          stringBuilder.append(paramArrayList.get(k));
          stringBuilder.append(",");
          paramArrayList.set(k, stringBuilder.toString());
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramArrayList.get(0));
          stringBuilder.append(">");
          paramArrayList.set(0, stringBuilder.toString());
        } else if (stringBuilder.equals("Array")) {
          k = j - 1;
          stringBuilder = new StringBuilder("<");
          stringBuilder.append(paramArrayList.get(k));
          paramArrayList.set(k, stringBuilder.toString());
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramArrayList.get(0));
          stringBuilder.append(">");
          paramArrayList.set(0, stringBuilder.toString());
        } 
      } 
      Collections.reverse(paramArrayList);
      Iterator<String> iterator = paramArrayList.iterator();
      while (iterator.hasNext())
        stringBuffer.append(iterator.next()); 
      return stringBuffer.toString();
    } 
  }
  
  public static void a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString)) {
      e = null;
      return;
    } 
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString, paramInt));
  }
  
  public static void a(InetAddress paramInetAddress, int paramInt) {
    if (paramInetAddress == null) {
      e = null;
      return;
    } 
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject) {
    if (paramObject.getClass().isArray()) {
      if (paramObject.getClass().getComponentType().toString().equals("byte")) {
        if (Array.getLength(paramObject) > 0) {
          paramArrayList.add("java.util.List");
          a(paramArrayList, Array.get(paramObject, 0));
          return;
        } 
        paramArrayList.add("Array");
        paramArrayList.add("?");
        return;
      } 
      throw new IllegalArgumentException("only byte[] is supported");
    } 
    if (!(paramObject instanceof Array)) {
      if (paramObject instanceof List) {
        paramArrayList.add("java.util.List");
        paramObject = paramObject;
        if (paramObject.size() > 0) {
          a(paramArrayList, paramObject.get(0));
          return;
        } 
        paramArrayList.add("?");
        return;
      } 
      if (paramObject instanceof Map) {
        paramArrayList.add("java.util.Map");
        Map map = (Map)paramObject;
        if (map.size() > 0) {
          paramObject = map.keySet().iterator().next();
          map = (Map)map.get(paramObject);
          paramArrayList.add(paramObject.getClass().getName());
          a(paramArrayList, map);
          return;
        } 
        paramArrayList.add("?");
        paramArrayList.add("?");
        return;
      } 
      paramArrayList.add(paramObject.getClass().getName());
      return;
    } 
    throw new IllegalArgumentException("can not support Array, please use List");
  }
  
  public static byte[] a(k paramk) {
    try {
      j j = new j();
      return j.b();
    } finally {
      paramk = null;
      if (!x.b((Throwable)paramk))
        paramk.printStackTrace(); 
    } 
  }
  
  public static byte[] a(Object paramObject) {
    try {
      d d = new d();
      d.c();
      d.a("utf-8");
      d.b(1);
      d.b("RqdServer");
      return d.a();
    } finally {
      paramObject = null;
      if (!x.b((Throwable)paramObject))
        paramObject.printStackTrace(); 
    } 
  }
  
  public static Proxy b() {
    return e;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public <T> void a(String paramString, T paramT) {
    if (paramString != null) {
      if (paramT != null) {
        if (!(paramT instanceof java.util.Set)) {
          j j = new j();
          j.a(this.b);
          j.a(paramT, 0);
          byte[] arrayOfByte = l.a(j.a());
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
          ArrayList<String> arrayList = new ArrayList(1);
          a(arrayList, paramT);
          hashMap.put(a(arrayList), arrayOfByte);
          this.d.remove(paramString);
          this.a.put(paramString, hashMap);
          return;
        } 
        throw new IllegalArgumentException("can not support Set");
      } 
      throw new IllegalArgumentException("put value can not is null");
    } 
    throw new IllegalArgumentException("put key can not is null");
  }
  
  public void a(byte[] paramArrayOfbyte) {
    this.c.a(paramArrayOfbyte);
    this.c.a(this.b);
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(1);
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>(1);
    hashMap2.put("", new byte[0]);
    hashMap1.put("", hashMap2);
    this.a = this.c.a(hashMap1, 0, false);
  }
  
  public byte[] a() {
    j j = new j(0);
    j.a(this.b);
    j.a(this.a, 0);
    return l.a(j.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */