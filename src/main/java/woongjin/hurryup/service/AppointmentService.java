package woongjin.hurryup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woongjin.hurryup.entity.Appointment;
import woongjin.hurryup.repository.AppointmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    public final AppointmentRepository appointmentRepository;
}
