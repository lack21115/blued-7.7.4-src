package com.datavisor.vangogh.d;

import android.content.Context;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.bridge.storage;
import com.datavisor.vangogh.e.a;
import com.datavisor.vangogh.f.a;
import com.datavisor.vangogh.f.f;

public class e {
  private static e b;
  
  public int a = 0;
  
  private Context c = null;
  
  private e(Context paramContext) {
    if (paramContext != null) {
      this.c = paramContext;
      this.a = 0;
      a();
      return;
    } 
    throw new IllegalArgumentException("StorageManager initialization error: mContext is null.");
  }
  
  public static e a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/d/e.b : Lcom/datavisor/vangogh/d/e;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/d/e
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/d/e.b : Lcom/datavisor/vangogh/d/e;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/d/e
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/d/e.b : Lcom/datavisor/vangogh/d/e;
    //   26: ldc com/datavisor/vangogh/d/e
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/d/e
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/d/e.b : Lcom/datavisor/vangogh/d/e;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a() {
    try {
      byte b;
      this.a = 0;
      a a = new a(this.c, "responsekey");
      boolean bool = a.b(a.a);
      if (bool && a.b(a.b)) {
        storage.globalSet(crypto.convert("H6i37Q=="), a.a);
        storage.globalSet(crypto.convert("H6iqxnPZqQ=="), a.b);
        storage.globalSet(crypto.convert("H6i9/Q=="), a.c);
        b = 1;
      } else {
        a = new a(".__pdvk.sys");
        if (a.b(a.a)) {
          storage.globalSet(crypto.convert("H6i37Q=="), a.a);
          b = 2;
        } else {
          return;
        } 
      } 
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public String a(String paramString) {
    return storage.globalGet(paramString);
  }
  
  public void a(a parama) {
    try {
      if (!f.a(parama.a))
        storage.globalSet(crypto.convert("H6i37Q=="), parama.a); 
      if (!f.a(parama.b))
        storage.globalSet(crypto.convert("H6iqxnPZqQ=="), parama.b); 
      if (!f.a(parama.c))
        storage.globalSet(crypto.convert("H6i9/Q=="), parama.c); 
      parama.a(this.c, "responsekey");
      return;
    } finally {
      parama = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */