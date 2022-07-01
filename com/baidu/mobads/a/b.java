package com.baidu.mobads.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.a.d;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.File;

public class b extends d {
  protected final IXAdLogger a = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private a d;
  
  private String e;
  
  private File f;
  
  private Boolean g;
  
  public b(Context paramContext, String paramString, File paramFile, boolean paramBoolean) {
    super(paramContext);
    this.e = paramString;
    this.f = paramFile;
    this.g = Boolean.valueOf(paramBoolean);
  }
  
  public void a() {
    try {
      if (this.e != null) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.b.registerReceiver(this.d, intentFilter);
      } 
      XAdSDKFoundationFacade.getInstance().getPackageUtils().b(this.b, this.f);
      return;
    } catch (Exception exception) {
      this.a.e(new Object[] { "XAdInstallController", "" });
      return;
    } 
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver) {
    this.d = (a)paramBroadcastReceiver;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */