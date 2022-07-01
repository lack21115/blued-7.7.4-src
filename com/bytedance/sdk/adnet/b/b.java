package com.bytedance.sdk.adnet.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class b {
  private final Map<String, b> a;
  
  private final Handler b = new Handler(Looper.getMainLooper());
  
  private final m c;
  
  private Context d;
  
  public b(Context paramContext, m paramm) {
    this.d = paramContext;
    this.c = paramm;
    this.a = Collections.synchronizedMap(new LinkedHashMap<String, b>());
  }
  
  private String a() {
    File file = new File(com.bytedance.sdk.adnet.a.b(this.d), "fileLoader");
    file.mkdirs();
    return file.getAbsolutePath();
  }
  
  private void a(b paramb) {
    if (paramb == null)
      return; 
    paramb.a();
    this.a.put(paramb.a, paramb);
  }
  
  private boolean a(String paramString) {
    return this.a.containsKey(paramString);
  }
  
  private b b(String paramString, a parama, boolean paramBoolean) {
    String str;
    if (parama != null) {
      str = (String)parama.b(paramString);
    } else {
      str = null;
    } 
    if (str == null) {
      str = new String(Base64.encode(paramString.getBytes(), 0));
      str = (new File(a(), str)).getAbsolutePath();
    } else {
      str = str.getAbsolutePath();
    } 
    return new b(this, paramString, str, parama, paramBoolean);
  }
  
  public void a(String paramString, a parama) {
    a(paramString, parama, true);
  }
  
  public void a(String paramString, a parama, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (a(paramString)) {
      b b1 = this.a.get(paramString);
      if (b1 != null) {
        b1.a(parama);
        return;
      } 
    } 
    File file = parama.a(paramString);
    if (file != null && parama != null) {
      this.b.post(new Runnable(this, parama, file) {
            public void run() {
              this.a.a(this.b.length(), this.b.length());
              this.a.a(n.a(this.b, null));
            }
          });
      return;
    } 
    a(b(paramString, parama, paramBoolean));
  }
  
  public static interface a extends c.a {
    File a(String param1String);
    
    void a(String param1String, File param1File);
    
    File b(String param1String);
  }
  
  class b {
    String a;
    
    String b;
    
    List<b.a> c;
    
    boolean d;
    
    c e;
    
    b(b this$0, String param1String1, String param1String2, b.a param1a, boolean param1Boolean) {
      this.a = param1String1;
      this.b = param1String2;
      this.d = param1Boolean;
      a(param1a);
    }
    
    void a() {
      this.e = new c(this.b, this.a, new c.a(this) {
            public void a(long param2Long1, long param2Long2) {
              if (this.a.c != null)
                for (c.a a1 : this.a.c) {
                  try {
                    a1.a(param2Long1, param2Long2);
                  } finally {
                    a1 = null;
                  } 
                }  
            }
            
            public void a(n<File> param2n) {
              if (this.a.c != null) {
                for (b.a a1 : this.a.c) {
                  try {
                  
                  } finally {
                    Exception exception;
                  } 
                } 
                this.a.c.clear();
              } 
              b.a(this.a.f).remove(this.a.a);
            }
            
            public void b(n<File> param2n) {
              if (this.a.c != null) {
                for (c.a a1 : this.a.c) {
                  try {
                    a1.b(param2n);
                  } finally {
                    a1 = null;
                  } 
                } 
                this.a.c.clear();
              } 
              b.a(this.a.f).remove(this.a.a);
            }
          });
      c c1 = this.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FileLoader#");
      stringBuilder.append(this.a);
      c1.setTag(stringBuilder.toString());
      b.b(this.f).a(this.e);
    }
    
    void a(b.a param1a) {
      if (param1a == null)
        return; 
      if (this.c == null)
        this.c = Collections.synchronizedList(new ArrayList<b.a>()); 
      this.c.add(param1a);
    }
    
    public boolean equals(Object param1Object) {
      return (param1Object instanceof b) ? ((b)param1Object).a.equals(this.a) : super.equals(param1Object);
    }
  }
  
  class null implements c.a {
    null(b this$0) {}
    
    public void a(long param1Long1, long param1Long2) {
      if (this.a.c != null)
        for (c.a a1 : this.a.c) {
          try {
            a1.a(param1Long1, param1Long2);
          } finally {
            a1 = null;
          } 
        }  
    }
    
    public void a(n<File> param1n) {
      if (this.a.c != null) {
        for (b.a a1 : this.a.c) {
          try {
          
          } finally {
            Exception exception;
          } 
        } 
        this.a.c.clear();
      } 
      b.a(this.a.f).remove(this.a.a);
    }
    
    public void b(n<File> param1n) {
      if (this.a.c != null) {
        for (c.a a1 : this.a.c) {
          try {
            a1.b(param1n);
          } finally {
            a1 = null;
          } 
        } 
        this.a.c.clear();
      } 
      b.a(this.a.f).remove(this.a.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */