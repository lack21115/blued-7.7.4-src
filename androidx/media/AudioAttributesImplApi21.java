package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AudioAttributesImplApi21 implements AudioAttributesImpl {
  static Method c;
  
  AudioAttributes a;
  
  int b = -1;
  
  AudioAttributesImplApi21() {}
  
  AudioAttributesImplApi21(AudioAttributes paramAudioAttributes) {
    this(paramAudioAttributes, -1);
  }
  
  AudioAttributesImplApi21(AudioAttributes paramAudioAttributes, int paramInt) {
    this.a = paramAudioAttributes;
    this.b = paramInt;
  }
  
  static Method a() {
    try {
      if (c == null)
        c = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[] { AudioAttributes.class }); 
      return c;
    } catch (NoSuchMethodException noSuchMethodException) {
      return null;
    } 
  }
  
  public static AudioAttributesImpl fromBundle(Bundle paramBundle) {
    if (paramBundle == null)
      return null; 
    AudioAttributes audioAttributes = (AudioAttributes)paramBundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS");
    return (audioAttributes == null) ? null : new AudioAttributesImplApi21(audioAttributes, paramBundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof AudioAttributesImplApi21))
      return false; 
    paramObject = paramObject;
    return this.a.equals(((AudioAttributesImplApi21)paramObject).a);
  }
  
  public Object getAudioAttributes() {
    return this.a;
  }
  
  public int getContentType() {
    return this.a.getContentType();
  }
  
  public int getFlags() {
    return this.a.getFlags();
  }
  
  public int getLegacyStreamType() {
    StringBuilder stringBuilder1;
    int i = this.b;
    if (i != -1)
      return i; 
    Method method = a();
    if (method == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("No AudioAttributes#toLegacyStreamType() on API: ");
      stringBuilder1.append(Build.VERSION.SDK_INT);
      Log.w("AudioAttributesCompat21", stringBuilder1.toString());
      return -1;
    } 
    try {
      return ((Integer)stringBuilder1.invoke(null, new Object[] { this.a })).intValue();
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("getLegacyStreamType() failed on API: ");
    stringBuilder2.append(Build.VERSION.SDK_INT);
    Log.w("AudioAttributesCompat21", stringBuilder2.toString(), illegalAccessException);
    return -1;
  }
  
  public int getRawLegacyStreamType() {
    return this.b;
  }
  
  public int getUsage() {
    return this.a.getUsage();
  }
  
  public int getVolumeControlStream() {
    return (Build.VERSION.SDK_INT >= 26) ? this.a.getVolumeControlStream() : AudioAttributesCompat.a(true, getFlags(), getUsage());
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public Bundle toBundle() {
    Bundle bundle = new Bundle();
    bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", (Parcelable)this.a);
    int i = this.b;
    if (i != -1)
      bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i); 
    return bundle;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AudioAttributesCompat: audioattributes=");
    stringBuilder.append(this.a);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\AudioAttributesImplApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */