package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.os.Environment;
import com.bytedance.sdk.adnet.b.c;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class b {
  private static File a;
  
  private static volatile b b;
  
  private AtomicBoolean c = new AtomicBoolean(true);
  
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private boolean e = false;
  
  private AtomicInteger f = new AtomicInteger(0);
  
  private AtomicLong g = new AtomicLong();
  
  private b() {
    f();
  }
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/b.b : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/b
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/b.b : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/b;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/widget/webview/a/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/b.b : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/b;
    //   25: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/b.b : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(int paramInt) {
    d d = d.b().b(paramInt).g(g.a(paramInt));
    a.a().h(d);
  }
  
  private void a(List<o.a> paramList) {
    if (paramList != null) {
      if (paramList.isEmpty())
        return; 
      Iterator<o.a> iterator = paramList.iterator();
      while (true) {
        if (iterator.hasNext()) {
          String str = j.a(((o.a)iterator.next()).a());
          File file1 = new File(e(), str);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(file1);
          stringBuilder.append(".tmp");
          File file2 = new File(stringBuilder.toString());
          if (file1.exists())
            try {
              file1.delete();
            } finally {} 
          if (file2.exists())
            try {
              file2.delete();
            } finally {} 
          continue;
        } 
        return;
      } 
    } 
  }
  
  public static File e() {
    if (a == null)
      try {
        if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && o.a().getExternalCacheDir() != null) {
          file = o.a().getExternalCacheDir();
        } else {
          file = o.a().getCacheDir();
        } 
        File file = new File(new File(file, "tt_tmpl_pkg"), "template");
        file.mkdirs();
      } finally {
        Exception exception = null;
      }  
    return a;
  }
  
  private void f() {
    a.a().c(new Runnable(this) {
          public void run() {
            f.a();
            b.a(this.a).set(false);
            b.b(this.a);
            this.a.d();
          }
        },  10);
  }
  
  private void g() {
    boolean bool1;
    t.b("TemplateManager", "check template usable1");
    o o = f.b();
    if (o == null || !o.e()) {
      t.b("TemplateManager", "check template usable2");
      return;
    } 
    boolean bool2 = true;
    Iterator<o.a> iterator = o.d().iterator();
    while (true) {
      bool1 = bool2;
      if (iterator.hasNext()) {
        o.a a = iterator.next();
        String str1 = a.a();
        String str2 = j.a(str1);
        File file = new File(e(), str2);
        String str3 = j.a(file);
        if (!file.exists() || !file.isFile() || a.b() == null || !a.b().equals(str3)) {
          bool1 = false;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("check template usable3: ");
          stringBuilder1.append(str1);
          stringBuilder1.append(",");
          stringBuilder1.append(file.getAbsolutePath());
          t.b("TemplateManager", stringBuilder1.toString());
          break;
        } 
        continue;
      } 
      break;
    } 
    if (!bool1)
      f.d(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("check template usable4: ");
    stringBuilder.append(bool1);
    t.b("TemplateManager", stringBuilder.toString());
    this.e = bool1;
  }
  
  private void h() {
    if (this.f.getAndSet(0) > 0 && System.currentTimeMillis() - this.g.get() > 600000L)
      d(); 
  }
  
  public void a(boolean paramBoolean) {
    if (this.c.get()) {
      t.b("TemplateManager", "loadTemplate error1");
      return;
    } 
    try {
      if (this.d.get()) {
        if (paramBoolean)
          this.f.getAndIncrement(); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadTemplate error2: ");
        return;
      } 
      this.d.set(true);
      o o2 = o.f().a();
      o o1 = f.b();
      if (o2 == null || !o2.e()) {
        this.d.set(false);
        return;
      } 
      if (!f.b(o2.b())) {
        this.d.set(false);
        return;
      } 
      ArrayList<o.a> arrayList1 = new ArrayList();
      ArrayList<o.a> arrayList2 = new ArrayList();
      if (o1 == null || o1.d().isEmpty()) {
        arrayList2.addAll(o2.d());
        t.b("TemplateManager", "loadTemplate update1");
      } else if (o2.d().isEmpty()) {
        arrayList1.addAll(o1.d());
        t.b("TemplateManager", "loadTemplate update2");
      } else {
        for (o.a a1 : o2.d()) {
          if (!o1.d().contains(a1)) {
            arrayList2.add(a1);
            continue;
          } 
          o.a a2 = f.a(a1.a());
          if (a2 != null && a1.b() != null && !a1.b().equals(a2.b()))
            arrayList2.add(a1); 
        } 
        for (o.a a : o1.d()) {
          if (!o2.d().contains(a))
            arrayList1.add(a); 
        } 
        t.b("TemplateManager", "loadTemplate update3");
      } 
      Iterator<o.a> iterator = arrayList2.iterator();
      while (true) {
        paramBoolean = iterator.hasNext();
        if (paramBoolean) {
          String str1 = ((o.a)iterator.next()).a();
          String str2 = j.a(str1);
          File file1 = new File(e(), str2);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(file1);
          stringBuilder.append(".tmp");
          File file2 = new File(stringBuilder.toString());
          paramBoolean = file1.exists();
          if (paramBoolean)
            try {
              file1.delete();
            } finally {
              Exception exception;
            }  
          paramBoolean = file2.exists();
          if (paramBoolean)
            try {
              file2.delete();
            } finally {} 
          i i = i.a();
          (new c(file1.getAbsolutePath(), str1, (n.a)i)).build(e.a(o.a()).c());
          try {
            n n = i.b();
          } finally {
            str1 = null;
          } 
          continue;
        } 
        Iterator<o.a> iterator1 = arrayList1.iterator();
        while (true) {
          if (iterator1.hasNext()) {
            String str = j.a(((o.a)iterator1.next()).a());
            File file1 = new File(e(), str);
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(file1);
            stringBuilder1.append(".tmp");
            File file2 = new File(stringBuilder1.toString());
            paramBoolean = file1.exists();
            if (paramBoolean)
              try {
                file1.delete();
              } finally {} 
            paramBoolean = file2.exists();
            if (paramBoolean)
              try {
                file2.delete();
              } finally {} 
            continue;
          } 
          f.a(o2);
          f.c();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("loadTemplate update success: ");
          stringBuilder.append(o2.b());
          t.b("TemplateManager", stringBuilder.toString());
          g();
          this.d.set(false);
          return;
        } 
        break;
      } 
    } finally {
      Exception exception = null;
      t.a("TemplateManager", "loadTemplate error: ", exception);
    } 
  }
  
  public boolean b() {
    return this.e;
  }
  
  public o c() {
    return f.b();
  }
  
  public void d() {
    a(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */