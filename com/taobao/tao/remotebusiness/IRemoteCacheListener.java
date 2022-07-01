package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;

public interface IRemoteCacheListener extends MtopListener {
  void onCached(MtopCacheEvent paramMtopCacheEvent, BaseOutDo paramBaseOutDo, Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\IRemoteCacheListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */