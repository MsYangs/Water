package com.zhc.water.common.utils;

public class HttpEntity {
    private HttpStatus status;
    private Boolean istrue;
    private String msg;
    private Object data;
    public HttpEntity() {
        super();
    }
    public HttpEntity(HttpStatus status, Boolean istrue, String msg, Object data) {
        this.status=status;
        this.istrue=istrue;
        this.msg=msg;
        this.data=data;
    }
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
        if(this.status != null){
            if (this.status.equals(HttpStatus.OK) || this.status.equals(HttpStatus.CREATED) || this.status.equals(HttpStatus.NO_CONTENT)) {
                this.istrue = true;
            }else{
                this.istrue = false;
            }
            this.msg = this.status.getCnreasonPhrase();
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Boolean getIstrue() {
        return istrue;
    }
    public void setIstrue(Boolean istrue) {
        this.istrue = istrue;
    }
}
