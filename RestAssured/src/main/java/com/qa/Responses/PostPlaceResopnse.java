package com.qa.Responses;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"status",
"place_id",
"scope",
"reference",
"id"
})
@Generated("jsonschema2pojo")
public class PostPlaceResopnse {

	@JsonProperty("status")
	private String status;
	@JsonProperty("place_id")
	private String placeId;
	@JsonProperty("scope")
	private String scope;
	@JsonProperty("reference")
	private String reference;
	@JsonProperty("id")
	private String id;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("place_id")
	public String getPlaceId() {
		return placeId;
	}

	@JsonProperty("place_id")
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	public void setScope(String scope) {
		this.scope = scope;
	}

	@JsonProperty("reference")
	public String getReference() {
		return reference;
	}

	@JsonProperty("reference")
	public void setReference(String reference) {
		this.reference = reference;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	@Override
	public String toString(){
		return new ToStringBuilder(this).append("status", status).append("place_id", placeId).append("scope", scope).append("reference", reference).toString();
	}
}
