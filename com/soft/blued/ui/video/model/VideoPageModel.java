package com.soft.blued.ui.video.model;

import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

public class VideoPageModel {
  public static List<VideoPageModel> mVideos = new ArrayList<VideoPageModel>();
  
  public BluedIngSelfFeed bluedIngSelfFeed;
  
  public int isLike;
  
  public String previewUrl;
  
  public String relationship;
  
  public String videoUrl;
  
  public VideoPageModel() {}
  
  public VideoPageModel(BluedIngSelfFeed paramBluedIngSelfFeed) {}
  
  public VideoPageModel(String paramString1, String paramString2) {
    this.previewUrl = paramString1;
    this.videoUrl = paramString2;
  }
  
  public VideoPageModel(String[] paramArrayOfString, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramArrayOfString != null && paramArrayOfString.length >= 2) {
      this.previewUrl = paramArrayOfString[0];
      this.videoUrl = paramArrayOfString[1];
      this.bluedIngSelfFeed = paramBluedIngSelfFeed;
      Logger.b("xpf", new Object[] { "videoUrl:", this.videoUrl });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\model\VideoPageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */