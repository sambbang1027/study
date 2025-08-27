package app.labs.ex08.mybatis.hr.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp {
	
	private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
// date 타입은 mybatis가 알아서 매핑해주기때문에 원하는 타입으로 하면 된다
    private String hireDate; 
    private String jobId;
    private double salary;
    private double commissionPct;
    private int managerId;
    private int departmentId;
	
}
