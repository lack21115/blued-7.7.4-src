package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

public final class ao extends b<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
  private final String j = "/direction/truck?";
  
  private final String k = "|";
  
  private final String l = ",";
  
  public ao(Context paramContext, RouteSearch.TruckRouteQuery paramTruckRouteQuery) {
    super(paramContext, paramTruckRouteQuery);
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
    stringBuffer.append(this.b.getMode());
    if (this.b.hasPassPoint()) {
      stringBuffer.append("&waypoints=");
      stringBuffer.append(this.b.getPassedPointStr());
    } 
    stringBuffer.append("&size=");
    stringBuffer.append(this.b.getTruckSize());
    stringBuffer.append("&height=");
    stringBuffer.append(this.b.getTruckHeight());
    stringBuffer.append("&width=");
    stringBuffer.append(this.b.getTruckWidth());
    stringBuffer.append("&load=");
    stringBuffer.append(this.b.getTruckLoad());
    stringBuffer.append("&weight=");
    stringBuffer.append(this.b.getTruckWeight());
    stringBuffer.append("&axis=");
    stringBuffer.append(this.b.getTruckAxis());
    if (!TextUtils.isEmpty(this.b.getExtensions())) {
      stringBuffer.append("&extensions=");
      stringBuffer.append(this.b.getExtensions());
    } else {
      stringBuffer.append("&extensions=base");
    } 
    stringBuffer.append("&output=json");
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.b());
    stringBuilder.append("/direction/truck?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */