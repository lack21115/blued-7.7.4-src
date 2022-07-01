package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
  public static final Parcelable.Creator CREATOR = new MediaDescriptionCompat$1();
  
  private final CharSequence mDescription;
  
  private Object mDescriptionObj;
  
  private final Bundle mExtras;
  
  private final Bitmap mIcon;
  
  private final Uri mIconUri;
  
  private final String mMediaId;
  
  private final Uri mMediaUri;
  
  private final CharSequence mSubtitle;
  
  private final CharSequence mTitle;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaDescriptionCompat(Parcel paramParcel) {
    this.mMediaId = paramParcel.readString();
    this.mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mIcon = (Bitmap)paramParcel.readParcelable(null);
    this.mIconUri = (Uri)paramParcel.readParcelable(null);
    this.mExtras = paramParcel.readBundle();
    this.mMediaUri = (Uri)paramParcel.readParcelable(null);
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2) {
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
    //   1: astore_2
    //   2: aload_0
    //   3: ifnull -> 244
    //   6: getstatic android/os/Build$VERSION.SDK_INT : I
    //   9: bipush #21
    //   11: if_icmplt -> 244
    //   14: new android/support/v4/media/MediaDescriptionCompat$Builder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #4
    //   23: aload_0
    //   24: checkcast android/media/MediaDescription
    //   27: astore #5
    //   29: aload #4
    //   31: aload #5
    //   33: invokevirtual getMediaId : ()Ljava/lang/String;
    //   36: putfield mMediaId : Ljava/lang/String;
    //   39: aload #4
    //   41: aload #5
    //   43: invokevirtual getTitle : ()Ljava/lang/CharSequence;
    //   46: putfield mTitle : Ljava/lang/CharSequence;
    //   49: aload #4
    //   51: aload #5
    //   53: invokevirtual getSubtitle : ()Ljava/lang/CharSequence;
    //   56: putfield mSubtitle : Ljava/lang/CharSequence;
    //   59: aload #4
    //   61: aload #5
    //   63: invokevirtual getDescription : ()Ljava/lang/CharSequence;
    //   66: putfield mDescription : Ljava/lang/CharSequence;
    //   69: aload #4
    //   71: aload #5
    //   73: invokevirtual getIconBitmap : ()Landroid/graphics/Bitmap;
    //   76: putfield mIcon : Landroid/graphics/Bitmap;
    //   79: aload #4
    //   81: aload #5
    //   83: invokevirtual getIconUri : ()Landroid/net/Uri;
    //   86: putfield mIconUri : Landroid/net/Uri;
    //   89: aload #5
    //   91: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   94: astore_3
    //   95: aload_3
    //   96: ifnonnull -> 104
    //   99: aconst_null
    //   100: astore_1
    //   101: goto -> 114
    //   104: aload_3
    //   105: ldc 'android.support.v4.media.description.MEDIA_URI'
    //   107: invokevirtual getParcelable : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   110: checkcast android/net/Uri
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull -> 150
    //   118: aload_3
    //   119: ldc 'android.support.v4.media.description.NULL_BUNDLE_FLAG'
    //   121: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   124: ifeq -> 138
    //   127: aload_3
    //   128: invokevirtual size : ()I
    //   131: iconst_2
    //   132: if_icmpne -> 138
    //   135: goto -> 152
    //   138: aload_3
    //   139: ldc 'android.support.v4.media.description.MEDIA_URI'
    //   141: invokevirtual remove : (Ljava/lang/String;)V
    //   144: aload_3
    //   145: ldc 'android.support.v4.media.description.NULL_BUNDLE_FLAG'
    //   147: invokevirtual remove : (Ljava/lang/String;)V
    //   150: aload_3
    //   151: astore_2
    //   152: aload #4
    //   154: aload_2
    //   155: putfield mExtras : Landroid/os/Bundle;
    //   158: aload_1
    //   159: ifnull -> 171
    //   162: aload #4
    //   164: aload_1
    //   165: putfield mMediaUri : Landroid/net/Uri;
    //   168: goto -> 189
    //   171: getstatic android/os/Build$VERSION.SDK_INT : I
    //   174: bipush #23
    //   176: if_icmplt -> 189
    //   179: aload #4
    //   181: aload #5
    //   183: invokevirtual getMediaUri : ()Landroid/net/Uri;
    //   186: putfield mMediaUri : Landroid/net/Uri;
    //   189: new android/support/v4/media/MediaDescriptionCompat
    //   192: dup
    //   193: aload #4
    //   195: getfield mMediaId : Ljava/lang/String;
    //   198: aload #4
    //   200: getfield mTitle : Ljava/lang/CharSequence;
    //   203: aload #4
    //   205: getfield mSubtitle : Ljava/lang/CharSequence;
    //   208: aload #4
    //   210: getfield mDescription : Ljava/lang/CharSequence;
    //   213: aload #4
    //   215: getfield mIcon : Landroid/graphics/Bitmap;
    //   218: aload #4
    //   220: getfield mIconUri : Landroid/net/Uri;
    //   223: aload #4
    //   225: getfield mExtras : Landroid/os/Bundle;
    //   228: aload #4
    //   230: getfield mMediaUri : Landroid/net/Uri;
    //   233: invokespecial <init> : (Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/Bitmap;Landroid/net/Uri;Landroid/os/Bundle;Landroid/net/Uri;)V
    //   236: astore_1
    //   237: aload_1
    //   238: aload_0
    //   239: putfield mDescriptionObj : Ljava/lang/Object;
    //   242: aload_1
    //   243: areturn
    //   244: aconst_null
    //   245: areturn
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mTitle);
    stringBuilder.append(", ");
    stringBuilder.append(this.mSubtitle);
    stringBuilder.append(", ");
    stringBuilder.append(this.mDescription);
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    Object object;
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
    if (this.mDescriptionObj != null || Build.VERSION.SDK_INT < 21) {
      object = this.mDescriptionObj;
    } else {
      MediaDescription.Builder builder1 = new MediaDescription.Builder();
      String str = this.mMediaId;
      MediaDescription.Builder builder2 = builder1;
      builder2.setMediaId(str);
      builder2.setTitle(this.mTitle);
      builder2.setSubtitle(this.mSubtitle);
      builder2.setDescription(this.mDescription);
      builder2.setIconBitmap(this.mIcon);
      builder2.setIconUri(this.mIconUri);
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
      builder2.setExtras(bundle1);
      if (Build.VERSION.SDK_INT >= 23)
        builder2.setMediaUri(this.mMediaUri); 
      this.mDescriptionObj = builder2.build();
      object = this.mDescriptionObj;
    } 
    ((MediaDescription)object).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\MediaDescriptionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */