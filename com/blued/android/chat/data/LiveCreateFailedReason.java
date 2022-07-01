package com.blued.android.chat.data;

public enum LiveCreateFailedReason {
  DESCRIPTION_INVALID, FORBIDDEN_LIVE, NO_AUTHORITY_LIVE, UNKNOWN;
  
  static {
    NO_AUTHORITY_LIVE = new LiveCreateFailedReason("NO_AUTHORITY_LIVE", 1);
    FORBIDDEN_LIVE = new LiveCreateFailedReason("FORBIDDEN_LIVE", 2);
    DESCRIPTION_INVALID = new LiveCreateFailedReason("DESCRIPTION_INVALID", 3);
    $VALUES = new LiveCreateFailedReason[] { UNKNOWN, NO_AUTHORITY_LIVE, FORBIDDEN_LIVE, DESCRIPTION_INVALID };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\LiveCreateFailedReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */