package me.hoonti06.deliverytracker.step3.trackeddelivery;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

public class FakeResponse implements Connection.Response {

  private final Document document;
  private final int statusCode;

  public FakeResponse(final Document document, final int statusCode) {
    this.document = document;
    this.statusCode = statusCode;
  }

  @Override
  public int statusCode() {
    return statusCode;
  }

  @Override
  public String statusMessage() {
    return null;
  }

  @Override
  public String charset() {
    return null;
  }

  @Override
  public Connection.Response charset(final String charset) {
    return null;
  }

  @Override
  public String contentType() {
    return null;
  }

  @Override
  public Document parse() throws IOException {
    return document;
  }

  @Override
  public String body() {
    return null;
  }

  @Override
  public byte[] bodyAsBytes() {
    return new byte[0];
  }

  @Override
  public Connection.Response bufferUp() {
    return null;
  }

  @Override
  public BufferedInputStream bodyStream() {
    return null;
  }

  @Override
  public URL url() {
    return null;
  }

  @Override
  public Connection.Response url(final URL url) {
    return this;
  }

  @Override
  public Connection.Method method() {
    return null;
  }

  @Override
  public Connection.Response method(final Connection.Method method) {
    return this;
  }

  @Override
  public String header(final String name) {
    return null;
  }

  @Override
  public List<String> headers(final String name) {
    return new ArrayList<>();
  }

  @Override
  public Connection.Response header(final String name, final String value) {
    return null;
  }

  @Override
  public Connection.Response addHeader(final String name, final String value) {
    return this;
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
  public Connection.Response removeHeader(final String name) {
    return this;
  }

  @Override
  public Map<String, String> headers() {
    return new HashMap<>();
  }

  @Override
  public Map<String, List<String>> multiHeaders() {
    return new HashMap<>();
  }

  @Override
  public String cookie(final String name) {
    return null;
  }

  @Override
  public Connection.Response cookie(final String name, final String value) {
    return this;
  }

  @Override
  public boolean hasCookie(final String name) {
    return false;
  }

  @Override
  public Connection.Response removeCookie(final String name) {
    return this;
  }

  @Override
  public Map<String, String> cookies() {
    return new HashMap<>();
  }
}
