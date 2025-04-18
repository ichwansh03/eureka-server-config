package com.ichwan.outlet.service;

import com.ichwan.outlet.dto.OutletDto;
import com.ichwan.outlet.entity.Outlet;
import com.ichwan.outlet.exception.ResourceNotFoundException;
import com.ichwan.outlet.repository.OutletRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OutletServiceImpl implements OutletService{

    private OutletRepository outletRepository;

    @Override
    public Page<Outlet> getOutlets(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return outletRepository.findAll(pageable);
    }

    @Override
    public Outlet getOutletByName(String name) {
        return outletRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("outlet not found")
        );
    }

    @Override
    public Outlet createOutlet(OutletDto outletDto) {
        Outlet outlet = new Outlet();
        outlet.setName(outletDto.name());
        outlet.setAddress(outletDto.address());
        outlet.setPhone(outletDto.phone());
        outlet.setTotalEmployee(outletDto.totalEmployees());
        outlet.setCreatedBy(outletDto.createdBy());
        return outletRepository.save(outlet);
    }

    @Override
    public Outlet updateOutlet(OutletDto outletDto, Long id) {
        Outlet outlet = new Outlet();
        outlet.setName(outletDto.name());
        outlet.setAddress(outletDto.address());
        outlet.setPhone(outletDto.phone());
        outlet.setTotalEmployee(outletDto.totalEmployees());
        outlet.setUpdatedBy(outletDto.updatedBy());
        outlet.setOutletId(id);
        return outletRepository.save(outlet);
    }

    @Override
    public void deleteOutlet(Long id) {
        outletRepository.deleteById(id);
    }
}
