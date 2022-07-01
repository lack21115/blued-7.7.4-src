package com.soft.blued.ui.pay.alipay;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.app.PayTask;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.soft.blued.utils.AppUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AlipayUtils {
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sign_type=\"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    return stringBuilder.toString();
  }
  
  public static void a(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3) {
    try {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("&sign=\"");
    stringBuilder.append(paramString3);
    stringBuilder.append("\"&");
    stringBuilder.append(a(paramString1));
    paramString1 = stringBuilder.toString();
    ThreadManager.a().a(new ThreadExecutor("alipay", ThreadPriority.c, paramContext, paramString1, paramHandler) {
          public void execute() {
            String str = (new PayTask((Activity)this.a)).pay(this.b, true);
            Message message = new Message();
            message.what = 1;
            message.obj = str;
            this.c.sendMessage(message);
          }
        });
  }
  
  public static boolean a() {
    return AppUtils.a("com.taobao.taobao");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\alipay\AlipayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */