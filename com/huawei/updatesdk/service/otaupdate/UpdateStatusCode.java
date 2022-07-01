package com.huawei.updatesdk.service.otaupdate;

public interface UpdateStatusCode {
  public static final int CANCEL = 4;
  
  public static final int CHECK_FAILED = 6;
  
  public static final int CONNECT_ERROR = 2;
  
  public static final int HAS_UPGRADE_INFO = 7;
  
  public static final int INSTALL_FAILED = 5;
  
  public static final int IN_MARKET_UPDATING = 9;
  
  public static final int MARKET_FORBID = 8;
  
  public static final int NO_UPGRADE_INFO = 3;
  
  public static final int PARAMER_ERROR = 1;
  
  public static interface DialogButton {
    public static final int CANCEL = 100;
    
    public static final int CONFIRM = 101;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\UpdateStatusCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */