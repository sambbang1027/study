package app.labs.ex01;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

	private List<String> list;
	private Map<String, String> map;
	private UserAccount userAccount;
	
	public TemplateServiceImpl() {
		/*java 8 버전 이하
		 * this.list.add("A");
			this.map.put("A", "가"); 
		*/
		list = List.of("A", "B", "C", "D", "E");
        map = Map.of(
                "A", "가",
                "B", "나",
                "C", "다",
                "D", "라",
                "E", "마"
        );

        userAccount = new UserAccount("1", "user", "1234", "사용자", "ROLE_USER", null, "1");
	}
	
	@Override
	public List<String> getList() {
				return this.list;
	}

	@Override
	public Map<String, String> getMap() {
				return this.map;
	}

	@Override
	public UserAccount getUserAccount() {
				return this.userAccount;
	}

}
