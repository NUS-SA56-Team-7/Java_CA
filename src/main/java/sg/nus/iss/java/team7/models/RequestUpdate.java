package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "requestupdate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@MapsId("courseId")
	@JsonIgnore
	private Course course;
	
	@ManyToOne
	@MapsId("lecturerId")
	@JsonIgnore
	private Lecturer lecturer;
	
	@Column(columnDefinition = "VARCHAR(255) NOT NULL")
	private String reason;

	@Column(columnDefinition = "TINYINT")
	private Integer status = 1;
}
