package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

public interface IRemoteBaseListener extends MtopListener {
  void onError(int paramInt, MtopResponse paramMtopResponse, Object paramObject);
  
  void onSuccess(int paramInt, MtopResponse paramMtopResponse, BaseOutDo paramBaseOutDo, Object paramObject);
  
  void onSystemError(int paramInt, MtopResponse paramMtopResponse, Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\IRemoteBaseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */