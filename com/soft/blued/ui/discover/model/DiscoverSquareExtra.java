package com.soft.blued.ui.discover.model;

import android.text.TextUtils;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.ArrayList;
import java.util.List;

public class DiscoverSquareExtra extends BluedEntityBaseExtra {
  public List<Explore> explore_list;
  
  public static List<Explore> getDefaultExplores() {
    ArrayList<Explore> arrayList = new ArrayList();
    arrayList.add(new Explore(1));
    arrayList.add(new Explore(2));
    arrayList.add(new Explore(4));
    return arrayList;
  }
  
  public static class Explore {
    public String apng;
    
    public int loop = 1;
    
    public int name;
    
    public String png;
    
    public String title;
    
    public Explore(int param1Int) {
      this.name = param1Int;
    }
    
    public String getIcon() {
      return !TextUtils.isEmpty(this.apng) ? this.apng : (!TextUtils.isEmpty(this.png) ? this.png : "");
    }
    
    public String getIconType() {
      return !TextUtils.isEmpty(this.apng) ? "apng" : (!TextUtils.isEmpty(this.png) ? "png" : "");
    }
    
    public String getTitle() {
      return this.title;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\model\DiscoverSquareExtra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */