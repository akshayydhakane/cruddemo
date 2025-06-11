package com.example.cruddemo.Service;

import com.example.cruddemo.DTO.UserMasterDTO;
import com.example.cruddemo.Entity.Userdetail;
import com.example.cruddemo.Entity.Userexperince;
import com.example.cruddemo.Entity.Usermaster;
import com.example.cruddemo.Repository.UsermasterRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsermasterRepo usermasterRepository;

    @Transactional
    public UserMasterDTO addUser(UserMasterDTO userDTO) {
        if (usermasterRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        Usermaster usermaster = new Usermaster();
        usermaster.setEmail(userDTO.getEmail());
        usermaster.setPassword(userDTO.getPassword()); // In production, hash the password
        usermaster.setIsActive(userDTO.isActive());

        Userdetail userdetail = new Userdetail();
        userdetail.setFirstname(userDTO.getUserdetail().getFirstname());
        userdetail.setLastname(userDTO.getUserdetail().getLastname());
        userdetail.setDesignation(userDTO.getUserdetail().getDesignation());
        userdetail.setIsActive(userDTO.getUserdetail().isActive());
        userdetail.setUsermaster(usermaster);
        usermaster.setUserdetail(userdetail);

        List<Userexperince> experiences = userDTO.getExperiences().stream()
                .map(expDTO -> {
                    Userexperince exp = new Userexperince();
                    exp.setExperincename(expDTO.getExperincename());
                    exp.setUsermaster(usermaster);
                    return exp;
                }).toList();
        usermaster.setExperiences(experiences);

        usermasterRepository.save(usermaster);
        userDTO.setUsermasterid(usermaster.getUsermasterid());
        return userDTO;
    }

    @Transactional
    public UserMasterDTO updateUser(UserMasterDTO userDTO) {
        Usermaster usermaster = usermasterRepository.findById(userDTO.getUsermasterid())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (usermasterRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        usermaster.setEmail(userDTO.getEmail());
        usermaster.setPassword(userDTO.getPassword());
        usermaster.setIsActive(userDTO.isActive());

        Userdetail userdetail = usermaster.getUserdetail();
        if (userdetail == null) {
            userdetail = new Userdetail();
            userdetail.setUsermaster(usermaster);
        }
        userdetail.setFirstname(userDTO.getUserdetail().getFirstname());
        userdetail.setLastname(userDTO.getUserdetail().getLastname());
        userdetail.setDesignation(userDTO.getUserdetail().getDesignation());
        userdetail.setIsActive(userDTO.getUserdetail().isActive());
        usermaster.setUserdetail(userdetail);

        // Update experiences incrementally
        List<Userexperince> existingExperiences = usermaster.getExperiences();
        existingExperiences.clear();
        userDTO.getExperiences().forEach(expDTO -> {
            Userexperince exp = new Userexperince();
            exp.setUsrexperinceId(expDTO.getUsrexperinceId());
            exp.setExperincename(expDTO.getExperincename());
            exp.setUsermaster(usermaster);
            existingExperiences.add(exp);
        });

        usermasterRepository.save(usermaster);
        return userDTO;
    }


}
