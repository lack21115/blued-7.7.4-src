package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class h extends g<String> {
  public h(int paramInt, String paramString, JSONObject paramJSONObject, n.a<String> parama) {
    super(paramInt, paramString, str, parama);
  }
  
  public n<String> a(j paramj) {
    try {
      return n.a(new String(paramj.b, c.a(paramj.c, "utf-8")), c.a(paramj));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return n.a((VAdError)new e(unsupportedEncodingException));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */