package com.soft.blued.ui.msg.model;

import com.blued.android.module.location.model.LocationPOIModel;
import java.io.Serializable;

public class PositionPOIModel extends LocationPOIModel implements Serializable {
  public boolean mark_visible;
  
  public static PositionPOIModel getFromLocationPOIModel(LocationPOIModel paramLocationPOIModel) {
    PositionPOIModel positionPOIModel = new PositionPOIModel();
    positionPOIModel.name = paramLocationPOIModel.name;
    positionPOIModel.address = paramLocationPOIModel.address;
    positionPOIModel.longitude = paramLocationPOIModel.longitude;
    positionPOIModel.latitude = paramLocationPOIModel.latitude;
    positionPOIModel.province = paramLocationPOIModel.province;
    positionPOIModel.city = paramLocationPOIModel.city;
    positionPOIModel.area = paramLocationPOIModel.area;
    positionPOIModel.distance = paramLocationPOIModel.distance;
    positionPOIModel.mark_visible = false;
    return positionPOIModel;
  }
  
  public double getLatitude() {
    try {
      return Double.parseDouble(this.latitude);
    } catch (Exception exception) {
      return 0.0D;
    } 
  }
  
  public double getLongitude() {
    try {
      return Double.parseDouble(this.longitude);
    } catch (Exception exception) {
      return 0.0D;
    } 
  }
  
  public void setLatitude(double paramDouble) {
    try {
      this.latitude = String.valueOf(paramDouble);
      return;
    } catch (Exception exception) {
      this.latitude = "0";
      return;
    } 
  }
  
  public void setLongitude(double paramDouble) {
    try {
      this.longitude = String.valueOf(paramDouble);
      return;
    } catch (Exception exception) {
      this.longitude = "0";
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\PositionPOIModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */