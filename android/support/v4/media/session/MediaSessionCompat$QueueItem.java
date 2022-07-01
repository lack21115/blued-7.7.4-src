package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public final class MediaSessionCompat$QueueItem implements Parcelable {
  public static final Parcelable.Creator CREATOR = new MediaSessionCompat$QueueItem$1();
  
  private final MediaDescriptionCompat mDescription;
  
  private final long mId;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaSessionCompat$QueueItem(Parcel paramParcel) {
    this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel);
    this.mId = paramParcel.readLong();
  }
  
  private MediaSessionCompat$QueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong) {
    if (paramMediaDescriptionCompat != null) {
      if (paramLong != -1L) {
        this.mDescription = paramMediaDescriptionCompat;
        this.mId = paramLong;
        return;
      } 
      throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
    } 
    throw new IllegalArgumentException("Description cannot be null.");
  }
  
  public static List fromQueueItemList(List paramList) {
    if (paramList != null) {
      if (Build.VERSION.SDK_INT < 21)
        return null; 
      ArrayList<MediaSessionCompat$QueueItem> arrayList = new ArrayList();
      for (List paramList : paramList) {
        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem;
        if (paramList == null || Build.VERSION.SDK_INT < 21) {
          paramList = null;
        } else {
          MediaSession.QueueItem queueItem = (MediaSession.QueueItem)paramList;
          mediaSessionCompat$QueueItem = new MediaSessionCompat$QueueItem(MediaDescriptionCompat.fromMediaDescription(queueItem.getDescription()), queueItem.getQueueId());
        } 
        arrayList.add(mediaSessionCompat$QueueItem);
      } 
      return arrayList;
    } 
    return null;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("MediaSession.QueueItem {Description=");
    stringBuilder.append(this.mDescription);
    stringBuilder.append(", Id=");
    stringBuilder.append(this.mId);
    stringBuilder.append(" }");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    this.mDescription.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mId);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompat$QueueItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */