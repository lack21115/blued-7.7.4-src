package com.blued.android.chat.data;

public enum LiveEnterFailedReason {
  BLOCKED_BY_PEER, BLOCK_PEER, LIVEROOM_CLOSE, LIVEROOM_FULL, LIVEROOM_KICKED_OUT, UNKNOWN;
  
  static {
    BLOCKED_BY_PEER = new LiveEnterFailedReason("BLOCKED_BY_PEER", 1);
    BLOCK_PEER = new LiveEnterFailedReason("BLOCK_PEER", 2);
    LIVEROOM_FULL = new LiveEnterFailedReason("LIVEROOM_FULL", 3);
    LIVEROOM_CLOSE = new LiveEnterFailedReason("LIVEROOM_CLOSE", 4);
    LIVEROOM_KICKED_OUT = new LiveEnterFailedReason("LIVEROOM_KICKED_OUT", 5);
    $VALUES = new LiveEnterFailedReason[] { UNKNOWN, BLOCKED_BY_PEER, BLOCK_PEER, LIVEROOM_FULL, LIVEROOM_CLOSE, LIVEROOM_KICKED_OUT };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\LiveEnterFailedReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */