package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.loc.ej;

public class AMapLocationClientOption implements Parcelable, Cloneable {
  public static final Parcelable.Creator<AMapLocationClientOption> CREATOR;
  
  public static boolean OPEN_ALWAYS_SCAN_WIFI = false;
  
  public static long SCAN_WIFI_INTERVAL = 0L;
  
  static String a;
  
  private static int d = 0;
  
  private static int e = 1;
  
  private static int f = 2;
  
  private static int g = 4;
  
  private static AMapLocationProtocol p = AMapLocationProtocol.HTTP;
  
  private float A;
  
  private AMapLocationPurpose B;
  
  boolean b;
  
  String c;
  
  private long h;
  
  private long i;
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private AMapLocationMode o;
  
  private boolean q;
  
  private boolean r;
  
  private boolean s;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private boolean w;
  
  private long x;
  
  private long y;
  
  private GeoLanguage z;
  
  static {
    a = "";
    CREATOR = new Parcelable.Creator<AMapLocationClientOption>() {
      
      };
    OPEN_ALWAYS_SCAN_WIFI = true;
    SCAN_WIFI_INTERVAL = 30000L;
  }
  
  public AMapLocationClientOption() {
    this.h = 2000L;
    this.i = ej.g;
    this.j = false;
    this.k = true;
    this.l = true;
    this.m = true;
    this.n = true;
    this.o = AMapLocationMode.Hight_Accuracy;
    this.q = false;
    this.r = false;
    this.s = true;
    this.t = true;
    this.u = false;
    this.v = false;
    this.w = true;
    this.x = 30000L;
    this.y = 30000L;
    this.z = GeoLanguage.DEFAULT;
    this.A = 0.0F;
    this.B = null;
    this.b = false;
    this.c = null;
  }
  
  protected AMapLocationClientOption(Parcel paramParcel) {
    AMapLocationMode aMapLocationMode;
    AMapLocationProtocol aMapLocationProtocol;
    GeoLanguage geoLanguage1;
    AMapLocationPurpose aMapLocationPurpose;
    this.h = 2000L;
    this.i = ej.g;
    boolean bool2 = false;
    this.j = false;
    this.k = true;
    this.l = true;
    this.m = true;
    this.n = true;
    this.o = AMapLocationMode.Hight_Accuracy;
    this.q = false;
    this.r = false;
    this.s = true;
    this.t = true;
    this.u = false;
    this.v = false;
    this.w = true;
    this.x = 30000L;
    this.y = 30000L;
    this.z = GeoLanguage.DEFAULT;
    this.A = 0.0F;
    GeoLanguage geoLanguage2 = null;
    this.B = null;
    this.b = false;
    this.c = null;
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.j = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.k = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.l = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.m = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.n = bool1;
    int i = paramParcel.readInt();
    if (i == -1) {
      aMapLocationMode = AMapLocationMode.Hight_Accuracy;
    } else {
      aMapLocationMode = AMapLocationMode.values()[i];
    } 
    this.o = aMapLocationMode;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.q = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.r = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.s = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.t = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.u = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.v = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.w = bool1;
    this.x = paramParcel.readLong();
    i = paramParcel.readInt();
    if (i == -1) {
      aMapLocationProtocol = AMapLocationProtocol.HTTP;
    } else {
      aMapLocationProtocol = AMapLocationProtocol.values()[i];
    } 
    p = aMapLocationProtocol;
    i = paramParcel.readInt();
    if (i == -1) {
      geoLanguage1 = GeoLanguage.DEFAULT;
    } else {
      geoLanguage1 = GeoLanguage.values()[i];
    } 
    this.z = geoLanguage1;
    this.A = paramParcel.readFloat();
    i = paramParcel.readInt();
    if (i == -1) {
      geoLanguage1 = geoLanguage2;
    } else {
      aMapLocationPurpose = AMapLocationPurpose.values()[i];
    } 
    this.B = aMapLocationPurpose;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0)
      bool1 = true; 
    OPEN_ALWAYS_SCAN_WIFI = bool1;
    this.y = paramParcel.readLong();
  }
  
  public static String getAPIKEY() {
    return a;
  }
  
  public static boolean isDownloadCoordinateConvertLibrary() {
    return false;
  }
  
  public static boolean isOpenAlwaysScanWifi() {
    return OPEN_ALWAYS_SCAN_WIFI;
  }
  
  public static void setDownloadCoordinateConvertLibrary(boolean paramBoolean) {}
  
  public static void setLocationProtocol(AMapLocationProtocol paramAMapLocationProtocol) {
    p = paramAMapLocationProtocol;
  }
  
  public static void setOpenAlwaysScanWifi(boolean paramBoolean) {
    OPEN_ALWAYS_SCAN_WIFI = paramBoolean;
  }
  
  public static void setScanWifiInterval(long paramLong) {
    SCAN_WIFI_INTERVAL = paramLong;
  }
  
  public AMapLocationClientOption clone() {
    AMapLocationClientOption aMapLocationClientOption;
    try {
      super.clone();
    } finally {
      Exception exception = null;
    } 
    aMapLocationClientOption.h = this.h;
    aMapLocationClientOption.j = this.j;
    aMapLocationClientOption.o = this.o;
    aMapLocationClientOption.k = this.k;
    aMapLocationClientOption.q = this.q;
    aMapLocationClientOption.r = this.r;
    aMapLocationClientOption.l = this.l;
    aMapLocationClientOption.m = this.m;
    aMapLocationClientOption.i = this.i;
    aMapLocationClientOption.s = this.s;
    aMapLocationClientOption.t = this.t;
    aMapLocationClientOption.u = this.u;
    aMapLocationClientOption.v = isSensorEnable();
    aMapLocationClientOption.w = isWifiScan();
    aMapLocationClientOption.x = this.x;
    setLocationProtocol(getLocationProtocol());
    aMapLocationClientOption.z = this.z;
    setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
    aMapLocationClientOption.A = this.A;
    aMapLocationClientOption.B = this.B;
    setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
    setScanWifiInterval(getScanWifiInterval());
    aMapLocationClientOption.y = this.y;
    return aMapLocationClientOption;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getDeviceModeDistanceFilter() {
    return this.A;
  }
  
  public GeoLanguage getGeoLanguage() {
    return this.z;
  }
  
  public long getGpsFirstTimeout() {
    return this.y;
  }
  
  public long getHttpTimeOut() {
    return this.i;
  }
  
  public long getInterval() {
    return this.h;
  }
  
  public long getLastLocationLifeCycle() {
    return this.x;
  }
  
  public AMapLocationMode getLocationMode() {
    return this.o;
  }
  
  public AMapLocationProtocol getLocationProtocol() {
    return p;
  }
  
  public AMapLocationPurpose getLocationPurpose() {
    return this.B;
  }
  
  public long getScanWifiInterval() {
    return SCAN_WIFI_INTERVAL;
  }
  
  public boolean isGpsFirst() {
    return this.r;
  }
  
  public boolean isKillProcess() {
    return this.q;
  }
  
  public boolean isLocationCacheEnable() {
    return this.t;
  }
  
  public boolean isMockEnable() {
    return this.k;
  }
  
  public boolean isNeedAddress() {
    return this.l;
  }
  
  public boolean isOffset() {
    return this.s;
  }
  
  public boolean isOnceLocation() {
    return this.j;
  }
  
  public boolean isOnceLocationLatest() {
    return this.u;
  }
  
  public boolean isSensorEnable() {
    return this.v;
  }
  
  public boolean isWifiActiveScan() {
    return this.m;
  }
  
  public boolean isWifiScan() {
    return this.w;
  }
  
  public AMapLocationClientOption setDeviceModeDistanceFilter(float paramFloat) {
    this.A = paramFloat;
    return this;
  }
  
  public AMapLocationClientOption setGeoLanguage(GeoLanguage paramGeoLanguage) {
    this.z = paramGeoLanguage;
    return this;
  }
  
  public AMapLocationClientOption setGpsFirst(boolean paramBoolean) {
    this.r = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setGpsFirstTimeout(long paramLong) {
    long l = paramLong;
    if (paramLong < 5000L)
      l = 5000L; 
    paramLong = l;
    if (l > 30000L)
      paramLong = 30000L; 
    this.y = paramLong;
    return this;
  }
  
  public AMapLocationClientOption setHttpTimeOut(long paramLong) {
    this.i = paramLong;
    return this;
  }
  
  public AMapLocationClientOption setInterval(long paramLong) {
    long l = paramLong;
    if (paramLong <= 800L)
      l = 800L; 
    this.h = l;
    return this;
  }
  
  public AMapLocationClientOption setKillProcess(boolean paramBoolean) {
    this.q = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setLastLocationLifeCycle(long paramLong) {
    this.x = paramLong;
    return this;
  }
  
  public AMapLocationClientOption setLocationCacheEnable(boolean paramBoolean) {
    this.t = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setLocationMode(AMapLocationMode paramAMapLocationMode) {
    this.o = paramAMapLocationMode;
    return this;
  }
  
  public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose paramAMapLocationPurpose) {
    this.B = paramAMapLocationPurpose;
    if (paramAMapLocationPurpose != null) {
      int i = null.a[paramAMapLocationPurpose.ordinal()];
      if (i != 1) {
        String str;
        if (i != 2) {
          if (i != 3)
            return this; 
          i = d;
          int k = g;
          if ((i & k) == 0) {
            this.b = true;
            d = i | k;
            str = "sport";
          } else {
            this.o = AMapLocationMode.Hight_Accuracy;
            this.j = false;
            this.u = false;
            this.r = true;
            this.k = false;
            this.w = true;
            return this;
          } 
        } else {
          i = d;
          int k = f;
          if ((i & k) == 0) {
            this.b = true;
            d = i | k;
            str = "transport";
          } else {
            this.o = AMapLocationMode.Hight_Accuracy;
            this.j = false;
            this.u = false;
            this.r = true;
            this.k = false;
            this.w = true;
            return this;
          } 
        } 
        this.c = str;
        this.o = AMapLocationMode.Hight_Accuracy;
        this.j = false;
        this.u = false;
        this.r = true;
        this.k = false;
        this.w = true;
        return this;
      } 
      this.o = AMapLocationMode.Hight_Accuracy;
      this.j = true;
      this.u = true;
      this.r = false;
      this.k = false;
      this.w = true;
      i = d;
      int j = e;
      if ((i & j) == 0) {
        this.b = true;
        d = i | j;
        this.c = "signin";
      } 
    } 
    return this;
  }
  
  public AMapLocationClientOption setMockEnable(boolean paramBoolean) {
    this.k = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setNeedAddress(boolean paramBoolean) {
    this.l = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setOffset(boolean paramBoolean) {
    this.s = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setOnceLocation(boolean paramBoolean) {
    this.j = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setOnceLocationLatest(boolean paramBoolean) {
    this.u = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setSensorEnable(boolean paramBoolean) {
    this.v = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setWifiActiveScan(boolean paramBoolean) {
    this.m = paramBoolean;
    this.n = paramBoolean;
    return this;
  }
  
  public AMapLocationClientOption setWifiScan(boolean paramBoolean) {
    this.w = paramBoolean;
    if (this.w) {
      paramBoolean = this.n;
    } else {
      paramBoolean = false;
    } 
    this.m = paramBoolean;
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("interval:");
    stringBuilder.append(String.valueOf(this.h));
    stringBuilder.append("#");
    stringBuilder.append("isOnceLocation:");
    stringBuilder.append(String.valueOf(this.j));
    stringBuilder.append("#");
    stringBuilder.append("locationMode:");
    stringBuilder.append(String.valueOf(this.o));
    stringBuilder.append("#");
    stringBuilder.append("locationProtocol:");
    stringBuilder.append(String.valueOf(p));
    stringBuilder.append("#");
    stringBuilder.append("isMockEnable:");
    stringBuilder.append(String.valueOf(this.k));
    stringBuilder.append("#");
    stringBuilder.append("isKillProcess:");
    stringBuilder.append(String.valueOf(this.q));
    stringBuilder.append("#");
    stringBuilder.append("isGpsFirst:");
    stringBuilder.append(String.valueOf(this.r));
    stringBuilder.append("#");
    stringBuilder.append("isNeedAddress:");
    stringBuilder.append(String.valueOf(this.l));
    stringBuilder.append("#");
    stringBuilder.append("isWifiActiveScan:");
    stringBuilder.append(String.valueOf(this.m));
    stringBuilder.append("#");
    stringBuilder.append("wifiScan:");
    stringBuilder.append(String.valueOf(this.w));
    stringBuilder.append("#");
    stringBuilder.append("httpTimeOut:");
    stringBuilder.append(String.valueOf(this.i));
    stringBuilder.append("#");
    stringBuilder.append("isLocationCacheEnable:");
    stringBuilder.append(String.valueOf(this.t));
    stringBuilder.append("#");
    stringBuilder.append("isOnceLocationLatest:");
    stringBuilder.append(String.valueOf(this.u));
    stringBuilder.append("#");
    stringBuilder.append("sensorEnable:");
    stringBuilder.append(String.valueOf(this.v));
    stringBuilder.append("#");
    stringBuilder.append("geoLanguage:");
    stringBuilder.append(String.valueOf(this.z));
    stringBuilder.append("#");
    stringBuilder.append("locationPurpose:");
    stringBuilder.append(String.valueOf(this.B));
    stringBuilder.append("#");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public enum AMapLocationMode {
    Battery_Saving, Device_Sensors, Hight_Accuracy;
  }
  
  public enum AMapLocationProtocol {
    HTTP(0),
    HTTPS(1);
    
    private int a;
    
    AMapLocationProtocol(int param1Int1) {
      this.a = param1Int1;
    }
    
    public final int getValue() {
      return this.a;
    }
  }
  
  public enum AMapLocationPurpose {
    SignIn, Sport, Transport;
    
    static {
    
    }
  }
  
  public enum GeoLanguage {
    DEFAULT, EN, ZH;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\AMapLocationClientOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */