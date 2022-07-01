package com.blued.android.chat.data;

public enum JoinLiveResult {
  FAILED_JOINLIVE_CLOSE, FAILED_JOINLIVE_FULL, FAILED_JOINLIVE_INVITE_OVERDUE, FAILED_UNKNOWN, SUCCESS;
  
  static {
    FAILED_UNKNOWN = new JoinLiveResult("FAILED_UNKNOWN", 1);
    FAILED_JOINLIVE_CLOSE = new JoinLiveResult("FAILED_JOINLIVE_CLOSE", 2);
    FAILED_JOINLIVE_FULL = new JoinLiveResult("FAILED_JOINLIVE_FULL", 3);
    FAILED_JOINLIVE_INVITE_OVERDUE = new JoinLiveResult("FAILED_JOINLIVE_INVITE_OVERDUE", 4);
    $VALUES = new JoinLiveResult[] { SUCCESS, FAILED_UNKNOWN, FAILED_JOINLIVE_CLOSE, FAILED_JOINLIVE_FULL, FAILED_JOINLIVE_INVITE_OVERDUE };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\JoinLiveResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */