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
public class CstVO {
	private String cst_id;
	private String cst_pw;
	private String cst_name;
	private String cst_birth;
	private Date cst_rgsdate;
}
