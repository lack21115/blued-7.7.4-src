package com.blued.android.module.live.base.model;

import com.blued.android.module.common.model.BaseGiftModel;

public class CommonLiveGiftModel extends BaseGiftModel {
  public static final int GIFT_CANCEL = 2;
  
  public static final int GIFT_DEFAULT = 0;
  
  public static final int GIFT_LOADING = 1;
  
  public static final int GIFT_NOT_AVAILABLE = -1;
  
  public static final int GIFT_SUCCESS = 3;
  
  public static final int GIFT_TYPE_ACTIVITY = 2;
  
  public static final int GIFT_TYPE_APPROACH = 4;
  
  public static final int GIFT_TYPE_AR = 6;
  
  public static final int GIFT_TYPE_BARRAGE = 3;
  
  public static final int GIFT_TYPE_EGGS = -1;
  
  public static final int GIFT_TYPE_GENERAL = 0;
  
  public static final int GIFT_TYPE_PRIVATE_TICKET = 5;
  
  public static final int GIFT_TYPE_TOP_CARD = 1;
  
  public static final int GIFT_VENDIBILITY = 1;
  
  public String anim_code;
  
  public int animation;
  
  public int availability;
  
  public long beans;
  
  public double beans_count;
  
  public double beans_current_count;
  
  public String box_image;
  
  public int comboWaitTime;
  
  public String contents;
  
  public long danmu_count;
  
  public int double_hit;
  
  public String expire_time;
  
  public int fans_level;
  
  public int free_number;
  
  public String goods_id;
  
  public int hit_batch;
  
  public int hit_count;
  
  public long hit_id;
  
  public String images_apng2;
  
  public String images_gif;
  
  public String images_mp4;
  
  public String images_static;
  
  public String info;
  
  public int is_my;
  
  public int is_use;
  
  public double one_month_beans;
  
  public int ops;
  
  public int resWidth;
  
  public String resource_url;
  
  public int sendGiftStatus;
  
  public int show_info;
  
  public void reduceCount() {
    if (this.count > 0)
      this.count--; 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CommonLiveGiftModel[");
    stringBuilder.append(super.toString());
    stringBuilder.append(", goods_id:");
    stringBuilder.append(this.goods_id);
    stringBuilder.append(", beans:");
    stringBuilder.append(this.beans);
    stringBuilder.append(", count:");
    stringBuilder.append(this.count);
    stringBuilder.append(",sendGiftStatus:");
    stringBuilder.append(this.sendGiftStatus);
    stringBuilder.append(", hit_id:");
    stringBuilder.append(this.hit_id);
    stringBuilder.append(", hit_count:");
    stringBuilder.append(this.hit_count);
    stringBuilder.append(", double_hit:");
    stringBuilder.append(this.double_hit);
    stringBuilder.append(", hit_batch:");
    stringBuilder.append(this.hit_batch);
    stringBuilder.append(", fans_level:");
    stringBuilder.append(this.fans_level);
    stringBuilder.append(", comboWaitTime:");
    stringBuilder.append(this.comboWaitTime);
    stringBuilder.append(", show_info:");
    stringBuilder.append(this.show_info);
    stringBuilder.append(", info:");
    stringBuilder.append(this.info);
    stringBuilder.append(", ops:");
    stringBuilder.append(this.ops);
    stringBuilder.append(", danmu_count:");
    stringBuilder.append(this.danmu_count);
    stringBuilder.append(", free_number:");
    stringBuilder.append(this.free_number);
    stringBuilder.append(", is_my:");
    stringBuilder.append(this.is_my);
    stringBuilder.append(", is_use:");
    stringBuilder.append(this.is_use);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\model\CommonLiveGiftModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */