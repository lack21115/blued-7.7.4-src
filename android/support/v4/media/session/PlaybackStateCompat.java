package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
  public static final Parcelable.Creator CREATOR = new PlaybackStateCompat$1();
  
  private long mActions;
  
  private long mActiveItemId;
  
  private long mBufferedPosition;
  
  private List mCustomActions;
  
  private int mErrorCode;
  
  private CharSequence mErrorMessage;
  
  private Bundle mExtras;
  
  private long mPosition;
  
  private float mSpeed;
  
  private int mState;
  
  private long mUpdateTime;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private PlaybackStateCompat(int paramInt1, long paramLong1, long paramLong2, float paramFloat, long paramLong3, int paramInt2, CharSequence paramCharSequence, long paramLong4, List<?> paramList, long paramLong5, Bundle paramBundle) {
    this.mState = paramInt1;
    this.mPosition = paramLong1;
    this.mBufferedPosition = paramLong2;
    this.mSpeed = paramFloat;
    this.mActions = paramLong3;
    this.mErrorCode = paramInt2;
    this.mErrorMessage = paramCharSequence;
    this.mUpdateTime = paramLong4;
    this.mCustomActions = new ArrayList(paramList);
    this.mActiveItemId = paramLong5;
    this.mExtras = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel) {
    this.mState = paramParcel.readInt();
    this.mPosition = paramParcel.readLong();
    this.mSpeed = paramParcel.readFloat();
    this.mUpdateTime = paramParcel.readLong();
    this.mBufferedPosition = paramParcel.readLong();
    this.mActions = paramParcel.readLong();
    this.mErrorMessage = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mCustomActions = paramParcel.createTypedArrayList(PlaybackStateCompat$CustomAction.CREATOR);
    this.mActiveItemId = paramParcel.readLong();
    this.mExtras = paramParcel.readBundle();
    this.mErrorCode = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat fromPlaybackState(Object paramObject) {
    Bundle bundle = null;
    if (paramObject != null && Build.VERSION.SDK_INT >= 21) {
      PlaybackState playbackState = (PlaybackState)paramObject;
      List list = playbackState.getCustomActions();
      if (list != null) {
        paramObject = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
          paramObject.add(PlaybackStateCompat$CustomAction.fromCustomAction(iterator.next())); 
      } else {
        paramObject = null;
      } 
      if (Build.VERSION.SDK_INT >= 22)
        bundle = playbackState.getExtras(); 
      return new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), 0, playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), (List)paramObject, playbackState.getActiveQueueItemId(), bundle);
    } 
    return null;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
    stringBuilder.append("state=");
    stringBuilder.append(this.mState);
    stringBuilder.append(", position=");
    stringBuilder.append(this.mPosition);
    stringBuilder.append(", buffered position=");
    stringBuilder.append(this.mBufferedPosition);
    stringBuilder.append(", speed=");
    stringBuilder.append(this.mSpeed);
    stringBuilder.append(", updated=");
    stringBuilder.append(this.mUpdateTime);
    stringBuilder.append(", actions=");
    stringBuilder.append(this.mActions);
    stringBuilder.append(", error code=");
    stringBuilder.append(this.mErrorCode);
    stringBuilder.append(", error message=");
    stringBuilder.append(this.mErrorMessage);
    stringBuilder.append(", custom actions=");
    stringBuilder.append(this.mCustomActions);
    stringBuilder.append(", active item id=");
    stringBuilder.append(this.mActiveItemId);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mPosition);
    paramParcel.writeFloat(this.mSpeed);
    paramParcel.writeLong(this.mUpdateTime);
    paramParcel.writeLong(this.mBufferedPosition);
    paramParcel.writeLong(this.mActions);
    TextUtils.writeToParcel(this.mErrorMessage, paramParcel, paramInt);
    paramParcel.writeTypedList(this.mCustomActions);
    paramParcel.writeLong(this.mActiveItemId);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeInt(this.mErrorCode);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\PlaybackStateCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */