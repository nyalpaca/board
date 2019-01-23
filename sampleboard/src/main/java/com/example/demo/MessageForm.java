package com.example.demo;

public class MessageForm {

  private String name;
  private String message;
  private Long id;
  private String createTime;

  public void setName(String name) {
    this.name = name;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getName() {
    return name;
  }

  public String getMessage() {
    return message;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCreateTime() {
	return createTime;
}

public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
}