package com.blued.android.module.external_sense_library.sticker;

import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class StickerDownLoader {
  private static final String a;
  
  private static volatile Map<String, String> b = new HashMap<String, String>();
  
  public static void a(String paramString1, String paramString2, IGetStickerListener paramIGetStickerListener, IRequestHost paramIRequestHost) {
    File file = new File(StickerConfig.b());
    if (!file.exists())
      file.mkdirs(); 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start downloadAsyn:");
    stringBuilder.append(paramString1);
    LogUtils.a(str, stringBuilder.toString(), new Object[0]);
    FileDownloader.a(paramString2, StickerConfig.b(paramString1), new FileHttpResponseHandler(paramString1, paramString2, paramIGetStickerListener) {
          public void a(File param1File) {
            String str = StickerDownLoader.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("downloadAsyn onSuccess:");
            stringBuilder.append(this.a);
            LogUtils.a(str, stringBuilder.toString(), new Object[0]);
            str = FileUtils.a(param1File, new File(StickerConfig.a()));
            param1File.delete();
            StickerDownLoader.b().remove(this.a);
            IGetStickerListener iGetStickerListener = this.c;
            if (iGetStickerListener != null) {
              iGetStickerListener.onSuccess(this.a, str);
              return;
            } 
            StickerUtils.a(this.a, this.b, str, 2);
          }
          
          public void a(Throwable param1Throwable, int param1Int, File param1File) {
            super.onFailure(param1Throwable, param1Int, param1File);
            String str = StickerDownLoader.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error:");
            stringBuilder.append(param1Throwable);
            LogUtils.a(str, stringBuilder.toString(), new Object[0]);
            StickerDownLoader.b().remove(this.a);
            IGetStickerListener iGetStickerListener = this.c;
            if (iGetStickerListener != null)
              iGetStickerListener.onFailed(ErrorCode.PlayStickerCode.b, "file downloader failed"); 
          }
          
          public void onCancel() {
            LogUtils.a(StickerDownLoader.a(), "onCancel", new Object[0]);
            StickerDownLoader.b().remove(this.a);
            IGetStickerListener iGetStickerListener = this.c;
            if (iGetStickerListener != null)
              iGetStickerListener.onFailed(ErrorCode.PlayStickerCode.b, "file downloader onCancel"); 
          }
          
          public void onFinish() {
            LogUtils.a(StickerDownLoader.a(), "onFinish", new Object[0]);
            StickerDownLoader.b().remove(this.a);
          }
          
          public void onStart() {
            LogUtils.a(StickerDownLoader.a(), "onCancel", new Object[0]);
            StickerDownLoader.b().put(this.a, this.b);
            IGetStickerListener iGetStickerListener = this.c;
            if (iGetStickerListener != null)
              iGetStickerListener.onSyncStart(); 
          }
        }paramIRequestHost);
  }
  
  public static boolean a(String paramString) {
    return b.containsKey(paramString);
  }
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_");
    stringBuilder.append(StickerDownLoader.class.getSimpleName());
    a = stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\sticker\StickerDownLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */