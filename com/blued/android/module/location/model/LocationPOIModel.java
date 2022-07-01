package com.blued.android.module.location.model;

public class LocationPOIModel {
  public String address;
  
  public String area;
  
  public String city;
  
  public String distance;
  
  public String latitude;
  
  public String longitude;
  
  public String name;
  
  public String province;
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    LocationPOIModel locationPOIModel = (LocationPOIModel)paramObject;
    try {
      if (this.name.equals(locationPOIModel.name) && this.address.equals(locationPOIModel.address) && this.longitude == locationPOIModel.longitude) {
        paramObject = this.latitude;
        String str = locationPOIModel.latitude;
        if (paramObject == str)
          return true; 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\model\LocationPOIModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */