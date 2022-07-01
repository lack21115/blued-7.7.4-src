package com.soft.blued.ui.login_register.model;

import java.util.List;

public class RemindSettingModel {
  private List<GroupInfo> groups;
  
  public String is_at_push;
  
  private String is_bluedtone;
  
  private String is_comment_push;
  
  private String is_followed_push;
  
  private String is_groups_notify;
  
  public String is_like_push;
  
  private String is_live_push;
  
  private String is_open_shake;
  
  private String is_open_sound;
  
  public String is_other_message_push;
  
  private String is_private_msg_push;
  
  private String is_push_content;
  
  public String is_push_posting_post;
  
  public String is_recall_live_push;
  
  private String is_system_push;
  
  public String is_used_mobile_push;
  
  public String is_verify_mobile_push;
  
  public String is_visited_push;
  
  public List<GroupInfo> getGroups() {
    return this.groups;
  }
  
  public String getIs_bluedtone() {
    return this.is_bluedtone;
  }
  
  public String getIs_comment_push() {
    return this.is_comment_push;
  }
  
  public String getIs_followed_push() {
    return this.is_followed_push;
  }
  
  public String getIs_groups_notify() {
    return this.is_groups_notify;
  }
  
  public String getIs_live_push() {
    return this.is_live_push;
  }
  
  public String getIs_open_shake() {
    return this.is_open_shake;
  }
  
  public String getIs_open_sound() {
    return this.is_open_sound;
  }
  
  public String getIs_private_msg_push() {
    return this.is_private_msg_push;
  }
  
  public String getIs_push_content() {
    return this.is_push_content;
  }
  
  public String getIs_push_pop_post() {
    return this.is_push_posting_post;
  }
  
  public String getIs_system_push() {
    return this.is_system_push;
  }
  
  public void setGroups(List<GroupInfo> paramList) {
    this.groups = paramList;
  }
  
  public void setIs_bluedtone(String paramString) {
    this.is_bluedtone = paramString;
  }
  
  public void setIs_comment_push(String paramString) {
    this.is_comment_push = paramString;
  }
  
  public void setIs_followed_push(String paramString) {
    this.is_followed_push = paramString;
  }
  
  public void setIs_groups_notify(String paramString) {
    this.is_groups_notify = paramString;
  }
  
  public void setIs_live_push(String paramString) {
    this.is_live_push = paramString;
  }
  
  public void setIs_open_shake(String paramString) {
    this.is_open_shake = paramString;
  }
  
  public void setIs_open_sound(String paramString) {
    this.is_open_sound = paramString;
  }
  
  public void setIs_private_msg_push(String paramString) {
    this.is_private_msg_push = paramString;
  }
  
  public void setIs_push_content(String paramString) {
    this.is_push_content = paramString;
  }
  
  public void setIs_push_pop_post(String paramString) {
    this.is_push_posting_post = paramString;
  }
  
  public void setIs_system_push(String paramString) {
    this.is_system_push = paramString;
  }
  
  public class GroupInfo {
    public String gid;
    
    public int nodisturb;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\model\RemindSettingModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */