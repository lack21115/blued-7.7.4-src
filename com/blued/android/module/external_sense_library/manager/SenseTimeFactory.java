package com.blued.android.module.external_sense_library.manager;

import android.content.Context;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SenseTimeFactory {
  public static ISenseTimeProcessor createInstance(Context paramContext, int paramInt) {
    return (ISenseTimeProcessor)((paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? null : new SenseTimeZegoFlashManger(paramContext, false)) : new SenseTimeQiniuEditVideoManager(paramContext, false)) : new SenseTimeQiniuShortVideoManager(paramContext, true)) : new SenseTimeQiniuLiveManager(paramContext, true));
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProcessorTypeDef {
    public static final int EDIT_VIDEO = 2;
    
    public static final int FLASH_VIDEO = 3;
    
    public static final int LIVE = 0;
    
    public static final int SHORT_VIDEO = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\manager\SenseTimeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */