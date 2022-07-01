package com.blued.android.module.live_china.model;

public class LiveRewardModel {
  public double beans;
  
  public String condition = "1";
  
  public long end_second;
  
  public boolean hasAgreePwd;
  
  public boolean hasPwdTip;
  
  public String hongbao_id;
  
  public int is_anim;
  
  public int is_prize;
  
  public String pwd;
  
  public long remaining_millisecond;
  
  public String size;
  
  public long start_second;
  
  public int status;
  
  public LiveRewardModel(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2) {
    this.hongbao_id = paramString1;
    this.start_second = paramLong1;
    this.end_second = paramLong2;
    this.is_anim = paramInt;
    this.condition = paramString2;
  }
  
  public LiveRewardModel(String paramString1, long paramLong1, long paramLong2, int paramInt1, String paramString2, double paramDouble, int paramInt2, long paramLong3, String paramString3, String paramString4) {
    this.hongbao_id = paramString1;
    this.start_second = paramLong1;
    this.end_second = paramLong2;
    this.status = paramInt1;
    this.size = paramString2;
    this.beans = paramDouble;
    this.is_anim = paramInt2;
    this.remaining_millisecond = paramLong3;
    this.condition = paramString3;
    this.pwd = paramString4;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveRewardModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */