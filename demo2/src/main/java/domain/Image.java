package domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Image {
@JsonProperty("id")
@Id
@GeneratedValue
Long id;


@Lob
byte[] content;

@JsonProperty("name")
String name;

@JsonProperty("album")
@ManyToOne()
private Album album;
}
