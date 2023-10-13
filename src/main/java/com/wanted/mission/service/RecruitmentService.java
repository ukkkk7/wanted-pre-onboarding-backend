package com.wanted.mission.service;

import com.wanted.mission.domain.Recruitment;
import com.wanted.mission.dto.RecruitmentUpdateDto;
import com.wanted.mission.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;

    private final ModelMapper modelMapper;

    public void save(Recruitment recruitment) {
        recruitmentRepository.save(recruitment);
    }

    public List<Recruitment> findAll(){
       return recruitmentRepository.findAll();
    }

    public void delete(Long id) {

        recruitmentRepository.deleteById(id);
    }


    @Transactional
    public Recruitment updateRecruit(RecruitmentUpdateDto recruitmentUpdateDto, Long id) {



       Recruitment recruitment = recruitmentRepository.findById(id)
                                                      .orElseThrow(() -> new EntityNotFoundException("Recruitment not found with id: " + id));

       modelMapper.map(recruitmentUpdateDto, recruitment);


       return recruitment;

    }
}
