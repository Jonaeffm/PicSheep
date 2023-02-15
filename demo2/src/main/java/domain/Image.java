package domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

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
@JsonRootName(value = "image")
@JsonPropertyOrder({  "id","name","album" })
public class Image {
@JsonProperty("id")
@Id
@GeneratedValue
Long id;

@JsonIgnore
@Lob
byte[] content;

@JsonProperty("name")
String name;

@JsonProperty("album")
@ManyToOne()
private Album album;


}
