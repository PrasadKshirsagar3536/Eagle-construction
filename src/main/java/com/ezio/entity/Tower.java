package com.ezio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Tower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tower;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@OneToMany(mappedBy = "tower", cascade = CascadeType.ALL)
	@JsonIgnore // Add this annotation to break the loop during serialization
	private List<Floor> floors;
	
	@OneToMany(mappedBy = "tower", cascade = CascadeType.ALL)
	@JsonIgnore // Add this annotation to break the loop during serialization
	private List<Flat> flats;

}
