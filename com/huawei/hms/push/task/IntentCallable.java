package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import java.util.concurrent.Callable;

public class IntentCallable implements Callable<Void> {
  public Context a;
  
  public Intent b;
  
  public String c;
  
  public IntentCallable(Context paramContext, Intent paramIntent, String paramString) {
    this.a = paramContext;
    this.b = paramIntent;
    this.c = paramString;
  }
  
  public Void call() throws Exception {
    this.a.sendBroadcast(this.b);
    PushBiUtil.reportExit(this.a, "push.setNotifyFlag", this.c, ErrorEnum.SUCCESS);
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\task\IntentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */