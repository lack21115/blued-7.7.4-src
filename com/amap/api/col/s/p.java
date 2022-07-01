package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePlanPath;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p {
  private static String[] a = new String[] { "010", "021", "022", "023", "1852", "1853" };
  
  public static BusRouteResult a(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("route"))
        return null; 
      BusRouteResult busRouteResult = new BusRouteResult();
      jSONObject = jSONObject.optJSONObject("route");
      if (jSONObject == null)
        return busRouteResult; 
      busRouteResult.setStartPos(b(jSONObject, "origin"));
      busRouteResult.setTargetPos(b(jSONObject, "destination"));
      busRouteResult.setTaxiCost(o(a(jSONObject, "taxi_cost")));
      if (!jSONObject.has("transits"))
        return busRouteResult; 
      JSONArray jSONArray = jSONObject.optJSONArray("transits");
      if (jSONArray == null)
        return busRouteResult; 
      busRouteResult.setPaths(a(jSONArray));
      return busRouteResult;
    } catch (JSONException jSONException) {
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static String a(JSONObject paramJSONObject, String paramString) throws JSONException {
    String str2 = "";
    if (paramJSONObject == null)
      return ""; 
    String str1 = str2;
    if (paramJSONObject.has(paramString)) {
      str1 = str2;
      if (!paramJSONObject.optString(paramString).equals("[]"))
        str1 = paramJSONObject.optString(paramString).trim(); 
    } 
    return str1;
  }
  
  public static ArrayList<SuggestionCity> a(JSONObject paramJSONObject) throws JSONException, NumberFormatException {
    ArrayList<SuggestionCity> arrayList = new ArrayList();
    if (!paramJSONObject.has("cities"))
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("cities");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null)
        arrayList.add(new SuggestionCity(a(jSONObject, "name"), a(jSONObject, "citycode"), a(jSONObject, "adcode"), n(a(jSONObject, "num")))); 
    } 
    return arrayList;
  }
  
  public static ArrayList<NearbyInfo> a(JSONObject paramJSONObject, boolean paramBoolean) throws JSONException {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'datas'
    //   3: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull -> 229
    //   11: aload_0
    //   12: invokevirtual length : ()I
    //   15: ifne -> 21
    //   18: goto -> 229
    //   21: new java/util/ArrayList
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #11
    //   30: aload_0
    //   31: invokevirtual length : ()I
    //   34: istore #7
    //   36: iconst_0
    //   37: istore #6
    //   39: iload #6
    //   41: iload #7
    //   43: if_icmpge -> 226
    //   46: aload_0
    //   47: iload #6
    //   49: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   52: astore #13
    //   54: aload #13
    //   56: ldc 'userid'
    //   58: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore #12
    //   63: aload #13
    //   65: ldc 'location'
    //   67: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore #14
    //   72: dconst_0
    //   73: dstore #4
    //   75: aload #14
    //   77: ifnull -> 116
    //   80: aload #14
    //   82: ldc ','
    //   84: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   87: astore #14
    //   89: aload #14
    //   91: arraylength
    //   92: iconst_2
    //   93: if_icmpne -> 116
    //   96: aload #14
    //   98: iconst_0
    //   99: aaload
    //   100: invokestatic p : (Ljava/lang/String;)D
    //   103: dstore_2
    //   104: aload #14
    //   106: iconst_1
    //   107: aaload
    //   108: invokestatic p : (Ljava/lang/String;)D
    //   111: dstore #4
    //   113: goto -> 118
    //   116: dconst_0
    //   117: dstore_2
    //   118: aload #13
    //   120: ldc 'distance'
    //   122: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore #14
    //   127: aload #13
    //   129: ldc 'updatetime'
    //   131: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic q : (Ljava/lang/String;)J
    //   137: lstore #9
    //   139: aload #14
    //   141: invokestatic n : (Ljava/lang/String;)I
    //   144: istore #8
    //   146: new com/amap/api/services/core/LatLonPoint
    //   149: dup
    //   150: dload #4
    //   152: dload_2
    //   153: invokespecial <init> : (DD)V
    //   156: astore #13
    //   158: new com/amap/api/services/nearby/NearbyInfo
    //   161: dup
    //   162: invokespecial <init> : ()V
    //   165: astore #14
    //   167: aload #14
    //   169: aload #12
    //   171: invokevirtual setUserID : (Ljava/lang/String;)V
    //   174: aload #14
    //   176: lload #9
    //   178: invokevirtual setTimeStamp : (J)V
    //   181: aload #14
    //   183: aload #13
    //   185: invokevirtual setPoint : (Lcom/amap/api/services/core/LatLonPoint;)V
    //   188: iload_1
    //   189: ifeq -> 202
    //   192: aload #14
    //   194: iload #8
    //   196: invokevirtual setDrivingDistance : (I)V
    //   199: goto -> 209
    //   202: aload #14
    //   204: iload #8
    //   206: invokevirtual setDistance : (I)V
    //   209: aload #11
    //   211: aload #14
    //   213: invokevirtual add : (Ljava/lang/Object;)Z
    //   216: pop
    //   217: iload #6
    //   219: iconst_1
    //   220: iadd
    //   221: istore #6
    //   223: goto -> 39
    //   226: aload #11
    //   228: areturn
    //   229: new java/util/ArrayList
    //   232: dup
    //   233: invokespecial <init> : ()V
    //   236: areturn
  }
  
  private static List<BusPath> a(JSONArray paramJSONArray) throws JSONException {
    ArrayList<BusPath> arrayList = new ArrayList();
    if (paramJSONArray == null)
      return arrayList; 
    int i;
    for (i = 0; i < paramJSONArray.length(); i++) {
      BusPath busPath = new BusPath();
      JSONObject jSONObject = paramJSONArray.optJSONObject(i);
      if (jSONObject != null) {
        busPath.setCost(o(a(jSONObject, "cost")));
        busPath.setDuration(q(a(jSONObject, "duration")));
        busPath.setNightBus(r(a(jSONObject, "nightflag")));
        busPath.setWalkDistance(o(a(jSONObject, "walking_distance")));
        busPath.setDistance(o(a(jSONObject, "distance")));
        JSONArray jSONArray = jSONObject.optJSONArray("segments");
        if (jSONArray != null) {
          Object object;
          ArrayList arrayList1 = new ArrayList();
          int j = 0;
          float f2 = 0.0F;
          float f1 = 0.0F;
          while (true) {
            j++;
            object = SYNTHETIC_LOCAL_VARIABLE_1;
          } 
          busPath.setSteps(arrayList1);
          busPath.setBusDistance(f2);
          busPath.setWalkDistance(object);
          arrayList.add(busPath);
        } 
      } 
      continue;
    } 
    return arrayList;
  }
  
  private static void a(DriveStep paramDriveStep, JSONObject paramJSONObject) throws AMapException {
    JSONArray jSONArray;
    ArrayList<TMC> arrayList;
    try {
      arrayList = new ArrayList();
      jSONArray = paramJSONObject.optJSONArray("tmcs");
      if (jSONArray == null)
        return; 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseTMCs");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
    for (int i = 0;; i++) {
      if (i < jSONArray.length()) {
        TMC tMC = new TMC();
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          tMC.setDistance(n(a(jSONObject, "distance")));
          tMC.setStatus(a(jSONObject, "status"));
          tMC.setPolyline(c(jSONObject, "polyline"));
          arrayList.add(tMC);
        } 
      } else {
        jSONException.setTMCs(arrayList);
        return;
      } 
    } 
  }
  
  private static void a(Path paramPath, List<WalkStep> paramList) {
    List list2 = paramPath.getPolyline();
    List list1 = list2;
    if (list2 == null)
      list1 = new ArrayList(); 
    for (WalkStep walkStep : paramList) {
      if (walkStep != null && walkStep.getPolyline() != null)
        list1.addAll(walkStep.getPolyline()); 
    } 
    paramPath.setPolyline(list1);
  }
  
  private static void a(RouteSearchCity paramRouteSearchCity, JSONObject paramJSONObject) throws AMapException {
    JSONArray jSONArray;
    ArrayList<District> arrayList;
    if (!paramJSONObject.has("districts"))
      return; 
    try {
      arrayList = new ArrayList();
      jSONArray = paramJSONObject.optJSONArray("districts");
      if (jSONArray == null) {
        paramRouteSearchCity.setDistricts(arrayList);
        return;
      } 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseCrossDistricts");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
    for (int i = 0;; i++) {
      if (i < jSONArray.length()) {
        District district = new District();
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          district.setDistrictName(a(jSONObject, "name"));
          district.setDistrictAdcode(a(jSONObject, "adcode"));
          arrayList.add(district);
        } 
      } else {
        jSONException.setDistricts(arrayList);
        return;
      } 
    } 
  }
  
  private static void a(TruckStep paramTruckStep, JSONObject paramJSONObject) throws AMapException {
    JSONArray jSONArray;
    ArrayList<RouteSearchCity> arrayList;
    try {
      arrayList = new ArrayList();
      jSONArray = paramJSONObject.optJSONArray("cities");
      if (jSONArray == null)
        return; 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseCrossCity");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
    for (int i = 0;; i++) {
      if (i < jSONArray.length()) {
        RouteSearchCity routeSearchCity = new RouteSearchCity();
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          routeSearchCity.setSearchCityName(a(jSONObject, "name"));
          routeSearchCity.setSearchCitycode(a(jSONObject, "citycode"));
          routeSearchCity.setSearchCityhAdCode(a(jSONObject, "adcode"));
          a(routeSearchCity, jSONObject);
          arrayList.add(routeSearchCity);
        } 
      } else {
        jSONException.setRouteSearchCityList(arrayList);
        return;
      } 
    } 
  }
  
  public static void a(JSONArray paramJSONArray, RegeocodeAddress paramRegeocodeAddress) throws JSONException {
    ArrayList<Crossroad> arrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++) {
      Crossroad crossroad = new Crossroad();
      JSONObject jSONObject = paramJSONArray.optJSONObject(i);
      if (jSONObject != null) {
        crossroad.setId(a(jSONObject, "id"));
        crossroad.setDirection(a(jSONObject, "direction"));
        crossroad.setDistance(o(a(jSONObject, "distance")));
        crossroad.setCenterPoint(b(jSONObject, "location"));
        crossroad.setFirstRoadId(a(jSONObject, "first_id"));
        crossroad.setFirstRoadName(a(jSONObject, "first_name"));
        crossroad.setSecondRoadId(a(jSONObject, "second_id"));
        crossroad.setSecondRoadName(a(jSONObject, "second_name"));
        arrayList.add(crossroad);
      } 
    } 
    paramRegeocodeAddress.setCrossroads(arrayList);
  }
  
  public static void a(JSONArray paramJSONArray, ArrayList<DistrictItem> paramArrayList, DistrictItem paramDistrictItem) throws JSONException {
    if (paramJSONArray == null)
      return; 
    for (int i = 0; i < paramJSONArray.length(); i++) {
      JSONObject jSONObject = paramJSONArray.optJSONObject(i);
      if (jSONObject != null) {
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(a(jSONObject, "citycode"));
        districtItem.setAdcode(a(jSONObject, "adcode"));
        districtItem.setName(a(jSONObject, "name"));
        districtItem.setLevel(a(jSONObject, "level"));
        districtItem.setCenter(b(jSONObject, "center"));
        if (jSONObject.has("polyline")) {
          String str = jSONObject.optString("polyline");
          if (str != null && str.length() > 0)
            districtItem.setDistrictBoundary(str.split("\\|")); 
        } 
        a(jSONObject.optJSONArray("districts"), new ArrayList<DistrictItem>(), districtItem);
        paramArrayList.add(districtItem);
      } 
    } 
    if (paramDistrictItem != null)
      paramDistrictItem.setSubDistrict(paramArrayList); 
  }
  
  public static void a(JSONObject paramJSONObject, RegeocodeAddress paramRegeocodeAddress) throws JSONException {
    paramRegeocodeAddress.setCountry(a(paramJSONObject, "country"));
    paramRegeocodeAddress.setCountryCode(a(paramJSONObject, "countrycode"));
    paramRegeocodeAddress.setProvince(a(paramJSONObject, "province"));
    paramRegeocodeAddress.setCity(a(paramJSONObject, "city"));
    paramRegeocodeAddress.setCityCode(a(paramJSONObject, "citycode"));
    paramRegeocodeAddress.setAdCode(a(paramJSONObject, "adcode"));
    paramRegeocodeAddress.setDistrict(a(paramJSONObject, "district"));
    paramRegeocodeAddress.setTownship(a(paramJSONObject, "township"));
    paramRegeocodeAddress.setNeighborhood(a(paramJSONObject.optJSONObject("neighborhood"), "name"));
    paramRegeocodeAddress.setBuilding(a(paramJSONObject.optJSONObject("building"), "name"));
    StreetNumber streetNumber = new StreetNumber();
    JSONObject jSONObject = paramJSONObject.optJSONObject("streetNumber");
    streetNumber.setStreet(a(jSONObject, "street"));
    streetNumber.setNumber(a(jSONObject, "number"));
    streetNumber.setLatLonPoint(b(jSONObject, "location"));
    streetNumber.setDirection(a(jSONObject, "direction"));
    streetNumber.setDistance(o(a(jSONObject, "distance")));
    paramRegeocodeAddress.setStreetNumber(streetNumber);
    ArrayList<BusinessArea> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("businessAreas");
    if (jSONArray != null && jSONArray.length() != 0)
      for (int i = 0; i < jSONArray.length(); i++) {
        BusinessArea businessArea = new BusinessArea();
        JSONObject jSONObject1 = jSONArray.optJSONObject(i);
        if (jSONObject1 != null) {
          businessArea.setCenterPoint(b(jSONObject1, "location"));
          businessArea.setName(a(jSONObject1, "name"));
          arrayList.add(businessArea);
        } 
      }  
    paramRegeocodeAddress.setBusinessAreas(arrayList);
    paramRegeocodeAddress.setTowncode(a(paramJSONObject, "towncode"));
    if ((paramRegeocodeAddress.getCity() == null || paramRegeocodeAddress.getCity().length() <= 0) && k(paramRegeocodeAddress.getCityCode()))
      paramRegeocodeAddress.setCity(paramRegeocodeAddress.getProvince()); 
  }
  
  private static LatLonPoint b(JSONObject paramJSONObject, String paramString) throws JSONException {
    return (paramJSONObject == null) ? null : (paramJSONObject.has(paramString) ? m(paramJSONObject.optString(paramString)) : null);
  }
  
  public static DriveRouteResult b(String paramString) throws AMapException {
    try {
      int i;
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("route"))
        return null; 
      DriveRouteResult driveRouteResult = new DriveRouteResult();
      jSONObject = jSONObject.optJSONObject("route");
      if (jSONObject == null)
        return driveRouteResult; 
      driveRouteResult.setStartPos(b(jSONObject, "origin"));
      driveRouteResult.setTargetPos(b(jSONObject, "destination"));
      driveRouteResult.setTaxiCost(o(a(jSONObject, "taxi_cost")));
      if (!jSONObject.has("paths"))
        return driveRouteResult; 
      JSONArray jSONArray = jSONObject.optJSONArray("paths");
      if (jSONArray == null)
        return driveRouteResult; 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseDriveRoute");
      throw new AMapException("协议解析错误 - ProtocolException");
    } finally {
      paramString = null;
      i.a((Throwable)paramString, "JSONHelper", "parseDriveRouteThrowable");
    } 
  }
  
  public static ArrayList<String> b(JSONObject paramJSONObject) throws JSONException {
    ArrayList<String> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("keywords");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++)
      arrayList.add(jSONArray.optString(i)); 
    return arrayList;
  }
  
  private static void b(DriveStep paramDriveStep, JSONObject paramJSONObject) throws AMapException {
    JSONArray jSONArray;
    ArrayList<RouteSearchCity> arrayList;
    try {
      arrayList = new ArrayList();
      jSONArray = paramJSONObject.optJSONArray("cities");
      if (jSONArray == null)
        return; 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseCrossCity");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
    for (int i = 0;; i++) {
      if (i < jSONArray.length()) {
        RouteSearchCity routeSearchCity = new RouteSearchCity();
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          routeSearchCity.setSearchCityName(a(jSONObject, "name"));
          routeSearchCity.setSearchCitycode(a(jSONObject, "citycode"));
          routeSearchCity.setSearchCityhAdCode(a(jSONObject, "adcode"));
          a(routeSearchCity, jSONObject);
          arrayList.add(routeSearchCity);
        } 
      } else {
        jSONException.setRouteSearchCityList(arrayList);
        return;
      } 
    } 
  }
  
  private static void b(Path paramPath, List<DriveStep> paramList) {
    List list2 = paramPath.getPolyline();
    List list1 = list2;
    if (list2 == null)
      list1 = new ArrayList(); 
    for (DriveStep driveStep : paramList) {
      if (driveStep != null && driveStep.getPolyline() != null)
        list1.addAll(driveStep.getPolyline()); 
    } 
    paramPath.setPolyline(list1);
  }
  
  private static void b(TruckStep paramTruckStep, JSONObject paramJSONObject) throws AMapException {
    JSONArray jSONArray;
    ArrayList<TMC> arrayList;
    try {
      arrayList = new ArrayList();
      jSONArray = paramJSONObject.optJSONArray("tmcs");
      if (jSONArray == null)
        return; 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseTMCs");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
    for (int i = 0;; i++) {
      if (i < jSONArray.length()) {
        TMC tMC = new TMC();
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          tMC.setDistance(n(a(jSONObject, "distance")));
          tMC.setStatus(a(jSONObject, "status"));
          tMC.setPolyline(c(jSONObject, "polyline"));
          arrayList.add(tMC);
        } 
      } else {
        jSONException.setTMCs(arrayList);
        return;
      } 
    } 
  }
  
  public static void b(JSONArray paramJSONArray, RegeocodeAddress paramRegeocodeAddress) throws JSONException {
    ArrayList<RegeocodeRoad> arrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++) {
      RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
      JSONObject jSONObject = paramJSONArray.optJSONObject(i);
      if (jSONObject != null) {
        regeocodeRoad.setId(a(jSONObject, "id"));
        regeocodeRoad.setName(a(jSONObject, "name"));
        regeocodeRoad.setLatLngPoint(b(jSONObject, "location"));
        regeocodeRoad.setDirection(a(jSONObject, "direction"));
        regeocodeRoad.setDistance(o(a(jSONObject, "distance")));
        arrayList.add(regeocodeRoad);
      } 
    } 
    paramRegeocodeAddress.setRoads(arrayList);
  }
  
  public static WalkRouteResult c(String paramString) throws AMapException {
    ArrayList<WalkPath> arrayList;
    JSONArray jSONArray;
    try {
      JSONObject jSONObject1 = new JSONObject(paramString);
      if (!jSONObject1.has("route"))
        return null; 
      WalkRouteResult walkRouteResult = new WalkRouteResult();
      JSONObject jSONObject2 = jSONObject1.optJSONObject("route");
      walkRouteResult.setStartPos(b(jSONObject2, "origin"));
      walkRouteResult.setTargetPos(b(jSONObject2, "destination"));
      if (!jSONObject2.has("paths"))
        return walkRouteResult; 
      arrayList = new ArrayList();
      jSONArray = jSONObject2.optJSONArray("paths");
      if (jSONArray == null) {
        walkRouteResult.setPaths(arrayList);
        return walkRouteResult;
      } 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseWalkRoute");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
    for (int i = 0;; i++) {
      if (i < jSONArray.length()) {
        WalkPath walkPath = new WalkPath();
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          walkPath.setDistance(o(a(jSONObject, "distance")));
          walkPath.setDuration(q(a(jSONObject, "duration")));
          if (jSONObject.has("steps")) {
            JSONArray jSONArray1 = jSONObject.optJSONArray("steps");
            ArrayList<WalkStep> arrayList1 = new ArrayList();
            if (jSONArray1 != null)
              for (int j = 0;; j++) {
                if (j < jSONArray1.length()) {
                  WalkStep walkStep = new WalkStep();
                  JSONObject jSONObject1 = jSONArray1.optJSONObject(j);
                  if (jSONObject1 != null) {
                    walkStep.setInstruction(a(jSONObject1, "instruction"));
                    walkStep.setOrientation(a(jSONObject1, "orientation"));
                    walkStep.setRoad(a(jSONObject1, "road"));
                    walkStep.setDistance(o(a(jSONObject1, "distance")));
                    walkStep.setDuration(o(a(jSONObject1, "duration")));
                    walkStep.setPolyline(c(jSONObject1, "polyline"));
                    walkStep.setAction(a(jSONObject1, "action"));
                    walkStep.setAssistantAction(a(jSONObject1, "assistant_action"));
                    arrayList1.add(walkStep);
                  } 
                } else {
                  walkPath.setSteps(arrayList1);
                  a((Path)walkPath, arrayList1);
                  arrayList.add(walkPath);
                  break;
                } 
              }  
          } else {
            continue;
          } 
        } 
      } else {
        jSONException.setPaths(arrayList);
        return (WalkRouteResult)jSONException;
      } 
    } 
  }
  
  public static ArrayList<PoiItem> c(JSONObject paramJSONObject) throws JSONException {
    ArrayList<PoiItem> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("pois");
    if (jSONArray != null) {
      if (jSONArray.length() == 0)
        return arrayList; 
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null)
          arrayList.add(d(jSONObject)); 
      } 
    } 
    return arrayList;
  }
  
  private static ArrayList<LatLonPoint> c(JSONObject paramJSONObject, String paramString) throws JSONException {
    return paramJSONObject.has(paramString) ? l(paramJSONObject.optString(paramString)) : null;
  }
  
  private static void c(Path paramPath, List<RideStep> paramList) {
    List list2 = paramPath.getPolyline();
    List list1 = list2;
    if (list2 == null)
      list1 = new ArrayList(); 
    for (RideStep rideStep : paramList) {
      if (rideStep != null && rideStep.getPolyline() != null)
        list1.addAll(rideStep.getPolyline()); 
    } 
    paramPath.setPolyline(list1);
  }
  
  public static void c(JSONArray paramJSONArray, RegeocodeAddress paramRegeocodeAddress) throws JSONException {
    ArrayList<AoiItem> arrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++) {
      AoiItem aoiItem = new AoiItem();
      JSONObject jSONObject = paramJSONArray.optJSONObject(i);
      if (jSONObject != null) {
        aoiItem.setId(a(jSONObject, "id"));
        aoiItem.setName(a(jSONObject, "name"));
        aoiItem.setAdcode(a(jSONObject, "adcode"));
        aoiItem.setLocation(b(jSONObject, "location"));
        aoiItem.setArea(Float.valueOf(o(a(jSONObject, "area"))));
        arrayList.add(aoiItem);
      } 
    } 
    paramRegeocodeAddress.setAois(arrayList);
  }
  
  public static PoiItem d(JSONObject paramJSONObject) throws JSONException {
    // Byte code:
    //   0: new com/amap/api/services/core/PoiItem
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 'id'
    //   8: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   11: aload_0
    //   12: ldc 'location'
    //   14: invokestatic b : (Lorg/json/JSONObject;Ljava/lang/String;)Lcom/amap/api/services/core/LatLonPoint;
    //   17: aload_0
    //   18: ldc 'name'
    //   20: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   23: aload_0
    //   24: ldc_w 'address'
    //   27: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   30: invokespecial <init> : (Ljava/lang/String;Lcom/amap/api/services/core/LatLonPoint;Ljava/lang/String;Ljava/lang/String;)V
    //   33: astore #6
    //   35: aload #6
    //   37: aload_0
    //   38: ldc 'adcode'
    //   40: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   43: invokevirtual setAdCode : (Ljava/lang/String;)V
    //   46: aload #6
    //   48: aload_0
    //   49: ldc_w 'pname'
    //   52: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   55: invokevirtual setProvinceName : (Ljava/lang/String;)V
    //   58: aload #6
    //   60: aload_0
    //   61: ldc_w 'cityname'
    //   64: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   67: invokevirtual setCityName : (Ljava/lang/String;)V
    //   70: aload #6
    //   72: aload_0
    //   73: ldc_w 'adname'
    //   76: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   79: invokevirtual setAdName : (Ljava/lang/String;)V
    //   82: aload #6
    //   84: aload_0
    //   85: ldc 'citycode'
    //   87: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual setCityCode : (Ljava/lang/String;)V
    //   93: aload #6
    //   95: aload_0
    //   96: ldc_w 'pcode'
    //   99: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   102: invokevirtual setProvinceCode : (Ljava/lang/String;)V
    //   105: aload #6
    //   107: aload_0
    //   108: ldc_w 'direction'
    //   111: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   114: invokevirtual setDirection : (Ljava/lang/String;)V
    //   117: aload_0
    //   118: ldc 'distance'
    //   120: invokevirtual has : (Ljava/lang/String;)Z
    //   123: ifeq -> 178
    //   126: aload_0
    //   127: ldc 'distance'
    //   129: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore_3
    //   133: aload_3
    //   134: invokestatic f : (Ljava/lang/String;)Z
    //   137: ifne -> 178
    //   140: aload #6
    //   142: aload_3
    //   143: invokestatic parseFloat : (Ljava/lang/String;)F
    //   146: f2i
    //   147: invokevirtual setDistance : (I)V
    //   150: goto -> 178
    //   153: astore_3
    //   154: aload_3
    //   155: ldc_w 'JSONHelper'
    //   158: ldc_w 'parseBasePoi'
    //   161: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   164: goto -> 178
    //   167: astore_3
    //   168: aload_3
    //   169: ldc_w 'JSONHelper'
    //   172: ldc_w 'parseBasePoi'
    //   175: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload #6
    //   180: aload_0
    //   181: ldc_w 'tel'
    //   184: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual setTel : (Ljava/lang/String;)V
    //   190: aload #6
    //   192: aload_0
    //   193: ldc_w 'type'
    //   196: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   199: invokevirtual setTypeDes : (Ljava/lang/String;)V
    //   202: aload #6
    //   204: aload_0
    //   205: ldc_w 'entr_location'
    //   208: invokestatic b : (Lorg/json/JSONObject;Ljava/lang/String;)Lcom/amap/api/services/core/LatLonPoint;
    //   211: invokevirtual setEnter : (Lcom/amap/api/services/core/LatLonPoint;)V
    //   214: aload #6
    //   216: aload_0
    //   217: ldc_w 'exit_location'
    //   220: invokestatic b : (Lorg/json/JSONObject;Ljava/lang/String;)Lcom/amap/api/services/core/LatLonPoint;
    //   223: invokevirtual setExit : (Lcom/amap/api/services/core/LatLonPoint;)V
    //   226: aload #6
    //   228: aload_0
    //   229: ldc_w 'website'
    //   232: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   235: invokevirtual setWebsite : (Ljava/lang/String;)V
    //   238: aload #6
    //   240: aload_0
    //   241: ldc_w 'postcode'
    //   244: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   247: invokevirtual setPostcode : (Ljava/lang/String;)V
    //   250: aload_0
    //   251: ldc_w 'business_area'
    //   254: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   257: astore #4
    //   259: aload #4
    //   261: astore_3
    //   262: aload #4
    //   264: invokestatic f : (Ljava/lang/String;)Z
    //   267: ifeq -> 278
    //   270: aload_0
    //   271: ldc_w 'businessarea'
    //   274: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_3
    //   278: aload #6
    //   280: aload_3
    //   281: invokevirtual setBusinessArea : (Ljava/lang/String;)V
    //   284: aload #6
    //   286: aload_0
    //   287: ldc_w 'email'
    //   290: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   293: invokevirtual setEmail : (Ljava/lang/String;)V
    //   296: aload_0
    //   297: ldc_w 'indoor_map'
    //   300: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   303: astore_3
    //   304: iconst_0
    //   305: istore_2
    //   306: ldc ''
    //   308: astore #5
    //   310: aload_3
    //   311: ifnull -> 341
    //   314: aload_3
    //   315: ldc ''
    //   317: invokevirtual equals : (Ljava/lang/Object;)Z
    //   320: ifne -> 341
    //   323: aload_3
    //   324: ldc_w '0'
    //   327: invokevirtual equals : (Ljava/lang/Object;)Z
    //   330: ifeq -> 336
    //   333: goto -> 341
    //   336: iconst_0
    //   337: istore_1
    //   338: goto -> 343
    //   341: iconst_1
    //   342: istore_1
    //   343: iload_1
    //   344: ifeq -> 356
    //   347: aload #6
    //   349: iconst_0
    //   350: invokevirtual setIndoorMap : (Z)V
    //   353: goto -> 362
    //   356: aload #6
    //   358: iconst_1
    //   359: invokevirtual setIndoorMap : (Z)V
    //   362: aload #6
    //   364: aload_0
    //   365: ldc_w 'parking_type'
    //   368: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   371: invokevirtual setParkingType : (Ljava/lang/String;)V
    //   374: new java/util/ArrayList
    //   377: dup
    //   378: invokespecial <init> : ()V
    //   381: astore_3
    //   382: aload_0
    //   383: ldc_w 'children'
    //   386: invokevirtual has : (Ljava/lang/String;)Z
    //   389: ifeq -> 453
    //   392: aload_0
    //   393: ldc_w 'children'
    //   396: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   399: astore #4
    //   401: aload #4
    //   403: ifnull -> 447
    //   406: iconst_0
    //   407: istore_1
    //   408: iload_1
    //   409: aload #4
    //   411: invokevirtual length : ()I
    //   414: if_icmpge -> 447
    //   417: aload #4
    //   419: iload_1
    //   420: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   423: astore #7
    //   425: aload #7
    //   427: ifnull -> 440
    //   430: aload_3
    //   431: aload #7
    //   433: invokestatic j : (Lorg/json/JSONObject;)Lcom/amap/api/services/poisearch/SubPoiItem;
    //   436: invokevirtual add : (Ljava/lang/Object;)Z
    //   439: pop
    //   440: iload_1
    //   441: iconst_1
    //   442: iadd
    //   443: istore_1
    //   444: goto -> 408
    //   447: aload #6
    //   449: aload_3
    //   450: invokevirtual setSubPois : (Ljava/util/List;)V
    //   453: aload_0
    //   454: ldc_w 'indoor_data'
    //   457: invokevirtual has : (Ljava/lang/String;)Z
    //   460: ifeq -> 526
    //   463: aload_0
    //   464: ldc_w 'indoor_data'
    //   467: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   470: astore_3
    //   471: aload_3
    //   472: ifnull -> 526
    //   475: aload_3
    //   476: ldc_w 'cpid'
    //   479: invokevirtual has : (Ljava/lang/String;)Z
    //   482: ifeq -> 526
    //   485: aload_3
    //   486: ldc_w 'floor'
    //   489: invokevirtual has : (Ljava/lang/String;)Z
    //   492: ifeq -> 526
    //   495: aload_3
    //   496: ldc_w 'cpid'
    //   499: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   502: astore #4
    //   504: aload_3
    //   505: ldc_w 'floor'
    //   508: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   511: invokestatic n : (Ljava/lang/String;)I
    //   514: istore_1
    //   515: aload_3
    //   516: ldc_w 'truefloor'
    //   519: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   522: astore_3
    //   523: goto -> 534
    //   526: ldc ''
    //   528: astore_3
    //   529: aload_3
    //   530: astore #4
    //   532: iload_2
    //   533: istore_1
    //   534: aload #6
    //   536: new com/amap/api/services/poisearch/IndoorData
    //   539: dup
    //   540: aload #4
    //   542: iload_1
    //   543: aload_3
    //   544: invokespecial <init> : (Ljava/lang/String;ILjava/lang/String;)V
    //   547: invokevirtual setIndoorDate : (Lcom/amap/api/services/poisearch/IndoorData;)V
    //   550: aload_0
    //   551: ldc_w 'biz_ext'
    //   554: invokevirtual has : (Ljava/lang/String;)Z
    //   557: ifeq -> 592
    //   560: aload_0
    //   561: ldc_w 'biz_ext'
    //   564: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   567: astore_3
    //   568: aload_3
    //   569: ifnull -> 592
    //   572: aload_3
    //   573: ldc_w 'open_time'
    //   576: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   579: astore #4
    //   581: aload_3
    //   582: ldc_w 'rating'
    //   585: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   588: astore_3
    //   589: goto -> 599
    //   592: ldc ''
    //   594: astore_3
    //   595: aload #5
    //   597: astore #4
    //   599: aload #6
    //   601: new com/amap/api/services/poisearch/PoiItemExtension
    //   604: dup
    //   605: aload #4
    //   607: aload_3
    //   608: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   611: invokevirtual setPoiExtension : (Lcom/amap/api/services/poisearch/PoiItemExtension;)V
    //   614: aload #6
    //   616: aload_0
    //   617: ldc_w 'typecode'
    //   620: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   623: invokevirtual setTypeCode : (Ljava/lang/String;)V
    //   626: aload #6
    //   628: aload_0
    //   629: ldc_w 'shopid'
    //   632: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   635: invokevirtual setShopID : (Ljava/lang/String;)V
    //   638: aload_0
    //   639: ldc_w 'deep_info'
    //   642: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   645: invokestatic x : (Lorg/json/JSONObject;)Ljava/util/List;
    //   648: astore #4
    //   650: aload #4
    //   652: astore_3
    //   653: aload #4
    //   655: invokeinterface size : ()I
    //   660: ifne -> 668
    //   663: aload_0
    //   664: invokestatic x : (Lorg/json/JSONObject;)Ljava/util/List;
    //   667: astore_3
    //   668: aload #6
    //   670: aload_3
    //   671: invokevirtual setPhotos : (Ljava/util/List;)V
    //   674: aload #6
    //   676: areturn
    // Exception table:
    //   from	to	target	type
    //   140	150	167	java/lang/NumberFormatException
    //   140	150	153	java/lang/Exception
  }
  
  public static LocalWeatherLive d(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("lives"))
        return null; 
      LocalWeatherLive localWeatherLive = new LocalWeatherLive();
      JSONArray jSONArray = jSONObject.optJSONArray("lives");
      if (jSONArray != null) {
        if (jSONArray.length() <= 0)
          return localWeatherLive; 
        JSONObject jSONObject1 = jSONArray.optJSONObject(0);
        if (jSONObject1 == null)
          return localWeatherLive; 
        localWeatherLive.setAdCode(a(jSONObject1, "adcode"));
        localWeatherLive.setProvince(a(jSONObject1, "province"));
        localWeatherLive.setCity(a(jSONObject1, "city"));
        localWeatherLive.setWeather(a(jSONObject1, "weather"));
        localWeatherLive.setTemperature(a(jSONObject1, "temperature"));
        localWeatherLive.setWindDirection(a(jSONObject1, "winddirection"));
        localWeatherLive.setWindPower(a(jSONObject1, "windpower"));
        localWeatherLive.setHumidity(a(jSONObject1, "humidity"));
        localWeatherLive.setReportTime(a(jSONObject1, "reporttime"));
      } 
      return localWeatherLive;
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "WeatherForecastResult");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static LocalWeatherForecast e(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("forecasts"))
        return null; 
      LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
      JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
      if (jSONArray != null) {
        if (jSONArray.length() <= 0)
          return localWeatherForecast; 
        int i = 0;
        JSONObject jSONObject1 = jSONArray.optJSONObject(0);
        if (jSONObject1 == null)
          return localWeatherForecast; 
        localWeatherForecast.setCity(a(jSONObject1, "city"));
        localWeatherForecast.setAdCode(a(jSONObject1, "adcode"));
        localWeatherForecast.setProvince(a(jSONObject1, "province"));
        localWeatherForecast.setReportTime(a(jSONObject1, "reporttime"));
        if (!jSONObject1.has("casts"))
          return localWeatherForecast; 
        ArrayList<LocalDayWeatherForecast> arrayList = new ArrayList();
        JSONArray jSONArray1 = jSONObject1.optJSONArray("casts");
        if (jSONArray1 == null || jSONArray1.length() <= 0) {
          localWeatherForecast.setWeatherForecast(arrayList);
          return localWeatherForecast;
        } 
        while (true) {
          if (i < jSONArray1.length()) {
            LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
            JSONObject jSONObject2 = jSONArray1.optJSONObject(i);
            if (jSONObject2 != null) {
              localDayWeatherForecast.setDate(a(jSONObject2, "date"));
              localDayWeatherForecast.setWeek(a(jSONObject2, "week"));
              localDayWeatherForecast.setDayWeather(a(jSONObject2, "dayweather"));
              localDayWeatherForecast.setNightWeather(a(jSONObject2, "nightweather"));
              localDayWeatherForecast.setDayTemp(a(jSONObject2, "daytemp"));
              localDayWeatherForecast.setNightTemp(a(jSONObject2, "nighttemp"));
              localDayWeatherForecast.setDayWindDirection(a(jSONObject2, "daywind"));
              localDayWeatherForecast.setNightWindDirection(a(jSONObject2, "nightwind"));
              localDayWeatherForecast.setDayWindPower(a(jSONObject2, "daypower"));
              localDayWeatherForecast.setNightWindPower(a(jSONObject2, "nightpower"));
              arrayList.add(localDayWeatherForecast);
            } 
          } else {
            localWeatherForecast.setWeatherForecast(arrayList);
            return localWeatherForecast;
          } 
          i++;
        } 
      } 
      return localWeatherForecast;
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "WeatherForecastResult");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static ArrayList<BusStationItem> e(JSONObject paramJSONObject) throws JSONException {
    ArrayList<BusStationItem> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("busstops");
    if (jSONArray != null) {
      if (jSONArray.length() == 0)
        return arrayList; 
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null)
          arrayList.add(k(jSONObject)); 
      } 
    } 
    return arrayList;
  }
  
  public static ArrayList<BusLineItem> f(JSONObject paramJSONObject) throws JSONException {
    ArrayList<BusLineItem> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("buslines");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null)
        arrayList.add(n(jSONObject)); 
    } 
    return arrayList;
  }
  
  public static boolean f(String paramString) {
    return (paramString == null || paramString.equals(""));
  }
  
  public static RideRouteResult g(String paramString) throws AMapException {
    try {
      JSONArray jSONArray;
      JSONObject jSONObject1 = new JSONObject(paramString);
      if (!jSONObject1.has("data"))
        return null; 
      RideRouteResult rideRouteResult = new RideRouteResult();
      JSONObject jSONObject2 = jSONObject1.optJSONObject("data");
      rideRouteResult.setStartPos(b(jSONObject2, "origin"));
      rideRouteResult.setTargetPos(b(jSONObject2, "destination"));
      ArrayList<Object> arrayList = new ArrayList();
      Object object = jSONObject2.opt("paths");
      if (object == null) {
        rideRouteResult.setPaths(arrayList);
        return rideRouteResult;
      } 
      if (object instanceof JSONArray) {
        jSONArray = jSONObject2.optJSONArray("paths");
        for (int i = 0;; i++) {
          if (i < jSONArray.length()) {
            object = z(jSONArray.optJSONObject(i));
            if (object != null)
              arrayList.add(object); 
          } else {
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
          } 
        } 
      } 
      if (object instanceof JSONObject) {
        JSONObject jSONObject = jSONArray.optJSONObject("paths");
        if (!jSONObject.has("path")) {
          rideRouteResult.setPaths(arrayList);
          return rideRouteResult;
        } 
        RidePath ridePath = z(jSONObject.optJSONObject("path"));
        if (ridePath != null)
          arrayList.add(ridePath); 
      } 
      rideRouteResult.setPaths(arrayList);
      return rideRouteResult;
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseRideRoute");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static ArrayList<GeocodeAddress> g(JSONObject paramJSONObject) throws JSONException {
    ArrayList<GeocodeAddress> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("geocodes");
    if (jSONArray != null) {
      if (jSONArray.length() == 0)
        return arrayList; 
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        if (jSONObject != null) {
          GeocodeAddress geocodeAddress = new GeocodeAddress();
          geocodeAddress.setFormatAddress(a(jSONObject, "formatted_address"));
          geocodeAddress.setProvince(a(jSONObject, "province"));
          geocodeAddress.setCity(a(jSONObject, "city"));
          geocodeAddress.setDistrict(a(jSONObject, "district"));
          geocodeAddress.setTownship(a(jSONObject, "township"));
          geocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
          geocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
          geocodeAddress.setAdcode(a(jSONObject, "adcode"));
          geocodeAddress.setLatLonPoint(b(jSONObject, "location"));
          geocodeAddress.setLevel(a(jSONObject, "level"));
          geocodeAddress.setCountry(a(jSONObject, "country"));
          geocodeAddress.setPostcode(a(jSONObject, "postcode"));
          arrayList.add(geocodeAddress);
        } 
      } 
    } 
    return arrayList;
  }
  
  public static DistanceResult h(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("results"))
        return null; 
      DistanceResult distanceResult = new DistanceResult();
      JSONArray jSONArray = jSONObject.optJSONArray("results");
      ArrayList<DistanceItem> arrayList = new ArrayList();
      int j = jSONArray.length();
      for (int i = 0; i < j; i++) {
        DistanceItem distanceItem = new DistanceItem();
        JSONObject jSONObject1 = jSONArray.getJSONObject(i);
        distanceItem.setOriginId(n(a(jSONObject1, "origin_id")));
        distanceItem.setDestId(n(a(jSONObject1, "dest_id")));
        distanceItem.setDistance(o(a(jSONObject1, "distance")));
        distanceItem.setDuration(o(a(jSONObject1, "duration")));
        String str = a(jSONObject1, "info");
        if (!TextUtils.isEmpty(str)) {
          distanceItem.setErrorInfo(str);
          distanceItem.setErrorCode(n(a(jSONObject1, "code")));
        } 
        arrayList.add(distanceItem);
      } 
      distanceResult.setDistanceResults(arrayList);
      return distanceResult;
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseRouteDistance");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static ArrayList<Tip> h(JSONObject paramJSONObject) throws JSONException {
    ArrayList<Tip> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("tips");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      Tip tip = new Tip();
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null) {
        tip.setName(a(jSONObject, "name"));
        tip.setDistrict(a(jSONObject, "district"));
        tip.setAdcode(a(jSONObject, "adcode"));
        tip.setID(a(jSONObject, "id"));
        tip.setAddress(a(jSONObject, "address"));
        tip.setTypeCode(a(jSONObject, "typecode"));
        String str = a(jSONObject, "location");
        if (!TextUtils.isEmpty(str)) {
          String[] arrayOfString = str.split(",");
          if (arrayOfString.length == 2)
            tip.setPostion(new LatLonPoint(Double.parseDouble(arrayOfString[1]), Double.parseDouble(arrayOfString[0]))); 
        } 
        arrayList.add(tip);
      } 
    } 
    return arrayList;
  }
  
  public static TruckRouteRestult i(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("data"))
        return null; 
      TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
      jSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
      truckRouteRestult.setStartPos(b(jSONObject, "origin"));
      truckRouteRestult.setTargetPos(b(jSONObject, "destination"));
      if (!jSONObject.has("paths"))
        return truckRouteRestult; 
      JSONArray jSONArray = jSONObject.optJSONArray("paths");
      if (jSONArray == null)
        return truckRouteRestult; 
      ArrayList<TruckPath> arrayList = new ArrayList();
      int j = jSONArray.length();
      for (int i = 0;; i++) {
        if (i < j) {
          TruckPath truckPath = new TruckPath();
          JSONObject jSONObject1 = jSONArray.getJSONObject(i);
          truckPath.setDistance(o(a(jSONObject1, "distance")));
          truckPath.setDuration(q(a(jSONObject1, "duration")));
          truckPath.setStrategy(a(jSONObject1, "strategy"));
          truckPath.setTolls(o(a(jSONObject1, "tolls")));
          truckPath.setTollDistance(o(a(jSONObject1, "toll_distance")));
          truckPath.setTotalTrafficlights(n(a(jSONObject1, "traffic_lights")));
          truckPath.setRestriction(n(a(jSONObject1, "restriction")));
          JSONArray jSONArray1 = jSONObject1.optJSONArray("steps");
          if (jSONArray1 != null) {
            ArrayList<TruckStep> arrayList1 = new ArrayList();
            for (int k = 0;; k++) {
              if (k < jSONArray1.length()) {
                TruckStep truckStep = new TruckStep();
                JSONObject jSONObject2 = jSONArray1.optJSONObject(k);
                if (jSONObject2 != null) {
                  truckStep.setInstruction(a(jSONObject2, "instruction"));
                  truckStep.setOrientation(a(jSONObject2, "orientation"));
                  truckStep.setRoad(a(jSONObject2, "road"));
                  truckStep.setDistance(o(a(jSONObject2, "distance")));
                  truckStep.setTolls(o(a(jSONObject2, "tolls")));
                  truckStep.setTollDistance(o(a(jSONObject2, "toll_distance")));
                  truckStep.setTollRoad(a(jSONObject2, "toll_road"));
                  truckStep.setDuration(o(a(jSONObject2, "duration")));
                  truckStep.setPolyline(c(jSONObject2, "polyline"));
                  truckStep.setAction(a(jSONObject2, "action"));
                  truckStep.setAssistantAction(a(jSONObject2, "assistant_action"));
                  a(truckStep, jSONObject2);
                  b(truckStep, jSONObject2);
                  arrayList1.add(truckStep);
                } 
              } else {
                truckPath.setSteps(arrayList1);
                arrayList.add(truckPath);
                break;
              } 
            } 
          } 
        } else {
          truckRouteRestult.setPaths(arrayList);
          return truckRouteRestult;
        } 
      } 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseTruckRoute");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static ArrayList<RoutePOIItem> i(JSONObject paramJSONObject) throws JSONException {
    ArrayList<RoutePOIItem> arrayList = new ArrayList();
    Object object = paramJSONObject.opt("pois");
    if (object instanceof JSONArray) {
      JSONArray jSONArray = paramJSONObject.optJSONArray("pois");
      if (jSONArray != null) {
        if (jSONArray.length() == 0)
          return arrayList; 
        for (int i = 0; i < jSONArray.length(); i++) {
          object = jSONArray.optJSONObject(i);
          if (object != null)
            arrayList.add(y((JSONObject)object)); 
        } 
      } else {
        return arrayList;
      } 
    } else if (object instanceof JSONObject) {
      arrayList.add(y(((JSONObject)object).optJSONObject("poi")));
    } 
    return arrayList;
  }
  
  private static SubPoiItem j(JSONObject paramJSONObject) throws JSONException {
    SubPoiItem subPoiItem = new SubPoiItem(a(paramJSONObject, "id"), b(paramJSONObject, "location"), a(paramJSONObject, "name"), a(paramJSONObject, "address"));
    subPoiItem.setSubName(a(paramJSONObject, "sname"));
    subPoiItem.setSubTypeDes(a(paramJSONObject, "subtype"));
    if (paramJSONObject.has("distance")) {
      String str = a(paramJSONObject, "distance");
      if (!f(str))
        try {
          subPoiItem.setDistance((int)Float.parseFloat(str));
          return subPoiItem;
        } catch (NumberFormatException numberFormatException) {
          i.a(numberFormatException, "JSONHelper", "parseSubPoiItem");
        } catch (Exception exception) {
          i.a(exception, "JSONHelper", "parseSubPoiItem");
          return subPoiItem;
        }  
    } 
    return subPoiItem;
  }
  
  public static DriveRoutePlanResult j(String paramString) throws AMapException {
    String str4 = "starttime";
    String str3 = "协议解析错误 - ProtocolException";
    String str1 = str3;
    String str2 = str3;
    try {
      JSONObject jSONObject1 = new JSONObject(paramString);
      str1 = str3;
      str2 = str3;
      if (jSONObject1.has("errcode")) {
        str1 = str3;
        str2 = str3;
        jSONObject1.optInt("errcode");
        str1 = str3;
        str2 = str3;
        jSONObject1.optString("errmsg");
        str1 = str3;
        str2 = str3;
        jSONObject1.optString("errdetail");
      } 
      str1 = str3;
      str2 = str3;
      if (!jSONObject1.has("data"))
        return null; 
      str1 = str3;
      str2 = str3;
      DriveRoutePlanResult driveRoutePlanResult = new DriveRoutePlanResult();
      str1 = str3;
      str2 = str3;
      JSONObject jSONObject2 = jSONObject1.optJSONObject("data");
      if (jSONObject2 == null)
        return driveRoutePlanResult; 
      str1 = str3;
      str2 = str3;
      if (!jSONObject2.has("paths"))
        return driveRoutePlanResult; 
      str1 = str3;
      str2 = str3;
      JSONArray jSONArray2 = jSONObject2.optJSONArray("paths");
      if (jSONArray2 == null)
        return driveRoutePlanResult; 
      str1 = str3;
      str2 = str3;
      ArrayList<DrivePlanPath> arrayList = new ArrayList();
      int i = 0;
      String str5 = str3;
      continue;
    } catch (JSONException jSONException) {
    
    } finally {
      paramString = null;
      i.a((Throwable)paramString, "JSONHelper", "parseDriveRouteThrowable");
    } 
    i.a((Throwable)paramString, "JSONHelper", "parseDriveRoute");
    throw new AMapException(str2);
  }
  
  private static BusStationItem k(JSONObject paramJSONObject) throws JSONException {
    BusStationItem busStationItem = l(paramJSONObject);
    busStationItem.setAdCode(a(paramJSONObject, "adcode"));
    busStationItem.setCityCode(a(paramJSONObject, "citycode"));
    JSONArray jSONArray = paramJSONObject.optJSONArray("buslines");
    ArrayList<BusLineItem> arrayList = new ArrayList();
    if (jSONArray == null) {
      busStationItem.setBusLineItems(arrayList);
      return busStationItem;
    } 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null)
        arrayList.add(m(jSONObject)); 
    } 
    busStationItem.setBusLineItems(arrayList);
    return busStationItem;
  }
  
  private static boolean k(String paramString) {
    if (paramString != null) {
      if (paramString.length() <= 0)
        return false; 
      for (String str : a) {
        if (paramString.trim().equals(str.trim()))
          return true; 
      } 
    } 
    return false;
  }
  
  private static BusStationItem l(JSONObject paramJSONObject) throws JSONException {
    BusStationItem busStationItem = new BusStationItem();
    busStationItem.setBusStationId(a(paramJSONObject, "id"));
    busStationItem.setLatLonPoint(b(paramJSONObject, "location"));
    busStationItem.setBusStationName(a(paramJSONObject, "name"));
    return busStationItem;
  }
  
  private static ArrayList<LatLonPoint> l(String paramString) {
    ArrayList<LatLonPoint> arrayList = new ArrayList();
    String[] arrayOfString = paramString.split(";");
    for (int i = 0; i < arrayOfString.length; i++)
      arrayList.add(m(arrayOfString[i])); 
    return arrayList;
  }
  
  private static BusLineItem m(JSONObject paramJSONObject) throws JSONException {
    BusLineItem busLineItem = new BusLineItem();
    busLineItem.setBusLineId(a(paramJSONObject, "id"));
    busLineItem.setBusLineType(a(paramJSONObject, "type"));
    busLineItem.setBusLineName(a(paramJSONObject, "name"));
    busLineItem.setDirectionsCoordinates(c(paramJSONObject, "polyline"));
    busLineItem.setCityCode(a(paramJSONObject, "citycode"));
    busLineItem.setOriginatingStation(a(paramJSONObject, "start_stop"));
    busLineItem.setTerminalStation(a(paramJSONObject, "end_stop"));
    return busLineItem;
  }
  
  private static LatLonPoint m(String paramString) {
    if (paramString != null && !paramString.equals("")) {
      if (paramString.equals("[]"))
        return null; 
      String[] arrayOfString = paramString.split(",| ");
      if (arrayOfString.length != 2)
        return null; 
      double d = Double.parseDouble(arrayOfString[0]);
      return new LatLonPoint(Double.parseDouble(arrayOfString[1]), d);
    } 
    return null;
  }
  
  private static int n(String paramString) {
    if (paramString != null && !paramString.equals("")) {
      if (paramString.equals("[]"))
        return 0; 
      try {
        return Integer.parseInt(paramString);
      } catch (NumberFormatException numberFormatException) {
        i.a(numberFormatException, "JSONHelper", "str2int");
      } 
    } 
    return 0;
  }
  
  private static BusLineItem n(JSONObject paramJSONObject) throws JSONException {
    BusLineItem busLineItem = m(paramJSONObject);
    busLineItem.setFirstBusTime(i.d(a(paramJSONObject, "start_time")));
    busLineItem.setLastBusTime(i.d(a(paramJSONObject, "end_time")));
    busLineItem.setBusCompany(a(paramJSONObject, "company"));
    busLineItem.setDistance(o(a(paramJSONObject, "distance")));
    busLineItem.setBasicPrice(o(a(paramJSONObject, "basic_price")));
    busLineItem.setTotalPrice(o(a(paramJSONObject, "total_price")));
    busLineItem.setBounds(c(paramJSONObject, "bounds"));
    ArrayList<BusStationItem> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("busstops");
    if (jSONArray == null) {
      busLineItem.setBusStations(arrayList);
      return busLineItem;
    } 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null)
        arrayList.add(l(jSONObject)); 
    } 
    busLineItem.setBusStations(arrayList);
    return busLineItem;
  }
  
  private static float o(String paramString) {
    if (paramString != null && !paramString.equals("")) {
      if (paramString.equals("[]"))
        return 0.0F; 
      try {
        return Float.parseFloat(paramString);
      } catch (NumberFormatException numberFormatException) {
        i.a(numberFormatException, "JSONHelper", "str2float");
      } 
    } 
    return 0.0F;
  }
  
  private static RouteBusWalkItem o(JSONObject paramJSONObject) throws JSONException {
    if (paramJSONObject == null)
      return null; 
    RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
    routeBusWalkItem.setOrigin(b(paramJSONObject, "origin"));
    routeBusWalkItem.setDestination(b(paramJSONObject, "destination"));
    routeBusWalkItem.setDistance(o(a(paramJSONObject, "distance")));
    routeBusWalkItem.setDuration(q(a(paramJSONObject, "duration")));
    if (!paramJSONObject.has("steps"))
      return routeBusWalkItem; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("steps");
    if (jSONArray == null)
      return routeBusWalkItem; 
    ArrayList<WalkStep> arrayList = new ArrayList();
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null) {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, "orientation"));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(o(a(jSONObject, "distance")));
        walkStep.setDuration(o(a(jSONObject, "duration")));
        walkStep.setPolyline(c(jSONObject, "polyline"));
        walkStep.setAction(a(jSONObject, "action"));
        walkStep.setAssistantAction(a(jSONObject, "assistant_action"));
        arrayList.add(walkStep);
      } 
    } 
    routeBusWalkItem.setSteps(arrayList);
    a((Path)routeBusWalkItem, arrayList);
    return routeBusWalkItem;
  }
  
  private static double p(String paramString) {
    if (paramString != null && !paramString.equals("")) {
      if (paramString.equals("[]"))
        return 0.0D; 
      try {
        return Double.parseDouble(paramString);
      } catch (NumberFormatException numberFormatException) {
        i.a(numberFormatException, "JSONHelper", "str2float");
      } 
    } 
    return 0.0D;
  }
  
  private static List<RouteBusLineItem> p(JSONObject paramJSONObject) throws JSONException {
    ArrayList<RouteBusLineItem> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("buslines");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null) {
        RouteBusLineItem routeBusLineItem;
        if (jSONObject == null) {
          paramJSONObject = null;
        } else {
          routeBusLineItem = new RouteBusLineItem();
          routeBusLineItem.setDepartureBusStation(s(jSONObject.optJSONObject("departure_stop")));
          routeBusLineItem.setArrivalBusStation(s(jSONObject.optJSONObject("arrival_stop")));
          routeBusLineItem.setBusLineName(a(jSONObject, "name"));
          routeBusLineItem.setBusLineId(a(jSONObject, "id"));
          routeBusLineItem.setBusLineType(a(jSONObject, "type"));
          routeBusLineItem.setDistance(o(a(jSONObject, "distance")));
          routeBusLineItem.setDuration(o(a(jSONObject, "duration")));
          routeBusLineItem.setPolyline(c(jSONObject, "polyline"));
          routeBusLineItem.setFirstBusTime(i.d(a(jSONObject, "start_time")));
          routeBusLineItem.setLastBusTime(i.d(a(jSONObject, "end_time")));
          routeBusLineItem.setPassStationNum(n(a(jSONObject, "via_num")));
          routeBusLineItem.setPassStations(r(jSONObject));
        } 
        arrayList.add(routeBusLineItem);
      } 
    } 
    return arrayList;
  }
  
  private static long q(String paramString) {
    if (paramString != null && !paramString.equals("")) {
      if (paramString.equals("[]"))
        return 0L; 
      try {
        return Long.parseLong(paramString);
      } catch (NumberFormatException numberFormatException) {
        i.a(numberFormatException, "JSONHelper", "str2long");
      } 
    } 
    return 0L;
  }
  
  private static Doorway q(JSONObject paramJSONObject) throws JSONException {
    Doorway doorway = new Doorway();
    doorway.setName(a(paramJSONObject, "name"));
    doorway.setLatLonPoint(b(paramJSONObject, "location"));
    return doorway;
  }
  
  private static List<BusStationItem> r(JSONObject paramJSONObject) throws JSONException {
    ArrayList<BusStationItem> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("via_stops");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null)
        arrayList.add(s(jSONObject)); 
    } 
    return arrayList;
  }
  
  private static boolean r(String paramString) {
    if (paramString != null && !paramString.equals("") && !paramString.equals("[]")) {
      if (paramString.equals("0"))
        return false; 
      if (paramString.equals("1"))
        return true; 
    } 
    return false;
  }
  
  private static BusStationItem s(JSONObject paramJSONObject) throws JSONException {
    BusStationItem busStationItem = new BusStationItem();
    busStationItem.setBusStationName(a(paramJSONObject, "name"));
    busStationItem.setBusStationId(a(paramJSONObject, "id"));
    busStationItem.setLatLonPoint(b(paramJSONObject, "location"));
    return busStationItem;
  }
  
  private static RailwayStationItem t(JSONObject paramJSONObject) throws JSONException {
    RailwayStationItem railwayStationItem = new RailwayStationItem();
    railwayStationItem.setID(a(paramJSONObject, "id"));
    railwayStationItem.setName(a(paramJSONObject, "name"));
    railwayStationItem.setLocation(b(paramJSONObject, "location"));
    railwayStationItem.setAdcode(a(paramJSONObject, "adcode"));
    railwayStationItem.setTime(a(paramJSONObject, "time"));
    railwayStationItem.setisStart(r(a(paramJSONObject, "start")));
    railwayStationItem.setisEnd(r(a(paramJSONObject, "end")));
    railwayStationItem.setWait(o(a(paramJSONObject, "wait")));
    return railwayStationItem;
  }
  
  private static List<RailwayStationItem> u(JSONObject paramJSONObject) throws JSONException {
    ArrayList<RailwayStationItem> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("via_stops");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null)
        arrayList.add(t(jSONObject)); 
    } 
    return arrayList;
  }
  
  private static List<Railway> v(JSONObject paramJSONObject) throws JSONException {
    ArrayList<Railway> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("alters");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null) {
        Railway railway = new Railway();
        railway.setID(a(jSONObject, "id"));
        railway.setName(a(jSONObject, "name"));
        arrayList.add(railway);
      } 
    } 
    return arrayList;
  }
  
  private static List<RailwaySpace> w(JSONObject paramJSONObject) throws JSONException {
    ArrayList<RailwaySpace> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("spaces");
    if (jSONArray == null)
      return arrayList; 
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      if (jSONObject != null)
        arrayList.add(new RailwaySpace(a(jSONObject, "code"), o(a(jSONObject, "cost")))); 
    } 
    return arrayList;
  }
  
  private static List<Photo> x(JSONObject paramJSONObject) throws JSONException {
    ArrayList<Photo> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    if (!paramJSONObject.has("photos"))
      return arrayList; 
    JSONArray jSONArray = paramJSONObject.optJSONArray("photos");
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject jSONObject = jSONArray.optJSONObject(i);
      Photo photo = new Photo();
      photo.setTitle(a(jSONObject, "title"));
      photo.setUrl(a(jSONObject, "url"));
      arrayList.add(photo);
    } 
    return arrayList;
  }
  
  private static RoutePOIItem y(JSONObject paramJSONObject) throws JSONException {
    RoutePOIItem routePOIItem = new RoutePOIItem();
    routePOIItem.setID(a(paramJSONObject, "id"));
    routePOIItem.setTitle(a(paramJSONObject, "name"));
    routePOIItem.setPoint(b(paramJSONObject, "location"));
    routePOIItem.setDistance(o(a(paramJSONObject, "distance")));
    routePOIItem.setDuration(o(a(paramJSONObject, "duration")));
    return routePOIItem;
  }
  
  private static RidePath z(JSONObject paramJSONObject) throws AMapException {
    ArrayList<RideStep> arrayList;
    RidePath ridePath = new RidePath();
    if (paramJSONObject == null)
      return null; 
    try {
      ridePath.setDistance(o(a(paramJSONObject, "distance")));
      ridePath.setDuration(q(a(paramJSONObject, "duration")));
      if (paramJSONObject.has("steps")) {
        JSONArray jSONArray = paramJSONObject.optJSONArray("steps");
        arrayList = new ArrayList();
        if (jSONArray == null)
          return null; 
      } else {
        return ridePath;
      } 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "JSONHelper", "parseRidePath");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
    for (int i = 0;; i++) {
      if (i < jSONException.length()) {
        RideStep rideStep = new RideStep();
        JSONObject jSONObject = jSONException.optJSONObject(i);
        if (jSONObject != null) {
          rideStep.setInstruction(a(jSONObject, "instruction"));
          rideStep.setOrientation(a(jSONObject, "orientation"));
          rideStep.setRoad(a(jSONObject, "road"));
          rideStep.setDistance(o(a(jSONObject, "distance")));
          rideStep.setDuration(o(a(jSONObject, "duration")));
          rideStep.setPolyline(c(jSONObject, "polyline"));
          rideStep.setAction(a(jSONObject, "action"));
          rideStep.setAssistantAction(a(jSONObject, "assistant_action"));
          arrayList.add(rideStep);
        } 
      } else {
        ridePath.setSteps(arrayList);
        c((Path)ridePath, arrayList);
        return ridePath;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */