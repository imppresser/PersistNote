package habit.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table COMMUNITY_RECORD.
 */
public class CommunityRecord {

    private Long id;
    /** Not-null value. */
    private String communityId;
    private String userName;
    private String avatarUrl;
    private String timestamp;
    private Integer persistCount;
    private String content;
    private Integer supportCount;
    private Integer commentCount;

    public CommunityRecord() {
    }

    public CommunityRecord(Long id) {
        this.id = id;
    }

    public CommunityRecord(Long id, String communityId, String userName, String avatarUrl, String timestamp, Integer persistCount, String content, Integer supportCount, Integer commentCount) {
        this.id = id;
        this.communityId = communityId;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.timestamp = timestamp;
        this.persistCount = persistCount;
        this.content = content;
        this.supportCount = supportCount;
        this.commentCount = commentCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getCommunityId() {
        return communityId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPersistCount() {
        return persistCount;
    }

    public void setPersistCount(Integer persistCount) {
        this.persistCount = persistCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(Integer supportCount) {
        this.supportCount = supportCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

}
