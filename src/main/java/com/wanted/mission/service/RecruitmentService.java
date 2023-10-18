package com.wanted.mission.service;

import com.wanted.mission.domain.Recruitment;
import com.wanted.mission.dto.RecruitmentDetailDto;
import com.wanted.mission.dto.RecruitmentDto;
import com.wanted.mission.dto.RecruitmentUpdateDto;
import com.wanted.mission.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;

    private final ModelMapper modelMapper;

    //id로 채용공고 찾는 메소드
    public Recruitment findRecruitmentById(Long id){
        return recruitmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recruitment not found with id: " + id));
    };


    public void save(Recruitment recruitment) {
        recruitmentRepository.save(recruitment);
    }

    public List<Recruitment> findAll(){
       return recruitmentRepository.findAll();
    }

    public void delete(Long id) {

        recruitmentRepository.deleteById(id);
    }



    public Recruitment updateRecruit(RecruitmentUpdateDto dto, Long id) {


       Recruitment updateRecruitment = findRecruitmentById(id);

       updateRecruitment.update(dto);

       return updateRecruitment;

    }

    public RecruitmentDetailDto detail(Long id) {

       Recruitment recruitment = findRecruitmentById(id);

       List<Long> idByCompany = recruitmentRepository.getRelatedRecruitment(recruitment.getCompany().getId());

       RecruitmentDetailDto detailDto = modelMapper.map(recruitment, RecruitmentDetailDto.class);

       detailDto.setRelatedRecruitment(idByCompany);

       return detailDto;


    }


    public List<RecruitmentDto> search(String keyword) {


       List<Recruitment> recruitment = recruitmentRepository.searchRecruitment(keyword);

       List<RecruitmentDto> resultList = recruitment.stream()
                                                    .map(data -> modelMapper.map(data, RecruitmentDto.class))
                                                    .collect(Collectors.toList());
       return resultList;

    }



}
