package com.soft.blued.ui.msg.controller.tools;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.SessionModel;
import com.soft.blued.utils.Logger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SessionModelComparator implements Comparator<SessionModel> {
  public static final String a = SessionModelComparator.class.getSimpleName();
  
  private Map<SessionModel, Long> b = new HashMap<SessionModel, Long>();
  
  public int a(SessionModel paramSessionModel1, SessionModel paramSessionModel2) {
    long l1;
    long l2;
    if (paramSessionModel1.lieTop == 1 && paramSessionModel2.lieTop == 0)
      return -1; 
    if (paramSessionModel1.lieTop == 0 && paramSessionModel2.lieTop == 1)
      return 1; 
    if (paramSessionModel1.expireTime != 0L) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("arg0=");
      stringBuilder.append(paramSessionModel1.lastMsgFromNickname);
      stringBuilder.append("===");
      stringBuilder.append(System.currentTimeMillis() - paramSessionModel1.expireTime);
      Logger.e(str, new Object[] { stringBuilder.toString() });
    } 
    if (paramSessionModel2.expireTime != 0L) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("arg1=");
      stringBuilder.append(paramSessionModel2.lastMsgFromNickname);
      stringBuilder.append("===");
      stringBuilder.append(System.currentTimeMillis() - paramSessionModel2.expireTime);
      Logger.e(str, new Object[] { stringBuilder.toString() });
    } 
    if (paramSessionModel1.expireTime != 0L && paramSessionModel1.expireTime < System.currentTimeMillis()) {
      paramSessionModel1.expireTime = 0L;
      paramSessionModel1.totalMoney = 0.0F;
      ChatManager.getInstance().updateSessionTopGift(paramSessionModel1.sessionType, paramSessionModel1.sessionId, 0L, 0.0F);
    } 
    if (paramSessionModel2.expireTime != 0L && paramSessionModel2.expireTime < System.currentTimeMillis()) {
      paramSessionModel2.expireTime = 0L;
      paramSessionModel2.totalMoney = 0.0F;
      ChatManager.getInstance().updateSessionTopGift(paramSessionModel2.sessionType, paramSessionModel2.sessionId, 0L, 0.0F);
    } 
    if (paramSessionModel1.expireTime != 0L && paramSessionModel2.expireTime == 0L)
      return -1; 
    if (paramSessionModel1.expireTime == 0L && paramSessionModel2.expireTime != 0L)
      return 1; 
    if (paramSessionModel1.expireTime != 0L && paramSessionModel2.expireTime != 0L) {
      if (paramSessionModel1.totalMoney > paramSessionModel2.totalMoney)
        return -1; 
      if (paramSessionModel1.totalMoney < paramSessionModel2.totalMoney)
        return 1; 
    } 
    Long long_2 = this.b.get(paramSessionModel1);
    if (long_2 == null) {
      l1 = paramSessionModel1.lastMsgTime;
      this.b.put(paramSessionModel1, Long.valueOf(l1));
    } else {
      l1 = long_2.longValue();
    } 
    Long long_1 = this.b.get(paramSessionModel2);
    if (long_1 == null) {
      l2 = paramSessionModel2.lastMsgTime;
      this.b.put(paramSessionModel2, Long.valueOf(l2));
    } else {
      l2 = long_1.longValue();
    } 
    int i = l1 cmp l2;
    return (i > 0) ? -1 : ((i < 0) ? 1 : 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\controller\tools\SessionModelComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */