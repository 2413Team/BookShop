package com.newBookShopWeb.entity;

import java.io.Serializable;

public class Book implements Serializable {
	private String title;
	private String author;
	private int publisherId;
	private String publisherDate;
	private String iSBN;
	private  int wordsCount;
	private float unitPrice;
	private String contentDescription;
	private String aurhorDescription;
	private String editorComment;
	private String tOc;
	private int categoryId;
	private int clicks;
	
	public Book(){
		this. clicks=1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherDate() {
		return publisherDate;
	}

	public void setPublisherDate(String publisherDate) {
		this.publisherDate = publisherDate;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public int getWordsCount() {
		return wordsCount;
	}

	public void setWordsCount(int wordsCount) {
		this.wordsCount = wordsCount;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public String getAurhorDescription() {
		return aurhorDescription;
	}

	public void setAurhorDescription(String aurhorDescription) {
		this.aurhorDescription = aurhorDescription;
	}

	public String getEditorComment() {
		return editorComment;
	}

	public void setEditorComment(String editorComment) {
		this.editorComment = editorComment;
	}

	public String gettOc() {
		return tOc;
	}

	public void settOc(String tOc) {
		this.tOc = tOc;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	
	
}
