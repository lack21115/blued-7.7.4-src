package cn.shuzilm.core;

import android.os.IInterface;
import java.util.Map;

public interface IDUService extends IInterface {
  void getOpenAnmsIDAsyn(DUListener paramDUListener);
  
  String getQueryID(String paramString1, String paramString2);
  
  Map getQueryIDAsyn(String paramString1, String paramString2, DUListener paramDUListener);
  
  void go(String paramString1, String paramString2);
  
  Map onEvent(String paramString1, String paramString2, String paramString3);
  
  Map onEventAsyn(String paramString1, String paramString2, String paramString3, DUListener paramDUListener);
  
  void report(String paramString1, String paramString2);
  
  int setConfig(String paramString1, String paramString2);
  
  int setData(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\IDUService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */