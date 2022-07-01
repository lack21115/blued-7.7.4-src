package com.baidu.mobads.command.c;

import android.content.Intent;
import android.os.Parcelable;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.AppActivityImp;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.XAdInstanceInfo;

public class c extends b {
  public String f = "";
  
  public String g = "";
  
  private String h = null;
  
  public c(IXNonLinearAdSlot paramIXNonLinearAdSlot, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdResource paramIXAdResource, String paramString) {
    super(paramIXNonLinearAdSlot, paramIXAdInstanceInfo, paramIXAdResource);
    this.h = paramString;
  }
  
  public void a() {
    try {
      h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
      IXAdActivityUtils iXAdActivityUtils = XAdSDKFoundationFacade.getInstance().getActivityUtils();
      XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(this.b.getProdInfo().getProdType(), this.c);
      xAdLandingPageExtraInfo.mIntTesting4LM = 999;
      xAdLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
      xAdLandingPageExtraInfo.url = this.h;
      xAdLandingPageExtraInfo.e75 = 1;
      xAdLandingPageExtraInfo.from = 0;
      xAdLandingPageExtraInfo.adid = this.c.getAdId();
      xAdLandingPageExtraInfo.qk = this.c.getQueryKey();
      xAdLandingPageExtraInfo.packageNameOfPubliser = this.a.getPackageName();
      xAdLandingPageExtraInfo.appsid = h.getAppId(this.a);
      xAdLandingPageExtraInfo.appsec = h.getAppSec(this.a);
      xAdLandingPageExtraInfo.title = this.c.getTitle();
      xAdLandingPageExtraInfo.lpShoubaiStyle = this.f;
      xAdLandingPageExtraInfo.lpMurl = this.g;
      Class clazz = AppActivity.getActivityClass();
      Intent intent = new Intent(this.a, clazz);
      if (this.b.getActivity() != null)
        xAdLandingPageExtraInfo.isFullScreen = iXAdActivityUtils.isFullScreen(this.b.getActivity()).booleanValue(); 
      xAdLandingPageExtraInfo.orientation = (this.a.getResources().getConfiguration()).orientation;
      if (AppActivity.isAnti()) {
        intent.putExtra("EXTRA_DATA_STRING", AppActivityImp.classToString(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo));
        intent.putExtra("EXTRA_DATA_STRING_COM", AppActivityImp.classToString(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo));
        intent.putExtra("EXTRA_DATA_STRING_AD", AppActivityImp.classToString(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo()));
      } else {
        intent.putExtra("EXTRA_DATA", (Parcelable)xAdLandingPageExtraInfo);
      } 
      intent.putExtra("theme", AppActivityImp.classToString(AppActivity.ActionBarColorTheme.class, AppActivity.getActionBarColorTheme()));
      intent.putExtra("showWhenLocked", AppActivity.getLpShowWhenLocked());
      intent.addFlags(268435456);
      intent.addFlags(536870912);
      this.a.startActivity(intent);
      return;
    } catch (Exception exception) {
      q.a().e(exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */