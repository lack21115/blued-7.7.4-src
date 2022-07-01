package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

public class AvailabilityException extends Exception {
  private final ArrayMap<ApiKey<?>, ConnectionResult> zaa;
  
  public AvailabilityException(ArrayMap<ApiKey<?>, ConnectionResult> paramArrayMap) {
    this.zaa = paramArrayMap;
  }
  
  public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> paramGoogleApi) {
    boolean bool;
    ApiKey<? extends Api.ApiOptions> apiKey = paramGoogleApi.getApiKey();
    if (this.zaa.get(apiKey) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    String str = apiKey.getApiName();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 58);
    stringBuilder.append("The given API (");
    stringBuilder.append(str);
    stringBuilder.append(") was not part of the availability request.");
    Preconditions.checkArgument(bool, stringBuilder.toString());
    return (ConnectionResult)this.zaa.get(apiKey);
  }
  
  public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> paramHasApiKey) {
    boolean bool;
    ApiKey<? extends Api.ApiOptions> apiKey = paramHasApiKey.getApiKey();
    if (this.zaa.get(apiKey) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    String str = apiKey.getApiName();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 58);
    stringBuilder.append("The given API (");
    stringBuilder.append(str);
    stringBuilder.append(") was not part of the availability request.");
    Preconditions.checkArgument(bool, stringBuilder.toString());
    return (ConnectionResult)this.zaa.get(apiKey);
  }
  
  public String getMessage() {
    ArrayList<String> arrayList = new ArrayList();
    Iterator<ApiKey> iterator = this.zaa.keySet().iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      ApiKey apiKey = iterator.next();
      ConnectionResult connectionResult = (ConnectionResult)this.zaa.get(apiKey);
      if (connectionResult.isSuccess())
        bool = false; 
      String str1 = apiKey.getApiName();
      String str2 = String.valueOf(connectionResult);
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str1).length() + 2 + String.valueOf(str2).length());
      stringBuilder1.append(str1);
      stringBuilder1.append(": ");
      stringBuilder1.append(str2);
      arrayList.add(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    if (bool) {
      stringBuilder.append("None of the queried APIs are available. ");
    } else {
      stringBuilder.append("Some of the queried APIs are unavailable. ");
    } 
    stringBuilder.append(TextUtils.join("; ", arrayList));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\AvailabilityException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */