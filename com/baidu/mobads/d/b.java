package com.baidu.mobads.d;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import java.util.Map;

public class b implements IXAdErrorCode {
  protected final IXAdLogger a;
  
  public b(IXAdLogger paramIXAdLogger) {
    this.a = paramIXAdLogger;
  }
  
  public String a(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      stringBuilder.append("ErrorCode: [");
      stringBuilder.append(paramString1);
      stringBuilder.append("];");
    } 
    if (!TextUtils.isEmpty(paramString2)) {
      stringBuilder.append("ErrorDesc: [");
      stringBuilder.append(paramString2);
      stringBuilder.append("];");
    } 
    if (!TextUtils.isEmpty(paramString3)) {
      stringBuilder.append(" Extra: [");
      stringBuilder.append(paramString3);
      stringBuilder.append("];");
    } 
    return stringBuilder.toString();
  }
  
  public String genCompleteErrorMessage(XAdErrorCode paramXAdErrorCode, String paramString) {
    if (paramXAdErrorCode == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXAdErrorCode.getCode());
    stringBuilder.append("");
    return a(stringBuilder.toString(), paramXAdErrorCode.getMessage(), paramString);
  }
  
  public String getMessage(Map<String, Object> paramMap) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 71
    //   4: aload_1
    //   5: ldc 'msg'
    //   7: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   12: ifeq -> 45
    //   15: aload_1
    //   16: ldc 'msg'
    //   18: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/baidu/mobads/interfaces/error/XAdErrorCode
    //   26: astore_1
    //   27: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   30: invokevirtual getErrorCode : ()Lcom/baidu/mobads/interfaces/error/IXAdErrorCode;
    //   33: aload_1
    //   34: ldc ''
    //   36: invokeinterface genCompleteErrorMessage : (Lcom/baidu/mobads/interfaces/error/XAdErrorCode;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_1
    //   42: goto -> 74
    //   45: aload_1
    //   46: ldc 'error_message'
    //   48: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   53: ifeq -> 71
    //   56: aload_1
    //   57: ldc 'error_message'
    //   59: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast java/lang/String
    //   67: astore_1
    //   68: goto -> 74
    //   71: ldc ''
    //   73: astore_1
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: ifnonnull -> 83
    //   80: ldc ''
    //   82: astore_2
    //   83: aload_2
    //   84: areturn
    //   85: astore_1
    //   86: goto -> 71
    // Exception table:
    //   from	to	target	type
    //   4	42	85	java/lang/Exception
    //   45	68	85	java/lang/Exception
  }
  
  public void printErrorMessage(XAdErrorCode paramXAdErrorCode, String paramString) {
    this.a.e(genCompleteErrorMessage(paramXAdErrorCode, paramString));
  }
  
  public void printErrorMessage(String paramString1, String paramString2, String paramString3) {
    this.a.e(a(paramString1, paramString2, paramString3));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */