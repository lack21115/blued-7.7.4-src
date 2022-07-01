package com.blued.android.framework.utils.upload.qiniu;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import java.util.Map;

public class QiniuTokenUtils {
  public static void a(String paramString, int paramInt, StringHttpResponseHandler paramStringHttpResponseHandler, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("number_images", stringBuilder.toString());
    HttpManager.a(paramString, (HttpResponseHandler)paramStringHttpResponseHandler, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\QiniuTokenUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */