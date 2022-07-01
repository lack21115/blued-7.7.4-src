package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.intersitial2.f;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.y.c;
import java.io.File;
import org.json.JSONObject;

public class d extends f {
  private String g;
  
  private JSONObject h;
  
  public d(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, l paraml, ADListener paramADListener) {
    super(paramContext, paramADSize, paramString1, paramString2, paraml, paramADListener, e.v);
  }
  
  private void b() {
    File file = aj.d(this.g);
    if (file == null || !file.exists()) {
      a.a().a(this.g, this.h.optString("cl"), new a.a(this) {
            public void a() {}
            
            public void a(int param1Int) {}
            
            public void a(c param1c) {}
            
            public void a(String param1String) {
              ADListener aDListener = d.f(this.a);
              d d1 = this.a;
              aDListener.onADEvent(new ADEvent(21, new Object[] { d.b(d1, d.d(d1)) }));
            }
          }this.f);
      return;
    } 
    this.d.onADEvent(new ADEvent(21, new Object[] { c(this.h) }));
  }
  
  public JSONObject a() {
    JSONObject jSONObject = this.h;
    this.h = null;
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual b : (Lorg/json/JSONObject;)Landroid/util/Pair;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull -> 222
    //   10: aload_3
    //   11: getfield first : Ljava/lang/Object;
    //   14: ifnull -> 222
    //   17: aload_3
    //   18: getfield second : Ljava/lang/Object;
    //   21: ifnonnull -> 27
    //   24: goto -> 222
    //   27: aload_3
    //   28: getfield first : Ljava/lang/Object;
    //   31: instanceof java/lang/Integer
    //   34: ifeq -> 70
    //   37: aload_0
    //   38: aload_3
    //   39: getfield first : Ljava/lang/Object;
    //   42: checkcast java/lang/Integer
    //   45: invokevirtual intValue : ()I
    //   48: invokevirtual c : (I)V
    //   51: aload_0
    //   52: getfield f : Lcom/qq/e/comm/plugin/y/c;
    //   55: astore_1
    //   56: aload_3
    //   57: getfield second : Ljava/lang/Object;
    //   60: checkcast java/lang/Integer
    //   63: invokevirtual intValue : ()I
    //   66: istore_2
    //   67: goto -> 238
    //   70: aload_3
    //   71: getfield first : Ljava/lang/Object;
    //   74: checkcast org/json/JSONObject
    //   77: astore_1
    //   78: aload_3
    //   79: getfield second : Ljava/lang/Object;
    //   82: checkcast org/json/JSONArray
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual length : ()I
    //   90: ifle -> 204
    //   93: aload_1
    //   94: iconst_0
    //   95: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   98: astore_1
    //   99: aload_0
    //   100: aload_1
    //   101: putfield h : Lorg/json/JSONObject;
    //   104: aload_1
    //   105: ifnonnull -> 111
    //   108: goto -> 204
    //   111: aload_0
    //   112: getfield f : Lcom/qq/e/comm/plugin/y/c;
    //   115: aload_0
    //   116: getfield h : Lorg/json/JSONObject;
    //   119: ldc 'cl'
    //   121: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   124: invokevirtual b : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   127: pop
    //   128: aload_0
    //   129: getfield f : Lcom/qq/e/comm/plugin/y/c;
    //   132: aload_0
    //   133: getfield h : Lorg/json/JSONObject;
    //   136: ldc 'traceid'
    //   138: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   141: invokevirtual c : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   144: pop
    //   145: aload_0
    //   146: aload_0
    //   147: getfield h : Lorg/json/JSONObject;
    //   150: ldc 'video'
    //   152: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield g : Ljava/lang/String;
    //   158: aload_0
    //   159: getfield g : Ljava/lang/String;
    //   162: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   165: ifeq -> 187
    //   168: sipush #5020
    //   171: istore_2
    //   172: aload_0
    //   173: sipush #5020
    //   176: invokevirtual c : (I)V
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield h : Lorg/json/JSONObject;
    //   184: goto -> 233
    //   187: new com/qq/e/comm/plugin/intersitial2/fullscreen/d$1
    //   190: dup
    //   191: aload_0
    //   192: invokespecial <init> : (Lcom/qq/e/comm/plugin/intersitial2/fullscreen/d;)V
    //   195: invokestatic a : (Ljava/lang/Runnable;)Z
    //   198: pop
    //   199: aload_0
    //   200: invokespecial b : ()V
    //   203: return
    //   204: aload_0
    //   205: sipush #501
    //   208: invokevirtual c : (I)V
    //   211: aload_0
    //   212: getfield f : Lcom/qq/e/comm/plugin/y/c;
    //   215: sipush #5004
    //   218: invokestatic a : (Lcom/qq/e/comm/plugin/y/c;I)V
    //   221: return
    //   222: sipush #6000
    //   225: istore_2
    //   226: aload_0
    //   227: sipush #6000
    //   230: invokevirtual c : (I)V
    //   233: aload_0
    //   234: getfield f : Lcom/qq/e/comm/plugin/y/c;
    //   237: astore_1
    //   238: aload_1
    //   239: iload_2
    //   240: invokestatic a : (Lcom/qq/e/comm/plugin/y/c;I)V
    //   243: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\fullscreen\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */