package me.hoonti06.deliverytracker.step3.deilverytracker;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieStore;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class FakeConnection implements Connection {

  private final Response response;

  public FakeConnection(final Response response) {
    this.response = response;
  }

  @Override
  public Connection newRequest() {
    return this;
  }

  @Override
  public Connection url(final URL url) {
    return this;
  }

  @Override
  public Connection url(final String url) {
    return this;
  }

  @Override
  public Connection proxy(final Proxy proxy) {
    return this;
  }

  @Override
  public Connection proxy(final String host, final int port) {
    return this;
  }

  @Override
  public Connection userAgent(final String userAgent) {
    return this;
  }

  @Override
  public Connection timeout(final int millis) {
    return this;
  }

  @Override
  public Connection maxBodySize(final int bytes) {
    return this;
  }

  @Override
  public Connection referrer(final String referrer) {
    return this;
  }

  @Override
  public Connection followRedirects(final boolean followRedirects) {
    return this;
  }

  @Override
  public Connection method(final Method method) {
    return this;
  }

  @Override
  public Connection ignoreHttpErrors(final boolean ignoreHttpErrors) {
    return this;
  }

  @Override
  public Connection ignoreContentType(final boolean ignoreContentType) {
    return this;
  }

  @Override
  public Connection sslSocketFactory(final SSLSocketFactory sslSocketFactory) {
    return this;
  }

  @Override
  public Connection data(final String key, final String value) {
    return this;
  }

  @Override
  public Connection data(final String key, final String filename, final InputStream inputStream) {
    return this;
  }

  @Override
  public Connection data(final String key, final String filename, final InputStream inputStream,
                         final String contentType) {
    return this;
  }

  @Override
  public Connection data(final Collection<KeyVal> data) {
    return this;
  }

  @Override
  public Connection data(final Map<String, String> data) {
    return this;
  }

  @Override
  public Connection data(final String... keyvals) {
    return this;
  }

  @Override
  public KeyVal data(final String key) {
    return null;
  }

  @Override
  public Connection requestBody(final String body) {
    return this;
  }

  @Override
  public Connection header(final String name, final String value) {
    return this;
  }

  @Override
  public Connection headers(final Map<String, String> headers) {
    return this;
  }

  @Override
  public Connection cookie(final String name, final String value) {
    return this;
  }

  @Override
  public Connection cookies(final Map<String, String> cookies) {
    return this;
  }

  @Override
  public Connection cookieStore(final CookieStore cookieStore) {
    return null;
  }

  @Override
  public CookieStore cookieStore() {
    return null;
  }

  @Override
  public Connection parser(final Parser parser) {
    return this;
  }

  @Override
  public Connection postDataCharset(final String charset) {
    return null;
  }

  @Override
  public Document get() throws IOException {
    return response.parse();
  }

  @Override
  public Document post() throws IOException {
    return response.parse();
  }

  @Override
  public Response execute() throws IOException {
    return response;
  }

  @Override
  public Request request() {
    return null;
  }

  @Override
  public Connection request(final Request request) {
    return this;
  }

  @Override
  public Response response() {
    return response;
  }

  @Override
  public Connection response(final Response response) {
    return this;
  }
}
