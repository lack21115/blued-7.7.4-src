package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

class MediaDescriptionCompatApi23 {
  public static Uri getMediaUri(Object paramObject) {
    return ((MediaDescription)paramObject).getMediaUri();
  }
  
  static class Builder {
    public static void setMediaUri(Object param1Object, Uri param1Uri) {
      ((MediaDescription.Builder)param1Object).setMediaUri(param1Uri);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\android\support\v4\media\MediaDescriptionCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */