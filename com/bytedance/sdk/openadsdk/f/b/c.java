package com.bytedance.sdk.openadsdk.f.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.b;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class c implements a {
  private final b a = b.a();
  
  private final List<a> b = Collections.synchronizedList(new LinkedList<a>());
  
  public static a c() {
    return e.c();
  }
  
  public void a() {
    com.bytedance.sdk.openadsdk.i.a.a().d(new Runnable(this) {
          public void run() {
            List<c.a> list = c.a(this.a).d();
            if (list != null)
              c.b(this.a).addAll(list); 
            c.a(this.a).c();
          }
        },  5);
  }
  
  public void a(b paramb) {
    a(paramb, false);
  }
  
  public void a(b paramb, boolean paramBoolean) {
    if (paramb != null) {
      if (!j.a())
        return; 
      a a1 = new a(UUID.randomUUID().toString(), paramb.a());
      if (paramBoolean) {
        o.e().a(a1);
        return;
      } 
      o.d().a(a1);
    } 
  }
  
  public void b() {}
  
  public static class a implements i {
    public final String a;
    
    public final JSONObject b;
    
    public a(String param1String, JSONObject param1JSONObject) {
      this.a = param1String;
      this.b = param1JSONObject;
    }
    
    public static a a(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return null; 
      try {
        JSONObject jSONObject = new JSONObject(param1String);
        param1String = jSONObject.optString("localId", null);
        return (!TextUtils.isEmpty(param1String) && jSONObject != null) ? new a(param1String, jSONObject) : null;
      } finally {
        param1String = null;
      } 
    }
    
    public String a() {
      if (!TextUtils.isEmpty(this.a) && this.b != null) {
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("localId", this.a);
          jSONObject.put("event", this.b);
        } finally {
          Exception exception;
        } 
        return jSONObject.toString();
      } 
      return null;
    }
    
    public String b() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\f\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */