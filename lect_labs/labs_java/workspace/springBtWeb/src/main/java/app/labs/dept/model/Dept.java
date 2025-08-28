package app.labs.dept.model;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Dept {

		private int deptNo;
		private String dName;
		private String loc;
	
}
