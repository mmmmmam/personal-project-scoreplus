package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter @Getter
@NoArgsConstructor
@ToString
public class ScoreVO {
	private String score_id;
	private String cst_id;
	private String test_id;
	private int score;
	private Date score_rgsdate;
	private int test_round;
	private String test_name;
	private String test_date;
	private String test_rgsstart;
	private String test_rgsend;
}
