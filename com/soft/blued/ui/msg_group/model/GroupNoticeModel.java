package com.soft.blued.ui.msg_group.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class GroupNoticeModel implements MultiItemEntity {
  public static final int ERROR_CODE_OPERATE_INVALID = 40319014;
  
  public static final int NOTIFY_RESULT_AGREE = 1;
  
  public static final int NOTIFY_RESULT_INVALID = 3;
  
  public static final int NOTIFY_RESULT_NONE = 0;
  
  public static final int NOTIFY_RESULT_REFUSE = 2;
  
  public static final int NOTIFY_TYPE_ACCEPT_GROUP_OWNER = 10;
  
  public static final int NOTIFY_TYPE_ADD = 1;
  
  public static final int NOTIFY_TYPE_APPLY = 2;
  
  public static final int NOTIFY_TYPE_APPLY_REFUSE = 9;
  
  public static final int NOTIFY_TYPE_AUTO_OWNER_CHANGE = 8;
  
  public static final int NOTIFY_TYPE_DANGER = 4;
  
  public static final int NOTIFY_TYPE_EXIT = 3;
  
  public static final int NOTIFY_TYPE_OWNER_CHANGE = 7;
  
  public static final int NOTIFY_TYPE_REFUSE_GROUP_OWNER = 11;
  
  public static final int NOTIFY_TYPE_SET_MANAGER = 5;
  
  public static final int NOTIFY_TYPE_SET_MANAGER_CANCEL = 6;
  
  public String group_cover;
  
  public int group_id;
  
  public String group_title;
  
  public int id;
  
  public int isRead;
  
  public int ops_age;
  
  public String ops_avatar;
  
  public int ops_group_ago_role;
  
  public int ops_height;
  
  public String ops_name;
  
  public float ops_role;
  
  public int ops_uid;
  
  public int ops_vbadge;
  
  public int ops_weight;
  
  public String reason;
  
  public int result;
  
  public String text;
  
  public int timestamp;
  
  public int type;
  
  public int getItemType() {
    return this.type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\model\GroupNoticeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */