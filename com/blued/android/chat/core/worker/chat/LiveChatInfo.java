package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.data.ProfileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiveChatInfo {
  public long sessionId;
  
  public short sessionType;
  
  public long viewerOnLineCount;
  
  public List<ProfileData> viewerProfileList;
  
  public long viewerTotalCount;
  
  public LiveChatInfo(LiveChatInfo paramLiveChatInfo) {
    this.sessionType = paramLiveChatInfo.sessionType;
    this.sessionId = paramLiveChatInfo.sessionId;
    this.viewerOnLineCount = paramLiveChatInfo.viewerOnLineCount;
    this.viewerTotalCount = paramLiveChatInfo.viewerTotalCount;
    if (paramLiveChatInfo.viewerProfileList != null) {
      this.viewerProfileList = new ArrayList<ProfileData>();
      this.viewerProfileList.addAll(paramLiveChatInfo.viewerProfileList);
    } 
  }
  
  public LiveChatInfo(short paramShort, long paramLong) {
    this.sessionType = paramShort;
    this.sessionId = paramLong;
  }
  
  private void checkProfileListSize() {
    for (int i = this.viewerProfileList.size() - 50; i > 0; i--) {
      List<ProfileData> list = this.viewerProfileList;
      list.remove(list.size() - 1);
    } 
  }
  
  public void addProfileData(ProfileData paramProfileData) {
    List<ProfileData> list = this.viewerProfileList;
    if (list == null) {
      this.viewerProfileList = new ArrayList<ProfileData>();
    } else {
      Iterator<ProfileData> iterator = list.iterator();
      while (iterator.hasNext()) {
        if (((ProfileData)iterator.next()).uid == paramProfileData.uid) {
          iterator.remove();
          break;
        } 
      } 
    } 
    this.viewerProfileList.add(0, paramProfileData);
    checkProfileListSize();
  }
  
  public boolean equalSession(short paramShort, long paramLong) {
    return (this.sessionType == paramShort && this.sessionId == paramLong);
  }
  
  public List<ProfileData> getViewerList() {
    if (this.viewerProfileList != null) {
      ArrayList<ProfileData> arrayList = new ArrayList();
      arrayList.addAll(this.viewerProfileList);
      return arrayList;
    } 
    return null;
  }
  
  public boolean removeProfileData(long paramLong) {
    List<ProfileData> list = this.viewerProfileList;
    if (list != null) {
      Iterator<ProfileData> iterator = list.iterator();
      while (iterator.hasNext()) {
        if (((ProfileData)iterator.next()).uid == paramLong) {
          iterator.remove();
          return true;
        } 
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\LiveChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */