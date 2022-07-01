package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import java.util.List;

public class YYGiftModel extends CommonLiveGiftModel {
  public String description;
  
  private String freeTime;
  
  public int free_count;
  
  public List<LiveGiftNumberModel> goods_number;
  
  public String images_apng;
  
  public String is_free;
  
  public String is_hot;
  
  public String marker;
  
  public String getFreeTime() {
    if (this.free_count <= 0) {
      this.freeTime = "不可送出";
    } else if (TextUtils.isEmpty(this.freeTime)) {
      this.freeTime = YYRoomInfoManager.d().h();
    } 
    return this.freeTime;
  }
  
  public void setFreeTime(String paramString) {
    this.freeTime = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYGiftModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */