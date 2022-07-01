package com.blued.android.module.base.game_center;

import android.content.Context;
import android.os.Bundle;

public class GameCenterProxy implements IGameCenter {
  private static GameCenterProxy a = new GameCenterProxy();
  
  private IGameCenter b = null;
  
  public static GameCenterProxy a() {
    return a;
  }
  
  public void a(Context paramContext, Bundle paramBundle) {
    IGameCenter iGameCenter = this.b;
    if (iGameCenter != null)
      iGameCenter.a(paramContext, paramBundle); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\game_center\GameCenterProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */