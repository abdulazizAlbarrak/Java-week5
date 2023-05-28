package com.example.week5hw21.Service;

import com.example.week5hw21.ApiException.ApiException;
import com.example.week5hw21.Model.Address;
import com.example.week5hw21.Model.Teacher;
import com.example.week5hw21.Repository.AddressRepository;
import com.example.week5hw21.Repository.TeacherRepository;
import com.example.week5hw21.TDO.AddressTDO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addAddressToTeacher(AddressTDO tdo){
        Teacher teacher = teacherRepository.findTeacherById(tdo.getTeacher_id());
        if (teacher == null)
            throw new ApiException("Id not found");
        Address address = new Address(null,tdo.getArea(),tdo.getStreet(),tdo.getBuildingNo(),teacher);
        addressRepository.save(address);
    }
    public void updateAddress(Integer id,Address address){
        Address old = addressRepository.findAddressById(id);
        if (old == null)
            throw new ApiException("Id not found");
        old.setArea(address.getArea());
        old.setStreet(address.getStreet());
        old.setBuildingNo(address.getBuildingNo());
        addressRepository.save(old);
    }
    public void deleteAddress(Integer id){
        addressRepository.delete(addressRepository.findAddressById(id));
    }
}
