package com.tencent.avroom;

import android.content.Context;
import android.view.TextureView;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class c extends TXCRenderAndDec {
  TXCloudVideoView a;
  
  private a b = null;
  
  public c(Context paramContext) {
    super(paramContext);
  }
  
  public a a() {
    return this.b;
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView) {
    if (paramTXCloudVideoView != null)
      this.a = paramTXCloudVideoView; 
    paramTXCloudVideoView = this.a;
    if (paramTXCloudVideoView == null)
      return; 
    paramTXCloudVideoView.setVisibility(0);
    TextureView textureView = new TextureView(this.a.getContext());
    this.a.addVideoView(textureView);
    getVideoRender().a(textureView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\avroom\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */