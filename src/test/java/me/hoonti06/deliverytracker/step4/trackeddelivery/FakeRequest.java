package me.hoonti06.deliverytracker.step4.trackeddelivery;

import org.jsoup.Connection;
import org.jsoup.parser.Parser;

import javax.net.ssl.SSLSocketFactory;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FakeRequest implements Connection.Request {

  @Override
  public Proxy proxy() {
    return null;
  }

  @Override
  public Connection.Request proxy(final Proxy proxy) {
    return this;
  }

  @Override
  public Connection.Request proxy(final String host, final int port) {
    return this;
  }

  @Override
  public int timeout() {
    return 0;
  }

  @Override
  public Connection.Request timeout(final int millis) {
    return this;
  }

  @Override
  public int maxBodySize() {
    return 0;
  }

  @Override
  public Connection.Request maxBodySize(final int bytes) {
    return this;
  }

  @Override
  public boolean followRedirects() {
    return false;
  }

  @Override
  public Connection.Request followRedirects(final boolean followRedirects) {
    return this;
  }

  @Override
  public boolean ignoreHttpErrors() {
    return false;
  }

  @Override
  public Connection.Request ignoreHttpErrors(final boolean ignoreHttpErrors) {
    return this;
  }

  @Override
  public boolean ignoreContentType() {
    return false;
  }

  @Override
  public Connection.Request ignoreContentType(final boolean ignoreContentType) {
    return this;
  }

  @Override
  public SSLSocketFactory sslSocketFactory() {
    return null;
  }

  @Override
  public void sslSocketFactory(final SSLSocketFactory sslSocketFactory) {

  }

  @Override
  public Connection.Request data(final Connection.KeyVal keyval) {
    return this;
  }

  @Override
  public Collection<Connection.KeyVal> data() {
    return new ArrayList<>();
  }

  @Override
  public Connection.Request requestBody(final String body) {
    return this;
  }

  @Override
  public String requestBody() {
    return "";
  }

  @Override
  public Connection.Request parser(final Parser parser) {
    return this;
  }

  @Override
  public Parser parser() {
    return null;
  }

  @Override
  public Connection.Request postDataCharset(final String charset) {
    return this;
  }

  @Override
  public String postDataCharset() {
    return null;
  }

  @Override
  public URL url() {
    return null;
  }

  @Override
  public Connection.Request url(final URL url) {
    return this;
  }

  @Override
  public Connection.Method method() {
    return null;
  }

  @Override
  public Connection.Request method(final Connection.Method method) {
    return null;
  }

  @Override
  public String header(final String name) {
    return null;
  }

  @Override
  public List<String> headers(final String name) {
    return null;
  }

  @Override
  public Connection.Request header(final String name, final String value) {
    return null;
  }

  @Override
  public Connection.Request addHeader(final String name, final String value) {
    return null;
  }

  @Override
  public boolean hasHeader(final String name) {
    return false;
  }

  @Override
  public boolean hasHeaderWithValue(final String name, final String value) {
    return false;
  }

  @Override
  public Connection.Request removeHeader(final String name) {
    return null;
  }

  @Override
  public Map<String, String> headers() {
    return null;
  }

  @Override
  public Map<String, List<String>> multiHeaders() {
    return null;
  }

  @Override
  public String cookie(final String name) {
    return null;
  }

  @Override
  public Connection.Request cookie(final String name, final String value) {
    return null;
  }

  @Override
  public boolean hasCookie(final String name) {
    return false;
  }

  @Override
  public Connection.Request removeCookie(final String name) {
    return null;
  }

  @Override
  public Map<String, String> cookies() {
    return null;
  }
}

