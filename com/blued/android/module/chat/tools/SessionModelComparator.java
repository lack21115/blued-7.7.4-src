package com.blued.android.module.chat.tools;

import com.blued.android.chat.model.SessionModel;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SessionModelComparator implements Comparator<SessionModel> {
  private Map<SessionModel, Long> sessionLastTimeMap = new HashMap<SessionModel, Long>();
  
  public int compare(SessionModel paramSessionModel1, SessionModel paramSessionModel2) {
    long l1;
    long l2;
    Long long_2 = this.sessionLastTimeMap.get(paramSessionModel1);
    if (long_2 == null) {
      l1 = paramSessionModel1.lastMsgTime;
      this.sessionLastTimeMap.put(paramSessionModel1, Long.valueOf(l1));
    } else {
      l1 = long_2.longValue();
    } 
    Long long_1 = this.sessionLastTimeMap.get(paramSessionModel2);
    if (long_1 == null) {
      l2 = paramSessionModel2.lastMsgTime;
      this.sessionLastTimeMap.put(paramSessionModel2, Long.valueOf(l2));
    } else {
      l2 = long_1.longValue();
    } 
    int i = l1 cmp l2;
    return (i > 0) ? -1 : ((i < 0) ? 1 : 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\tools\SessionModelComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */