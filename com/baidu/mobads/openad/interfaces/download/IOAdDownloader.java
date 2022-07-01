package com.baidu.mobads.openad.interfaces.download;

import java.util.Observer;

public interface IOAdDownloader {
  void addObserver(Observer paramObserver);
  
  void cancel();
  
  int getFileSize();
  
  String getOutputPath();
  
  String getPackageName();
  
  float getProgress();
  
  DownloadStatus getState();
  
  String getTargetURL();
  
  String getTitle();
  
  String getURL();
  
  boolean isPausedManually();
  
  void pause();
  
  void removeObservers();
  
  void resume();
  
  void setPausedManually(boolean paramBoolean);
  
  void start();
  
  public enum DownloadStatus {
    CANCELLED,
    COMPLETED,
    COMPLETE_BUT_FILE_REMOVED,
    DOWNLOADING,
    ERROR,
    INITING,
    NONE(-1, "未开始"),
    PAUSED(-1, "未开始");
    
    private int a;
    
    private String b;
    
    static {
      DOWNLOADING = new DownloadStatus("DOWNLOADING", 2, 1, "正在下载");
      CANCELLED = new DownloadStatus("CANCELLED", 3, 2, "已取消下载");
      COMPLETED = new DownloadStatus("COMPLETED", 4, 3, "下载完成");
      ERROR = new DownloadStatus("ERROR", 5, 4, "下载失败");
      COMPLETE_BUT_FILE_REMOVED = new DownloadStatus("COMPLETE_BUT_FILE_REMOVED", 6, 5, "下载完但文件异常");
      PAUSED = new DownloadStatus("PAUSED", 7, 6, "已暂停下载");
      c = new DownloadStatus[] { NONE, INITING, DOWNLOADING, CANCELLED, COMPLETED, ERROR, COMPLETE_BUT_FILE_REMOVED, PAUSED };
    }
    
    DownloadStatus(int param1Int1, String param1String1) {
      this.a = param1Int1;
      this.b = param1String1;
    }
    
    public int getCode() {
      return this.a;
    }
    
    public String getMessage() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\interfaces\download\IOAdDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */