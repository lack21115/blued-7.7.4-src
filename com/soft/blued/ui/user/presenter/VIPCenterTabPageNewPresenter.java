package com.soft.blued.ui.user.presenter;

import android.text.TextUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.Map;

public class VIPCenterTabPageNewPresenter extends MvpPresenter {
  private BluedUIHttpResponse h;
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    if (this.h == null)
      this.h = new BluedUIHttpResponse<BluedEntityA<VIPCenterForJsonParse>>(this, "vip_center_new", g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<VIPCenterForJsonParse> param1BluedEntityA) {
            super.onUICache((BluedEntity)param1BluedEntityA);
            if (param1BluedEntityA != null)
              this.a.a("DATA_VIP_OPTION_CACHE", param1BluedEntityA.data); 
          }
          
          protected void b(BluedEntityA<VIPCenterForJsonParse> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              this.a.a("vip_option", param1BluedEntityA.data); 
          }
          
          public void onSuccess(String param1String) {
            super.onSuccess(param1String);
            Logger.a("center_data", param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.a.a(true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.a();
          }
        }; 
    this.h.refresh();
    PayHttpUtils.b(this.h, g());
    BluedConfig.b().d();
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    if (!TextUtils.isEmpty(paramString) && paramString.equals(BluedPreferences.Z()))
      return; 
    if ((BluedConfig.b().j()).is_invisible_half == 1 && (BluedConfig.b().k()).is_invisible_half == 1) {
      Map<String, String> map = BluedHttpTools.a();
      map.put("stealth_distance", BluedPreferences.Z());
      ProfileHttpUtils.a(new BluedUIHttpResponse(this) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {}
          },  UserInfo.a().i().getUid(), map);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\presenter\VIPCenterTabPageNewPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */