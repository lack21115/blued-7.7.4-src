package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer {
  public static AudioAttributesImplBase read(VersionedParcel paramVersionedParcel) {
    AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
    audioAttributesImplBase.a = paramVersionedParcel.readInt(audioAttributesImplBase.a, 1);
    audioAttributesImplBase.b = paramVersionedParcel.readInt(audioAttributesImplBase.b, 2);
    audioAttributesImplBase.c = paramVersionedParcel.readInt(audioAttributesImplBase.c, 3);
    audioAttributesImplBase.d = paramVersionedParcel.readInt(audioAttributesImplBase.d, 4);
    return audioAttributesImplBase;
  }
  
  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, VersionedParcel paramVersionedParcel) {
    paramVersionedParcel.setSerializationFlags(false, false);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.a, 1);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.b, 2);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.c, 3);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.d, 4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\AudioAttributesImplBaseParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */