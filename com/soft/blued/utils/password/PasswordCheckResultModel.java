package com.soft.blued.utils.password;

public class PasswordCheckResultModel {
  public String _;
  
  public String password;
  
  private int strength_level;
  
  int getStrength_level() {
    return this.strength_level * 10;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\password\PasswordCheckResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */