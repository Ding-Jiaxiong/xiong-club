package com.dingjiaxiong.subject.application.convert;

import com.dingjiaxiong.subject.application.dto.SubjectCategoryDTO;
import com.dingjiaxiong.subject.domain.entity.SubjectCategoryBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T14:45:26+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_411 (Oracle Corporation)"
)
public class SubjectCategoryDTOConverterImpl implements SubjectCategoryDTOConverter {

    @Override
    public List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        List<SubjectCategoryDTO> list = new ArrayList<SubjectCategoryDTO>( subjectCategoryDTO.size() );
        for ( SubjectCategoryBO subjectCategoryBO : subjectCategoryDTO ) {
            list.add( convertBoToCategoryDTO( subjectCategoryBO ) );
        }

        return list;
    }

    @Override
    public SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategoryDTO.getId() );
        subjectCategoryBO.setCategoryName( subjectCategoryDTO.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategoryDTO.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategoryDTO.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategoryDTO.getParentId() );

        return subjectCategoryBO;
    }

    @Override
    public SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO) {
        if ( subjectCategoryBO == null ) {
            return null;
        }

        SubjectCategoryDTO subjectCategoryDTO = new SubjectCategoryDTO();

        subjectCategoryDTO.setId( subjectCategoryBO.getId() );
        subjectCategoryDTO.setCategoryName( subjectCategoryBO.getCategoryName() );
        subjectCategoryDTO.setCategoryType( subjectCategoryBO.getCategoryType() );
        subjectCategoryDTO.setImageUrl( subjectCategoryBO.getImageUrl() );
        subjectCategoryDTO.setParentId( subjectCategoryBO.getParentId() );

        return subjectCategoryDTO;
    }
}
