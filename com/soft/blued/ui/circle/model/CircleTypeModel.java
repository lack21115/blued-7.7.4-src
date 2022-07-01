package com.soft.blued.ui.circle.model;

import java.io.Serializable;
import java.util.List;

public class CircleTypeModel implements Serializable {
  public int code;
  
  public List<DataBean> data;
  
  public String msg;
  
  public static class DataBean {
    public int id;
    
    public int lastOffset = 0;
    
    public int lastPosition = 0;
    
    public String name;
    
    public int weight;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\model\CircleTypeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */