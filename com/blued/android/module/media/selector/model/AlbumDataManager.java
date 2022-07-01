package com.blued.android.module.media.selector.model;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlbumDataManager implements Serializable {
  private static volatile String mCurrentFolderName;
  
  private static volatile List<MediaInfo> mCurrentList;
  
  private static volatile MutableLiveData<Boolean> mCurrentListChangeLiveData;
  
  private static int mCurrentPosition;
  
  private static List<GroupImageInfo> mGroupFileList;
  
  private static volatile LinkedHashMap<String, List<MediaInfo>> mGroupMap = new LinkedHashMap<String, List<MediaInfo>>();
  
  private static int mMaxSelectNum;
  
  private static AlbumSelectInfo mSelectInfo;
  
  static {
    mGroupFileList = new ArrayList<GroupImageInfo>();
    mCurrentList = new ArrayList<MediaInfo>();
    mCurrentListChangeLiveData = new MutableLiveData();
    mSelectInfo = new AlbumSelectInfo();
    mCurrentPosition = 0;
    mMaxSelectNum = 9;
  }
  
  public static int addSelectImage(MediaInfo paramMediaInfo, int paramInt) {
    AlbumSelectInfo albumSelectInfo = mSelectInfo;
    return (albumSelectInfo != null) ? albumSelectInfo.b(paramMediaInfo) : 0;
  }
  
  public static void addSelectImageList(List<MediaInfo> paramList) {
    AlbumSelectInfo albumSelectInfo = mSelectInfo;
    if (albumSelectInfo != null)
      albumSelectInfo.a(paramList); 
  }
  
  public static void clear() {
    clearSelectImageList();
    clearGroupMap();
    clearGroupList();
    clearCurrentList();
  }
  
  public static void clearAlbumSelectData() {
    mSelectInfo.a();
  }
  
  public static void clearCurrentList() {
    if (mCurrentList != null) {
      mCurrentList.clear();
      mCurrentListChangeLiveData.postValue(Boolean.valueOf(true));
    } 
  }
  
  public static void clearGroupList() {
    List<GroupImageInfo> list = mGroupFileList;
    if (list != null)
      list.clear(); 
  }
  
  public static void clearGroupMap() {
    if (mGroupMap != null)
      mGroupMap.clear(); 
  }
  
  public static void clearSelectImageList() {
    AlbumSelectInfo albumSelectInfo = mSelectInfo;
    if (albumSelectInfo != null)
      albumSelectInfo.b(); 
  }
  
  public static void copySelectInfo(AlbumSelectInfo paramAlbumSelectInfo) {
    mSelectInfo.a(paramAlbumSelectInfo);
  }
  
  public static AlbumSelectInfo getAlbumSelectInfo() {
    return mSelectInfo;
  }
  
  public static MediaInfo getCurrentChildImageInfo() {
    return getVRChildImageInfo(getCurrentPosition());
  }
  
  public static String getCurrentFolderName() {
    return mCurrentFolderName;
  }
  
  public static List<MediaInfo> getCurrentList() {
    return mCurrentList;
  }
  
  public static LiveData<Boolean> getCurrentListChangeLiveData() {
    return (LiveData<Boolean>)mCurrentListChangeLiveData;
  }
  
  public static int getCurrentListSize() {
    return (mCurrentList != null) ? mCurrentList.size() : 0;
  }
  
  public static int getCurrentPosition() {
    return mCurrentPosition;
  }
  
  public static List<MediaInfo> getGroupFileList(String paramString) {
    ArrayList<MediaInfo> arrayList = new ArrayList();
    if (mGroupMap != null && mGroupMap.containsKey(paramString))
      arrayList.addAll(mGroupMap.get(paramString)); 
    return arrayList;
  }
  
  public static GroupImageInfo getGroupListFileInfo(int paramInt) {
    List<GroupImageInfo> list = mGroupFileList;
    return (list != null && list.size() > paramInt) ? mGroupFileList.get(paramInt) : null;
  }
  
  public static int getGroupListSize() {
    List<GroupImageInfo> list = mGroupFileList;
    return (list != null) ? list.size() : 0;
  }
  
  public static int getMaxSelectNum() {
    return mMaxSelectNum;
  }
  
  public static int getMediaTypeImage() {
    return 1;
  }
  
  public static int getMediaTypeVideo() {
    return 3;
  }
  
  public static List<MediaInfo> getSelectImageList() {
    return mSelectInfo.c();
  }
  
  public static int getSelectImageSize() {
    AlbumSelectInfo albumSelectInfo = mSelectInfo;
    return (albumSelectInfo != null) ? albumSelectInfo.d() : 0;
  }
  
  public static MediaInfo getVRChildImageInfo(int paramInt) {
    return (getCurrentListSize() > paramInt) ? mCurrentList.get(paramInt) : null;
  }
  
  public static void putGroupMap(String paramString1, String paramString2, MediaInfo paramMediaInfo) {
    if (!mGroupMap.containsKey(paramString2)) {
      ArrayList<MediaInfo> arrayList = new ArrayList();
      arrayList.add(paramMediaInfo);
      mGroupMap.put(paramString2, arrayList);
    } else {
      ((List<MediaInfo>)mGroupMap.get(paramString2)).add(paramMediaInfo);
    } 
    if (mGroupMap.get(paramString1) == null)
      mGroupMap.put(paramString1, new LinkedList<MediaInfo>()); 
    ((List<MediaInfo>)mGroupMap.get(paramString1)).add(paramMediaInfo);
  }
  
  public static void removeAll() {
    clearGroupMap();
    clearGroupList();
    clearCurrentList();
  }
  
  public static int removeFromPath(String paramString) {
    AlbumSelectInfo albumSelectInfo = mSelectInfo;
    return (albumSelectInfo != null) ? albumSelectInfo.a(paramString) : 0;
  }
  
  public static int removeSelectImage(MediaInfo paramMediaInfo) {
    return removeFromPath(paramMediaInfo.imagePath);
  }
  
  public static void setAlbumSelectInfo(AlbumSelectInfo paramAlbumSelectInfo) {
    mSelectInfo.a(paramAlbumSelectInfo);
  }
  
  public static void setCurrentList(String paramString, List<MediaInfo> paramList) {
    mCurrentFolderName = paramString;
    mCurrentList.clear();
    mCurrentList.addAll(paramList);
    mCurrentListChangeLiveData.postValue(Boolean.valueOf(true));
  }
  
  public static int setCurrentPosition(int paramInt) {
    mCurrentPosition = paramInt;
    return paramInt;
  }
  
  public static void setMaxSelectNum(int paramInt) {
    mMaxSelectNum = paramInt;
  }
  
  public static void setSelectMediaType(int paramInt) {
    AlbumSelectInfo albumSelectInfo = mSelectInfo;
    if (albumSelectInfo != null)
      albumSelectInfo.a(paramInt); 
  }
  
  public static void subGroupOfImage() {
    if (mGroupMap.size() == 0)
      return; 
    clearGroupList();
    for (Map.Entry<String, List<MediaInfo>> entry : mGroupMap.entrySet()) {
      GroupImageInfo groupImageInfo = new GroupImageInfo();
      String str = (String)entry.getKey();
      List<?> list = (List)entry.getValue();
      Collections.reverse(list);
      groupImageInfo.setFolderName(str);
      groupImageInfo.setImageCounts(list.size());
      if (list.size() > 0) {
        MediaInfo mediaInfo = (MediaInfo)list.get(0);
        if (mediaInfo != null) {
          groupImageInfo.setMediaType(mediaInfo.media_type);
          if (mediaInfo.media_type == getMediaTypeVideo()) {
            groupImageInfo.setChildImageInfo(mediaInfo);
          } else if (!TextUtils.isEmpty(mediaInfo.imgUri)) {
            groupImageInfo.topImageUri = mediaInfo.imgUri;
          } else {
            groupImageInfo.setTopImagePath(mediaInfo.imagePath);
          } 
        } 
      } 
      mGroupFileList.add(groupImageInfo);
    } 
  }
  
  public static void updateGroupFileList(String paramString, List<MediaInfo> paramList) {
    // Byte code:
    //   0: ldc com/blued/android/module/media/selector/model/AlbumDataManager
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/media/selector/model/AlbumDataManager.mGroupMap : Ljava/util/LinkedHashMap;
    //   6: ifnull -> 41
    //   9: getstatic com/blued/android/module/media/selector/model/AlbumDataManager.mGroupMap : Ljava/util/LinkedHashMap;
    //   12: aload_0
    //   13: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   16: ifeq -> 41
    //   19: aload_1
    //   20: ifnull -> 41
    //   23: aload_1
    //   24: invokeinterface size : ()I
    //   29: ifle -> 41
    //   32: getstatic com/blued/android/module/media/selector/model/AlbumDataManager.mGroupMap : Ljava/util/LinkedHashMap;
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: ldc com/blued/android/module/media/selector/model/AlbumDataManager
    //   43: monitorexit
    //   44: return
    //   45: astore_0
    //   46: ldc com/blued/android/module/media/selector/model/AlbumDataManager
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	45	finally
    //   23	41	45	finally
  }
  
  public int getSelectMediaType() {
    AlbumSelectInfo albumSelectInfo = mSelectInfo;
    return (albumSelectInfo != null) ? albumSelectInfo.e() : 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\model\AlbumDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */