package info.prime;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestDemoController {
	ArrayList<Employee> arrayList;

	@PostConstruct
	public void getData() {
		arrayList = new ArrayList<Employee>();
		arrayList.add(new Employee(1, "arundathi", 1234.0));
	}

	@GetMapping("/emp/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		if (empId > arrayList.size()) {
			System.out.println("get employee.....................");
			throw new DataNotFoundException("data not visible" + empId);
		}
		return arrayList.get(empId);
	}

	/*@PostMapping("/employee")
	public String putEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getName());
		arrayList.add(employee);
		return "successfully updated";
	}*/
	@PostMapping("/employee")
	public ResponseEntity<String> putEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getName());
		arrayList.add(employee);
		return ResponseEntity.status(HttpStatus.OK).body("good");
	}

}
