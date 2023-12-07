package ru.tinkoff.qa.hibernate.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	public final void setId(final int id) {
		this.id = id;
	}

	public final int getId() {
		return id;
	}
}