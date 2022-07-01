package com.blued.android.module.live_china.model;

import com.blued.android.module.common.model.CommonGiftPackageModel;
import java.util.Arrays;

public class LiveGiftPackageModel extends CommonGiftPackageModel<LiveGiftModel> {
  public int itemPadding;
  
  public String type_name;
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    boolean bool = paramObject instanceof LiveGiftPackageModel;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (((LiveGiftPackageModel)paramObject).goods != null) {
      bool = bool1;
      if (this.goods != null)
        bool = Arrays.equals(((LiveGiftPackageModel)paramObject).goods.toArray(), this.goods.toArray()); 
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveGiftPackageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */