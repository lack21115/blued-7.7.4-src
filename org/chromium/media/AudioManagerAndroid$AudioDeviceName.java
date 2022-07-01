package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class AudioManagerAndroid$AudioDeviceName {
  private final int mId;
  
  private final String mName;
  
  private AudioManagerAndroid$AudioDeviceName(int paramInt, String paramString) {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  @CalledByNative
  private String id() {
    return String.valueOf(this.mId);
  }
  
  @CalledByNative
  private String name() {
    return this.mName;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioManagerAndroid$AudioDeviceName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */