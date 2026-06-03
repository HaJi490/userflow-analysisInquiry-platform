package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
	@Id
	@Column( nullable = false)
	private String id;
	private String password;
	private String username;
	@Builder.Default
	private Date createDate = new Date();
	@Builder.Default
	@Column(nullable = false)
	private boolean enabled = true;
	@Builder.Default
	@Enumerated(EnumType.STRING)
	private Role role = Role.ROLE_MEMBER;
	
}
