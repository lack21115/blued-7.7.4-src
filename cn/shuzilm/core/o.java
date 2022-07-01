package cn.shuzilm.core;

import java.util.HashMap;
import java.util.Map;

public class o extends IDUService$Stub {
  public o(DUService paramDUService) {}
  
  public void getOpenAnmsIDAsyn(DUListener paramDUListener) {
    try {
      DUHelper.ZVTFJRAAsyn(DUService.a(this.a), paramDUListener);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public String getQueryID(String paramString1, String paramString2) {
    try {
      return DUHelper.getQueryID(DUService.a(this.a), paramString1, paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public Map getQueryIDAsyn(String paramString1, String paramString2, DUListener paramDUListener) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      return DUHelper.getQueryIDDUCallback(DUService.a(this.a), paramString1, paramString2, 1, paramDUListener);
    } catch (Exception exception) {
      exception.printStackTrace();
      return hashMap;
    } 
  }
  
  public void go(String paramString1, String paramString2) {
    try {
      DUHelper.go(DUService.a(this.a), paramString1, paramString2);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public Map onEvent(String paramString1, String paramString2, String paramString3) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      return DUHelper.onEventDUCallback(DUService.a(this.a), paramString1, paramString2, paramString3, 0, null);
    } catch (Exception exception) {
      exception.printStackTrace();
      return hashMap;
    } 
  }
  
  public Map onEventAsyn(String paramString1, String paramString2, String paramString3, DUListener paramDUListener) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      return DUHelper.onEventDUCallback(DUService.a(this.a), paramString1, paramString2, paramString3, 1, paramDUListener);
    } catch (Exception exception) {
      exception.printStackTrace();
      return hashMap;
    } 
  }
  
  public void report(String paramString1, String paramString2) {
    try {
      DUHelper.report(DUService.a(this.a), paramString1, paramString2);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public int setConfig(String paramString1, String paramString2) {
    try {
      return DUHelper.setConfig(paramString1, paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public int setData(String paramString1, String paramString2) {
    try {
      return DUHelper.setData(paramString1, paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */