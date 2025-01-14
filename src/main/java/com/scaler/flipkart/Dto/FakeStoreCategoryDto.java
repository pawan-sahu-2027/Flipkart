package com.scaler.flipkart.Dto;

import com.scaler.flipkart.Models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreCategoryDto {


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return category;
  }

  public void setTitle(String category) {
    this.category = category;
  }

  private long id;
  private String category;

}
