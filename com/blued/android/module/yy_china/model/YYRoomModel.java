package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class YYRoomModel {
  private int audienceCount = 0;
  
  private Vector<YYAudienceModel> audiences;
  
  public String avatar;
  
  public String chat_type;
  
  public int countdown = 0;
  
  public String create_time;
  
  private String giftBeans = "0";
  
  private List<Long> giftHitIds;
  
  private List<YYImModel> imDatas;
  
  private Set<String> invitedList;
  
  public boolean isUpload = false;
  
  public String is_public;
  
  public List<YYSeatMemberModel> mics;
  
  public String mute = "0";
  
  public String name;
  
  private int next_step = 0;
  
  private ConcurrentHashMap<String, YYImModel> playingEmojiMap;
  
  private int present_step = 0;
  
  public String publish_url;
  
  public String region;
  
  public String relationship;
  
  public String room_desc;
  
  public String room_id;
  
  public String room_member_count;
  
  public String room_member_lock_count;
  
  public String room_member_total;
  
  public String room_name;
  
  public String room_owner;
  
  public String room_type;
  
  private boolean timerFinished = true;
  
  public String type_id;
  
  public String type_img;
  
  public String uid;
  
  public String user_sig;
  
  public String vote_id;
  
  private int waittingCount = 0;
  
  public void addAudienceToList(YYAudienceModel paramYYAudienceModel) {
    if (this.audiences == null)
      this.audiences = new Vector<YYAudienceModel>(); 
    Iterator<YYAudienceModel> iterator = this.audiences.iterator();
    while (iterator.hasNext()) {
      YYAudienceModel yYAudienceModel = iterator.next();
      if (TextUtils.equals(paramYYAudienceModel.getUid(), yYAudienceModel.getUid())) {
        iterator.remove();
        break;
      } 
    } 
    if (this.audiences.size() >= 50) {
      Vector<YYAudienceModel> vector = this.audiences;
      vector.remove(vector.size() - 1);
    } 
    this.audiences.add(0, paramYYAudienceModel);
    YYObserverManager.a().a(this.audiences);
  }
  
  public void addImDatas(YYImModel paramYYImModel) {
    if (this.imDatas == null)
      this.imDatas = new ArrayList<YYImModel>(); 
    this.imDatas.add(paramYYImModel);
    YYObserverManager.a().a(paramYYImModel);
  }
  
  public void addInvited(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (this.invitedList == null)
      this.invitedList = new HashSet<String>(); 
    this.invitedList.add(paramString);
  }
  
  public void addSeatMember(YYSeatMemberModel paramYYSeatMemberModel) {
    if (this.mics == null)
      this.mics = new ArrayList<YYSeatMemberModel>(); 
    for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
      if (StringUtils.a(yYSeatMemberModel.getUid(), 0) <= 0) {
        yYSeatMemberModel.setUid(paramYYSeatMemberModel.getUid());
        yYSeatMemberModel.setName(paramYYSeatMemberModel.getName());
        yYSeatMemberModel.setAvatar(paramYYSeatMemberModel.getAvatar());
        yYSeatMemberModel.position_status = paramYYSeatMemberModel.position_status;
        yYSeatMemberModel.is_open_mic = paramYYSeatMemberModel.is_open_mic;
        yYSeatMemberModel.chat_anchor = paramYYSeatMemberModel.chat_anchor;
        break;
      } 
    } 
  }
  
  public void clearEmojiAndSendMessage() {
    ConcurrentHashMap<String, YYImModel> concurrentHashMap = this.playingEmojiMap;
    if (concurrentHashMap == null)
      return; 
    for (String str : concurrentHashMap.keySet()) {
      YYImModel yYImModel = this.playingEmojiMap.get(str);
      if (yYImModel == null)
        continue; 
      addImDatas(yYImModel);
    } 
    this.playingEmojiMap.clear();
  }
  
  public boolean enableRequestMic() {
    return (this.present_step < 2);
  }
  
  public int getAudienceCount() {
    return this.audienceCount;
  }
  
  public int getCPNextStep() {
    if (this.present_step <= 0)
      this.next_step = 1; 
    return this.next_step;
  }
  
  public int getCPPresentStep() {
    if (this.present_step < 0)
      this.present_step = 0; 
    return this.present_step;
  }
  
  public String getGiftBeans() {
    return this.giftBeans;
  }
  
  public List<YYSeatMemberModel> getHasPeopleMics() {
    ArrayList<YYSeatMemberModel> arrayList = new ArrayList();
    for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
      if (yYSeatMemberModel.position_status == 1)
        arrayList.add(yYSeatMemberModel); 
    } 
    return arrayList;
  }
  
  public List<YYImModel> getImDatas() {
    if (this.imDatas == null)
      this.imDatas = new ArrayList<YYImModel>(); 
    return this.imDatas;
  }
  
  public YYImModel getPlayingEmoji(String paramString) {
    return removePlayingEmoji(paramString);
  }
  
  public YYSeatMemberModel getSeatMember(String paramString) {
    List<YYSeatMemberModel> list = this.mics;
    if (list == null)
      return null; 
    for (YYSeatMemberModel yYSeatMemberModel : list) {
      if (TextUtils.equals(yYSeatMemberModel.getUid(), paramString))
        return yYSeatMemberModel; 
    } 
    return null;
  }
  
  public Set<String> getTalkingUserIds() {
    TreeSet<String> treeSet = new TreeSet();
    for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
      if (yYSeatMemberModel.position_status == 1 && yYSeatMemberModel.is_open_mic == 2)
        treeSet.add(yYSeatMemberModel.getUid()); 
    } 
    return treeSet;
  }
  
  public int getWaittingCount() {
    return this.waittingCount;
  }
  
  public boolean isCPChannel() {
    return TextUtils.equals("1", this.chat_type);
  }
  
  public boolean isExistById(String paramString) {
    List<YYSeatMemberModel> list = this.mics;
    if (list == null)
      return false; 
    Iterator<YYSeatMemberModel> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (TextUtils.equals(((YYSeatMemberModel)iterator.next()).getUid(), paramString))
        return true; 
    } 
    return false;
  }
  
  public boolean isExistEmojiByUid(String paramString) {
    ConcurrentHashMap<String, YYImModel> concurrentHashMap = this.playingEmojiMap;
    return (concurrentHashMap == null) ? false : concurrentHashMap.containsKey(paramString);
  }
  
  public boolean isInvited(String paramString) {
    return (this.invitedList == null || TextUtils.isEmpty(paramString)) ? false : this.invitedList.contains(paramString);
  }
  
  public boolean isTimerFinished() {
    return this.timerFinished;
  }
  
  public void putPlayingEmoji(String paramString, YYImModel paramYYImModel) {
    if (this.playingEmojiMap == null)
      this.playingEmojiMap = new ConcurrentHashMap<String, YYImModel>(); 
    this.playingEmojiMap.put(paramString, paramYYImModel);
  }
  
  public void removeAudienceForList(String paramString) {
    Vector<YYAudienceModel> vector = this.audiences;
    if (vector == null)
      return; 
    Iterator<YYAudienceModel> iterator = vector.iterator();
    while (iterator.hasNext()) {
      if (TextUtils.equals(paramString, ((YYAudienceModel)iterator.next()).getUid())) {
        iterator.remove();
        break;
      } 
    } 
    YYObserverManager.a().a(this.audiences);
  }
  
  public YYImModel removePlayingEmoji(String paramString) {
    ConcurrentHashMap<String, YYImModel> concurrentHashMap = this.playingEmojiMap;
    return (concurrentHashMap == null) ? null : concurrentHashMap.remove(paramString);
  }
  
  public void removeSeatMember(String paramString) {
    List<YYSeatMemberModel> list = this.mics;
    if (list == null)
      return; 
    for (YYSeatMemberModel yYSeatMemberModel : list) {
      if (TextUtils.equals(yYSeatMemberModel.getUid(), paramString)) {
        yYSeatMemberModel.setName("");
        yYSeatMemberModel.setAvatar("");
        yYSeatMemberModel.setUid("0");
        yYSeatMemberModel.position_status = 0;
        yYSeatMemberModel.is_open_mic = 0;
        yYSeatMemberModel.chat_anchor = "0";
        break;
      } 
    } 
    YYObserverManager.a().b(this.mics);
  }
  
  public void setAudienceCount(int paramInt) {
    this.audienceCount = paramInt;
  }
  
  public void setAudiences(List<YYAudienceModel> paramList) {
    List<YYAudienceModel> list = paramList;
    if (paramList == null)
      list = new ArrayList<YYAudienceModel>(); 
    paramList = list;
    if (list.size() > 50)
      paramList = list.subList(0, 50); 
    if (this.audiences == null)
      this.audiences = new Vector<YYAudienceModel>(); 
    this.audiences.clear();
    this.audiences.addAll(paramList);
    YYObserverManager.a().a(this.audiences);
  }
  
  public void setCPNextStep(int paramInt) {
    this.next_step = paramInt;
  }
  
  public void setCPPresentStep(int paramInt) {
    this.present_step = paramInt;
  }
  
  public void setGiftBeans(String paramString) {
    this.giftBeans = paramString;
  }
  
  public void setSeatList(List<YYSeatMemberModel> paramList) {
    if (this.mics == null)
      this.mics = new ArrayList<YYSeatMemberModel>(); 
    List<YYSeatMemberModel> list = paramList;
    if (paramList == null)
      list = new ArrayList<YYSeatMemberModel>(); 
    this.mics.clear();
    this.mics.addAll(list);
    YYObserverManager.a().b(this.mics);
  }
  
  public void setTimerFinished(boolean paramBoolean) {
    this.timerFinished = paramBoolean;
  }
  
  public void setWaittingCount(int paramInt) {
    this.waittingCount = paramInt;
  }
  
  public void updateMicStatus(String paramString, int paramInt) {
    List<YYSeatMemberModel> list = this.mics;
    if (list == null)
      return; 
    for (YYSeatMemberModel yYSeatMemberModel : list) {
      if (TextUtils.equals(yYSeatMemberModel.getUid(), paramString)) {
        yYSeatMemberModel.is_open_mic = paramInt;
        break;
      } 
    } 
    YYObserverManager.a().b(this.mics);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYRoomModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */