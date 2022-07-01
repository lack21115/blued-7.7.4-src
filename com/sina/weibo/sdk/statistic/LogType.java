package com.sina.weibo.sdk.statistic;

enum LogType {
  ACTIVITY, EVENT, FRAGMENT, SESSION_END, SESSION_START;
  
  static {
    SESSION_END = new LogType("SESSION_END", 1);
    FRAGMENT = new LogType("FRAGMENT", 2);
    EVENT = new LogType("EVENT", 3);
    ACTIVITY = new LogType("ACTIVITY", 4);
    ENUM$VALUES = new LogType[] { SESSION_START, SESSION_END, FRAGMENT, EVENT, ACTIVITY };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\LogType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */