package com.soft.blued.emoticon.manager;

import android.content.Context;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.web.WebDownloaderManager;
import com.soft.blued.emoticon.model.EmotionPackDownload;
import com.soft.blued.http.ChatHttpUtils;

public class EmotionPackWebDownload {
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    ChatHttpUtils.a(paramContext, new BluedUIHttpResponse<BluedEntityA<EmotionPackDownload>>(paramString2, paramString3, paramString1) {
          protected void a(BluedEntityA<EmotionPackDownload> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              EmotionPackDownload emotionPackDownload = param1BluedEntityA.data.get(0);
              WebDownloaderManager.a().a(this.a, emotionPackDownload.download, this.b, this.c);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            WebDownloaderManager.a().a(this.a, this.b, this.c);
            return super.onUIFailure(param1Int, param1String);
          }
        }paramString1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\emoticon\manager\EmotionPackWebDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */