package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class f {
  private static o a;
  
  public static o.a a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (b() != null) {
      if (b().d() == null)
        return null; 
      if (b().e())
        for (o.a a : b().d()) {
          if (a.a() != null && a.a().equals(paramString))
            return a; 
        }  
    } 
    return null;
  }
  
  public static void a() {
    FileInputStream fileInputStream = null;
    try {
      File file = new File(b.e(), "temp_pkg_info.json");
      Long long_ = Long.valueOf(file.length());
    } finally {
      null = null;
      fileInputStream = null;
    } 
  }
  
  public static void a(o paramo) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/f
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 27
    //   7: aload_0
    //   8: invokevirtual e : ()Z
    //   11: ifeq -> 27
    //   14: aload_0
    //   15: putstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/f.a : Lcom/bytedance/sdk/openadsdk/core/d/o;
    //   18: goto -> 27
    //   21: astore_0
    //   22: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/f
    //   24: monitorexit
    //   25: aload_0
    //   26: athrow
    //   27: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/f
    //   29: monitorexit
    //   30: return
    // Exception table:
    //   from	to	target	type
    //   7	18	21	finally
  }
  
  public static o b() {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/f
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/f.a : Lcom/bytedance/sdk/openadsdk/core/d/o;
    //   6: astore_0
    //   7: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/f
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/f
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static boolean b(String paramString) {
    boolean bool2 = false;
    boolean bool1 = false;
    try {
      return true;
    } finally {
      paramString = null;
    } 
  }
  
  public static void c() {
    o o1 = a;
    if (o1 == null) {
      t.b("Version", "version save error1");
      return;
    } 
    null = o1.f();
    if (TextUtils.isEmpty(null)) {
      t.b("Version", "version save error2");
      return;
    } 
    File file1 = new File(b.e(), "temp_pkg_info.json");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file1);
    stringBuilder.append(".tmp");
    File file2 = new File(stringBuilder.toString());
    if (file2.exists())
      file2.delete(); 
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file2);
    } finally {
      null = null;
    } 
    try {
      t.c("Version", "version save error3", (Throwable)null);
      if (stringBuilder == null)
        return; 
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {} 
    } 
  }
  
  public static void d() {
    o o1 = b();
    if (o1 == null)
      return; 
    File file = b.e();
    try {
      (new File(file, "temp_pkg_info.json")).delete();
    } finally {
      Exception exception;
    } 
    if (o1.d() != null) {
      Iterator<o.a> iterator = o1.d().iterator();
      while (true) {
        if (iterator.hasNext()) {
          o.a a = iterator.next();
          try {
            (new File(file, j.a(a.a()))).delete();
          } finally {}
          continue;
        } 
        a = null;
        return;
      } 
    } 
    a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */