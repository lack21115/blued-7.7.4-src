package androidx.media;

import android.os.Bundle;
import java.util.Arrays;

class AudioAttributesImplBase implements AudioAttributesImpl {
  int a = 0;
  
  int b = 0;
  
  int c = 0;
  
  int d = -1;
  
  AudioAttributesImplBase() {}
  
  AudioAttributesImplBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = paramInt3;
    this.d = paramInt4;
  }
  
  public static AudioAttributesImpl fromBundle(Bundle paramBundle) {
    if (paramBundle == null)
      return null; 
    int i = paramBundle.getInt("androidx.media.audio_attrs.USAGE", 0);
    return new AudioAttributesImplBase(paramBundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), paramBundle.getInt("androidx.media.audio_attrs.FLAGS", 0), i, paramBundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof AudioAttributesImplBase;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.b == paramObject.getContentType()) {
      bool = bool1;
      if (this.c == paramObject.getFlags()) {
        bool = bool1;
        if (this.a == paramObject.getUsage()) {
          bool = bool1;
          if (this.d == ((AudioAttributesImplBase)paramObject).d)
            bool = true; 
        } 
      } 
    } 
    return bool;
  }
  
  public Object getAudioAttributes() {
    return null;
  }
  
  public int getContentType() {
    return this.b;
  }
  
  public int getFlags() {
    int i;
    int j = this.c;
    int k = getLegacyStreamType();
    if (k == 6) {
      i = j | 0x4;
    } else {
      i = j;
      if (k == 7)
        i = j | 0x1; 
    } 
    return i & 0x111;
  }
  
  public int getLegacyStreamType() {
    int i = this.d;
    return (i != -1) ? i : AudioAttributesCompat.a(false, this.c, this.a);
  }
  
  public int getRawLegacyStreamType() {
    return this.d;
  }
  
  public int getUsage() {
    return this.a;
  }
  
  public int getVolumeControlStream() {
    return AudioAttributesCompat.a(true, this.c, this.a);
  }
  
  public int hashCode() {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.a), Integer.valueOf(this.d) });
  }
  
  public Bundle toBundle() {
    Bundle bundle = new Bundle();
    bundle.putInt("androidx.media.audio_attrs.USAGE", this.a);
    bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.b);
    bundle.putInt("androidx.media.audio_attrs.FLAGS", this.c);
    int i = this.d;
    if (i != -1)
      bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i); 
    return bundle;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (this.d != -1) {
      stringBuilder.append(" stream=");
      stringBuilder.append(this.d);
      stringBuilder.append(" derived");
    } 
    stringBuilder.append(" usage=");
    stringBuilder.append(AudioAttributesCompat.a(this.a));
    stringBuilder.append(" content=");
    stringBuilder.append(this.b);
    stringBuilder.append(" flags=0x");
    stringBuilder.append(Integer.toHexString(this.c).toUpperCase());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\AudioAttributesImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */