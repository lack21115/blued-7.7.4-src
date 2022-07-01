package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

public final class l extends b<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
  public l(Context paramContext, RouteSearch.DrivePlanQuery paramDrivePlanQuery) {
    super(paramContext, paramDrivePlanQuery);
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
    if (this.b.getDestParentPoiID() != null) {
      stringBuffer.append("&parentid=");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.b.getDestParentPoiID());
      stringBuffer.append(stringBuilder1.toString());
    } 
    stringBuffer.append("&strategy=");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getMode());
    stringBuffer.append(stringBuilder.toString());
    stringBuffer.append("&cartype=");
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getCarType());
    stringBuffer.append(stringBuilder.toString());
    stringBuffer.append("&firsttime=");
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getFirstTime());
    stringBuffer.append(stringBuilder.toString());
    stringBuffer.append("&interval=");
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getInterval());
    stringBuffer.append(stringBuilder.toString());
    stringBuffer.append("&count=");
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getCount());
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.b());
    stringBuilder.append("/etd/driving?");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */