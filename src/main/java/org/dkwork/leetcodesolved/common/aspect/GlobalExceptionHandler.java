package org.dkwork.leetcodesolved.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.dkwork.leetcodesolved.common.domain.ResultInfo;
import org.dkwork.leetcodesolved.common.domain.Status;
import org.dkwork.leetcodesolved.common.exceptions.CheckAuthException;
import org.dkwork.leetcodesolved.common.exceptions.CheckHandleValidException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResultInfo<Object> handleIllegalParamException(ConstraintViolationException e) {
        return new ResultInfo<>(Status.ERROR_REQUEST_PARAMETER, e.getMessage()).result(e.getMessage());
    }

    @ExceptionHandler(CheckHandleValidException.class)
    public ResultInfo<Object> checkHandleValidException(CheckHandleValidException e) {
        return new ResultInfo<>(Status.INVALID_HANDLE_CODE, e.getMessage());
    }

    @ExceptionHandler(CheckAuthException.class)
    public ResultInfo<Object> checkAuthException(CheckAuthException e) {
        return new ResultInfo<>(Status.LOGIN_EXPIRE, e.getMessage()).result(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo<Object> handleIllegalParamException(MethodArgumentNotValidException e) {
        StringBuilder tips = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(item -> {
            tips.append(item.getField());
            tips.append(item.getDefaultMessage());
            tips.append(";");
        });
        return new ResultInfo<>(Status.ERROR_REQUEST_PARAMETER).result(tips.toString());
    }

    @ExceptionHandler(Exception.class)
    public ResultInfo<Object> exceptionHandler(Exception ex) {
        log.error("GlobalExceptionHandler :{}", ex.getMessage());
        return new ResultInfo<>(Status.ERROR_SYSTEM).result(ex.getMessage());
    }
}
