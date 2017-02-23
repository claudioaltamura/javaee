package de.claudioaltamura.javaee.beanvalidation.custom.crossparameter;

import java.time.ZonedDateTime;

public class PromotionCampaign {

	private ZonedDateTime start;

	private ZonedDateTime end;

	@ConsistentDateParameters
	public PromotionCampaign(ZonedDateTime start, ZonedDateTime end) {
		this.start = start;
		this.end = end;
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	public ZonedDateTime getEnd() {
		return end;
	}

	public void setEnd(ZonedDateTime end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "PromotionCampaign [start=" + start + ", end=" + end + "]";
	}

}