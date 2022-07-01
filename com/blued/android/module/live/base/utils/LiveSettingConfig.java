package com.blued.android.module.live.base.utils;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.live.base.model.LiveQiniuTokenModel;
import com.blued.android.module.live.base.model.LiveSettingConfigModel;
import java.io.File;
import java.util.Map;

public class LiveSettingConfig {
  private LiveSettingConfigModel a;
  
  public static LiveSettingConfig a() {
    return SettingConfig.a;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    if (TextUtils.isEmpty(paramString2))
      return; 
    if (TextUtils.isEmpty(paramString3))
      return; 
    if (TextUtils.isEmpty(paramString4))
      return; 
    QiniuUploadTools.a(null, new File(paramString2), paramString3, paramString4, new QiniuUploadTools.QiNiuListener(this, paramString1, paramString2) {
          public void a(String param1String) {}
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            LiveSettingConfig.a(this.c, this.a, param1String1, this.b);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void b(String paramString1, String paramString2, String paramString3) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("zip", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<Object>>(this, null, paramString3) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            (new File(this.a)).delete();
          }
        }).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public void a(String paramString) {
    HttpManager.a(paramString, (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<LiveSettingConfigModel>>(this, null) {
          protected void a(BluedEntityA<LiveSettingConfigModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              if (param1BluedEntityA.getSingleData() == null)
                return; 
              LiveSettingConfig.a(this.a, (LiveSettingConfigModel)param1BluedEntityA.getSingleData());
            } 
          }
        }).b(BluedHttpTools.a(true)).i();
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      if (TextUtils.isEmpty(paramString3))
        return; 
      if (!(new File(paramString3)).exists())
        return; 
      HttpManager.a(paramString1, (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<LiveQiniuTokenModel>>(this, null, paramString2, paramString3) {
            protected void a(BluedEntityA<LiveQiniuTokenModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
                if (param1BluedEntityA.getSingleData() == null)
                  return; 
                LiveSettingConfig.a(this.c, this.a, this.b, ((LiveQiniuTokenModel)param1BluedEntityA.getSingleData()).key, ((LiveQiniuTokenModel)param1BluedEntityA.getSingleData()).token);
              } 
            }
          }).b(BluedHttpTools.a(true)).i();
    } 
  }
  
  public boolean b() {
    LiveSettingConfigModel liveSettingConfigModel = this.a;
    boolean bool = false;
    if (liveSettingConfigModel == null)
      return false; 
    if (liveSettingConfigModel.a == 1)
      bool = true; 
    return bool;
  }
  
  public static class SettingConfig {
    public static LiveSettingConfig a = new LiveSettingConfig();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\bas\\utils\LiveSettingConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */