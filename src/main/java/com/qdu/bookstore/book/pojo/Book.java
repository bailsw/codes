package com.qdu.bookstore.book.pojo;

import lombok.Data;

@Data
public class Book {

  private long book_id;
  private String book_type;
  private String book_name;
  private long book_price;
  private String book_pic;
  private String book_info;
  private String book_ISBN;
  private String book_author;
  private String book_publishingHouse;
  private long book_browsedTime;
  private long book_stock;
  private long book_soldcount;




}
