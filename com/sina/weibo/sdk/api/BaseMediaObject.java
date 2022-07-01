package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;

public abstract class BaseMediaObject implements Parcelable {
  public static final int MEDIA_TYPE_CMD = 7;
  
  public static final int MEDIA_TYPE_IMAGE = 2;
  
  public static final int MEDIA_TYPE_MUSIC = 3;
  
  public static final int MEDIA_TYPE_TEXT = 1;
  
  public static final int MEDIA_TYPE_VIDEO = 4;
  
  public static final int MEDIA_TYPE_VOICE = 6;
  
  public static final int MEDIA_TYPE_WEBPAGE = 5;
  
  public String actionUrl;
  
  public String description;
  
  public String identify;
  
  public String schema;
  
  public byte[] thumbData;
  
  public String title;
  
  public BaseMediaObject() {}
  
  public BaseMediaObject(Parcel paramParcel) {
    this.actionUrl = paramParcel.readString();
    this.schema = paramParcel.readString();
    this.identify = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.thumbData = paramParcel.createByteArray();
  }
  
  protected boolean checkArgs() {
    String str2 = this.actionUrl;
    if (str2 == null || str2.length() > 512) {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
      return false;
    } 
    str2 = this.identify;
    if (str2 == null || str2.length() > 512) {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
      return false;
    } 
    byte[] arrayOfByte = this.thumbData;
    if (arrayOfByte == null || arrayOfByte.length > 32768) {
      byte b;
      StringBuilder stringBuilder = new StringBuilder("checkArgs fail, thumbData is invalid,size is ");
      byte[] arrayOfByte1 = this.thumbData;
      if (arrayOfByte1 != null) {
        b = arrayOfByte1.length;
      } else {
        b = -1;
      } 
      stringBuilder.append(b);
      stringBuilder.append("! more then 32768.");
      LogUtil.e("Weibo.BaseMediaObject", stringBuilder.toString());
      return false;
    } 
    String str1 = this.title;
    if (str1 == null || str1.length() > 512) {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
      return false;
    } 
    str1 = this.description;
    if (str1 == null || str1.length() > 1024) {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
      return false;
    } 
    return true;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public abstract int getObjType();
  
  public final void setThumbImage(Bitmap paramBitmap) {
    Bitmap bitmap2 = null;
    Exception exception1 = null;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      try {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        this.thumbData = byteArrayOutputStream.toByteArray();
      } catch (Exception exception) {
        ByteArrayOutputStream byteArrayOutputStream1 = byteArrayOutputStream;
      } finally {
        paramBitmap = null;
      } 
    } catch (Exception exception2) {
      paramBitmap = bitmap2;
    } finally {}
    Bitmap bitmap1 = paramBitmap;
    exception2.printStackTrace();
    bitmap1 = paramBitmap;
    LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
    if (paramBitmap != null) {
      paramBitmap.close();
      return;
    } 
  }
  
  protected abstract BaseMediaObject toExtraMediaObject(String paramString);
  
  protected abstract String toExtraMediaString();
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeString(this.schema);
    paramParcel.writeString(this.identify);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeByteArray(this.thumbData);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\BaseMediaObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */