package com.blued.android.module.yy_china.model;

import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import java.util.Arrays;

public class YYGiftPackageModel extends CommonGiftPackageModel<YYGiftModel> {
  public int itemPadding;
  
  public String type_name;
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof YYGiftPackageModel))
      return false; 
    paramObject = paramObject;
    if (((YYGiftPackageModel)paramObject).goods != null && this.goods != null) {
      bool = Arrays.equals(((YYGiftPackageModel)paramObject).goods.toArray(), this.goods.toArray());
    } else {
      bool = false;
    } 
    Logger.a("niu", new Object[] { "goodsCompare = ", Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYGiftPackageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */