package com.dingjiaxiong.subject.domain.convert;

import com.dingjiaxiong.subject.domain.entity.SubjectAnswerBO;
import com.dingjiaxiong.subject.infra.basic.entity.SubjectMultiple;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T10:36:52+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_411 (Oracle Corporation)"
)
public class MultipleSubjectConverterImpl implements MultipleSubjectConverter {

    @Override
    public SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectMultiple subjectMultiple = new SubjectMultiple();

        if ( subjectAnswerBO.getOptionType() != null ) {
            subjectMultiple.setOptionType( subjectAnswerBO.getOptionType().longValue() );
        }
        subjectMultiple.setOptionContent( subjectAnswerBO.getOptionContent() );
        subjectMultiple.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectMultiple;
    }

    @Override
    public List<SubjectAnswerBO> convertEntityToBoList(List<SubjectMultiple> subjectMultipleList) {
        if ( subjectMultipleList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectMultipleList.size() );
        for ( SubjectMultiple subjectMultiple : subjectMultipleList ) {
            list.add( subjectMultipleToSubjectAnswerBO( subjectMultiple ) );
        }

        return list;
    }

    protected SubjectAnswerBO subjectMultipleToSubjectAnswerBO(SubjectMultiple subjectMultiple) {
        if ( subjectMultiple == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        if ( subjectMultiple.getOptionType() != null ) {
            subjectAnswerBO.setOptionType( subjectMultiple.getOptionType().intValue() );
        }
        subjectAnswerBO.setOptionContent( subjectMultiple.getOptionContent() );
        subjectAnswerBO.setIsCorrect( subjectMultiple.getIsCorrect() );

        return subjectAnswerBO;
    }
}
