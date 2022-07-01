package androidx.media;

import android.os.Bundle;
import androidx.versionedparcelable.VersionedParcelable;

interface AudioAttributesImpl extends VersionedParcelable {
  Object getAudioAttributes();
  
  int getContentType();
  
  int getFlags();
  
  int getLegacyStreamType();
  
  int getRawLegacyStreamType();
  
  int getUsage();
  
  int getVolumeControlStream();
  
  Bundle toBundle();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\AudioAttributesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */