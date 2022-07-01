package com.bytedance.sdk.openadsdk.core.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.f;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class h implements Runnable {
  private static final AtomicBoolean c = new AtomicBoolean(false);
  
  private static volatile h d;
  
  private final e a;
  
  private final Context b;
  
  private h(e parame) {
    e e1 = parame;
    if (parame == null)
      e1 = o.h(); 
    this.a = e1;
    this.b = o.a();
    if (b.b())
      try {
        IntentFilter intentFilter = new IntentFilter("com.bytedance.openadsdk.dnsSettingReceiver");
        return;
      } finally {
        parame = null;
      }  
  }
  
  public static h a(e parame) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/h/h.d : Lcom/bytedance/sdk/openadsdk/core/h/h;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/core/h/h
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/h/h.d : Lcom/bytedance/sdk/openadsdk/core/h/h;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/core/h/h
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/h/e;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/core/h/h.d : Lcom/bytedance/sdk/openadsdk/core/h/h;
    //   26: ldc com/bytedance/sdk/openadsdk/core/h/h
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/core/h/h
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/core/h/h.d : Lcom/bytedance/sdk/openadsdk/core/h/h;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private String a(String paramString1, String paramString2) {
    StringBuffer stringBuffer = new StringBuffer("https://");
    if (!TextUtils.isEmpty(paramString1)) {
      stringBuffer.append(paramString1);
    } else {
      stringBuffer.append("dig.bdurl.net");
    } 
    stringBuffer.append("/q?host=");
    if (!TextUtils.isEmpty(paramString2)) {
      stringBuffer.append(paramString2);
    } else {
      stringBuffer.append("is.snssdk.com");
      stringBuffer.append(",");
      stringBuffer.append("pangolin.snssdk.com");
    } 
    stringBuffer.append("&aid=");
    stringBuffer.append("1371");
    return stringBuffer.toString();
  }
  
  public static void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (o.a() != null)
      try {
        Intent intent = new Intent();
        intent.setAction("com.bytedance.openadsdk.dnsSettingReceiver");
        intent.putExtra("b_msg_id", 1);
        intent.putExtra("b_msg_data", paramString);
        return;
      } finally {
        paramString = null;
      }  
  }
  
  public void a() {
    try {
      if (!c.getAndSet(true))
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void run() {
    if (!w.a(this.b))
      try {
        this.a.a();
        return;
      } finally {
        Exception exception = null;
      }  
    (new f(0, a(null, null), (String)null, new n.a<JSONObject>(this) {
          public void a(n<JSONObject> param1n) {
            h.b().set(false);
            if (param1n != null && param1n.a != null) {
              JSONObject jSONObject = (JSONObject)param1n.a;
              try {
                h.a(this.a).a(jSONObject);
              } finally {
                Exception exception;
              } 
              if (b.b())
                h.a(jSONObject.toString()); 
              return;
            } 
            try {
              return;
            } finally {
              param1n = null;
            } 
          }
          
          public void b(n<JSONObject> param1n) {
            h.b().set(false);
            try {
              return;
            } finally {
              param1n = null;
            } 
          }
        })).setResponseOnMain(false).setShouldCache(false).build(e.a(this.b).d());
  }
  
  class a extends BroadcastReceiver {
    private a(h this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (param1Intent == null)
        return; 
      if (param1Intent.getIntExtra("b_msg_id", -1) == 1) {
        String str = param1Intent.getStringExtra("b_msg_data");
        if (!TextUtils.isEmpty(str))
          try {
            JSONObject jSONObject = new JSONObject(str);
            return;
          } finally {
            str = null;
          }  
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */