package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioAttributesCompat implements VersionedParcelable {
  public static final int CONTENT_TYPE_MOVIE = 3;
  
  public static final int CONTENT_TYPE_MUSIC = 2;
  
  public static final int CONTENT_TYPE_SONIFICATION = 4;
  
  public static final int CONTENT_TYPE_SPEECH = 1;
  
  public static final int CONTENT_TYPE_UNKNOWN = 0;
  
  public static final int FLAG_AUDIBILITY_ENFORCED = 1;
  
  public static final int FLAG_HW_AV_SYNC = 16;
  
  public static final int USAGE_ALARM = 4;
  
  public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
  
  public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
  
  public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
  
  public static final int USAGE_ASSISTANT = 16;
  
  public static final int USAGE_GAME = 14;
  
  public static final int USAGE_MEDIA = 1;
  
  public static final int USAGE_NOTIFICATION = 5;
  
  public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
  
  public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
  
  public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
  
  public static final int USAGE_NOTIFICATION_EVENT = 10;
  
  public static final int USAGE_NOTIFICATION_RINGTONE = 6;
  
  public static final int USAGE_UNKNOWN = 0;
  
  public static final int USAGE_VOICE_COMMUNICATION = 2;
  
  public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
  
  static boolean a;
  
  private static final SparseIntArray c = new SparseIntArray();
  
  private static final int[] d = new int[] { 
      0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
      10, 11, 12, 13, 14, 16 };
  
  AudioAttributesImpl b;
  
  AudioAttributesCompat() {}
  
  AudioAttributesCompat(AudioAttributesImpl paramAudioAttributesImpl) {
    this.b = paramAudioAttributesImpl;
  }
  
  static int a(boolean paramBoolean, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder;
    if ((paramInt1 & 0x1) == 1)
      return paramBoolean ? 1 : 7; 
    boolean bool = false;
    if ((paramInt1 & 0x4) == 4)
      return paramBoolean ? 0 : 6; 
    byte b = 3;
    paramInt1 = bool;
    switch (paramInt2) {
      default:
        if (!paramBoolean)
          return 3; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown usage value ");
        stringBuilder.append(paramInt2);
        stringBuilder.append(" in audio attributes");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 13:
        return 1;
      case 11:
        return 10;
      case 6:
        return 2;
      case 5:
      case 7:
      case 8:
      case 9:
      case 10:
        return 5;
      case 4:
        return 4;
      case 3:
        if (paramBoolean)
          return 0; 
        paramInt1 = 8;
      case 2:
        return paramInt1;
      case 1:
      case 12:
      case 14:
      case 16:
        return 3;
      case 0:
        break;
    } 
    paramInt1 = b;
    if (paramBoolean)
      paramInt1 = Integer.MIN_VALUE; 
    return paramInt1;
  }
  
  static String a(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("unknown usage ");
        stringBuilder.append(paramInt);
        return stringBuilder.toString();
      case 16:
        return "USAGE_ASSISTANT";
      case 14:
        return "USAGE_GAME";
      case 13:
        return "USAGE_ASSISTANCE_SONIFICATION";
      case 12:
        return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
      case 11:
        return "USAGE_ASSISTANCE_ACCESSIBILITY";
      case 10:
        return "USAGE_NOTIFICATION_EVENT";
      case 9:
        return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
      case 8:
        return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
      case 7:
        return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
      case 6:
        return "USAGE_NOTIFICATION_RINGTONE";
      case 5:
        return "USAGE_NOTIFICATION";
      case 4:
        return "USAGE_ALARM";
      case 3:
        return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
      case 2:
        return "USAGE_VOICE_COMMUNICATION";
      case 1:
        return "USAGE_MEDIA";
      case 0:
        break;
    } 
    return "USAGE_UNKNOWN";
  }
  
  static int b(int paramInt) {
    switch (paramInt) {
      default:
        return 0;
      case 10:
        return 11;
      case 8:
        return 3;
      case 6:
        return 2;
      case 5:
        return 5;
      case 4:
        return 4;
      case 3:
        return 1;
      case 2:
        return 6;
      case 1:
      case 7:
        return 13;
      case 0:
        break;
    } 
    return 2;
  }
  
  public static AudioAttributesCompat fromBundle(Bundle paramBundle) {
    AudioAttributesImpl audioAttributesImpl;
    if (Build.VERSION.SDK_INT >= 21) {
      audioAttributesImpl = AudioAttributesImplApi21.fromBundle(paramBundle);
    } else {
      audioAttributesImpl = AudioAttributesImplBase.fromBundle((Bundle)audioAttributesImpl);
    } 
    return (audioAttributesImpl == null) ? null : new AudioAttributesCompat(audioAttributesImpl);
  }
  
  public static void setForceLegacyBehavior(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static AudioAttributesCompat wrap(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 21 && !a) {
      paramObject = new AudioAttributesImplApi21((AudioAttributes)paramObject);
      AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
      audioAttributesCompat.b = (AudioAttributesImpl)paramObject;
      return audioAttributesCompat;
    } 
    return null;
  }
  
  int a() {
    return this.b.getRawLegacyStreamType();
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = paramObject instanceof AudioAttributesCompat;
    boolean bool = false;
    if (!bool1)
      return false; 
    paramObject = paramObject;
    AudioAttributesImpl audioAttributesImpl = this.b;
    if (audioAttributesImpl == null) {
      if (((AudioAttributesCompat)paramObject).b == null)
        bool = true; 
      return bool;
    } 
    return audioAttributesImpl.equals(((AudioAttributesCompat)paramObject).b);
  }
  
  public int getContentType() {
    return this.b.getContentType();
  }
  
  public int getFlags() {
    return this.b.getFlags();
  }
  
  public int getLegacyStreamType() {
    return this.b.getLegacyStreamType();
  }
  
  public int getUsage() {
    return this.b.getUsage();
  }
  
  public int getVolumeControlStream() {
    return this.b.getVolumeControlStream();
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
  
  public Bundle toBundle() {
    return this.b.toBundle();
  }
  
  public String toString() {
    return this.b.toString();
  }
  
  public Object unwrap() {
    return this.b.getAudioAttributes();
  }
  
  static {
    c.put(5, 1);
    c.put(6, 2);
    c.put(7, 2);
    c.put(8, 1);
    c.put(9, 1);
    c.put(10, 1);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AttributeContentType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AttributeUsage {}
  
  static abstract class AudioManagerHidden {
    public static final int STREAM_ACCESSIBILITY = 10;
    
    public static final int STREAM_BLUETOOTH_SCO = 6;
    
    public static final int STREAM_SYSTEM_ENFORCED = 7;
    
    public static final int STREAM_TTS = 9;
  }
  
  public static class Builder {
    private int a = 0;
    
    private int b = 0;
    
    private int c = 0;
    
    private int d = -1;
    
    public Builder() {}
    
    public Builder(AudioAttributesCompat param1AudioAttributesCompat) {
      this.a = param1AudioAttributesCompat.getUsage();
      this.b = param1AudioAttributesCompat.getContentType();
      this.c = param1AudioAttributesCompat.getFlags();
      this.d = param1AudioAttributesCompat.a();
    }
    
    Builder a(int param1Int) {
      StringBuilder stringBuilder;
      switch (param1Int) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid stream type ");
          stringBuilder.append(param1Int);
          stringBuilder.append(" for AudioAttributesCompat");
          Log.e("AudioAttributesCompat", stringBuilder.toString());
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 10:
          this.b = 1;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 9:
          this.b = 4;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 8:
          this.b = 4;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 7:
          this.c = 0x1 | this.c;
        case 6:
          this.b = 1;
          this.c |= 0x4;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 5:
          this.b = 4;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 4:
          this.b = 4;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 3:
          this.b = 2;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 2:
          this.b = 4;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 1:
          this.b = 4;
          this.a = AudioAttributesCompat.b(param1Int);
          return this;
        case 0:
          break;
      } 
      this.b = 1;
      this.a = AudioAttributesCompat.b(param1Int);
      return this;
    }
    
    public AudioAttributesCompat build() {
      AudioAttributesImplBase audioAttributesImplBase;
      if (!AudioAttributesCompat.a && Build.VERSION.SDK_INT >= 21) {
        AudioAttributes.Builder builder = (new AudioAttributes.Builder()).setContentType(this.b).setFlags(this.c).setUsage(this.a);
        int i = this.d;
        if (i != -1)
          builder.setLegacyStreamType(i); 
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21(builder.build(), this.d);
      } else {
        audioAttributesImplBase = new AudioAttributesImplBase(this.b, this.c, this.a, this.d);
      } 
      return new AudioAttributesCompat(audioAttributesImplBase);
    }
    
    public Builder setContentType(int param1Int) {
      if (param1Int != 0 && param1Int != 1 && param1Int != 2 && param1Int != 3 && param1Int != 4) {
        this.a = 0;
        return this;
      } 
      this.b = param1Int;
      return this;
    }
    
    public Builder setFlags(int param1Int) {
      this.c = param1Int & 0x3FF | this.c;
      return this;
    }
    
    public Builder setLegacyStreamType(int param1Int) {
      if (param1Int != 10) {
        this.d = param1Int;
        return (Build.VERSION.SDK_INT >= 21) ? a(param1Int) : this;
      } 
      throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
    }
    
    public Builder setUsage(int param1Int) {
      switch (param1Int) {
        default:
          this.a = 0;
          return this;
        case 16:
          if (!AudioAttributesCompat.a && Build.VERSION.SDK_INT > 25) {
            this.a = param1Int;
            return this;
          } 
          this.a = 12;
          return this;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
          break;
      } 
      this.a = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\AudioAttributesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */