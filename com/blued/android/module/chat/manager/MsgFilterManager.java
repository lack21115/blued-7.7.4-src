package com.blued.android.module.chat.manager;

import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.contract.FilterSessionListListener;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.chat.utils.FilterTools;
import com.blued.android.module.chat.utils.PreferencesUtils;
import java.util.List;

public class MsgFilterManager {
  private static MsgFilterManager instance;
  
  private String TAG = "@@@ module_chat_MsgFilterManager";
  
  private boolean filterSwitchOpen = false;
  
  private volatile boolean updateRelationFinishNeedFilter = false;
  
  private MsgFilterManager() {
    if (getInitiatorSwitch() || getFollowerSwitch() || getNearBySwitch()) {
      this.filterSwitchOpen = true;
      return;
    } 
    this.filterSwitchOpen = false;
  }
  
  public static MsgFilterManager getInstance() {
    if (instance == null)
      instance = new MsgFilterManager(); 
    return instance;
  }
  
  @Deprecated
  public void checkFilterStatus() {
    if (this.updateRelationFinishNeedFilter)
      filterData(); 
  }
  
  public void filterData() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   5: new com/blued/android/module/chat/manager/MsgFilterManager$1
    //   8: dup
    //   9: aload_0
    //   10: invokespecial <init> : (Lcom/blued/android/module/chat/manager/MsgFilterManager;)V
    //   13: invokevirtual getSessionModelList : (Lcom/blued/android/chat/listener/FetchDataListener;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
  
  public boolean getFollowerSwitch() {
    return PreferencesUtils.getFollowerSwitch();
  }
  
  public boolean getInitiatorSwitch() {
    return PreferencesUtils.getInitiatorSwitch();
  }
  
  public boolean getNearBySwitch() {
    return PreferencesUtils.getNearbySwitch();
  }
  
  public boolean getOnlineSwitch() {
    return PreferencesUtils.getOnlineSwitch();
  }
  
  public boolean isFilterSwitchOpen() {
    return this.filterSwitchOpen;
  }
  
  public void registerFilterSessionListListener(FilterSessionListListener paramFilterSessionListListener) {
    SessionDataManager.getInstance().registerFilterSessionListListener(paramFilterSessionListListener);
  }
  
  public void setFilterSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    setInitiatorSwitch(paramBoolean1);
    setFollowerSwitch(paramBoolean2);
    setNearBySwitch(paramBoolean3);
    if (paramBoolean1 || paramBoolean2 || paramBoolean3) {
      this.filterSwitchOpen = true;
      return;
    } 
    this.filterSwitchOpen = false;
  }
  
  public void setFilterSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    setInitiatorSwitch(paramBoolean1);
    setFollowerSwitch(paramBoolean2);
    setNearBySwitch(paramBoolean3);
    setOnlineSwitch(paramBoolean4);
    if (paramBoolean1 || paramBoolean2 || paramBoolean3) {
      this.filterSwitchOpen = true;
      return;
    } 
    this.filterSwitchOpen = false;
  }
  
  public void setFollowerSwitch(boolean paramBoolean) {
    PreferencesUtils.setFollowerSwitch(paramBoolean);
    if (getInitiatorSwitch() || paramBoolean || getNearBySwitch()) {
      this.filterSwitchOpen = true;
      return;
    } 
    this.filterSwitchOpen = false;
  }
  
  public void setInitiatorSwitch(boolean paramBoolean) {
    PreferencesUtils.setInitiatorSwitch(paramBoolean);
    if (paramBoolean || getFollowerSwitch() || getNearBySwitch()) {
      this.filterSwitchOpen = true;
      return;
    } 
    this.filterSwitchOpen = false;
  }
  
  public void setNearBySwitch(boolean paramBoolean) {
    PreferencesUtils.setNearbySwitch(paramBoolean);
    if (getInitiatorSwitch() || getFollowerSwitch() || paramBoolean) {
      this.filterSwitchOpen = true;
      return;
    } 
    this.filterSwitchOpen = false;
  }
  
  public void setOnlineSwitch(boolean paramBoolean) {
    PreferencesUtils.setOnlineSwitch(paramBoolean);
  }
  
  public void unRegisterFilterSessionListListener(FilterSessionListListener paramFilterSessionListListener) {
    SessionDataManager.getInstance().unRegisterFilterSessionListListener(paramFilterSessionListListener);
  }
  
  public void unRegisterSessionListener() {
    SessionDataManager.getInstance().unRegisterSessionListener();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\manager\MsgFilterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */