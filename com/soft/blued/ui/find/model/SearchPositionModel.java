package com.soft.blued.ui.find.model;

public class SearchPositionModel {
  public boolean isDel;
  
  public double lat;
  
  public double lon;
  
  public String name;
  
  public SearchPositionModel() {}
  
  public SearchPositionModel(String paramString) {
    this.name = paramString;
  }
  
  public SearchPositionModel(String paramString, double paramDouble1, double paramDouble2) {
    this.name = paramString;
    this.lat = paramDouble1;
    this.lon = paramDouble2;
  }
  
  public void update(SearchPositionModel paramSearchPositionModel) {
    this.name = paramSearchPositionModel.name;
    this.lat = paramSearchPositionModel.lat;
    this.lon = paramSearchPositionModel.lon;
    this.isDel = paramSearchPositionModel.isDel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\SearchPositionModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */