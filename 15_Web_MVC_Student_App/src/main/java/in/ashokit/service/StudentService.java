package in.ashokit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Student;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	public StudentRepo repo;
	
	public List<String> getCourses(){
		return Arrays.asList("Java","Python","Aws","DevOps");
	}
	
	public List<String> getTimings(){
		return Arrays.asList("Morning","Afternoon","Evening");
		
	}
	
	public boolean saveData(Student s) {
		
		StudentEntity entity = new StudentEntity();
		
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings()));

		repo.save(entity);
		
		return true;
		
	}
}
