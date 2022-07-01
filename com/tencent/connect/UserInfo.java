package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;

public class UserInfo extends BaseApi {
  public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";
  
  public UserInfo(Context paramContext, QQAuth paramQQAuth, QQToken paramQQToken) {
    super(paramQQAuth, paramQQToken);
  }
  
  public UserInfo(Context paramContext, QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  public void getOpenId(IUiListener paramIUiListener) {
    Bundle bundle = composeCGIParams();
    BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "oauth2.0/m_me", bundle, "GET", (IRequestListener)tempRequestListener);
  }
  
  public void getTenPayAddr(IUiListener paramIUiListener) {
    Bundle bundle = composeCGIParams();
    bundle.putString("ver", "1");
    BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "cft_info/get_tenpay_addr", bundle, "GET", (IRequestListener)tempRequestListener);
  }
  
  public void getUserInfo(IUiListener paramIUiListener) {
    Bundle bundle = composeCGIParams();
    BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/get_simple_userinfo", bundle, "GET", (IRequestListener)tempRequestListener);
  }
  
  public void getVipUserInfo(IUiListener paramIUiListener) {
    Bundle bundle = composeCGIParams();
    BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/get_vip_info", bundle, "GET", (IRequestListener)tempRequestListener);
  }
  
  public void getVipUserRichInfo(IUiListener paramIUiListener) {
    Bundle bundle = composeCGIParams();
    BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/get_vip_rich_info", bundle, "GET", (IRequestListener)tempRequestListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */