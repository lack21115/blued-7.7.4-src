package com.taobao.tao.remotebusiness.a;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

public final class b implements Serializable {
  public MtopListener a;
  
  public MtopEvent b;
  
  public BaseOutDo c;
  
  public MtopBusiness d;
  
  public MtopResponse e;
  
  public b() {}
  
  public b(MtopListener paramMtopListener, MtopEvent paramMtopEvent, MtopBusiness paramMtopBusiness) {
    this.a = paramMtopListener;
    this.b = paramMtopEvent;
    this.d = paramMtopBusiness;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */