package com.bytedance.embedapplog;

import com.bytedance.embedapplog.util.h;
import com.bytedance.embedapplog.util.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class GameReportHelper {
  public static final String ACCESS_ACCOUNT = "access_account";
  
  public static final String ACCESS_PAYMENT_CHANNEL = "access_payment_channel";
  
  public static final String ADD_CART = "add_cart";
  
  public static final String ADD_TO_FAVORITE = "add_to_favourite";
  
  public static final String CHECK_OUT = "check_out";
  
  public static final String CREATE_GAMEROLE = "create_gamerole";
  
  public static final String LOG_IN = "log_in";
  
  public static final String PURCHASE = "purchase";
  
  public static final String QUEST = "quest";
  
  public static final String REGISTER = "register";
  
  public static final String UPDATE_LEVEL = "update_level";
  
  public static final String VIEW_CONTENT = "view_content";
  
  public static void onEventAccessAccount(String paramString, boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("account_type", paramString);
      jSONObject.put("is_success", i.a(paramBoolean));
      AppLog.onEventV3("access_account", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventAccessPaymentChannel(String paramString, boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("payment_channel", paramString);
      jSONObject.put("is_success", i.a(paramBoolean));
      AppLog.onEventV3("access_payment_channel", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventAddCart(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("content_type", paramString1);
      jSONObject.put("content_name", paramString2);
      jSONObject.put("content_id", paramString3);
      jSONObject.put("content_num", paramInt);
      jSONObject.put("is_success", i.a(paramBoolean));
      AppLog.onEventV3("add_cart", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventAddToFavorite(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("content_type", paramString1);
      jSONObject.put("content_name", paramString2);
      jSONObject.put("content_id", paramString3);
      jSONObject.put("content_num", paramInt);
      jSONObject.put("is_success", i.a(paramBoolean));
      AppLog.onEventV3("add_to_favourite", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventCheckOut(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, String paramString4, String paramString5, boolean paramBoolean2, int paramInt2) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("content_type", paramString1);
      jSONObject.put("content_name", paramString2);
      jSONObject.put("content_id", paramString3);
      jSONObject.put("content_num", paramInt1);
      jSONObject.put("is_virtual_currency", i.a(paramBoolean1));
      jSONObject.put("virtual_currency", paramString4);
      jSONObject.put("currency", paramString5);
      jSONObject.put("is_success", i.a(paramBoolean2));
      jSONObject.put("currency_amount", paramInt2);
      AppLog.onEventV3("check_out", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventCreateGameRole(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("gamerole_id", paramString);
      AppLog.onEventV3("create_gamerole", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventLogin(String paramString, boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("method", paramString);
      jSONObject.put("is_success", i.a(paramBoolean));
      AppLog.onEventV3("log_in", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventPurchase(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, boolean paramBoolean, int paramInt2) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("content_type", paramString1);
      jSONObject.put("content_name", paramString2);
      jSONObject.put("content_id", paramString3);
      jSONObject.put("content_num", paramInt1);
      jSONObject.put("payment_channel", paramString4);
      jSONObject.put("currency", paramString5);
      jSONObject.put("is_success", i.a(paramBoolean));
      jSONObject.put("currency_amount", paramInt2);
      AppLog.onEventV3("purchase", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventQuest(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, String paramString4) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("quest_id", paramString1);
      jSONObject.put("quest_type", paramString2);
      jSONObject.put("quest_name", paramString3);
      jSONObject.put("quest_no", paramInt);
      jSONObject.put("is_success", i.a(paramBoolean));
      jSONObject.put("description", paramString4);
      AppLog.onEventV3("quest", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventRegister(String paramString, boolean paramBoolean) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("method", paramString);
      jSONObject.put("is_success", i.a(paramBoolean));
      AppLog.onEventV3("register", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventUpdateLevel(int paramInt) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("level", paramInt);
      AppLog.onEventV3("update_level", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
  
  public static void onEventViewContent(String paramString1, String paramString2, String paramString3) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("content_type", paramString1);
      jSONObject.put("content_name", paramString2);
      jSONObject.put("content_id", paramString3);
      AppLog.onEventV3("view_content", jSONObject);
      return;
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\GameReportHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */