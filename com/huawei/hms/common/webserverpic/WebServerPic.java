package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

public class WebServerPic {
  public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();
  
  private final int height;
  
  private final Uri url;
  
  private final int width;
  
  public WebServerPic(Uri paramUri) throws IllegalArgumentException {
    this(paramUri, 0, 0);
  }
  
  public WebServerPic(Uri paramUri, int paramInt1, int paramInt2) throws IllegalArgumentException {
    this.url = paramUri;
    this.width = paramInt1;
    this.height = paramInt2;
    if (paramUri != null) {
      if (paramInt1 >= 0 && paramInt2 >= 0)
        return; 
      throw new IllegalArgumentException("width and height should be positive or 0");
    } 
    throw new IllegalArgumentException("url is not able to be null");
  }
  
  public final int getHeight() {
    return this.height;
  }
  
  public final Uri getUrl() {
    return this.url;
  }
  
  public final int getWidth() {
    return this.width;
  }
  
  public final String toString() {
    return String.format(Locale.ENGLISH, "Image %dx%d %s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), this.url.toString() });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    Preconditions.checkNotNull(paramParcel);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)getUrl(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 2, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 3, getHeight());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\webserverpic\WebServerPic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */