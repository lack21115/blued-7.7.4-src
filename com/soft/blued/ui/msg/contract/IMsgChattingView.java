package com.soft.blued.ui.msg.contract;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.model.UserInfoBasicModel;
import com.soft.blued.ui.msg.adapter.MessageChatAdapter;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.msg.model.HelloExpressionData;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.util.List;

public interface IMsgChattingView {
  void B();
  
  BaseFragment L();
  
  MessageChatAdapter P();
  
  String T();
  
  IRequestHost U();
  
  Activity V();
  
  void a(int paramInt, String paramString);
  
  void a(int paramInt, String paramString1, String paramString2);
  
  void a(int paramInt, boolean paramBoolean);
  
  void a(SessionModel paramSessionModel);
  
  void a(UserInfoBasicModel paramUserInfoBasicModel);
  
  void a(FuGiftListEvent paramFuGiftListEvent);
  
  void a(GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse);
  
  void a(List<ChattingModel> paramList);
  
  boolean a(Runnable paramRunnable);
  
  boolean a(Runnable paramRunnable, long paramLong);
  
  void b(int paramInt);
  
  void b(List<HelloExpressionData> paramList);
  
  void c(int paramInt);
  
  Bundle getArguments();
  
  Context getContext();
  
  void t();
  
  void v();
  
  void w();
  
  void x();
  
  void z();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\contract\IMsgChattingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */