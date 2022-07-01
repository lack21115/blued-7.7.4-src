package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;

public class RemoteBusiness extends MtopBusiness {
  private RemoteBusiness(IMTOPDataObject paramIMTOPDataObject, String paramString) {
    super(paramIMTOPDataObject, paramString);
  }
  
  private RemoteBusiness(MtopRequest paramMtopRequest, String paramString) {
    super(paramMtopRequest, paramString);
  }
  
  public static RemoteBusiness build(IMTOPDataObject paramIMTOPDataObject) {
    return new RemoteBusiness(paramIMTOPDataObject, null);
  }
  
  public static RemoteBusiness build(IMTOPDataObject paramIMTOPDataObject, String paramString) {
    return new RemoteBusiness(paramIMTOPDataObject, paramString);
  }
  
  public static RemoteBusiness build(MtopRequest paramMtopRequest) {
    return new RemoteBusiness(paramMtopRequest, null);
  }
  
  public static RemoteBusiness build(MtopRequest paramMtopRequest, String paramString) {
    return new RemoteBusiness(paramMtopRequest, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\RemoteBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */