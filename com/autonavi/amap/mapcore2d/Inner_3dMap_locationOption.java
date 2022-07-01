package com.autonavi.amap.mapcore2d;

import com.amap.api.mapcore2d.gu;

public class Inner_3dMap_locationOption implements Cloneable {
  static String APIKEY;
  
  private static Inner_3dMap_Enum_LocationProtocol locationProtocol = Inner_3dMap_Enum_LocationProtocol.HTTP;
  
  private long httpTimeOut = gu.f;
  
  private long interval = 2000L;
  
  private boolean isGpsFirst = false;
  
  private boolean isKillProcess = false;
  
  private boolean isLocationCacheEnable = true;
  
  private boolean isMockEnable = false;
  
  private boolean isNeedAddress = true;
  
  private boolean isOffset = true;
  
  private boolean isOnceLocation = false;
  
  private boolean isOnceLocationLatest = false;
  
  private boolean isWifiActiveScan = true;
  
  private boolean isWifiScan = true;
  
  private boolean lastWifiActiveScan = true;
  
  private Inner_3dMap_Enum_LocationMode locationMode = Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
  
  private boolean sensorEnable = false;
  
  static {
    APIKEY = "";
  }
  
  private Inner_3dMap_locationOption clone(Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    this.interval = paramInner_3dMap_locationOption.interval;
    this.isOnceLocation = paramInner_3dMap_locationOption.isOnceLocation;
    this.locationMode = paramInner_3dMap_locationOption.locationMode;
    this.isMockEnable = paramInner_3dMap_locationOption.isMockEnable;
    this.isKillProcess = paramInner_3dMap_locationOption.isKillProcess;
    this.isGpsFirst = paramInner_3dMap_locationOption.isGpsFirst;
    this.isNeedAddress = paramInner_3dMap_locationOption.isNeedAddress;
    this.isWifiActiveScan = paramInner_3dMap_locationOption.isWifiActiveScan;
    this.httpTimeOut = paramInner_3dMap_locationOption.httpTimeOut;
    this.isOffset = paramInner_3dMap_locationOption.isOffset;
    this.isLocationCacheEnable = paramInner_3dMap_locationOption.isLocationCacheEnable;
    this.isOnceLocationLatest = paramInner_3dMap_locationOption.isOnceLocationLatest;
    this.sensorEnable = paramInner_3dMap_locationOption.isSensorEnable();
    this.isWifiScan = paramInner_3dMap_locationOption.isWifiScan();
    return this;
  }
  
  public static String getAPIKEY() {
    return APIKEY;
  }
  
  public static void setLocationProtocol(Inner_3dMap_Enum_LocationProtocol paramInner_3dMap_Enum_LocationProtocol) {
    locationProtocol = paramInner_3dMap_Enum_LocationProtocol;
  }
  
  public Inner_3dMap_locationOption clone() {
    try {
      super.clone();
    } finally {
      Exception exception = null;
    } 
  }
  
  public long getHttpTimeOut() {
    return this.httpTimeOut;
  }
  
  public long getInterval() {
    return this.interval;
  }
  
  public Inner_3dMap_Enum_LocationMode getLocationMode() {
    return this.locationMode;
  }
  
  public Inner_3dMap_Enum_LocationProtocol getLocationProtocol() {
    return locationProtocol;
  }
  
  public boolean isGpsFirst() {
    return this.isGpsFirst;
  }
  
  public boolean isKillProcess() {
    return this.isKillProcess;
  }
  
  public boolean isLocationCacheEnable() {
    return this.isLocationCacheEnable;
  }
  
  public boolean isMockEnable() {
    return this.isMockEnable;
  }
  
  public boolean isNeedAddress() {
    return this.isNeedAddress;
  }
  
  public boolean isOffset() {
    return this.isOffset;
  }
  
  public boolean isOnceLocation() {
    return this.isOnceLocationLatest ? true : this.isOnceLocation;
  }
  
  public boolean isOnceLocationLatest() {
    return this.isOnceLocationLatest;
  }
  
  public boolean isSensorEnable() {
    return this.sensorEnable;
  }
  
  public boolean isWifiActiveScan() {
    return this.isWifiActiveScan;
  }
  
  public boolean isWifiScan() {
    return this.isWifiScan;
  }
  
  public Inner_3dMap_locationOption setGpsFirst(boolean paramBoolean) {
    this.isGpsFirst = paramBoolean;
    return this;
  }
  
  public void setHttpTimeOut(long paramLong) {
    this.httpTimeOut = paramLong;
  }
  
  public Inner_3dMap_locationOption setInterval(long paramLong) {
    long l = paramLong;
    if (paramLong <= 800L)
      l = 800L; 
    this.interval = l;
    return this;
  }
  
  public Inner_3dMap_locationOption setKillProcess(boolean paramBoolean) {
    this.isKillProcess = paramBoolean;
    return this;
  }
  
  public void setLocationCacheEnable(boolean paramBoolean) {
    this.isLocationCacheEnable = paramBoolean;
  }
  
  public Inner_3dMap_locationOption setLocationMode(Inner_3dMap_Enum_LocationMode paramInner_3dMap_Enum_LocationMode) {
    this.locationMode = paramInner_3dMap_Enum_LocationMode;
    return this;
  }
  
  public void setMockEnable(boolean paramBoolean) {
    this.isMockEnable = paramBoolean;
  }
  
  public Inner_3dMap_locationOption setNeedAddress(boolean paramBoolean) {
    this.isNeedAddress = paramBoolean;
    return this;
  }
  
  public Inner_3dMap_locationOption setOffset(boolean paramBoolean) {
    this.isOffset = paramBoolean;
    return this;
  }
  
  public Inner_3dMap_locationOption setOnceLocation(boolean paramBoolean) {
    this.isOnceLocation = paramBoolean;
    return this;
  }
  
  public void setOnceLocationLatest(boolean paramBoolean) {
    this.isOnceLocationLatest = paramBoolean;
  }
  
  public void setSensorEnable(boolean paramBoolean) {
    this.sensorEnable = paramBoolean;
  }
  
  public void setWifiActiveScan(boolean paramBoolean) {
    this.isWifiActiveScan = paramBoolean;
    this.lastWifiActiveScan = paramBoolean;
  }
  
  public void setWifiScan(boolean paramBoolean) {
    this.isWifiScan = paramBoolean;
    if (this.isWifiScan) {
      paramBoolean = this.lastWifiActiveScan;
    } else {
      paramBoolean = false;
    } 
    this.isWifiActiveScan = paramBoolean;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("interval:");
    stringBuilder.append(String.valueOf(this.interval));
    stringBuilder.append("#");
    stringBuilder.append("isOnceLocation:");
    stringBuilder.append(String.valueOf(this.isOnceLocation));
    stringBuilder.append("#");
    stringBuilder.append("locationMode:");
    stringBuilder.append(String.valueOf(this.locationMode));
    stringBuilder.append("#");
    stringBuilder.append("isMockEnable:");
    stringBuilder.append(String.valueOf(this.isMockEnable));
    stringBuilder.append("#");
    stringBuilder.append("isKillProcess:");
    stringBuilder.append(String.valueOf(this.isKillProcess));
    stringBuilder.append("#");
    stringBuilder.append("isGpsFirst:");
    stringBuilder.append(String.valueOf(this.isGpsFirst));
    stringBuilder.append("#");
    stringBuilder.append("isNeedAddress:");
    stringBuilder.append(String.valueOf(this.isNeedAddress));
    stringBuilder.append("#");
    stringBuilder.append("isWifiActiveScan:");
    stringBuilder.append(String.valueOf(this.isWifiActiveScan));
    stringBuilder.append("#");
    stringBuilder.append("httpTimeOut:");
    stringBuilder.append(String.valueOf(this.httpTimeOut));
    stringBuilder.append("#");
    stringBuilder.append("isOffset:");
    stringBuilder.append(String.valueOf(this.isOffset));
    stringBuilder.append("#");
    stringBuilder.append("isLocationCacheEnable:");
    stringBuilder.append(String.valueOf(this.isLocationCacheEnable));
    stringBuilder.append("#");
    stringBuilder.append("isLocationCacheEnable:");
    stringBuilder.append(String.valueOf(this.isLocationCacheEnable));
    stringBuilder.append("#");
    stringBuilder.append("isOnceLocationLatest:");
    stringBuilder.append(String.valueOf(this.isOnceLocationLatest));
    stringBuilder.append("#");
    stringBuilder.append("sensorEnable:");
    stringBuilder.append(String.valueOf(this.sensorEnable));
    stringBuilder.append("#");
    return stringBuilder.toString();
  }
  
  public enum Inner_3dMap_Enum_LocationMode {
    Battery_Saving, Device_Sensors, Hight_Accuracy;
    
    static {
    
    }
  }
  
  public enum Inner_3dMap_Enum_LocationProtocol {
    HTTP(0),
    HTTPS(1);
    
    private int value;
    
    static {
    
    }
    
    Inner_3dMap_Enum_LocationProtocol(int param1Int1) {
      this.value = param1Int1;
    }
    
    public final int getValue() {
      return this.value;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\autonavi\amap\mapcore2d\Inner_3dMap_locationOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */