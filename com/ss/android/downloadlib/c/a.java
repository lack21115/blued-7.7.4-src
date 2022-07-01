package com.ss.android.downloadlib.c;

import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.downloader.g.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements g {
  public void a(c paramc, int paramInt, boolean paramBoolean) {
    c.a().b();
    com.ss.android.downloadad.a.b.a a1 = c.a().a(paramc);
    if (a1 == null) {
      g.b();
      return;
    } 
    JSONObject jSONObject = com.ss.android.downloadad.a.b.a.a(a1);
    try {
      jSONObject.put("download_id", paramc.g());
      jSONObject.put("name", paramc.h());
      jSONObject.put("url", paramc.j());
      jSONObject.put("download_time", paramc.aw());
      jSONObject.put("download_status", paramInt);
      jSONObject.put("cur_bytes", paramc.Z());
      jSONObject.put("total_bytes", paramc.ab());
      boolean bool1 = paramc.x();
      boolean bool = true;
      if (bool1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      jSONObject.put("only_wifi", paramInt);
      jSONObject.put("chunk_count", paramc.aV());
      if (paramBoolean) {
        paramInt = bool;
      } else {
        paramInt = 0;
      } 
      jSONObject.put("launch_resumed", paramInt);
      jSONObject.put("failed_resume_count", paramc.aZ());
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    com.ss.android.downloadlib.d.a.a().a("embeded_ad", "download_uncompleted", jSONObject, a1);
  }
  
  public void a(c paramc, boolean paramBoolean) {
    if (paramc == null)
      return; 
    if (com.ss.android.socialbase.downloader.k.a.a(paramc.g()).a("report_download_uncompleted_event", 0) == 0)
      return; 
    a(paramc, paramc.w(), paramBoolean);
  }
  
  public void a(List<c> paramList) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */