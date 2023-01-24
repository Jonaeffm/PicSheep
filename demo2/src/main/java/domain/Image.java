package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Image {
@Id
@GeneratedValue
Long id;

@Lob
byte[] content;

String name;
}
