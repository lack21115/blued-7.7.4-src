package com.datavisor.vangogh.d;

import android.content.Context;
import android.util.Base64;
import com.datavisor.vangogh.bridge.config;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.bridge.storage;
import com.datavisor.vangogh.e.b.a;
import com.datavisor.vangogh.f.a;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.f;
import com.datavisor.vangogh.f.i.c;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private static b a;
  
  private Context b = null;
  
  private String c = null;
  
  private b(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      this.c = a();
      b();
      c();
      return;
    } 
    throw new IllegalArgumentException("ConfigManager initialization error: mContext is null.");
  }
  
  public static b a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/d/b.a : Lcom/datavisor/vangogh/d/b;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/d/b
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/d/b.a : Lcom/datavisor/vangogh/d/b;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/d/b
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/d/b.a : Lcom/datavisor/vangogh/d/b;
    //   26: ldc com/datavisor/vangogh/d/b
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/d/b
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/d/b.a : Lcom/datavisor/vangogh/d/b;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private String a() {
    String str;
    try {
      int j = a.c(this.b, "DVSPRANDOM");
      int i = j;
      if (j < 0) {
        i = (new Random()).nextInt(1000) % 1000 + 1;
        a.a(this.b, "DVSPRANDOM", i);
      } 
      str = crypto.convert("H6ih6nfSockIb6dpGfsK/wZizrztHSI=");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      storage.globalSet(str, stringBuilder.toString());
    } finally {
      Exception exception = null;
      String str1 = UUID.randomUUID().toString();
      str = str1;
    } 
    return str;
  }
  
  private void b() {
    config.loadDefaultConfig();
  }
  
  private void c() {
    String str = a.a(this.b, "DVSPCONFIG");
    if (!f.a(str))
      storage.globalSet(crypto.convert("H6ih6nfSockI"), str); 
  }
  
  private void d(String paramString) {
    if (f.a(paramString))
      return; 
    a.a(this.b, "DVSPCONFIG", paramString);
  }
  
  public void a(String paramString) {
    String str;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("app_access_key", paramString);
    hashMap.put("sdk_version", "2.1.1.20200509_Android");
    hashMap.put("os", "Android");
    hashMap.put("random", this.c);
    byte[] arrayOfByte = crypto.encryptV(a.b(hashMap).toString().getBytes());
    if (arrayOfByte == null) {
      paramString = "updateData encryptParams empty";
    } else {
      byte[] arrayOfByte1 = crypto.sign(arrayOfByte);
      if (arrayOfByte1 == null) {
        paramString = "updateData sign empty";
      } else {
        byte[] arrayOfByte2 = new byte[arrayOfByte.length + arrayOfByte1.length];
        System.arraycopy(arrayOfByte, 0, arrayOfByte2, 0, arrayOfByte.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, arrayOfByte.length, arrayOfByte1.length);
        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
        hashMap1.put("c", "1");
        c c = com.datavisor.vangogh.f.i.b.b(hashMap1, arrayOfByte2, this.b);
        if (c.c == 0) {
          str = Base64.encodeToString(c.b, 2);
          storage.globalSet(crypto.convert("H6ih6nfSockI"), str);
          d(str);
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateData network error: ");
        stringBuilder.append(((c)str).c);
        d.a(stringBuilder.toString());
        return;
      } 
    } 
    d.a(str);
  }
  
  public boolean b(String paramString) {
    boolean bool1 = f.a(paramString);
    boolean bool = false;
    if (bool1)
      return false; 
    if (config.isSwitchOn(paramString) != 0)
      bool = true; 
    return bool;
  }
  
  public JSONObject c(String paramString) {
    if (f.a(paramString))
      return null; 
    paramString = config.getInfoByName(paramString);
    if (f.a(paramString))
      return null; 
    try {
      return new JSONObject(paramString);
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */