package com.bytedance.sdk.adnet.face;

import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.IOException;
import java.util.Map;

public interface IHttpStack {
  HttpResponse a(Request<?> paramRequest, Map<String, String> paramMap) throws IOException, VAdError;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\face\IHttpStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */