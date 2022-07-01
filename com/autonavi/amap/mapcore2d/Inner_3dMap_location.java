package com.autonavi.amap.mapcore2d;

import android.location.Location;
import com.amap.api.mapcore2d.gu;
import com.amap.api.mapcore2d.gy;
import org.json.JSONObject;

public class Inner_3dMap_location extends Location implements Cloneable {
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
  
  public static final int LOCATION_TYPE_OFFLINE = 8;
  
  public static final int LOCATION_TYPE_SAME_REQ = 2;
  
  public static final int LOCATION_TYPE_WIFI = 5;
  
  private String adCode = "";
  
  private String address = "";
  
  private String aoiName = "";
  
  protected String buildingId = "";
  
  private String city = "";
  
  private String cityCode = "";
  
  private String country = "";
  
  protected String desc = "";
  
  private String district = "";
  
  private int errorCode = 0;
  
  private String errorInfo = "success";
  
  protected String floor = "";
  
  private boolean isOffset = true;
  
  private double latitude = 0.0D;
  
  private String locationDetail = "";
  
  private int locationType = 0;
  
  private double longitude = 0.0D;
  
  private String number = "";
  
  private String poiName = "";
  
  private String province = "";
  
  private String road = "";
  
  private int satellites = 0;
  
  private int signalIntensity = -1;
  
  private String street = "";
  
  public Inner_3dMap_location(Location paramLocation) {
    super(paramLocation);
    this.latitude = paramLocation.getLatitude();
    this.longitude = paramLocation.getLongitude();
  }
  
  public Inner_3dMap_location(String paramString) {
    super(paramString);
  }
  
  public Inner_3dMap_location clone() {
    try {
      super.clone();
    } finally {
      Exception exception;
    } 
    Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(this);
    inner_3dMap_location.setProvince(this.province);
    inner_3dMap_location.setCity(this.city);
    inner_3dMap_location.setDistrict(this.district);
    inner_3dMap_location.setCityCode(this.cityCode);
    inner_3dMap_location.setAdCode(this.adCode);
    inner_3dMap_location.setAddress(this.address);
    inner_3dMap_location.setPoiName(this.poiName);
    inner_3dMap_location.setCountry(this.country);
    inner_3dMap_location.setRoad(this.road);
    inner_3dMap_location.setStreet(this.street);
    inner_3dMap_location.setNumber(this.number);
    inner_3dMap_location.setOffset(this.isOffset);
    inner_3dMap_location.setErrorCode(this.errorCode);
    inner_3dMap_location.setErrorInfo(this.errorInfo);
    inner_3dMap_location.setLocationDetail(this.locationDetail);
    inner_3dMap_location.setLocationType(this.locationType);
    inner_3dMap_location.setLatitude(this.latitude);
    inner_3dMap_location.setLongitude(this.longitude);
    inner_3dMap_location.setSatellites(this.satellites);
    inner_3dMap_location.setAoiName(this.aoiName);
    inner_3dMap_location.setBuildingId(this.buildingId);
    inner_3dMap_location.setFloor(this.floor);
    inner_3dMap_location.setGpsAccuracyStatus(this.signalIntensity);
    inner_3dMap_location.setExtras(getExtras());
    return inner_3dMap_location;
  }
  
  public float getAccuracy() {
    return super.getAccuracy();
  }
  
  public String getAdCode() {
    return this.adCode;
  }
  
  public String getAddress() {
    return this.address;
  }
  
  public double getAltitude() {
    return super.getAltitude();
  }
  
  public String getAoiName() {
    return this.aoiName;
  }
  
  public float getBearing() {
    return super.getBearing();
  }
  
  public String getBuildingId() {
    return this.buildingId;
  }
  
  public String getCity() {
    return this.city;
  }
  
  public String getCityCode() {
    return this.cityCode;
  }
  
  public String getCountry() {
    return this.country;
  }
  
  public String getDistrict() {
    return this.district;
  }
  
  public int getErrorCode() {
    return this.errorCode;
  }
  
  public String getErrorInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.errorInfo);
    if (this.errorCode != 0) {
      stringBuilder.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
      StringBuilder stringBuilder1 = new StringBuilder(",错误详细信息:");
      stringBuilder1.append(this.locationDetail);
      stringBuilder.append(stringBuilder1.toString());
    } 
    this.errorInfo = stringBuilder.toString();
    return this.errorInfo;
  }
  
  public String getFloor() {
    return this.floor;
  }
  
  public int getGpsAccuracyStatus() {
    return this.signalIntensity;
  }
  
  public double getLatitude() {
    return this.latitude;
  }
  
  public String getLocationDetail() {
    return this.locationDetail;
  }
  
  public int getLocationType() {
    return this.locationType;
  }
  
  public double getLongitude() {
    return this.longitude;
  }
  
  public String getPoiName() {
    return this.poiName;
  }
  
  public String getProvider() {
    return super.getProvider();
  }
  
  public String getProvince() {
    return this.province;
  }
  
  public String getRoad() {
    return this.road;
  }
  
  public int getSatellites() {
    return this.satellites;
  }
  
  public float getSpeed() {
    return super.getSpeed();
  }
  
  public String getStreet() {
    return this.street;
  }
  
  public String getStreetNum() {
    return this.number;
  }
  
  public boolean isOffset() {
    return this.isOffset;
  }
  
  public void setAdCode(String paramString) {
    this.adCode = paramString;
  }
  
  public void setAddress(String paramString) {
    this.address = paramString;
  }
  
  public void setAoiName(String paramString) {
    this.aoiName = paramString;
  }
  
  public void setBuildingId(String paramString) {
    this.buildingId = paramString;
  }
  
  public void setCity(String paramString) {
    this.city = paramString;
  }
  
  public void setCityCode(String paramString) {
    this.cityCode = paramString;
  }
  
  public void setCountry(String paramString) {
    this.country = paramString;
  }
  
  public void setDistrict(String paramString) {
    this.district = paramString;
  }
  
  public void setErrorCode(int paramInt) {
    if (this.errorCode != 0)
      return; 
    this.errorInfo = gy.b(paramInt);
    this.errorCode = paramInt;
  }
  
  public void setErrorInfo(String paramString) {
    this.errorInfo = paramString;
  }
  
  public void setFloor(String paramString) {
    this.floor = paramString;
  }
  
  public void setGpsAccuracyStatus(int paramInt) {
    this.signalIntensity = paramInt;
  }
  
  public void setLatitude(double paramDouble) {
    this.latitude = paramDouble;
  }
  
  public void setLocationDetail(String paramString) {
    this.locationDetail = paramString;
  }
  
  public void setLocationType(int paramInt) {
    this.locationType = paramInt;
  }
  
  public void setLongitude(double paramDouble) {
    this.longitude = paramDouble;
  }
  
  public void setNumber(String paramString) {
    this.number = paramString;
  }
  
  public void setOffset(boolean paramBoolean) {
    this.isOffset = paramBoolean;
  }
  
  public void setPoiName(String paramString) {
    this.poiName = paramString;
  }
  
  public void setProvince(String paramString) {
    this.province = paramString;
  }
  
  public void setRoad(String paramString) {
    this.road = paramString;
  }
  
  public void setSatellites(int paramInt) {
    this.satellites = paramInt;
  }
  
  public void setStreet(String paramString) {
    this.street = paramString;
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
        jSONObject.put("citycode", this.cityCode);
        jSONObject.put("desc", this.desc);
        jSONObject.put("adcode", this.adCode);
        jSONObject.put("country", this.country);
        jSONObject.put("province", this.province);
        jSONObject.put("city", this.city);
        jSONObject.put("district", this.district);
        jSONObject.put("road", this.road);
        jSONObject.put("street", this.street);
        jSONObject.put("number", this.number);
        jSONObject.put("poiname", this.poiName);
        jSONObject.put("errorCode", this.errorCode);
        jSONObject.put("errorInfo", this.errorInfo);
        jSONObject.put("locationType", this.locationType);
        jSONObject.put("locationDetail", this.locationDetail);
        jSONObject.put("aoiname", this.aoiName);
        jSONObject.put("address", this.address);
        jSONObject.put("poiid", this.buildingId);
        jSONObject.put("floor", this.floor);
      } 
      jSONObject.put("time", getTime());
      jSONObject.put("provider", getProvider());
      jSONObject.put("lon", getLongitude());
      jSONObject.put("lat", getLatitude());
      return jSONObject;
    } finally {
      Exception exception = null;
      gu.a(exception, "AmapLoc", "toStr");
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
      gu.a(exception, "AMapLocation", "toStr part2");
    } 
    return (exception == null) ? null : exception.toString();
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    try {
      StringBuilder stringBuilder = new StringBuilder("latitude=");
      stringBuilder.append(this.latitude);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("longitude=");
      stringBuilder.append(this.longitude);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("province=");
      stringBuilder.append(this.province);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("city=");
      stringBuilder.append(this.city);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("district=");
      stringBuilder.append(this.district);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("cityCode=");
      stringBuilder.append(this.cityCode);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("adCode=");
      stringBuilder.append(this.adCode);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("address=");
      stringBuilder.append(this.address);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("country=");
      stringBuilder.append(this.country);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("road=");
      stringBuilder.append(this.road);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("poiName=");
      stringBuilder.append(this.poiName);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("street=");
      stringBuilder.append(this.street);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("streetNum=");
      stringBuilder.append(this.number);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("aoiName=");
      stringBuilder.append(this.aoiName);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("poiid=");
      stringBuilder.append(this.buildingId);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("floor=");
      stringBuilder.append(this.floor);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("errorCode=");
      stringBuilder.append(this.errorCode);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("errorInfo=");
      stringBuilder.append(this.errorInfo);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("locationDetail=");
      stringBuilder.append(this.locationDetail);
      stringBuilder.append("#");
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder("locationType=");
      stringBuilder.append(this.locationType);
      stringBuffer.append(stringBuilder.toString());
    } finally {
      Exception exception;
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\autonavi\amap\mapcore2d\Inner_3dMap_location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */