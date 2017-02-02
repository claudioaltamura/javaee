package de.claudioaltamura.javaee.beanvalidation.custom.minwords;

import java.util.List;

public class Content {

	@MinWords(value = 10)
	private String foreword;

	private List<Page> pages;

	public String getForeword() {
		return foreword;
	}

	public void setForeword(String foreword) {
		this.foreword = foreword;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

}
