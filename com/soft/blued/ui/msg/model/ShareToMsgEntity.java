package com.soft.blued.ui.msg.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareToMsgEntity implements Parcelable {
  public static final Parcelable.Creator<ShareToMsgEntity> CREATOR = new Parcelable.Creator<ShareToMsgEntity>() {
      public ShareToMsgEntity createFromParcel(Parcel param1Parcel) {
        return new ShareToMsgEntity(param1Parcel);
      }
      
      public ShareToMsgEntity[] newArray(int param1Int) {
        return new ShareToMsgEntity[param1Int];
      }
    };
  
  public String description;
  
  public String gid;
  
  public String image;
  
  public String isCreatorOrAdmin;
  
  public String name;
  
  public long sessionId;
  
  public int share_from;
  
  public String title;
  
  public int type;
  
  public String url;
  
  public ShareToMsgEntity() {}
  
  protected ShareToMsgEntity(Parcel paramParcel) {
    this.title = paramParcel.readString();
    this.name = paramParcel.readString();
    this.image = paramParcel.readString();
    this.url = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.description = paramParcel.readString();
    this.share_from = paramParcel.readInt();
    this.gid = paramParcel.readString();
    this.isCreatorOrAdmin = paramParcel.readString();
    this.sessionId = paramParcel.readLong();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.image);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.share_from);
    paramParcel.writeString(this.gid);
    paramParcel.writeString(this.isCreatorOrAdmin);
    paramParcel.writeLong(this.sessionId);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\ShareToMsgEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */