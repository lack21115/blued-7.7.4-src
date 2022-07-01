package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.p;
import com.bytedance.sdk.openadsdk.core.h.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

class d {
  private static volatile d a;
  
  private final AtomicLong b = new AtomicLong((o.h().n() * 1000));
  
  private ScheduledFuture<?> c;
  
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private d() {
    (new HandlerThread("TmplDiffManager-Thread")).start();
    this.c = com.bytedance.sdk.openadsdk.i.a.a().a(new a(this, 1), 0L);
  }
  
  public static d a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/d.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/d
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/d.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/d;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/widget/webview/a/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/d.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/d;
    //   25: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/d.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private JSONObject b(String paramString) {
    i i = i.a();
    (new j(0, paramString, (n.a)i)).setShouldCache(false).build(e.a(o.a()).d());
    try {
      n n = i.b();
      if (n != null && n.a() && n.a != null)
        return new JSONObject((String)n.a); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  private void d() {
    List<p> list = c.a().b();
    if (list.isEmpty())
      return; 
    for (p p : list) {
      if (TextUtils.isEmpty(p.d()))
        continue; 
      JSONObject jSONObject = b(p.d());
      if (jSONObject != null) {
        String str1 = jSONObject.optString("md5");
        String str2 = jSONObject.optString("version");
        String str3 = jSONObject.optString("data");
        if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str1.equals(p.c())) {
          p.c(str1).e(str3);
          if (f.b(str2)) {
            p.f(str2);
            b.a().a(true);
          } 
          c.a().a(p);
        } 
      } 
    } 
  }
  
  private void e() {
    t.b("TmplDiffManager", "start doCheckAndDeleteTask");
    if (o.h() == null)
      return; 
    int i = o.h().Q() * 3;
    if (i <= 0)
      return; 
    List<p> list = c.a().b();
    if (list.isEmpty() || i >= list.size()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("end doCheckAndDeleteTask maxTplCnt,local size");
      stringBuilder1.append(i);
      stringBuilder1.append(",");
      stringBuilder1.append(list.size());
      t.b("TmplDiffManager", stringBuilder1.toString());
      return;
    } 
    int j = (int)(list.size() - i * 0.75F);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("doCheckAndDeleteTask maxTplCnt,local size,deleteCnt:");
    stringBuilder.append(i);
    stringBuilder.append(",");
    stringBuilder.append(list.size());
    stringBuilder.append(",");
    stringBuilder.append(j);
    t.b("TmplDiffManager", stringBuilder.toString());
    HashSet<String> hashSet = new HashSet();
    for (i = 0; i < j; i++)
      hashSet.add(((p)list.get(i)).b()); 
    a(hashSet);
    t.b("TmplDiffManager", "end doCheckAndDeleteTask");
    this.d.set(false);
  }
  
  public p a(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : c.a().a(paramString);
  }
  
  public void a(k paramk) {
    if (paramk != null) {
      if (paramk.x() == null)
        return; 
      String str1 = paramk.x().b();
      String str2 = paramk.x().d();
      String str3 = paramk.x().c();
      int i = ah.d(paramk.P());
      m m = m.a().a(str1).b(str3).c(str2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      a(m, stringBuilder.toString());
    } 
  }
  
  public void a(m paramm, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_1
    //   10: getfield a : Ljava/lang/String;
    //   13: astore_3
    //   14: aload_1
    //   15: getfield c : Ljava/lang/String;
    //   18: astore #4
    //   20: aload_1
    //   21: getfield b : Ljava/lang/String;
    //   24: astore #5
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   32: ifeq -> 42
    //   35: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/core/h;
    //   38: invokevirtual e : ()Ljava/lang/String;
    //   41: astore_1
    //   42: aload #4
    //   44: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   47: ifne -> 93
    //   50: aload #5
    //   52: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   55: ifne -> 93
    //   58: aload_3
    //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   62: ifeq -> 68
    //   65: goto -> 93
    //   68: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/i/a;
    //   71: new com/bytedance/sdk/openadsdk/core/widget/webview/a/d$2
    //   74: dup
    //   75: aload_0
    //   76: aload_3
    //   77: aload #5
    //   79: aload #4
    //   81: aload_1
    //   82: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/d;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   85: bipush #10
    //   87: invokevirtual c : (Ljava/lang/Runnable;I)V
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Exception table:
    //   from	to	target	type
    //   9	26	96	finally
    //   28	42	96	finally
    //   42	65	96	finally
    //   68	90	96	finally
  }
  
  public void a(Set<String> paramSet) {
    try {
      return;
    } finally {
      paramSet = null;
    } 
  }
  
  public void b() {
    int i = o.h().n();
    long l1 = this.b.get();
    long l2 = (i * 1000);
    if (l1 != l2) {
      ScheduledFuture<?> scheduledFuture = this.c;
      if (scheduledFuture != null && scheduledFuture.isCancelled())
        this.c.cancel(true); 
      this.b.set(l2);
      this.c = com.bytedance.sdk.openadsdk.i.a.a().a(new a(this, 1), 0L);
    } 
  }
  
  public void c() {
    if (!this.d.getAndSet(true))
      com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable(this) {
            public void run() {
              d.c(this.a);
            }
          },  60000L); 
  }
  
  class a implements Runnable {
    private int b = 0;
    
    public a(d this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void run() {
      if (this.b == 1) {
        d.a(this.a);
        com.bytedance.sdk.openadsdk.i.a.a().a(new a(this.a, 1), d.b(this.a).get());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */