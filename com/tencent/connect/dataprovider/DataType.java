package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;

public final class DataType {
  public static final int CONTENT_AND_IMAGE_PATH = 1;
  
  public static final int CONTENT_AND_VIDEO_PATH = 2;
  
  public static final int CONTENT_ONLY = 4;
  
  public static class TextAndMediaPath implements Parcelable {
    public static final Parcelable.Creator<TextAndMediaPath> CREATOR = new Parcelable.Creator<TextAndMediaPath>() {
        public DataType.TextAndMediaPath createFromParcel(Parcel param2Parcel) {
          return new DataType.TextAndMediaPath(param2Parcel);
        }
        
        public DataType.TextAndMediaPath[] newArray(int param2Int) {
          return new DataType.TextAndMediaPath[param2Int];
        }
      };
    
    private String a;
    
    private String b;
    
    private TextAndMediaPath(Parcel param1Parcel) {
      this.a = param1Parcel.readString();
      this.b = param1Parcel.readString();
    }
    
    public TextAndMediaPath(String param1String1, String param1String2) {
      this.a = param1String1;
      this.b = param1String2;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public String getMediaPath() {
      return this.b;
    }
    
    public String getText() {
      return this.a;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeString(this.a);
      param1Parcel.writeString(this.b);
    }
  }
  
  static final class null implements Parcelable.Creator<TextAndMediaPath> {
    public DataType.TextAndMediaPath createFromParcel(Parcel param1Parcel) {
      return new DataType.TextAndMediaPath(param1Parcel);
    }
    
    public DataType.TextAndMediaPath[] newArray(int param1Int) {
      return new DataType.TextAndMediaPath[param1Int];
    }
  }
  
  public static class TextOnly implements Parcelable {
    public static final Parcelable.Creator<TextOnly> CREATOR = new Parcelable.Creator<TextOnly>() {
        public DataType.TextOnly createFromParcel(Parcel param2Parcel) {
          return new DataType.TextOnly(param2Parcel);
        }
        
        public DataType.TextOnly[] newArray(int param2Int) {
          return new DataType.TextOnly[param2Int];
        }
      };
    
    private String a;
    
    private TextOnly(Parcel param1Parcel) {
      this.a = param1Parcel.readString();
    }
    
    public TextOnly(String param1String) {
      this.a = param1String;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public String getText() {
      return this.a;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeString(this.a);
    }
  }
  
  static final class null implements Parcelable.Creator<TextOnly> {
    public DataType.TextOnly createFromParcel(Parcel param1Parcel) {
      return new DataType.TextOnly(param1Parcel);
    }
    
    public DataType.TextOnly[] newArray(int param1Int) {
      return new DataType.TextOnly[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\dataprovider\DataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */