package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer {
  public static AudioAttributesImplApi21 read(VersionedParcel paramVersionedParcel) {
    AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
    audioAttributesImplApi21.a = (AudioAttributes)paramVersionedParcel.readParcelable((Parcelable)audioAttributesImplApi21.a, 1);
    audioAttributesImplApi21.b = paramVersionedParcel.readInt(audioAttributesImplApi21.b, 2);
    return audioAttributesImplApi21;
  }
  
  public static void write(AudioAttributesImplApi21 paramAudioAttributesImplApi21, VersionedParcel paramVersionedParcel) {
    paramVersionedParcel.setSerializationFlags(false, false);
    paramVersionedParcel.writeParcelable((Parcelable)paramAudioAttributesImplApi21.a, 1);
    paramVersionedParcel.writeInt(paramAudioAttributesImplApi21.b, 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\AudioAttributesImplApi21Parcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */