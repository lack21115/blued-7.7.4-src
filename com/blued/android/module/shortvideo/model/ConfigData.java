package com.blued.android.module.shortvideo.model;

import com.blued.android.module.shortvideo.R;
import java.util.ArrayList;
import java.util.List;

public class ConfigData extends IModel {
  public static final int ID_BEAUTY = 1;
  
  public static final int ID_COVER = 5;
  
  public static final int ID_FILTER = 2;
  
  public static final int ID_MUSIC = 0;
  
  public static final int ID_TIMEDOWN = 3;
  
  public static final int ID_VOLUME = 4;
  
  public List<Boolean> activateds = new ArrayList<Boolean>();
  
  public boolean[] all_activated = new boolean[] { true, true, false, false, true, false };
  
  private float[] all_alphas = new float[] { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  
  public int[] all_iconids = new int[] { R.drawable.config_music_icon, R.drawable.config_beauty_btn_selector, R.drawable.config_filter_icon, R.drawable.config_countdown_btn_selector, R.drawable.config_volume_icon, R.drawable.config_cover_selector };
  
  public int[] all_nameids = new int[] { R.string.stv_config_music_name, R.string.stv_config_open_beauty_name, R.string.stv_config_filter_name, R.string.stv_config_countdown_close_name, R.string.stv_config_volume_name, R.string.stv_config_cover_name };
  
  public List<Float> alphas = new ArrayList<Float>();
  
  public List<Integer> iconids = new ArrayList<Integer>();
  
  public List<Integer> ids = new ArrayList<Integer>();
  
  private CommonModel mCommonModel;
  
  private int mFrom;
  
  private int mPageType;
  
  private int mPrePageType;
  
  public List<Integer> nameids = new ArrayList<Integer>();
  
  public ConfigData(CommonModel paramCommonModel) {
    this.mCommonModel = paramCommonModel;
  }
  
  private void initData(CommonModel paramCommonModel) {
    FilterItem filterItem;
    if (this.mPageType == 4 && this.mPrePageType == 1) {
      float f;
      setMusicActivated(paramCommonModel.isAddMusic() ^ true);
      if (paramCommonModel.isAddMusic()) {
        f = 0.4F;
      } else {
        f = 1.0F;
      } 
      setMusicAlphas(f);
      if (paramCommonModel.isUseData()) {
        filterItem = paramCommonModel.getSelectedFilter();
        if (filterItem != null) {
          setFilter(filterItem.b, filterItem.c);
          return;
        } 
      } 
    } else if (this.mPageType == 1) {
      setBeauty(filterItem.isOpenBeauty());
      if (filterItem.isUseData()) {
        filterItem = filterItem.getSelectedFilter();
        if (filterItem != null)
          setFilter(filterItem.b, filterItem.c); 
      } 
    } 
  }
  
  private void setAlphas(int paramInt, float paramFloat) {
    if (this.alphas.size() >= paramInt)
      this.alphas.set(paramInt, Float.valueOf(paramFloat)); 
  }
  
  private void updateActivated(int paramInt, boolean paramBoolean) {
    if (paramInt >= 0 && this.activateds.size() >= paramInt)
      this.activateds.set(paramInt, Boolean.valueOf(paramBoolean)); 
  }
  
  public int getDefaultFilterNameId() {
    return this.all_nameids[2];
  }
  
  public int setBeauty(boolean paramBoolean) {
    int i = this.ids.indexOf(Integer.valueOf(1));
    updateActivated(i, paramBoolean);
    return i;
  }
  
  public int setCoverActivated(boolean paramBoolean) {
    CommonModel commonModel = this.mCommonModel;
    if (commonModel != null && commonModel.isUseData()) {
      int i = this.ids.indexOf(Integer.valueOf(5));
      updateActivated(i, paramBoolean);
      return i;
    } 
    return -1;
  }
  
  public int setFilter(int paramInt1, int paramInt2) {
    int i = this.ids.indexOf(Integer.valueOf(2));
    this.nameids.set(i, Integer.valueOf(paramInt1));
    this.iconids.set(i, Integer.valueOf(paramInt2));
    return i;
  }
  
  public int setMusicActivated(boolean paramBoolean) {
    int i = this.ids.indexOf(Integer.valueOf(0));
    updateActivated(i, paramBoolean);
    return i;
  }
  
  public int setMusicAlphas(float paramFloat) {
    int i = this.ids.indexOf(Integer.valueOf(0));
    if (i >= 0)
      setAlphas(i, paramFloat); 
    return i;
  }
  
  public void switchPage(int paramInt1, int paramInt2, int paramInt3) {
    this.ids.clear();
    this.iconids.clear();
    this.nameids.clear();
    this.alphas.clear();
    this.activateds.clear();
    this.mFrom = paramInt1;
    this.mPageType = paramInt3;
    this.mPrePageType = paramInt2;
    paramInt1 = this.mPageType;
    paramInt2 = 0;
    if (paramInt1 != 1) {
      if (paramInt1 != 4) {
        if (paramInt1 != 5) {
          paramInt1 = paramInt2;
        } else {
          this.ids.add(Integer.valueOf(1));
          this.ids.add(Integer.valueOf(2));
          paramInt1 = paramInt2;
        } 
      } else if (this.mFrom >= 60) {
        paramInt1 = paramInt2;
      } else {
        this.ids.add(Integer.valueOf(0));
        if (this.mPrePageType == 3) {
          this.ids.add(Integer.valueOf(2));
          this.ids.add(Integer.valueOf(4));
        } else {
          this.ids.add(Integer.valueOf(4));
        } 
        paramInt1 = paramInt2;
        if (this.mFrom != 1) {
          this.ids.add(Integer.valueOf(5));
          paramInt1 = paramInt2;
        } 
      } 
    } else if (this.mFrom >= 60) {
      this.ids.add(Integer.valueOf(1));
      this.ids.add(Integer.valueOf(2));
      this.ids.add(Integer.valueOf(3));
      paramInt1 = paramInt2;
    } else {
      this.ids.add(Integer.valueOf(0));
      this.ids.add(Integer.valueOf(1));
      this.ids.add(Integer.valueOf(2));
      this.ids.add(Integer.valueOf(3));
      paramInt1 = paramInt2;
    } 
    while (paramInt1 < this.ids.size()) {
      this.iconids.add(Integer.valueOf(this.all_iconids[((Integer)this.ids.get(paramInt1)).intValue()]));
      this.nameids.add(Integer.valueOf(this.all_nameids[((Integer)this.ids.get(paramInt1)).intValue()]));
      this.alphas.add(Float.valueOf(this.all_alphas[((Integer)this.ids.get(paramInt1)).intValue()]));
      this.activateds.add(Boolean.valueOf(this.all_activated[((Integer)this.ids.get(paramInt1)).intValue()]));
      paramInt1++;
    } 
    initData(this.mCommonModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\ConfigData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */