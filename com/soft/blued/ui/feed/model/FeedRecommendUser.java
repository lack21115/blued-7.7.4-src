package com.soft.blued.ui.feed.model;

import com.soft.blued.ui.live.model.LiveRecommendModel;
import com.soft.blued.ui.login_register.model.BluedLoginResult;

public class FeedRecommendUser extends LiveRecommendModel {
  public String relationship;
  
  public int show_type;
  
  public FeedRecommendUser(BluedLoginResult paramBluedLoginResult) {
    super(paramBluedLoginResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\FeedRecommendUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */