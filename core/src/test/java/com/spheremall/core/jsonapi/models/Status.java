package com.spheremall.core.jsonapi.models;

import com.spheremall.core.jsonapi.Links;
import com.spheremall.core.jsonapi.annotations.Id;
import com.spheremall.core.jsonapi.annotations.Relationship;
import com.spheremall.core.jsonapi.annotations.RelationshipLinks;
import com.spheremall.core.jsonapi.annotations.RelationshipMeta;
import com.spheremall.core.jsonapi.annotations.Type;

@Type(value = "statuses", path = "/statuses/{id}")
public class Status {
	@Id
	private String id;
	private String content;
	private Integer commentCount;
	private Integer likeCount;
	
	@com.spheremall.core.jsonapi.annotations.Links
	private Links links;

	@Relationship(value = "user", resolve = true, path = "/relationships/user", relatedPath = "user")
	private User user;
	
	@RelationshipMeta("user")
	private SimpleMeta userRelationshipMeta;
	
	@RelationshipLinks("user")
	private Links userRelationshipLinks;

	@Relationship(value = "related-user", resolve = true, serialise = false)
	private User relatedUser;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getRelatedUser() {
		return relatedUser;
	}

	public void setRelatedUser(User relatedUser) {
		this.relatedUser = relatedUser;
	}
	
	public SimpleMeta getUserRelationshipMeta() {
		return userRelationshipMeta;
	}
	
	public void setUserRelationshipMeta(SimpleMeta userRelationshipMeta) {
		this.userRelationshipMeta = userRelationshipMeta;
	}
	
	public Links getUserRelationshipLinks() {
		return userRelationshipLinks;
	}
	
	public void setUserRelationshipLinks(Links userRelationshipLinks) {
		this.userRelationshipLinks = userRelationshipLinks;
	}
	
	public Links getLinks() {
		return links;
	}
	
	public void setLinks(Links links) {
		this.links = links;
	}
	
	@Override
	public String toString() {
		return "Status{" +
				"id='" + id + '\'' +
				", content='" + content + '\'' +
				", commentCount=" + commentCount +
				", likeCount=" + likeCount +
				", user=" + user +
				'}';
	}
}
