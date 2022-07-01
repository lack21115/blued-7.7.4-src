package com.bytedance.tea.crash.upload;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.tea.crash.b.a;
import com.bytedance.tea.crash.b.a.a;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.g.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class CrashUploadService extends IntentService {
  public CrashUploadService() {
    super("CrashUploadService");
  }
  
  private f a(String paramString1, String paramString2, String paramString3, c paramc) {
    if (paramc == null)
      return new f(201); 
    try {
      JSONObject jSONObject = new JSONObject(paramString2);
      jSONObject.put("upload_scene", "new_process");
      String str = jSONObject.toString();
      paramString2 = str;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return (paramc == c.c) ? b.a(paramString1, paramString2, paramString3) : ((paramc == c.a) ? b.a(paramString1, paramString2) : b.a(paramString1, paramString2, b.a()));
  }
  
  public void onDestroy() {
    super.onDestroy();
    System.exit(0);
  }
  
  protected void onHandleIntent(Intent paramIntent) {
    if (paramIntent == null)
      return; 
    c c = null;
    if (paramIntent.hasExtra("crash_type"))
      c = (c)paramIntent.getSerializableExtra("crash_type"); 
    String str2 = paramIntent.getStringExtra("upload_url");
    String str3 = paramIntent.getStringExtra("crash_json_value");
    String str4 = paramIntent.getStringExtra("crash_info_file_path");
    String str1 = paramIntent.getStringExtra("crash_dump_file_path");
    a.a().a((Context)getApplication());
    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
      if (a.a().a(str4))
        return; 
      if (a(str2, str3, str1, c).a())
        if (c == c.c) {
          if (!d.a((new File(str4)).getParentFile(), true)) {
            a.a().a(a.a(str4));
            return;
          } 
        } else if (!TextUtils.isEmpty(str4) && !d.a(str4)) {
          a.a().a(a.a(str4));
        }  
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\cras\\upload\CrashUploadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */