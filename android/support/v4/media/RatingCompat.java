package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
  public static final Parcelable.Creator CREATOR = new RatingCompat$1();
  
  private final int mRatingStyle;
  
  private final float mRatingValue;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  RatingCompat(int paramInt, float paramFloat) {
    this.mRatingStyle = paramInt;
    this.mRatingValue = paramFloat;
  }
  
  public final int describeContents() {
    return this.mRatingStyle;
  }
  
  public final String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder("Rating:style=");
    stringBuilder.append(this.mRatingStyle);
    stringBuilder.append(" rating=");
    if (this.mRatingValue < 0.0F) {
      str = "unrated";
    } else {
      str = String.valueOf(this.mRatingValue);
    } 
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.mRatingStyle);
    paramParcel.writeFloat(this.mRatingValue);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\RatingCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */