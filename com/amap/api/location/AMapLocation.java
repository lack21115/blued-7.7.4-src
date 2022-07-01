package com.amap.api.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.loc.ej;
import com.loc.ep;
import org.json.JSONObject;

public class AMapLocation extends Location implements Parcelable, Cloneable {
  public static final String COORD_TYPE_GCJ02 = "GCJ02";
  
  public static final String COORD_TYPE_WGS84 = "WGS84";
  
  public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() {
    
    };
  
  public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
  
  public static final int ERROR_CODE_FAILURE_AUTH = 7;
  
  public static final int ERROR_CODE_FAILURE_CELL = 11;
  
  public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
  
  public static final int ERROR_CODE_FAILURE_INIT = 9;
  
  public static final int ERROR_CODE_FAILURE_LOCATION = 6;
  
  public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
  
  public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
  
  public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
  
  public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
  
  public static final int ERROR_CODE_FAILURE_PARSER = 5;
  
  public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
  
  public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
  
  public static final int ERROR_CODE_INVALID_PARAMETER = 1;
  
  public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
  
  public static final int ERROR_CODE_SERVICE_FAIL = 10;
  
  public static final int ERROR_CODE_UNKNOWN = 8;
  
  public static final int GPS_ACCURACY_BAD = 0;
  
  public static final int GPS_ACCURACY_GOOD = 1;
  
  public static final int GPS_ACCURACY_UNKNOWN = -1;
  
  public static final int LOCATION_SUCCESS = 0;
  
  public static final int LOCATION_TYPE_AMAP = 7;
  
  public static final int LOCATION_TYPE_CELL = 6;
  
  public static final int LOCATION_TYPE_FAST = 3;
  
  public static final int LOCATION_TYPE_FIX_CACHE = 4;
  
  public static final int LOCATION_TYPE_GPS = 1;
  
  public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
  
  public static final int LOCATION_TYPE_OFFLINE = 8;
  
  public static final int LOCATION_TYPE_SAME_REQ = 2;
  
  public static final int LOCATION_TYPE_WIFI = 5;
  
  public static final int TRUSTED_LEVEL_BAD = 4;
  
  public static final int TRUSTED_LEVEL_HIGH = 1;
  
  public static final int TRUSTED_LEVEL_LOW = 3;
  
  public static final int TRUSTED_LEVEL_NORMAL = 2;
  
  private boolean A = false;
  
  private String B = "GCJ02";
  
  private int C = 1;
  
  private int D;
  
  protected String a = "";
  
  protected String b = "";
  
  AMapLocationQualityReport c = new AMapLocationQualityReport();
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private String i = "";
  
  private String j = "";
  
  private String k = "";
  
  private String l = "";
  
  private String m = "";
  
  private String n = "";
  
  private boolean o = true;
  
  private int p = 0;
  
  private String q = "success";
  
  private String r = "";
  
  private int s = 0;
  
  private double t = 0.0D;
  
  private double u = 0.0D;
  
  private int v = 0;
  
  private String w = "";
  
  private int x = -1;
  
  private boolean y = false;
  
  private String z = "";
  
  public AMapLocation(Location paramLocation) {
    super(paramLocation);
    this.t = paramLocation.getLatitude();
    this.u = paramLocation.getLongitude();
  }
  
  public AMapLocation(String paramString) {
    super(paramString);
  }
  
  public AMapLocation clone() {
    try {
      super.clone();
    } finally {
      Exception exception;
    } 
    AMapLocation aMapLocation = new AMapLocation(this);
    try {
      aMapLocation.setLatitude(this.t);
      aMapLocation.setLongitude(this.u);
      aMapLocation.setAdCode(this.h);
      aMapLocation.setAddress(this.i);
      aMapLocation.setAoiName(this.w);
      aMapLocation.setBuildingId(this.a);
      aMapLocation.setCity(this.e);
      aMapLocation.setCityCode(this.g);
      aMapLocation.setCountry(this.k);
      aMapLocation.setDistrict(this.f);
      aMapLocation.setErrorCode(this.p);
      aMapLocation.setErrorInfo(this.q);
      aMapLocation.setFloor(this.b);
      aMapLocation.setFixLastLocation(this.A);
      aMapLocation.setOffset(this.o);
      aMapLocation.setLocationDetail(this.r);
      aMapLocation.setLocationType(this.s);
      aMapLocation.setMock(this.y);
      aMapLocation.setNumber(this.n);
      aMapLocation.setPoiName(this.j);
      aMapLocation.setProvince(this.d);
      aMapLocation.setRoad(this.l);
      aMapLocation.setSatellites(this.v);
      aMapLocation.setGpsAccuracyStatus(this.x);
      aMapLocation.setStreet(this.m);
      aMapLocation.setDescription(this.z);
      aMapLocation.setExtras(getExtras());
      if (this.c != null)
        aMapLocation.setLocationQualityReport(this.c.clone()); 
      aMapLocation.setCoordType(this.B);
      return aMapLocation;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMapLocation", "clone");
    } 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getAccuracy() {
    return super.getAccuracy();
  }
  
  public String getAdCode() {
    return this.h;
  }
  
  public String getAddress() {
    return this.i;
  }
  
  public double getAltitude() {
    return super.getAltitude();
  }
  
  public String getAoiName() {
    return this.w;
  }
  
  public float getBearing() {
    return super.getBearing();
  }
  
  public String getBuildingId() {
    return this.a;
  }
  
  public String getCity() {
    return this.e;
  }
  
  public String getCityCode() {
    return this.g;
  }
  
  public int getConScenario() {
    return this.D;
  }
  
  public String getCoordType() {
    return this.B;
  }
  
  public String getCountry() {
    return this.k;
  }
  
  public String getDescription() {
    return this.z;
  }
  
  public String getDistrict() {
    return this.f;
  }
  
  public int getErrorCode() {
    return this.p;
  }
  
  public String getErrorInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.q);
    if (this.p != 0) {
      stringBuilder.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
      StringBuilder stringBuilder1 = new StringBuilder(",错误详细信息:");
      stringBuilder1.append(this.r);
      stringBuilder.append(stringBuilder1.toString());
    } 
    return stringBuilder.toString();
  }
  
  public String getFloor() {
    return this.b;
  }
  
  public int getGpsAccuracyStatus() {
    return this.x;
  }
  
  public double getLatitude() {
    return this.t;
  }
  
  public String getLocationDetail() {
    return this.r;
  }
  
  public AMapLocationQualityReport getLocationQualityReport() {
    return this.c;
  }
  
  public int getLocationType() {
    return this.s;
  }
  
  public double getLongitude() {
    return this.u;
  }
  
  public String getPoiName() {
    return this.j;
  }
  
  public String getProvider() {
    return super.getProvider();
  }
  
  public String getProvince() {
    return this.d;
  }
  
  public String getRoad() {
    return this.l;
  }
  
  public int getSatellites() {
    return this.v;
  }
  
  public float getSpeed() {
    return super.getSpeed();
  }
  
  public String getStreet() {
    return this.m;
  }
  
  public String getStreetNum() {
    return this.n;
  }
  
  public int getTrustedLevel() {
    return this.C;
  }
  
  public boolean isFixLastLocation() {
    return this.A;
  }
  
  public boolean isMock() {
    return this.y;
  }
  
  public boolean isOffset() {
    return this.o;
  }
  
  public void setAdCode(String paramString) {
    this.h = paramString;
  }
  
  public void setAddress(String paramString) {
    this.i = paramString;
  }
  
  public void setAoiName(String paramString) {
    this.w = paramString;
  }
  
  public void setBuildingId(String paramString) {
    this.a = paramString;
  }
  
  public void setCity(String paramString) {
    this.e = paramString;
  }
  
  public void setCityCode(String paramString) {
    this.g = paramString;
  }
  
  public void setConScenario(int paramInt) {
    this.D = paramInt;
  }
  
  public void setCoordType(String paramString) {
    this.B = paramString;
  }
  
  public void setCountry(String paramString) {
    this.k = paramString;
  }
  
  public void setDescription(String paramString) {
    this.z = paramString;
  }
  
  public void setDistrict(String paramString) {
    this.f = paramString;
  }
  
  public void setErrorCode(int paramInt) {
    if (this.p != 0)
      return; 
    this.q = ep.b(paramInt);
    this.p = paramInt;
  }
  
  public void setErrorInfo(String paramString) {
    this.q = paramString;
  }
  
  public void setFixLastLocation(boolean paramBoolean) {
    this.A = paramBoolean;
  }
  
  public void setFloor(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replace("F", "");
      try {
        Integer.parseInt(str);
      } finally {
        paramString = null;
        ej.a((Throwable)paramString, "AmapLoc", "setFloor");
      } 
    } 
    this.b = str;
  }
  
  public void setGpsAccuracyStatus(int paramInt) {
    this.x = paramInt;
  }
  
  public void setLatitude(double paramDouble) {
    this.t = paramDouble;
  }
  
  public void setLocationDetail(String paramString) {
    this.r = paramString;
  }
  
  public void setLocationQualityReport(AMapLocationQualityReport paramAMapLocationQualityReport) {
    if (paramAMapLocationQualityReport == null)
      return; 
    this.c = paramAMapLocationQualityReport;
  }
  
  public void setLocationType(int paramInt) {
    this.s = paramInt;
  }
  
  public void setLongitude(double paramDouble) {
    this.u = paramDouble;
  }
  
  public void setMock(boolean paramBoolean) {
    this.y = paramBoolean;
  }
  
  public void setNumber(String paramString) {
    this.n = paramString;
  }
  
  public void setOffset(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public void setPoiName(String paramString) {
    this.j = paramString;
  }
  
  public void setProvince(String paramString) {
    this.d = paramString;
  }
  
  public void setRoad(String paramString) {
    this.l = paramString;
  }
  
  public void setSatellites(int paramInt) {
    this.v = paramInt;
  }
  
  public void setStreet(String paramString) {
    this.m = paramString;
  }
  
  public void setTrustedLevel(int paramInt) {
    this.C = paramInt;
  }
  
  public JSONObject toJson(int paramInt) {
    try {
      JSONObject jSONObject = new JSONObject();
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3)
            return jSONObject; 
          jSONObject.put("provider", getProvider());
          jSONObject.put("lon", getLongitude());
          jSONObject.put("lat", getLatitude());
          jSONObject.put("accuracy", getAccuracy());
          jSONObject.put("isOffset", this.o);
          return jSONObject;
        } 
      } else {
        try {
          jSONObject.put("altitude", getAltitude());
          jSONObject.put("speed", getSpeed());
          jSONObject.put("bearing", getBearing());
        } finally {
          Exception exception;
        } 
        jSONObject.put("citycode", this.g);
        jSONObject.put("adcode", this.h);
        jSONObject.put("country", this.k);
        jSONObject.put("province", this.d);
        jSONObject.put("city", this.e);
        jSONObject.put("district", this.f);
        jSONObject.put("road", this.l);
        jSONObject.put("street", this.m);
        jSONObject.put("number", this.n);
        jSONObject.put("poiname", this.j);
        jSONObject.put("errorCode", this.p);
        jSONObject.put("errorInfo", this.q);
        jSONObject.put("locationType", this.s);
        jSONObject.put("locationDetail", this.r);
        jSONObject.put("aoiname", this.w);
        jSONObject.put("address", this.i);
        jSONObject.put("poiid", this.a);
        jSONObject.put("floor", this.b);
        jSONObject.put("description", this.z);
      } 
      jSONObject.put("time", getTime());
      jSONObject.put("provider", getProvider());
      jSONObject.put("lon", getLongitude());
      jSONObject.put("lat", getLatitude());
      jSONObject.put("accuracy", getAccuracy());
      jSONObject.put("isOffset", this.o);
      return jSONObject;
    } finally {
      Exception exception = null;
      ej.a(exception, "AmapLoc", "toStr");
    } 
  }
  
  public String toStr() {
    return toStr(1);
  }
  
  public String toStr(int paramInt) {
    Exception exception;
    try {
      JSONObject jSONObject = toJson(paramInt);
    } finally {
      exception = null;
      ej.a(exception, "AMapLocation", "toStr part2");
    } 
    return (exception == null) ? null : exception.toString();
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    try {
      StringBuilder stringBuilder = new StringBuilder("latitude=");
      stringBuilder.append(this.t);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("longitude=");
      stringBuilder.append(this.u);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("province=");
      stringBuilder.append(this.d);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("coordType=");
      stringBuilder.append(this.B);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("city=");
      stringBuilder.append(this.e);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("district=");
      stringBuilder.append(this.f);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("cityCode=");
      stringBuilder.append(this.g);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("adCode=");
      stringBuilder.append(this.h);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("address=");
      stringBuilder.append(this.i);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("country=");
      stringBuilder.append(this.k);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("road=");
      stringBuilder.append(this.l);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("poiName=");
      stringBuilder.append(this.j);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("street=");
      stringBuilder.append(this.m);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("streetNum=");
      stringBuilder.append(this.n);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("aoiName=");
      stringBuilder.append(this.w);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("poiid=");
      stringBuilder.append(this.a);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("floor=");
      stringBuilder.append(this.b);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("errorCode=");
      stringBuilder.append(this.p);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("errorInfo=");
      stringBuilder.append(this.q);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("locationDetail=");
      stringBuilder.append(this.r);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("description=");
      stringBuilder.append(this.z);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("locationType=");
      stringBuilder.append(this.s);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("conScenario=");
      stringBuilder.append(this.D);
      stringBuffer.append(stringBuilder.toString());
    } finally {
      Exception exception;
    } 
    return stringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    try {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.w);
      paramParcel.writeString(this.a);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.k);
      paramParcel.writeString(this.f);
      paramParcel.writeInt(this.p);
      paramParcel.writeString(this.q);
      paramParcel.writeString(this.b);
      boolean bool1 = this.A;
      boolean bool = true;
      if (bool1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      paramParcel.writeInt(paramInt);
      if (this.o) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      paramParcel.writeInt(paramInt);
      paramParcel.writeDouble(this.t);
      paramParcel.writeString(this.r);
      paramParcel.writeInt(this.s);
      paramParcel.writeDouble(this.u);
      if (this.y) {
        paramInt = bool;
      } else {
        paramInt = 0;
      } 
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.j);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.l);
      paramParcel.writeInt(this.v);
      paramParcel.writeInt(this.x);
      paramParcel.writeString(this.m);
      paramParcel.writeString(this.z);
      paramParcel.writeString(this.B);
      return;
    } finally {
      paramParcel = null;
      ej.a((Throwable)paramParcel, "AMapLocation", "writeToParcel");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\AMapLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */