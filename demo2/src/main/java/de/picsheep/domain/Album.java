package de.picsheep.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Album {
	@Id
	@Column(name = "ALBUM_ID")
	@GeneratedValue
	Long id;
	String name;

	@JsonIgnore
	@OneToMany(targetEntity = Image.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "album_image", referencedColumnName = "AlBUM_ID")
	private Collection<Image> images;

	public Album(String name) {
		super();
		this.name = name;
		List<Image> imageSet = new ArrayList<Image>();
		this.setImages(imageSet);
	}

	public Album() {
		List<Image> imageSet = new ArrayList<Image>();
		this.setImages(imageSet);
	}
}
