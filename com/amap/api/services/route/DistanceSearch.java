package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.ax;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

public class DistanceSearch {
  public static final String EXTENSIONS_ALL = "all";
  
  public static final String EXTENSIONS_BASE = "base";
  
  public static final int TYPE_DISTANCE = 0;
  
  public static final int TYPE_DRIVING_DISTANCE = 1;
  
  public static final int TYPE_WALK_DISTANCE = 3;
  
  private IDistanceSearch a;
  
  public DistanceSearch(Context paramContext) {
    if (this.a == null)
      try {
        this.a = (IDistanceSearch)new ax(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public DistanceResult calculateRouteDistance(DistanceQuery paramDistanceQuery) throws AMapException {
    IDistanceSearch iDistanceSearch = this.a;
    return (iDistanceSearch != null) ? iDistanceSearch.calculateRouteDistance(paramDistanceQuery) : null;
  }
  
  public void calculateRouteDistanceAsyn(DistanceQuery paramDistanceQuery) {
    IDistanceSearch iDistanceSearch = this.a;
    if (iDistanceSearch != null)
      iDistanceSearch.calculateRouteDistanceAsyn(paramDistanceQuery); 
  }
  
  public void setDistanceSearchListener(OnDistanceSearchListener paramOnDistanceSearchListener) {
    IDistanceSearch iDistanceSearch = this.a;
    if (iDistanceSearch != null)
      iDistanceSearch.setDistanceSearchListener(paramOnDistanceSearchListener); 
  }
  
  public static class DistanceQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() {
      
      };
    
    private int a = 1;
    
    private List<LatLonPoint> b = new ArrayList<LatLonPoint>();
    
    private LatLonPoint c;
    
    private String d = "base";
    
    private int e = 4;
    
    public DistanceQuery() {}
    
    protected DistanceQuery(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.createTypedArrayList(LatLonPoint.CREATOR);
      this.c = (LatLonPoint)param1Parcel.readParcelable(LatLonPoint.class.getClassLoader());
      this.d = param1Parcel.readString();
      this.e = param1Parcel.readInt();
    }
    
    public void addOrigins(LatLonPoint... param1VarArgs) {
      int j = param1VarArgs.length;
      for (int i = 0; i < j; i++) {
        LatLonPoint latLonPoint = param1VarArgs[i];
        if (latLonPoint != null)
          this.b.add(latLonPoint); 
      } 
    }
    
    public DistanceQuery clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "DistanceSearch", "DistanceQueryclone");
      } 
      DistanceQuery distanceQuery = new DistanceQuery();
      distanceQuery.setType(this.a);
      distanceQuery.setOrigins(this.b);
      distanceQuery.setDestination(this.c);
      distanceQuery.setExtensions(this.d);
      distanceQuery.setMode(this.e);
      return distanceQuery;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public LatLonPoint getDestination() {
      return this.c;
    }
    
    public String getExtensions() {
      return this.d;
    }
    
    public int getMode() {
      return this.e;
    }
    
    public List<LatLonPoint> getOrigins() {
      return this.b;
    }
    
    public int getType() {
      return this.a;
    }
    
    public void setDestination(LatLonPoint param1LatLonPoint) {
      this.c = param1LatLonPoint;
    }
    
    public void setExtensions(String param1String) {
      this.d = param1String;
    }
    
    public void setMode(int param1Int) {
      this.e = param1Int;
    }
    
    public void setOrigins(List<LatLonPoint> param1List) {
      if (param1List != null)
        this.b = param1List; 
    }
    
    public void setType(int param1Int) {
      this.a = param1Int;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.a);
      param1Parcel.writeTypedList(this.b);
      param1Parcel.writeParcelable((Parcelable)this.c, param1Int);
      param1Parcel.writeString(this.d);
      param1Parcel.writeInt(this.e);
    }
  }
  
  static final class null implements Parcelable.Creator<DistanceQuery> {}
  
  public static interface OnDistanceSearchListener {
    void onDistanceSearched(DistanceResult param1DistanceResult, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DistanceSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */