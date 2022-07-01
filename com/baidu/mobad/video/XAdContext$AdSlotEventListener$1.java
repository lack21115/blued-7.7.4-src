package com.baidu.mobad.video;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

class XAdContext$AdSlotEventListener$1 implements Runnable {
  XAdContext$AdSlotEventListener$1(XAdContext.AdSlotEventListener paramAdSlotEventListener, IOAdEvent paramIOAdEvent) {}
  
  public void run() {
    if (this.a.getType().equals("complete"))
      XAdContext.AdSlotEventListener.b(this.b).dispatchEvent((IOAdEvent)new XAdEvent4PDK("EVENT_REQUEST_COMPLETE", XAdContext.AdSlotEventListener.a(this.b))); 
    if (this.a.getType().equals("AdStarted")) {
      if (XAdContext.AdSlotEventListener.a(this.b).getProdBase() != null)
        XAdContext.AdSlotEventListener.a(this.b).getProdBase().setVisibility(0); 
      XAdContext.AdSlotEventListener.b(this.b).dispatchEvent((IOAdEvent)new XAdEvent4PDK("EVENT_SLOT_STARTED", XAdContext.AdSlotEventListener.a(this.b)));
    } 
    if (this.a.getType().equals("AdUserClick"))
      XAdContext.AdSlotEventListener.b(this.b).dispatchEvent((IOAdEvent)new XAdEvent4PDK("EVENT_SLOT_CLICKED", XAdContext.AdSlotEventListener.a(this.b))); 
    if (this.a.getType().equals("AdStopped")) {
      if (XAdContext.AdSlotEventListener.a(this.b).getProdBase() != null)
        XAdContext.AdSlotEventListener.a(this.b).getProdBase().setVisibility(4); 
      XAdContext.AdSlotEventListener.b(this.b).dispatchEvent((IOAdEvent)new XAdEvent4PDK("EVENT_SLOT_ENDED", XAdContext.AdSlotEventListener.a(this.b)));
    } 
    if (this.a.getType().equals("AdError")) {
      if (XAdContext.AdSlotEventListener.a(this.b).getProdBase() != null)
        XAdContext.AdSlotEventListener.a(this.b).getProdBase().setVisibility(4); 
      XAdContext.AdSlotEventListener.b(this.b).dispatchEvent((IOAdEvent)new XAdEvent4PDK("EVENT_ERROR", XAdContext.AdSlotEventListener.a(this.b)));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\video\XAdContext$AdSlotEventListener$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */