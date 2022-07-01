package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
  public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
  
  public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
  
  public static final long BT_FOLDER_TYPE_GENRES = 4L;
  
  public static final long BT_FOLDER_TYPE_MIXED = 0L;
  
  public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
  
  public static final long BT_FOLDER_TYPE_TITLES = 1L;
  
  public static final long BT_FOLDER_TYPE_YEARS = 6L;
  
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
      public MediaDescriptionCompat createFromParcel(Parcel param1Parcel) {
        return (Build.VERSION.SDK_INT < 21) ? new MediaDescriptionCompat(param1Parcel) : MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(param1Parcel));
      }
      
      public MediaDescriptionCompat[] newArray(int param1Int) {
        return new MediaDescriptionCompat[param1Int];
      }
    };
  
  public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
  
  public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
  
  public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
  
  public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
  
  public static final long STATUS_DOWNLOADED = 2L;
  
  public static final long STATUS_DOWNLOADING = 1L;
  
  public static final long STATUS_NOT_DOWNLOADED = 0L;
  
  private final CharSequence mDescription;
  
  private Object mDescriptionObj;
  
  private final Bundle mExtras;
  
  private final Bitmap mIcon;
  
  private final Uri mIconUri;
  
  private final String mMediaId;
  
  private final Uri mMediaUri;
  
  private final CharSequence mSubtitle;
  
  private final CharSequence mTitle;
  
  MediaDescriptionCompat(Parcel paramParcel) {
    this.mMediaId = paramParcel.readString();
    this.mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    ClassLoader classLoader = getClass().getClassLoader();
    this.mIcon = (Bitmap)paramParcel.readParcelable(classLoader);
    this.mIconUri = (Uri)paramParcel.readParcelable(classLoader);
    this.mExtras = paramParcel.readBundle(classLoader);
    this.mMediaUri = (Uri)paramParcel.readParcelable(classLoader);
  }
  
  MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2) {
    this.mMediaId = paramString;
    this.mTitle = paramCharSequence1;
    this.mSubtitle = paramCharSequence2;
    this.mDescription = paramCharSequence3;
    this.mIcon = paramBitmap;
    this.mIconUri = paramUri1;
    this.mExtras = paramBundle;
    this.mMediaUri = paramUri2;
  }
  
  public static MediaDescriptionCompat fromMediaDescription(Object paramObject) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_3
    //   5: astore_1
    //   6: aload_0
    //   7: ifnull -> 205
    //   10: aload_3
    //   11: astore_1
    //   12: getstatic android/os/Build$VERSION.SDK_INT : I
    //   15: bipush #21
    //   17: if_icmplt -> 205
    //   20: new android/support/v4/media/MediaDescriptionCompat$Builder
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #4
    //   29: aload #4
    //   31: aload_0
    //   32: invokestatic getMediaId : (Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokevirtual setMediaId : (Ljava/lang/String;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   38: pop
    //   39: aload #4
    //   41: aload_0
    //   42: invokestatic getTitle : (Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   45: invokevirtual setTitle : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   48: pop
    //   49: aload #4
    //   51: aload_0
    //   52: invokestatic getSubtitle : (Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   55: invokevirtual setSubtitle : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   58: pop
    //   59: aload #4
    //   61: aload_0
    //   62: invokestatic getDescription : (Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   65: invokevirtual setDescription : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   68: pop
    //   69: aload #4
    //   71: aload_0
    //   72: invokestatic getIconBitmap : (Ljava/lang/Object;)Landroid/graphics/Bitmap;
    //   75: invokevirtual setIconBitmap : (Landroid/graphics/Bitmap;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   78: pop
    //   79: aload #4
    //   81: aload_0
    //   82: invokestatic getIconUri : (Ljava/lang/Object;)Landroid/net/Uri;
    //   85: invokevirtual setIconUri : (Landroid/net/Uri;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   88: pop
    //   89: aload_0
    //   90: invokestatic getExtras : (Ljava/lang/Object;)Landroid/os/Bundle;
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull -> 115
    //   98: aload_3
    //   99: invokestatic ensureClassLoader : (Landroid/os/Bundle;)V
    //   102: aload_3
    //   103: ldc 'android.support.v4.media.description.MEDIA_URI'
    //   105: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   108: checkcast android/net/Uri
    //   111: astore_1
    //   112: goto -> 117
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull -> 153
    //   121: aload_3
    //   122: ldc 'android.support.v4.media.description.NULL_BUNDLE_FLAG'
    //   124: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   127: ifeq -> 141
    //   130: aload_3
    //   131: invokevirtual size : ()I
    //   134: iconst_2
    //   135: if_icmpne -> 141
    //   138: goto -> 155
    //   141: aload_3
    //   142: ldc 'android.support.v4.media.description.MEDIA_URI'
    //   144: invokevirtual remove : (Ljava/lang/String;)V
    //   147: aload_3
    //   148: ldc 'android.support.v4.media.description.NULL_BUNDLE_FLAG'
    //   150: invokevirtual remove : (Ljava/lang/String;)V
    //   153: aload_3
    //   154: astore_2
    //   155: aload #4
    //   157: aload_2
    //   158: invokevirtual setExtras : (Landroid/os/Bundle;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   161: pop
    //   162: aload_1
    //   163: ifnull -> 176
    //   166: aload #4
    //   168: aload_1
    //   169: invokevirtual setMediaUri : (Landroid/net/Uri;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   172: pop
    //   173: goto -> 194
    //   176: getstatic android/os/Build$VERSION.SDK_INT : I
    //   179: bipush #23
    //   181: if_icmplt -> 194
    //   184: aload #4
    //   186: aload_0
    //   187: invokestatic getMediaUri : (Ljava/lang/Object;)Landroid/net/Uri;
    //   190: invokevirtual setMediaUri : (Landroid/net/Uri;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   193: pop
    //   194: aload #4
    //   196: invokevirtual build : ()Landroid/support/v4/media/MediaDescriptionCompat;
    //   199: astore_1
    //   200: aload_1
    //   201: aload_0
    //   202: putfield mDescriptionObj : Ljava/lang/Object;
    //   205: aload_1
    //   206: areturn
  }
  
  public int describeContents() {
    return 0;
  }
  
  public CharSequence getDescription() {
    return this.mDescription;
  }
  
  public Bundle getExtras() {
    return this.mExtras;
  }
  
  public Bitmap getIconBitmap() {
    return this.mIcon;
  }
  
  public Uri getIconUri() {
    return this.mIconUri;
  }
  
  public Object getMediaDescription() {
    if (this.mDescriptionObj != null || Build.VERSION.SDK_INT < 21)
      return this.mDescriptionObj; 
    Object object = MediaDescriptionCompatApi21.Builder.newInstance();
    MediaDescriptionCompatApi21.Builder.setMediaId(object, this.mMediaId);
    MediaDescriptionCompatApi21.Builder.setTitle(object, this.mTitle);
    MediaDescriptionCompatApi21.Builder.setSubtitle(object, this.mSubtitle);
    MediaDescriptionCompatApi21.Builder.setDescription(object, this.mDescription);
    MediaDescriptionCompatApi21.Builder.setIconBitmap(object, this.mIcon);
    MediaDescriptionCompatApi21.Builder.setIconUri(object, this.mIconUri);
    Bundle bundle2 = this.mExtras;
    Bundle bundle1 = bundle2;
    if (Build.VERSION.SDK_INT < 23) {
      bundle1 = bundle2;
      if (this.mMediaUri != null) {
        bundle1 = bundle2;
        if (bundle2 == null) {
          bundle1 = new Bundle();
          bundle1.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
        } 
        bundle1.putParcelable("android.support.v4.media.description.MEDIA_URI", (Parcelable)this.mMediaUri);
      } 
    } 
    MediaDescriptionCompatApi21.Builder.setExtras(object, bundle1);
    if (Build.VERSION.SDK_INT >= 23)
      MediaDescriptionCompatApi23.Builder.setMediaUri(object, this.mMediaUri); 
    this.mDescriptionObj = MediaDescriptionCompatApi21.Builder.build(object);
    return this.mDescriptionObj;
  }
  
  public String getMediaId() {
    return this.mMediaId;
  }
  
  public Uri getMediaUri() {
    return this.mMediaUri;
  }
  
  public CharSequence getSubtitle() {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle() {
    return this.mTitle;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mTitle);
    stringBuilder.append(", ");
    stringBuilder.append(this.mSubtitle);
    stringBuilder.append(", ");
    stringBuilder.append(this.mDescription);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    if (Build.VERSION.SDK_INT < 21) {
      paramParcel.writeString(this.mMediaId);
      TextUtils.writeToParcel(this.mTitle, paramParcel, paramInt);
      TextUtils.writeToParcel(this.mSubtitle, paramParcel, paramInt);
      TextUtils.writeToParcel(this.mDescription, paramParcel, paramInt);
      paramParcel.writeParcelable((Parcelable)this.mIcon, paramInt);
      paramParcel.writeParcelable((Parcelable)this.mIconUri, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable((Parcelable)this.mMediaUri, paramInt);
      return;
    } 
    MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), paramParcel, paramInt);
  }
  
  public static final class Builder {
    private CharSequence mDescription;
    
    private Bundle mExtras;
    
    private Bitmap mIcon;
    
    private Uri mIconUri;
    
    private String mMediaId;
    
    private Uri mMediaUri;
    
    private CharSequence mSubtitle;
    
    private CharSequence mTitle;
    
    public MediaDescriptionCompat build() {
      return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
    }
    
    public Builder setDescription(CharSequence param1CharSequence) {
      this.mDescription = param1CharSequence;
      return this;
    }
    
    public Builder setExtras(Bundle param1Bundle) {
      this.mExtras = param1Bundle;
      return this;
    }
    
    public Builder setIconBitmap(Bitmap param1Bitmap) {
      this.mIcon = param1Bitmap;
      return this;
    }
    
    public Builder setIconUri(Uri param1Uri) {
      this.mIconUri = param1Uri;
      return this;
    }
    
    public Builder setMediaId(String param1String) {
      this.mMediaId = param1String;
      return this;
    }
    
    public Builder setMediaUri(Uri param1Uri) {
      this.mMediaUri = param1Uri;
      return this;
    }
    
    public Builder setSubtitle(CharSequence param1CharSequence) {
      this.mSubtitle = param1CharSequence;
      return this;
    }
    
    public Builder setTitle(CharSequence param1CharSequence) {
      this.mTitle = param1CharSequence;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\android\support\v4\media\MediaDescriptionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */