package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;

public interface IRemoteParserListener extends MtopListener {
  void parseResponse(MtopResponse paramMtopResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\IRemoteParserListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */