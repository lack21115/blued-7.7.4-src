package com.bytedance.sdk.openadsdk.j;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.face.d;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class b implements a {
  private final Context a;
  
  private final f b;
  
  public b(Context paramContext, f paramf) {
    this.a = paramContext;
    this.b = paramf;
  }
  
  private void a(List<e> paramList, String paramString) {
    if (r.b(paramList)) {
      Iterator<e> iterator = paramList.iterator();
      while (iterator.hasNext())
        (new a(iterator.next(), paramString)).executeOnExecutor(com.bytedance.sdk.openadsdk.i.a.a().b(), (Object[])new Void[0]); 
    } 
  }
  
  public static a c() {
    return d.b();
  }
  
  public void a() {}
  
  public void a(String paramString) {
    if (!j.a())
      return; 
    com.bytedance.sdk.openadsdk.i.a.a().d(new Runnable(this, paramString) {
          public void run() {
            List<e> list = b.a(this.b).a();
            (new Handler(Looper.getMainLooper())).post(new Runnable(this, list) {
                  public void run() {
                    b.a(this.b.b, this.a, this.b.a);
                  }
                });
          }
        }1);
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean) {
    if (!j.a())
      return; 
    if (r.b(paramList))
      for (String str : paramList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UUID.randomUUID().toString());
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        (new a(new e(stringBuilder.toString(), str, paramBoolean, 5), paramString)).executeOnExecutor(com.bytedance.sdk.openadsdk.i.a.a().b(), (Object[])new Void[0]);
      }  
  }
  
  public Context b() {
    Context context2 = this.a;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
  
  class a extends AsyncTask<Void, Void, Void> {
    private final e b;
    
    private final String c;
    
    private a(b this$0, e param1e, String param1String) {
      this.b = param1e;
      this.c = param1String;
    }
    
    private String c(String param1String) {
      // Byte code:
      //   0: aload_1
      //   1: astore #4
      //   3: aload_1
      //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   7: ifne -> 167
      //   10: aload_1
      //   11: ldc '{TS}'
      //   13: invokevirtual contains : (Ljava/lang/CharSequence;)Z
      //   16: ifne -> 31
      //   19: aload_1
      //   20: astore #4
      //   22: aload_1
      //   23: ldc '__TS__'
      //   25: invokevirtual contains : (Ljava/lang/CharSequence;)Z
      //   28: ifeq -> 56
      //   31: invokestatic currentTimeMillis : ()J
      //   34: lstore_2
      //   35: aload_1
      //   36: ldc '{TS}'
      //   38: lload_2
      //   39: invokestatic valueOf : (J)Ljava/lang/String;
      //   42: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   45: ldc '__TS__'
      //   47: lload_2
      //   48: invokestatic valueOf : (J)Ljava/lang/String;
      //   51: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   54: astore #4
      //   56: aload #4
      //   58: ldc '{UID}'
      //   60: invokevirtual contains : (Ljava/lang/CharSequence;)Z
      //   63: ifne -> 79
      //   66: aload #4
      //   68: astore_1
      //   69: aload #4
      //   71: ldc '__UID__'
      //   73: invokevirtual contains : (Ljava/lang/CharSequence;)Z
      //   76: ifeq -> 113
      //   79: aload #4
      //   81: astore_1
      //   82: aload_0
      //   83: getfield c : Ljava/lang/String;
      //   86: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   89: ifne -> 113
      //   92: aload #4
      //   94: ldc '{UID}'
      //   96: aload_0
      //   97: getfield c : Ljava/lang/String;
      //   100: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   103: ldc '__UID__'
      //   105: aload_0
      //   106: getfield c : Ljava/lang/String;
      //   109: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   112: astore_1
      //   113: invokestatic a : ()Ljava/lang/String;
      //   116: astore #5
      //   118: aload_1
      //   119: ldc '{OAID}'
      //   121: invokevirtual contains : (Ljava/lang/CharSequence;)Z
      //   124: ifne -> 139
      //   127: aload_1
      //   128: astore #4
      //   130: aload_1
      //   131: ldc '__OAID__'
      //   133: invokevirtual contains : (Ljava/lang/CharSequence;)Z
      //   136: ifeq -> 167
      //   139: aload_1
      //   140: astore #4
      //   142: aload #5
      //   144: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   147: ifne -> 167
      //   150: aload_1
      //   151: ldc '{OAID}'
      //   153: aload #5
      //   155: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   158: ldc '__OAID__'
      //   160: aload #5
      //   162: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   165: astore #4
      //   167: aload #4
      //   169: areturn
    }
    
    protected Void a(Void... param1VarArgs) {
      if (!j.a())
        return null; 
      if (!a(this.b.b()))
        return null; 
      if (this.b.d() == 0) {
        b.a(this.a).c(this.b);
        return null;
      } 
      while (true) {
        if (this.b.d() > 0 && !isCancelled())
          try {
            if (this.b.d() == 5)
              b.a(this.a).a(this.b); 
            if (!w.a(this.a.b()))
              return null; 
            String str2 = c(this.b.b());
            String str1 = str2;
            if (this.b.c())
              str1 = b(str2); 
            i i = i.a();
            (new j(0, str1, (n.a)i)).setRetryPolicy((d)e.b().a(10000)).build(e.a(this.a.b()).d());
            try {
              n n = i.b();
            } finally {
              str1 = null;
            } 
          } finally {
            param1VarArgs = null;
          }  
        return null;
      } 
    }
    
    boolean a(String param1String) {
      return (!TextUtils.isEmpty(param1String) && (param1String.startsWith("http://") || param1String.startsWith("https://")));
    }
    
    String b(String param1String) {
      String str = param1String;
      if (!TextUtils.isEmpty(param1String)) {
        str = param1String;
        try {
          param1String = param1String.replace("[ss_random]", String.valueOf((new Random()).nextLong()));
          str = param1String;
          return param1String.replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
      return str;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */