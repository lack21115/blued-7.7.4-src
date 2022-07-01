package com.bytedance.sdk.openadsdk.core.g;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a {
  private static volatile a a;
  
  private String b;
  
  private Map<k, b> c = Collections.synchronizedMap(new HashMap<k, b>());
  
  private Map<String, JSONObject> d = Collections.synchronizedMap(new HashMap<String, JSONObject>());
  
  private AtomicBoolean e = new AtomicBoolean(false);
  
  private Set<String> f = Collections.synchronizedSet(new HashSet<String>());
  
  private Handler g = new Handler(Looper.getMainLooper());
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/g/a.a : Lcom/bytedance/sdk/openadsdk/core/g/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/g/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/g/a.a : Lcom/bytedance/sdk/openadsdk/core/g/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/g/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/g/a.a : Lcom/bytedance/sdk/openadsdk/core/g/a;
    //   25: ldc com/bytedance/sdk/openadsdk/core/g/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/g/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/g/a.a : Lcom/bytedance/sdk/openadsdk/core/g/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    String[] arrayOfString = paramString.split("\\?");
    String str = paramString;
    if (arrayOfString != null) {
      str = paramString;
      if (arrayOfString.length == 2) {
        String str1 = paramString;
        if (arrayOfString[0] != null) {
          str1 = paramString;
          if (arrayOfString[0].endsWith("/"))
            str1 = paramString.substring(0, arrayOfString.length - 1); 
        } 
        str = str1;
        if (arrayOfString[0] != null) {
          str = str1;
          if (arrayOfString[0].endsWith("index.html"))
            str = arrayOfString[0]; 
        } 
      } 
    } 
    return str.replace("index.html", "");
  }
  
  private JSONObject a(File paramFile, boolean paramBoolean) {
    if (paramFile != null)
      try {
        if (paramFile.exists() && paramFile.isFile() && paramFile.canRead()) {
          byte[] arrayOfByte = k.d(paramFile);
          if (arrayOfByte != null && arrayOfByte.length > 0) {
            String str = com.bytedance.sdk.openadsdk.core.a.b(new String(arrayOfByte), com.bytedance.sdk.openadsdk.core.b.d());
            if (!TextUtils.isEmpty(str)) {
              JSONObject jSONObject = new JSONObject(str);
              if (paramBoolean && jSONObject.length() > 0)
                this.d.put(paramFile.getParentFile().getName(), jSONObject); 
              return jSONObject;
            } 
          } 
        } 
      } finally {} 
    return null;
  }
  
  private void a(a parama, boolean paramBoolean) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      if (parama != null) {
        parama.a(paramBoolean);
        return;
      } 
    } else if (parama != null) {
      this.g.post(new Runnable(this, parama, paramBoolean) {
            public void run() {
              a.a a1 = this.a;
              if (a1 != null)
                a1.a(this.b); 
            }
          });
    } 
  }
  
  private void a(File paramFile) {
    b(paramFile);
    try {
      return;
    } finally {
      paramFile = null;
    } 
  }
  
  private boolean a(String paramString1, String paramString2, File paramFile) {
    if (paramFile != null) {
      if (!paramFile.exists())
        return false; 
      JSONObject jSONObject = this.d.get(paramString1);
      if (jSONObject == null)
        return false; 
      String str = jSONObject.optString(paramString2);
      if (str != null)
        return !!str.equalsIgnoreCase(j.a(paramFile)); 
    } 
    return false;
  }
  
  private void b(File paramFile) {
    try {
      return;
    } finally {
      paramFile = null;
    } 
  }
  
  private String c() {
    File file = new File(d(), "games");
    if (!file.exists())
      file.mkdirs(); 
    return file.getAbsolutePath();
  }
  
  private boolean c(File paramFile) {
    if (paramFile != null && paramFile.isDirectory()) {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null && arrayOfString.length > 0)
        return Arrays.<String>asList(arrayOfString).contains("index.html"); 
    } 
    return false;
  }
  
  private String d() {
    if (TextUtils.isEmpty(this.b))
      try {
      
      } finally {
        Exception exception = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("init root path error: ");
        stringBuilder.append(exception);
      }  
    return this.b;
  }
  
  public WebResourceResponse a(String paramString1, String paramString2, String paramString3) {
    try {
      if (!this.e.get())
        return null; 
    } finally {
      paramString1 = null;
    } 
    return null;
  }
  
  public void a(k paramk, a parama) {
    if (paramk == null || paramk.z() == null || TextUtils.isEmpty(paramk.z().i())) {
      b.a(o.a(), paramk, -701, (String)null);
      a(parama, false);
      return;
    } 
    String str1 = paramk.z().i();
    if (this.f.contains(str1))
      return; 
    this.c.put(paramk, (new b()).a(System.currentTimeMillis()));
    b.a(o.a(), paramk);
    String str2 = j.a(str1);
    File file = new File(c(), str2);
    if (c(file)) {
      b.a(o.a(), paramk, -702, (String)null);
      b(file);
      this.c.remove(paramk);
      a(parama, true);
      return;
    } 
    try {
      k.c(file);
    } finally {
      Exception exception;
    } 
    this.f.add(str1);
    e.a(o.a()).a(str1, new com.bytedance.sdk.adnet.b.b.a(this, str2, str1, paramk, file, parama) {
          public File a(String param1String) {
            return null;
          }
          
          public void a(long param1Long1, long param1Long2) {}
          
          public void a(n<File> param1n) {
            a.d(this.f).remove(this.b);
            a.b b = (a.b)a.e(this.f).remove(this.c);
            if (b != null)
              b.b(System.currentTimeMillis()); 
            if (param1n != null && param1n.a != null) {
              com.bytedance.sdk.openadsdk.i.a.a().c(new Runnable(this, b, param1n) {
                    public void run() {
                      boolean bool = true;
                      try {
                        long l1;
                        long l2;
                        if (this.a != null)
                          this.a.c(System.currentTimeMillis()); 
                        al.a(((File)this.b.a).getAbsolutePath(), a.a(this.c.f));
                        if (this.a != null)
                          this.a.d(System.currentTimeMillis()); 
                        if (this.a != null) {
                          l1 = this.a.a();
                          l2 = this.a.b();
                        } else {
                          l2 = 0L;
                          l1 = l2;
                        } 
                      } finally {
                        Exception exception = null;
                        t.c("PlayableCache", "unzip error: ", exception);
                        b.a(o.a(), this.c.c, -704, exception.getMessage());
                      } 
                      try {
                        ((File)this.b.a).delete();
                      } finally {
                        Exception exception;
                      } 
                      a.a(this.c.f, this.c.e, bool);
                    }
                  }5);
              return;
            } 
            short s = -700;
            int i = s;
            if (param1n != null) {
              i = s;
              if (param1n.h != 0L)
                i = Long.valueOf(param1n.h).intValue(); 
            } 
            b.a(o.a(), this.c, i, (String)null);
            a.a(this.f, this.e, false);
          }
          
          public void a(String param1String, File param1File) {}
          
          public File b(String param1String) {
            param1String = a.c(this.f);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".zip");
            return new File(param1String, stringBuilder.toString());
          }
          
          public void b(n<File> param1n) {
            a.d(this.f).remove(this.b);
            a.e(this.f).remove(this.c);
            short s = -700;
            String str2 = null;
            int i = s;
            String str1 = str2;
            if (param1n != null) {
              int j;
              if (param1n.h != 0L) {
                j = Long.valueOf(param1n.h).intValue();
              } else {
                j = s;
                if (param1n.c != null) {
                  j = s;
                  if (param1n.c.a != null) {
                    j = s;
                    if (param1n.c.a.a != 0)
                      j = param1n.c.a.a; 
                  } 
                } 
              } 
              i = j;
              str1 = str2;
              if (param1n.c != null) {
                str1 = param1n.c.getMessage();
                i = j;
              } 
            } 
            b.a(o.a(), this.c, i, str1);
            a.a(this.f, this.e, false);
          }
        });
  }
  
  public boolean a(k paramk) {
    if (!this.e.get())
      return false; 
    if (paramk != null && paramk.z() != null) {
      if (paramk.z().i() == null)
        return false; 
      try {
        return ((JSONObject)this.d.get(str) == null) ? false : c(new File(c(), str));
      } finally {
        paramk = null;
      } 
    } 
    return false;
  }
  
  public void b() {
    if (!this.e.get())
      com.bytedance.sdk.openadsdk.i.a.a().c(new Runnable(this) {
            public void run() {
              try {
                String str = a.a(this.a);
                if (!TextUtils.isEmpty(str)) {
                  File file = new File(str);
                  if (file.exists() && file.isDirectory()) {
                    File[] arrayOfFile = file.listFiles();
                    if (arrayOfFile != null) {
                      int j = arrayOfFile.length;
                      int i = 0;
                      while (true) {
                        if (i < j) {
                          File file1 = arrayOfFile[i];
                          try {
                            file1 = new File(file1, "tt_open_ad_sdk_check_res.dat");
                            a.a(this.a, file1, true);
                          } finally {}
                          i++;
                          continue;
                        } 
                        a.b(this.a).set(true);
                        return;
                      } 
                    } 
                  } 
                } 
              } finally {
                Exception exception;
              } 
              a.b(this.a).set(true);
            }
          }5); 
  }
  
  public static interface a {
    void a(boolean param1Boolean);
  }
  
  static class b {
    long a;
    
    long b;
    
    long c;
    
    long d;
    
    private b() {}
    
    public long a() {
      return this.b - this.a;
    }
    
    public b a(long param1Long) {
      this.a = param1Long;
      return this;
    }
    
    public long b() {
      return this.d - this.c;
    }
    
    public b b(long param1Long) {
      this.b = param1Long;
      return this;
    }
    
    public b c(long param1Long) {
      this.c = param1Long;
      return this;
    }
    
    public b d(long param1Long) {
      this.d = param1Long;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */