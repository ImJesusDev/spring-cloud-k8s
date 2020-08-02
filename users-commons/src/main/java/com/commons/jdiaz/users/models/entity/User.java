package com.commons.jdiaz.users.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty
	@Column(name = "last_name")
	private String lastName;

	@Column(unique = true, length = 100)
	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Column(unique = true, length = 30)
	private String username;

	@Column(name = "photo_url")
	private String photoUrl;

	@NotEmpty
	@Column(length = 60)
	private String password;

	private Boolean enabled;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "last_connection")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastConnection;

	@ManyToMany(fetch = FetchType.LAZY)
	@NotNull
	@JoinTable(name = "users_x_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "user_id", "role_id" }) })
	private List<Role> roles;

	public User(Long id, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty @Email String email,
			@NotEmpty String username, String photoUrl, @NotEmpty String password, Boolean enabled, Date createdAt,
			Date lastConnection, @NotNull List<Role> roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.photoUrl = photoUrl;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
		this.lastConnection = lastConnection;
		this.roles = roles;
	}

	public User() {
	}

	@PrePersist()
	public void prePersist() {
		this.createdAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
