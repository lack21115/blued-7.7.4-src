package com.loopj.android.http;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.HttpContext;

public class PreemtiveAuthorizationHttpRequestInterceptor implements HttpRequestInterceptor {
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
    AuthState authState = (AuthState)paramHttpContext.getAttribute("http.auth.target-scope");
    CredentialsProvider credentialsProvider = (CredentialsProvider)paramHttpContext.getAttribute("http.auth.credentials-provider");
    HttpHost httpHost = (HttpHost)paramHttpContext.getAttribute("http.target_host");
    if (authState.getAuthScheme() == null) {
      Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()));
      if (credentials != null) {
        authState.setAuthScheme((AuthScheme)new BasicScheme());
        authState.setCredentials(credentials);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\PreemtiveAuthorizationHttpRequestInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */