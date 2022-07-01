package com.loopj.android.http;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.RedirectLocations;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

class MyRedirectHandler extends DefaultRedirectHandler {
  private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
  
  private final boolean enableRedirects;
  
  public MyRedirectHandler(boolean paramBoolean) {
    this.enableRedirects = paramBoolean;
  }
  
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
    if (paramHttpResponse != null) {
      Header header = paramHttpResponse.getFirstHeader("location");
      if (header != null) {
        RedirectLocations redirectLocations;
        String str = header.getValue().replaceAll(" ", "%20");
        try {
          StringBuilder stringBuilder1;
          URI uRI2 = new URI(str);
          HttpParams httpParams = paramHttpResponse.getParams();
          URI uRI1 = uRI2;
          if (!uRI2.isAbsolute())
            if (!httpParams.isParameterTrue("http.protocol.reject-relative-redirect")) {
              HttpHost httpHost = (HttpHost)paramHttpContext.getAttribute("http.target_host");
              if (httpHost != null) {
                HttpRequest httpRequest = (HttpRequest)paramHttpContext.getAttribute("http.request");
                try {
                  URI uRI = URIUtils.resolve(URIUtils.rewriteURI(new URI(httpRequest.getRequestLine().getUri()), httpHost, true), uRI2);
                } catch (URISyntaxException null) {
                  throw new ProtocolException(uRISyntaxException.getMessage(), uRISyntaxException);
                } 
              } else {
                throw new IllegalStateException("Target host not available in the HTTP context");
              } 
            } else {
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Relative redirect location '");
              stringBuilder1.append(uRI2);
              stringBuilder1.append("' not allowed");
              throw new ProtocolException(stringBuilder1.toString());
            }  
          if (httpParams.isParameterFalse("http.protocol.allow-circular-redirects")) {
            URISyntaxException uRISyntaxException1;
            redirectLocations = (RedirectLocations)paramHttpContext.getAttribute("http.protocol.redirect-locations");
            RedirectLocations redirectLocations1 = redirectLocations;
            if (redirectLocations == null) {
              redirectLocations1 = new RedirectLocations();
              paramHttpContext.setAttribute("http.protocol.redirect-locations", redirectLocations1);
            } 
            if (stringBuilder1.getFragment() != null) {
              try {
                URI uRI = URIUtils.rewriteURI((URI)stringBuilder1, new HttpHost(stringBuilder1.getHost(), stringBuilder1.getPort(), stringBuilder1.getScheme()), true);
              } catch (URISyntaxException null) {
                throw new ProtocolException(uRISyntaxException.getMessage(), uRISyntaxException);
              } 
            } else {
              uRISyntaxException1 = uRISyntaxException;
            } 
            if (!redirectLocations1.contains((URI)uRISyntaxException1)) {
              redirectLocations1.add((URI)uRISyntaxException1);
              return (URI)uRISyntaxException;
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Circular redirect to '");
            stringBuilder1.append(uRISyntaxException1);
            stringBuilder1.append("'");
            throw new CircularRedirectException(stringBuilder1.toString());
          } 
          return (URI)stringBuilder1;
        } catch (URISyntaxException uRISyntaxException) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Invalid redirect URI: ");
          stringBuilder1.append((String)redirectLocations);
          throw new ProtocolException(stringBuilder1.toString(), uRISyntaxException);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Received redirect response ");
      stringBuilder.append(uRISyntaxException.getStatusLine());
      stringBuilder.append(" but no location header");
      throw new ProtocolException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("HTTP response may not be null");
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    if (!this.enableRedirects)
      return false; 
    if (paramHttpResponse != null) {
      int i = paramHttpResponse.getStatusLine().getStatusCode();
      if (i != 307)
        switch (i) {
          default:
            return false;
          case 301:
          case 302:
          case 303:
            break;
        }  
      return true;
    } 
    throw new IllegalArgumentException("HTTP response may not be null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\MyRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */