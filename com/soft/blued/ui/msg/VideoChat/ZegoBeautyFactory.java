package com.soft.blued.ui.msg.VideoChat;

import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory;

public class ZegoBeautyFactory extends ZegoVideoFilterFactory {
  public ZegoVideoFilter a = null;
  
  public ZegoVideoFilter create() {
    this.a = new ZegoBeautyFilter();
    return this.a;
  }
  
  public void destroy(ZegoVideoFilter paramZegoVideoFilter) {
    this.a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\VideoChat\ZegoBeautyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */