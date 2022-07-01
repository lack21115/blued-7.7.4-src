package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import java.util.Arrays;
import java.util.List;

public class LiveGiftModel extends CommonLiveGiftModel {
  public double bonus;
  
  public List<LiveEffectModel> effect;
  
  public LiveEffectModel effectModel;
  
  public String errorMessage;
  
  public int event_type;
  
  public int exclusive_icon;
  
  public int expire;
  
  public int fanClubLevel;
  
  public String fanClubName;
  
  public int fanStatus;
  
  public int giftId;
  
  public int giftType;
  
  public List<LiveGiftNumberModel> groups;
  
  public int inFanClub;
  
  public String info_img;
  
  public int info_type;
  
  public String info_url;
  
  public int is_fans_goods;
  
  public int is_join_ticket;
  
  public int is_task;
  
  public int level;
  
  public String liang_id;
  
  public int liang_type;
  
  public LiveGiftNumberModel selectNumModel;
  
  public String text;
  
  public String type_name;
  
  public long userId;
  
  public int user_store_count;
  
  public boolean equals(Object<LiveEffectModel> paramObject) {
    boolean bool2 = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof LiveGiftModel))
      return false; 
    paramObject = paramObject;
    boolean bool1 = bool2;
    if (TextUtils.equals(((LiveGiftModel)paramObject).goods_id, this.goods_id)) {
      bool1 = bool2;
      if (TextUtils.equals(((LiveGiftModel)paramObject).images_static, this.images_static)) {
        bool1 = bool2;
        if (TextUtils.equals(((LiveGiftModel)paramObject).images_gif, this.images_gif)) {
          bool1 = bool2;
          if (TextUtils.equals(((LiveGiftModel)paramObject).images_apng2, this.images_apng2)) {
            bool1 = bool2;
            if (TextUtils.equals(((LiveGiftModel)paramObject).anim_code, this.anim_code)) {
              bool1 = bool2;
              if (TextUtils.equals(((LiveGiftModel)paramObject).name, this.name)) {
                bool1 = bool2;
                if (TextUtils.equals(((LiveGiftModel)paramObject).contents, this.contents)) {
                  bool1 = bool2;
                  if (TextUtils.equals(((LiveGiftModel)paramObject).expire_time, this.expire_time)) {
                    bool1 = bool2;
                    if (((LiveGiftModel)paramObject).user_store_count == this.user_store_count) {
                      bool1 = bool2;
                      if (((LiveGiftModel)paramObject).beans == this.beans) {
                        bool1 = bool2;
                        if (((LiveGiftModel)paramObject).sendGiftStatus == this.sendGiftStatus) {
                          bool1 = bool2;
                          if (((LiveGiftModel)paramObject).availability == this.availability) {
                            bool1 = bool2;
                            if (((LiveGiftModel)paramObject).count == this.count) {
                              bool1 = bool2;
                              if (((LiveGiftModel)paramObject).ops == this.ops) {
                                bool1 = bool2;
                                if (((LiveGiftModel)paramObject).animation == this.animation) {
                                  bool1 = bool2;
                                  if (((LiveGiftModel)paramObject).hit_id == this.hit_id) {
                                    bool1 = bool2;
                                    if (((LiveGiftModel)paramObject).hit_count == this.hit_count) {
                                      bool1 = bool2;
                                      if (((LiveGiftModel)paramObject).double_hit == this.double_hit) {
                                        bool1 = bool2;
                                        if (((LiveGiftModel)paramObject).beans_count == this.beans_count) {
                                          bool1 = bool2;
                                          if (((LiveGiftModel)paramObject).beans_current_count == this.beans_current_count) {
                                            bool1 = bool2;
                                            if (((LiveGiftModel)paramObject).free_number == this.free_number) {
                                              bool1 = bool2;
                                              if (((LiveGiftModel)paramObject).one_month_beans == this.one_month_beans) {
                                                bool1 = bool2;
                                                if (((LiveGiftModel)paramObject).is_my == this.is_my) {
                                                  bool1 = bool2;
                                                  if (((LiveGiftModel)paramObject).is_use == this.is_use) {
                                                    paramObject = (Object<LiveEffectModel>)((LiveGiftModel)paramObject).effect;
                                                    bool1 = bool2;
                                                    if (paramObject != null) {
                                                      bool1 = bool2;
                                                      if (this.effect != null) {
                                                        if (Arrays.equals(paramObject.toArray(), this.effect.toArray()))
                                                          return true; 
                                                        bool1 = false;
                                                      } 
                                                    } 
                                                  } 
                                                } 
                                              } 
                                            } 
                                          } 
                                        } 
                                      } 
                                    } 
                                  } 
                                } 
                              } 
                            } 
                          } 
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LiveGiftModel[");
    stringBuilder.append(super.toString());
    stringBuilder.append(", user_store_count:");
    stringBuilder.append(this.user_store_count);
    stringBuilder.append(", bonus:");
    stringBuilder.append(this.bonus);
    stringBuilder.append(", text:");
    stringBuilder.append(this.text);
    stringBuilder.append(", expire:");
    stringBuilder.append(this.expire);
    stringBuilder.append(", is_fans_goods:");
    stringBuilder.append(this.is_fans_goods);
    stringBuilder.append(", is_join_ticket:");
    stringBuilder.append(this.is_join_ticket);
    stringBuilder.append(", is_task:");
    stringBuilder.append(this.is_task);
    stringBuilder.append(", exclusive_icon:");
    stringBuilder.append(this.exclusive_icon);
    stringBuilder.append(", fans_level:");
    stringBuilder.append(this.fans_level);
    stringBuilder.append(", info_type:");
    stringBuilder.append(this.info_type);
    stringBuilder.append(", info_img:");
    stringBuilder.append(this.info_img);
    stringBuilder.append(", info_url:");
    stringBuilder.append(this.info_url);
    stringBuilder.append(", images_mp4:");
    stringBuilder.append(this.images_mp4);
    stringBuilder.append(", images_static: ");
    stringBuilder.append(this.images_static);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveGiftModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */