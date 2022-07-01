package com.huawei.hianalytics.hms;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.cd.ab.cd;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.kl.cd;
import com.huawei.hianalytics.ab.bc.kl.fg;
import com.huawei.hianalytics.ab.fg.ab;
import com.huawei.hianalytics.ab.fg.bc;
import com.huawei.hianalytics.ab.fg.cd;

public class HiAnalyticsConf {
  public static class Builder {
    String appid;
    
    Context mContext;
    
    cd maintData;
    
    cd operData;
    
    public Builder(Context param1Context) {
      if (param1Context != null)
        this.mContext = param1Context.getApplicationContext(); 
      this.operData = new cd();
      this.maintData = new cd();
    }
    
    public void create() {
      if (this.mContext == null) {
        ab.bc("hmsSdk", "analyticsConf create(): context is null,create failed!");
        return;
      } 
      ab.cd("hmsSdk", "Builder.create() is execute.");
      cd cd1 = new cd("_hms_config_tag");
      cd1.cd(new cd(this.operData));
      cd1.bc(new cd(this.maintData));
      ab.bc().ab(this.mContext);
      bc.ab().ab(this.mContext);
      ab.cd().ab(cd1);
      ab.bc().bc(this.appid);
    }
    
    public void refresh(boolean param1Boolean) {
      ab.cd("hmsSdk", "Builder.refresh() is execute.");
      cd cd1 = new cd(this.maintData);
      cd cd2 = new cd(this.operData);
      cd cd3 = ab.cd().bc();
      if (cd3 == null) {
        ab.ef("hmsSdk", "HiAnalyticsInstance.Builder.Refresh(): calling refresh before create. TAG: _hms_config_tag has no instance. ");
        return;
      } 
      cd3.ab(1, cd1);
      cd3.ab(0, cd2);
      if (this.appid != null)
        ab.bc().bc(this.appid); 
      if (param1Boolean)
        ab.bc().ab("_hms_config_tag"); 
    }
    
    public Builder setAndroidId(String param1String) {
      ab.cd("hmsSdk", "setAndroidId(String androidId) is execute.");
      String str = param1String;
      if (!cd.ab("androidId", param1String, 4096))
        str = ""; 
      this.operData.ef().ab(str);
      this.maintData.ef().ab(str);
      return this;
    }
    
    public Builder setAppID(String param1String) {
      ab.cd("hmsSdk", "Builder.setAppID is execute");
      this.appid = param1String;
      return this;
    }
    
    public Builder setChannel(String param1String) {
      ab.cd("hmsSdk", "Builder.setChannel(String channel) is execute.");
      String str = param1String;
      if (!cd.ab("channel", param1String, 256))
        str = ""; 
      this.operData.ab(str);
      this.maintData.ab(str);
      return this;
    }
    
    public Builder setCollectURL(int param1Int, String param1String) {
      cd cd1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Builder.setCollectURL(int type,String collectURL) is execute.TYPE : ");
      stringBuilder.append(param1Int);
      ab.cd("hmsSdk", stringBuilder.toString());
      String str = param1String;
      if (!fg.bc(param1String))
        str = ""; 
      if (param1Int != 0) {
        if (param1Int != 1) {
          ab.fg("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
          return this;
        } 
        cd1 = this.maintData;
      } else {
        cd1 = this.operData;
      } 
      cd1.bc(str);
      return this;
    }
    
    @Deprecated
    public Builder setEnableAndroidID(boolean param1Boolean) {
      ab.cd("hmsSdk", "Builder.setEnableAndroidID(boolean reportAndroidID) is execute.");
      this.operData.ef().ab(param1Boolean);
      this.maintData.ef().ab(param1Boolean);
      return this;
    }
    
    @Deprecated
    public Builder setEnableImei(boolean param1Boolean) {
      ab.cd("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
      this.operData.ef().bc(param1Boolean);
      this.maintData.ef().bc(param1Boolean);
      return this;
    }
    
    public Builder setEnableMccMnc(boolean param1Boolean) {
      ab.cd("hmsSdk", "Builder.setEnableMccMnc(boolean enableMccMnc) is execute.");
      this.operData.bc(param1Boolean);
      this.maintData.bc(param1Boolean);
      return this;
    }
    
    @Deprecated
    public Builder setEnableSN(boolean param1Boolean) {
      ab.cd("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
      this.operData.ef().cd(param1Boolean);
      this.maintData.ef().cd(param1Boolean);
      return this;
    }
    
    @Deprecated
    public Builder setEnableUDID(boolean param1Boolean) {
      ab.cd("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
      this.operData.ef().de(param1Boolean);
      this.maintData.ef().de(param1Boolean);
      return this;
    }
    
    public Builder setEnableUUID(boolean param1Boolean) {
      ab.ab("hmsSdk", "Builder.setEnableUUID() is executed.");
      this.operData.de(param1Boolean);
      this.maintData.de(param1Boolean);
      return this;
    }
    
    public Builder setIMEI(String param1String) {
      ab.cd("hmsSdk", "setIMEI(String imei) is execute.");
      String str = param1String;
      if (!cd.ab("imei", param1String, 4096))
        str = ""; 
      this.operData.ef().bc(str);
      this.maintData.ef().bc(str);
      return this;
    }
    
    public Builder setSDKPkgName(String param1String) {
      ab.ab("hmsSdk", "Builder.setSDKPkgName is executed");
      if (cd.ab("sdkPkgName", param1String, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}")) {
        this.operData.cd(param1String);
        this.maintData.cd(param1String);
      } 
      return this;
    }
    
    public Builder setSN(String param1String) {
      ab.cd("hmsSdk", "setSN(String sn) is execute.");
      String str = param1String;
      if (!cd.ab("sn", param1String, 4096))
        str = ""; 
      this.operData.ef().de(str);
      this.maintData.ef().de(str);
      return this;
    }
    
    public Builder setUDID(String param1String) {
      ab.cd("hmsSdk", "setUDID(String udid) is execute.");
      String str = param1String;
      if (!cd.ab("udid", param1String, 4096))
        str = ""; 
      this.operData.ef().cd(str);
      this.maintData.ef().cd(str);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\hms\HiAnalyticsConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */