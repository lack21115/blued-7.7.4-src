package com.blued.android.module.live_china.zegoVideoCapture;

import android.content.Context;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory;

public class VideoFilterFactory extends ZegoVideoFilterFactory {
  private FilterType a = FilterType.a;
  
  private ZegoVideoFilter b = null;
  
  private ISenseTimeProcessor c;
  
  private Context d;
  
  public VideoFilterFactory(FilterType paramFilterType, ISenseTimeProcessor paramISenseTimeProcessor) {
    this.a = paramFilterType;
    this.c = paramISenseTimeProcessor;
  }
  
  public void a(Context paramContext) {
    this.d = paramContext;
  }
  
  public ZegoVideoFilter create() {
    return new VideoFilterSurfaceTexture(this.d, this.c);
  }
  
  public void destroy(ZegoVideoFilter paramZegoVideoFilter) {
    this.b = null;
  }
  
  public enum FilterType {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\zegoVideoCapture\VideoFilterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */