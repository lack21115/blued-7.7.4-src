package com.ishumei.l111l11111lIl;

import android.text.TextUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l111l11111lIl {
  private static final String l1111l111111Il = "sm";
  
  private Map<String, l111l11111I1l> l111l11111I1l;
  
  private Map<String, l111l11111Il> l111l11111Il;
  
  private Map<String, l111l11111lIl> l111l11111lIl;
  
  private Set<String> l111l1111l1Il;
  
  private String l111l1111lI1l;
  
  private String l111l1111lIl;
  
  private List<l1111l111111Il> l111l1111llIl;
  
  private int l111l11IlIlIl = 0;
  
  private boolean l11l1111I11l = true;
  
  private boolean l11l1111I1l = true;
  
  private boolean l11l1111I1ll;
  
  private int l11l1111Il = 50;
  
  private int l11l1111Il1l = 10;
  
  private boolean l11l1111Ill = true;
  
  private String l11l1111lIIl;
  
  private boolean l11l111l11Il;
  
  private int l11l111l1I1l = 2;
  
  private int l11l111l1Il = -1;
  
  private boolean l11l111l1lll;
  
  private int l11l111ll11l = 100;
  
  private int l11l111ll1Il = 10;
  
  private int l11l111lll = 60;
  
  private boolean l11l11IlIIll;
  
  private static Map<String, l111l11111lIl> l1111l111111Il(JSONArray paramJSONArray) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = 0;
    while (true) {
      if (i < paramJSONArray.length()) {
        try {
          JSONObject jSONObject = paramJSONArray.getJSONObject(i);
          l111l11111lIl l111l11111lIl1 = new l111l11111lIl();
          String str = jSONObject.keys().next();
          jSONObject = jSONObject.getJSONObject(str);
          l111l11111lIl1.l1111l111111Il(str);
          l111l11111lIl1.l111l11111lIl(jSONObject.getString("pn"));
          l111l11111lIl1.l111l11111I1l(jSONObject.getString("uri"));
          hashMap.put(l111l11111lIl1.l1111l111111Il(), l111l11111lIl1);
        } catch (JSONException jSONException) {}
        i++;
        continue;
      } 
      return (Map)hashMap;
    } 
  }
  
  private static Set<String> l1111l111111Il(JSONObject paramJSONObject) {
    HashSet<String> hashSet = new HashSet();
    Iterator<String> iterator = paramJSONObject.keys();
    while (true) {
      if (iterator.hasNext()) {
        try {
          String str = iterator.next();
          if (str.startsWith("sensitive.") && paramJSONObject.getBoolean(str))
            hashSet.add(str.split("\\.")[1]); 
        } catch (Exception exception) {}
        continue;
      } 
      return hashSet;
    } 
  }
  
  private void l1111l111111Il(int paramInt) {
    this.l11l111ll11l = paramInt;
  }
  
  private void l1111l111111Il(List<l1111l111111Il> paramList) {
    this.l111l1111llIl = paramList;
  }
  
  private void l1111l111111Il(Map<String, l111l11111lIl> paramMap) {
    this.l111l11111lIl = paramMap;
  }
  
  private void l1111l111111Il(Set<String> paramSet) {
    this.l111l1111l1Il = paramSet;
  }
  
  private void l1111l111111Il(boolean paramBoolean) {
    this.l11l111l1lll = paramBoolean;
  }
  
  public static l111l11111lIl l111l11111I1l(String paramString) {
    l111l11111lIl l111l11111lIl1 = new l111l11111lIl();
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      try {
        l111l11111lIl1.l111l11111lIl = l111l11111I1l(jSONObject.getJSONObject("risk_apps"));
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l11111I1l = l111l11111Il(jSONObject.getJSONObject("risk_dirs"));
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l11111Il = l111l1111l1Il(jSONObject.getJSONObject("white_apps"));
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l1111l1Il = l111l1111llIl(jSONObject.getJSONObject("sensitive"));
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111I11l = jSONObject.getBoolean("core_atamper");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111I1l = jSONObject.getBoolean("all_atamper");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111I1ll = jSONObject.getBoolean("risk_file_switch");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111Ill = jSONObject.getBoolean("upload_checker_switch");
      } catch (Exception exception) {}
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  private static Map<String, l111l11111Il> l111l11111I1l(JSONArray paramJSONArray) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = 0;
    while (true) {
      if (i < paramJSONArray.length()) {
        try {
          JSONObject jSONObject = paramJSONArray.getJSONObject(i);
          l111l11111Il l111l11111Il = new l111l11111Il();
          String str = jSONObject.keys().next();
          jSONObject = jSONObject.getJSONObject(str);
          l111l11111Il.l1111l111111Il(str);
          l111l11111Il.l111l11111lIl(jSONObject.getString("pn"));
          hashMap.put(l111l11111Il.l1111l111111Il(), l111l11111Il);
        } catch (JSONException jSONException) {}
        i++;
        continue;
      } 
      return (Map)hashMap;
    } 
  }
  
  private static Map<String, l111l11111lIl> l111l11111I1l(JSONObject paramJSONObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Iterator<String> iterator = paramJSONObject.keys();
    while (true) {
      if (iterator.hasNext()) {
        try {
          l111l11111lIl l111l11111lIl1 = new l111l11111lIl();
          String str = iterator.next();
          JSONObject jSONObject = paramJSONObject.getJSONObject(str);
          l111l11111lIl1.l1111l111111Il(str);
          l111l11111lIl1.l111l11111lIl(jSONObject.getString("pn"));
          l111l11111lIl1.l111l11111I1l(jSONObject.getString("uri"));
          hashMap.put(l111l11111lIl1.l1111l111111Il(), l111l11111lIl1);
        } catch (Exception exception) {}
        continue;
      } 
      return (Map)hashMap;
    } 
  }
  
  private void l111l11111I1l(int paramInt) {
    this.l11l111lll = paramInt;
  }
  
  private void l111l11111I1l(Map<String, l111l11111Il> paramMap) {
    this.l111l11111Il = paramMap;
  }
  
  private void l111l11111I1l(boolean paramBoolean) {
    this.l11l111l11Il = paramBoolean;
  }
  
  private static Map<String, l111l11111I1l> l111l11111Il(JSONObject paramJSONObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Iterator<String> iterator = paramJSONObject.keys();
    while (true) {
      if (iterator.hasNext()) {
        try {
          l111l11111I1l l111l11111I1l = new l111l11111I1l();
          String str = iterator.next();
          JSONObject jSONObject = paramJSONObject.getJSONObject(str);
          l111l11111I1l.l1111l111111Il(str);
          if (TextUtils.equals("sdcard", jSONObject.getString("type"))) {
            l111l11111I1l.l1111l111111Il(0);
          } else if (TextUtils.equals("absolute", jSONObject.getString("type"))) {
            l111l11111I1l.l1111l111111Il(1);
          } else {
            continue;
          } 
          l111l11111I1l.l111l11111lIl(jSONObject.getString("dir"));
          hashMap.put(l111l11111I1l.l1111l111111Il(), l111l11111I1l);
        } catch (Exception exception) {}
        continue;
      } 
      return (Map)hashMap;
    } 
  }
  
  private void l111l11111Il(int paramInt) {
    this.l111l11IlIlIl = paramInt;
  }
  
  private void l111l11111Il(String paramString) {
    this.l111l1111lIl = paramString;
  }
  
  private void l111l11111Il(boolean paramBoolean) {
    this.l11l1111Ill = paramBoolean;
  }
  
  public static l111l11111lIl l111l11111lIl(String paramString) {
    l111l11111lIl l111l11111lIl1 = new l111l11111lIl();
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      try {
        if (jSONObject.has("usrappcnt"))
          l111l11111lIl1.l11l1111Il = jSONObject.getInt("usrappcnt"); 
        if (jSONObject.has("sysappcnt"))
          l111l11111lIl1.l11l1111Il1l = jSONObject.getInt("sysappcnt"); 
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l11111lIl = l1111l111111Il(jSONObject.getJSONArray("risk_apps"));
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l11111I1l = l111l11111lIl(jSONObject.getJSONArray("risk_dirs"));
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l11111Il = l111l11111I1l(jSONObject.getJSONArray("white_apps"));
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l1111l1Il = l1111l111111Il(jSONObject);
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111I11l = jSONObject.getBoolean("core_atamper");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111I1l = jSONObject.getBoolean("all_atamper");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111I1ll = jSONObject.getBoolean("risk_file_switch");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l1111Ill = jSONObject.getBoolean("upload_checker_switch");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l11IlIIll = jSONObject.getBoolean("hook_switch");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l111l11Il = jSONObject.getBoolean("hook_java_switch");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l111l1lll = jSONObject.optBoolean("ip_cache_switch");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l111l11IlIlIl = jSONObject.getInt("net_max");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l111l1I1l = jSONObject.getInt("re_max");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l111l1Il = jSONObject.getInt("up_max");
      } catch (Exception exception) {}
      try {
        l111l11111lIl1.l11l111lll = jSONObject.optInt("weventt", 60);
        l111l11111lIl1.l11l111ll11l = jSONObject.optInt("weventc", 100);
        l111l11111lIl1.l11l111ll1Il = jSONObject.optInt("weventmax", 10);
      } catch (Exception exception) {}
    } catch (Exception exception) {
      throw new IOException(exception);
    } 
  }
  
  private static Map<String, l111l11111I1l> l111l11111lIl(JSONArray paramJSONArray) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (int i = 0;; i++) {
      if (i < paramJSONArray.length()) {
        try {
          JSONObject jSONObject = paramJSONArray.getJSONObject(i);
          l111l11111I1l l111l11111I1l = new l111l11111I1l();
          String str = jSONObject.keys().next();
          jSONObject = jSONObject.getJSONObject(str);
          l111l11111I1l.l1111l111111Il(str);
          if (TextUtils.equals("sdcard", jSONObject.getString("type"))) {
            l111l11111I1l.l1111l111111Il(0);
          } else if (TextUtils.equals("absolute", jSONObject.getString("type"))) {
            l111l11111I1l.l1111l111111Il(1);
          } else {
            continue;
          } 
          l111l11111I1l.l111l11111lIl(jSONObject.getString("dir"));
          hashMap.put(l111l11111I1l.l1111l111111Il(), l111l11111I1l);
        } catch (JSONException jSONException) {}
        continue;
      } 
      return (Map)hashMap;
    } 
  }
  
  private void l111l11111lIl(int paramInt) {
    this.l11l111ll1Il = paramInt;
  }
  
  private void l111l11111lIl(Map<String, l111l11111I1l> paramMap) {
    this.l111l11111I1l = paramMap;
  }
  
  private void l111l11111lIl(JSONObject paramJSONObject) {
    if (paramJSONObject.has("usrappcnt"))
      this.l11l1111Il = paramJSONObject.getInt("usrappcnt"); 
    if (paramJSONObject.has("sysappcnt"))
      this.l11l1111Il1l = paramJSONObject.getInt("sysappcnt"); 
  }
  
  private void l111l11111lIl(boolean paramBoolean) {
    this.l11l11IlIIll = paramBoolean;
  }
  
  private static Map<String, l111l11111Il> l111l1111l1Il(JSONObject paramJSONObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Iterator<String> iterator = paramJSONObject.keys();
    while (true) {
      if (iterator.hasNext()) {
        try {
          l111l11111Il l111l11111Il = new l111l11111Il();
          String str = iterator.next();
          JSONObject jSONObject = paramJSONObject.getJSONObject(str);
          l111l11111Il.l1111l111111Il(str);
          l111l11111Il.l111l11111lIl(jSONObject.getString("pn"));
          hashMap.put(l111l11111Il.l1111l111111Il(), l111l11111Il);
        } catch (Exception exception) {}
        continue;
      } 
      return (Map)hashMap;
    } 
  }
  
  private void l111l1111l1Il(int paramInt) {
    this.l11l111l1I1l = paramInt;
  }
  
  private void l111l1111l1Il(String paramString) {
    this.l111l1111lI1l = paramString;
  }
  
  private void l111l1111l1Il(boolean paramBoolean) {
    this.l11l1111I1ll = paramBoolean;
  }
  
  private void l111l1111lI1l(int paramInt) {
    this.l11l1111Il = paramInt;
  }
  
  private void l111l1111lI1l(boolean paramBoolean) {
    this.l11l1111I1l = paramBoolean;
  }
  
  private void l111l1111lIl(int paramInt) {
    this.l11l1111Il1l = paramInt;
  }
  
  private static Set<String> l111l1111llIl(JSONObject paramJSONObject) {
    HashSet<String> hashSet = new HashSet();
    Iterator<String> iterator = paramJSONObject.keys();
    while (true) {
      if (iterator.hasNext()) {
        try {
          String str = iterator.next();
          if (paramJSONObject.getBoolean(str))
            hashSet.add(str); 
        } catch (Exception exception) {}
        continue;
      } 
      return hashSet;
    } 
  }
  
  private void l111l1111llIl(int paramInt) {
    this.l11l111l1Il = paramInt;
  }
  
  private void l111l1111llIl(boolean paramBoolean) {
    this.l11l1111I11l = paramBoolean;
  }
  
  private boolean l11l111l1I1l() {
    return this.l11l11IlIIll;
  }
  
  private List<l1111l111111Il> l11l111l1Il() {
    return this.l111l1111llIl;
  }
  
  private boolean l11l111ll11l() {
    return this.l11l1111I1l;
  }
  
  private String l11l111ll1Il() {
    return this.l11l1111lIIl;
  }
  
  public final int l1111l111111Il() {
    return this.l11l111ll11l;
  }
  
  public final void l1111l111111Il(String paramString) {
    this.l11l1111lIIl = paramString;
  }
  
  public final int l111l11111I1l() {
    return this.l11l111lll;
  }
  
  public final int l111l11111Il() {
    return this.l111l11IlIlIl;
  }
  
  public final int l111l11111lIl() {
    return this.l11l111ll1Il;
  }
  
  public final int l111l1111l1Il() {
    return this.l11l111l1I1l;
  }
  
  public final boolean l111l1111lI1l() {
    return this.l11l111l1lll;
  }
  
  public final boolean l111l1111lIl() {
    return this.l11l111l11Il;
  }
  
  public final int l111l1111llIl() {
    return this.l11l111l1Il;
  }
  
  public final Set<String> l111l11IlIlIl() {
    return this.l111l1111l1Il;
  }
  
  public final boolean l11l1111I11l() {
    return this.l11l1111I1ll;
  }
  
  public final int l11l1111I1l() {
    return this.l11l1111Il;
  }
  
  public final int l11l1111I1ll() {
    return this.l11l1111Il1l;
  }
  
  public final boolean l11l1111Il() {
    return this.l11l1111I11l;
  }
  
  public final String l11l1111Il1l() {
    return this.l111l1111lIl;
  }
  
  public final String l11l1111Ill() {
    return this.l111l1111lI1l;
  }
  
  public final boolean l11l1111lIIl() {
    return this.l11l1111Ill;
  }
  
  public final Map<String, l111l11111I1l> l11l111l11Il() {
    return this.l111l11111I1l;
  }
  
  public final Map<String, l111l11111Il> l11l111l1lll() {
    return this.l111l11111Il;
  }
  
  public final Map<String, l111l11111lIl> l11l11IlIIll() {
    return this.l111l11111lIl;
  }
  
  public static final class l1111l111111Il {
    private static int l1111l111111Il = 1;
    
    private static int l111l11111I1l = 3;
    
    private static int l111l11111lIl = 2;
    
    private String l111l11111Il;
    
    private String l111l1111l1Il;
    
    private List<String> l111l1111lI1l;
    
    private int l111l1111lIl;
    
    private String l111l1111llIl;
    
    private String l111l1111l1Il() {
      return this.l111l11111Il;
    }
    
    public final String l1111l111111Il() {
      return this.l111l1111l1Il;
    }
    
    public final void l1111l111111Il(int param1Int) {
      this.l111l1111lIl = param1Int;
    }
    
    public final void l1111l111111Il(String param1String) {
      this.l111l11111Il = param1String;
    }
    
    public final void l1111l111111Il(List<String> param1List) {
      this.l111l1111lI1l = param1List;
    }
    
    public final List<String> l111l11111I1l() {
      return this.l111l1111lI1l;
    }
    
    public final void l111l11111I1l(String param1String) {
      this.l111l1111llIl = param1String;
    }
    
    public final int l111l11111Il() {
      return this.l111l1111lIl;
    }
    
    public final String l111l11111lIl() {
      return this.l111l1111llIl;
    }
    
    public final void l111l11111lIl(String param1String) {
      this.l111l1111l1Il = param1String;
    }
  }
  
  public static final class l111l11111I1l {
    private static int l1111l111111Il = 0;
    
    private static int l111l11111lIl = 1;
    
    private String l111l11111I1l;
    
    private int l111l11111Il;
    
    private String l111l1111l1Il;
    
    public final String l1111l111111Il() {
      return this.l111l11111I1l;
    }
    
    public final void l1111l111111Il(int param1Int) {
      this.l111l11111Il = param1Int;
    }
    
    public final void l1111l111111Il(String param1String) {
      this.l111l11111I1l = param1String;
    }
    
    public final int l111l11111I1l() {
      return this.l111l11111Il;
    }
    
    public final String l111l11111lIl() {
      return this.l111l1111l1Il;
    }
    
    public final void l111l11111lIl(String param1String) {
      this.l111l1111l1Il = param1String;
    }
  }
  
  public static final class l111l11111Il {
    private String l1111l111111Il;
    
    private String l111l11111lIl;
    
    public final String l1111l111111Il() {
      return this.l1111l111111Il;
    }
    
    public final void l1111l111111Il(String param1String) {
      this.l1111l111111Il = param1String;
    }
    
    public final String l111l11111lIl() {
      return this.l111l11111lIl;
    }
    
    public final void l111l11111lIl(String param1String) {
      this.l111l11111lIl = param1String;
    }
  }
  
  public static final class l111l11111lIl {
    private String l1111l111111Il;
    
    private String l111l11111I1l;
    
    private String l111l11111lIl;
    
    private String l111l11111I1l() {
      return this.l111l11111I1l;
    }
    
    public final String l1111l111111Il() {
      return this.l1111l111111Il;
    }
    
    public final void l1111l111111Il(String param1String) {
      this.l1111l111111Il = param1String;
    }
    
    public final void l111l11111I1l(String param1String) {
      this.l111l11111I1l = param1String;
    }
    
    public final String l111l11111lIl() {
      return this.l111l11111lIl;
    }
    
    public final void l111l11111lIl(String param1String) {
      this.l111l11111lIl = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111lIl\l111l11111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */