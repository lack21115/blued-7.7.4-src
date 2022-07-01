package com.huawei.hms.push.task;

public class SubscribeTask extends BaseVoidTask {
  public SubscribeTask(String paramString1, String paramString2, String paramString3) {
    super(paramString1, paramString2, paramString3);
  }
  
  public int getMinApkVersion() {
    return 40003000;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\task\SubscribeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */