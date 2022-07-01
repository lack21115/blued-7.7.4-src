package com.soft.blued.ui.user.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.fragment.CommandFragment;
import com.soft.blued.ui.user.model.WatchWordModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandManager {
  private static final CommandManager a = new CommandManager();
  
  private int b = 10;
  
  private int c;
  
  public static CommandManager a() {
    return a;
  }
  
  private boolean a(String paramString) {
    return paramString.contains("##");
  }
  
  public static String b(Context paramContext) {
    Context context = paramContext;
    if (paramContext == null)
      context = AppInfo.d(); 
    ClipData clipData = ((ClipboardManager)context.getSystemService("clipboard")).getPrimaryClip();
    return (clipData != null && clipData.getItemCount() > 0 && !TextUtils.isEmpty(clipData.getItemAt(0).getText())) ? clipData.getItemAt(0).getText().toString() : "";
  }
  
  private void b(String paramString) {
    String str;
    Matcher matcher = Pattern.compile("##([^##]+)##").matcher(paramString);
    if (matcher.find()) {
      str = matcher.group(1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("matcher:");
      stringBuilder.append(str);
      Log.v("drb", stringBuilder.toString());
    } else {
      str = "";
    } 
    MineHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<WatchWordModel>>(this, null) {
          protected void a(BluedEntityA<WatchWordModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              WatchWordModel watchWordModel = param1BluedEntityA.data.get(0);
              if (!TextUtils.isEmpty(watchWordModel.image)) {
                ImageFileLoader.a(null).a(watchWordModel.image).a(new ImageLoadResult(this, null, watchWordModel) {
                      public void a() {
                        CommandFragment.a((Context)BluedApplicationLike.getForeActivity(), this.a);
                      }
                    }).a();
                return;
              } 
              WebViewShowInfoFragment.show((Context)BluedApplicationLike.getForeActivity(), watchWordModel.url, -1);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
          
          public void onUIFinish() {}
        }str);
  }
  
  public void a(Context paramContext) {
    Log.v("drb", "start");
    AppInfo.n().postDelayed(new Runnable(this, paramContext) {
          public void run() {
            if (BluedPreferences.cG()) {
              if (CommandManager.a(this.b) < CommandManager.b(this.b)) {
                CommandManager.c(this.b);
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("在开机动画restartCount：");
                stringBuilder1.append(CommandManager.a(this.b));
                Log.v("drb", stringBuilder1.toString());
                this.b.a(this.a);
              } 
              return;
            } 
            CommandManager.a(this.b, 0);
            String str = CommandManager.b(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getClipData:");
            stringBuilder.append(str);
            Log.v("drb", stringBuilder.toString());
            if (!TextUtils.isEmpty(str) && CommandManager.a(this.b, str))
              CommandManager.b(this.b, str); 
          }
        }1000L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\use\\utils\CommandManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */