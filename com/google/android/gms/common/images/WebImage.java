package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage extends AbstractSafeParcelable {
  public static final Parcelable.Creator<WebImage> CREATOR = new zae();
  
  private final int zaa;
  
  private final Uri zab;
  
  private final int zac;
  
  private final int zad;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3) {
    this.zaa = paramInt1;
    this.zab = paramUri;
    this.zac = paramInt2;
    this.zad = paramInt3;
  }
  
  public WebImage(Uri paramUri) throws IllegalArgumentException {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2) throws IllegalArgumentException {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri != null) {
      if (paramInt1 >= 0 && paramInt2 >= 0)
        return; 
      throw new IllegalArgumentException("width and height must not be negative");
    } 
    throw new IllegalArgumentException("url cannot be null");
  }
  
  public WebImage(JSONObject paramJSONObject) throws IllegalArgumentException {
    this(zaa(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri zaa(JSONObject paramJSONObject) {
    Uri uri2 = Uri.EMPTY;
    Uri uri1 = uri2;
    if (paramJSONObject.has("url"))
      try {
        return Uri.parse(paramJSONObject.getString("url"));
      } catch (JSONException jSONException) {
        return uri2;
      }  
    return uri1;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (!(paramObject instanceof WebImage))
        return false; 
      paramObject = paramObject;
      if (Objects.equal(this.zab, ((WebImage)paramObject).zab) && this.zac == ((WebImage)paramObject).zac && this.zad == ((WebImage)paramObject).zad)
        return true; 
    } 
    return false;
  }
  
  public final int getHeight() {
    return this.zad;
  }
  
  public final Uri getUrl() {
    return this.zab;
  }
  
  public final int getWidth() {
    return this.zac;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zab, Integer.valueOf(this.zac), Integer.valueOf(this.zad) });
  }
  
  public final JSONObject toJson() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("url", this.zab.toString());
      jSONObject.put("width", this.zac);
      jSONObject.put("height", this.zad);
      return jSONObject;
    } catch (JSONException jSONException) {
      return jSONObject;
    } 
  }
  
  public final String toString() {
    return String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(this.zac), Integer.valueOf(this.zad), this.zab.toString() });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)getUrl(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 4, getHeight());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\images\WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */