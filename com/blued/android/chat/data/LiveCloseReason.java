package com.blued.android.chat.data;

public enum LiveCloseReason {
  CLOSED_BY_LIVER, CLOSED_BY_MANAGER, CLOSED_BY_SELF;
  
  static {
    CLOSED_BY_LIVER = new LiveCloseReason("CLOSED_BY_LIVER", 1);
    CLOSED_BY_MANAGER = new LiveCloseReason("CLOSED_BY_MANAGER", 2);
    $VALUES = new LiveCloseReason[] { CLOSED_BY_SELF, CLOSED_BY_LIVER, CLOSED_BY_MANAGER };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\LiveCloseReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */