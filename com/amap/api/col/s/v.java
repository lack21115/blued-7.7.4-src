package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

public final class v extends b<UploadInfo, Integer> {
  private Context j;
  
  private UploadInfo k;
  
  public v(Context paramContext, UploadInfo paramUploadInfo) {
    super(paramContext, paramUploadInfo);
    this.j = paramContext;
    this.k = paramUploadInfo;
  }
  
  protected final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("key=");
    stringBuffer.append(bi.f(this.j));
    stringBuffer.append("&userid=");
    stringBuffer.append(this.k.getUserID());
    LatLonPoint latLonPoint = this.k.getPoint();
    int i = (int)(latLonPoint.getLongitude() * 1000000.0D);
    int j = (int)(latLonPoint.getLatitude() * 1000000.0D);
    stringBuffer.append("&location=");
    stringBuffer.append(i / 1000000.0F);
    stringBuffer.append(",");
    stringBuffer.append(j / 1000000.0F);
    stringBuffer.append("&coordtype=");
    stringBuffer.append(this.k.getCoordType());
    return stringBuffer.toString();
  }
  
  public final String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(h.c());
    stringBuilder.append("/nearby/data/create");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */