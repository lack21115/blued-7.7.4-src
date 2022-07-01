package com.soft.blued.ui.find.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.chad.library.adapter.base.entity.MultiItemEntity;

public class UserFindResult extends UserBasicModel implements Parcelable, MultiItemEntity {
  public static final Parcelable.Creator<UserFindResult> CREATOR = new Parcelable.Creator<UserFindResult>() {
      public UserFindResult createFromParcel(Parcel param1Parcel) {
        return new UserFindResult(param1Parcel);
      }
      
      public UserFindResult[] newArray(int param1Int) {
        return new UserFindResult[param1Int];
      }
    };
  
  public int accumCount;
  
  public String additional_tag_data;
  
  public int additional_tag_type;
  
  public VoiceBroadcast chatroom;
  
  public int hb;
  
  public int is_eco_user;
  
  public int is_have_chatroom;
  
  public int itemType;
  
  public int link_type;
  
  public String list_avatar;
  
  public int live;
  
  public int live_type;
  
  public String live_url;
  
  public String lt;
  
  public int positionReal;
  
  public long realtime_count;
  
  public String redirect_url;
  
  public String selected_tag;
  
  public boolean showMore;
  
  public String source;
  
  public TTNativeAd ttNativeAdData;
  
  public int userPositionReal;
  
  public long watch_count;
  
  public UserFindResult() {
    this.itemType = 10;
    this.accumCount = -1;
    this.positionReal = -1;
    this.userPositionReal = -1;
  }
  
  protected UserFindResult(Parcel paramParcel) {
    boolean bool;
    this.itemType = 10;
    this.accumCount = -1;
    this.positionReal = -1;
    this.userPositionReal = -1;
    this.live = paramParcel.readInt();
    this.hb = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.showMore = bool;
    this.watch_count = paramParcel.readLong();
    this.realtime_count = paramParcel.readLong();
    this.itemType = paramParcel.readInt();
    this.avatar = paramParcel.readString();
    this.uid = paramParcel.readString();
    this.email = paramParcel.readString();
    this.name = paramParcel.readString();
    this.height = paramParcel.readString();
    this.weight = paramParcel.readString();
    this.last_operate = paramParcel.readString();
    this.avatar = paramParcel.readString();
    this.hot = paramParcel.readString();
    this.description = paramParcel.readString();
    this.role = paramParcel.readString();
    this.age = paramParcel.readString();
    this.online_state = paramParcel.readInt();
    this.distance = paramParcel.readString();
    this.photos_count = paramParcel.readInt();
    this.note = paramParcel.readString();
    this.vbadge = paramParcel.readInt();
    this.is_recommend = paramParcel.readInt();
    this.blued_pic = paramParcel.readString();
    this.weekstar = paramParcel.readString();
    this.vip_grade = paramParcel.readInt();
    this.vip_exp_lvl = paramParcel.readInt();
    this.is_hide_distance = paramParcel.readInt();
    this.is_hide_last_operate = paramParcel.readInt();
    this.is_shadow = paramParcel.readInt();
    this.is_hide_vip_look = paramParcel.readInt();
    this.is_show_vip_page = paramParcel.readInt();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int getItemType() {
    if (this.itemType == 0)
      this.itemType = 10; 
    return this.itemType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.live);
    paramParcel.writeInt(this.hb);
    paramParcel.writeByte((byte)this.showMore);
    paramParcel.writeLong(this.watch_count);
    paramParcel.writeLong(this.realtime_count);
    paramParcel.writeInt(this.itemType);
    paramParcel.writeString(this.avatar);
    paramParcel.writeString(this.uid);
    paramParcel.writeString(this.email);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.height);
    paramParcel.writeString(this.weight);
    paramParcel.writeString(this.last_operate);
    paramParcel.writeString(this.avatar);
    paramParcel.writeString(this.hot);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.role);
    paramParcel.writeString(this.age);
    paramParcel.writeInt(this.online_state);
    paramParcel.writeString(this.distance);
    paramParcel.writeInt(this.photos_count);
    paramParcel.writeString(this.note);
    paramParcel.writeInt(this.vbadge);
    paramParcel.writeInt(this.is_recommend);
    paramParcel.writeString(this.blued_pic);
    paramParcel.writeString(this.weekstar);
    paramParcel.writeInt(this.vip_grade);
    paramParcel.writeInt(this.vip_exp_lvl);
    paramParcel.writeInt(this.is_hide_distance);
    paramParcel.writeInt(this.is_hide_last_operate);
    paramParcel.writeInt(this.is_shadow);
    paramParcel.writeInt(this.is_hide_vip_look);
    paramParcel.writeInt(this.is_show_vip_page);
  }
  
  public static interface USER_ITEM_TYPE {
    public static final int AD = 11;
    
    public static final int DN_ORIGIN_AD = 15;
    
    public static final int ORIGIN_AD = 13;
    
    public static final int TT_ORIGIN_AD = 14;
    
    public static final int USER = 10;
  }
  
  public static interface USER_SORT_BY {
    public static final String HOME_LIVE = "home_live";
    
    public static final String INTEGRATE = "integrate";
    
    public static final String NEARBY = "nearby";
    
    public static final String NEWBEE = "newbie";
    
    public static final String ONLINE = "online";
    
    public static final String SELECTED = "selected";
  }
  
  public class VoiceBroadcast {
    public String room_id;
    
    public String room_name;
    
    public String room_type;
    
    public String uid;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\UserFindResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */