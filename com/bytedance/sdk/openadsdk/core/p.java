package com.bytedance.sdk.openadsdk.core;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.d.a;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.o;
import java.util.List;
import org.json.JSONObject;

public interface p<T> {
  h a(List<T> paramList);
  
  h a(JSONObject paramJSONObject);
  
  o a();
  
  void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap);
  
  void a(AdSlot paramAdSlot, l paraml, int paramInt, b paramb);
  
  void a(k paramk, List<FilterWord> paramList);
  
  void a(String paramString1, String paramString2, a parama);
  
  void a(JSONObject paramJSONObject, c paramc);
  
  boolean a(JSONObject paramJSONObject, int paramInt);
  
  public static interface a {
    void a(boolean param1Boolean, long param1Long1, long param1Long2);
  }
  
  public static interface b {
    void a(int param1Int, String param1String);
    
    void a(a param1a);
  }
  
  public static interface c {
    void a(int param1Int, String param1String);
    
    void a(q.c param1c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */