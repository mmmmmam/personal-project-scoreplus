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
public class RgsVO {
	private int rgs_no;
	private String test_id;
	private String cst_id;
	private int test_round;    //시험회차
	private String test_name;  //시험이름
	private String test_date;  //시험일자
	private Date rgs_rgsdate;
	private String cancel_yn;
}
