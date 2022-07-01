package com.soft.blued.ui.find.model;

import com.soft.blued.ui.feed.model.BluedADExtra;
import java.io.Serializable;

public class AdvertFloatModel extends BluedADExtra implements Serializable {
  public String advert_pic;
  
  public int id;
  
  public ImageModel images;
  
  public class ImageModel implements Serializable {
    public String _530x680;
    
    public String _795x1020;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\AdvertFloatModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */