package com.baidu.mobads.interfaces.error;

import java.util.Map;

public interface IXAdErrorCode {
  String genCompleteErrorMessage(XAdErrorCode paramXAdErrorCode, String paramString);
  
  String getMessage(Map<String, Object> paramMap);
  
  void printErrorMessage(XAdErrorCode paramXAdErrorCode, String paramString);
  
  void printErrorMessage(String paramString1, String paramString2, String paramString3);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\error\IXAdErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */