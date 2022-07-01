package com.qq.e.comm.managers.status;

import android.content.Context;
import com.qq.e.comm.util.StringUtil;

public class APPStatus {
  private String a;
  
  private Context b;
  
  public APPStatus(String paramString, Context paramContext) {
    this.a = paramString;
    this.b = paramContext;
  }
  
  public String getAPPID() {
    return this.a;
  }
  
  public String getAPPName() {
    return this.b.getPackageName();
  }
  
  public String getAPPRealName() {
    String str = getAPPName();
    if (!StringUtil.isEmpty(str))
      try {
        return (this.b.getPackageManager().getPackageInfo(str, 0)).applicationInfo.loadLabel(this.b.getPackageManager()).toString();
      } catch (Exception exception) {} 
    return null;
  }
  
  public String getAPPVersion() {
    String str = getAPPName();
    if (!StringUtil.isEmpty(str))
      try {
        return (this.b.getPackageManager().getPackageInfo(str, 0)).versionName;
      } catch (Exception exception) {} 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\status\APPStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */