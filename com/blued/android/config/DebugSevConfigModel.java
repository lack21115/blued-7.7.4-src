package com.blued.android.config;

public class DebugSevConfigModel {
  public int android_font_adjust = 0;
  
  public int android_grpc_im = 0;
  
  public int android_grpc_live = 0;
  
  public int android_msg_backup = 0;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DebugSevConfigModel{android_msg_backup=");
    stringBuilder.append(this.android_msg_backup);
    stringBuilder.append(", android_grpc_live=");
    stringBuilder.append(this.android_grpc_live);
    stringBuilder.append(", android_grpc_im=");
    stringBuilder.append(this.android_grpc_im);
    stringBuilder.append(", android_font_adjust=");
    stringBuilder.append(this.android_font_adjust);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\config\DebugSevConfigModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */