package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopListener;

abstract class b {
  protected MtopListener listener = null;
  
  protected MtopBusiness mtopBusiness = null;
  
  protected b(MtopBusiness paramMtopBusiness, MtopListener paramMtopListener) {
    this.mtopBusiness = paramMtopBusiness;
    this.listener = paramMtopListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\listener\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */