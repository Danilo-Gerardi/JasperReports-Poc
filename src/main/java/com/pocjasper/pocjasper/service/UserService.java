package com.pocjasper.pocjasper.service;

import com.pocjasper.pocjasper.entities.User;
import com.pocjasper.pocjasper.exceptions.ResourceNotFoundException;
import com.pocjasper.pocjasper.reports.ReportService;
import com.pocjasper.pocjasper.repository.UserRepository;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ReportService reportService;

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public User findById(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        user.setId(UUID.randomUUID());
        return this.repository.save(user);
    }


    public List<User> generateReport(String format) throws JRException, FileNotFoundException {
        List<User> users = this.repository.findAll();

        this.reportService.export(format, users);

        return users;

    }
}