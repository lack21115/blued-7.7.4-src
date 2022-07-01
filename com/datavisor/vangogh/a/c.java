package com.datavisor.vangogh.a;

import android.content.Context;
import android.net.LocalServerSocket;
import android.text.TextUtils;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.bridge.storage;
import com.datavisor.vangogh.d.b;
import com.datavisor.vangogh.f.f;
import com.datavisor.vangogh.f.h.a;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
  private static c a;
  
  private Context b = null;
  
  private volatile LocalServerSocket c = null;
  
  private long d = 0L;
  
  private c(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      this.d = 0L;
      return;
    } 
    throw new IllegalArgumentException("MultiOpenDetect initialization error: mContext is null.");
  }
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/a/c.a : Lcom/datavisor/vangogh/a/c;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/a/c
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/a/c.a : Lcom/datavisor/vangogh/a/c;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/a/c
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/a/c.a : Lcom/datavisor/vangogh/a/c;
    //   26: ldc com/datavisor/vangogh/a/c
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/a/c
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/a/c.a : Lcom/datavisor/vangogh/a/c;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a() {
    int k;
    Exception exception;
    String[] arrayOfString;
    try {
      Map map = a.a();
      if (map == null)
        return; 
      k = ((Integer)map.get("userid")).intValue();
      int m = ((Integer)map.get("appid")).intValue();
      Locale locale = Locale.getDefault();
      String str1 = String.format(locale, "u%d_a%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m - 10000) });
      if (TextUtils.isEmpty(str1))
        return; 
      String str2 = a.c("ps -e");
      if (TextUtils.isEmpty(str2))
        return; 
      arrayOfString = str2.split("\n");
    } finally {
      exception = null;
    } 
    int i = 0;
    for (int j = 0;; j = m) {
      int m;
      if (i < arrayOfString.length) {
        m = j;
        if (arrayOfString[i].contains((CharSequence)exception)) {
          m = arrayOfString[i].lastIndexOf(" ");
          String str = arrayOfString[i];
          if (m <= 0) {
            m = 0;
          } else {
            m++;
          } 
          str = str.substring(m, arrayOfString[i].length());
          Locale locale = Locale.getDefault();
          m = j;
          if ((new File(String.format(locale, "/data/user/%d/%s", new Object[] { Integer.valueOf(k), str }))).exists())
            m = j + 1; 
        } 
      } else {
        if (j > 1)
          this.d |= 0x10L; 
        return;
      } 
      i++;
    } 
  }
  
  private void a(JSONArray paramJSONArray) {
    try {
      int i;
      String str = this.b.getFilesDir().getPath();
      return;
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void b(String paramString) {
    if (this.c != null)
      return; 
    try {
      this.c = new LocalServerSocket(paramString);
      return;
    } catch (IOException iOException) {
      this.d |= 0x8L;
      return;
    } 
  }
  
  private void b(JSONArray paramJSONArray) {
    String str = storage.globalGet(crypto.convert("H6ih/XXMmPAdX5dBI+oF8QZ9zqL6"));
    if (f.a(str))
      return; 
    int i = 0;
    try {
      while (i < paramJSONArray.length()) {
        if (str.contains(paramJSONArray.getString(i).toLowerCase()))
          return; 
        i++;
      } 
    } finally {
      paramJSONArray = null;
    } 
  }
  
  public String a(String paramString) {
    JSONObject jSONObject = b.a(this.b).c(crypto.convert("NpGOzHY="));
    if (jSONObject == null)
      return "empty"; 
    this.d = 0L;
    try {
      JSONArray jSONArray = jSONObject.getJSONArray(crypto.convert("K5WZ"));
      if (jSONArray != null && jSONArray.length() > 0) {
        a(jSONArray);
        b(jSONArray);
      } 
    } finally {}
    b(paramString);
    a();
    return String.valueOf(this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */