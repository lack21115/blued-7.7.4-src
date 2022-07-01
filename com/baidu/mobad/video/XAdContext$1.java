package com.baidu.mobad.video;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXLinearAdSlot;

class XAdContext$1 implements Runnable {
  XAdContext$1(XAdContext paramXAdContext) {}
  
  public void run() {
    IXLinearAdSlot iXLinearAdSlot = XAdContext.a(this.a).retrievePrerollAdSlot();
    if (iXLinearAdSlot != null && iXLinearAdSlot.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING)
      iXLinearAdSlot.resize(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\video\XAdContext$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */