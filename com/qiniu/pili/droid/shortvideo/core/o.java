package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoMixItem;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.process.a.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class o {
  private c a;
  
  private PLVideoEncodeSetting b;
  
  private String c;
  
  private long d;
  
  public o(Context paramContext, String paramString, long paramLong) {
    l.a(paramContext.getApplicationContext());
    this.c = paramString;
    this.d = paramLong;
  }
  
  public JSONObject a(int paramInt) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_mix_video", paramInt);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void a() {
    this.a.a();
  }
  
  public void a(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.b = paramPLVideoEncodeSetting;
  }
  
  public void a(List<PLVideoMixItem> paramList, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.ad)) {
      if (paramPLVideoSaveListener != null)
        paramPLVideoSaveListener.onSaveVideoFailed(8); 
      return;
    } 
    if (this.a == null)
      this.a = new c(); 
    this.a.a(paramList, this.c, this.d, this.b, paramPLVideoSaveListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */