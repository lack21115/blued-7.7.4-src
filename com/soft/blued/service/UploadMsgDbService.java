package com.soft.blued.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.soft.blued.utils.Logger;

public class UploadMsgDbService extends Service {
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    String str1 = paramIntent.getStringExtra("FILE_PATH");
    String str2 = UploadMsgDbService.class.getSimpleName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("备份消息成功====");
    stringBuilder.append(str1);
    Logger.e(str2, new Object[] { stringBuilder.toString() });
    if (!TextUtils.isEmpty(str1))
      ToastUtils.a("备份成功"); 
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\service\UploadMsgDbService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */