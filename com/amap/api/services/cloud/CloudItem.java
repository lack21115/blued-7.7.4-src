package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloudItem implements Parcelable {
  public static final Parcelable.Creator<CloudItem> CREATOR = new Parcelable.Creator<CloudItem>() {
    
    };
  
  private String a;
  
  private int b = -1;
  
  private String c;
  
  private String d;
  
  private HashMap<String, String> e;
  
  private List<CloudImage> f;
  
  protected final LatLonPoint mPoint;
  
  protected final String mSnippet;
  
  protected final String mTitle;
  
  protected CloudItem(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.mPoint = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.mTitle = paramParcel.readString();
    this.mSnippet = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = new HashMap<String, String>();
    paramParcel.readMap(this.e, HashMap.class.getClassLoader());
    this.f = new ArrayList<CloudImage>();
    paramParcel.readList(this.f, getClass().getClassLoader());
  }
  
  public CloudItem(String paramString1, LatLonPoint paramLatLonPoint, String paramString2, String paramString3) {
    this.a = paramString1;
    this.mPoint = paramLatLonPoint;
    this.mTitle = paramString2;
    this.mSnippet = paramString3;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof CloudItem))
      return false; 
    paramObject = paramObject;
    String str = this.a;
    if (str == null) {
      if (((CloudItem)paramObject).a != null)
        return false; 
    } else if (!str.equals(((CloudItem)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public List<CloudImage> getCloudImage() {
    return this.f;
  }
  
  public String getCreatetime() {
    return this.c;
  }
  
  public HashMap<String, String> getCustomfield() {
    return this.e;
  }
  
  public int getDistance() {
    return this.b;
  }
  
  public String getID() {
    return this.a;
  }
  
  public LatLonPoint getLatLonPoint() {
    return this.mPoint;
  }
  
  public String getSnippet() {
    return this.mSnippet;
  }
  
  public String getTitle() {
    return this.mTitle;
  }
  
  public String getUpdatetime() {
    return this.d;
  }
  
  public int hashCode() {
    int i;
    String str = this.a;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    return i + 31;
  }
  
  public void setCreatetime(String paramString) {
    this.c = paramString;
  }
  
  public void setCustomfield(HashMap<String, String> paramHashMap) {
    this.e = paramHashMap;
  }
  
  public void setDistance(int paramInt) {
    this.b = paramInt;
  }
  
  public void setUpdatetime(String paramString) {
    this.d = paramString;
  }
  
  public void setmCloudImage(List<CloudImage> paramList) {
    this.f = paramList;
  }
  
  public String toString() {
    return this.mTitle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeValue(this.mPoint);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSnippet);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeMap(this.e);
    paramParcel.writeList(this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\cloud\CloudItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */