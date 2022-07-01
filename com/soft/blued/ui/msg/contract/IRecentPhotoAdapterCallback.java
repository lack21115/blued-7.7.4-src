package com.soft.blued.ui.msg.contract;

import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import java.util.List;

public interface IRecentPhotoAdapterCallback {
  List<MsgRecentPhotoInfo> Q();
  
  void R();
  
  void S();
  
  void a(IGetPhotoListCallback paramIGetPhotoListCallback);
  
  void a(MsgRecentPhotoInfo paramMsgRecentPhotoInfo);
  
  void b(IGetPhotoListCallback paramIGetPhotoListCallback);
  
  void b(MsgRecentPhotoInfo paramMsgRecentPhotoInfo);
  
  public static interface IGetPhotoListCallback {
    void a(List<MsgRecentPhotoInfo> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\contract\IRecentPhotoAdapterCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */