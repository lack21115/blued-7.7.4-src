package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends g<JSONObject> {
  public f(int paramInt, String paramString1, String paramString2, n.a<JSONObject> parama) {
    super(paramInt, paramString1, paramString2, parama);
  }
  
  public f(int paramInt, String paramString, JSONObject paramJSONObject, n.a<JSONObject> parama) {
    this(paramInt, paramString, str, parama);
  }
  
  public n<JSONObject> a(j paramj) {
    try {
      return n.a(new JSONObject(new String(paramj.b, c.a(paramj.c, "utf-8"))), c.a(paramj));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return n.a((VAdError)new e(unsupportedEncodingException));
    } catch (JSONException jSONException) {
      return n.a((VAdError)new e((Throwable)jSONException));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */