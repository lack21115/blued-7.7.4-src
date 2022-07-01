package com.alibaba.mtl.log.model;

public enum LogField {
  ACCESS, ACCESS_SUBTYPE, APPKEY, APPVERSION, ARG1, ARG2, ARG3, ARGS, BRAND, CARRIER, CHANNEL, DEVICE_MODEL, EVENTID, IMEI, IMSI, LANGUAGE, LL_USERID, LL_USERNICK, OS, OSVERSION, PAGE, RECORD_TIMESTAMP, RESERVE2, RESERVE3, RESERVE4, RESERVE5, RESERVES, RESOLUTION, SDKTYPE, SDKVERSION, START_SESSION_TIMESTAMP, USERID, USERNICK, UTDID;
  
  static {
    BRAND = new LogField("BRAND", 2);
    DEVICE_MODEL = new LogField("DEVICE_MODEL", 3);
    RESOLUTION = new LogField("RESOLUTION", 4);
    CARRIER = new LogField("CARRIER", 5);
    ACCESS = new LogField("ACCESS", 6);
    ACCESS_SUBTYPE = new LogField("ACCESS_SUBTYPE", 7);
    CHANNEL = new LogField("CHANNEL", 8);
    APPKEY = new LogField("APPKEY", 9);
    APPVERSION = new LogField("APPVERSION", 10);
    LL_USERNICK = new LogField("LL_USERNICK", 11);
    USERNICK = new LogField("USERNICK", 12);
    LL_USERID = new LogField("LL_USERID", 13);
    USERID = new LogField("USERID", 14);
    LANGUAGE = new LogField("LANGUAGE", 15);
    OS = new LogField("OS", 16);
    OSVERSION = new LogField("OSVERSION", 17);
    SDKVERSION = new LogField("SDKVERSION", 18);
    START_SESSION_TIMESTAMP = new LogField("START_SESSION_TIMESTAMP", 19);
    UTDID = new LogField("UTDID", 20);
    SDKTYPE = new LogField("SDKTYPE", 21);
    RESERVE2 = new LogField("RESERVE2", 22);
    RESERVE3 = new LogField("RESERVE3", 23);
    RESERVE4 = new LogField("RESERVE4", 24);
    RESERVE5 = new LogField("RESERVE5", 25);
    RESERVES = new LogField("RESERVES", 26);
    RECORD_TIMESTAMP = new LogField("RECORD_TIMESTAMP", 27);
    PAGE = new LogField("PAGE", 28);
    EVENTID = new LogField("EVENTID", 29);
    ARG1 = new LogField("ARG1", 30);
    ARG2 = new LogField("ARG2", 31);
    ARG3 = new LogField("ARG3", 32);
    ARGS = new LogField("ARGS", 33);
    a = new LogField[] { 
        IMEI, IMSI, BRAND, DEVICE_MODEL, RESOLUTION, CARRIER, ACCESS, ACCESS_SUBTYPE, CHANNEL, APPKEY, 
        APPVERSION, LL_USERNICK, USERNICK, LL_USERID, USERID, LANGUAGE, OS, OSVERSION, SDKVERSION, START_SESSION_TIMESTAMP, 
        UTDID, SDKTYPE, RESERVE2, RESERVE3, RESERVE4, RESERVE5, RESERVES, RECORD_TIMESTAMP, PAGE, EVENTID, 
        ARG1, ARG2, ARG3, ARGS };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\model\LogField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */