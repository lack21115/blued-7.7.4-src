package com.qiniu.pili.droid.shortvideo;

public enum PLAudioMixMode {
  EARPHONE_MODE, SPEAKERPHONE_MODE;
  
  static {
    EARPHONE_MODE = new PLAudioMixMode("EARPHONE_MODE", 1);
    $VALUES = new PLAudioMixMode[] { SPEAKERPHONE_MODE, EARPHONE_MODE };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLAudioMixMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */