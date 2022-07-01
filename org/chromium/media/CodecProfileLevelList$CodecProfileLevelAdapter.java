package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class CodecProfileLevelList$CodecProfileLevelAdapter {
  private final int mCodec;
  
  private final int mLevel;
  
  private final int mProfile;
  
  public CodecProfileLevelList$CodecProfileLevelAdapter(int paramInt1, int paramInt2, int paramInt3) {
    this.mCodec = paramInt1;
    this.mProfile = paramInt2;
    this.mLevel = paramInt3;
  }
  
  @CalledByNative
  public int getCodec() {
    return this.mCodec;
  }
  
  @CalledByNative
  public int getLevel() {
    return this.mLevel;
  }
  
  @CalledByNative
  public int getProfile() {
    return this.mProfile;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\CodecProfileLevelList$CodecProfileLevelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */