package imageMover;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormattedCustomer {

    @JsonProperty("EmailVerified")
    private boolean emailVerified;

    @JsonProperty("UserCreateDate")
    private String userCreateDate;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Username")
    private String username;

    @JsonProperty("FamilyName")
    private String familyName;

    @JsonProperty("DisplayName")
    private String displayName;

    @JsonProperty("GivenName")
    private String givenName;

    @JsonProperty("Enabled")
    private boolean enabled;

    @JsonProperty("UserLastModifiedDate")
    private String userLastModifiedDate;

    @JsonProperty("UserStatus")
    private String userStatus;

    @JsonProperty("Tags")
    private List<String> tags;

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setUserLastModifiedDate(String userLastModifiedDate) {
        this.userLastModifiedDate = userLastModifiedDate;
    }

    public String getUserLastModifiedDate() {
        return userLastModifiedDate;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "emailVerified=" + emailVerified +
                ", userCreateDate='" + userCreateDate + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", familyName='" + familyName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", enabled=" + enabled +
                ", userLastModifiedDate='" + userLastModifiedDate + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", tags=" + tags +
                '}';
    }
}