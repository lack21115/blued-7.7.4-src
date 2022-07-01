package com.datavisor.vangogh.d;

import android.content.Context;
import android.os.Environment;
import com.datavisor.vangogh.b.b;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.bridge.storage;
import com.datavisor.vangogh.c.a;
import com.datavisor.vangogh.e.a;
import com.datavisor.vangogh.e.b.a;
import com.datavisor.vangogh.f.a;
import com.datavisor.vangogh.f.b;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.f;
import com.datavisor.vangogh.f.g.a;
import com.datavisor.vangogh.f.h.a;
import com.datavisor.vangogh.f.i.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class c {
  private static c a = null;
  
  private Context b = null;
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private Map<String, String> f;
  
  private AtomicBoolean g = new AtomicBoolean(false);
  
  static {
    String str = a.a;
  }
  
  private c(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      return;
    } 
    throw new IllegalArgumentException("DVIDManger initialization error: mContext is null.");
  }
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/d/c.a : Lcom/datavisor/vangogh/d/c;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/d/c
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/d/c.a : Lcom/datavisor/vangogh/d/c;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/d/c
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/d/c.a : Lcom/datavisor/vangogh/d/c;
    //   26: ldc com/datavisor/vangogh/d/c
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/d/c
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/d/c.a : Lcom/datavisor/vangogh/d/c;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(Map<String, String> paramMap, boolean paramBoolean) {
    if (f.b(this.c))
      paramMap.put("u1", this.c); 
    if (f.b(this.d))
      paramMap.put("u2", this.d); 
    if (paramBoolean && f.b(this.e))
      paramMap.put("event_name", this.e); 
    Map<String, String> map = this.f;
    if (map != null && !map.isEmpty()) {
      map = new HashMap<String, String>(this.f);
      String str = map.get("appExternKey");
      if (map.containsKey("appExternKey") && !f.a(str)) {
        paramMap.put("u3", str);
        map.remove("appExternKey");
      } 
      if (!map.isEmpty())
        paramMap.put("e1", a.b(map).toString()); 
    } 
  }
  
  private void b() {
    String str1 = b.b(this.b);
    String str2 = b.a(this.b);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (f.b(str1))
      hashMap.put("netException", str1); 
    if (f.b(str2))
      hashMap.put("overallException", str2); 
    if (!hashMap.isEmpty()) {
      if (f.b(this.c))
        hashMap.put("app_access_key", this.c); 
      hashMap.put("sdk_version", "2.1.1.20200509_Android");
      hashMap.put("os", "Android");
      str1 = e.a(this.b).a(crypto.convert("H6i37Q=="));
      if (f.b(str1))
        hashMap.put("dvid", str1); 
      str1 = b.a().c(this.b, "wlan0");
      if (f.b(str1) && !str1.equals("no_permission") && !str1.equals("para_err") && !str1.equals("empty") && !str1.equals("exception"))
        hashMap.put("mac", str1); 
      str1 = b.a().i(this.b);
      if (f.b(str1) && !str1.equals("empty") && !str1.equals("exception") && !str1.equals("para_err") && !str1.equals("default"))
        hashMap.put("aid", str1); 
      str1 = b.a().k(this.b);
      if (f.b(str1) && !str1.equals("exception"))
        hashMap.put("uuid", str1); 
      byte[] arrayOfByte2 = crypto.encryptV(a.b(hashMap).toString().getBytes());
      if (arrayOfByte2 == null)
        return; 
      byte[] arrayOfByte3 = crypto.sign(arrayOfByte2);
      if (arrayOfByte3 == null)
        return; 
      byte[] arrayOfByte1 = new byte[arrayOfByte2.length + arrayOfByte3.length];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
      System.arraycopy(arrayOfByte3, 0, arrayOfByte1, arrayOfByte2.length, arrayOfByte3.length);
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
      hashMap1.put("c", "1");
      if ((b.c(hashMap1, arrayOfByte1, this.b)).c == 0)
        b.c(this.b); 
    } 
  }
  
  private int c() {
    for (int i = 0;; i++) {
      if (i >= 60 || b.a().w(this.b)) {
        boolean bool;
        if (i >= 60)
          return 13; 
        b();
        b.a(this.b).a(this.c);
        if (!b.a(this.b).b("main"))
          return 0; 
        if (h()) {
          bool = g();
        } else {
          bool = d();
        } 
        if (!bool)
          return 0; 
        a a = m();
        if (a.d == 0)
          e.a(this.b).a(a); 
        return a.d;
      } 
      try {
        Thread.sleep(2000L);
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  private boolean d() {
    boolean bool1;
    boolean bool2;
    String str = e.a(this.b).a(crypto.convert("H6iqxnPZqQ=="));
    boolean bool5 = e();
    boolean bool6 = f();
    boolean bool4 = f.a(str);
    boolean bool3 = false;
    if (bool6) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool4) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    a.a = bool5 | false | bool1 | bool2;
    if (bool5 || bool6 || bool4)
      bool3 = true; 
    return bool3;
  }
  
  private boolean e() {
    String str1 = a.a(a.b(a.a(this.b, this.c)).toString());
    if (f.a(str1))
      return true; 
    String str2 = a.a(this.b, "DVSPNEEDUPLOAD");
    if (!f.a(str2)) {
      if (str2.equals(str1)) {
        d.a("=========Equallllll,no need to upload");
        return false;
      } 
      d.a("=========not hit, need to upload");
    } 
    a.a(this.b, "DVSPNEEDUPLOAD", str1);
    return true;
  }
  
  private boolean f() {
    long l = a.d(this.b, "DVSPDVMA");
    return (l < 0L) ? true : ((System.currentTimeMillis() > l));
  }
  
  private boolean g() {
    boolean bool1;
    long l = a.d(this.b, "DVSPDVMA");
    boolean bool2 = false;
    if (l < 0L || System.currentTimeMillis() > l + 2592000000L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (f.a(e.a(this.b).a(crypto.convert("H6iqxnPZqQ=="))) || bool1)
      bool2 = true; 
    return bool2;
  }
  
  private boolean h() {
    String str = a.a(this.b, "DVSPDVDE");
    if (f.a(str))
      return false; 
    try {
      JSONArray jSONArray = new JSONArray(str);
      int i = 0;
      while (true)
        return false; 
    } finally {
      str = null;
    } 
  }
  
  private void i() {
    try {
      String str = a.b(crypto.convert("dI6MxnuTtMUDVttzEf8a"));
      if (f.b(str)) {
        str = str.toLowerCase();
        storage.globalSet(crypto.convert("H6ih/XXMmPAdX5dBI+oF8QZ9zqL6"), str);
      } 
      str = Environment.getExternalStorageDirectory().getAbsolutePath();
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void j() {
    storage.globalSet(crypto.convert("H6ih/XXMmPAdX5dBI+oF8QZ9zqL6"), "");
    storage.globalSet(crypto.convert("H6ih/XXMmPMrc5VsFNA59i1Y"), "");
    storage.globalSet(crypto.convert("H6ih/XXMmO4KRLN/BOo="), "");
  }
  
  private void k() {
    try {
      String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void l() {
    storage.globalSet(crypto.convert("H6ih/XXMmPMrc5VsFNA59i1Y"), "");
    storage.globalSet(crypto.convert("H6ih/XXMmO4KRLN/BOo="), "");
  }
  
  private a m() {
    Map<String, String> map1 = a.a(this.b, this.c);
    Map<String, String> map2 = a.a(this.b);
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    hashMap2.putAll(map1);
    hashMap2.putAll(map2);
    a((Map)hashMap2, false);
    byte[] arrayOfByte1 = crypto.encryptVV(a.b(hashMap2).toString(), 0);
    a a = new a();
    if (arrayOfByte1 == null) {
      boolean bool = true;
      a.d = bool;
      return a;
    } 
    byte[] arrayOfByte2 = crypto.sign(arrayOfByte1);
    if (arrayOfByte2 == null) {
      byte b = 2;
      a.d = b;
      return a;
    } 
    byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    hashMap1.put("c", "1");
    com.datavisor.vangogh.f.i.c c1 = b.a(hashMap1, arrayOfByte3, this.b);
    return new a(this.b, c1);
  }
  
  public int a(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap) {
    if (f.a(paramString2) || f.a(paramString3))
      return 8; 
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString1;
    this.f = paramMap;
    if (!this.g.get()) {
      int i = a(paramString2, paramString3, paramMap);
      if (i != 0)
        return i; 
    } 
    if (!b.a(this.b).b("main"))
      return 0; 
    paramString1 = e.a(this.b).a(crypto.convert("H6i37Q=="));
    paramString2 = e.a(this.b).a(crypto.convert("H6iqxnPZqQ=="));
    if (f.a(paramString1) && f.a(paramString2))
      return 12; 
    k();
    Map<String, String> map = a.b(this.b);
    a(map, true);
    byte[] arrayOfByte2 = crypto.encryptVV(a.b(map).toString(), 0);
    l();
    if (arrayOfByte2 == null)
      return 1; 
    byte[] arrayOfByte3 = crypto.sign(arrayOfByte2);
    if (arrayOfByte3 == null)
      return 2; 
    byte[] arrayOfByte1 = new byte[arrayOfByte2.length + arrayOfByte3.length];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte1, arrayOfByte2.length, arrayOfByte3.length);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("c", "1");
    com.datavisor.vangogh.f.i.c c1 = b.d(hashMap, arrayOfByte1, this.b);
    if (c1.c == 0) {
      d.a(this.b);
    } else {
      d.a(this.b, (Map)hashMap, arrayOfByte1);
    } 
    return c1.c;
  }
  
  public int a(String paramString1, String paramString2, Map<String, String> paramMap) {
    if (f.a(paramString1) || f.a(paramString2))
      return 8; 
    if (this.g.get())
      return 0; 
    this.c = paramString1;
    this.d = paramString2;
    this.f = paramMap;
    i();
    int i = c();
    j();
    if (i == 0)
      this.g.set(true); 
    a.a();
    return i;
  }
  
  public String a() {
    String str2 = e.a(this.b).a(crypto.convert("H6iqxnPZqQ=="));
    String str1 = str2;
    if (a.a(str2))
      str1 = ""; 
    return str1;
  }
  
  static {
    System.loadLibrary("dedge");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */