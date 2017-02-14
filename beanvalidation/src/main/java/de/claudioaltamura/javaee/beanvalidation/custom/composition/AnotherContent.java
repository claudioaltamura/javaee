package de.claudioaltamura.javaee.beanvalidation.custom.composition;

import java.util.List;

import de.claudioaltamura.javaee.beanvalidation.custom.minwords.Page;

public class AnotherContent {

	@Range
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
