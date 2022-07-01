package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction implements Parcelable {
  public static final Parcelable.Creator CREATOR = new PlaybackStateCompat$CustomAction$1();
  
  private final String mAction;
  
  private final Bundle mExtras;
  
  private final int mIcon;
  
  private final CharSequence mName;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  PlaybackStateCompat$CustomAction(Parcel paramParcel) {
    this.mAction = paramParcel.readString();
    this.mName = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mIcon = paramParcel.readInt();
    this.mExtras = paramParcel.readBundle();
  }
  
  private PlaybackStateCompat$CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle) {
    this.mAction = paramString;
    this.mName = paramCharSequence;
    this.mIcon = paramInt;
    this.mExtras = paramBundle;
  }
  
  public static PlaybackStateCompat$CustomAction fromCustomAction(Object paramObject) {
    if (paramObject == null || Build.VERSION.SDK_INT < 21)
      return null; 
    paramObject = paramObject;
    return new PlaybackStateCompat$CustomAction(paramObject.getAction(), paramObject.getName(), paramObject.getIcon(), paramObject.getExtras());
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("Action:mName='");
    stringBuilder.append(this.mName);
    stringBuilder.append(", mIcon=");
    stringBuilder.append(this.mIcon);
    stringBuilder.append(", mExtras=");
    stringBuilder.append(this.mExtras);
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.mAction);
    TextUtils.writeToParcel(this.mName, paramParcel, paramInt);
    paramParcel.writeInt(this.mIcon);
    paramParcel.writeBundle(this.mExtras);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\PlaybackStateCompat$CustomAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */