package com.datavisor.vangogh.e;

import android.content.Context;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.e.b.a;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.f;
import com.datavisor.vangogh.f.i.c;
import com.datavisor.vangogh.storage.local.b;
import org.json.JSONObject;

public class a {
  public String a = "";
  
  public String b = "";
  
  public String c = "";
  
  public int d = 0;
  
  public a() {}
  
  public a(Context paramContext, c paramc) {
    try {
      byte[] arrayOfByte;
      this.d = paramc.c;
      int i = paramc.c;
      if (i != 0)
        return; 
      try {
      
      } finally {
        Exception exception = null;
      } 
      if (arrayOfByte == null)
        return; 
      JSONObject jSONObject = new JSONObject(new String(arrayOfByte));
      if (jSONObject.has(crypto.convert("PoyM9nvTo8U=")) && jSONObject.getInt(crypto.convert("PoyM9nvTo8U=")) != 0) {
        i = jSONObject.getInt(crypto.convert("PoyM9nvTo8U="));
      } else if (!jSONObject.has(crypto.convert("MpCYxg=="))) {
        i = 4;
      } else {
        JSONObject jSONObject1 = jSONObject.getJSONObject(crypto.convert("MpCYxg=="));
        if (jSONObject1 == null)
          return; 
        a(jSONObject1);
        boolean bool1 = jSONObject.has(crypto.convert("H6iz6A=="));
        boolean bool = true;
        i = bool;
        if (bool1)
          try {
          
          } finally {
            jSONObject1 = null;
          }  
        a.a(paramContext, "DVSPDVMA", System.currentTimeMillis() + i * 86400000L);
        return;
      } 
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public a(Context paramContext, String paramString) {
    try {
      String str = a.b(paramContext, paramString);
      if (f.b(str))
        return; 
    } finally {
      paramContext = null;
    } 
  }
  
  public a(String paramString) {
    try {
      paramString = b.b(paramString);
      if (f.b(paramString))
        return; 
    } finally {
      paramString = null;
    } 
  }
  
  private String a() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put(crypto.convert("H6i37Q=="), this.a);
      jSONObject.put(crypto.convert("H6iqxnPZqQ=="), this.b);
      return jSONObject.toString();
    } finally {
      Exception exception = null;
    } 
  }
  
  private void a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    try {
      if (paramJSONObject.has(crypto.convert("H6i37Q==")))
        this.a = paramJSONObject.getString(crypto.convert("H6i37Q==")); 
      if (paramJSONObject.has(crypto.convert("H6iqxnPZqQ==")))
        this.b = paramJSONObject.getString(crypto.convert("H6iqxnPZqQ==")); 
      return;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private String b() {
    try {
      JSONObject jSONObject = new JSONObject();
      return jSONObject.toString();
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(Context paramContext, String paramString) {
    try {
      String str = a();
      return;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public void a(String paramString) {
    try {
      String str = b();
      return;
    } finally {
      paramString = null;
      d.a((Throwable)paramString);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */