package domain;

import java.util.Collection;

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
@NoArgsConstructor
public class Album {
	@Id
	 @Column(name="ALBUM_ID")
	@GeneratedValue
	Long id;
	
	 @OneToMany(targetEntity= Image.class, cascade= CascadeType.ALL)
	    @JoinColumn(name="album_image",referencedColumnName = "AlBUM_ID")
	    private Collection<Image> images;

}
