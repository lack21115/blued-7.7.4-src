package com.alibaba.mtl.log.sign;

public interface IRequestAuth {
  String getAppkey();
  
  String getSign(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\sign\IRequestAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */