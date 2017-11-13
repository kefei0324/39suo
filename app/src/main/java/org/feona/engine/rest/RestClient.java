package org.feona.engine.rest;

import org.androidannotations.rest.spring.annotations.*;
import org.androidannotations.rest.spring.api.MediaType;
import org.androidannotations.rest.spring.api.RestClientErrorHandling;
import org.androidannotations.rest.spring.api.RestClientSupport;
import org.feona.base.Constant;
import org.feona.entity.Student;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  9:12
 **/
@Rest(rootUrl = Constant.ROOT_URL, converters = {MappingJackson2HttpMessageConverter.class, StringHttpMessageConverter.class},
        interceptors = {UserAgentInterceptor.class}, /*requestFactory = UserRequestFactory.class,*/
        responseErrorHandler = UserResponseErrorHandler.class)
public interface RestClient extends RestClientErrorHandling,RestClientSupport{

    @Get(value = "test/timeOut.do")
    @Accept(MediaType.TEXT_PLAIN)
    String testRestTimeOut();

    @Get(value = "studentApi/findAllStudentInfo.do?id={id}")
    @Accept(MediaType.APPLICATION_JSON)
    BaseResponse<List<Student>> getAllStudent(@Path int id);




}
