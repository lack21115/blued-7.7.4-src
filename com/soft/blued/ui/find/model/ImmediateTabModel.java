package com.soft.blued.ui.find.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ImmediateTabModel implements Parcelable {
  public static final Parcelable.Creator<ImmediateTabModel> CREATOR = new Parcelable.Creator<ImmediateTabModel>() {
      public ImmediateTabModel createFromParcel(Parcel param1Parcel) {
        return new ImmediateTabModel(param1Parcel);
      }
      
      public ImmediateTabModel[] newArray(int param1Int) {
        return new ImmediateTabModel[param1Int];
      }
    };
  
  public List<Tab> conf;
  
  public String is_update;
  
  public Tab my;
  
  public List<UserFindResult> users;
  
  public ImmediateTabModel() {}
  
  protected ImmediateTabModel(Parcel paramParcel) {
    this.is_update = paramParcel.readString();
    this.conf = paramParcel.readArrayList(Tab.class.getClassLoader());
    this.users = paramParcel.readArrayList(UserFindResult.class.getClassLoader());
    this.my = (Tab)paramParcel.readParcelable(Tab.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.is_update);
    paramParcel.writeList(this.conf);
    paramParcel.writeList(this.users);
    paramParcel.writeParcelable(this.my, paramInt);
  }
  
  public static class Tab implements Parcelable {
    public static final Parcelable.Creator<Tab> CREATOR = new Parcelable.Creator<Tab>() {
        public ImmediateTabModel.Tab createFromParcel(Parcel param2Parcel) {
          return new ImmediateTabModel.Tab(param2Parcel);
        }
        
        public ImmediateTabModel.Tab[] newArray(int param2Int) {
          return new ImmediateTabModel.Tab[param2Int];
        }
      };
    
    public String background;
    
    public int background_id;
    
    public String item_id;
    
    public String name;
    
    public String pic;
    
    public int pic_id;
    
    public String small_pic;
    
    public int small_pic_id;
    
    public Tab() {}
    
    protected Tab(Parcel param1Parcel) {
      this.item_id = param1Parcel.readString();
      this.name = param1Parcel.readString();
      this.pic = param1Parcel.readString();
      this.background = param1Parcel.readString();
      this.small_pic = param1Parcel.readString();
      this.pic_id = param1Parcel.readInt();
      this.small_pic_id = param1Parcel.readInt();
      this.background_id = param1Parcel.readInt();
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeString(this.item_id);
      param1Parcel.writeString(this.name);
      param1Parcel.writeString(this.pic);
      param1Parcel.writeString(this.background);
      param1Parcel.writeString(this.small_pic);
      param1Parcel.writeInt(this.pic_id);
      param1Parcel.writeInt(this.small_pic_id);
      param1Parcel.writeInt(this.background_id);
    }
  }
  
  static final class null implements Parcelable.Creator<Tab> {
    public ImmediateTabModel.Tab createFromParcel(Parcel param1Parcel) {
      return new ImmediateTabModel.Tab(param1Parcel);
    }
    
    public ImmediateTabModel.Tab[] newArray(int param1Int) {
      return new ImmediateTabModel.Tab[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\ImmediateTabModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */