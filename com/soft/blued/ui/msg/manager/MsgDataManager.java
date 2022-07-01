package com.soft.blued.ui.msg.manager;

import com.blued.android.chat.model.SessionModel;
import com.soft.blued.BluedConstant;
import com.soft.blued.db.model.SessionSettingModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgDataManager {
  private List<SessionModel> a = new ArrayList<SessionModel>();
  
  private List<SessionModel> b = new ArrayList<SessionModel>();
  
  private List<SessionModel> c = new ArrayList<SessionModel>();
  
  private List<SessionModel> d = new ArrayList<SessionModel>();
  
  public List<SessionModel> a() {
    return this.b;
  }
  
  public void a(SessionModel paramSessionModel) {
    List<SessionModel> list = this.d;
    if (list != null && !list.contains(paramSessionModel))
      this.d.add(paramSessionModel); 
  }
  
  public void a(List<SessionModel> paramList) {
    this.c.clear();
    if (paramList != null)
      this.c.addAll(paramList); 
  }
  
  public List<SessionModel> b() {
    return this.d;
  }
  
  public void b(List<SessionModel> paramList) {
    this.b.clear();
    if (paramList != null)
      this.b.addAll(paramList); 
  }
  
  public void c() {
    this.d.clear();
  }
  
  public void c(List<SessionModel> paramList) {
    this.a.clear();
    if (paramList != null)
      this.a.addAll(paramList); 
  }
  
  public int d(List<SessionModel> paramList) {
    int k = paramList.size();
    int j = 0;
    int i = 0;
    if (k > 0) {
      Iterator<SessionModel> iterator = paramList.iterator();
      while (true) {
        j = i;
        if (iterator.hasNext()) {
          SessionModel sessionModel = iterator.next();
          SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
          if (sessionSettingModel == null || sessionSettingModel.getRemindAudio() == 0) {
            if (BluedConstant.a) {
              if (sessionModel.sessionType != 3) {
                if (sessionModel.sessionType == 1) {
                  if (sessionModel.sessionId != 2L) {
                    j = sessionModel.noReadMsgCount;
                  } else {
                    continue;
                  } 
                } else {
                  j = sessionModel.noReadMsgCount;
                } 
              } else {
                continue;
              } 
            } else {
              j = sessionModel.noReadMsgCount;
            } 
            i += j;
          } 
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  public List<SessionModel> d() {
    return this.a;
  }
  
  public List<SessionModel> e() {
    synchronized (this.c) {
      return this.c;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\MsgDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */