package imageMover;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"Username",
		"UserAttributes",
		"UserCreateDate",
		"UserLastModifiedDate",
		"Enabled",
		"UserStatus"
})
@Generated("jsonschema2pojo")
public class CustomerInput {

	@JsonProperty("Username")
	private String username;
	@JsonProperty("UserAttributes")
	private UserAttribute userAttribute;
	@JsonProperty("UserCreateDate")
	private String userCreateDate;
	@JsonProperty("UserLastModifiedDate")
	private String userLastModifiedDate;
	@JsonProperty("Enabled")
	private Boolean enabled;
	@JsonProperty("UserStatus")
	private String userStatus;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	@JsonProperty("Username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("Username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("UserAttributes")
	public UserAttribute getUserAttribute() {
		return userAttribute;
	}

	@JsonProperty("UserAttributes")
	public void setUserAttribute(UserAttribute userAttribute) {
		this.userAttribute = userAttribute;
	}

	@JsonProperty("UserCreateDate")
	public String getUserCreateDate() {
		return userCreateDate;
	}

	@JsonProperty("UserCreateDate")
	public void setUserCreateDate(String userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	@JsonProperty("UserLastModifiedDate")
	public String getUserLastModifiedDate() {
		return userLastModifiedDate;
	}

	@JsonProperty("UserLastModifiedDate")
	public void setUserLastModifiedDate(String userLastModifiedDate) {
		this.userLastModifiedDate = userLastModifiedDate;
	}

	@JsonProperty("Enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	@JsonProperty("Enabled")
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@JsonProperty("UserStatus")
	public String getUserStatus() {
		return userStatus;
	}

	@JsonProperty("UserStatus")
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}


}