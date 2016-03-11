package com.netcracker.unc.newmvc.dao;

import java.math.BigDecimal;
import java.sql.Date;

public class CategoryModel {
	private Integer objectId = 0;
	private String objectName = null;
	private BigDecimal minPercent = null;
	private BigDecimal maxPercent = null;
	private Date finalDate = null;
	private BigDecimal coeficient = null;
	private BigDecimal sumCategory = null;
	private double prePersent = 0;
	private double persent = 0;

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public double getPrePersent() {
		return prePersent;
	}

	public void setPrePersent(double prePersent) {
		this.prePersent = prePersent;
	}

	public double getPersent() {
		return persent;
	}

	public void setPersent(double persent) {
		this.persent = persent;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public BigDecimal getMinPercent() {
		return minPercent;
	}

	public void setMinPercent(BigDecimal minPercent) {
		this.minPercent = minPercent;
	}

	public BigDecimal getMaxPercent() {
		return maxPercent;
	}

	public void setMaxPercent(BigDecimal maxPercent) {
		this.maxPercent = maxPercent;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public BigDecimal getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(BigDecimal coeficient) {
		this.coeficient = coeficient;
	}

	public BigDecimal getSumCategory() {
		return sumCategory;
	}

	public void setSumCategory(BigDecimal sumCategory) {
		this.sumCategory = sumCategory;
	}
}
