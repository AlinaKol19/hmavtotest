package ru.tinkoff.qa.hibernate.apimodels;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {
	@JsonProperty("photoUrls")
	private List<String> photoUrls;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private long id;

	@JsonProperty("category")
	private Category category;
	@JsonProperty("tags")
	private List<TagsItem> tags;

	@JsonProperty("status")
	private String status;

	public final void setPhotoUrls(final List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public final List<String> getPhotoUrls() {
		return photoUrls;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	public final void setId(final long id) {
		this.id = id;
	}

	public final long getId() {
		return id;
	}

	public final void setCategory(final Category category) {
		this.category = category;
	}

	public final Category getCategory() {
		return category;
	}

	public final void setTags(final List<TagsItem> tags) {
		this.tags = tags;
	}

	public final List<TagsItem> getTags() {
		return tags;
	}

	public final void setStatus(final String status) {
		this.status = status;
	}

	public final String getStatus() {
		return status;
	}
}