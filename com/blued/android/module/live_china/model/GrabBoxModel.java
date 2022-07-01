package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class GrabBoxModel extends BluedEntityBaseExtra {
  public static final int BOX_STATE_CLOSE = 3;
  
  public static final int BOX_STATE_OPEN = 2;
  
  public static final int BOX_STATE_PROGRESS = 1;
  
  public static final int BOX_STATE_RECEIVE = 4;
  
  public String box_gif;
  
  public String box_id;
  
  public String box_image;
  
  public int duration;
  
  public int index;
  
  public boolean isPlayAnim;
  
  public int progress;
  
  public String progress_full_gif;
  
  public int type;
  
  public static List<GrabBoxModel> parseGrabBoxMap(List<Map<String, Object>> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<GrabBoxModel> arrayList = new ArrayList();
    for (Map<String, Object> map : paramList) {
      GrabBoxModel grabBoxModel = new GrabBoxModel();
      grabBoxModel.parseMsgPackData(map);
      arrayList.add(grabBoxModel);
    } 
    return arrayList;
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof GrabBoxModel && TextUtils.equals(((GrabBoxModel)paramObject).box_id, this.box_id));
  }
  
  public void parseMsgPackData(Map<String, Object> paramMap) {
    if (paramMap == null)
      return; 
    this.type = MsgPackHelper.getIntValue(paramMap, "type");
    this.box_id = MsgPackHelper.getStringValue(paramMap, "box_id");
    this.box_image = MsgPackHelper.getStringValue(paramMap, "box_image");
    this.progress = MsgPackHelper.getIntValue(paramMap, "progress");
    this.box_gif = MsgPackHelper.getStringValue(paramMap, "box_gif");
    this.progress_full_gif = MsgPackHelper.getStringValue(paramMap, "progress_full_gif");
    this.duration = MsgPackHelper.getIntValue(paramMap, "duration");
    this.index = MsgPackHelper.getIntValue(paramMap, "index");
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GrabBoxModel{type=");
    stringBuilder.append(this.type);
    stringBuilder.append(", box_id='");
    stringBuilder.append(this.box_id);
    stringBuilder.append('\'');
    stringBuilder.append(", box_image='");
    stringBuilder.append(this.box_image);
    stringBuilder.append('\'');
    stringBuilder.append(", box_gif='");
    stringBuilder.append(this.box_gif);
    stringBuilder.append('\'');
    stringBuilder.append(", progress=");
    stringBuilder.append(this.progress);
    stringBuilder.append(", progress_full_gif='");
    stringBuilder.append(this.progress_full_gif);
    stringBuilder.append('\'');
    stringBuilder.append(", duration=");
    stringBuilder.append(this.duration);
    stringBuilder.append(", index=");
    stringBuilder.append(this.index);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static class GrabBoxModelComparator implements Comparator<GrabBoxModel> {
    public int compare(GrabBoxModel param1GrabBoxModel1, GrabBoxModel param1GrabBoxModel2) {
      return (param1GrabBoxModel1.index > param1GrabBoxModel2.index) ? 1 : ((param1GrabBoxModel1.index < param1GrabBoxModel2.index) ? -1 : 0);
    }
    
    public boolean equals(Object param1Object) {
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\GrabBoxModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */