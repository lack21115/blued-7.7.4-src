package com.baidu.mobads.interfaces.feeds;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import java.util.Map;

public interface IXAdDummyContainer extends IXAdContainer {
  boolean isAdAvailable(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters);
  
  void onClick(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, int paramInt, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
  
  void onClose(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
  
  void onComplete(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
  
  void onCstartcard(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
  
  void onError(Context paramContext, int paramInt1, int paramInt2, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
  
  void onFullScreen(Context paramContext, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
  
  void onImpression(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
  
  void onStart(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, Map<String, Object> paramMap);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\feeds\IXAdDummyContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */