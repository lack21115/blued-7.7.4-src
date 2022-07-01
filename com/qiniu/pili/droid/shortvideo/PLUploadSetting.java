package com.qiniu.pili.droid.shortvideo;

import com.qiniu.android.common.FixedZone;
import com.qiniu.android.common.Zone;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.Map;

public class PLUploadSetting {
  private static final String TAG = "PLUploadSetting";
  
  private int mChunkSize = 2097152;
  
  private int mConnectTimeout = 10;
  
  private boolean mIsHttpsEnabled = false;
  
  private Map<String, String> mParams = null;
  
  private int mPutThreshhold = 4194304;
  
  private int mResponseTimeout = 60;
  
  private Zone mZone = null;
  
  public int getChunkSize() {
    return this.mChunkSize;
  }
  
  public int getConnectTimeout() {
    return this.mConnectTimeout;
  }
  
  public Map<String, String> getParams() {
    return this.mParams;
  }
  
  public int getPutThreshhold() {
    return this.mPutThreshhold;
  }
  
  public int getResponseTimeout() {
    return this.mResponseTimeout;
  }
  
  public Zone getZone() {
    return this.mZone;
  }
  
  public boolean isHttpsEnabled() {
    return this.mIsHttpsEnabled;
  }
  
  public PLUploadSetting setChunkSize(int paramInt) {
    this.mChunkSize = paramInt;
    e e = e.o;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setChunkSize: ");
    stringBuilder.append(paramInt);
    e.c("PLUploadSetting", stringBuilder.toString());
    return this;
  }
  
  public PLUploadSetting setConnectTimeout(int paramInt) {
    this.mConnectTimeout = paramInt;
    e e = e.o;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setConnectTimeout: ");
    stringBuilder.append(paramInt);
    e.c("PLUploadSetting", stringBuilder.toString());
    return this;
  }
  
  public PLUploadSetting setHttpsEnabled(boolean paramBoolean) {
    this.mIsHttpsEnabled = paramBoolean;
    e e = e.o;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setHttpsEnabled: ");
    stringBuilder.append(paramBoolean);
    e.c("PLUploadSetting", stringBuilder.toString());
    return this;
  }
  
  public PLUploadSetting setParams(Map<String, String> paramMap) {
    this.mParams = paramMap;
    e.o.c("PLUploadSetting", "setParams");
    return this;
  }
  
  public PLUploadSetting setPutThreshhold(int paramInt) {
    this.mPutThreshhold = paramInt;
    e e = e.o;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPutThreshhold: ");
    stringBuilder.append(paramInt);
    e.c("PLUploadSetting", stringBuilder.toString());
    return this;
  }
  
  public PLUploadSetting setResponseTimeout(int paramInt) {
    this.mResponseTimeout = paramInt;
    e e = e.o;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setResponseTimeout: ");
    stringBuilder.append(paramInt);
    e.c("PLUploadSetting", stringBuilder.toString());
    return this;
  }
  
  public PLUploadSetting setZone(PLUploadZone paramPLUploadZone) {
    int i = null.a[paramPLUploadZone.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5) {
              this.mZone = null;
            } else {
              this.mZone = FixedZone.zoneAs0;
            } 
          } else {
            this.mZone = FixedZone.zoneNa0;
          } 
        } else {
          this.mZone = FixedZone.zone2;
        } 
      } else {
        this.mZone = FixedZone.zone1;
      } 
    } else {
      this.mZone = FixedZone.zone0;
    } 
    e e = e.o;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setZone: ");
    stringBuilder.append(paramPLUploadZone);
    e.c("PLUploadSetting", stringBuilder.toString());
    return this;
  }
  
  public enum PLUploadZone {
    ZONE0, ZONE1, ZONE2, ZONEAS0, ZONENA0;
    
    static {
      $VALUES = new PLUploadZone[] { ZONE0, ZONE1, ZONE2, ZONENA0, ZONEAS0 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLUploadSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */