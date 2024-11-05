package woongjin.hurryup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woongjin.hurryup.entity.Appointment;
import woongjin.hurryup.service.AppointmentService;

@RequestMapping(value = "/api/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // 약속 생성
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.create(appointment), HttpStatus.CREATED);
    }

    // 약속 상세 데이터 조회
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> detailAppointment(@PathVariable long id) {
        return new ResponseEntity<>(appointmentService.getAppointment(id), HttpStatus.OK);
    }
}
