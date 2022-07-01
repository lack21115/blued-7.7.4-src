package com.sina.weibo.sdk.register.mobile;

import com.sina.weibo.sdk.exception.WeiboException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryList implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public List<Country> countries;
  
  public CountryList(String paramString) {
    initFromJsonStr(paramString);
  }
  
  private void initFromJsonStr(String paramString) {
    try {
      initFromJsonObject(new JSONObject(paramString));
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  public void initFromJsonObject(JSONObject paramJSONObject) throws WeiboException {
    try {
      this.countries = new ArrayList<Country>();
      Iterator<String> iterator = paramJSONObject.keys();
      label14: while (true) {
        if (!iterator.hasNext())
          return; 
        String str1 = iterator.next();
        JSONObject jSONObject = paramJSONObject.optJSONObject(str1);
        String str2 = jSONObject.getString("code");
        JSONArray jSONArray = jSONObject.optJSONObject("rule").optJSONArray("mcc");
        String[] arrayOfString = new String[jSONArray.length()];
        for (int i = 0;; i++) {
          if (i >= jSONArray.length()) {
            Country country = new Country(str1, str2);
            country.setMccs(arrayOfString);
            this.countries.add(country);
            continue label14;
          } 
          arrayOfString[i] = jSONArray.getString(i);
        } 
        break;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      throw new WeiboException(jSONException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\CountryList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */