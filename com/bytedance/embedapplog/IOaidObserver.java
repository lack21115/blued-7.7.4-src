package com.bytedance.embedapplog;

public interface IOaidObserver {
  void onOaidLoaded(Oaid paramOaid);
  
  public static final class Oaid {
    public final String id;
    
    public Oaid(String param1String) {
      this.id = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\IOaidObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */