package com.tts.Weather.request;

public class Request {
  private String zipCode;

  public Request() {}

  public Request(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "Request [zipCode=" + zipCode + "]";
  }
  
}
