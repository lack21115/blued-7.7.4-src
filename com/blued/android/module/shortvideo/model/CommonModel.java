package com.blued.android.module.shortvideo.model;

import android.text.TextUtils;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import java.io.Serializable;
import java.util.List;

public class CommonModel extends IModel implements Serializable {
  public static final int FLING_MIN_DISTANCE = 80;
  
  public static final int SHOW_V_DEFAULT = 0;
  
  public static final int SHOW_V_FILTER = 2;
  
  private static final String Tag = CommonModel.class.getSimpleName();
  
  private long MAX_RECORD_DURATION = 15000L;
  
  private long MAX_VIDEO_DURATION = 60000L;
  
  private long MIN_RECORD_DURATION = 3000L;
  
  private long MIN_VIDEO_DURATION = 3000L;
  
  private int SHOW_V_TYPE = 0;
  
  protected boolean canDeleteVideoFile = true;
  
  protected int currentPage = 0;
  
  protected int from = 0;
  
  protected boolean isAddAblum = false;
  
  protected boolean isAddMusic = false;
  
  protected boolean isPrivilegeUser = false;
  
  protected List<FilterItem> mFilters;
  
  protected boolean mHasBgMusic = false;
  
  protected int mSelectFilterPosition = 0;
  
  protected FilterItem mSelectedFilter;
  
  protected String musicId;
  
  protected String musicName;
  
  protected String musicPath;
  
  protected int nextPage = 0;
  
  public boolean openBeauty = false;
  
  protected String originalVideoPath;
  
  protected int prePage = 0;
  
  protected boolean useData = false;
  
  protected String videoPath;
  
  private void setMusicId(String paramString) {
    this.musicId = paramString;
  }
  
  public void clear() {
    this.MAX_RECORD_DURATION = 15000L;
    this.MIN_RECORD_DURATION = 3000L;
    this.SHOW_V_TYPE = 0;
    this.prePage = 0;
    List<FilterItem> list = this.mFilters;
    if (list != null)
      list.clear(); 
    this.mSelectedFilter = null;
    this.mSelectFilterPosition = 0;
    this.mHasBgMusic = false;
    this.isAddMusic = false;
    this.isPrivilegeUser = false;
    this.videoPath = null;
    this.musicPath = null;
    this.musicId = null;
    this.useData = false;
    this.openBeauty = false;
    this.canDeleteVideoFile = true;
  }
  
  public void copyModel(CommonModel paramCommonModel) {
    copyModel(paramCommonModel, false);
  }
  
  public void copyModel(CommonModel paramCommonModel, boolean paramBoolean) {
    setFrom(paramCommonModel.getFrom());
    if (paramBoolean) {
      setPrePageType(paramCommonModel.getCurrentPage());
    } else {
      setPrePageType(paramCommonModel.getPrePageType());
      setCurrentPage(paramCommonModel.getCurrentPage());
    } 
    setOpenBeauty(paramCommonModel.isOpenBeauty());
    setVideoPath(paramCommonModel.getVideoPath());
    setMusicPath(paramCommonModel.getMusicPath());
    setMusicName(paramCommonModel.getMusicName());
    setSelectedFilter(paramCommonModel.getSelectedFilter());
    setSelectFilterPosition(paramCommonModel.getSelectFilterPosition());
    setMaxRecordDuration(paramCommonModel.getMaxRecordDuration());
    setMinRecordDuration(paramCommonModel.getMinRecordDuration());
    setMaxVideoDuration(paramCommonModel.getMaxVideoDuration());
    setMinVideoDuration(paramCommonModel.getMinVideoDuration());
    setPrivilegeUser(paramCommonModel.isPrivilegeUser());
    setCanDeleteVideoFile(paramCommonModel.isCanDeleteVideoFile());
    this.mHasBgMusic = paramCommonModel.mHasBgMusic;
    this.originalVideoPath = paramCommonModel.originalVideoPath;
    this.isAddAblum = paramCommonModel.isAddAblum;
  }
  
  public int getCurrentPage() {
    return this.currentPage;
  }
  
  public List<FilterItem> getFilters() {
    return this.mFilters;
  }
  
  public int getFrom() {
    return this.from;
  }
  
  public long getMaxRecordDuration() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield MAX_RECORD_DURATION : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public long getMaxVideoDuration() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield MAX_VIDEO_DURATION : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public long getMinRecordDuration() {
    return this.MIN_RECORD_DURATION;
  }
  
  public float getMinRecordDurationPre() {
    return (float)getMinRecordDuration() * 1.0F / (float)getMaxRecordDuration();
  }
  
  public long getMinVideoDuration() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield MIN_VIDEO_DURATION : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public String getMusicId() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Tag);
    stringBuilder.append(" 获取音乐Id:");
    stringBuilder.append(this.musicId);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    return this.musicId;
  }
  
  public String getMusicName() {
    return this.musicName;
  }
  
  public String getMusicPath() {
    return this.musicPath;
  }
  
  public int getNextPage() {
    return this.nextPage;
  }
  
  public String getOriginalVideoPath() {
    return this.originalVideoPath;
  }
  
  public int getPrePageType() {
    return this.prePage;
  }
  
  public int getSelectFilterPosition() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mSelectFilterPosition : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public FilterItem getSelectedFilter() {
    return this.mSelectedFilter;
  }
  
  public int getShowVType() {
    return this.SHOW_V_TYPE;
  }
  
  public void getVideoFrame(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, IGetFrameCallback paramIGetFrameCallback) {
    VideoFrameModel.getInstance().getVideoFrame(getVideoPath(), paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramIGetFrameCallback);
  }
  
  public String getVideoPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Tag);
    stringBuilder.append(" getVideoPath: ");
    stringBuilder.append(this.videoPath);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    return this.videoPath;
  }
  
  public boolean isAddAblum() {
    return this.isAddAblum;
  }
  
  public boolean isAddMusic() {
    return this.isAddMusic;
  }
  
  public boolean isCanDeleteVideoFile() {
    return this.canDeleteVideoFile;
  }
  
  public boolean isHasBgMusic() {
    return this.mHasBgMusic;
  }
  
  public boolean isOpenBeauty() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield openBeauty : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean isPrivilegeUser() {
    return this.isPrivilegeUser;
  }
  
  public boolean isUseData() {
    return this.useData;
  }
  
  public void setAddAblum(boolean paramBoolean) {
    this.isAddAblum = paramBoolean;
  }
  
  public void setAddMusic(boolean paramBoolean) {
    this.isAddMusic = paramBoolean;
  }
  
  public void setCanDeleteVideoFile(boolean paramBoolean) {
    this.canDeleteVideoFile = paramBoolean;
  }
  
  public void setCurrentPage(int paramInt) {
    this.currentPage = paramInt;
  }
  
  public void setFilters(List<FilterItem> paramList) {
    this.mFilters = paramList;
  }
  
  public void setFrom(int paramInt) {
    this.from = paramInt;
  }
  
  public void setHasBgMusic(boolean paramBoolean) {
    this.mHasBgMusic = paramBoolean;
  }
  
  public void setMaxRecordDuration(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: putfield MAX_RECORD_DURATION : J
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_3
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_3
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void setMaxVideoDuration(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: putfield MAX_VIDEO_DURATION : J
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_3
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_3
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void setMinRecordDuration(long paramLong) {
    this.MIN_RECORD_DURATION = paramLong;
  }
  
  public void setMinVideoDuration(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: putfield MIN_VIDEO_DURATION : J
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_3
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_3
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void setMusicName(String paramString) {
    this.musicName = paramString;
  }
  
  public void setMusicPath(String paramString) {
    this.musicPath = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      setAddMusic(true);
      if (paramString.contains(".mp3")) {
        paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf(".mp3"));
      } else {
        paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Tag);
      stringBuilder.append(" 使用的音乐Id:");
      stringBuilder.append(paramString);
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      setMusicId(paramString);
      return;
    } 
    setMusicId("");
    setAddMusic(false);
  }
  
  public void setNextPage(int paramInt) {
    this.nextPage = paramInt;
  }
  
  public void setOpenBeauty(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield openBeauty : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void setOriginalVideoPath(String paramString) {
    this.originalVideoPath = paramString;
  }
  
  public void setPrePageType(int paramInt) {
    this.prePage = paramInt;
  }
  
  public void setPrivilegeUser(boolean paramBoolean) {
    this.isPrivilegeUser = paramBoolean;
  }
  
  public void setSelectFilterPosition(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield mSelectFilterPosition : I
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void setSelectedFilter(FilterItem paramFilterItem) {
    this.mSelectedFilter = paramFilterItem;
  }
  
  public void setShowVType(int paramInt) {
    this.SHOW_V_TYPE = paramInt;
  }
  
  public void setUseData(Boolean paramBoolean) {
    this.useData = paramBoolean.booleanValue();
  }
  
  public void setVideoPath(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Tag);
    stringBuilder.append(" setVideoPath: ");
    stringBuilder.append(paramString);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    this.videoPath = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\CommonModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */