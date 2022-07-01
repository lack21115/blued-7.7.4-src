package com.baidu.mobads.openad.interfaces.download;

import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import java.net.URL;
import java.util.ArrayList;

public interface IOAdDownloaderManager {
  IOAdDownloader createAdsApkDownloader(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  IXAdStaticImgDownloader createImgHttpDownloader(URL paramURL, String paramString1, String paramString2);
  
  IOAdDownloader createSimpleFileDownloader(URL paramURL, String paramString1, String paramString2, boolean paramBoolean);
  
  IOAdDownloader getAdsApkDownloader(String paramString);
  
  ArrayList<IOAdDownloader> getAllAdsApkDownloaderes();
  
  Boolean removeAdsApkDownloader(String paramString);
  
  void removeAllAdsApkDownloaderes();
  
  void resumeUndownloadedAfterRestartApp(long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\interfaces\download\IOAdDownloaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */