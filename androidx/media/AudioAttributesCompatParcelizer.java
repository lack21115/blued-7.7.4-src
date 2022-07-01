package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesCompatParcelizer {
  public static AudioAttributesCompat read(VersionedParcel paramVersionedParcel) {
    AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
    audioAttributesCompat.b = (AudioAttributesImpl)paramVersionedParcel.readVersionedParcelable(audioAttributesCompat.b, 1);
    return audioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, VersionedParcel paramVersionedParcel) {
    paramVersionedParcel.setSerializationFlags(false, false);
    paramVersionedParcel.writeVersionedParcelable(paramAudioAttributesCompat.b, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\AudioAttributesCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */