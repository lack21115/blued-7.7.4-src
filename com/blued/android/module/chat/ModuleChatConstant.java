package com.blued.android.module.chat;

public class ModuleChatConstant {
  public static int DEFAULT_REMIND_AUDIO_VALUE = 0;
  
  public static final long DELAYED_GETSESSION_TIME = 1000L;
  
  public static final int INTERVAL_TIME = 300000;
  
  public static final int ONCE_UPDATE_COUNT = 100;
  
  public static final String TAG = "@@@ module_chat_";
  
  public static final int UPDATE_MAX_COUNT = 500;
  
  public static interface RELATION_STATUS {
    public static final int N = 0;
    
    public static final int UNKNOWN = 3;
    
    public static final int Y = 1;
  }
  
  public static interface SESSION {
    public static final int DELETE = 1;
  }
  
  public static interface UPDATE_RELATION_DATA_CODE {
    public static final int ERROR = 404;
    
    public static final int NO_UPDATE_TIME = 201;
    
    public static final int SUCESS = 200;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\ModuleChatConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */