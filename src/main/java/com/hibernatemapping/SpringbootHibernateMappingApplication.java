package com.hibernatemapping;

import com.hibernatemapping.model.*;
import com.hibernatemapping.repository.LaptopRepository;
import com.hibernatemapping.repository.StudentRepository;
import com.hibernatemapping.repository.UserProfileRepository;
import com.hibernatemapping.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootHibernateMappingApplication implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHibernateMappingApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;


    @Override
    public void run(String... args) throws Exception {

//        User user=new User();
//        user.setName("Sapana");
//        user.setEmail("sapana@gmail.com");
//
//        UserProfile userProfile=new UserProfile();
//        userProfile.setAddress("Kathamandu");
//        userProfile.setGender(Gender.FEMALE);
//        userProfile.setDateOfBirth(LocalDate.of(1999,12,27));
//        userProfile.setPhoneNumber("2345678991");
//
//        user.setUserProfile(userProfile);
//        userProfile.setUser(user);
//
//        userRepository.save(user);

        Laptop laptop=new Laptop();
        laptop.setBrand("Dell");
        laptop.setLid(1l);
        Laptop laptop1 =new Laptop();
        laptop1.setBrand("Lenovo");
        laptop1.setLid(2l);

        Student students=new Student();
        students.setName("harry");
        students.setRollNo(1l);
        students.setMarks(70);
        students.getLaptop().add(laptop);
        students.getLaptop().add(laptop1);

        laptop.setStudent(students);
        List<Laptop> laptopList=new ArrayList<>();
        laptopList.add(laptop);
        laptopList.add(laptop1);
        students.setLaptop(laptopList);
        System.out.println("list of laptop are" + laptopList);

        studentRepository.save(students);



    }
}
