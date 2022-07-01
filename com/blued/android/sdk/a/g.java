package com.blued.android.sdk.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import java.util.List;

public class g {
  public static void a(Context paramContext) {
    (new AlertDialog.Builder(paramContext)).setMessage("您的手机没有安装Blued客户端，是否前往官网进行下载?").setPositiveButton("前往", new DialogInterface.OnClickListener(paramContext) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            g.b(this.a);
          }
        }).setNegativeButton("取消", null).show();
  }
  
  public static boolean a(Context paramContext, Intent paramIntent) {
    List list = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (list != null && list.size() > 0);
  }
  
  public static void b(Context paramContext) {
    Intent intent = new Intent();
    intent.setAction("android.intent.action.VIEW");
    intent.setData(Uri.parse("https://www.blued.cn"));
    paramContext.startActivity(intent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */