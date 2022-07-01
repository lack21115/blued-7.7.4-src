package com.blued.android.sdk;

import com.blued.android.sdk.a.c;
import com.blued.android.sdk.a.d;
import com.blued.android.sdk.a.e;
import com.blued.android.sdk.model.BluedEntity;
import com.blued.android.sdk.model.EmptyModel;
import com.blued.android.sdk.model.ModelCallback;
import com.blued.android.sdk.model.RelationshipModel;
import com.blued.android.sdk.model.UserModel;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;

public class BluedUser {
  public static void followUser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ModelCallback<RelationshipModel> paramModelCallback) {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("T", str);
    hashMap.put("access_token", paramString5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/followed/");
    stringBuilder.append(paramString2);
    c.a(e.a(stringBuilder.toString(), hashMap), e.a(paramString3, paramString4, paramString5, str), null, (new TypeToken<BluedEntity<RelationshipModel>>() {
        
        },  ).getType(), paramModelCallback);
  }
  
  public static void getFriendList(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, ModelCallback<List<UserModel>> paramModelCallback) {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("T", str);
    hashMap.put("access_token", paramString4);
    hashMap.put("page", String.valueOf(paramInt));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/friends");
    c.a(e.a(stringBuilder.toString(), hashMap), e.a(paramString2, paramString3, paramString4, str), (new TypeToken<BluedEntity<UserModel>>() {
        
        },  ).getType(), paramModelCallback);
  }
  
  public static void getUserInfo(String paramString1, String paramString2, String paramString3, ModelCallback<UserModel> paramModelCallback) {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("T", str);
    hashMap.put("access_token", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a());
    stringBuilder.append("/users/self");
    c.a(e.a(stringBuilder.toString(), hashMap), e.a(paramString1, paramString2, paramString3, str), (new TypeToken<BluedEntity<UserModel>>() {
        
        },  ).getType(), paramModelCallback);
  }
  
  public static void getUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, ModelCallback<UserModel> paramModelCallback) {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("T", str);
    hashMap.put("access_token", paramString4);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    c.a(e.a(stringBuilder.toString(), hashMap), e.a(paramString2, paramString3, paramString4, str), (new TypeToken<BluedEntity<UserModel>>() {
        
        },  ).getType(), paramModelCallback);
  }
  
  public static void unfollowUser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ModelCallback<RelationshipModel> paramModelCallback) {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("T", str);
    hashMap.put("access_token", paramString5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/followed/");
    stringBuilder.append(paramString2);
    stringBuilder.append("?http_method_override=DELETE");
    c.a(e.a(stringBuilder.toString(), hashMap), e.a(paramString3, paramString4, paramString5, str), null, (new TypeToken<BluedEntity<RelationshipModel>>() {
        
        },  ).getType(), paramModelCallback);
  }
  
  public static void updateGameStatus(String paramString1, String paramString2, String paramString3, String paramString4, ModelCallback<EmptyModel> paramModelCallback) {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("T", str);
    hashMap.put("access_token", paramString4);
    hashMap.put("operation", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a());
    stringBuilder.append("/game/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/status");
    c.a(e.a(stringBuilder.toString(), hashMap), e.a(paramString2, paramString3, paramString4, str), (new TypeToken<BluedEntity<EmptyModel>>() {
        
        },  ).getType(), paramModelCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\BluedUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */