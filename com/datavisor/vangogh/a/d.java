package com.datavisor.vangogh.a;

import android.content.Context;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.d.b;
import com.datavisor.vangogh.f.f;
import com.datavisor.vangogh.f.h.a;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
  private static d a;
  
  private Context b = null;
  
  private long c = 0L;
  
  private d(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      this.c = 0L;
      return;
    } 
    throw new IllegalArgumentException("RootDetect initialization error: mContext is null.");
  }
  
  public static d a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/a/d.a : Lcom/datavisor/vangogh/a/d;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/a/d
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/a/d.a : Lcom/datavisor/vangogh/a/d;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/a/d
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/a/d.a : Lcom/datavisor/vangogh/a/d;
    //   26: ldc com/datavisor/vangogh/a/d
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/a/d
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/a/d.a : Lcom/datavisor/vangogh/a/d;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(JSONArray paramJSONArray) {
    int i = 0;
    try {
      return;
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void b() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void c() {
    if (f.b(a.c(crypto.convert("LJaXynCctNU="))))
      this.c |= 0x4L; 
  }
  
  private void d() {
    try {
      int i;
      String str = System.getenv("PATH");
      if (f.a(str))
        return; 
      List<String> list = Arrays.asList(str.split(":"));
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public String a() {
    JSONObject jSONObject = b.a(this.b).c(crypto.convert("KZGR3Q=="));
    if (jSONObject == null)
      return "empty"; 
    this.c = 0L;
    b();
    try {
      JSONArray jSONArray = jSONObject.getJSONArray(crypto.convert("KIuOyGzUtA=="));
      if (jSONArray != null && jSONArray.length() > 0)
        a(jSONArray); 
    } finally {}
    c();
    d();
    return String.valueOf(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */