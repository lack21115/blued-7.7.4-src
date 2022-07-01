package com.baidu.mobads.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;

public class a extends BroadcastReceiver {
  protected final IXAdLogger a = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private com.baidu.mobads.command.a b;
  
  public a(com.baidu.mobads.command.a parama) {
    this.b = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
      String str = paramIntent.getDataString().replace("package:", "");
      if (str.equals(this.b.i)) {
        r r = XAdSDKFoundationFacade.getInstance().getPackageUtils();
        if (this.b.w == true && this.b.x != null && !this.b.x.equals("")) {
          l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
          if (r.sendAPOInfo(paramContext, this.b.x, str, 381, l.getActTypeDownload(), 0))
            XAdSDKFoundationFacade.getInstance().getCommonUtils().browserOutside(paramContext, this.b.x); 
          paramContext.unregisterReceiver(this);
          return;
        } 
        if (this.b.l)
          try {
            Thread.sleep(600L);
            Intent intent = paramContext.getPackageManager().getLaunchIntentForPackage(str);
            intent.addFlags(268435456);
            paramContext.startActivity(intent);
            paramContext.unregisterReceiver(this);
            return;
          } catch (Exception exception) {
            this.a.d("InstallReceiver", exception);
          }  
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */