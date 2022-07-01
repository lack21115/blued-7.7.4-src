package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;

public interface IRemoteProcessListener extends MtopListener {
  void onDataReceived(MtopProgressEvent paramMtopProgressEvent, Object paramObject);
  
  void onHeader(MtopHeaderEvent paramMtopHeaderEvent, Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\IRemoteProcessListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */