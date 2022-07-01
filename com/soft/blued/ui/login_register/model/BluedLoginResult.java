package com.soft.blued.ui.login_register.model;

import android.text.TextUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.model.BluedLoginResultVerBinding;
import com.soft.blued.ui.user.model.UserHeaderVerifyStatus;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class BluedLoginResult {
  private String _;
  
  private String access_token;
  
  public String age;
  
  private List<BluedAlbum> album;
  
  private String astro;
  
  public String avatar;
  
  private String avatar_pid;
  
  private String birthday;
  
  private String black_allowed_count;
  
  private String black_count;
  
  private String[] blacklist;
  
  private String blood_type;
  
  public String blued_pic;
  
  public int chat_sdk_type = 1;
  
  private String chinese_zodiac;
  
  private String city_settled;
  
  private String custom;
  
  public String description;
  
  private int device_safe;
  
  private String device_token;
  
  public String distance;
  
  private String education;
  
  public String email;
  
  private String ethnicity;
  
  private String followed_count;
  
  private String followers_count;
  
  private String friends_count;
  
  public int game_type;
  
  private String groups_count;
  
  private UserHeaderVerifyStatus headerVerifyStatus;
  
  public String health_prpe_use_situation;
  
  public String health_test_result;
  
  public String health_test_time;
  
  public String height;
  
  private String hometown;
  
  public String hot;
  
  private String ihate;
  
  private String ilike;
  
  private String in_blacklist;
  
  private String industry;
  
  private String is_access_follows;
  
  private String is_access_groups;
  
  private String is_audited;
  
  private String is_auth_url;
  
  public int is_hide_city_settled;
  
  public int is_hide_distance;
  
  public int is_hide_last_operate;
  
  public int is_invisible_all;
  
  public int is_invisible_half;
  
  private int is_kids;
  
  private String is_locked;
  
  public int is_recommend;
  
  public int is_show_vip_page;
  
  public int is_user_reactive;
  
  public int is_vip_annual;
  
  private String last_login;
  
  public String last_operate;
  
  private String latitude;
  
  private String lock_until;
  
  private String longitude;
  
  private String mate;
  
  private String my_ticktocks_count;
  
  public String name;
  
  private int need_auth;
  
  public String nickname_limit;
  
  public String note;
  
  public String online_state;
  
  public int photos_count;
  
  private String province;
  
  private String qq;
  
  public String reason;
  
  private String red_ribbon;
  
  private String red_ribbon_link;
  
  private String reg_date;
  
  private String relationship;
  
  private int rich_level;
  
  public String role;
  
  private UserTagAll tags;
  
  public int theme_pendant;
  
  private String third_access_token;
  
  private String third_user_id;
  
  private String total_time;
  
  public String uid;
  
  public int vbadge;
  
  private BluedLoginResultVerBinding verified_bindings;
  
  private VerifyStatus[] verify;
  
  private List<BluedAlbum> vip_avatars;
  
  public int vip_grade;
  
  private String visited_count;
  
  public String weekstar;
  
  private String weibo;
  
  public String weight;
  
  private String weixin;
  
  private String dealCountInt(String paramString, int paramInt) {
    int i;
    String str = paramString;
    if (StringUtils.e(paramString))
      str = "0"; 
    try {
      i = Integer.parseInt(str);
    } catch (Exception exception) {
      i = 0;
    } 
    i += paramInt;
    paramInt = i;
    if (i < 0)
      paramInt = 0; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public void addBlackCount() {
    try {
      int i = Integer.parseInt(this.black_count);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i + 1);
      stringBuilder.append("");
      this.black_count = stringBuilder.toString();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void addUserBlackCount() {
    byte b;
    String str2 = getBlackCount();
    String str1 = str2;
    if (StringUtils.e(str2))
      str1 = "0"; 
    try {
      b = Integer.parseInt(str1);
    } catch (Exception exception) {
      b = 0;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b + 1);
    stringBuilder.append("");
    setBlackCount(stringBuilder.toString());
  }
  
  public String getAccess_token() {
    return this.access_token;
  }
  
  public String getAge() {
    return this.age;
  }
  
  public List<BluedAlbum> getAlbum() {
    return this.album;
  }
  
  public String getAstro() {
    return this.astro;
  }
  
  public String getAvatar() {
    return this.avatar;
  }
  
  public String getAvatar_pid() {
    return this.avatar_pid;
  }
  
  public String getBirthday() {
    return this.birthday;
  }
  
  public String getBlackCount() {
    return this.black_count;
  }
  
  public String getBlackMax() {
    return this.black_allowed_count;
  }
  
  public String[] getBlacklist() {
    return this.blacklist;
  }
  
  public String getBlood_type() {
    return this.blood_type;
  }
  
  public String getChinese_zodiac() {
    return this.chinese_zodiac;
  }
  
  public String getCity_settled() {
    return this.city_settled;
  }
  
  public String getCustom() {
    return this.custom;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public int getDevice_safe() {
    return this.device_safe;
  }
  
  public String getDevice_token() {
    return this.device_token;
  }
  
  public String getDistance() {
    return this.distance;
  }
  
  public String getEducation() {
    return this.education;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public String getEthnicity() {
    return this.ethnicity;
  }
  
  public String getFollowedCount() {
    return this.followed_count;
  }
  
  public String getFollowerCount() {
    return this.followers_count;
  }
  
  public String getFriendCount() {
    return this.friends_count;
  }
  
  public String getGroupsCount() {
    return this.groups_count;
  }
  
  public UserHeaderVerifyStatus getHeaderVerifyStatus() {
    return this.headerVerifyStatus;
  }
  
  public String getHeight() {
    return this.height;
  }
  
  public String getHometown() {
    return this.hometown;
  }
  
  public String getHot() {
    return this.hot;
  }
  
  public String getIhate() {
    return this.ihate;
  }
  
  public String getIlike() {
    return this.ilike;
  }
  
  public String getIn_blacklist() {
    return this.in_blacklist;
  }
  
  public String getIndustry() {
    return this.industry;
  }
  
  public String getIs_access_follows() {
    return this.is_access_follows;
  }
  
  public String getIs_access_groups() {
    return this.is_access_groups;
  }
  
  public String getIs_audited() {
    return this.is_audited;
  }
  
  public String getIs_auth_url() {
    return this.is_auth_url;
  }
  
  public String getIs_locked() {
    return this.is_locked;
  }
  
  public String getLast_login() {
    return this.last_login;
  }
  
  public String getLast_operate() {
    return this.last_operate;
  }
  
  public String getLatitude() {
    return this.latitude;
  }
  
  public String getLock_until() {
    return this.lock_until;
  }
  
  public String getLongitude() {
    return this.longitude;
  }
  
  public String getMate() {
    return this.mate;
  }
  
  public String getMyTicktocksCount() {
    return this.my_ticktocks_count;
  }
  
  public String getName() {
    return TextUtils.isEmpty(this.name) ? "" : this.name;
  }
  
  public int getNeedAdultVerify() {
    return this.is_kids;
  }
  
  public int getNeed_auth() {
    return this.need_auth;
  }
  
  public String getNote() {
    return this.note;
  }
  
  public String getOnline_state() {
    return this.online_state;
  }
  
  public int getPhotos_count() {
    return this.photos_count;
  }
  
  public String getProvince() {
    return this.province;
  }
  
  public String getQq() {
    return this.qq;
  }
  
  public String getRed_ribbon() {
    return this.red_ribbon;
  }
  
  public String getRed_ribbon_link() {
    return this.red_ribbon_link;
  }
  
  public String getReg_date() {
    return this.reg_date;
  }
  
  public String getRelationship() {
    return this.relationship;
  }
  
  public int getRich_level() {
    return this.rich_level;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public ArrayList<String> getTagList() {
    ArrayList<String> arrayList = new ArrayList();
    UserTagAll userTagAll = this.tags;
    if (userTagAll != null) {
      List list = userTagAll.type;
      byte b = 0;
      if (list != null)
        for (int i = 0; i < this.tags.type.size(); i++)
          arrayList.add(((UserTag)this.tags.type.get(i)).id);  
      if (this.tags.character != null)
        for (int i = 0; i < this.tags.character.size(); i++)
          arrayList.add(((UserTag)this.tags.character.get(i)).id);  
      if (this.tags.love_type != null)
        for (int i = 0; i < this.tags.love_type.size(); i++)
          arrayList.add(((UserTag)this.tags.love_type.get(i)).id);  
      if (this.tags.i_want != null)
        for (int i = 0; i < this.tags.i_want.size(); i++)
          arrayList.add(((UserTag)this.tags.i_want.get(i)).id);  
      if (this.tags.love_character != null)
        for (int i = b; i < this.tags.love_character.size(); i++)
          arrayList.add(((UserTag)this.tags.love_character.get(i)).id);  
    } 
    return arrayList;
  }
  
  public UserTagAll getTags() {
    return this.tags;
  }
  
  public String getThird_access_token() {
    return this.third_access_token;
  }
  
  public String getThird_user_id() {
    return this.third_user_id;
  }
  
  public String getTotal_time() {
    return this.total_time;
  }
  
  public String getUid() {
    return TextUtils.isEmpty(this.uid) ? "0" : this.uid;
  }
  
  public int getVBadge() {
    return this.vbadge;
  }
  
  public BluedLoginResultVerBinding getVerified_bindings() {
    return this.verified_bindings;
  }
  
  public VerifyStatus[] getVerify() {
    return this.verify;
  }
  
  public List<BluedAlbum> getVip_avatars() {
    return this.vip_avatars;
  }
  
  public String getVisited_count() {
    return this.visited_count;
  }
  
  public String getWeibo() {
    return this.weibo;
  }
  
  public String getWeight() {
    return this.weight;
  }
  
  public String getWeixin() {
    return this.weixin;
  }
  
  public String get_() {
    return this._;
  }
  
  public void removeBlackCount() {
    try {
      int i = Integer.parseInt(this.black_count);
      StringBuilder stringBuilder = new StringBuilder();
      int j = i - 1;
      i = j;
      if (j < 0)
        i = 0; 
      stringBuilder.append(i);
      stringBuilder.append("");
      this.black_count = stringBuilder.toString();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void removeUserBlackCount() {
    byte b;
    String str2 = getBlackCount();
    String str1 = str2;
    if (StringUtils.e(str2))
      str1 = "0"; 
    try {
      b = Integer.parseInt(str1);
    } catch (Exception exception) {
      b = 0;
    } 
    int i = b;
    if (b >= 1)
      i = b - 1; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("");
    setBlackCount(stringBuilder.toString());
  }
  
  public void setAccess_token(String paramString) {
    this.access_token = paramString;
  }
  
  public void setAge(String paramString) {
    this.age = paramString;
  }
  
  public void setAlbum(List<BluedAlbum> paramList) {
    this.album = paramList;
  }
  
  public void setAstro(String paramString) {
    this.astro = paramString;
  }
  
  public void setAttentionCount(int paramInt) {
    setFollowedCount(dealCountInt(getFollowedCount(), paramInt));
  }
  
  public void setAvatar(String paramString) {
    this.avatar = paramString;
  }
  
  public void setAvatar_pid(String paramString) {
    this.avatar_pid = paramString;
  }
  
  public void setBirthday(String paramString) {
    this.birthday = paramString;
  }
  
  public void setBlackCount(String paramString) {
    this.black_count = paramString;
  }
  
  public void setBlackMax(String paramString) {
    this.black_allowed_count = paramString;
  }
  
  public void setBlacklist(String[] paramArrayOfString) {
    this.blacklist = paramArrayOfString;
  }
  
  public void setBlood_type(String paramString) {
    this.blood_type = paramString;
  }
  
  public void setChinese_zodiac(String paramString) {
    this.chinese_zodiac = paramString;
  }
  
  public void setCity_settled(String paramString) {
    this.city_settled = paramString;
  }
  
  public void setCustom(String paramString) {
    this.custom = paramString;
  }
  
  public void setDescription(String paramString) {
    this.description = paramString;
  }
  
  public void setDevice_safe(int paramInt) {
    this.device_safe = paramInt;
  }
  
  public void setDevice_token(String paramString) {
    this.device_token = paramString;
  }
  
  public void setDistance(String paramString) {
    this.distance = paramString;
  }
  
  public void setEducation(String paramString) {
    this.education = paramString;
  }
  
  public void setEmail(String paramString) {
    this.email = paramString;
  }
  
  public void setEthnicity(String paramString) {
    this.ethnicity = paramString;
  }
  
  public void setFansCount(int paramInt) {
    setFollowerCount(dealCountInt(getFollowerCount(), paramInt));
  }
  
  public void setFollowedCount(String paramString) {
    this.followed_count = paramString;
  }
  
  public void setFollowerCount(String paramString) {
    this.followers_count = paramString;
  }
  
  public void setFriendCount(String paramString) {
    this.friends_count = paramString;
  }
  
  public void setFriendsCount(int paramInt) {
    setFriendCount(dealCountInt(getFriendCount(), paramInt));
  }
  
  public void setGroupsCount(int paramInt) {
    setGroupsCount(dealCountInt(getGroupsCount(), paramInt));
  }
  
  public void setGroupsCount(String paramString) {
    this.groups_count = paramString;
  }
  
  public void setHeaderVerifyStatus(UserHeaderVerifyStatus paramUserHeaderVerifyStatus) {
    this.headerVerifyStatus = paramUserHeaderVerifyStatus;
  }
  
  public void setHeight(String paramString) {
    this.height = paramString;
  }
  
  public void setHometown(String paramString) {
    this.hometown = paramString;
  }
  
  public void setHot(String paramString) {
    this.hot = paramString;
  }
  
  public void setIhate(String paramString) {
    this.ihate = paramString;
  }
  
  public void setIlike(String paramString) {
    this.ilike = paramString;
  }
  
  public void setIn_blacklist(String paramString) {
    this.in_blacklist = paramString;
  }
  
  public void setIndustry(String paramString) {
    this.industry = paramString;
  }
  
  public void setIs_access_follows(String paramString) {
    this.is_access_follows = paramString;
  }
  
  public void setIs_access_groups(String paramString) {
    this.is_access_groups = paramString;
  }
  
  public void setIs_audited(String paramString) {
    this.is_audited = paramString;
  }
  
  public void setIs_auth_url(String paramString) {
    this.is_auth_url = paramString;
  }
  
  public void setIs_locked(String paramString) {
    this.is_locked = paramString;
  }
  
  public void setLast_login(String paramString) {
    this.last_login = paramString;
  }
  
  public void setLast_operate(String paramString) {
    this.last_operate = paramString;
  }
  
  public void setLatitude(String paramString) {
    this.latitude = paramString;
  }
  
  public void setLock_until(String paramString) {
    this.lock_until = paramString;
  }
  
  public void setLongitude(String paramString) {
    this.longitude = paramString;
  }
  
  public void setMate(String paramString) {
    this.mate = paramString;
  }
  
  public void setMyTicktocksCount(String paramString) {
    this.my_ticktocks_count = paramString;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setNeedAdultVerify(int paramInt) {
    this.is_kids = paramInt;
  }
  
  public void setNeed_auth(int paramInt) {
    this.need_auth = paramInt;
  }
  
  public void setNote(String paramString) {
    this.note = paramString;
  }
  
  public void setOnline_state(String paramString) {
    this.online_state = paramString;
  }
  
  public void setPhotos_count(int paramInt) {
    this.photos_count = paramInt;
  }
  
  public void setProvince(String paramString) {
    this.province = paramString;
  }
  
  public void setQq(String paramString) {
    this.qq = paramString;
  }
  
  public void setRed_ribbon(String paramString) {
    this.red_ribbon = paramString;
  }
  
  public void setRed_ribbon_link(String paramString) {
    this.red_ribbon_link = paramString;
  }
  
  public void setReg_date(String paramString) {
    this.reg_date = paramString;
  }
  
  public void setRelationship(String paramString) {
    this.relationship = paramString;
  }
  
  public void setRich_level(int paramInt) {
    this.rich_level = paramInt;
  }
  
  public void setRole(String paramString) {
    this.role = paramString;
  }
  
  public void setTags(UserTagAll paramUserTagAll) {
    this.tags = paramUserTagAll;
  }
  
  public void setThird_access_token(String paramString) {
    this.third_access_token = paramString;
  }
  
  public void setThird_user_id(String paramString) {
    this.third_access_token = paramString;
  }
  
  public void setTotal_time(String paramString) {
    this.total_time = paramString;
  }
  
  public void setUid(String paramString) {
    this.uid = paramString;
  }
  
  public void setVBadge(int paramInt) {
    this.vbadge = paramInt;
  }
  
  public void setVerified_bindings(BluedLoginResultVerBinding paramBluedLoginResultVerBinding) {
    this.verified_bindings = paramBluedLoginResultVerBinding;
  }
  
  public void setVerify(VerifyStatus[] paramArrayOfVerifyStatus) {
    this.verify = paramArrayOfVerifyStatus;
  }
  
  public void setVip_avatars(List<BluedAlbum> paramList) {
    this.vip_avatars = paramList;
  }
  
  public void setVisited_count(String paramString) {
    this.visited_count = paramString;
  }
  
  public void setWeibo(String paramString) {
    this.weibo = paramString;
  }
  
  public void setWeight(String paramString) {
    this.weight = paramString;
  }
  
  public void setWeixin(String paramString) {
    this.weixin = paramString;
  }
  
  public void set_(String paramString) {
    this._ = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\model\BluedLoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */