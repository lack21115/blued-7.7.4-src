package com.soft.blued.ui.share_custom.Model;

import android.graphics.Bitmap;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.utils.ShareCoreUtils;
import java.io.Serializable;

public class BaseShareEntity implements Serializable {
  public String content = "";
  
  public String fileUrl = "";
  
  public int flag;
  
  public boolean ifHideRepostToFeed = true;
  
  public boolean ifHideShareToFeed = true;
  
  public boolean ifHideShareToPeopleAndGroup = false;
  
  public String linkUrl = "";
  
  public String mainBody = "";
  
  public String netImgUrl = "";
  
  public String platFormName = "";
  
  public ShareCoreUtils.ShareBackLister shareBackLister;
  
  public int shareFrom;
  
  public int shareType;
  
  public String title = "";
  
  public static class ShareLiveData {
    public String a;
    
    public String b;
    
    public String c;
    
    public String d;
    
    public Bitmap e;
    
    public String f;
    
    public String g;
    
    public String h;
    
    public boolean i;
    
    public String j;
    
    public ShareCoreUtils.ShareBackLister k;
    
    public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\share_custom\Model\BaseShareEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */