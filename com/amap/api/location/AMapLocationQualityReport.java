package com.amap.api.location;

import com.loc.ej;

public class AMapLocationQualityReport implements Cloneable {
  public static final int GPS_STATUS_MODE_SAVING = 3;
  
  public static final int GPS_STATUS_NOGPSPERMISSION = 4;
  
  public static final int GPS_STATUS_NOGPSPROVIDER = 1;
  
  public static final int GPS_STATUS_OFF = 2;
  
  public static final int GPS_STATUS_OK = 0;
  
  AMapLocationClientOption.AMapLocationMode a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
  
  private boolean b = false;
  
  private int c = 2;
  
  private int d = 0;
  
  private String e = "UNKNOWN";
  
  private long f = 0L;
  
  private boolean g = false;
  
  protected AMapLocationQualityReport clone() {
    AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
    try {
      super.clone();
    } finally {
      Exception exception;
    } 
    try {
      aMapLocationQualityReport.setGpsStatus(this.c);
      aMapLocationQualityReport.setGPSSatellites(this.d);
      aMapLocationQualityReport.setWifiAble(this.b);
      aMapLocationQualityReport.setNetUseTime(this.f);
      aMapLocationQualityReport.setNetworkType(this.e);
      return aMapLocationQualityReport;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMapLocationQualityReport", "clone");
    } 
  }
  
  public String getAdviseMessage() {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield a : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   12: getstatic com/amap/api/location/AMapLocationClientOption$AMapLocationMode.Battery_Saving : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   15: if_acmpeq -> 104
    //   18: aload_0
    //   19: getfield c : I
    //   22: istore_1
    //   23: iload_1
    //   24: ifeq -> 80
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq -> 68
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq -> 62
    //   37: iload_1
    //   38: iconst_3
    //   39: if_icmpeq -> 56
    //   42: iload_1
    //   43: iconst_4
    //   44: if_icmpeq -> 50
    //   47: goto -> 104
    //   50: ldc '您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\\n'
    //   52: astore_2
    //   53: goto -> 71
    //   56: ldc '您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\\n'
    //   58: astore_2
    //   59: goto -> 71
    //   62: ldc '您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\\n'
    //   64: astore_2
    //   65: goto -> 71
    //   68: ldc '您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\\n'
    //   70: astore_2
    //   71: aload_3
    //   72: aload_2
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   76: pop
    //   77: goto -> 104
    //   80: aload_0
    //   81: getfield a : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   84: getstatic com/amap/api/location/AMapLocationClientOption$AMapLocationMode.Device_Sensors : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   87: if_acmpne -> 104
    //   90: aload_0
    //   91: getfield d : I
    //   94: iconst_4
    //   95: if_icmpge -> 104
    //   98: ldc '当前GPS信号弱，位置更新可能会延迟\\n'
    //   100: astore_2
    //   101: goto -> 71
    //   104: aload_0
    //   105: getfield a : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   108: getstatic com/amap/api/location/AMapLocationClientOption$AMapLocationMode.Device_Sensors : Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   111: if_acmpeq -> 170
    //   114: ldc 'DISCONNECTED'
    //   116: aload_0
    //   117: getfield e : Ljava/lang/String;
    //   120: invokevirtual equals : (Ljava/lang/Object;)Z
    //   123: ifeq -> 138
    //   126: ldc '您的设备未连接到网络，无法进行网络定位\\n'
    //   128: astore_2
    //   129: aload_3
    //   130: aload_2
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: pop
    //   135: goto -> 156
    //   138: ldc '2G'
    //   140: aload_0
    //   141: getfield e : Ljava/lang/String;
    //   144: invokevirtual equals : (Ljava/lang/Object;)Z
    //   147: ifeq -> 156
    //   150: ldc '您的设备网络状态不太好，网络定位可能会有延迟\\n'
    //   152: astore_2
    //   153: goto -> 129
    //   156: aload_0
    //   157: getfield b : Z
    //   160: ifne -> 170
    //   163: aload_3
    //   164: ldc '您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\\n'
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   169: pop
    //   170: aload_3
    //   171: invokevirtual toString : ()Ljava/lang/String;
    //   174: areturn
  }
  
  public int getGPSSatellites() {
    return this.d;
  }
  
  public int getGPSStatus() {
    return this.c;
  }
  
  public long getNetUseTime() {
    return this.f;
  }
  
  public String getNetworkType() {
    return this.e;
  }
  
  public boolean isInstalledHighDangerMockApp() {
    return this.g;
  }
  
  public boolean isWifiAble() {
    return this.b;
  }
  
  public void setGPSSatellites(int paramInt) {
    this.d = paramInt;
  }
  
  public void setGpsStatus(int paramInt) {
    this.c = paramInt;
  }
  
  public void setInstallHighDangerMockApp(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void setLocationMode(AMapLocationClientOption.AMapLocationMode paramAMapLocationMode) {
    this.a = paramAMapLocationMode;
  }
  
  public void setNetUseTime(long paramLong) {
    this.f = paramLong;
  }
  
  public void setNetworkType(String paramString) {
    this.e = paramString;
  }
  
  public void setWifiAble(boolean paramBoolean) {
    this.b = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\AMapLocationQualityReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */