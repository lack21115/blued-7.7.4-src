package org.chromium.content_public.browser;

import java.util.Locale;
import java.util.Map;
import org.chromium.content_public.common.Referrer;
import org.chromium.content_public.common.ResourceRequestBody;

public class LoadUrlParams {
  public String mBaseUrlForDataUrl;
  
  public boolean mCanLoadLocalResources;
  
  public String mDataUrlAsString;
  
  public Map mExtraHeaders;
  
  public boolean mIsRendererInitiated;
  
  public int mLoadUrlType;
  
  public ResourceRequestBody mPostData;
  
  public Referrer mReferrer;
  
  public boolean mShouldReplaceCurrentEntry;
  
  public int mTransitionType;
  
  public int mUaOverrideOption;
  
  public String mUrl;
  
  public String mVirtualUrlForDataUrl;
  
  public LoadUrlParams(String paramString) {
    this(paramString, 0);
  }
  
  private LoadUrlParams(String paramString, int paramInt) {
    this.mUrl = paramString;
    this.mTransitionType = paramInt;
    this.mLoadUrlType = 0;
    this.mUaOverrideOption = 0;
    this.mPostData = null;
    this.mBaseUrlForDataUrl = null;
    this.mVirtualUrlForDataUrl = null;
    this.mDataUrlAsString = null;
  }
  
  private static String buildDataUri(String paramString1, String paramString2, boolean paramBoolean, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder("data:");
    stringBuilder.append(paramString2);
    if (paramString3 != null && !paramString3.isEmpty()) {
      StringBuilder stringBuilder1 = new StringBuilder(";charset=");
      stringBuilder1.append(paramString3);
      stringBuilder.append(stringBuilder1.toString());
    } 
    if (paramBoolean)
      stringBuilder.append(";base64"); 
    stringBuilder.append(",");
    stringBuilder.append(paramString1);
    return stringBuilder.toString();
  }
  
  public static LoadUrlParams createLoadDataParams(String paramString1, String paramString2, boolean paramBoolean) {
    return createLoadDataParams(paramString1, paramString2, paramBoolean, null);
  }
  
  private static LoadUrlParams createLoadDataParams(String paramString1, String paramString2, boolean paramBoolean, String paramString3) {
    LoadUrlParams loadUrlParams = new LoadUrlParams(buildDataUri(paramString1, paramString2, paramBoolean, paramString3));
    loadUrlParams.mLoadUrlType = 2;
    loadUrlParams.mTransitionType = 1;
    return loadUrlParams;
  }
  
  public static LoadUrlParams createLoadDataParamsWithBaseUrl(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {
    if (paramString3 == null || !paramString3.toLowerCase(Locale.US).startsWith("data:")) {
      LoadUrlParams loadUrlParams = createLoadDataParams("", paramString2, paramBoolean, paramString5);
      if (paramString3 == null)
        paramString3 = "about:blank"; 
      loadUrlParams.mBaseUrlForDataUrl = paramString3;
      if (paramString4 == null)
        paramString4 = "about:blank"; 
      loadUrlParams.mVirtualUrlForDataUrl = paramString4;
      loadUrlParams.mDataUrlAsString = buildDataUri(paramString1, paramString2, paramBoolean, paramString5);
      return loadUrlParams;
    } 
    return createLoadDataParams(paramString1, paramString2, paramBoolean, paramString5);
  }
  
  public static LoadUrlParams createLoadHttpPostParams(String paramString, byte[] paramArrayOfbyte) {
    LoadUrlParams loadUrlParams = new LoadUrlParams(paramString);
    loadUrlParams.mLoadUrlType = 1;
    loadUrlParams.mTransitionType = 1;
    loadUrlParams.mPostData = ResourceRequestBody.createFromBytes(paramArrayOfbyte);
    return loadUrlParams;
  }
  
  public static native boolean nativeIsDataScheme(String paramString);
  
  public final String getExtraHeadersString(String paramString, boolean paramBoolean) {
    if (this.mExtraHeaders == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry entry : this.mExtraHeaders.entrySet()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append(paramString); 
      stringBuilder.append(((String)entry.getKey()).toLowerCase(Locale.US));
      stringBuilder.append(":");
      stringBuilder.append((String)entry.getValue());
    } 
    if (paramBoolean)
      stringBuilder.append(paramString); 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\LoadUrlParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */