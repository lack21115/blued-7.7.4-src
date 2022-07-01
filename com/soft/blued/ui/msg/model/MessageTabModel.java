package com.soft.blued.ui.msg.model;

import android.content.Context;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.ui.msg.MsgFragment;
import com.soft.blued.ui.notify.fragment.SystemNoticeFragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class MessageTabModel {
  private static List<MessageTabModel> tabs;
  
  public int tabid;
  
  public String title;
  
  public MessageTabModel(int paramInt, Context paramContext) {
    this.tabid = paramInt;
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      this.title = paramContext.getResources().getString(2131755442);
      return;
    } 
    this.title = paramContext.getResources().getString(2131758054);
  }
  
  public static void clearTabs() {
    tabs = null;
  }
  
  public static List<MessageTabModel> getMessageTabs(Context paramContext) {
    List<MessageTabModel> list = tabs;
    if (list != null && list.size() > 0)
      return tabs; 
    tabs = new ArrayList<MessageTabModel>();
    tabs.add(new MessageTabModel(0, paramContext));
    tabs.add(new MessageTabModel(1, paramContext));
    return tabs;
  }
  
  public static int getTabPosition(int paramInt) {
    if (tabs != null)
      for (int i = 0; i < tabs.size(); i++) {
        if (((MessageTabModel)tabs.get(i)).tabid == paramInt)
          return i; 
      }  
    return -1;
  }
  
  public BaseFragment getFragment() {
    int i = this.tabid;
    return (BaseFragment)((i != 0) ? ((i != 1) ? new SystemNoticeFragment() : new MsgFragment()) : new SystemNoticeFragment());
  }
  
  public static interface MESSAGE_TAB_ID {
    public static final int CHAT = 1;
    
    public static final int NOTICE = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MessageTabDef {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MessageTabModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */