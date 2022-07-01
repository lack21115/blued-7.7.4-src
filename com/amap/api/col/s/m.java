package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

public final class m extends b<RouteSearch.DriveRouteQuery, DriveRouteResult> {
  public m(Context paramContext, RouteSearch.DriveRouteQuery paramDriveRouteQuery) {
    super(paramContext, paramDriveRouteQuery);
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.e));
    if (this.b.getFromAndTo() != null) {
      stringBuffer.append("&origin=");
      stringBuffer.append(i.a(this.b.getFromAndTo().getFrom()));
      if (!p.f(this.b.getFromAndTo().getStartPoiID())) {
        stringBuffer.append("&originid=");
        stringBuffer.append(this.b.getFromAndTo().getStartPoiID());
      } 
      stringBuffer.append("&destination=");
      stringBuffer.append(i.a(this.b.getFromAndTo().getTo()));
      if (!p.f(this.b.getFromAndTo().getDestinationPoiID())) {
        stringBuffer.append("&destinationid=");
        stringBuffer.append(this.b.getFromAndTo().getDestinationPoiID());
      } 
      if (!p.f(this.b.getFromAndTo().getOriginType())) {
        stringBuffer.append("&origintype=");
        stringBuffer.append(this.b.getFromAndTo().getOriginType());
      } 
      if (!p.f(this.b.getFromAndTo().getDestinationType())) {
        stringBuffer.append("&destinationtype=");
        stringBuffer.append(this.b.getFromAndTo().getDestinationType());
      } 
      if (!p.f(this.b.getFromAndTo().getPlateProvince())) {
        stringBuffer.append("&province=");
        stringBuffer.append(this.b.getFromAndTo().getPlateProvince());
      } 
      if (!p.f(this.b.getFromAndTo().getPlateNumber())) {
        stringBuffer.append("&number=");
        stringBuffer.append(this.b.getFromAndTo().getPlateNumber());
      } 
    } 
    stringBuffer.append("&strategy=");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getMode());
    stringBuffer.append(stringBuilder.toString());
    if (!TextUtils.isEmpty(this.b.getExtensions())) {
      stringBuffer.append("&extensions=");
      stringBuffer.append(this.b.getExtensions());
    } else {
      stringBuffer.append("&extensions=base");
    } 
    stringBuffer.append("&ferry=");
    stringBuffer.append(this.b.isUseFerry() ^ true);
    stringBuffer.append("&cartype=");
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getCarType());
    stringBuffer.append(stringBuilder.toString());
    if (this.b.hasPassPoint()) {
      stringBuffer.append("&waypoints=");
      stringBuffer.append(this.b.getPassedPointStr());
    } 
    if (this.b.hasAvoidpolygons()) {
      stringBuffer.append("&avoidpolygons=");
      stringBuffer.append(this.b.getAvoidpolygonsStr());
    } 
    if (this.b.hasAvoidRoad()) {
      stringBuffer.append("&avoidroad=");
      stringBuffer.append(b(this.b.getAvoidRoad()));
    } 
    stringBuffer.append("&output=json");
    stringBuffer.append("&geometry=false");
    if (this.b.getExclude() != null) {
      stringBuffer.append("&exclude=");
      stringBuffer.append(this.b.getExclude());
    } 
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.a());
    stringBuilder.append("/direction/driving?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */