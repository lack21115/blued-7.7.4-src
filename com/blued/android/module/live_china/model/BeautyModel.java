package com.blued.android.module.live_china.model;

import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;

public class BeautyModel {
  public static final int BEAUTY_TYPE_CLOSE = -1;
  
  public static final int BEAUTY_TYPE_DEFAULT = 0;
  
  public BluedBeautifyKey.KEY beautifyKey;
  
  public String customName;
  
  public String eventName;
  
  public BluedFilterType.FILER filer;
  
  public String id;
  
  public boolean isFilter;
  
  public boolean isSelect;
  
  public int progress;
  
  public int resource;
  
  public int type;
  
  public BeautyModel() {}
  
  public BeautyModel(BluedBeautifyKey.KEY paramKEY, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2) {
    this.beautifyKey = paramKEY;
    this.id = paramString1;
    this.customName = paramString2;
    this.type = paramInt1;
    this.isSelect = paramBoolean;
    this.progress = paramInt2;
  }
  
  public BeautyModel(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
    this.id = paramString1;
    this.customName = paramString2;
    this.type = paramInt;
    this.isSelect = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\BeautyModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */