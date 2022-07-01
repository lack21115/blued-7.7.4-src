package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
  
  static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap();
  
  public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
  
  public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  
  public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  
  public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  
  public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
  
  public static final String METADATA_KEY_ART = "android.media.metadata.ART";
  
  public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  
  public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
  
  public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  
  public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
  
  public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  
  public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  
  public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  
  public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  
  public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
  
  public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
  
  public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
  
  public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
  
  public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
  
  public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
  
  public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  
  public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  
  public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
  
  public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
  
  public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
  
  public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  
  public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  
  public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  
  public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  
  public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  
  public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  
  static final int METADATA_TYPE_BITMAP = 2;
  
  static final int METADATA_TYPE_LONG = 0;
  
  static final int METADATA_TYPE_RATING = 3;
  
  static final int METADATA_TYPE_TEXT = 1;
  
  private static final String[] PREFERRED_BITMAP_ORDER;
  
  private static final String[] PREFERRED_DESCRIPTION_ORDER = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
  
  private static final String[] PREFERRED_URI_ORDER;
  
  private static final String TAG = "MediaMetadata";
  
  final Bundle mBundle;
  
  private MediaDescriptionCompat mDescription;
  
  private Object mMetadataObj;
  
  static {
    PREFERRED_BITMAP_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    PREFERRED_URI_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
    CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        public MediaMetadataCompat createFromParcel(Parcel param1Parcel) {
          return new MediaMetadataCompat(param1Parcel);
        }
        
        public MediaMetadataCompat[] newArray(int param1Int) {
          return new MediaMetadataCompat[param1Int];
        }
      };
  }
  
  MediaMetadataCompat(Bundle paramBundle) {
    this.mBundle = new Bundle(paramBundle);
    MediaSessionCompat.ensureClassLoader(this.mBundle);
  }
  
  MediaMetadataCompat(Parcel paramParcel) {
    this.mBundle = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject) {
    if (paramObject != null && Build.VERSION.SDK_INT >= 21) {
      Parcel parcel = Parcel.obtain();
      MediaMetadataCompatApi21.writeToParcel(paramObject, parcel, 0);
      parcel.setDataPosition(0);
      MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(parcel);
      parcel.recycle();
      mediaMetadataCompat.mMetadataObj = paramObject;
      return mediaMetadataCompat;
    } 
    return null;
  }
  
  public boolean containsKey(String paramString) {
    return this.mBundle.containsKey(paramString);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bitmap getBitmap(String paramString) {
    try {
      return (Bitmap)this.mBundle.getParcelable(paramString);
    } catch (Exception exception) {
      Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", exception);
      return null;
    } 
  }
  
  public Bundle getBundle() {
    return new Bundle(this.mBundle);
  }
  
  public MediaDescriptionCompat getDescription() {
    String[] arrayOfString1;
    String[] arrayOfString2;
    Uri uri;
    MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
    if (mediaDescriptionCompat != null)
      return mediaDescriptionCompat; 
    String str1 = getString("android.media.metadata.MEDIA_ID");
    CharSequence[] arrayOfCharSequence = new CharSequence[3];
    CharSequence charSequence = getText("android.media.metadata.DISPLAY_TITLE");
    if (!TextUtils.isEmpty(charSequence)) {
      arrayOfCharSequence[0] = charSequence;
      arrayOfCharSequence[1] = getText("android.media.metadata.DISPLAY_SUBTITLE");
      arrayOfCharSequence[2] = getText("android.media.metadata.DISPLAY_DESCRIPTION");
    } else {
      int k = 0;
      int j = 0;
      while (k < arrayOfCharSequence.length) {
        arrayOfString1 = PREFERRED_DESCRIPTION_ORDER;
        if (j < arrayOfString1.length) {
          CharSequence charSequence1 = getText(arrayOfString1[j]);
          int m = k;
          if (!TextUtils.isEmpty(charSequence1)) {
            arrayOfCharSequence[k] = charSequence1;
            m = k + 1;
          } 
          j++;
          k = m;
        } 
      } 
    } 
    int i = 0;
    while (true) {
      arrayOfString1 = PREFERRED_BITMAP_ORDER;
      int j = arrayOfString1.length;
      uri = null;
      if (i < j) {
        Bitmap bitmap = getBitmap(arrayOfString1[i]);
        if (bitmap != null)
          break; 
        i++;
        continue;
      } 
      arrayOfString1 = null;
      break;
    } 
    i = 0;
    while (true) {
      arrayOfString2 = PREFERRED_URI_ORDER;
      if (i < arrayOfString2.length) {
        String str = getString(arrayOfString2[i]);
        if (!TextUtils.isEmpty(str)) {
          Uri uri1 = Uri.parse(str);
          break;
        } 
        i++;
        continue;
      } 
      arrayOfString2 = null;
      break;
    } 
    String str2 = getString("android.media.metadata.MEDIA_URI");
    if (!TextUtils.isEmpty(str2))
      uri = Uri.parse(str2); 
    MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
    builder.setMediaId(str1);
    builder.setTitle(arrayOfCharSequence[0]);
    builder.setSubtitle(arrayOfCharSequence[1]);
    builder.setDescription(arrayOfCharSequence[2]);
    builder.setIconBitmap((Bitmap)arrayOfString1);
    builder.setIconUri((Uri)arrayOfString2);
    builder.setMediaUri(uri);
    Bundle bundle = new Bundle();
    if (this.mBundle.containsKey("android.media.metadata.BT_FOLDER_TYPE"))
      bundle.putLong("android.media.extra.BT_FOLDER_TYPE", getLong("android.media.metadata.BT_FOLDER_TYPE")); 
    if (this.mBundle.containsKey("android.media.metadata.DOWNLOAD_STATUS"))
      bundle.putLong("android.media.extra.DOWNLOAD_STATUS", getLong("android.media.metadata.DOWNLOAD_STATUS")); 
    if (!bundle.isEmpty())
      builder.setExtras(bundle); 
    this.mDescription = builder.build();
    return this.mDescription;
  }
  
  public long getLong(String paramString) {
    return this.mBundle.getLong(paramString, 0L);
  }
  
  public Object getMediaMetadata() {
    if (this.mMetadataObj == null && Build.VERSION.SDK_INT >= 21) {
      Parcel parcel = Parcel.obtain();
      writeToParcel(parcel, 0);
      parcel.setDataPosition(0);
      this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(parcel);
      parcel.recycle();
    } 
    return this.mMetadataObj;
  }
  
  public RatingCompat getRating(String paramString) {
    try {
      return (Build.VERSION.SDK_INT >= 19) ? RatingCompat.fromRating(this.mBundle.getParcelable(paramString)) : (RatingCompat)this.mBundle.getParcelable(paramString);
    } catch (Exception exception) {
      Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", exception);
      return null;
    } 
  }
  
  public String getString(String paramString) {
    CharSequence charSequence = this.mBundle.getCharSequence(paramString);
    return (charSequence != null) ? charSequence.toString() : null;
  }
  
  public CharSequence getText(String paramString) {
    return this.mBundle.getCharSequence(paramString);
  }
  
  public Set<String> keySet() {
    return this.mBundle.keySet();
  }
  
  public int size() {
    return this.mBundle.size();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mBundle);
  }
  
  static {
    ArrayMap<String, Integer> arrayMap1 = METADATA_KEYS_TYPE;
    Integer integer1 = Integer.valueOf(1);
    arrayMap1.put("android.media.metadata.TITLE", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", integer1);
    ArrayMap<String, Integer> arrayMap2 = METADATA_KEYS_TYPE;
    Integer integer2 = Integer.valueOf(0);
    arrayMap2.put("android.media.metadata.DURATION", integer2);
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.DATE", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", integer2);
    METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", integer2);
    METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", integer2);
    METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", integer2);
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", integer1);
    ArrayMap<String, Integer> arrayMap3 = METADATA_KEYS_TYPE;
    Integer integer3 = Integer.valueOf(2);
    arrayMap3.put("android.media.metadata.ART", integer3);
    METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", integer3);
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", integer1);
    arrayMap3 = METADATA_KEYS_TYPE;
    Integer integer4 = Integer.valueOf(3);
    arrayMap3.put("android.media.metadata.USER_RATING", integer4);
    METADATA_KEYS_TYPE.put("android.media.metadata.RATING", integer4);
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", integer3);
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.BT_FOLDER_TYPE", integer2);
    METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_URI", integer1);
    METADATA_KEYS_TYPE.put("android.media.metadata.ADVERTISEMENT", integer2);
    METADATA_KEYS_TYPE.put("android.media.metadata.DOWNLOAD_STATUS", integer2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BitmapKey {}
  
  public static final class Builder {
    private final Bundle mBundle = new Bundle();
    
    public Builder() {}
    
    public Builder(MediaMetadataCompat param1MediaMetadataCompat) {
      MediaSessionCompat.ensureClassLoader(this.mBundle);
    }
    
    public Builder(MediaMetadataCompat param1MediaMetadataCompat, int param1Int) {
      this(param1MediaMetadataCompat);
      for (String str : this.mBundle.keySet()) {
        Object object = this.mBundle.get(str);
        if (object instanceof Bitmap) {
          object = object;
          if (object.getHeight() > param1Int || object.getWidth() > param1Int)
            putBitmap(str, scaleBitmap((Bitmap)object, param1Int)); 
        } 
      } 
    }
    
    private Bitmap scaleBitmap(Bitmap param1Bitmap, int param1Int) {
      float f = param1Int;
      f = Math.min(f / param1Bitmap.getWidth(), f / param1Bitmap.getHeight());
      param1Int = (int)(param1Bitmap.getHeight() * f);
      return Bitmap.createScaledBitmap(param1Bitmap, (int)(param1Bitmap.getWidth() * f), param1Int, true);
    }
    
    public MediaMetadataCompat build() {
      return new MediaMetadataCompat(this.mBundle);
    }
    
    public Builder putBitmap(String param1String, Bitmap param1Bitmap) {
      if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) || ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() == 2) {
        this.mBundle.putParcelable(param1String, (Parcelable)param1Bitmap);
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("The ");
      stringBuilder.append(param1String);
      stringBuilder.append(" key cannot be used to put a Bitmap");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder putLong(String param1String, long param1Long) {
      if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) || ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() == 0) {
        this.mBundle.putLong(param1String, param1Long);
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("The ");
      stringBuilder.append(param1String);
      stringBuilder.append(" key cannot be used to put a long");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder putRating(String param1String, RatingCompat param1RatingCompat) {
      if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) || ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() == 3) {
        if (Build.VERSION.SDK_INT >= 19) {
          this.mBundle.putParcelable(param1String, (Parcelable)param1RatingCompat.getRating());
          return this;
        } 
        this.mBundle.putParcelable(param1String, param1RatingCompat);
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("The ");
      stringBuilder.append(param1String);
      stringBuilder.append(" key cannot be used to put a Rating");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder putString(String param1String1, String param1String2) {
      if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String1) || ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String1)).intValue() == 1) {
        this.mBundle.putCharSequence(param1String1, param1String2);
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("The ");
      stringBuilder.append(param1String1);
      stringBuilder.append(" key cannot be used to put a String");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder putText(String param1String, CharSequence param1CharSequence) {
      if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) || ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() == 1) {
        this.mBundle.putCharSequence(param1String, param1CharSequence);
        return this;
      } 
      param1CharSequence = new StringBuilder();
      param1CharSequence.append("The ");
      param1CharSequence.append(param1String);
      param1CharSequence.append(" key cannot be used to put a CharSequence");
      throw new IllegalArgumentException(param1CharSequence.toString());
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LongKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RatingKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TextKey {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\android\support\v4\media\MediaMetadataCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */