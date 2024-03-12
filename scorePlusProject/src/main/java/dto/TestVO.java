package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter @Getter
@NoArgsConstructor
@ToString
public class TestVO {
	private String test_id;
	private int test_round;
	private String test_name;
	private String test_date;
	private String test_rgsstart;
	private String test_rgsend;
	private String test_yn;

}
